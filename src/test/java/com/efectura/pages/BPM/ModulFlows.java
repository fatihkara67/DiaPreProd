package com.efectura.pages.BPM;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Database;
import com.efectura.utilities.Driver;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Getter
public class ModulFlows extends BasePage {

    TaskList taskList = new TaskList();

    @FindBy(xpath = "//input[@id='formNumber2']")
    private WebElement formNumberInput;

    @FindBy(xpath = "//input[contains(@id,'noktaTrackKodu2')]")
    private WebElement musteriNoInputBox;

    @FindBy(xpath = "//input[@id='noktaTrackKodu']")
    private WebElement menuMusteriNoInputBox;

//    ----------------------Module Budget---------------------------------
    @FindBy(xpath = "//input[@id='formNumber']")
    private WebElement modulBudgetFormNumberInput;

    @FindBy(xpath = "//input[@id='butceDestegi']")
    private WebElement budgetSupportInputBox;

    @FindBy(xpath = "//input[@id='calismaTarihi']")
    private WebElement moduleBudgetDate;

    @FindBy(xpath = "(//span[@class='flatpickr-day today'])[1]")
    private WebElement moduleBudgetTodayDate;

    @FindBy(xpath = "//input[@id='noktaTrackKodu']")
    private WebElement modulBudgetMusteriNoInput;

    @FindBy(xpath = "//button[@id='searchButton']")
    private WebElement modulBudgetGetirBtn;

    @FindBy(xpath = "//input[@id='docDate']")
    private WebElement modulBudgetDocDateInput;

    @FindBy(xpath = "//select[@id='docType']")
    private WebElement modulBudgetDocTypeSelect;

    @FindBy(xpath = "(//span[contains(@class,'flatpickr-day today')])[2]")
    private WebElement modulBudgetDocTodayDate;

    @FindBy(xpath = "//input[@id='fileInput']")
    private WebElement modulBudgetFileInput;

    @FindBy(xpath = "(//button[contains(text(),'Onaya Gönder')])[1]")
    private WebElement modulBudgetFlowSubmitButton;

    @FindBy(xpath = "(//input[contains(@id,'madde2')])[1]")
    private WebElement moduleBudgetStartFormFirstCheckbox;

    @FindBy(xpath = "(//input[contains(@id,'madde5')])[1]")
    private WebElement moduleBudgetStartFormFourthCheckbox;

    @FindBy(xpath = "(//input[contains(@id,'madde1')])[1]")
    private WebElement moduleBudgetStartFormFifthCheckbox;

    @FindBy(xpath = "//input[@id='ciroOrani']")
    private WebElement moduleBudgetDateCiroOraniInput;

    @FindBy(xpath = "//input[@id='musteriAdi']")
    private WebElement customerNameInput;

    @FindBy(xpath = "//input[@id='bankaAdi']")
    private WebElement bankNameInput;

    @FindBy(xpath = "//input[@id='bankaSube']")
    private WebElement bankSubeInput;

    @FindBy(xpath = "//input[@id='ibanNo']")
    private WebElement ibanNoInput;

    @FindBy(xpath = "//input[@id='invoiceAmount']")
    private WebElement invoiceAmount;

    @FindBy(xpath = "//input[@id='invoiceNo']")
    private WebElement invoiceNo;

    @FindBy(xpath = "//td[contains(text(),'Mey Faturası')]")
    private WebElement meyInvoiceUploadInfo;

    @FindBy(xpath = "(//span[contains(@class,'flatpickr-day today')])[1]")
    private WebElement moduleBudgetInvoiceTodayDate;

    @FindBy(xpath = "//div[contains(@class, 'notyf__wrapper')]/div[2]")
    private WebElement moduleBudgetInvoiceInfoMessage;



//    ----------------------------------------------------

    @FindBy(xpath = "//button[@id='searchButton2']")
    private WebElement getirBtn;

    @FindBy(xpath = "//span[@id='select2-vendorList-container']")
    private WebElement vendorSelect;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement vendorInput;

    @FindBy(xpath = "//li[contains(.,'Efectura Vendor')]")
    private WebElement efecturaVendorOption;

