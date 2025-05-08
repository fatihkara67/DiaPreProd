package com.efectura.pages.SystemPages;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.efectura.utilities.Driver.getDriver;

public class CurrenciesPage extends BasePage {

    @FindBy(xpath = "//tbody")
    private WebElement currenciesTableValuePart;

    @FindBy(xpath = "//tr/td[1]")
    private List<WebElement> codeValues;

    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> statusValues;

    @FindBy(xpath = "//tr/th[1]")
    private WebElement codeHeader;

    @FindBy(xpath = "//tr/th[.='Durum']")
    private WebElement statusHeader;

    @FindBy(xpath = "//input[@placeholder='Kod']")
    private WebElement codeFilterInputBox;

    @FindBy(id = "create-tag-button")
    private WebElement createNewButton;

    @FindBy(xpath = "//span[text()='Yenile']")
    private WebElement refreshButton;

    @FindBy(xpath = "//span[text()='Sıfırla']")
    private WebElement resetButton;

    @FindBy(xpath = "//td/a[1]")
    private List<WebElement> editButtonsInCurrenciesPage;

    @FindBy(xpath = "//td/a[2]")
    private List<WebElement> deleteButtonsInCurrenciesPage;

    @FindBy(xpath = "//div[2]/div[3]/button[1]")
    private WebElement cancelButtonInDeleteCurrencyPopup;

    @FindBy(xpath = "//div[2]/div[3]/button[2]")
    private WebElement deleteButtonInDeleteCurrencyPopup;

    @FindBy(xpath = "(//div[@class='modal-dialog modal-confirm'])[1]")
    private WebElement deleteCurrencyPopup;

    @FindBy(xpath = "//div[@id='edit-currency-modal']/div[2]/div")
    private WebElement editCurrencyPopup;

    @FindBy(xpath = "//input[@id='edit-currency-code']")
    private WebElement editCurrencyCodeInputBox;

    @FindBy(xpath = "//div[2]/div/div[3]/div/a[2]")
    private WebElement cancelButtonInEditCurrencyPopup;

    @FindBy(xpath = "//a[@id='edit-currency']")
    private WebElement saveButtonInEditCurrencyPopup;

    @FindBy(xpath = "//input[@id='edit-is-activate']")
    private WebElement statusCheckboxInEditCurrencyPopup;

    @FindBy(xpath = "//a[@id='create-currency']")
    private WebElement saveButtonInAddCurrencyPopup;

    @FindBy(xpath = "//div[2]/div/div[3]/div/a[2]")
    private WebElement cancelButtonInAddCurrencyPopup;

    @FindBy(xpath = "//*[@id='add-currency-modal']/div[2]")
    private WebElement addCurrencyPopup;

    @FindBy(xpath = "//button[@id='locales_tableFirstPage']")
    private WebElement firstPaginationButton;

    @FindBy(xpath = "//button[@id='locales_tableLastPage']")
    private WebElement lastPaginationButton;

    @FindBy(xpath = "//span[@id='locales_table_previous']")
    private WebElement previousPaginationButton;

    @FindBy(xpath = "//span[@id='locales_table_next']")
    private WebElement nextPaginationButton;

    @FindBy(xpath = "//div[@id='locales_table_info']")
    private WebElement tableInfoInCurrenciesPage;

    @FindBy(xpath = "//input[@class='pagination-text']")
    private WebElement paginationInputBox;

    @FindBy(xpath = "//input[@id='currency-code']")
    private WebElement addCurrencyCodeInputBox;

    @FindBy(xpath = "//span[text()='SKU benzersiz olmalı']")
    private WebElement skuShouldBeUniqueWarningPopup;
    
    @FindBy(xpath = "//span[text()='Değişiklikler başarıyla kaydedildi.']")
    private WebElement changesSavedSuccessfullyInfoPopup;

    @FindBy(xpath = "//div[@id='notifyjs-container-top-right']/div/span")
    private WebElement warning;

    @FindBy(xpath = "//select[@name='locales_table_length']")
    private WebElement tableLengthSelectDropdown;

    @FindBy(xpath = "//tr/td")
    private WebElement emptyTableMessage;

