package com.efectura.stepDefs;


import com.efectura.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MDMContractStepDefs extends BaseStep {
    public MDMContractStepDefs() {
    }

    @When("The User opens the browser with the given url")
    public void the_user_opens_the_browser_with_the_given_url() {
    }

    @When("The User inputs a valid username {string}")
    public void the_user_inputs_a_valid_username(String username) {
        pages.loginPage().setUsernameField(username);
    }

    @When("The User inputs a valid password {string}")
    public void the_user_inputs_a_valid_password(String password) {
        pages.loginPage().setPasswordField(password);

    }

    @When("The User clicks the Submit button")
    public void the_user_clicks_the_submit_button() {
        pages.loginPage().clickLoginButton();
    }


    @Then("The User waits until the MDM element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_mdm_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.homePage().verifyMDMElement(timeout);
    }

    @Then("The User performs a mouseover on the MDM element")
    public void the_user_performs_a_mouseover_on_the_mdm_element() {
        pages.homePage().mouseoverOnTheMdmElement();
    }

    @Then("The User performs a mouseover on the Contract Management element")
    public void the_user_performs_a_mouseover_on_the_contract_management_element() {
        pages.homePage().mouseoverOnTheContractManagementElement();
    }

    @Then("The User performs a mouseover on the Contract element")
    public void the_user_performs_a_mouseover_on_the_contract_element() {
        pages.homePage().mouseoverOnTheContractElement();
    }

    @Then("The User clicks on the Contract element")
    public void the_user_clicks_on_the_contract_element() {
        pages.homePage().clicksOnTheContractElement();
    }

    @Then("The User gets the current URL and stores it in {string}")
    public void the_user_gets_the_current_url_and_stores_it_in(String partialUrl) {
        pages.homePage().currentUrlAndStoresItInUrl(partialUrl);
    }

    @Then("The User waits until the createItem element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_create_item_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.contract().verifyCreateNewItemButton(timeout);
    }

    @When("The user clicks sign in with microsoft button")
    public void the_user_clicks_sign_in_with_microsoft_button() {
        pages.loginPage().clickSignInWithMicrosoftButton();
    }

    @Then("The User clicks on the createItem element")
    public void the_user_clicks_on_the_create_ıtem_element() {
        pages.contract().clickCreateNewItemButton();
    }

    @Then("The User waits until the uniqueCode element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_unique_code_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.contract().verifyUniqueCodeElement(timeout);
    }

    @Then("The User inputs the value from cont into the inputCode field")
    public void the_user_inputs_the_value_from_cont_into_the_input_code_field() {
        pages.contract().setUniqueCodeElement();
    }

    @Then("The User presses the down arrow key and then presses Enter in the Choose Family element")
    public void the_user_presses_the_down_arrow_key_and_then_presses_enter_in_the_choose_family_element() {
        pages.contract().selectChooseFamily();
    }

    @Then("The User waits until the page contains {string} with a timeout of {int} seconds")
    public void the_user_waits_until_the_page_contains_with_a_timeout_of_seconds(String text, Integer timeout) {
        pages.contract().verifyCreateItemMessage(text, timeout);
    }

    @Then("The User waits until the  ROOT element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_root_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.contract().verifyRootCategories(timeout);
    }

    @Then("The User clicks on the ROOT element")
    public void the_user_clicks_on_the_root_element() {
        pages.contract().clickRootCategories();
    }

    @Then("The User clicks on the Categories element")
    public void the_user_clicks_on_the_categories_element() {
        pages.contract().clickCategoriesButton();
    }

    @Then("The User clicks on the createButton element")
    public void the_user_clicks_on_the_create_button_element() {
        pages.contract().clickCreateButton();
    }

    @Then("The User waits until the page contains {string} with a timeout of {int} seconds-asset")
    public void the_user_waits_until_the_page_contains_with_a_timeout_of_seconds_asset(String text, Integer timeout) {
        pages.asset().verifyAssetEmptyFamilyText(text, timeout);
    }

    @Then("The User presses the down arrow key and then presses Enter in the Contract_Family element")
    public void the_user_presses_the_down_arrow_key_and_then_presses_enter_in_the_contract_family_element() {
        pages.contract().selectContractFamily();
    }

    @Then("The User waits until the page contains {string} text with a timeout of {int} seconds")
    public void the_user_waits_until_the_page_contains_text_with_a_timeout_of_seconds(String text, Integer timeout) {
        pages.contract().verifyEmptyCategories(text, timeout);
    }

    @Then("The User clicks on the cancelButton element")
    public void the_user_clicks_on_the_cancel_button_element() {
        pages.contract().clickCancelButton();
    }

    @Then("The User inputs the value from cont into the inputCode field-{string}")
    public void the_user_inputs_the_value_from_cont_into_the_input_code_field(String uniqueCode) {
        pages.contactHomePageMyContactPage().setUniqueCodeElement(uniqueCode);
    }

    @Then("The User presses the down arrow key and then presses Enter in the {string} element")
    public void the_user_presses_the_down_arrow_key_and_then_presses_enter_in_the_element(String family) {
        pages.contactHomePage().selectEkosystemFamily(family);

    }


}





