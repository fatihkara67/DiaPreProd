package com.efectura.pages.MDMPages.AssetManagement;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.efectura.pages.SystemPages.CurrenciesPage.getStringListFromWebElementList;
import static org.junit.Assert.assertTrue;

public class Asset extends BasePage {

    @FindBy(xpath = "//a[@id='_fast-item-info']")
    private WebElement infoItem;
    @FindBy(xpath = "//div[@id='jstreeFastCatalog_35']//a[@id='35_anchor']")
    private WebElement assetCategories;
    @FindBy(xpath = "//div[@id='create-new-item-modal']//a[@id='110_anchor']//i[1]")
    private WebElement newNodeClick;
    @FindBy(xpath = "//li[text()=' COOLER3 ']")
    private WebElement coolerFamily;
    @FindBy(xpath = "//span//span[@id='select2-chooseFamilies-container']")
    private WebElement familyDropDown;
    @FindBy(xpath = "//span[normalize-space()='EMPTY_FAMILY']")
    private WebElement emptyFamilyAssetText;
    @FindBy(xpath = "//a[@class='t-delete danger-btn']")
    private WebElement deleteButtonAsset;
    @FindBy(xpath = "//button[@id='deleteItemPopup']")
    private WebElement deleteButtonAssetPopup;
    @FindBy(xpath = "//button[@id='cancelPopup']")
    private WebElement cancelButtonAssetPopup;
    @FindBy(xpath = "//span[normalize-space()='Öğe Başarıyla Silindi.']")
    private WebElement deleteItemText;
    @FindBy(xpath = "//a[normalize-space()='Asset Overview']")
    private WebElement verifyAssetEditButton;
    @FindBy(xpath = "//a[@id='35']")
    private WebElement mainAssetCategories;
    @FindBy(xpath = "//a[@id='110_anchor']")
    private WebElement newNodeElementAssetCategories;
    @FindBy(xpath = "//li[contains(text(),'Cooler') and @role='treeitem']")
    private WebElement selectCoolerFamily;
    @FindBy(xpath = "//a[@id='createNewList']")
    private WebElement createListButton;
    @FindBy(xpath = "//div[@id='create-new-list']//button[@type='button'][normalize-space()='İptal Et']")
    private WebElement createListCancelButton;
    @FindBy(xpath = "//h4[normalize-space()='Yeni Liste']")
    private WebElement verifyNewListPopup;
    @FindBy(xpath = "//input[@id='input-list']")
    private WebElement listName;
    @FindBy(xpath = "//select[@id='can-view-select']")
    private WebElement canView;
    @FindBy(xpath = "//select[@id='can-view-select']//optgroup[@label='Users']//option")
    private List<WebElement> canViewList;
    @FindBy(xpath = "//select[@id='can-edit-select']")
    private WebElement canEdit;
    @FindBy(xpath = "//select[@id='can-edit-select']//optgroup[@label='Users']//option")
    private List<WebElement> canEditList;
    @FindBy(xpath = "//ul/li[@class='list-item']/p")
    private List<WebElement> listItemNames;
    @FindBy(xpath = "//li[@id='select2-can-view-select-result-ejbv-user0007d59c-20cc-4ce2-a7f3-8031f22b03ce'and @role='treeitem']")
    private WebElement selectedCanView;
    @FindBy(xpath = "//button[@id='create-list']")
    private WebElement listCreateButton;
    @FindBy(xpath = "//div[@class='notifyjs-warning']")
    private WebElement createListErrorMessage;
    @FindBy(xpath = "//li[normalize-space()='No results found']")
    private WebElement verifyNoResultsFound;
    @FindBy(xpath = "//div[@class='modal-footer']/button[text()='İptal Et']")
    private WebElement deleteListCancelPopUp;
    @FindBy(xpath = "//button[@id='delete-list-button']")
    private WebElement deleteListDeletePopUp;
    @FindBy(xpath = "//li[normalize-space()='campaign-list']")
    private WebElement deletedListItem;
    @FindBy(xpath = "//li[normalize-space()='campaign-list']//i[@class='fa fa-trash edit-icon']")
    private WebElement deleteListButton;
    @FindBy(xpath = "//li[normalize-space()='otomasyon']")
    private WebElement deletedListItemAssetOtomasyonVerify;
    @FindBy(xpath = "//li[normalize-space()='otomasyon']//i[@class='fa fa-trash edit-icon']")
    private WebElement deleteListButtonAssetOtomasyon;

    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> codeValues;

    @FindBy(xpath = "//li[contains(@class,'catalogCategories')]")
    private WebElement rootCategorySubTab;

    @FindBy(xpath = "//i[@class='jstree-icon jstree-checkbox']")
    private WebElement rootCategoryCheckbox;


    public Asset() {
    }

    public void verifyInfoItem() {
        BrowserUtils.waitForVisibility(infoItem, 20);
        Assert.assertTrue(infoItem.isDisplayed());
    }

