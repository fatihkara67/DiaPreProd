package com.efectura.stepDefs;

import com.efectura.pages.BPM.Offstand;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.CommonExcelReader;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class OffstandStepDefs extends BaseStep {

    @Given("The user navigate to import page")
    public void theUserNavigateToImportPage() {
        Driver.getDriver().navigate().to("https://dia-preprod-ui.efectura.com/Import");
    }

    @And("The user accepts import popup")
    public void theUserAcceptsImportPopup() {
        pages.offstand().getImportPopupApplyButton().click();
    }

    @When("The user upload {string} file")
    public void theUserUploadFile(String fileName) {
        pages.offstand().uploadExcelFile(fileName);

    }

    @When("The user import the uploaded file")
    public void theUserImportTheUploadedFile() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForVisibility(pages.offstand().getImportButton(),10);
        pages.offstand().getImportButton().click();
        BrowserUtils.wait(4);
    }

    @When("The user select {string} for importType")
    public void theUserSelectForImportType(String importType) {
        pages.offstand().selectImportType(importType);
    }

    @Given("The user update {string} cells with {string} in {int} to {int}")
    public void theUserUpdateMUSTERI_KODUCellsWith(String columnName,String columnValue, int start, int end) throws IOException {
        CommonExcelReader.updateColumnRange(Offstand.getExcelPath("OFFSTAND"),columnName,start,end,columnValue);
    }

    @Given("The user update {string} cell with {string} in {int}")
    public void theUserUpdateTOPLAM_TUTARCellWithIn(String columnName,String columnValue, int index) throws IOException {
        CommonExcelReader.updateCellValue(Offstand.getExcelPath("OFFSTAND"),columnName,index,columnValue);
    }

    @Given("The user get stand actual budget for {string} and markaisi {int}")
    public void theUserGetStandActualBudgetFor(String customerCode, int markaisi) {
        pages.offstand().getStandActualBudgetForCustomer(customerCode, markaisi);
    }

    @Then("The user verify stand actual budget for {string} and markaisi {int} with budget {string}")
    public void theUserVerifyStandActualBudgetForAndMarkaisiWithBudget(String customerCode, int markaisi, String expectedActualBudget) {
        boolean isBudgetOk = pages.offstand().verifyStandActualBudget(customerCode,markaisi,expectedActualBudget);
        Assert.assertTrue(isBudgetOk);
        BrowserUtils.wait(3);
    }

    @When("The user go in digital asset item")
    public void theUserGoInDigitalAssetItem() {
        pages.offstand().goInDigitalAssetItem();
    }

    @When("The user clicks {string} attribute group")
    public void theUserClicksAttributeGroup(String attrGroup) {
        pages.offstand().clickAttributeGroup(attrGroup);
    }

    @When("The user update {string} attribute with value {string}")
    public void theUserUpdateTOPLAMKALEMTUTARIAttributeWithValue(String attrLabel, String value) {
        pages.offstand().updateAttribute(attrLabel,value);
    }

    @And("The user clicks save button in edit item")
    public void theUserClicksSaveButtonInEditItem() {
        BrowserUtils.wait(2);
//        pages.editItemPage().getAccordionButton().click();
        BrowserUtils.wait(2);
        BrowserUtils.waitForVisibility(pages.editItemPage().getSaveButton(),10);
        pages.editItemPage().getSaveButton().click();
    }

    @And("The user clicks save button in edit item save modal")
    public void theUserClicksSaveButtonInEditItemSaveModal() {
        pages.editItemPage().getSaveBtnInEditItemSaveModal().click();
    }

    @Then("The user verifies info {string} appears")
    public void theUserVerifiesInfoAppears(String expectedMessage) {
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(pages.editItemPage().getInfoMessage(),20);
        Assert.assertEquals(expectedMessage, pages.editItemPage().getInfoMessage().getText());
        System.out.println(pages.editItemPage().getInfoMessage().getText());
    }

    @When("The user delete item")
    public void theUserDeleteItem() {
        if (BrowserUtils.isElementDisplayed(pages.editItemPage().getScrollUpButton())) {
            pages.editItemPage().getScrollUpButton().click();
        }
        BrowserUtils.wait(2);
        pages.editItemPage().getDeleteItemButton().click();
        pages.editItemPage().getDeleteButtonInDeleteItemModal().click();
        BrowserUtils.wait(2);
    }
}
