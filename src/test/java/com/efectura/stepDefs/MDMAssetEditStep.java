package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MDMAssetEditStep extends BaseStep {
    public MDMAssetEditStep() {
    }

    @Then("The user clicks list drop down button")
    public void the_user_clicks_list_drop_down_button() {
        pages.assetEditPage().clickListDropDown();
    }

    @Then("The user clicks new list item")
    public void the_user_clicks_new_list_item() {
        pages.assetEditPage().clickListItem();
    }

    @Then("The user clicks new list second item")
    public void the_user_clicks_new_list_second_item() {
        pages.assetEditPage().clickListSecondItem();
    }

    @Then("The user verifies item is added")
    public void the_user_verifies_item_is_added() {
        pages.assetEditPage().verifyEditListItem();
    }

    @Then("The user waits ten seconds")
    public void the_user_waits_ten_seconds() {
        BrowserUtils.wait(10);
    }

    @Then("The user verifies item is added allItem")
    public void the_user_verifies_item_is_added_allItem() {
        pages.assetEditPage().verifyAllItemList();
    }

    @Then("The user clicks removed button")
    public void the_user_clicks_removed_button() {
        pages.assetEditPage().clicksDeleteEditList();
    }

    @Then("The user verifies item is removed")
    public void the_user_verifies_item_is_removed() {
        pages.assetEditPage().verifyEditRemoved();
    }

    @Then("The user clicks group permission tab")
    public void clicks_group_permission_tab() {
        pages.assetEditPage().clickGroupPermission();
    }

    @Then("The user verifies previous page button is not clickable asset")
    public void the_user_verifies_previous_page_button_is_not_clickable_asset() {
        pages.assetEditPage().verifyPreviousePageIsNotClicible();
    }

    @Then("The user verifies first page button is not clickable asset")
    public void the_user_verifies_firstPage_button_is_not_clickable_asset() {
        pages.assetEditPage().verifyLeftPreviousePageIsNotClicible();
    }

    @When("The user clicks next page button asset")
    public void the_user_clicks_next_page_button_asset() {
        pages.assetEditPage().clicksNextPageButton();
    }

    @When("The user verifies next button is clickable asset")
    public void the_user_verifies_next_button_is_clickable_asset() {
        pages.assetEditPage().verifyNextPageIsClickable();
    }

    @When("The user clicks previous page button asset")
    public void the_user_clicks_previous_page_button_asset() {
        pages.assetEditPage().clickPreviousPageButton();
    }

    @When("The user verifies previous button is clickable asset")
    public void the_user_verifies_previous_button_is_clickable_asset() {
        pages.assetEditPage().verifyPreviousPageIsClickable();
    }

    @When("The user clicks last page button asset")
    public void the_user_clicks_last_page_button_asset() {
        pages.assetEditPage().clickLastPageButton();
    }

    @When("The user verifies last button is clickable asset")
    public void the_user_verifies_last_button_is_clickable_asset() {
        pages.assetEditPage().verifyLastPageIsClickable();
    }

    @When("The user verifies last button is unclickable asset")
    public void the_user_verifies_last_button_is_unclickable_asset() {
        pages.assetEditPage().verifyLastPageIsUnClickable();
    }

    @When("The user verifies next button is unclickable asset")
    public void the_user_verifies_next_button_is_unclickable_asset() {
        pages.assetEditPage().verifyNextPageIsNotClickable();
    }

    @When("The user verifies first page button is clickable asset")
    public void the_user_verifies_first_page_button_is_clickable_asset() {
        pages.assetEditPage().verifyFirstPageIsClickable();
    }

    @Then("The user clicks user permission tab")
    public void clicks_user_permission_tab() {
        pages.assetEditPage().clickUserPermission();
    }

    @Then("The user verifies first page button is not clickable user")
    public void the_user_verifies_first_page_button_is_not_clickable_user() {
        pages.assetEditPage().verifyLeftPreviousePageUserIsNotClickable();
    }

    @Then("The user verifies previous page button is not clickable user")
    public void the_user_verifies_previous_page_button_is_not_clickable_user() {
        pages.assetEditPage().verifyPreviousPageUserIsNotClickable();
    }

    @When("The user clicks next page button user")
    public void the_user_clicks_next_page_button_user() {
        pages.assetEditPage().clicksNextPageUserButton();
    }

    @When("The user verifies next button is clickable user")
    public void the_user_verifies_next_button_is_clickable_user() {
        pages.assetEditPage().verifyNextPageUserIsClickable();
    }

    @When("The user clicks previous page button user")
    public void the_user_clicks_previous_page_button_user() {
        pages.assetEditPage().clickPreviousPageUserButton();
    }

    @When("The user verifies previous button is clickable user")
    public void the_user_verifies_previous_button_is_clickable_user() {
        pages.assetEditPage().verifyPreviousPageUserIsClickable();
    }

    @When("The user clicks last page button user")
    public void the_user_clicks_last_page_button_user() {
        pages.assetEditPage().clickLastPageUserButton();
    }

    @When("The user verifies last button is clickable user")
    public void the_user_verifies_last_button_is_clickable_user() {
        pages.assetEditPage().verifyLastPageUserIsClickable();
    }

    @When("The user verifies next button is unclickable user")
    public void the_user_verifies_next_button_is_unclickable_user() {
        pages.assetEditPage().verifyNextPageUserIsUnClickable();
    }

    @When("The user verifies first page button is clickable user")
    public void the_user_verifies_first_page_button_is_clickable_user() {
        pages.assetEditPage().verifyLeftPreviousPageUserIsClickable();
    }

    @And("The user selects {string}")
    public void theUserSelects(String itemStatusOption) {
        pages.assetEditPage().selectItemStatusInAssetEditPage(itemStatusOption);
    }

    @And("The user clicks on unsaved change button")
    public void theUserClicksOnUnsavedChangeButton() {
        pages.assetEditPage().clickUnsavedChangesButton();
    }

    @And("The user clicks cancel button in ChangeItem modal")
    public void theUserClicksCancelButtonInChangeItemModal() {
        pages.assetEditPage().clickCancelButtonInChangeItemModal();
    }

    @And("The user refresh the browser")
    public void theUserRefreshTheBrowser() {
        Driver.getDriver().navigate().refresh();
        BrowserUtils.handleAlertAccept();
    }

    @And("The user verifies item status not change")
    public void theUserVerifiesItemStatusNotChange() {
        pages.assetEditPage().verifyItemStatusNotChange();
    }

    @And("The user clicks save button in ChangeItem modal")
    public void theUserClicksSaveButtonInChangeItemModal() {
        pages.assetEditPage().clickSaveButtonInChangeItemModal();
    }

    @And("The user verifies last button is unclickable user")
    public void theUserVerifiesLastButtonIsUnclickableUser() {
        pages.assetEditPage().verifyLastButtonIsUnclickableInUserPermissions();
    }

    @Then("The user verifies that {string} tab is opened")
    public void theUserVerifiesThatTabIsOpened(String tabName) {
        pages.contactHomePage().verifyTabIsOpened(tabName);
    }

    @And("The user clicks accordion button")
    public void theUserClicksAccordionButton() {
        pages.assetEditPage().clickAccordionButton();
    }
}

