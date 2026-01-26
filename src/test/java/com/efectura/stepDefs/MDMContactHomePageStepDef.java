package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MDMContactHomePageStepDef extends BaseStep {
    @Then("The User performs a mouseover on the Contact Management element")
    public void the_user_performs_a_mouseover_on_the_contact_management_element() {
        pages.homePage().mouseoverOnTheContactManagementElement();
    }

    @Then("The User performs a mouseover on the Contact element")
    public void the_user_performs_a_mouseover_on_the_contact_element() {
        pages.homePage().mouseoverOnTheContactElement();
    }

    @Then("The User clicks on the Contact element")
    public void the_user_clicks_on_the_contact_element() {
        pages.homePage().clicksOnTheContactElement();
    }

    @Then("The User waits until the  Contact element is visible with a timeout of {int} seconds")
    public void the_user_waits_until_the_contact_element_is_visible_with_a_timeout_of_seconds(Integer timeout) {
        pages.contactHomePage().verifyContactCategories(timeout);
    }

    @Then("The User clicks on the Contact Categories element")
    public void the_user_clicks_on_the_contact_categories_element() {
        pages.contactHomePage().clickContactCategories();
    }

    @Then("The User clicks on the new node element Contact")
    public void the_user_clicks_on_the_new_node_element_contact() {
        pages.contactHomePage().clickContactNewNode();
    }

    @Then("The user enters a DIA_FirstName {string} input fields")
    public void the_user_enters_a_dıa_first_name_input_fields(String DIA_firstName) {
        pages.contactHomePage().setDIA_FirstName(DIA_firstName);
    }

    @Then("The user enters a Surname {string}\" input fields")
    public void the_user_enters_a_surname_input_fields(String surname) {
        pages.contactHomePage().setSurname(surname);
    }

    @Then("The user clicks on Contact  category")
    public void the_user_clicks_on_contact_category() {
        pages.contactHomePage().clickContactCategoryButton();
    }


    @Then("The user verifies that the codes shown in the Contact label filter are contact categories")
    public void the_user_verifies_that_the_codes_shown_in_the_contact_label_filter_are_contact_categories() {
        pages.contactHomePage().verifyContactCategory();
    }

    @Then("The user clicks on New node")
    public void the_user_clicks_on_new_node() {
        pages.contactHomePage().clickNewNodeCategoryButton();
    }

    @Then("The user verifies that the codes shown in the New Node label filter are contact categories")
    public void the_user_verifies_that_the_codes_shown_in_the_new_node_label_filter_are_contact_categories() {
        pages.contactHomePage().VerifyNewNodeCategory();
    }

    @Then("The user clicks on Unassigned Records Category category")
    public void the_user_clicks_on_unassigned_records_category_category() {
        pages.contactHomePage().clickUnassignedRecords();
    }

    @Then("The user verifies that the codes shown in the Unassigned label filter are contact categories")
    public void the_user_verifies_that_the_codes_shown_in_the_unassigned_label_filter_are_contact_categories() {

    }

    @Then("The User performs a mouseover on the Kisiler element")
    public void the_user_performs_a_mouseover_on_the_kisiler_element() {
        pages.homePage().mouseoverOnTheKisilerElement();
    }

    @Then("The user enters {string} into Code field")
    public void the_user_enters_into_code_field(String code) {
        pages.contactHomePage().setCodeFilter(code);
    }

    @Then("The User inputs the {string} from cont into the inputCode field")
    public void the_user_inputs_the_from_cont_into_the_input_code_field(String code) {
        pages.contactHomePage().setUniqueCodeElement(code);
    }

    @Then("The user clicks on Search button")
    public void the_user_clicks_on_search_button() {
        BrowserUtils.wait(1);
        pages.contactHomePage().clickSearchButton();
        BrowserUtils.wait(2);
    }

    @Then("The user verify on code filter functionality {string}")
    public void the_user_verify_on_code_filter_functionality(String code) {
        pages.contactHomePage().verifyCodeFilter(code);
    }

    @Then("the user verify on code filter functionality with partial unique code {string}")
    public void the_user_verify_on_code_filter_functionality_with_partial_unique_code(String partialCode) {
        pages.contactHomePage().verifyPartialCodeFilters(partialCode);
    }

    @Then("the user verify on code filter functionality  with invalid unique code {string}")
    public void the_user_verify_on_code_filter_functionality_with_invalid_unique_code(String text) {
        pages.contactHomePage().verifyNoContentTextInvalidUniqueCode(text);
    }

    @Then("The user enters {string} into Label field")
    public void the_user_enters_into_label_field(String label) {
        pages.contactHomePage().setLabelFilter(label);
    }

    @Then("the user verify on label filter functionality with partial unique code {string}")
    public void the_user_verify_on_label_filter_functionality_with_partial_unique_code(String partialLabel) {
        pages.contactHomePage().verifyPartialLabelFilters(partialLabel);
    }

    @Then("the user verify on family filter Ekosystem functionality")
    public void the_user_verify_on_family_filter_ekosystem_functionality() {
        pages.contactHomePage().verifyFamilyFilter();
    }

    @Then("The user clicks on Ekosystem Filtre")
    public void the_user_clicks_on_ekosystem_filtre() {
        pages.contactHomePage().selectEkosystemFamilyFilter();
    }

    @Then("The user clicks on IWSA Filtre")
    public void the_user_clicks_on_ıwsa_filtre() {
        pages.contactHomePage().selectIWSAFamilyFilter();
    }

    @Then("the user verify on family filter IWSA functionality")
    public void the_user_verify_on_family_filter_ıwsa_functionality() {
        pages.contactHomePage().verifyIWSAFamilyFilter();
    }

    @Then("The user clicks on ItemStatuses")
    public void the_user_clicks_on_ItemStatuses() {
        pages.contactHomePage().clicksItemStatus();
    }

    @Then("The user clicks on {string}")
    public void the_user_clicks_on(String itemStatus) {
        pages.campaignHomePage().selectOptionOfItemStatus(itemStatus);
    }

    @Then("the incoming filter for {string} should contain")
    public void the_incoming_filter_for_should_contain(String itemStatus) {
        pages.contactHomePage().verifyItemStatuses(itemStatus);
    }

    @Then("the user clicks on Reset button")
    public void the_user_clicks_on_reset_button() {
        pages.contactHomePage().clicksResetButton();
    }

    @Then("the user verify Reset button functionality")
    public void the_user_verify_reset_button_functionality() {
        pages.contactHomePage().verifyResetButton();
    }

    @Then("The user clicks on Delete")
    public void the_user_clicks_on_delete() {
        pages.contactHomePage().clickDeleteButton();
    }

    @Then("The user declines the popup message")
    public void the_user_declines_the_popup_message() {
        pages.contactHomePage().declineDeletePopUp();
    }

    @Then("The user verify that {string} is visible")
    public void the_user_verify_that_is_visible(String code) {
        pages.contactHomePage().verifyDeletingObject(code);
    }

    @Then("The user accepts the popup message")
    public void the_user_accepts_the_popup_message() {
        pages.contactHomePage().acceptDeletePopUp();
    }

    @Then("The user should see the message")
    public void the_user_should_see_the_message() {
        pages.contactHomePage().verifyDeleteMessage();
    }

    @Given("The user clicks show entries button")
    public void the_user_clicks_show_entries_button() {
        pages.contactHomePage().clickShowEntrie();
    }

    @When("The user selects {string} into show entries")
    public void the_user_selects_into_show_entries(String entrie) {
        pages.contactHomePage().selectEntrie(entrie);
    }

    @Then("The user should see  {string} entrie in everypage")
    public void the_user_should_see_entrie_in_everypage(String entrie) {
        pages.contactHomePage().verifySelectOption(entrie);
    }

    @Then("The user clicks on Edit Button")
    public void the_user_clicks_on_editButton() {
        pages.contactHomePage().clickEditButton();
    }

    @Then("The user verify Edit Page")
    public void the_user_verify_edit_page() {
        pages.contactHomePage().verifyEditPage();
    }

    @Then("The user verifies that {string} is visible")
    public void the_user_verifies_that_is_visible(String starFeature) {
        pages.contactHomePage().verifyStarFeatures(starFeature);
    }

    @Then("The user verifies that the badge count for feature is correct")
    public void the_user_verifies_that_the_badge_count_for_is_correct() {
        pages.contactHomePage().verifyStarFeatureBadgeCount();
    }

    @Then("the user clicks on Star items")
    public void the_user_clicks_on_star_items() {
        pages.contactHomePage().clickStarItems();
    }

    @Then("the user verify My Count badge count is correct")
    public void the_user_verify_my_count_badge_count_is_correct() {
        pages.contactHomePage().verifyMyCountsBadgeCount();
    }

    @When("The user clicks on Export button")
    public void the_user_clicks_on_export_button() {
        pages.contactHomePage().clickExportButton();
    }

    @Then("The user verify that the export was {string}")
    public void the_user_verify_that_the_export_was(String successMessage) {
        pages.contactHomePage().verifyExportSuccessMessage(successMessage);
    }

    @Then("The user verify that the file is located in the downloads folder")
    public void the_user_verify_that_the_file_is_located_in_the_downloads_folder() {
        pages.contactHomePage().verifyExportedFile();
    }

    @Then("The user verify that the file is in the correct format")
    public void the_user_verify_that_the_file_is_in_the_correct_format() {
        pages.contactHomePage().verifyExportedFileFormat();
    }

    @When("The user clicks My Contact button")
    public void the_user_clicks_my_contact_button() {
        pages.contactHomePage().clickMyContactButton();
    }

    @When("The user clicks last page button")
    public void the_user_clicks_last_page_button() {
        pages.contactHomePage().clickLastPageButton();
    }

    @Then("The user verifies first page button is not clickable")
    public void the_user_verifies_first_page_button_is_not_clickable() {
        pages.contactHomePage().verifyFirstPageButtonUnClickable();
    }

    @Then("The user verifies previous page button is not clickable")
    public void the_user_verifies_previous_page_button_is_not_clickable() {
        pages.contactHomePage().verifypreviousPageButtonUnClickability();
    }

    @Then("The user verifies last page button is not clickable")
    public void the_user_verifies_last_page_button_is_not_clickable() {
        pages.contactHomePage().verifyLastPageButtonClickability();
    }

    @Given("The user clicks {string}")
    public void the_user_clicks(String starFeature) {
        pages.contactHomePage().clicksStarFeatures(starFeature);

    }

    @When("The user verifies first page button is clickable")
    public void the_user_verifies_first_page_button_is_clickable() {
        pages.contactHomePage().verifyFirstPageButtonClickable();
    }

    @When("The user verifies previous page button is clickable")
    public void the_user_verifies_previous_page_button_is_clickable() {
        pages.contactHomePage().verifyPreviousPageButtonClickable();
    }

    @When("The user verifies next button is clickable")
    public void the_user_verifies_next_button_is_clickable() {
        pages.contactHomePage().verifyNextPageButtonClickable();
    }

    @When("The user verifies last page button is clickable")
    public void the_user_verifies_last_page_button_is_clickable() {
        pages.contactHomePage().verifyLastPageButtonClickable();
    }

    @When("The user clicks {string} tab")
    public void the_user_clicks_tab(String tabName) {
        BrowserUtils.adjustScreenSize(50, Driver.getDriver());
        pages.contactHomePage().clickEditItemTab(tabName);
        BrowserUtils.wait(2);
    }

    @Then("The user verifies preview tab details is displayed")
    public void the_user_verifies_preview_tab_details_is_displayed() {
        pages.contactHomePage().verifyPreviewTab();
    }

    @Then("The user verifies itemComment tab details is displayed")
    public void the_user_verifies_itemComment_tab_details_is_displayed() {
        pages.contactHomePage().verifyItemCommentTab();
    }

    @Then("The user verifies My Account tab details is displayed")
    public void the_user_verifies_My_Account_tab_details_is_displayed() {
        pages.contactHomePage().verifyMyAccountTab();
    }

    @When("The user clicks on Export button ediitem")
    public void the_user_clicks_on_export_button_ediitem() {
        pages.contactHomePage().exportButtonEditItem();
    }

    @Then("The user selects deleted element-asset")
    public void the_user_selects_deleted_element_asset() {
        pages.asset().clickDeleteButtonOtomasyon();
    }

    @Then("The user clicks cancel button in delete popup-asset")
    public void the_user_clicks_cancel_button_in_delete_popup_asset() {
        pages.asset().clickCancelButtonPopUpOtomasyon();
    }

    @Then("The user clicks update on tab")
    public void the_user_clicks_update_on_tab() {
        pages.contactHomePage().clickUpdateOn();
    }

    @Then("The user verifies that dates are sorted from {string}")
    public void the_user_verifies_that_dates_are_sorted_from(String sorting) {
        pages.contactHomePage().updateOnSorting(sorting);
    }

    @Then("The user clicks create on tab")
    public void the_user_clicks_create_on_tab() {
        pages.contactHomePage().clickCreateOn();
    }

    @Then("The user verifies that dates are sorted from {string} create on")
    public void the_user_verifies_that_dates_are_sorted_from_create_on(String sorting) {
        pages.contactHomePage().createOnSorting(sorting);
    }

    @Then("The user clicks id tab")
    public void the_user_clicks_id_tab() {
        pages.contactHomePage().clickIdTabSorting();
    }

    @Then("The user verifies sort id numbers from {string}")
    public void the_user_verifies_sort_id_numbers_from(String sorting) {
        pages.contactHomePage().idTabSorting(sorting);
    }

    @Then("The user clicks birthdate on tab")
    public void the_user_clicks_birthdate_on_tab() {
        pages.contactHomePage().clickBirthdateTabSorting();
    }

    @Then("The user verifies that birthdate are sorted from {string}")
    public void the_user_verifies_that_birthdate_are_sorted_from(String sorting) {
        pages.contactHomePage().birthdateSorting(sorting);
    }

    @And("The user clicks on the Root Checkbox")
    public void theUserClicksOnTheRootCheckbox() {
        pages.contactHomePage().clickRootCheckbox();
    }

    @And("The User clicks on the Genel category")
    public void theUserClicksOnTheGenelCategory() {
        pages.contactHomePage().clickGenelCategoryCheckBox();
    }

    @And("The user enters required fields in CreateNewContact modal")
    public void theUserEntersRequiredFieldsInCreateNewContactModal() {
        pages.contactHomePage().fillRequiredFieldsInCreateNewContactModal("1", "Fatih", "KARA");
    }
}