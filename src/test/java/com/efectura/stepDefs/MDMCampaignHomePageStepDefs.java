package com.efectura.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MDMCampaignHomePageStepDefs extends BaseStep {
    public MDMCampaignHomePageStepDefs() {
    }

    @Then("The User performs a  mouseover on the Campaign Management element")
    public void the_user_performs_a_mouseover_on_the_campaign_management_element() {
        pages.homePage().mouseoverOnTheCampaignManagementElement();
    }

    @Then("The User performs a  mouseover on the Campaign element")
    public void the_user_performs_a_mouseover_on_the_campaign_element() {
        pages.homePage().mouseoverOnTheCampaignElement();
    }

    @Then("The User clicks on the Campaign element")
    public void the_user_clicks_on_the_campaign_element() {
        pages.homePage().clicksOnTheCampaignElement();
    }

    @Then("The user verify on code filter functionality {string}-Campaign")
    public void the_user_verify_on_code_filter_functionality_campaign(String code) {
        pages.campaignHomePage().verifyCampaignCodeFilter(code);
    }

    @Then("the user verify on code filter functionality with partial unique code {string}- Campaign")
    public void the_user_verify_on_code_filter_functionality_with_partial_unique_code_campaign(String partialCode) {
        pages.campaignHomePage().verifyCodeFilterFunctionalityWithPartialCode(partialCode);
    }

    @Then("the user verify on label filter functionality with partial unique code {string}- Campaign")
    public void the_user_verify_on_label_filter_functionality_with_partial_unique_code_campaign(String partialLabel) {
        pages.campaignHomePage().verifyLabelFilterFunctionalityWithPartialLabel(partialLabel);
    }

    @Then("The user verify that {string} is visible-campaign")
    public void the_user_verify_that_is_visible(String code) {
        pages.campaignHomePage().verifyDeletingObject(code);
    }

    @And("The user clicks delete icon of list {string}")
    public void theUserClicksDeleteIconOfList(String listName) {
        pages.campaignHomePage().clickDeleteButtonOfList(listName);
    }
}
