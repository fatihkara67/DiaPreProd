package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.Given;

public class MenuFlowsStepDefs extends BaseStep{

    @Given("The user fill menu start form with musteri code {string}")
    public void theUserFillMenuStartFormWithMusteriCode(String lastCustomerCode) {
        pages.menuFlows().fillMenuFlowForm(lastCustomerCode);
    }

    @Given("The user select vendor as {string}")
    public void theUserSelectVendor(String vendor) {
        BrowserUtils.scrollToElement(Driver.getDriver(),pages.menuFlows().getVendorSelect());
        BrowserUtils.wait(3);
        BrowserUtils.adjustScreenSize(75, Driver.getDriver());
        BrowserUtils.waitForVisibility(pages.menuFlows().getVendorSelect(),60);
        pages.menuFlows().getVendorSelect().click();
        pages.menuFlows().getVendorInput().sendKeys(vendor);
        pages.menuFlows().getEfecturaVendorOption().click();
    }

    @Given("The user go in menu Task {string}")
    public void theUserGoInMenuTask(String tabTitleName) {
        pages.menuFlows().goInMenuTask(tabTitleName);
    }

    @Given("The user fill menu vendor form with budget {string}")
    public void theUserFillMenuVendorFormWithBudget(String budget) {
        pages.menuFlows().fillMenuVendorForm(budget);
    }

    @Given("The user fill second menu vendor form")
    public void theUserFillSecondMenuVendorForm() {
        pages.menuFlows().fillSecondMenuVendorForm();
    }

    @Given("The user fill menu vendor invoice form with invoice {string}")
    public void theUserFillMenuVendorInvoiceFormWithInvoice(String invoiceAmount) {
        pages.menuFlows().fillMenuVendorInvoiceForm(invoiceAmount);
    }
}
