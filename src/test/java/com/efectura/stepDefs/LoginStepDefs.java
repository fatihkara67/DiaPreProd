package com.efectura.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs extends BaseStep {
    public LoginStepDefs() {
    }

    @Given("I am on the MDM login page")
    public void i_am_on_the_mdm_login_page() {
        pages.loginPage().theUserIsOnTheHomePage();
    }

    @When("I enter the username {string} and password {string}")
    public void i_enter_the_username_and_password(String username, String password) {
        pages.loginPage().setUsernameField(username);
        pages.loginPage().setPasswordField(password);
    }

    @When("click on the login button")
    public void click_on_the_login_button() {
        pages.loginPage().clickLoginButton();
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedResult) {
        pages.loginPage().loginVerify(expectedResult);
    }

    @When("The user enters {string}")
    public void the_user_enters(String email) {
        pages.loginPage().setEmailBox(email);
    }

    @When("The user clicks send button")
    public void the_user_clicks_send_button() {
        pages.loginPage().clickSendButton();
    }
    @Then("The user verifies {string} text")
    public void the_user_verifies_text(String text) {
        pages.loginPage().verifyForgotPasswordErrorText(text);
    }
}
