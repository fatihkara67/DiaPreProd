package com.efectura.pages.MDMPages.AssetManagement;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.efectura.pages.SystemPages.CurrenciesPage.*;
import static com.efectura.utilities.BrowserUtils.getSelectedOption;

public class AssetEditPage extends BasePage {
    public AssetEditPage() {
    }

    @FindBy(xpath = "//a[@id='listDropdown']//*[name()='svg']")
    private WebElement listDropDownButton;

    @FindBy(xpath = "//a[normalize-space()='Sematestyeni']")
    private WebElement editListItem;
    @FindBy(xpath = "//li[@class='list-tag']")
    private WebElement verifyEditListItem;
    @FindBy(xpath = "//span[@class='cancel-button']")
    private WebElement deleteEditList;
    @FindBy(xpath = "//div[@class='notifyjs-success']")
    private WebElement verifyRemovedListPopUp;
    @FindBy(xpath = "//a[normalize-space()='test12234testt52']")
    private WebElement editListSecondItem;
    @FindBy(xpath = "//a[normalize-space()='AllListsAdded']")
    private WebElement allListAddedItem;
    @FindBy(xpath = "//a[@id='_group-permissions']")
    private WebElement groupPermissions;
    @FindBy(xpath = "//button[@id='group-permissions-tableFirstPage']")
    private WebElement leftPreviousPage;
    @FindBy(xpath = "//button[@id='user-permissions-tableFirstPage']")
    private WebElement leftPreviousPageUser;
    @FindBy(xpath = "//span[@id='group-permissions-table_previous']")
    private WebElement previousPage;
    @FindBy(xpath = "//span[@id='user-permissions-table_previous']")
    private WebElement previousPageUser;
    @FindBy(xpath = "//span[@id='group-permissions-table_next']")
    private WebElement nextPage;
    @FindBy(xpath = "//span[@id='user-permissions-table_next']")
    private WebElement nextPageUser;
    @FindBy(xpath = "//button[@id='group-permissions-tableLastPage']")
    private WebElement lastPage;
    @FindBy(xpath = "//button[@id='user-permissions-tableLastPage']")
    private WebElement lastPageUser;
    @FindBy(xpath = "//input[@class='pagination-text']")
    private WebElement lastPageVerificationText;
    @FindBy(xpath = "//input[@class='pagination-text']")
    private WebElement lastPageVerificationTextUser;
    @FindBy(xpath = "//a[@id='_user-permissions']")
    private WebElement userPermissions;

    @FindBy(id = "itemStatusDropdown")
    private WebElement itemStatusDropdown;

    @FindBy(xpath = "//span[@id='select2-itemStatusDropdown-container']")
    private WebElement itemStatusDropdownContainer;

    @FindBy(xpath = "//span[text()='Unsaved Changes']")
    private WebElement unsavedChangesButton;

    @FindBy(xpath = "//div[2]/div/div[3]/a[1]")
    private WebElement cancelButtonInChangeItemModal;

    @FindBy(xpath = "//span/input[@type='search']")
    private WebElement itemStatusDropdownInputBox;

    @FindBy(xpath = "//a[@id='savebutton']")
    private WebElement saveButtonInChangeItemModal;

    @FindBy(xpath = "//li[contains(@class,'catalogCategories')]")
    private WebElement rootCategorySubTab;

    @FindBy(xpath = "//div[6]/div[1]/i")
    private WebElement accordionButton;

    @FindBy(xpath = "//div[contains(@class,'accordion-title')]")
    private WebElement accordionTitle;

    @FindBy(xpath = "//span[text()='AddFavourite']")
    private WebElement addFavouriteButton;

    public void clickListDropDown() {
        BrowserUtils.waitForVisibility(listDropDownButton, 20);
        listDropDownButton.click();
    }

    public void clickListItem() {
        BrowserUtils.waitForVisibility(editListItem, 20);
        editListItem.click();
    }

    public void clickListSecondItem() {
        BrowserUtils.waitForVisibility(editListSecondItem, 25);
        editListSecondItem.click();
    }

    public void verifyEditListItem() {
    BrowserUtils.wait(5);
    Assert.assertTrue(verifyEditListItem.isDisplayed());
    }

    public void clicksDeleteEditList() {
        BrowserUtils.waitForVisibility(deleteEditList, 20);
        deleteEditList.click();
    }

    public void verifyEditRemoved() {
        BrowserUtils.waitForVisibility(verifyRemovedListPopUp, 20);
        Assert.assertTrue(verifyRemovedListPopUp.isDisplayed());
    }

    public void verifyAllItemList() {
        BrowserUtils.waitForVisibility(allListAddedItem, 20);
        Assert.assertTrue(allListAddedItem.isDisplayed());
    }

    public void clickGroupPermission() {
        BrowserUtils.wait(5);
        groupPermissions.click();
    }

    public void verifyLeftPreviousePageIsNotClicible() {
        BrowserUtils.wait(5);
        Assert.assertFalse(isButtonActive(leftPreviousPage));
    }