    @FindBy(xpath = "(//input[contains(@id,'madde2')])[2]")
    private WebElement startFormFirstCheckbox;

    @FindBy(xpath = "(//input[contains(@id,'madde5')])[2]")
    private WebElement startFormFourthCheckbox;

    @FindBy(xpath = "(//input[contains(@id,'madde1')])[2]")
    private WebElement startFormFifthCheckbox;

    @FindBy(xpath = "//input[@id='ciroOrani2']")
    private WebElement ciroOraniInput;

    @FindBy(xpath = "//select[@id='docType2']")
    private WebElement docTypeSelect;

    @FindBy(xpath = "//input[@id='docDate2']")
    private WebElement docDateInput;

    @FindBy(xpath = "//input[@id='fileInput2']")
    private WebElement fileInput;

    @FindBy(xpath = "//input[@id='butceDestegi']")
    private WebElement initialBudgetInput;

    @FindBy(xpath = "//select[@id='docType']")
    private WebElement vendorDocTypeSelect;

    @FindBy(xpath = "//input[@id='docDate']")
    private WebElement vendorDocDateInput;

    @FindBy(xpath = "//input[@id='fileInput']")
    private WebElement vendorFileInput;

    @FindBy(xpath = "//span[contains(@class,'flatpickr-day today')]")
    private WebElement vendorTodayDate;

    @FindBy(xpath = "(//span[@class='flatpickr-day today'])[3]")
    private WebElement todayDate;

    @FindBy(xpath = "//ul[@id='select2-docType2-results']/li/span")
    private List<WebElement> docOptions;

    @FindBy(xpath = "(//button[contains(text(),'Onaya Gönder')])[2]")
    private WebElement flowSubmitButton;

    @FindBy(xpath = "/html/body/div[8]/div/div[1]/div[2]")
    private WebElement startFormInfoMessage;

    @FindBy(xpath = "/html/body/div[7]/div/div[1]/div[2]")
    private WebElement flowInfoMessage;

    @FindBy(xpath = "//button[@id='onayla']")
    private WebElement formSubmitButton;

    @FindBy(xpath = "//button[@id='reddet']")
    private WebElement formRejectButton;

    @FindBy(xpath = "//button[@id='revize-et']")
    private WebElement formReviseButton;

    @FindBy(xpath = "//button[@id='confirmBtn']")
    private WebElement confirmButton;

    @FindBy(xpath = "//h4[contains(text(),'Nokta Bilgileri')]")
    private WebElement trackInfoHeader;

    @FindBy(xpath = "//td[contains(text(),'Tütün Alkol Denetim Belgesi')]")
    private WebElement tadbUploadInfo;

    @FindBy(xpath = "//td[contains(text(),'Tasarım Dosyası')]")
    private WebElement tasarimDosyaUploadInfo;

    @FindBy(xpath = "//button[contains(text(),'İlerlet')]")
    private WebElement ilerletButton;

    @FindBy(xpath = "//input[@id='invoiceAmount']")
    private WebElement invoiceAmountInput;

    @FindBy(xpath = "//input[@id='invoiceNo']")
    private WebElement invoiceNoInput;

    @FindBy(xpath = "//td[contains(text(),'Montaj Görseli')]")
    private WebElement montajImageUploadInfo;

    @FindBy(xpath = "//td[contains(text(),'Tedarikçi Faturası')]")
    private WebElement vendorInvoiceUploadInfo;

    @FindBy(xpath = "//button[contains(text(),'Onaya Gönder')]")
    private WebElement onayaGonderButton;

    @FindBy(xpath = "//input[@id='isDistrubutor']")
    private WebElement distributorCheckbox;


