package com.efectura.pages.MDMPages;

import com.efectura.pages.BasePage;
import com.efectura.pages.GeneralPage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Database;
import com.efectura.utilities.Driver;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.efectura.utilities.BrowserUtils.isButtonActive;


@Getter
public class EditItemPage extends BasePage {

    @FindBy(xpath = "//button[@id='saveChangeButton']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[contains(@id,'floatingSaveButton')]")
    private WebElement saveBtnInEditItemSaveModal;

    @FindBy(xpath = "//*[@id='renderBodyWrap']/div[6]/div[1]")
    protected WebElement accordionButton;

    @FindBy(xpath = "//span[@id='arrowbtn-down']")
    private WebElement scrollRightButton;

    @FindBy(xpath = "//a[contains(@class,'showRuleTabLi')]")
    private WebElement ruleTab;

    @FindBy(xpath = "//span[@id='select2-association-table-IsAssociated-container']")
    private WebElement associatedFilter;

    @FindBy(xpath = "//li[contains(text(),'Yes')]")
    private WebElement associatedFilterYesOption;

    @FindBy(xpath = "//tr/td[1]/a")
    private List<WebElement> idValues;

    @FindBy(xpath = "//div[contains(@class,'accordion-title')]")
    private WebElement accordionTitle;

    @FindBy(xpath = "//table[@id='association-table']/thead/tr[1]/th")
    private List<WebElement> assocTabTableHeaders;

    //table[@id='association-table']/thead/tr[2]/th/div/input   id'ler için

    @FindBy(xpath = "//table[@id='association-table']/thead/tr[2]/th")
    private List<WebElement> assocTabFilters;

    @FindBy(xpath = "//ul[@class='nav nav-tabs current_nav_tabs']//li//a")
    private List<WebElement> editItemTabs;

    @FindBy(xpath = "//*[@id='association-table']/tbody/tr/td/input")
    private List<WebElement> associateCheckBoxes;

    @FindBy(xpath = "//div[@id='saveChangeButton']")
    private WebElement saveChangesBtn;

    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement saveCommentTextarea;

    @FindBy(xpath = "//button[@id='floatingSaveButton']")
    private WebElement saveButtonInSaveChanges;

    // /html/body/div[7]/div/div[1]/div[2]
    //div[@class='notyf__message']
    @FindBy(xpath = "//div[@class='notyf__message']")
    private WebElement infoMessage;

    @FindBy(xpath = "//*[@id='association-table']/tbody/tr/td[4]/div")
    private List<WebElement> isAssociatedValues;

    @FindBy(id = "association-table")
    private WebElement associationTable;

    @FindBy(xpath = "//div[3]/div/div/div[1]/h4[contains(text(),'Column Selection')]")
    private WebElement associationTableColumnsBtn;

    @FindBy(xpath = "//button[@id='cancelPopup']")
    private WebElement cancelBtnInDeletePopup;

    @FindBy(xpath = "//select[@id='itemStatusDropdown']")
    private WebElement editItemStatusSelect;

    @FindBy(xpath = "//*[@id=\"status-input-block\"]/div[1]/div[2]/span/span[1]/span/span[2]/b")
    private WebElement statusExpandArrow;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement statusSelectInput;

    @FindBy(xpath = "//li[contains(@class,'select2-results__option')]")
    private WebElement resultOption;

    @FindBy(xpath = "//select[@id='item-family']")
    private WebElement editItemFamilySelect;

    @FindBy(xpath = "//button[@id='deletItemButton']")
    private WebElement deleteItemButton;

    @FindBy(xpath = "//button[@id='removeItemBtn']")
    private WebElement deleteButtonInDeleteItemModal;

    @FindBy(xpath = "//div[@id='scrollToUp']/div")
    private WebElement scrollUpButton;


    public void clickRuleTab() {
        BrowserUtils.wait(5);
        BrowserUtils.scrollToRightEnd(driver);
        BrowserUtils.wait(1);
        while (!BrowserUtils.isElementDisplayed(ruleTab)) {
            scrollRightButton.click();
        }
        ruleTab.click();
    }