    public void verifyPreviousePageIsNotClicible() {
        BrowserUtils.wait(5);
        Assert.assertFalse(isButtonActive(previousPage));
    }
    public void verifyPreviousPageUserIsNotClickable() {
        BrowserUtils.wait(5);
        Assert.assertFalse(isButtonActive(previousPageUser));
    }
    public void verifyLeftPreviousPageUserIsClickable() {
        BrowserUtils.wait(5);
        Assert.assertTrue(isButtonActive(leftPreviousPageUser));
    }


    public void clicksNextPageButton() {
        BrowserUtils.wait(7);
        nextPage.click();
    }

    public void verifyNextPageIsNotClickable() {
        BrowserUtils.wait(5);
        String classAttribute = nextPage.getAttribute("class");
        //Assert.assertTrue(classAttribute.contains("disabled"));
        Assert.assertFalse(isButtonActive(nextPage));
    }
    public void clicksNextPageUserButton() {
        BrowserUtils.wait(2);
        nextPageUser.click();
        waitForClickableOfButton(leftPreviousPageUser);
    }


    public void verifyNextPageUserIsClickable() {
        BrowserUtils.wait(5);
        Assert.assertTrue(isButtonActive(nextPageUser));
    }

    public void clickPreviousPageButton() {
        BrowserUtils.wait(5);
        previousPage.click();
    }
    public void clickPreviousPageUserButton() {
        BrowserUtils.waitForVisibility(previousPageUser,20);
        previousPageUser.click();
    }
    public void verifyPreviousPageIsClickable() {
        BrowserUtils.wait(5);
        Assert.assertTrue(isButtonActive(previousPage));
    }
    public void verifyPreviousPageUserIsClickable() {
        BrowserUtils.wait(5);
        Assert.assertTrue(isButtonActive(previousPageUser));
    }

    public void clickLastPageButton() {
        BrowserUtils.wait(5);
        lastPage.click();
    }

    public void verifyLastPageIsClickable() {
        BrowserUtils.wait(5);
        Assert.assertTrue(isButtonActive(lastPage));
    }

    public void clickLastPageUserButton() {
        BrowserUtils.wait(4);
        lastPageUser.click();
        waitForUnclickableOfButton(lastPageUser);
    }

    public void verifyLastPageUserIsClickable() {
        BrowserUtils.wait(7);
        Assert.assertTrue(isButtonActive(lastPageUser));
    }

    public void verifyLastPageIsUnClickable() {
        BrowserUtils.wait(7);
        Assert.assertFalse(isButtonActive(lastPage));
    }

    public void verifyNextPageIsClickable() {
        BrowserUtils.wait(7);
        Assert.assertTrue(isButtonActive(nextPage));
    }
    public void verifyNextPageUserIsUnClickable() {
        BrowserUtils.wait(5);
//        String classAttribute = nextPageUser.getAttribute("class");
//        Assert.assertTrue(classAttribute.contains("disabled"));
        Assert.assertFalse(isButtonActive(nextPageUser));
    }

    public void verifyFirstPageIsClickable() {
        BrowserUtils.wait(5);
        Assert.assertTrue(isButtonActive(leftPreviousPage));
    }

    public void clickUserPermission() {
        BrowserUtils.wait(3);
        userPermissions.click();
        BrowserUtils.wait(3);
    }
    public void verifyLeftPreviousePageUserIsNotClickable() {
        Assert.assertFalse(isButtonActive(leftPreviousPageUser));
    }

    String currentItemStatus;
    public void selectItemStatusInAssetEditPage(String itemStatusOption) {
        currentItemStatus = getSelectedOption(itemStatusDropdown);
        BrowserUtils.waitForVisibility(itemStatusDropdown,4);
        itemStatusDropdownContainer.click();
        BrowserUtils.wait(2);
        itemStatusDropdownInputBox.sendKeys(itemStatusOption + Keys.ENTER);
        BrowserUtils.wait(3);
    }

    public void clickUnsavedChangesButton() {
        unsavedChangesButton.click();
    }


    public void clickCancelButtonInChangeItemModal() {
        BrowserUtils.waitForVisibility(cancelButtonInChangeItemModal,4);
        cancelButtonInChangeItemModal.click();
    }

    public void verifyItemStatusNotChange() {
        BrowserUtils.wait(4);
        Assert.assertEquals(currentItemStatus, getSelectedOption(itemStatusDropdown));
    }

    public void clickSaveButtonInChangeItemModal() {
        BrowserUtils.waitForVisibility(saveButtonInChangeItemModal,3);
        saveButtonInChangeItemModal.click();
    }

    public void verifyLastButtonIsUnclickableInUserPermissions() {
        Assert.assertFalse(isButtonActive(lastPageUser));
    }


    public void clickAccordionButton() {
        if (accordionTitle.getAttribute("class").contains("active")) {
            accordionButton.click();
            BrowserUtils.waitForVisibility(addFavouriteButton,5);
        }
    }
}
