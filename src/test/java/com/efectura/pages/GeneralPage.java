package com.efectura.pages;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Database;
import com.efectura.utilities.Driver;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.efectura.utilities.BrowserUtils.isButtonActive;

@Getter
public class GeneralPage extends BasePage {

    @FindBy(xpath = "//div[@class='notyf__message']")
    private WebElement generalWarningElement;

    @FindBy(xpath = "//select[@id='chooseFamilies']")
    private WebElement familySelectInCreateModal;

    @FindBy(xpath = "//tbody/tr/td[@class='dataTables_empty']")
    private WebElement emptyDataTableInfo;

    @FindBy(xpath = "//a[contains(@class,'t-edit')]")
    private WebElement editBtnInTable;

    @FindBy(xpath = "//a[contains(@class,'danger-btn')]")
    private WebElement deleteBtnInTable;

    @FindBy(xpath = "//select[contains(@id,'-ItemStatuses')]")
    private WebElement tableItemStatusSelect;

    @FindBy(xpath = "//select[contains(@id,'-Family')]")
    private WebElement tableFamilySelect;

    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement changeSaveCommentTextArea;

    @FindBy(xpath = "//*[@id='impersonate']")
    public WebElement impersonateHoverBtn;

    @FindBy(xpath = "//a[@id='impersonate-fletum']")
    public WebElement impersonateButton;

    @FindBy(xpath = "//button[contains(@id,'-reset-basic')]")
    private WebElement basicResetButton;

    @FindBy(xpath = "//div[@class='notyf__message']")
    private WebElement infoMessage;

    @FindBy(xpath = "//div[contains(@id,'_wrapper')]/div/div/div/label/div/select")
    private WebElement tableShowEntrySelect;

    @FindBy(xpath = "//div[@class='pagination-container']/div[contains(@id,'_info')]")
    private WebElement tableInfo;

    @FindBy(xpath = "/html/body/div[7]/div/div[1]/div[2]")
    private WebElement flowInfoMessage;

    @FindBy(id = "Username")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password-field']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'button-filter-container')]")
    private WebElement advancedFilterContainer;

    @FindBy(xpath = "//ul[@id='sortableAvailableTabs']/li/div/span")
    private List<WebElement> tabAvailableColumns;

    @FindBy(xpath = "//ul[contains(@class,'nav-tabs')]/li")
    private List<WebElement> editFamilyTabs;

    @FindBy(xpath = "//div[contains(@class,'panel-heading')]/a")
    private List<WebElement> editFamilyAttributeGroups;


    // you can use selectFilter as IsAssociated, Family, ItemStatuses in feature file
    public void selectOptionInSelectFilter(String selectOption, String selectFilter) {

        WebElement selectElement = driver.findElement(By.xpath("//select[contains(@id,'-" + selectFilter + "')]"));
        BrowserUtils.selectDropdownOptionByVisibleText(selectElement,selectOption);
        BrowserUtils.wait(3);
    }

    public void useTextFilter(String value, String columnName) {
        //thead/tr[1]/th[normalize-space()='Address']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='Address']/preceding-sibling::th)+1]//input
        String locate = "//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/preceding-sibling::th)+1]//input";

        WebElement filterInput = Driver.getDriver().findElement(By.xpath(locate));
        filterInput.sendKeys(value + Keys.ENTER);

    }

    public void clickHeaderForAscSort(String headerName) {
        String locate = "//thead/tr[1]/th[normalize-space()='" + headerName + "']";
        WebElement header = Driver.getDriver().findElement(By.xpath(locate));
        header.click();
        BrowserUtils.waitForAttribute(header,"aria-sort");
        while (header.getAttribute("aria-sort").equals("descending")) {
            header.click();
            BrowserUtils.wait(4);
        }
    }

    public void clickHeaderForDescSort(String headerName) {
        String locate = "//thead/tr[1]/th[normalize-space()='" + headerName + "']";
        WebElement header = Driver.getDriver().findElement(By.xpath(locate));
        header.click();
        BrowserUtils.waitForAttribute(header,"aria-sort");
        while (header.getAttribute("aria-sort").equals("ascending")) {
            header.click();
            BrowserUtils.wait(3);
        }
    }


    public String getItemStatus(String itemCode) {
        String query = "SELECT Text FROM TEST_MDM.dbo.ItemStatusesTranslations is2 \n" +
                "WHERE LanguageCode = 'en-US' \n" +
                "AND ItemStatusesId = (SELECT ItemStatusesId FROM TEST_MDM.dbo.Items WHERE SKU = '" + itemCode + "')";

        String itemStatus = "";

        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                itemStatus = rs.getString("Text");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("item status of the item with code " + itemCode + " is " + itemStatus);
        return itemStatus;

    }

    public static boolean isRowCountCorrectAccordingToTableLength(WebElement tableInfo, String length) {
        BrowserUtils.waitForVisibility(tableInfo,30);
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//div[contains(@id,'_wrapper')]/div/div/table/tbody/tr/td[2]"));
        String maxDataCountAsString = tableInfo.getText().split(" ")[5].replace(",","");
        System.out.println("maxDataCountAsString " + maxDataCountAsString);
        System.out.println("LengthAsInt " + Integer.parseInt(length.split(" ")[0]));
        int maxDataCount = Integer.parseInt(maxDataCountAsString);
        int lengthAsInt = Integer.parseInt(length.split(" ")[0]);
        System.out.println("Row sayısı " + rows.size());
        System.out.println(Math.min(maxDataCount, lengthAsInt));
        return rows.size() == Math.min(maxDataCount, lengthAsInt);
    }

    public void verifyTableContainsRightRowsAccordingToLength(String length) {
        Assert.assertTrue(isRowCountCorrectAccordingToTableLength(tableInfo,length));
    }

    /*
    You can write button names like these in future file:
    firstpage
    previous
    next
    lastpage
     */
    public void verifyButtonStatus(String btnName, String btnStatus) {
        BrowserUtils.wait(4);
        String locate = "//div[@class='pagination-container']//*[contains(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" +
                btnName + "')]";
        System.out.println(locate);
        WebElement btn = driver.findElement(By.xpath(locate));
//        WebElement button = driver.findElement(By.id(btnName));
        if(btnStatus.equalsIgnoreCase("Active")) {
            Assert.assertTrue(isButtonActive(btn));
        } else if (btnStatus.equalsIgnoreCase("Passive")) {
            Assert.assertFalse(isButtonActive(btn));
        }
    }

    public void clickPaginationButton(String btnName) {
        BrowserUtils.wait(10);
        String locate = "//div[@class='pagination-container']//*[contains(translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" +
                btnName + "')]";
        WebElement btn = driver.findElement(By.xpath(locate));
//        WebElement btn2 = driver.findElement(By.id(btnName));
//        WebElement button = driver.findElement
//                (By.xpath("//div[@class='pagination-container']//button[@id='" + btnName + "']"));
        btn.click();
    }

}
