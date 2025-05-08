package com.efectura.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FamiliesOcerviewStepDefs extends BaseStep{
    public FamiliesOcerviewStepDefs() {
    }

    @Then("The User waits until the Settings element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_settings_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.homePage().verifySettingsElement(timeout);    }
    @Then("The User performs a mouseover on the Settings element")
    public void the_user_performs_a_mouseover_on_the_Settings_element() {
        pages.homePage().mouseoverOnTheSettingsElement();
    }
    @Then("The User clicks on the Families element")
    public void the_user_clicks_on_the_families_element() {
       pages.homePage().clicksOnTheFamiliesElement();
    }
    @Then("The User verifies Families page table is displayed")
    public void the_user_verifies_families_page_table_is_displayed() {
      pages.families().verifyFamilyPage();
    }
    @Then("The user enters {string} into Code field-Settings Families")
    public void the_user_enters_into_code_field_(String code) {
    pages.families().setCodeField(code);
    }
    @Then("the user verify Reset button functionality-Settings Families")
    public void the_user_verify_reset_button_functionality() {
pages.families().verifyResetButton();
    }
    @Given("The user clicks show entries button families")
    public void the_user_clicks_show_entries_button_families() {
pages.families().clickShowEntries();
    }
    @When("The user selects {string} into show entries families")
    public void the_user_selects_into_show_entries_families(String entrie) {
pages.families().selectEntrie(entrie);
    }
    @Then("The user should see  {string} entrie in everypage families")
    public void the_user_should_see_entrie_in_everypage_families(String entrie) {
pages.families().verifySelectOption(entrie);
    }
    @Then("The user verifies first page button is not clickable-families")
    public void the_user_verifies_first_page_button_is_not_clickable() {
        pages.families().verifyFirstPageButtonUnClickable();
    }
    @Then("The user verifies first page button is clickable-families")
    public void the_user_verifies_first_page_button_is_clickable() {
        pages.families().verifyFirstPageButtonClickable();
    }
    @Then("The user verifies previous page button is not clickable-families")
    public void the_user_verifies_previous_page_button_is_not_clickable() {
        pages.families().verifyPreviousPageButtonUnClickable();
    }
    @Then("The user verifies previous page button is clickable-families")
    public void the_user_verifies_previous_page_button_is_clickable() {
        pages.families().verifyPreviousPageButtonClickable();
    }
    @When("The user clicks last page button-families")
    public void the_user_clicks_last_page_button_families() {
     pages.families().clickLastPage();
    }
    @When("The user verifies next button is not clickable-families")
    public void the_user_verifies_next_button_is_not_clickable_families() {
       pages.families().verifyNextPageButtonUnClickable();
    }
    @When("The user verifies next button is clickable-families")
    public void the_user_verifies_next_button_is_clickable_families() {
        pages.families().verifyNextPageButtonClickable();
    }
    @When("The user verifies last page button is not clickable-families")
    public void the_user_verifies_last_page_button_is_not_clickable_families() {
        pages.families().verifyLastPageButtonUnClickable();
    }

    @When("The user verifies last page button is clickable-families")
    public void the_user_verifies_last_page_button_is_clickable_families() {
        pages.families().verifyLastPageButtonClickable();
    }


    @Given("The user on the settings families page")
    public void the_user_on_the_settings_families_page() {
       pages.families().onTheFamiliesSettingPage();
    }
}
