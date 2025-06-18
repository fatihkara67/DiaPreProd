package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class ModuleFlowsStepDefs extends BaseStep {

    @Given("The user login with {string}")
    public void theUserLoginWith(String username) {
        BrowserUtils.wait(3);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(pages.loginPage().getUsernameField(),60);
        pages.loginPage().loginWith(username);
    }

    @Given("The user go to {string} page")
    public void theUserGoToPage(String pageName) {
        BrowserUtils.wait(2);
        Driver.getDriver().get(ConfigurationReader.getProperty(pageName));
    }

    @Given("The user go in {string} flow")
    public void theUserGoInFlow(String formName) {
        pages.modulFlows().goInFlow(formName);
    }

    @Given("The user select {string} as form type")
    public void theUserSelectAsFormType(String formType) {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.modulFlows().getFormTypeSelect(),formType);
        BrowserUtils.wait(7);
    }

    @Given("The user fill start form with musteri code {string}")
    public void theUserFillStartFormWithMusteriCode(String lastCustomerCode) {
        pages.modulFlows().fillModuleFlowForm(lastCustomerCode);
    }

    @Given("The user verify blocked budget with {string}")
    public void theUserVerifyBlockedBudgetWith(String budget) {
        boolean isBudgetOk = pages.modulFlows().verifyBlockedBudget(budget);
        Assert.assertTrue(isBudgetOk);
    }

    @Given("The user get blocked budget")
    public void theUserGetBlockedBudget() {
        pages.modulFlows().getBlockedBudget();
    }

    @Given("The user go in Task and submit")
    public void theUserGoInTaskAndSubmit() {
        pages.modulFlows().goInTaskAndSubmit();
    }

    @Given("The user fill vendor form with initial budget {string}")
    public void theUserFillVendorFormWithInitialBudget(String budget) {
        pages.modulFlows().fillVendorInitialForm(budget);
//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//        BrowserUtils.wait(19);
    }

    @Given("The user fill vendor invoice form with invoice {string}")
    public void theUserFillVendorInvoiceFormWithInvoice(String invoiceAmount) {
        pages.modulFlows().fillVendorInvoiceForm(invoiceAmount);
//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//        BrowserUtils.wait(19);
    }

    @Given("The user get actual budget")
    public void theUserGetActualBudget() {
        pages.modulFlows().getActualBudget();
    }

    @Given("The user verify actual budget with {string}")
    public void theUserVerifyActualBudgetWith(String expectedActualBudget) {
        boolean isBudgetOk = pages.modulFlows().verifyActualBudget(expectedActualBudget);
        Assert.assertTrue(isBudgetOk);
        BrowserUtils.wait(3);
    }

    @Given("The user go in Task {string}")
    public void theUserGoInTask(String tabTitleName) {
        pages.modulFlows().goInTask(tabTitleName);
    }

    @Given("The user submit the task")
    public void theUserSubmitTheTask() {
        BrowserUtils.wait(2);
        pages.modulFlows().submitTask();
//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//        BrowserUtils.wait(12);
    }

    @Given("The user change distributor help")
    public void theUserChangeDistributorHelp() {
        BrowserUtils.waitForVisibility(pages.modulFlows().getDistributorCheckbox(),30);
        pages.modulFlows().getDistributorCheckbox().click();
        BrowserUtils.wait(1);
        BrowserUtils.waitForVisibility(pages.modulFlows().getFlowInfoMessage(), 20);
    }


    @Given("The user reject the task")
    public void theUserRejectTheTask() {
        BrowserUtils.wait(2);
        pages.modulFlows().rejectTask();
    }

    @Given("The user revise the task")
    public void theUserReviseTheTask() {
        BrowserUtils.wait(2);
        pages.modulFlows().reviseTask();
    }

    @Given("The user fill start form with musteri code {string} and budget {string}")
    public void theUserFillStartFormWithMusteriCodeAndBudget(String lastCustomerCode, String budgetSupport) {
        pages.modulFlows().fillModuleBudgetForm(lastCustomerCode, budgetSupport);
    }


    @Given("The user fill invoice form with amount {string}")
    public void theUserFillInvoiceFormWithAmount(String invoiceAmount) {
        pages.modulFlows().fillInvoiceForm(invoiceAmount);
    }
}
