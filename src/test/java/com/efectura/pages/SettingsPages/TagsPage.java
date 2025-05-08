package com.efectura.pages.SettingsPages;

import com.efectura.pages.BasePage;
import com.efectura.pages.SystemPages.CurrenciesPage;
import com.efectura.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.efectura.pages.SystemPages.CurrenciesPage.*;

public class TagsPage extends BasePage {

    @FindBy(xpath = "//a[@id='setting-wheel']")
    private WebElement settingsWheelSymbol;

    @FindBy(xpath = "//a[@id='settingnav']")
    private WebElement settingsMenu;

    @FindBy(xpath = "//a[@id='systemid']")
    private WebElement systemMenu;

    @FindBy(xpath = "//li[5]/ul/li[1]/ul/li/a")
    private List<WebElement> settingsOptions;

    @FindBy(xpath = "//li[5]/ul/li[2]/ul/li/a")
    private List<WebElement> systemOptions;

    @FindBy(xpath = "//span[contains(text(),'Kimlik')]")
    private WebElement idFilter;

    @FindBy(xpath = "//input[@id='Id_From']")
    private WebElement idFromInputBox;

    @FindBy(xpath = "//input[@id='Id_To']")
    private WebElement idToInputBox;

    @FindBy(xpath = "//span[text()='Güncelle']")
    private WebElement idFilterUpdateButton;

    @FindBy(xpath = "//input[@placeholder='Açıklama']")
    private WebElement labelFilterInputBox;

    @FindBy(xpath = "//select[@id='Type']")
    private WebElement itemTypeSelectFilter;

    @FindBy(xpath = "//span[@id='select2-Type-container']")
    private WebElement itemTypeFilterBox;

    @FindBy(xpath = "//tbody")
    private WebElement tagsTableValuePart;

    @FindBy(xpath = "//tr/th[1]")
    private WebElement idHeader;

    @FindBy(xpath = "//tr/td[1]")
    private List<WebElement> idValues;

    @FindBy(xpath = "//tr/th[2]")
    private WebElement labelHeader;

    @FindBy(xpath = "//tr/td[2]")
    private List<WebElement> labelValues;

    @FindBy(xpath = "//tr/th[3]")
    private WebElement itemTypeHeader;

    @FindBy(xpath = "//tr/td[3]")
    private List<WebElement> itemTypeValues;

    @FindBy(xpath = "//tr/td[4]/a[1]")
    private List<WebElement> editTagButtons;

    @FindBy(xpath = "//tr/td[4]/a[2]")
    private List<WebElement> deleteTagButtons;

    @FindBy(xpath = "//button[@id='tags_tableFirstPage']")
    private WebElement firstPaginationButton;

    @FindBy(xpath = "//button[@id='tags_tableLastPage']")
    private WebElement lastPaginationButton;

    @FindBy(xpath = "//span[@id='tags_table_previous']")
    private WebElement previousPaginationButton;

    @FindBy(xpath = "//span[@id='tags_table_next']")
    private WebElement nextPaginationButton;

    @FindBy(xpath = "//div[@id='tags_table_info']")
    private WebElement tableInfoInTagsPage;

    @FindBy(xpath = "//input[@class='pagination-text']")
    private WebElement paginationInputBox;

    @FindBy(xpath = "//span[text()='ExistingTag']")
    private WebElement existingTagWarningPopup;

    @FindBy(xpath = "//span[text()='Değişiklikler başarıyla kaydedildi.']")
    private WebElement changesSavedSuccessfullyInfoPopup;

    @FindBy(xpath = "//select[@name='tags_table_length']")
    private WebElement tableLengthSelectDropdown;

    @FindBy(xpath = "//tr/td")
    private WebElement emptyTableMessage;

    @FindBy(xpath = "//span[text()='IdFromMustBeLessThanIdTo']")
    private WebElement idFromMustBeLessThanIdToWaringPopup;

    @FindBy(xpath = "//button[@id='cancelTagBtn']")
    private WebElement cancelButtonInEditTagModal;

    String labelValueForCreate = "labelValueForCreate";
    String labelValueForEdit = "labelValueForEdit";


    public void goToTagsPage() {
        goToSubMenu("Ayarlar", "Etiketler");
        BrowserUtils.wait(2);
    }

