package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlackListHomePageStepDefs extends BaseStep {
    @Then("The User waits until the System element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_system_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.homePage().verifySystemElementSymbol(timeout);
    }

    @Then("The User performs a mouseover on the System element symbol")
    public void the_user_performs_a_mouseover_on_the_system_element_symbol() {
        pages.homePage().mouseoverOnTheSystemElementSymbol();
    }

    @Then("The User performs a mouseover on the System element")
    public void the_user_performs_a_mouseover_on_the_system_element() {
        pages.homePage().mouseoverOnTheSystemElement();
    }

    @Then("The User performs a mouseover on the BlackList element")
    public void the_user_performs_a_mouseover_on_the_black_list_element() {
        pages.homePage().mouseoverOnTheBlackListElement();
    }

    @Then("The User clicks on the BlackList element")
    public void the_user_clicks_on_the_black_list_element() {
        pages.homePage().clickBlackListElement();
    }

    @Then("The User waits until the black list create element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_black_list_create_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.blackListPage().verifyBlackListNewCreateButton(timeout);
    }

    @Then("The User clicks on the black list create new element")
    public void the_user_clicks_on_the_black_list_create_new_element() {
        pages.blackListPage().clickBlackListNewCreateButton();
    }

    @Then("The User waits until the page contains {string}")
    public void the_user_waits_until_the_page_contains(String text) {
        pages.blackListPage().verifySavedText(text);
    }

    @When("The user clicks on Create New")
    public void the_user_clicks_on_create_new() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The user clicks a phone Number into field {string}")
    public void the_user_clicks_a_phone_number_into_field(String phone) {
        BrowserUtils.wait(5);
        pages.blackListPage().setPhoneNumber(phone);
    }

    @When("The user clicks a last6DigitOfCard nto field {string}")
    public void the_user_clicks_a_last6digit_of_card_nto_field(String card) {
        BrowserUtils.wait(5);
        pages.blackListPage().setCardNumber(card);
    }

    @When("The User clicks on the Add button element")
    public void the_user_clicks_on_the_add_button_element() {
        BrowserUtils.wait(5);
        pages.blackListPage().clickAddButton();
    }
    @Then("The User clicks on the Cancel button element")
    public void the_user_clicks_on_the_cancel_button_element() {
        pages.blackListPage().clickCancelButton();
    }
    @Then("The user clicks a filter phone number")
    public void the_user_clicks_a_filter_phone_number() {
    }
    @Then("The user enters {string} filter phone number field")
    public void the_user_enters_filter_phone_number_field(String number) {

    }
    @When("The user enters {string} into the phone number field")
    public void the_user_enters_into_the_phone_number_field(String phoneNumber) {
      pages.blackListPage().setPhoneNumberField(phoneNumber);
    }
    @Then("The user verifies that {string} is visible in blackList")
    public void the_user_verifies_that_is_visible_in_black_list(String phoneNumber) {
        pages.blackListPage().verifyPhoneNumber(phoneNumber);
    }
    @When("the user verify Reset button functionality in blackList")
    public void the_user_verify_reset_button_functionality_in_black_list() {
        pages.blackListPage().verifyResetButton();
    }
    @When("The user clicks on delete button")
    public void the_user_clicks_on_delete_button() {
        pages.blackListPage().clickDeleteButton();
    }
    @When("The user clicks on cancel button in popup")
    public void the_user_clicks_on_cancel_button_in_popup() {
        pages.blackListPage().clickCancelButtonPopup();
    }
    @Then("The user verify the number {string} is visible")
    public void the_user_verify_the_number_is_visible(String phoneNumber) {
        pages.blackListPage().verifyPhoneNumber(phoneNumber);
    }
    @Then("The user verify the number {string} is visible-cancel")
    public void the_user_verify_the_number_is_visible_cancel(String phoneNumber) {
        pages.blackListPage().verifyPhoneNumberCancel(phoneNumber);
    }
    @When("The user clicks on delete button in popup")
    public void the_user_clicks_on_delete_button_in_popup() {
     pages.blackListPage().clickDeleteButtonPopup();
    }
    @Then("The user verify the number {string} is deleted")
    public void the_user_verify_the_number_is_deleted(String string) {
    pages.blackListPage().verifyActiveBlackListButton();
    }
    @When("The user enters {string} into the passive phone number field")
    public void the_user_enters_into_the_passive_phone_number_field(String phoneNumber) {
        pages.blackListPage().setPassivePhoneNumberField(phoneNumber);
    }
    @When("The user clicks on active button")
    public void the_user_clicks_on_active_button() {
     pages.blackListPage().clickActiveButton();
    }
    @When("The user clicks on cancel button in active popup")
    public void the_user_clicks_on_cancel_button_in_active_popup() {
    pages.blackListPage().clickCancelButtonActivePopup();
    }
    @When("The user clicks active button in popup")
    public void the_user_clicks_active_button_in_popup() {
       pages.blackListPage().clickActiveButtonPopup();
    }
    @Then("The user verify the number {string} is activated")
    public void the_user_verify_the_number_is_activated(String string) {
       pages.blackListPage().verifyActiveText();
    }
    @When("The user enters {string} into the card number field")
    public void the_user_enters_into_the_card_number_field(String cardNumber) {
        pages.blackListPage().setCardNumberField(cardNumber);
    }
    @When("The user enters {string} into the passive card number field")
    public void the_user_enters_into_the_passive_card_number_field(String cardNumber) {
        pages.blackListPage().setPassiveCardNumberField(cardNumber);
    }
    @When("The user clicks forgot your password button")
    public void the_user_clicks_forgot_your_password_button() {
    pages.loginPage().clickForgotYourPassword();
    }
    @When("The user clicks return to login page")
    public void the_user_clicks_return_to_login_page() {
    pages.loginPage().clickReturnToLoginPageText();
    }

    @Given("The user on the black list users page")
    public void the_user_on_the_black_list_users_page() {
        pages.blackListPage().onTheBlackListPage();
    }

}