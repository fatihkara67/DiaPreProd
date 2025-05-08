package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

public class MDMAssetHomePageSteps extends BaseStep {
    @Then("The user clicks on Asset category")
    public void the_user_clicks_on_asset_category() {
        pages.asset().clickAssetCategoryButton();
    }
    @Then("The user verify Edit Page Asset")
    public void the_user_verify_edit_page_asset() {
    pages.asset().verifyEditPage();
    }
    @Then("The User clicks on the Asset Categories element")
    public void the_user_clicks_on_the_asset_categories_element() {
        pages.asset().clickMainAssetCategories();
    }
    @Then("The User presses the down arrow key and then presses enter in the {string} element in Asset")
    public void the_user_presses_the_down_arrow_key_and_then_presses_enter_in_the_element(String family) {
        pages.asset().selectAssetFamily(family);
    }


}