    String formNumber = "";
    public String fillModuleFlowForm(String lastCustomerCode) {
        BrowserUtils.adjustScreenSize(80,Driver.getDriver());
        formNumber = BrowserUtils.getValueInInputBox(formNumberInput);
        System.out.println("Form Number: " + formNumber);
        musteriNoInputBox.sendKeys(lastCustomerCode);
        getirBtn.click();
        startFormFirstCheckbox.click();
        startFormFourthCheckbox.click();
        ciroOraniInput.sendKeys("30");
        startFormFifthCheckbox.click();
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(trackInfoHeader,20);
        vendorSelect.click();
        vendorInput.sendKeys("Efectura Vendor");
        efecturaVendorOption.click();
        BrowserUtils.scrollToElement(Driver.getDriver(), docDateInput);

        List<String> docTypes = Arrays.asList("İşletme Modül Talep Formu","Rekabet Bildirim Formu","Tütün Alkol Denetim Belgesi");

        for (int i = 0; i < 3; i++) {
            BrowserUtils.selectDropdownOptionByVisibleText(docTypeSelect,docTypes.get(i));
            docDateInput.click();
            todayDate.click();
            fileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
//            BrowserUtils.wait(2);

            WebElement file = driver.findElement(By.xpath("//td[contains(text(),'" + docTypes.get(i) +"')]"));
            BrowserUtils.waitForVisibility(file,30);

        }
        BrowserUtils.waitForVisibility(tadbUploadInfo,60);
        BrowserUtils.scrollToElement(Driver.getDriver(), flowSubmitButton);
        flowSubmitButton.click();
        BrowserUtils.waitForVisibility(startFormInfoMessage,60);
        Assert.assertEquals("Başarılı", startFormInfoMessage.getText());

        return formNumber;
    }

    public boolean verifyBlockedBudget(String budget) {
        String query = "SELECT * FROM DIA_PREPROD.dbo.vw_ModuleFlowTransactionTotals vmftt \n" +
                "WHERE MudurlukAdi = 'BolgeMuduru' AND ButceYili = 'F26'";

        int totalBlockedBudget = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                totalBlockedBudget = rs.getInt("ToplamBlokeButce");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Akış Sonrası Bloke Bütçe: " + totalBlockedBudget);
//        return totalBlockedBudget == firstBlockedBudget + Integer.parseInt(budget);
        Assert.assertEquals(firstBlockedBudget + Integer.parseInt(budget),totalBlockedBudget);
        return true;
    }

    int firstBlockedBudget;
    public void getBlockedBudget() {
        String query = "SELECT * FROM DIA_PREPROD.dbo.vw_ModuleFlowTransactionTotals vmftt \n" +
                "WHERE MudurlukAdi = 'BolgeMuduru' AND ButceYili = 'F26'";

        int totalBlockedBudget = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                totalBlockedBudget = rs.getInt("ToplamBlokeButce");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        firstBlockedBudget = totalBlockedBudget;
        System.out.println("Akış Öncesi Bloke:  " + firstBlockedBudget);
    }

