package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class SystemCurrenciesStepDefs extends BaseStep{

    @When("The user on the currencies page")
    public void the_user_on_the_currencies_page() {
        pages.currenciesPage().goToCurrenciesPage();
    }

    @Then("The user verifies that reached the {string} page.")
    public void theUserVerifiesThatReachedThePage(String pageName) {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(pageName));
    }

    @When("The user enters {string} in to code filter")
    public void theUserEntersInToCodeFilter(String filterInput) {
        pages.currenciesPage().enterInputToCodeFilter(filterInput);
    }

    @Then("The User verifies that code filter results contains {string}")
    public void theUserVerifiesThatCodeFilterResultsContains(String filterInput) {
        pages.currenciesPage().verifyCodeFilterResultsAreCorrect(filterInput);
    }

    @Then("The user verifies that code values are ascending order with no action")
    public void theUserVerifiesThatCodeValuesAreAscendingOrderWithNoAction() {
        Assert.assertTrue(pages.currenciesPage().areCodeValuesAscending());
    }

    @When("The user clicks data header for descending sort")
    public void theUserClicksDataHeaderForDescendingSort() {
        pages.currenciesPage().clickCodeHeaderForDescending();
    }

    @Then("The user verifies that code values are descending order")
    public void theUserVerifiesThatCodeValuesAreDescendingOrder() {
        Assert.assertTrue(pages.currenciesPage().areCodeValuesDescending());
    }

    @When("The user clicks status header for ascending sort")
    public void theUserClicksStatusHeaderForAscendingSort() {
        pages.currenciesPage().clickStatusHeaderForAscending();
    }

    @Then("The user verifies that status values are ascending order")
    public void theUserVerifiesThatStatusValuesAreAscendingOrder() {
        Assert.assertTrue(pages.currenciesPage().areStatusValuesAscending());
    }

    @When("The user clicks status header for descending sort")
    public void theUserClicksStatusHeaderForDescendingSort() {
        pages.currenciesPage().clickStatusHeaderForDescending();
    }

    @Then("The user verifies that status values are descending order")
    public void theUserVerifiesThatStatusValuesAreDescendingOrder() {
        Assert.assertTrue(pages.currenciesPage().areStatusValuesDescending());
    }

    @When("The user clicks reset button")
    public void theUserClicksResetButton() {
        pages.currenciesPage().clickResetButton();
    }

    @Then("The user verifies that code filter has no value")
    public void theUserVerifiesThatCodeFilterHasNoValue() {
        pages.currenciesPage().verifyCodeFilterHasNoValue();
    }

    @When("The user clicks a currency edit button")
    public void theUserClicksACurrencyEditButton() {
        pages.currenciesPage().clickCurrencyEditButton();
        BrowserUtils.wait(8);
    }

    @Then("The user verifies that cancel button is active in EditCurrency popup")
    public void theUserVerifiesThatCancelButtonIsActiveInEditCurrencyPopup() {
        pages.currenciesPage().verifyCancelButtonIsActiveInEditCurrencyPopup();
    }

    @Then("The user verifies that Save button is inactive without change in EditCurrency popup")
    public void theUserVerifiesThatSaveButtonIsInactiveWithoutChangeInEditCurrencyPopup() {
        pages.currenciesPage().verifySaveButtonIsInactiveInEditCurrencyPopup();
    }

    @When("The user clicks cancel button in EditCurrency popup")
    public void theUserClicksCancelButtonInEditCurrencyPopup() {
        pages.currenciesPage().clickCancelButtonInEditCurrencyPopup();
        BrowserUtils.wait(1);
    }

    @Then("The user verifies that EditCurrency popup is closed")
    public void theUserVerifiesThatEditCurrencyPopupIsClosed() {
        pages.currenciesPage().verifyEditCurrencyPopupIsClosed();
    }

    @When("The user enter {string} in to CurrencyCode input box in EditCurrency popup")
    public void theUserEnterAInToCurrencyCodeInputBoxInEditCurrencyPopup(String editCurrencyCodeInput) {
        pages.currenciesPage().enterInputToEditCurrencyCode(editCurrencyCodeInput);
    }

    @Then("The user verifies that Save button is active in EditCurrency popup")
    public void theUserVerifiesThatSaveButtonIsActiveInEditCurrencyPopup() {
        pages.currenciesPage().verifySaveButtonIsActiveInEditCurrencyPopup();
    }

    @When("The user clicks Status checkbox in EditCurrency popup")
    public void theUserClicksStatusCheckboxInEditCurrencyPopup() {
        pages.currenciesPage().clickStatusCheckboxInEditCurrencyPopup();
    }

    @Then("The user verifies that Refresh button is active")
    public void theUserVerifiesThatRefreshButtonIsActive() {
        pages.currenciesPage().verifyRefreshButtonIsActiveInCurrencies();
    }

    @When("The user clicks CreateNew button in Currencies page")
    public void theUserClicksCreateNewButtonInCurrenciesPage() {
        pages.currenciesPage().clickCreateNewButtonInCurrenciesPage();
    }

    @When("The user clicks cancel button in AddCurrency popup")
    public void theUserClicksCancelButtonInAddCurrencyPopup() {
        pages.currenciesPage().clickCancelButtonInAddCurrencyPopup();
        BrowserUtils.wait(1);
    }

    @Then("The user verifies that AddCurrency popup is closed")
    public void theUserVerifiesThatAddCurrencyPopupIsClosed() {
        pages.currenciesPage().verifyAddCurrencyPopupIsClosed();
    }

    @Then("The user verifies that Save button is inactive without change in AddCurrency popup")
    public void theUserVerifiesThatSaveButtonIsInactiveWithoutChangeInAddCurrencyPopup() {
        pages.currenciesPage().verifySaveButtonIsInactiveInAddCurrencyPopup();
    }

    @When("The user enters {string} in to pagination input box")
    public void theUserEntersInToPaginationInputBox(String firstPageNumber) {
        pages.currenciesPage().enterPageNumberInToPaginationInputBox(firstPageNumber);
    }

    @Then("The user verifies that first and previous pagination buttons are inactive in first page of table in Currencies")
    public void theUserVerifiesThatFirstAndPreviousPaginationButtonsAreInactiveInFirstPageOfTableInCurrencies() {
        pages.currenciesPage().verifyFirstAndPreviousButtonsAreInactiveInFirstPageOfTableInCurrencies();
    }

    @When("The user enters {string} in to CurrencyCode input box in AddCurrency popup")
    public void theUserEntersAInToCurrencyCodeInputBoxInAddCurrencyPopup(String addCurrencyCodeInput) {
        pages.currenciesPage().enterInputToAddCurrencyCode(addCurrencyCodeInput);
    }

    @Then("The user verifies that Save button is active in AddCurrency popup")
    public void theUserVerifiesThatSaveButtonIsActiveInAddCurrencyPopup() {
        pages.currenciesPage().verifySaveButtonIsActiveInAddCurrencyPopup();
    }

    @When("The user enters an already existing Code value in to CurrencyCode input box {string}")
    public void theUserEntersAnAlreadyExistingCodeValueInToCurrencyCodeInputBox(String popupName) {
        pages.currenciesPage().enterAlreadyExistingCodeValueInTo(popupName);
    }

    @When("The user clicks Save button in AddCurrency popup")
    public void theUserClicksSaveButtonInAddCurrencyPopup() {
        pages.currenciesPage().clickSaveButtonInAddCurrencyPopup();
    }

    @Then("The user verifies that the {string} warning appears in the top right")
    public void theUserVerifiesThatWarningAppearsInTheTopRight(String expectedWarning) {
        pages.currenciesPage().verifyWarningIsDisplayed(expectedWarning);
    }

    @When("The user clicks Save button in EditCurrency popup")
    public void theUserClicksSaveButtonInEditCurrencyPopup() {
        pages.currenciesPage().clickSaveButtonInEditCurrencyPopup();
    }

    @When("The user enters a non existing Code value in to CurrencyCode input box {string}")
    public void theUserEntersANonExistingCodeValueInToCurrencyCodeInputBoxEditCurrency(String popupName) {
        pages.currenciesPage().enterNonExistingCodeValueInTo(popupName);
    }

    @Then("The user verifies that the {string} info appears in the top right")
    public void theUserVerifiesThatTheChangesSavedSuccessfullyInfoAppearsInTheTopRight(String expectedInfo) {
        pages.currenciesPage().verifyWarningIsDisplayed(expectedInfo);
    }

    @Then("The user verifies that current currencies include edited currency")
    public void theUserVerifiesThatCurrentCurrenciesIncludeEditedCurrency() {
        pages.currenciesPage().verifyEditedCurrencyIsInTable();
    }

    @Then("User verifies that status of the currency has changed")
    public void userVerifiesThatStatusOfTheCurrencyHasChanged() {
        pages.currenciesPage().verifyStatusOfEditedCurrencyHasChanged();
    }

    @Then("The user verifies that current currencies include new currency")
    public void theUserVerifiesThatCurrentCurrenciesIncludeNewCurrency() {
        pages.currenciesPage().verifyNewCurrencyIsInTable();
    }

    @When("The user clicks a currency delete button")
    public void theUserClicksACurrencyDeleteButton() {
        pages.currenciesPage().clickCurrencyDeleteButton();
    }

    @Then("The user verifies that Cancel button is active in DeleteCurrency popup")
    public void theUserVerifiesThatCancelButtonIsActiveInDeleteCurrencyPopup() {
        pages.currenciesPage().verifyThatCancelButtonIsActiveInDeleteCurrencyPopup();
    }

    @Then("The user verifies that Delete button is active in DeleteCurrency popup")
    public void theUserVerifiesThatDeleteButtonIsActiveInDeleteCurrencyPopup() {
        pages.currenciesPage().verifyThatDeleteButtonIsActiveInDeleteCurrencyPopup();
    }

    @When("The user clicks Cancel button in DeleteCurrency popup")
    public void theUserClicksCancelButtonInDeleteCurrencyPopup() {
        pages.currenciesPage().clickCancelButtonInDeleteCurrencyPopup();
    }

    @Then("The user verifies that DeleteCurrency popup is closed")
    public void theUserVerifiesThatDeleteCurrencyPopupIsClosed() {
        pages.currenciesPage().verifyDeleteCurrencyPopupIsClosed();
    }

    @When("The user clicks Delete button in DeleteCurrency popup")
    public void theUserClicksDeleteButtonInDeleteCurrencyPopup() {
        pages.currenciesPage().clickDeleteButtonInDeleteCurrencyPopup();
    }

    @Then("The user verifies that current currencies do not include deleted currency")
    public void theUserVerifiesThatCurrentCurrenciesDoNotIncludeDeletedCurrency() {
        pages.currenciesPage().verifyDeletedCurrencyIsNotInTable();
    }

    @Then("The user verifies that Cancel button is active in AddCurrency popup")
    public void theUserVerifiesThatCancelButtonIsActiveInAddCurrencyPopup() {
        pages.currenciesPage().verifyCancelButtonIsActiveInAddCurrencyPopup();
    }

    @When("The user enters last page number in to pagination input box in Currencies page")
    public void theUserEntersLastPageNumberInToPaginationInputBoxInCurrenciesPage() {
        pages.currenciesPage().enterLastPageNumberInToPaginationInputBox();
    }

    @Then("The user verifies that last and next pagination buttons are inactive in last page of table in Currencies page")
    public void theUserVerifiesThatLastAndNextPaginationButtonsAreInactiveInLastPageOfTableInCurrenciesPage() {
        pages.currenciesPage().verifyLastAndNextButtonsAreInactiveInLastPageOfTable();
    }

    @When("The user clicks last pagination button in Currencies page")
    public void theUserClicksLastPaginationButtonInCurrenciesPage() {
        pages.currenciesPage().clickLastPaginationButtonInCurrenciesPage();
    }

    @Then("The user verifies that table is in last page")
    public void theUserVerifiesThatTableIsInLastPage() {
        pages.currenciesPage().verifyTableIsInLastPageInCurrenciesPage();
    }

    @When("The user clicks first pagination button in Currencies page")
    public void theUserClicksFirstPaginationButtonInCurrenciesPage() {
        pages.currenciesPage().clickFirstPaginationButtonInCurrenciesPage();
    }

    @Then("The user verifies that table is in first page in Currencies page")
    public void theUserVerifiesThatTableIsInFirstPageInCurrenciesPage() {
        pages.currenciesPage().verifyTableIsInFirstPageInCurrenciesPage();
    }

    @When("The user clicks next pagination button in Currencies page")
    public void theUserClicksNextPaginationButtonInCurrenciesPage() {
        pages.currenciesPage().clickNextPaginationButtonInCurrenciesPage();
    }

    @Then("The user verifies that table go to next page in Currencies page")
    public void theUserVerifiesThatTableGoToNextPageInCurrenciesPage() {
        pages.currenciesPage().verifyTableIsInNextPageInCurrenciesPage();
    }

    @When("The user clicks previous pagination button in Currencies page")
    public void theUserClicksPreviousPaginationButtonInCurrenciesPage() {
        pages.currenciesPage().clickPreviousPaginationButtonInCurrenciesPage();
    }

    @Then("The user verifies that table go to previous page in Currencies page")
    public void theUserVerifiesThatTableGoToPreviousPageInCurrenciesPage() {
        pages.currenciesPage().verifyTableGoToPreviousPageInCurrenciesPage();
    }
}
