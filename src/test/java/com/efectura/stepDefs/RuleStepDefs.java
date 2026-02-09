package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RuleStepDefs extends BaseStep {

    @When("The User is on the Similar overview")
    public void theUserIsOnSimilarOverview() {
        //pages.membershipAccountRulePage().goToItemOverview(itemName);
        pages.membershipAccountRulePage().goToSimilarOverview();
    }

    @When("The user go in to item {string}")
    public void theUserGoInToItem(String itemId) {
        pages.membershipAccountRulePage().goToItemEditPage(itemId);
    }

    @When("The user click rule tab")
    public void theUserClickRuleTab() {
        pages.editItemPage().clickRuleTab();
    }

    @When("The user sets a rule")
    public void theUserSetsARule() {
        pages.membershipAccountRulePage().setARule();
    }

    @When("The user clicks view list button")
    public void theUserClicksViewListButton() {
        pages.membershipAccountRulePage().clickViewListButton();
    }

    @When("The user set an item in rule which is not in rule")
    public void theUserSetAnItemInRuleWhichIsNotInRule() {
        pages.membershipAccountRulePage().setAnItemInRuleWhichIsNotInRule();
    }

    @When("The user clicks Set Rules button")
    public void theUserClicksSetRulesButton() {
        pages.membershipAccountRulePage().clickSetRulesButton();
    }

    @Then("The item that is set in rule should appear in InList")
    public void theItemThatIsSetInRuleShouldAppearInInList() {
        pages.membershipAccountRulePage().verifyTheItemThatIsSetInRuleIsAppearInInList();
    }

    @Then("The item that is set in rule should been associated according to {string}")
    public void theItemThatIsSetInRuleShouldBeenAssociatedAccordingTo(String tabName) {
        pages.membershipAccountRulePage().verifyTheItemThatIsSetInRuleIsAssociated(tabName);
    }

    @Then("The user tear down all rules {string}")
    public void theUserTearDownAllRules(String itemId) {
        Driver.getDriver().get("https://sandbox-ui.efectura.com/Enrich/EditItem/" + ConfigurationReader.getProperty(itemId));
        pages.editItemPage().clickRuleTab();
        pages.membershipAccountRulePage().tearDownAllChanges();
    }

    @When("The user sets two rule with or operator")
    public void theUserSetsTwoRuleWithOrOperator() {
        pages.membershipAccountRulePage().setTwoRuleWithOrOperator();
    }

    @Then("The user edit an account to meet the rules {string}")
    public void theUserEditAnAccountToMeetTheRules(String attributeValueToChange) {
        pages.membershipAccountRulePage().editAnAccountToMeetTheRules(attributeValueToChange);
    }

    @Then("The user verifies that the edited item is associated {string} {string}")
    public void theUserVerifiesThatTheEditedItemIsAssociated(String tabName, String itemIdForRule) {
        pages.membershipAccountRulePage().verifyEditedItemIsAssociated(tabName,itemIdForRule);
    }

    @When("The user click Calculate button")
    public void theUserClickCalculateButton() {
        pages.membershipAccountRulePage().clickCalculateButton();
    }

    @Then("The user delete changes for item")
    public void theUserDeleteChangesForItem() {
        pages.membershipAccountRulePage().deleteItemChanges();
    }


    @Then("The user verifies that association of this item is removed {string} {string}")
    public void theUserVerifiesThatAssociationOfThisItemIsRemoved(String tabName, String itemIdForRule) {
        pages.membershipAccountRulePage().verifyAssociationOfTheItemRemoved(tabName,itemIdForRule);
    }

    @When("The user set an item out rule which is in rule")
    public void theUserSetAnItemOutRuleWhichIsInRule() {
        pages.membershipAccountRulePage().setItemOutRuleWhichIsInRule();
    }

    @Then("The item that is set out rule should appear in NotInList")
    public void theItemThatIsSetOutRuleShouldAppearInNotInList() {
        pages.membershipAccountRulePage().verifyTheItemThatIsSetOutRuleIsAppearInInList();
    }

    @Then("The item that is set out rule should not been associated {string} {string}")
    public void theItemThatIsSetOutRuleShouldNotBeenAssociated(String tabName,String itemIdForRule) {
        pages.membershipAccountRulePage().verifyItemThatIsSetOutRuleNotAssociated(tabName,itemIdForRule);
    }

    @When("The user sets two different rule with or")
    public void theUserSetsTwoDifferentRuleWithOr() {
        pages.membershipAccountRulePage().setTwoDifferentRuleWithOr(pages);
    }

    @Then("The user verify detail info of associated items for or {string}")
    public void theUserVerifyDetailInfoOfAssociatedItemsForOr(String tabName) {
        pages.membershipAccountRulePage().verifyDetailInfoOfAssociatedItemsForOr(tabName);
    }

    @Then("The user go to rule association tab {string}")
    public void theUserGoToRuleAssociationTab(String tabName) {
        BrowserUtils.wait(5);
        pages.editItemPage().goToRuleAssociationTab(tabName);
    }

    @When("The user sets two different rule with and")
    public void theUserSetsTwoDifferentRuleWithAnd() {
        pages.membershipAccountRulePage().setTwoDifferentRuleWithAnd();
    }

    @Then("The user verify detail info of associated items for and")
    public void theUserVerifyDetailInfoOfAssociatedItemsForAnd() {
        pages.membershipAccountRulePage().verifyDetailInfoOfAssociatedItemsForAnd();
    }

    @When("The user delete all rules if any exists")
    public void theUserDeleteAllRulesIfAnyExists() {
        pages.membershipAccountRulePage().deleteAllRulesIfAnyExists();
    }

    @When("The user clicks Set Rules button with association name {string}")
    public void theUserClicksSetRulesButtonWithAssociationName(String assocName) {
        pages.membershipAccountRulePage().clickSetRulesButtonWithAssociationName(assocName);
    }

    @Then("The user verifies that associated item has association name {string}")
    public void theUserVerifiesThatAssociatedItemHasAssociationNameRuleTestAutomation(String assocName) {
        pages.membershipAccountRulePage().verifyAssociatedItemHasAssociationName(assocName);
    }

    @When("The user clicks Set Rules button with random association name")
    public void theUserClicksSetRulesButtonWithRandomAssociationName() {
        pages.membershipAccountRulePage().clickSetRulesButtonWithRandomAssociationName();
    }


    @Then("The user clicks clearAll button in {string}")
    public void theUserClicksClearAllButtonIn(String ruleListType) {
        pages.membershipAccountRulePage().clickClearAllButton(ruleListType);
    }

    @Then("The item that is set in rule should not appear in InList")
    public void theItemThatIsSetInRuleShouldNotAppearInInList() {
        pages.membershipAccountRulePage().verifyTheItemThatIsSetInRuleIsNotAppearInInList();
    }

    @When("The user refresh the page")
    public void theUserRefreshThePage() {
        BrowserUtils.wait(2);
        Driver.getDriver().navigate().refresh();
    }

    @Then("The item that is set out rule should not appear in NotInList")
    public void theItemThatIsSetOutRuleShouldNotAppearInNotInList() {
        pages.membershipAccountRulePage().verifyTheItemThatIsSetOutRuleIsNotAppearInInList();
    }

    @When("The user select {string} list")
    public void theUserSelectRuleTestAutomationList(String listName) {
        pages.itemOverviewPage().selectList(listName);
    }

    @When("The user take the {string} values of item in item overview for {string}")
    public void theUserTakeTheValuesOfItemInItemOverview(String header, String inOrNotInList) {
        pages.membershipAccountRulePage().takeValueOfItemInItemOverview(header, inOrNotInList);
    }

    @When("The user select {string} list in {string} area")
    public void theUserSelectListIn(String listName, String area) {
        pages.membershipAccountRulePage().selectListIn(listName, area);
    }

    @Then("The user go to items to verify detail info with two step for or {string}")
    public void theUserGoToItemsToVerifyDetailInfoWithTwoStepForOr(String tabName) {
        pages.membershipAccountRulePage().goToItemsToVerifyDetailInfoWithTwoStepForOr(tabName);
    }

    @Then("The user go to items to verify detail info with two step for and {string}")
    public void theUserGoToItemsToVerifyDetailInfoWithTwoStepForAnd(String tabName) {
        pages.membershipAccountRulePage().goToItemsToVerifyDetailInfoWithTwoStepForAnd(tabName);
    }


    @Then("The user verifies edited item is associated with two step {string} {string} {string}")
    public void theUserVerifiesEditedItemIsAssociatedWithTwoStep(String tabName, String itemIdForRule, String itemIdForAssociation) {
        pages.membershipAccountRulePage().verifyEditedItemIsAssociatedWithTwoStep(tabName,itemIdForRule,itemIdForAssociation);
    }

}