    public void verifyCodeFilterResultsAreCorrect(String filterInput) {
        for (WebElement value : codeValues) {
            Assert.assertTrue(value.getText().contains(filterInput));
        }
    }

    public void verifyRootCategories(int timeout) {
        BrowserUtils.waitForVisibility(rootCategorySubTab,timeout);
        Assert.assertTrue(rootCategorySubTab.isDisplayed());
    }

    public void clickNewNode() {
        BrowserUtils.waitForVisibility(newNodeClick, 20);
        newNodeClick.click();
    }

    public void selectCoolerFamily() {
        BrowserUtils.waitForVisibility(familyDropDown, 20);
        familyDropDown.click();
        BrowserUtils.waitForVisibility(coolerFamily, 20);
        coolerFamily.click();
    }

    public void verifyAssetEmptyFamilyText(String text, int timeout) {
        BrowserUtils.waitForVisibility(emptyFamilyAssetText, timeout);
        Assert.assertTrue(emptyFamilyAssetText.getText().contains(text));
    }

    public void clickDeleteButtonAsset() {
        BrowserUtils.hoverOver(deleteButtonAsset);
        BrowserUtils.wait(5);
        deleteButtonAsset.click();
    }

    public void clickCancelButtonInPopup() {
        cancelButtonAssetPopup.click();
    }

    public void clickDeleteButtonAssetPopup() {
        deleteButtonAssetPopup.click();
    }

    public void verifyDeleteItemText(String text, int timeout) {
        BrowserUtils.waitForVisibility(deleteItemText, timeout);
        Assert.assertTrue(deleteItemText.getText().contains(text));
    }

    public void clickAssetCategoryButton() {
        BrowserUtils.waitForVisibility(assetCategories, 20);
        assetCategories.click();
    }

    public void verifyEditPage() {
        BrowserUtils.wait(2);
        assertTrue(verifyAssetEditButton.isDisplayed());

    }

    public void clickMainAssetCategories() {
        mainAssetCategories.click();
    }

    public void selectAssetFamily(String family) {
        BrowserUtils.waitForVisibility(familyDropDown, 20);
        familyDropDown.click();
        if (family.equalsIgnoreCase("COOLER3")) {
            BrowserUtils.waitForVisibility(coolerFamily, 20);
            coolerFamily.click();
        }
    }

    public void clickNewList() {
        BrowserUtils.waitForVisibility(createListButton, 20);
        createListButton.click();
    }

    public void verifyNewListPopup() {
        BrowserUtils.waitForVisibility(verifyNewListPopup, 20);
        Assert.assertTrue(verifyNewListPopup.isDisplayed());
    }

    public void setListName(String name) {
        listName.sendKeys(name);
    }

    public void setCanView(String view) {
        BrowserUtils.selectDropdownOptionByVisibleText(canView,view);
    }

    public void setCanEdit(String edit) {
        BrowserUtils.selectDropdownOptionByVisibleText(canEdit,edit);
    }

    public void clickNewListCancelButton() {
        createListCancelButton.click();
    }

    public void verifyListItemIsNotVisible(String itemName) {
        BrowserUtils.wait(5);
        List<String> names = getStringListFromWebElementList(listItemNames);
        Assert.assertFalse(names.contains(itemName));
    }

    public void verifyListItemIsVisible(String itemName) {
        BrowserUtils.wait(5);
        List<String> names = getStringListFromWebElementList(listItemNames);
        Assert.assertTrue(names.contains(itemName));
    }

    public void clickNewListCreateButton() {
        BrowserUtils.waitForVisibility(listCreateButton, 20);
        listCreateButton.click();
    }

    public void verifyCreateListErrorMessageIsDisplayed(String message) {
        BrowserUtils.waitForVisibility(createListErrorMessage, 30);
        Assert.assertTrue(createListErrorMessage.isDisplayed());
    }

    public void verifyNoResultsFound() {
        BrowserUtils.waitForVisibility(verifyNoResultsFound, 20);
        Assert.assertTrue(verifyNoResultsFound.isDisplayed());
    }

    public void clickDeleteButton() {
       //  BrowserUtils.hoverOver(deletedListItem);
       // BrowserUtils.waitForVisibility(deleteListButton, 20);
       //  deleteListButton.click();
    }

    public void clickCancelButtonPopUp() {
        BrowserUtils.waitForVisibility(deleteListCancelPopUp, 20);
        deleteListCancelPopUp.click();
    }

    public void clickDeleteButtonPopUp() {
        BrowserUtils.waitForVisibility(deleteListDeletePopUp, 20);
        deleteListDeletePopUp.click();
    }
    public void clickDeleteButtonOtomasyon() {
        //BrowserUtils.hoverOver(deletedListItemAssetOtomasyonVerify);
       // BrowserUtils.waitForVisibility(deletedListItemAssetOtomasyonVerify, 30);
    }
    public void clickCancelButtonPopUpOtomasyon() {
        BrowserUtils.waitForVisibility(deleteListButtonAssetOtomasyon, 20);
        deleteListButtonAssetOtomasyon.click();
    }

}
