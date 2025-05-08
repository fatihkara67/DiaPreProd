package com.efectura.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SettingsTagsStepDefs extends BaseStep {

    @When("The user is on the Tags page")
    public void theUserIsOnTheTagsPage() {
        pages.tagsPage().goToTagsPage();
    }

    @When("The user enters {string} in to label filter")
    public void theUserEntersInToLabelFilter(String input) {
        pages.tagsPage().enterInputToLabelFilter(input);
    }

    @Then("The User verifies that label filter results contains {string}")
    public void theUserVerifiesThatLabelFilterResultsContains(String input) {
        pages.tagsPage().verifyLabelFilterResultsAreCorrect(input);
    }

    @Then("The user verifies that {string} is displayed in table")
    public void theUserVerifiesThatNoDataAvailableInTableIsDisplayedInTable(String message) {
        pages.tagsPage().verifyNoMatchingRecordsFoundIsDisplayed(message);
    }

    @Then("The user verifies that label filter has no value")
    public void theUserVerifiesThatLabelFilterHasNoValue() {
        pages.tagsPage().verifyLabelFilterHasNoValue();
    }

    @Then("The user verifies that id values are ascending order with no action")
    public void theUserVerifiesThatIdValuesAreAscendingOrderWithNoAction() {
        Assert.assertTrue(pages.tagsPage().areIdValuesAscending());
    }

    @When("The user clicks Id header for descending sort")
    public void theUserClicksIdHeaderForDescendingSort() {
        pages.tagsPage().clickIdHeaderForDescending();
    }

    @Then("The user verifies that id values are descending order")
    public void theUserVerifiesThatIdValuesAreDescendingOrder() {
        Assert.assertTrue(pages.tagsPage().areIdValuesDescending());
    }

    @When("The user clicks Label header for ascending sort")
    public void theUserClicksLabelHeaderForAscendingSort() {
        pages.tagsPage().clickLabelHeaderForAscendingSort();
    }

    @Then("The user verifies that Label values are ascending order")
    public void theUserVerifiesThatLabelValuesAreAscendingOrder() {
        Assert.assertTrue(pages.tagsPage().areLabelValuesAscending());
    }

    @When("The user clicks Label header for descending sort")
    public void theUserClicksLabelHeaderForDescendingSort() {
        pages.tagsPage().clickLabelHeaderForDescendingSort();
    }

    @Then("The user verifies that Label values are descending order")
    public void theUserVerifiesThatLabelValuesAreDescendingOrder() {
        Assert.assertTrue(pages.tagsPage().areLabelValuesDescending());
    }

    @When("The user clicks ItemType header for ascending sort")
    public void theUserClicksItemTypeHeaderForAscendingSort() {
        pages.tagsPage().clickItemTypeHeaderForAscendingSort();
    }

    @Then("The user verifies that ItemType values are ascending order")
    public void theUserVerifiesThatItemTypeValuesAreAscendingOrder() {
        Assert.assertTrue(pages.tagsPage().areItemTypesValuesAscending());
    }

    @When("The user clicks ItemType header for descending sort")
    public void theUserClicksItemTypeHeaderForDescendingSort() {
        pages.tagsPage().clickItemTypeHeaderForDescendingSort();
    }

    @Then("The user verifies that ItemType values are descending order")
    public void theUserVerifiesThatItemTypeValuesAreDescendingOrder() {
        Assert.assertTrue(pages.tagsPage().areItemTypesValuesDescending());
    }

    @When("The user enters {int} and {int} in to Id filter")
    public void theUserEntersAndInToIdFilter(int idFrom, int idTo) {
        pages.tagsPage().enterIdFilterValues(idFrom, idTo);
    }

    @When("The user clicks update button in Id filter")
    public void theUserClicksUpdateButtonInIdFilter() {
        pages.tagsPage().clickUpdateButtonInIdFilter();
    }

    @Then("The user verifies that ids are between {int} and {int} inclusive")
    public void theUserVerifiesThatIdsAreBetweenAndInclusive(int idFrom, int idTo) {
        pages.tagsPage().verifyIdsAreBetweenIdFromAndIdToInclusive(idFrom,idTo);
    }

    @Then("The user verifies that {string} warning is displayed")
    public void theUserVerifiesThatIdFromMustBeLessThanIdToWarningIsDisplayed(String expectedWarning) {
        pages.tagsPage().verifyIdFromMustBeLessThanIdToWarningIsDisplayed(expectedWarning);
    }

    @Then("The user verifies that Id filter has no value")
    public void theUserVerifiesThatIdFilterHasNoValue() {pages.tagsPage().verifyIdFilterHasNoValue();}

    @When("The user select {string} from Type filter")
    public void theUserSelectAccountFromTypeFilter(String option) {
        pages.tagsPage().selectValueFromTypeSelectFilter(option);
    }

    @Then("The user verifies that table has only {string} values")
    public void theUserVerifiesThatTableHasOnlyFilteredValues(String filteredValue) {
        pages.tagsPage().verifyTableHasOnlyFilteredValues(filteredValue);
    }

    @Then("The user verifies that ItemType filter has value {string}")
    public void theUserVerifiesThatItemTypeFilterHasValueTypeAll(String typeAll) {
        pages.tagsPage().verifyItemTypeFilterHasValueTypeAll(typeAll);
    }

    @Then("The user verifies that first and previous pagination buttons are inactive in first page of table in Tags page")
    public void theUserVerifiesThatFirstAndPreviousPaginationButtonsAreInactiveInFirstPageOfTableInTagsPage() {
        pages.tagsPage().verifyFirstAndPreviousButtonsAreInactiveInFirstPageOfTableInTagsPage();
    }

    @When("The user enters last page number in to pagination input box in Tags page")
    public void theUserEntersLastPageNumberInToPaginationInputBoxInTagsPage() {
        pages.tagsPage().enterLastPageNumberInToPaginationInputBox();
    }

    @Then("The user verifies that last and next pagination buttons are inactive in last page of table in Tags page")
    public void theUserVerifiesThatLastAndNextPaginationButtonsAreInactiveInLastPageOfTableInTagsPage() {
        pages.tagsPage().verifyLastAndNextButtonsAreInactiveInLastPageOfTable();
    }

    @When("The user clicks last pagination button in Tags page")
    public void theUserClicksLastPaginationButtonInTagsPage() {
        pages.tagsPage().clickLastPaginationButtonInTagsPage();
    }

    @Then("The user verifies that table is in last page in Tags page")
    public void theUserVerifiesThatTableIsInLastPageInTagsPage() {
        pages.tagsPage().verifyTableIsInLastPageInTagsPage();
    }

    @When("The user clicks first pagination button in Tags page")
    public void theUserClicksFirstPaginationButtonInTagsPage() {
        pages.tagsPage().clickFirstPaginationButton();
    }

    @Then("The user verifies that table is in first page in Tags page")
    public void theUserVerifiesThatTableIsInFirstPageInTagsPage() {
        pages.tagsPage().verifyTableIsInFirstPageInTagsPage();
    }

    @When("The user clicks next pagination button in Tags page")
    public void theUserClicksNextPaginationButtonInTagsPage() {
        pages.tagsPage().clickNextPaginationButtonInTagsPage();
    }

    @Then("The user verifies that table go to next page in Tags page")
    public void theUserVerifiesThatTableGoToNextPageInTagsPage() {
        pages.tagsPage().verifyTableGoToNextPageInTagsPage();
    }

    @When("The user clicks previous pagination button in Tags page")
    public void theUserClicksPreviousPaginationButtonInTagsPage() {
        pages.tagsPage().clickPreviousPaginationButtonInTagsPage();
    }

    @Then("The user verifies that table go to previous page in Tags page")
    public void theUserVerifiesThatTableGoToPreviousPageInTagsPage() {
        pages.tagsPage().verifyTableGoToPreviousPageInTagsPage();
    }

    @When("The user clicks tag delete button")
    public void theUserClicksTagDeleteButton() {
        pages.tagsPage().clickTagDeleteButton();
    }
}
