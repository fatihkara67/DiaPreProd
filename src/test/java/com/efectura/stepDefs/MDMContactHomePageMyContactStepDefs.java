package com.efectura.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MDMContactHomePageMyContactStepDefs extends BaseStep {
    public MDMContactHomePageMyContactStepDefs() {
    }
    @When("The user verifies its contacts is displayed")
    public void the_user_verifies_its_contacts_is_displayed() {
        pages.contactHomePageMyContactPage().verifyMyContact();
    }
    @When("The user clicks item next button")
    public void the_user_clicks_item_next_button() {
       pages.contactHomePageMyContactPage().clickItemNextButton();
    }
    @Then("The user verify next items is displayed")
    public void the_user_verify_next_items_is_displayed() {
    pages.contactHomePageMyContactPage().verifyItemNextShowingEntriesText();
    }

    @When("The user clicks item previous button")
    public void the_user_clicks_item_previous_button() {
        pages.contactHomePageMyContactPage().clickItemPreviousButton();
    }
    @Then("The user verify previous items is displayed")
    public void the_user_verify_previous_items_is_displayed() {
       pages.contactHomePageMyContactPage().verifyItemPreviousShowingEntriesText();
    }
    @When("The user verifies next button is not clickable")
    public void the_user_verifies_next_button_is_not_clickable() {
        pages.contactHomePageMyContactPage().verifyNextPageButtonUnClickable();

    }
    @When("The user verifies previous button is not clickable")
    public void the_user_verifies_previous_button_is_not_clickable() {
        pages.contactHomePageMyContactPage().verifyItemPreviousButtonUnclickable();
    }
    @When("The user verifies left previous button is not clickable")
    public void the_user_verifies_left_previous_button_is_not_clickable() {
       pages.contactHomePageMyContactPage().verifyItemLeftPreviousButtonUnclickable();
    }


    @And("The user enters last interaction day {string}")
    public void theUserEntersLastInteractionDay(String interactionDay) {
        pages.contactHomePage().enterLastInteractionDay(interactionDay);
    }

    @And("The user general iwsa checkbox")
    public void theUserGeneralIwsaCheckbox() {
        pages.contactHomePage().selectGeneralIwsaCheckbox();
    }
}
