package com.efectura.pages.BPM;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Database;
import com.efectura.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Getter
public class Offstand extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElement importPopupApplyButton;

    @FindBy(xpath = "//span[@id='select2-ItemType-container']")
    private WebElement selectImportTypeElement;

    @FindBy(xpath = "//span/span/span[1]/input")
    private WebElement selectImportTypeInputBox;

    @FindBy(xpath = "//ul/li[contains(@id,'select2')]")
    private List<WebElement> filteredImportTypeOptions;

    @FindBy(id = "addcsvfile")
    private WebElement addCsvInputElement;

    @FindBy(xpath = "//button[@id='cancelUploadFile']/following-sibling::button[1]")
    private WebElement saveChangesButtonInAreYouSureModal;

    @FindBy(xpath = "//span[@id='Import']/span[2]")
    private WebElement importButton;

    @FindBy(xpath = "//a[@id='_attributes']")
    private WebElement attributesTab;

    @FindBy(xpath = "//ul[@class='nav nav-tabs current_nav_tabs']//li//a")
    private List<WebElement> editItemTabs;

    public static String getExcelPath(String fileName) {
        String projectDir = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testData/" + fileName + ".xlsx";
        return Paths.get(projectDir, relativePath).toString();
    }


    public void selectImportType(String importType) {
        BrowserUtils.wait(3);
        selectImportTypeElement.click();
        selectImportTypeInputBox.sendKeys(importType);
        BrowserUtils.wait(1);
        for (WebElement option : filteredImportTypeOptions) {
            if (option.getText().equals(importType)) {
                option.click();
                break;
            }
        }
    }

    public void uploadExcelFile(String fileName) {
        BrowserUtils.wait(2);
        addCsvInputElement.sendKeys(getExcelPath(fileName));
        BrowserUtils.wait(2);
        saveChangesButtonInAreYouSureModal.click();
    }

    int actualStandBudgetBeforeImportOrFlow;
    public void getStandActualBudgetForCustomer(String customerCode, int markaisi) {
        String query = "with cte as (\n" +
                "SELECT \n" +
                "T1.TrackKodu, \n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is null THEN T1.ToplamFiyat ELSE 0 end),0) as BLOKE,\n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is not null THEN T1.ToplamFiyat ELSE 0 end),0) as GERCEKLESEN,\n" +
                "/*T1.[Type],*/ T1.[Markaisi],\n" +
                "T1.LimitKontrol\n" +
                "FROM DIA_PREPROD.dbo.StandAkisTransactions AS T1\n" +
                "JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM DIA_PREPROD.dbo.StandAkisTransactions \n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T2 \n" +
                "ON T1.FormNumber = T2.FormNumber AND T1.Version = T2.MaxVersion AND T1.TrackKodu = T2.TrackKodu\n" +
                "LEFT JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM DIA_PREPROD.dbo.StandAkisTransactions \n" +
                "  WHERE [Status] = 'DONE'\n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T3\n" +
                "ON T1.FormNumber = T3.FormNumber AND T1.Version = T3.MaxVersion AND T1.TrackKodu = T3.TrackKodu\n" +
                "WHERE T1.[Status] != 'REJECTED'\n" +
                "AND YEAR(T1.CreatedOn) = 2025\n" +
                "group by T1.TrackKodu,/*T1.[Type],*/ T1.[Markaisi], T1.LimitKontrol\n" +
                ")\n" +
                "select \n" +
                "TrackKodu, LimitKontrol, /*[Type],*/ Markaisi, Bloke, GERCEKLESEN,\n" +
                "CASE \n" +
                "WHEN LimitKontrol = 0 THEN 0\n" +
                "WHEN Markaisi = 0 THEN 60000 - BLOKE - GERCEKLESEN\n" +
                "WHEN Markaisi = 1 THEN 120000 - BLOKE - GERCEKLESEN\n" +
                "END AS Kalan,\n" +
                "CASE \n" +
                "WHEN LimitKontrol = 0 THEN 0\n" +
                "WHEN Markaisi = 0 THEN 60000\n" +
                "WHEN Markaisi = 1 THEN 120000\n" +
                "END AS Limit\n" +
                "from cte\n" +
                "WHERE TrackKodu = '" + customerCode + "' AND Markaisi = " + markaisi;

        int totalActualBudget = 0;
        String trackKod = "";
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                totalActualBudget = rs.getInt("GERCEKLESEN");
                trackKod = rs.getString("TrackKodu");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actualStandBudgetBeforeImportOrFlow = totalActualBudget;
        System.out.println("Import ya da Akış Öncesi Gerçekleşen: " + actualStandBudgetBeforeImportOrFlow);
        System.out.println(totalActualBudget);
        System.out.println("Track Kodu : " + trackKod);
    }

    public boolean verifyStandActualBudget(String customerCode, int markaisi, String expectedActualBudget) {
        String query = "with cte as (\n" +
                "SELECT \n" +
                "T1.TrackKodu, \n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is null THEN T1.ToplamFiyat ELSE 0 end),0) as BLOKE,\n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is not null THEN T1.ToplamFiyat ELSE 0 end),0) as GERCEKLESEN,\n" +
                "/*T1.[Type],*/ T1.[Markaisi],\n" +
                "T1.LimitKontrol\n" +
                "FROM DIA_PREPROD.dbo.StandAkisTransactions AS T1\n" +
                "JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM DIA_PREPROD.dbo.StandAkisTransactions \n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T2 \n" +
                "ON T1.FormNumber = T2.FormNumber AND T1.Version = T2.MaxVersion AND T1.TrackKodu = T2.TrackKodu\n" +
                "LEFT JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM DIA_PREPROD.dbo.StandAkisTransactions \n" +
                "  WHERE [Status] = 'DONE'\n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T3\n" +
                "ON T1.FormNumber = T3.FormNumber AND T1.Version = T3.MaxVersion AND T1.TrackKodu = T3.TrackKodu\n" +
                "WHERE T1.[Status] != 'REJECTED'\n" +
                "AND YEAR(T1.CreatedOn) = 2025\n" +
                "group by T1.TrackKodu,/*T1.[Type],*/ T1.[Markaisi], T1.LimitKontrol\n" +
                ")\n" +
                "select \n" +
                "TrackKodu, LimitKontrol, /*[Type],*/ Markaisi, Bloke, GERCEKLESEN,\n" +
                "CASE \n" +
                "WHEN LimitKontrol = 0 THEN 0\n" +
                "WHEN Markaisi = 0 THEN 60000 - BLOKE - GERCEKLESEN\n" +
                "WHEN Markaisi = 1 THEN 120000 - BLOKE - GERCEKLESEN\n" +
                "END AS Kalan,\n" +
                "CASE \n" +
                "WHEN LimitKontrol = 0 THEN 0\n" +
                "WHEN Markaisi = 0 THEN 60000\n" +
                "WHEN Markaisi = 1 THEN 120000\n" +
                "END AS Limit\n" +
                "from cte\n" +
                "WHERE TrackKodu = '" + customerCode + "' AND Markaisi = " + markaisi;

        int totalActualBudget = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                totalActualBudget = rs.getInt("GERCEKLESEN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Akış Ya da Import Sonrası Gerçekleşen Bütçe: " + totalActualBudget);
        return totalActualBudget == actualStandBudgetBeforeImportOrFlow + Integer.parseInt(expectedActualBudget);
    }

    public void goInDigitalAssetItem() {
        String query = "Select TOP 1 Id From DIA_PREPROD.dbo.Items i WHERE FamilyId = 255 ORDER BY CreatedOn DESC";

        int itemId = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                itemId = rs.getInt("Id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Driver.getDriver().navigate().to("https://dia-preprod-ui.efectura.com/Enrich/EditItem/" + itemId);
        BrowserUtils.waitForVisibility(attributesTab,20);
    }

    public void clickEditItemTab(String tabName) {
        BrowserUtils.wait(5);
        for (WebElement editItemTab : editItemTabs) {
            if (editItemTab.getText().contains(tabName)) {
                editItemTab.click();
                BrowserUtils.wait(2);
            }
        }
        BrowserUtils.adjustScreenSize(75,driver);
    }
}
