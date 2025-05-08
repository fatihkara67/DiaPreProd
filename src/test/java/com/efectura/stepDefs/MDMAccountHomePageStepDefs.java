package com.efectura.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MDMAccountHomePageStepDefs extends BaseStep {
    @Given("The user is on the Account item home page")
    public void the_user_is_on_the_account_item_home_page() {
        pages.accountHomePage().onTheAccountPage();
    }

    @Given("The user Associated All filter")
    public void the_user_associated_all_filter() {
        pages.accountHomePage().clickAssociatedFilter();
        pages.accountHomePage().clickAssociatedAllFilter();
    }

    @Given("The user clicks item")
    public void the_user_clicks_item() {
        pages.accountHomePage().clicksSelectFirstItem();
    }

    @Given("The user Associated No filter")
    public void the_user_associated_no_filter() {
        pages.accountHomePage().clickAssociatedFilter();
        pages.accountHomePage().clickAssociatedNoFilter();
    }

    @Then("The user verify No Filter")
    public void the_user_verify_no_filter() {
        pages.accountHomePage().verifyAssociatedNoFilter();
    }

    @Given("The user clicks Associated on filter")
    public void the_user_clicks_associated_on_filter() {

    }

    @Given("The user enters {string} info from field")
    public void the_user_enters_info_from_field(String string) {

    }

    @Given("The user enters {string} info to field")
    public void the_user_enters_info_to_field(String string) {

    }

    @Given("The user clicks update button")
    public void the_user_clicks_update_button() {

    }

    @Then("The user verifies that associated on filter functionality")
    public void the_user_verifies_that_associated_on_filter_functionality() {

    }

    @Given("The user clicks on Label Filter")
    public void the_user_clicks_on_label_filter() {

    }

    @Then("The user verifies that labet filter functionality")
    public void the_user_verifies_that_labet_filter_functionality() {

    }

    @Given("The user associated selects {string} families filter")
    public void the_user_associated_selects_families_filter(String string) {

    }

    @Then("The user verifies that families filter functionality")
    public void the_user_verifies_that_families_filter_functionality() {

    }

    @Given("The user clicks Associated status")
    public void the_user_clicks_associated_status() {

    }

    @Given("The user selects  {string}")
    public void the_user_selects(String string) {

    }

    @Then("The user verifies displayed {string} is correct")
    public void the_user_verifies_displayed_is_correct(String string) {

    }

    @Given("The user clicks on code filter Filter")
    public void the_user_clicks_on_code_filter_filter() {

    }

    @Then("The user verifies that code filter functionality")
    public void the_user_verifies_that_code_filter_functionality() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("The user clicks Reset button")
    public void the_user_clicks_reset_button() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("The user verifies that code filter reset button functionality")
    public void the_user_verifies_that_code_filter_reset_button_functionality() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("The user clicks on Fixed Point  Filter")
    public void the_user_clicks_on_fixed_point_filter() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("The user verifies that Fixed Point filter functionality")
    public void the_user_verifies_that_fixed_point_filter_functionality() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("The user clicks Export Attributes")
    public void the_user_clicks_export_attributes() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("The user clicks Export Entity Button")
    public void the_user_clicks_export_entity_button() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("The user clicks Export Associations")
    public void the_user_clicks_export_associations() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("The user clicks Export Permission")
    public void the_user_clicks_export_permission() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("The user dowloand Export Entity verifies")
    public void the_user_dowloand_export_entity_verifies() {
        // Write code here that turns the phrase above into concrete actions

    }


}