    public void goInTaskAndSubmit() {
        BrowserUtils.wait(1);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskList");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),50);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(5);
        taskList.getFirstColumn().click();
        BrowserUtils.wait(1);
//        BrowserUtils.switchToTab("DIA: ConfirmationForm");
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: ConfirmationForm");
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());
        BrowserUtils.scrollToElement(Driver.getDriver(), formSubmitButton);
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        BrowserUtils.wait(2);
        formSubmitButton.click();
        BrowserUtils.waitForVisibility(flowInfoMessage,60);
        Assert.assertEquals("Başarılı", flowInfoMessage.getText());
    }

    String vendorInitialBudget = "";
    public void fillVendorInitialForm(String budget) {
        BrowserUtils.wait(2);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskListVendor");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),60);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(4);
        taskList.getFirstColumn().click();
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: SalesFlowForm");
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());

        initialBudgetInput.sendKeys(budget);

        List<String> docTypes = Arrays.asList("Bütçe Detay Hesaplamaları","Tasarım Dosyası");

        for (String docType : docTypes) {
            BrowserUtils.selectDropdownOptionByVisibleText(vendorDocTypeSelect, docType);
            vendorDocDateInput.click();
            vendorTodayDate.click();
            vendorFileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
//            BrowserUtils.wait(2);

            WebElement file = driver.findElement(By.xpath("//td[contains(text(),'" + docType +"')]"));
            BrowserUtils.waitForVisibility(file,30);

        }

        BrowserUtils.waitForVisibility(tasarimDosyaUploadInfo,30);
        ilerletButton.click();
        BrowserUtils.waitForVisibility(flowInfoMessage,60);
        Assert.assertEquals("Başarılı", flowInfoMessage.getText());
        vendorInitialBudget = budget;
        System.out.println("Vendor Ininital Budget = " + vendorInitialBudget);
    }

    String invoiceAmountInForm;
    public void fillVendorInvoiceForm(String invoiceAmount) {
        BrowserUtils.wait(2);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskListVendor");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),60);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(7);
        taskList.getFirstColumn().click();
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: SalesFlowForm");
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());

        List<String> docTypes = Arrays.asList("Tedarikçi Faturası","Montaj Görseli");

        BrowserUtils.selectDropdownOptionByVisibleText(vendorDocTypeSelect, "Tedarikçi Faturası");
        invoiceAmountInput.sendKeys(invoiceAmount);
        invoiceNoInput.sendKeys("555");
        vendorDocDateInput.click();
        vendorTodayDate.click();
        vendorFileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
        BrowserUtils.wait(2);
        BrowserUtils.waitForVisibility(vendorInvoiceUploadInfo,60);

        BrowserUtils.selectDropdownOptionByVisibleText(vendorDocTypeSelect, "Montaj Görseli");
        vendorDocDateInput.click();
        vendorTodayDate.click();
        vendorFileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
        BrowserUtils.wait(2);

        BrowserUtils.waitForVisibility(montajImageUploadInfo,60);
        onayaGonderButton.click();

        BrowserUtils.waitForVisibility(flowInfoMessage,60);
        Assert.assertEquals("Başarılı", flowInfoMessage.getText());
        invoiceAmountInForm = invoiceAmount;
        System.out.println("Vendor Invoice Amount = " + invoiceAmountInForm);
    }

    int actualBudgetBeforeFlow;
    public void getActualBudget() {
        String query = "SELECT * FROM DIA_PREPROD.dbo.vw_ModuleFlowTransactionTotals vmftt WHERE MudurlukAdi = 'BolgeMuduru' AND ButceYili = 'F26'";

        int totalActualBudget = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                totalActualBudget = rs.getInt("ToplamGerceklesenButce");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actualBudgetBeforeFlow = totalActualBudget;
        System.out.println("Akış Öncesi Gerçekleşen:  " + actualBudgetBeforeFlow);
    }

    public boolean verifyActualBudget(String expectedActualBudget) {
        String query = "SELECT * FROM DIA_PREPROD.dbo.vw_ModuleFlowTransactionTotals vmftt WHERE MudurlukAdi = 'BolgeMuduru' AND ButceYili = 'F26'";

        int totalActualBudget = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                totalActualBudget = rs.getInt("ToplamGerceklesenButce");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Akış Sonrası Gerçekleşen Bütçe: " + totalActualBudget);
        Assert.assertEquals(actualBudgetBeforeFlow + Integer.parseInt(expectedActualBudget),totalActualBudget);
//        return totalActualBudget == actualBudgetBeforeFlow + Integer.parseInt(expectedActualBudget);
        return true;
    }

    public void goInTask(String tabTitleName) {


        BrowserUtils.wait(1);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskList");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),50);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(5);
        taskList.getFirstColumn().click();

        BrowserUtils.switchToTabByTitleAndCloseOld(tabTitleName);
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());