    String codeValueForCreate = "codeValueForCreate";
    String codeValueForEdit = "codeValueForEdit";


    public void goToCurrenciesPage() {
        getDriver().navigate().to("https://dia-preprod-ui.efectura.com/Settings/Currencies");
        BrowserUtils.waitForVisibility(currenciesTableValuePart, 15);
    }

    public void enterInputToCodeFilter(String filterInput) {
        codeFilterInputBox.sendKeys(filterInput);
        BrowserUtils.wait(5);
    }

    public void verifyCodeFilterResultsAreCorrect(String filterInput) {
        for (WebElement value : codeValues) {
            Assert.assertTrue(value.getText().toLowerCase().contains(filterInput));
        }
    }

    public static List<String> getStringListFromWebElementList(List<WebElement> webElementList) {
        List<String> stringList = new ArrayList<>();
        BrowserUtils.wait(2);
        for (WebElement element : webElementList) {
            stringList.add(element.getText().toLowerCase());
        }
        return stringList;
    }

    public static boolean areValuesAscending(List<WebElement> values) {
        List<String> valuesAsString = getStringListFromWebElementList(values);
        for (int i = 0; i < valuesAsString.size() - 1; i++) {
            if (valuesAsString.get(i).compareTo(valuesAsString.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean areCodeValuesAscending() {
        return areValuesAscending(codeValues);
    }

    public void clickCodeHeaderForDescending() {
        clickHeaderForDescendingSort(codeHeader);
    }

    public static boolean areValuesDescending(List<WebElement> values) {
        List<String> valuesAsString = getStringListFromWebElementList(values);
        for (int i = 0; i < valuesAsString.size() - 1; i++) {
            if (valuesAsString.get(i).compareTo(valuesAsString.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean areCodeValuesDescending() {
        return areValuesDescending(codeValues);
    }

    public static void clickHeaderForAscendingSort(WebElement header) {
        waitForAttribute(header,"aria-sort");
        while (header.getAttribute("aria-sort").equals("descending")) {
            header.click();
            BrowserUtils.wait(3);
        }
    }

    public static void clickHeaderForDescendingSort(WebElement header) {
        waitForAttribute(header,"aria-sort");
        while (header.getAttribute("aria-sort").equals("ascending")) {
            header.click();
            BrowserUtils.wait(3);
        }
    }

    public void clickStatusHeaderForAscending() {
        statusHeader.click();
        clickHeaderForAscendingSort(statusHeader);
    }

    public boolean areStatusValuesAscending() {
        List<String> statusValuesAsString = getStringListFromWebElementList(statusValues);
        for (int i = 0; i < statusValuesAsString.size() - 1; i++) {
            if (statusValuesAsString.get(i).equals("Active") && statusValuesAsString.get(i + 1).equals("Inactive")) {
                return false;
            }
        }
        return true;
    }

    public void clickStatusHeaderForDescending() {
        statusHeader.click();
        clickHeaderForDescendingSort(statusHeader);
    }

    public boolean areStatusValuesDescending() {
        List<String> statusValuesAsString = getStringListFromWebElementList(statusValues);
        for (int i = 0; i < statusValuesAsString.size() - 1; i++) {
            if (statusValuesAsString.get(i).equals("Inactive") && statusValuesAsString.get(i + 1).equals("Active")) {
                return false;
            }
        }
        return true;
    }

    public static void waitForAttribute(WebElement element, String attribute) {
        while (element.getAttribute(attribute) == null) {
            BrowserUtils.wait(1);
        }
    }

    public void clickResetButton() {resetButton.click();}

    public void verifyCodeFilterHasNoValue() {
        String actualValue = getValueInInputBox(codeFilterInputBox);
        Assert.assertEquals("", actualValue);
    }

    String currencyStatusToBeClicked;
    String currencyCodeToBeClicked;
    public void clickCurrencyEditButton() {
//        List<String> codeValuesAsString = getStringListFromWebElementList(codeValues);
//        for (int i = 0; i < codeValuesAsString.size(); i++) {
//            if ((!codeValuesAsString.get(i).contains("USD") && !codeValuesAsString.get(i).contains("TRY")) &&
//                    !codeValuesAsString.get(i).contains("RUB")) {
//                currencyStatusToBeClicked = statusValues.get(i).getText();
//                currencyCodeToBeClicked = codeValuesAsString.get(i);
//                editButtonsInCurrenciesPage.get(i).click();
//                break;
//            }
//        }
        codeFilterInputBox.sendKeys(codeValueForEdit);
        editButtonsInCurrenciesPage.get(0).click();
        BrowserUtils.waitForVisibility(cancelButtonInEditCurrencyPopup,5);
    }

    public void verifyCancelButtonIsActiveInEditCurrencyPopup() {Assert.assertTrue(cancelButtonInEditCurrencyPopup.isEnabled());}

    public static boolean isButtonActive(WebElement button) {
        BrowserUtils.wait(1);
        String classAttribute = button.getAttribute("class");
        return !classAttribute.contains("disabled");
    }

    public void verifySaveButtonIsInactiveInEditCurrencyPopup() {
        Assert.assertFalse(isButtonActive(saveButtonInEditCurrencyPopup));
    }

    public void clickCancelButtonInEditCurrencyPopup() {cancelButtonInEditCurrencyPopup.click();}

    public void verifyEditCurrencyPopupIsClosed() {Assert.assertTrue(isPopupClosed(editCurrencyPopup));}

    public boolean isPopupClosed(WebElement popupName) {
        BrowserUtils.wait(2);
        try {
            return !popupName.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Belirtilen element bulunamazsa, modal kapatılmıştır.
            return true;
        }
    }

    public void enterInputToEditCurrencyCode(String editCurrencyCodeInput) {
        editCurrencyCodeInputBox.sendKeys(editCurrencyCodeInput);
        BrowserUtils.wait(1);
    }

    public void verifySaveButtonIsActiveInEditCurrencyPopup() {
        Assert.assertTrue(isButtonActive(saveButtonInEditCurrencyPopup));
    }

    public void clickStatusCheckboxInEditCurrencyPopup() {statusCheckboxInEditCurrencyPopup.click();}

    public void verifyRefreshButtonIsActiveInCurrencies() {Assert.assertTrue(isButtonActive(refreshButton));}

    public void clickCreateNewButtonInCurrenciesPage() {
        createNewButton.click();
        BrowserUtils.wait(2);
        BrowserUtils.waitForVisibility(cancelButtonInAddCurrencyPopup,10);
    }

    public void clickCancelButtonInAddCurrencyPopup() {cancelButtonInAddCurrencyPopup.click();}

    public void verifyAddCurrencyPopupIsClosed() {Assert.assertTrue(isPopupClosed(addCurrencyPopup));}

    public void verifySaveButtonIsInactiveInAddCurrencyPopup() {
        Assert.assertFalse(isButtonActive(saveButtonInAddCurrencyPopup));
    }

    public void enterPageNumberInToPaginationInputBox(String pageNumber) {
        paginationInputBox.clear();
        paginationInputBox.sendKeys(pageNumber);
        BrowserUtils.wait(6);
    }

    public void verifyFirstAndPreviousButtonsAreInactiveInFirstPageOfTableInCurrencies() {
        Assert.assertFalse(isButtonActive(firstPaginationButton) || isButtonActive(previousPaginationButton));
    }

    public void enterInputToAddCurrencyCode(String addCurrencyCodeInput) {
        addCurrencyCodeInputBox.sendKeys(addCurrencyCodeInput);
        BrowserUtils.wait(1);
    }

    public void verifySaveButtonIsActiveInAddCurrencyPopup() {
        Assert.assertTrue(isButtonActive(saveButtonInAddCurrencyPopup));
    }

    public void enterAlreadyExistingCodeValueInTo(String s) {
        String alreadyExistingCode = "USD(US Dollar)";
        if (s.contains("Add")) {
            addCurrencyCodeInputBox.sendKeys(alreadyExistingCode);
        }else if(s.contains("Edit")) {
            editCurrencyCodeInputBox.clear();
            editCurrencyCodeInputBox.sendKeys(alreadyExistingCode);
        }
    }

    public void clickSaveButtonInAddCurrencyPopup() {
        waitForClickableOfButton(saveButtonInAddCurrencyPopup);
        saveButtonInAddCurrencyPopup.click();
    }

    public void verifySkuShouldBeUniqueWarningIsDisplayed(String expectedWarning) {
        BrowserUtils.waitForVisibility(skuShouldBeUniqueWarningPopup,3);
        Assert.assertEquals(skuShouldBeUniqueWarningPopup.getText(), expectedWarning);
    }

    public static void waitForClickableOfButton(WebElement button) {
        while (!isButtonActive(button)) {
            BrowserUtils.wait(1);
        }
    }

    public static void waitForUnclickableOfButton(WebElement button) {
        while (isButtonActive(button)) {
            BrowserUtils.wait(1);
        }
    }

    public void clickSaveButtonInEditCurrencyPopup() {
        waitForClickableOfButton(saveButtonInEditCurrencyPopup);
        saveButtonInEditCurrencyPopup.click();
    }

    String randomCurrencyCode;
    public static String generateRandomCurrencyCode() {
        int length = 5;
        String characters = "ABCDEFGHJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public void enterNonExistingCodeValueInTo(String popupName) {
        //randomCurrencyCode = generateRandomCurrencyCode();

        if (popupName.contains("Add")) {
            addCurrencyCodeInputBox.sendKeys(codeValueForCreate);
        }else if(popupName.contains("Edit")) {
            editCurrencyCodeInputBox.clear();
            editCurrencyCodeInputBox.sendKeys(codeValueForEdit);
        }
    }

    public void verifyChangesSavedSuccessfullyInfoIsDisplayed(String expectedInfo) {
        BrowserUtils.waitForVisibility(changesSavedSuccessfullyInfoPopup,5);
        Assert.assertEquals(changesSavedSuccessfullyInfoPopup.getText(), expectedInfo);
    }

    public boolean isCurrencyCodeValueInTable(String currencyCodeToBeCheck) {
        BrowserUtils.wait(3);
        resetButton.click();
        enterInputToCodeFilter(currencyCodeToBeCheck);
        List<String> codeValuesAsString = getStringListFromWebElementList(codeValues);
        return codeValuesAsString.contains(currencyCodeToBeCheck.toLowerCase());
    }

    public void verifyEditedCurrencyIsInTable() {
        Assert.assertTrue(isCurrencyCodeValueInTable(codeValueForEdit));
    }

    public void verifyStatusOfEditedCurrencyHasChanged() {
        codeFilterInputBox.sendKeys(codeValueForEdit);
        String newStatus = statusValues.get(0).getText();
        Assert.assertNotEquals("Inaktif",newStatus);
    }

    public void verifyNewCurrencyIsInTable() {
        Assert.assertTrue(isCurrencyCodeValueInTable(codeValueForCreate));
    }

    String currencyCodeToBeDeleted;
    public void clickCurrencyDeleteButton() {
//        List<String> codeValuesAsString = getStringListFromWebElementList(codeValues);
//        for (int i = 0; i < codeValuesAsString.size(); i++) {
//            if (!codeValuesAsString.get(i).equalsIgnoreCase("Dolar") && !codeValuesAsString.get(i).equalsIgnoreCase("Lira")) {
//                currencyCodeToBeDeleted = codeValuesAsString.get(i);
//                deleteButtonsInCurrenciesPage.get(i).click();
//                break;
//            }
//        }
        codeFilterInputBox.sendKeys(codeValueForEdit);
        BrowserUtils.wait(2);
        deleteButtonsInCurrenciesPage.get(0).click();
        BrowserUtils.waitForVisibility(cancelButtonInDeleteCurrencyPopup,10);
    }

    public void verifyThatCancelButtonIsActiveInDeleteCurrencyPopup() {
        Assert.assertTrue(isButtonActive(cancelButtonInDeleteCurrencyPopup));
    }

    public void verifyThatDeleteButtonIsActiveInDeleteCurrencyPopup() {
        Assert.assertTrue(isButtonActive(deleteButtonInDeleteCurrencyPopup));
    }

    public void clickCancelButtonInDeleteCurrencyPopup() {cancelButtonInDeleteCurrencyPopup.click();}

    public void verifyDeleteCurrencyPopupIsClosed() {
        Assert.assertTrue(isPopupClosed(deleteCurrencyPopup));
    }

    public void clickDeleteButtonInDeleteCurrencyPopup() {deleteButtonInDeleteCurrencyPopup.click();}

    public void verifyDeletedCurrencyIsNotInTable() {
        Assert.assertFalse(isCurrencyCodeValueInTable(codeValueForEdit));
    }

    public void verifyCancelButtonIsActiveInAddCurrencyPopup() {
        Assert.assertTrue(isButtonActive(cancelButtonInAddCurrencyPopup));
    }

    public static String getSelectedOption(WebElement selectElement) {
        Select select = new Select(selectElement);
        return select.getFirstSelectedOption().getText();
    }

    public static int findLastPageNumber(WebElement tableInfo, WebElement tableLengthSelectDropdown) {
        int totalCurrencyCount = Integer.parseInt(tableInfo.getText().split(" ")[0]);
        int visibleCurrencyCount = Integer.parseInt(getSelectedOption(tableLengthSelectDropdown));
        return (int) Math.ceil((double) totalCurrencyCount / visibleCurrencyCount);
    }

    public void enterLastPageNumberInToPaginationInputBox() {
        paginationInputBox.clear();
        paginationInputBox.sendKeys(findLastPageNumber(tableInfoInCurrenciesPage, tableLengthSelectDropdown) + "");
        BrowserUtils.wait(5);
    }

    public void verifyLastAndNextButtonsAreInactiveInLastPageOfTable() {
        BrowserUtils.waitForVisibility(lastPaginationButton, 10);
        Assert.assertFalse(isButtonActive(lastPaginationButton) || isButtonActive(nextPaginationButton));
    }

    public void clickLastPaginationButtonInCurrenciesPage() {
        lastPaginationButton.click();
        waitForUnclickableOfButton(lastPaginationButton);
    }

    public static String getValueInInputBox(WebElement inputBox) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return (String) js.executeScript("return arguments[0].value;", inputBox);
    }

    public void verifyTableIsInLastPageInCurrenciesPage() {
        verifyTableIsInLastPage(paginationInputBox,tableInfoInCurrenciesPage,tableLengthSelectDropdown);
    }

    public void clickFirstPaginationButtonInCurrenciesPage() {
        firstPaginationButton.click();
        waitForUnclickableOfButton(firstPaginationButton);
    }

    public void verifyTableIsInFirstPageInCurrenciesPage() {
        verifyTableIsInFirstPage(paginationInputBox);
    }

    public static void verifyTableIsInFirstPage(WebElement inputBox) {
        String actualPageNumber = getValueInInputBox(inputBox);
        Assert.assertEquals("1",actualPageNumber);
    }

    public static void verifyTableIsInLastPage(WebElement inputBox, WebElement tableInfo, WebElement tableLengthSelectDropdown) {
        String actualPageNumber = getValueInInputBox(inputBox);
        Assert.assertEquals(findLastPageNumber(tableInfo,tableLengthSelectDropdown) + "",actualPageNumber);
    }

    public void clickNextPaginationButtonInCurrenciesPage() {
        BrowserUtils.wait(1);
        nextPaginationButton.click();
        BrowserUtils.wait(1);
        waitForClickableOfButton(firstPaginationButton);
    }

    public void verifyTableIsInNextPageInCurrenciesPage() {
        Assert.assertEquals("2", getValueInInputBox(paginationInputBox));
    }

    public void clickPreviousPaginationButtonInCurrenciesPage() {
        previousPaginationButton.click();
        waitForUnclickableOfButton(firstPaginationButton);
    }

    public void verifyTableGoToPreviousPageInCurrenciesPage() {
        Assert.assertEquals("1", getValueInInputBox(paginationInputBox));
    }

    public void verifyWarningIsDisplayed(String expectedWarning) {
        BrowserUtils.waitForVisibility(warning,3);
        //BrowserUtils.wait(1);
        System.out.println("AAAAAA : " + warning.getText());
        Assert.assertEquals(warning.getText(), expectedWarning);
    }
}