    public void goToSubMenu(String dropdownMenu, String subMenu) {
        if (dropdownMenu.equalsIgnoreCase("Ayarlar")) {
            settingsWheelSymbol.click();
            settingsMenu.click();
            BrowserUtils.waitForClickability(settingsOptions.get(0), 10);

            for (WebElement option : settingsOptions) {
                if (option.getText().equalsIgnoreCase(subMenu)) {
                    option.click();
                    return;
                }
            }
        } else if (dropdownMenu.equalsIgnoreCase("Sistem")) {
            settingsWheelSymbol.click();
            systemMenu.click();

            for (WebElement option : systemOptions) {
                if (option.getText().equalsIgnoreCase(subMenu)) {
                    option.click();
                    return;
                }
            }
        }
        BrowserUtils.waitForVisibility(tagsTableValuePart, 10);
    }

    public void enterInputToLabelFilter(String input) {
        labelFilterInputBox.sendKeys(input);
        BrowserUtils.wait(5);
    }

    public void verifyLabelFilterResultsAreCorrect(String input) {
        for (WebElement value : labelValues) {
            Assert.assertTrue(value.getText().toLowerCase().contains(input));
        }
    }

    public void verifyNoMatchingRecordsFoundIsDisplayed(String message) {
        Assert.assertTrue(emptyTableMessage.isDisplayed());
        Assert.assertEquals(message, emptyTableMessage.getText());
    }

    public void verifyLabelFilterHasNoValue() {
        String actualValue = CurrenciesPage.getValueInInputBox(labelFilterInputBox);
        Assert.assertEquals("", actualValue);
    }