//        BrowserUtils.wait(1);
//        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskList");
//        BrowserUtils.wait(3);
//        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),60);
//        taskList.getSearchAllFilterInput().sendKeys(formNumber);
//        BrowserUtils.wait(5);
//        taskList.getFirstColumn().click();
//
//        BrowserUtils.switchToTabByTitleAndCloseOld(tabTitleName);
//        BrowserUtils.wait(3);
//        System.out.println("Title: " + Driver.getDriver().getTitle());
    }

    public void submitTask() {
        BrowserUtils.scrollToElement(Driver.getDriver(), formSubmitButton);
        BrowserUtils.wait(5);
        BrowserUtils.waitForClickability(formSubmitButton,30);
        formSubmitButton.click();
        BrowserUtils.waitForVisibility(flowInfoMessage,20);
        Assert.assertEquals("Başarılı", flowInfoMessage.getText());
    }

    public void rejectTask() {
        BrowserUtils.scrollToElement(Driver.getDriver(), formRejectButton);
        BrowserUtils.wait(2);
        formRejectButton.click();
        confirmButton.click();
        BrowserUtils.waitForVisibility(flowInfoMessage,60);
        Assert.assertEquals("Başarılı", flowInfoMessage.getText());
    }

    public void reviseTask() {
        BrowserUtils.scrollToElement(Driver.getDriver(), formReviseButton);
        BrowserUtils.wait(2);
        formReviseButton.click();
        confirmButton.click();
        BrowserUtils.waitForVisibility(flowInfoMessage,60);
        Assert.assertEquals("Başarılı", flowInfoMessage.getText());
    }

    public void fillModuleBudgetForm(String lastCustomerCode, String budgetSupport) {
//        BrowserUtils.adjustScreenSize(50,Driver.getDriver());
        formNumber = BrowserUtils.getValueInInputBox(modulBudgetFormNumberInput);
        System.out.println("Form Number: " + formNumber);
        modulBudgetMusteriNoInput.sendKeys(lastCustomerCode);
        modulBudgetGetirBtn.click();

        moduleBudgetDate.click();
        moduleBudgetTodayDate.click();
        budgetSupportInputBox.sendKeys(budgetSupport);

        moduleBudgetStartFormFirstCheckbox.click();
        moduleBudgetStartFormFourthCheckbox.click();
        moduleBudgetDateCiroOraniInput.sendKeys("30");
        moduleBudgetStartFormFifthCheckbox.click();
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(trackInfoHeader,20);
        BrowserUtils.scrollToElement(Driver.getDriver(), docDateInput);

        List<String> docTypes = Arrays.asList(
                "İşletme Modül Talep Formu","Rekabet Bildirim Formu","Bütçe Desteği Kanıt Dokümanı", "Tütün Alkol Denetim Belgesi"
        );

        for (int i = 0; i < 4; i++) {
            BrowserUtils.selectDropdownOptionByVisibleText(modulBudgetDocTypeSelect,docTypes.get(i));
            modulBudgetDocDateInput.click();
            BrowserUtils.wait(1);
            modulBudgetDocTodayDate.click();
            modulBudgetFileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
//            BrowserUtils.wait(1);
            WebElement file = driver.findElement(By.xpath("//td[contains(text(),'" + docTypes.get(i) +"')]"));
            BrowserUtils.waitForVisibility(file,30);
        }
        BrowserUtils.waitForVisibility(tadbUploadInfo,40);
        BrowserUtils.scrollToElement(Driver.getDriver(), modulBudgetFlowSubmitButton);
        modulBudgetFlowSubmitButton.click();
        BrowserUtils.waitForVisibility(startFormInfoMessage,60);
        Assert.assertEquals("Başarılı", startFormInfoMessage.getText());
    }

    public void fillInvoiceForm(String invoiceAmount) {
        customerNameInput.sendKeys("DamlaPlastic");
        bankNameInput.sendKeys("IsBank");
        bankSubeInput.sendKeys("67670");
        ibanNoInput.sendKeys("TR1213456789");

        List<String> docTypes = Arrays.asList(
                "Vergi Levhası","Ticaret Sicil Gazetesi","İmza sirküsü", "Tedarikçi Faturası","Mey Faturası"
        );

        for (String docType : docTypes) {
            BrowserUtils.selectDropdownOptionByVisibleText(modulBudgetDocTypeSelect, docType);
            modulBudgetDocDateInput.click();
            BrowserUtils.wait(1);
            moduleBudgetInvoiceTodayDate.click();

            if (docType.contains("Fatura")) {
                invoiceAmountInput.sendKeys(Keys.CONTROL + "a");
                invoiceAmountInput.sendKeys(invoiceAmount);
                invoiceNoInput.sendKeys(Keys.CONTROL + "a");
                invoiceNoInput.sendKeys("6767");
            }

            modulBudgetFileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
            BrowserUtils.wait(2);

        }

        BrowserUtils.waitForVisibility(meyInvoiceUploadInfo,20);
        BrowserUtils.scrollToElement(Driver.getDriver(), modulBudgetFlowSubmitButton);
        modulBudgetFlowSubmitButton.click();
        BrowserUtils.waitForVisibility(moduleBudgetInvoiceInfoMessage,60);
        Assert.assertEquals("Başarılı", moduleBudgetInvoiceInfoMessage.getText());

    }

    int firstStandBlockedBudget;
    public int getBlockedBudgetForStand() {
        String query = "with cte as (\n" +
                "SELECT \n" +
                "T1.TrackKodu, \n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is null THEN T1.ToplamFiyat ELSE 0 end),0) as BLOKE,\n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is not null THEN T1.ToplamFiyat ELSE 0 end),0) as GERCEKLESEN,\n" +
                "/*T1.[Type],*/ T1.[Markaisi],\n" +
                "T1.LimitKontrol\n" +
                "FROM StandAkisTransactions AS T1\n" +
                "JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM StandAkisTransactions \n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T2 \n" +
                "ON T1.FormNumber = T2.FormNumber AND T1.Version = T2.MaxVersion AND T1.TrackKodu = T2.TrackKodu\n" +
                "LEFT JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM StandAkisTransactions \n" +
                "  WHERE [Status] = 'DONE'\n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T3\n" +
                "ON T1.FormNumber = T3.FormNumber AND T1.Version = T3.MaxVersion AND T1.TrackKodu = T3.TrackKodu\n" +
                "WHERE T1.[Status] != 'REJECTED'\n" +
                "AND YEAR(T1.CreatedOn) = 2026\n" +
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
                "WHERE TrackKodu = '999999999' AND Markaisi = 0";

        firstStandBlockedBudget = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                firstStandBlockedBudget = rs.getInt("Bloke");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Stand Akış Öncesi Bloke:  " + firstStandBlockedBudget);
        return firstStandBlockedBudget;
    }

    int standActualBudgetBeforeFlow;
    public int getActualBudgetForStand() {
        String query = "with cte as (\n" +
                "SELECT \n" +
                "T1.TrackKodu, \n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is null THEN T1.ToplamFiyat ELSE 0 end),0) as BLOKE,\n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is not null THEN T1.ToplamFiyat ELSE 0 end),0) as GERCEKLESEN,\n" +
                "/*T1.[Type],*/ T1.[Markaisi],\n" +
                "T1.LimitKontrol\n" +
                "FROM StandAkisTransactions AS T1\n" +
                "JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM StandAkisTransactions \n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T2 \n" +
                "ON T1.FormNumber = T2.FormNumber AND T1.Version = T2.MaxVersion AND T1.TrackKodu = T2.TrackKodu\n" +
                "LEFT JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM StandAkisTransactions \n" +
                "  WHERE [Status] = 'DONE'\n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T3\n" +
                "ON T1.FormNumber = T3.FormNumber AND T1.Version = T3.MaxVersion AND T1.TrackKodu = T3.TrackKodu\n" +
                "WHERE T1.[Status] != 'REJECTED'\n" +
                "AND YEAR(T1.CreatedOn) = 2026\n" +
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
                "WHERE TrackKodu = '999999999' AND Markaisi = 0";

        int standActualBudgetBeforeFlow = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // İlk kolondaki tarih bilgisini al
                standActualBudgetBeforeFlow = rs.getInt("GERCEKLESEN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Stand Akış Öncesi Gerçekleşen:  " + standActualBudgetBeforeFlow);
        return standActualBudgetBeforeFlow;
    }

    public String fillStandFlowForm(String customerCode, int markaisi) {

        BrowserUtils.adjustScreenSize(80,Driver.getDriver());
        formNumber = BrowserUtils.getValueInInputBox(driver.findElement(By.xpath("//input[@id='formNo']")));
        System.out.println("Form Number: " + formNumber);
        menuMusteriNoInputBox.sendKeys(customerCode);
        driver.findElement(By.xpath("//button[contains(@id,'searchButton')]")).click();

        BrowserUtils.wait(3);

        WebElement brandSelect = driver.findElement(By.xpath("//select[@id='isBrandJob']"));
        WebElement kalemSelect = driver.findElement(By.xpath("//select[@id='kalem-options']"));

        BrowserUtils.selectDropdownOptionByVisibleText(brandSelect,"Hayır");
        BrowserUtils.selectDropdownOptionByVisibleText(kalemSelect,"JW_Ağac_Stand_tr");
        driver.findElement(By.xpath("//button[@id='add-stand-process']")).click();
        BrowserUtils.wait(6);
        BrowserUtils.adjustScreenSize(75,driver);
        driver.findElement(By.xpath("//button[contains(text(),'Onaya Gönder')]")).click();

        return formNumber;

    }

    int totalPrice;
    public void addKalemAndGetTotalPrice() {
        WebElement kalemSelect = driver.findElement(By.xpath("//select[@id='kalem-options']"));
        BrowserUtils.selectDropdownOptionByVisibleText(kalemSelect,"JW_Ağac_Stand_tr");
        driver.findElement(By.xpath("//button[@id='add-stand-process']")).click();

        String price = driver.findElement(By.xpath("//span[@id='total-price']")).getText().
                split(" : ₺")[1].split(",")[0].replace(".","");

        totalPrice = Integer.parseInt(price);
        System.out.println("Toplam Kalem Tutarı: " + totalPrice);

        BrowserUtils.scrollToElement(Driver.getDriver(), formSubmitButton);
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        BrowserUtils.wait(2);
        formSubmitButton.click();
        BrowserUtils.waitForVisibility(flowInfoMessage,60);
        Assert.assertEquals("Başarılı", flowInfoMessage.getText());

    }

    int newTotalPrice;
    public void fillVendor1Form() {
        BrowserUtils.wait(2);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskListVendor");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),60);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(4);
        taskList.getFirstColumn().click();
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: StandFlowForm");
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());

        driver.findElement(By.xpath("//input[@id='deliveryDateInput']")).click();
        driver.findElement(By.xpath("/html/body/div[10]/div[2]/div/div[2]/div/span[@class='flatpickr-day today']")).click();
        BrowserUtils.wait(5);

        newTotalPrice = (totalPrice / 2 - 50);
        List<WebElement> kalemPriceInputs = driver.findElements(By.xpath("//input[@placeholder='Teklif Giriniz']"));
        for (WebElement input : kalemPriceInputs) {
            input.sendKeys(Keys.CONTROL + "A");
            input.sendKeys(newTotalPrice + "");
        }

        BrowserUtils.adjustScreenSize(60,driver);
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[contains(.,'Onaya Gönder')]")).click();
        BrowserUtils.waitForVisibility(flowInfoMessage,20);
        Assert.assertEquals("Form başarıyla gönderildi.", flowInfoMessage.getText());

    }

    public void verifyNewPrice() {
        WebElement newTotalPriceActual = driver.findElement
                (By.xpath("//span[contains(.,'Teklif Toplamı:')]/following-sibling::span"));

        int actualNewTotal = Integer.parseInt
                (newTotalPriceActual.getText().substring(1).split(",")[0].replace(".",""));

        Assert.assertEquals("Yeni total tedarikcinin girdiginden farklı",newTotalPrice * 2,actualNewTotal);

    }

    public void fillVendor2Form() {
        BrowserUtils.adjustScreenSize(60,driver);
        BrowserUtils.wait(3);
        BrowserUtils.selectDropdownOptionByVisibleText(vendorDocTypeSelect, "Teslimat Kanıt Belgeleri");
        vendorDocDateInput.click();
        vendorTodayDate.click();
        vendorFileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
//            BrowserUtils.wait(2);

        WebElement file = driver.findElement(By.xpath("//td[contains(text(),'" + "Teslimat Kanıt Belgeleri" +"')]"));
        BrowserUtils.waitForVisibility(file,30);

        BrowserUtils.adjustScreenSize(60,driver);
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[contains(.,'Onaya Gönder')]")).click();
        BrowserUtils.waitForVisibility(flowInfoMessage,20);
        Assert.assertEquals("Form başarıyla gönderildi.", flowInfoMessage.getText());

    }

    public boolean verifyStandBlockedBudget(String budget, int blockedBudgetBeforeFlow) {

        String query = "with cte as (\n" +
                "SELECT \n" +
                "T1.TrackKodu, \n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is null THEN T1.ToplamFiyat ELSE 0 end),0) as BLOKE,\n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is not null THEN T1.ToplamFiyat ELSE 0 end),0) as GERCEKLESEN,\n" +
                "/*T1.[Type],*/ T1.[Markaisi],\n" +
                "T1.LimitKontrol\n" +
                "FROM StandAkisTransactions AS T1\n" +
                "JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM StandAkisTransactions \n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T2 \n" +
                "ON T1.FormNumber = T2.FormNumber AND T1.Version = T2.MaxVersion AND T1.TrackKodu = T2.TrackKodu\n" +
                "LEFT JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM StandAkisTransactions \n" +
                "  WHERE [Status] = 'DONE'\n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T3\n" +
                "ON T1.FormNumber = T3.FormNumber AND T1.Version = T3.MaxVersion AND T1.TrackKodu = T3.TrackKodu\n" +
                "WHERE T1.[Status] != 'REJECTED'\n" +
                "AND YEAR(T1.CreatedOn) = 2026\n" +
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
                "WHERE TrackKodu = '999999999' AND Markaisi = 0";

        int totalBlockedBudget = 0;
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                totalBlockedBudget = rs.getInt("Bloke");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Akış Sonrası Bloke Bütçe: " + totalBlockedBudget);
//        return totalBlockedBudget == firstBlockedBudget + Integer.parseInt(budget);
        Assert.assertEquals(blockedBudgetBeforeFlow + Integer.parseInt(budget),totalBlockedBudget);
        return true;

    }

    public void fillVendor3Form() {
        driver.findElement(By.xpath("//input[@id='vendorInvoice']")).sendKeys("1000");


        BrowserUtils.selectDropdownOptionByVisibleText(vendorDocTypeSelect, "Tedarikçi Faturası");
        vendorDocDateInput.click();
        vendorTodayDate.click();
        vendorFileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
//            BrowserUtils.wait(2);

        WebElement file = driver.findElement(By.xpath("//td[contains(text(),'" + "Tedarikçi Faturası" +"')]"));
        BrowserUtils.waitForVisibility(file,30);

        BrowserUtils.adjustScreenSize(60,driver);
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[contains(.,'Onaya Gönder')]")).click();
        BrowserUtils.waitForVisibility(flowInfoMessage,20);
        Assert.assertEquals("Form başarıyla gönderildi.", flowInfoMessage.getText());

    }

    public boolean verifyStandActualBudget(String budget,int actualBeforeFlow) {

        String query = "with cte as (\n" +
                "SELECT \n" +
                "T1.TrackKodu, \n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is null THEN T1.ToplamFiyat ELSE 0 end),0) as BLOKE,\n" +
                "COALESCE(SUM(CASE WHEN T3.TrackKodu is not null THEN T1.ToplamFiyat ELSE 0 end),0) as GERCEKLESEN,\n" +
                "/*T1.[Type],*/ T1.[Markaisi],\n" +
                "T1.LimitKontrol\n" +
                "FROM StandAkisTransactions AS T1\n" +
                "JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM StandAkisTransactions \n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T2 \n" +
                "ON T1.FormNumber = T2.FormNumber AND T1.Version = T2.MaxVersion AND T1.TrackKodu = T2.TrackKodu\n" +
                "LEFT JOIN (\n" +
                "    SELECT TrackKodu,FormNumber, MAX(Version) AS MaxVersion \n" +
                "    FROM StandAkisTransactions \n" +
                "  WHERE [Status] = 'DONE'\n" +
                "    GROUP BY TrackKodu,FormNumber\n" +
                ") AS T3\n" +
                "ON T1.FormNumber = T3.FormNumber AND T1.Version = T3.MaxVersion AND T1.TrackKodu = T3.TrackKodu\n" +
                "WHERE T1.[Status] != 'REJECTED'\n" +
                "AND YEAR(T1.CreatedOn) = 2026\n" +
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
                "WHERE TrackKodu = '999999999' AND Markaisi = 0";

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
        System.out.println("standActualBudgetBeforeFlow: " + actualBeforeFlow);
        System.out.println("Akış Sonrası Gerçekleşen Bütçe: " + totalActualBudget);
        Assert.assertEquals(actualBeforeFlow + Integer.parseInt(budget),totalActualBudget);
//        return totalActualBudget == actualBudgetBeforeFlow + Integer.parseInt(expectedActualBudget);
        return true;

    }
}