    public static void clickRuleTab2(WebElement ruleTab, WebElement scrollRightButton) {
        while (!BrowserUtils.isElementDisplayed(ruleTab)) {
            scrollRightButton.click();
        }
        ruleTab.click();
    }

    public void goToRuleAssociationTab(String tabName) {
        BrowserUtils.wait(10);
        driver.findElement(By.xpath("//li[@data-order-code='Associations']")).click();
        driver.findElement(By.xpath("//a[@href='#AssociationTab']/text[contains(.,'" + tabName + "')]")).click();
        BrowserUtils.wait(60);
        associatedFilter.click();
        associatedFilterYesOption.click();
        BrowserUtils.wait(9);
    }

    public void closeShowcase() {
        if (!accordionTitle.getAttribute("class").contains("active")) {
            accordionTitle.click();
        }
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

    /*
    You can write button names like these in future file:
    _next, _previous, LastPage, FirstPage
     */
    public void verifyButtonStatus(String tabName, String btnName, String btnStatus) {
        BrowserUtils.wait(4);
        WebElement btn = driver.findElement(By.id(tabName.toLowerCase() + "-permissions-table" + btnName));
        if(btnStatus.equalsIgnoreCase("Active")) {
            Assert.assertTrue(isButtonActive(btn));
        } else if (btnStatus.equalsIgnoreCase("Passive")) {
            Assert.assertFalse(isButtonActive(btn));
        }
    }

    public void clickPermissionPageBtn(String tabName, String btnName) {
        BrowserUtils.wait(6);
        WebElement btn = driver.findElement(By.id(tabName.toLowerCase() + "-permissions-table" + btnName));
        btn.click();
    }

    public static List<String> getStringListFromWebElementList(List<WebElement> webElementList) {
        List<String> stringList = new ArrayList<>();
        BrowserUtils.wait(2);
        for (WebElement element : webElementList) {
            stringList.add(element.getText().toLowerCase());
        }
        return stringList;
    }

    public void selectStatus(String status) {
        WebElement option = Driver.getDriver().findElement(By.xpath("//li[contains(text(),'" + status + "')]"));
        BrowserUtils.wait(15);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", statusExpandArrow);
        statusSelectInput.sendKeys(status);
        option.click();
    }

    int itemIdToBeAssociated;
    public void selectItemAtOrderInAssociationTab(int assocCheckboxOrder) {
        BrowserUtils.wait(2);
        associateCheckBoxes.get(assocCheckboxOrder - 1).click();
        String itemIdToBeAssociatedText = GeneralPage.getColumnData(associationTable,"Item Id").get(1);
        itemIdToBeAssociated = Integer.parseInt(itemIdToBeAssociatedText);
    }

    public boolean getAssociations(String itemCode, String associationTypeCode) {
        int firstItemId = 0;
        int secondItemId = 0;
        int assocType = 0;
        int itemId = getItemIdFromSKU(itemCode);
        if (itemId == -1) {
            System.out.println("Item not found for SKU: " + itemCode);
        }

        String query = "SELECT * FROM TEST_MDM.dbo.Associations a " +
                "WHERE (FirstItemId = ? AND SecondItemId = ?) " +
                "   OR (FirstItemId = ? AND SecondItemId = ?)";

        try (Connection connection = Database.getInstance();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, itemIdToBeAssociated);
            ps.setInt(2, itemId);
            ps.setInt(3, itemId);
            ps.setInt(4, itemIdToBeAssociated);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Association ID: " + rs.getInt("Id"));
                firstItemId = rs.getInt("FirstItemId");
                secondItemId = rs.getInt("SecondItemId");
                assocType = rs.getInt("AssociationTypeId");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("FirstItemId " + firstItemId);
        System.out.println("SecondItemId " + secondItemId);
        System.out.println("AssociationTypeId " + assocType);
        System.out.println(itemIdToBeAssociated);
        return firstItemId != 0 && secondItemId != 0;
    }

    public int getItemIdFromSKU(String sku) {
        String sql = "SELECT Id FROM TEST_MDM.dbo.Items WHERE SKU = '" + sku + "'";
        try (Connection connection = Database.getInstance();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