    public static List<Integer> getIntListFromWebElementList(List<WebElement> webElementList) {
        List<Integer> intList = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            intList.add(Integer.parseInt(webElement.getText().trim()));
        }
        return intList;
    }

    public boolean areIdValuesAscending() {
        List<Integer> idValuesAsInt = getIntListFromWebElementList(idValues);
        for (int i = 0; i < idValuesAsInt.size() - 1; i++) {
            if (idValuesAsInt.get(i) > idValuesAsInt.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickIdHeaderForDescending() {
        clickHeaderForDescendingSort(idHeader);
    }

    public boolean areIdValuesDescending() {
        List<Integer> idValuesAsInt = getIntListFromWebElementList(idValues);
        for (int i = 0; i < idValuesAsInt.size() - 1; i++) {
            if (idValuesAsInt.get(i) < idValuesAsInt.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void clickLabelHeaderForAscendingSort() {
        labelHeader.click();
        clickHeaderForAscendingSort(labelHeader);
    }

    public boolean areLabelValuesAscending() {
        return areValuesAscending(labelValues);
    }

    public void clickLabelHeaderForDescendingSort() {
        labelHeader.click();
        clickHeaderForDescendingSort(labelHeader);
    }

    public boolean areLabelValuesDescending() {
        return areValuesDescending(labelValues);
    }

    public void clickItemTypeHeaderForAscendingSort() {
        itemTypeHeader.click();
        clickHeaderForAscendingSort(itemTypeHeader);
    }

    public boolean areItemTypesValuesAscending() {
        return areValuesAscending(itemTypeValues);
    }

    public void clickItemTypeHeaderForDescendingSort() {
        itemTypeHeader.click();
        clickHeaderForDescendingSort(itemTypeHeader);
    }

    public boolean areItemTypesValuesDescending() {
        return areValuesDescending(itemTypeValues);
    }

    public void enterIdFilterValues(int idFrom, int idTo) {
        idFilter.click();
        BrowserUtils.waitForVisibility(idFromInputBox,8);
        idFromInputBox.sendKeys(idFrom + "");
        idToInputBox.sendKeys(idTo + "");
    }

    public static void waitForInvisibilityOfElement(WebElement element) {
        while (element.isDisplayed()) {
            BrowserUtils.wait(2);
        }
    }

    public void clickUpdateButtonInIdFilter() {
        idFilterUpdateButton.click();
        waitForInvisibilityOfElement(idFilterUpdateButton);
    }

    public void verifyIdsAreBetweenIdFromAndIdToInclusive(int idFrom, int idTo) {
        boolean isResultCorrect = true;
        List<Integer> idValuesAsIntList = getIntListFromWebElementList(idValues);
        for (int id : idValuesAsIntList) {
            if (id < idFrom || id > idTo) {
                isResultCorrect = false;
                break;
            }
        }
        Assert.assertTrue(isResultCorrect);
    }

    public void verifyIdFromMustBeLessThanIdToWarningIsDisplayed(String expectedWarning) {
        BrowserUtils.waitForVisibility(idFromMustBeLessThanIdToWaringPopup,5);
        Assert.assertEquals(idFromMustBeLessThanIdToWaringPopup.getText(), expectedWarning);
    }

    public void verifyIdFilterHasNoValue() {
        /*BrowserUtils.wait(2);
        idFilter.click();
        BrowserUtils.waitForVisibility(idFromInputBox,8);*/
        String actualValueFrom = CurrenciesPage.getValueInInputBox(idFromInputBox);
        String actualValueTo = CurrenciesPage.getValueInInputBox(idToInputBox);
        Assert.assertEquals("", actualValueFrom);
        Assert.assertEquals("", actualValueTo);
    }

    public void selectValueFromTypeSelectFilter(String option) {
        BrowserUtils.selectDropdownOptionByVisibleText(itemTypeSelectFilter, option);
        BrowserUtils.wait(1);
    }

    public void verifyTableHasOnlyFilteredValues(String filteredValue) {
        for (WebElement value : itemTypeValues) {
            Assert.assertEquals(filteredValue, value.getText());
        }
    }

    public void verifyItemTypeFilterHasValueTypeAll(String typeAll) {
        Assert.assertEquals(typeAll, itemTypeFilterBox.getText());
    }

    public void verifyFirstAndPreviousButtonsAreInactiveInFirstPageOfTableInTagsPage() {
        Assert.assertFalse(isButtonActive(firstPaginationButton) || isButtonActive(previousPaginationButton));
    }

    public void enterLastPageNumberInToPaginationInputBox() {
        paginationInputBox.clear();
        paginationInputBox.sendKeys(findLastPageNumber() + "");
        BrowserUtils.wait(5);
    }

    public int findLastPageNumber() {
        int totalCurrencyCount = Integer.parseInt(tableInfoInTagsPage.getText().split(" ")[0]);
        int visibleCurrencyCount = Integer.parseInt(getSelectedOption(tableLengthSelectDropdown));
        return (int) Math.ceil((double) totalCurrencyCount / visibleCurrencyCount);
    }

    public void verifyLastAndNextButtonsAreInactiveInLastPageOfTable() {
        BrowserUtils.waitForVisibility(lastPaginationButton, 10);
        Assert.assertFalse(isButtonActive(lastPaginationButton) || isButtonActive(nextPaginationButton));
    }

    public void clickLastPaginationButtonInTagsPage() {
        lastPaginationButton.click();
        waitForUnclickableOfButton(lastPaginationButton);
    }

    public void verifyTableIsInLastPageInTagsPage() {
        verifyTableIsInLastPage(paginationInputBox,tableInfoInTagsPage,tableLengthSelectDropdown);
    }

    public void clickFirstPaginationButton() {
        firstPaginationButton.click();
        waitForUnclickableOfButton(firstPaginationButton);
    }

    public void verifyTableIsInFirstPageInTagsPage() {
        verifyTableIsInFirstPage(paginationInputBox);
    }

    public void clickNextPaginationButtonInTagsPage() {
        BrowserUtils.wait(1);
        nextPaginationButton.click();
        BrowserUtils.wait(1);
        waitForClickableOfButton(firstPaginationButton);
    }

    public void verifyTableGoToNextPageInTagsPage() {
        Assert.assertEquals("2", getValueInInputBox(paginationInputBox));
    }

    public void clickPreviousPaginationButtonInTagsPage() {
        previousPaginationButton.click();
        waitForUnclickableOfButton(firstPaginationButton);
    }

    public void verifyTableGoToPreviousPageInTagsPage() {
        Assert.assertEquals("1", getValueInInputBox(paginationInputBox));
    }

    public void clickTagDeleteButton() {
        labelFilterInputBox.sendKeys(labelValueForEdit);
        deleteTagButtons.get(0).click();
        BrowserUtils.waitForVisibility(cancelButtonInEditTagModal,5);
    }
}
