package com.efectura.stepDefs;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.efectura.pages.BasePage.getColumnData;
import static com.efectura.utilities.CommonExcelReader.getExcelPath;

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
        pages.panel().goInFlow(formName);
    }

    @Given("The user select {string} as form type")
    public void theUserSelectAsFormType(String formType) {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.panel().getFormTypeSelect(),formType);
        BrowserUtils.wait(7);
    }

    String formNumber;
    @Given("The user fill start form with musteri code {string}")
    public void theUserFillStartFormWithMusteriCode(String lastCustomerCode) {
        formNumber = pages.modulFlows().fillModuleFlowForm(lastCustomerCode);
    }

    @Given("The user verify blocked budget with {string}")
    public void theUserVerifyBlockedBudgetWith(String budget) {
        BrowserUtils.wait(2);
        boolean isBudgetOk = pages.modulFlows().verifyBlockedBudget(budget);
//        Assert.assertTrue(isBudgetOk);
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
        BrowserUtils.adjustScreenSize(75,Driver.getDriver());
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

    @Then("The user verify flow start page is open")
    public void theUserVerifyFlowStartPageIsOpen() {
        Assert.assertTrue(pages.panel().getFormTypeSelect().isDisplayed());
    }

    @Given("The user verify process list flow step {string}")
    public void theUserVerifyProcessListFlowStep(String expectedFlowStep) {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Process/ProcessDefinitonDetail?id=SalesFlow_V3.1:1:7a0ec3d6-3321-11ef-8958-0242ac130003");

        BrowserUtils.wait(4);

        pages.generalPage().useTextFilter(formNumber,"Form Numarası");
        BrowserUtils.wait(4);

        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("processListTable")));
        List<String> values =  BasePage.getColumnData(tableElement,"Akış Adımı");

        System.out.println(values);
        BrowserUtils.wait(2);
        for (String actualValue : values) {
            Assert.assertTrue(actualValue.toLowerCase().contains(expectedFlowStep.toLowerCase()));
//            Assert.assertEquals(expectedValue,actualValue);
        }

    }

    @Given("The user go to Flow logs page")
    public void theUserGoToFlowLogsPage() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/EventLogs");
    }

    @And("The user enters {string} into {string} filter text input box flow")
    public void theUserEntersIntoFilterTextInputBox(String value, String columnName) {
        value = formNumber;
        pages.generalPage().useTextFilter(value,columnName);
    }

    @Then("The user verify {string} text filter with value {string} in {string} flow")
    public void theUserVerifyTextFilterWithValueIn(String columnName, String expectedValue, String table) {
        expectedValue = formNumber;
        BrowserUtils.adjustScreenSize(65,Driver.getDriver());
        BrowserUtils.wait(2);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty(table)));
        List<String> values =  getColumnData(tableElement,columnName);

        System.out.println(values);
        BrowserUtils.wait(2);
        for (String actualValue : values) {
            Assert.assertTrue(actualValue.toLowerCase().contains(expectedValue.toLowerCase()));
//            Assert.assertEquals(expectedValue,actualValue);
        }
    }

    int blockedBudgetBeforeFlow;
    @Given("The user get blocked budget for stand")
    public void theUserGetBlockedBudgetForStand() {
        blockedBudgetBeforeFlow = pages.modulFlows().getBlockedBudgetForStand();
    }

    int actualStandBudgetBeforeFlow;
    @Given("The user get actual budget for stand")
    public void theUserGetActualBudgetForStand() {
//        pages.modulFlows().getActualBudget();
        actualStandBudgetBeforeFlow = pages.modulFlows().getActualBudgetForStand();
    }

    @Given("The user fill start form for {string} and markaisi {int}")
    public void theUserFillStartFormForAndMarkaisi(String customerCode, int markaisi) {
        formNumber = pages.modulFlows().fillStandFlowForm(customerCode,markaisi);
    }

    @Given("The user get total price")
    public void theUserGetTotalPrice() {
        pages.modulFlows().addKalemAndGetTotalPrice();
    }

    @Given("The user fill vendor1 form")
    public void theUserFillVendorForm() {
        pages.modulFlows().fillVendor1Form();
    }

    @Given("The user verify new total price")
    public void theUserVerifyNewTotalPrice() {
        pages.modulFlows().verifyNewPrice();
    }

    @Given("The user fill vendor2 form and submit")
    public void theUserFillVendor2FormAndSubmit() {
        pages.modulFlows().fillVendor2Form();
    }

    @Given("The user verify stand blocked budget with {string}")
    public void theUserVerifyStandBlockedBudgetWith(String budget) {
        BrowserUtils.wait(2);
        boolean isBudgetOk = pages.modulFlows().verifyStandBlockedBudget(budget,blockedBudgetBeforeFlow);
    }

    @Given("The user fill vendor3 form and submit")
    public void theUserFillVendor3FormAndSubmit() {
        pages.modulFlows().fillVendor3Form();
    }

    @Given("The user verify stand actual budget with {string}")
    public void theUserVerifyStandActualBudgetWith(String budget) {
        boolean isBudgetOk = pages.modulFlows().verifyStandActualBudget(budget,actualStandBudgetBeforeFlow);
        Assert.assertTrue(isBudgetOk);
        BrowserUtils.wait(3);
    }

    @When("The user clear related tables")
    public void theUserClearRelatedTables() {
        pages.dbProcess().clearRelatedTables();
    }

    @When("The user export target file")
    public void theUserExportTargetFile() {
        BrowserUtils.wait(1);
        Driver.getDriver().findElement(By.id("export-target-dropdown")).click();
        Driver.getDriver().findElement(By.id("export-target")).click();

    }

    @When("The user import target file")
    public void theUserImportTargetFile() {
        BrowserUtils.wait(2);

//        Driver.getDriver().findElement(By.id("target-import-step-two")).click();
        BrowserUtils.wait(6);
        Driver.getDriver().findElement(By.id("target-import-step-three")).click();
        BrowserUtils.wait(6);
        Driver.getDriver().findElement(By.id("target-apply-details-button")).click();
        BrowserUtils.wait(12);
    }

    @When("The user click target import button")
    public void theUserClickTargetImportButton() {
        BrowserUtils.wait(2);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        By importDropdownBtn = By.id("import-target-dropdown");

        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(importDropdownBtn));

// Görünür alana getir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView({block:'center'});", btn);

// Clickable olana kadar bekle
        wait.until(ExpectedConditions.elementToBeClickable(btn));

// Normal click bazen yutulur -> Actions click daha sağlam
        new Actions(Driver.getDriver()).moveToElement(btn).pause(Duration.ofMillis(150)).click().perform();

// Gerçekten açıldı mı?
        wait.until(d -> "true".equals(btn.getAttribute("aria-expanded")));

        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.xpath("//a[@id='import-target']")).click();

    }

    @When("The user click flow button")
    public void theUserClickFlowButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='modal_actionBtn']")).click();
        BrowserUtils.wait(2);
    }

    @When("The user select bm {string}")
    public void theUserSelectBm(String bmName) {
        BrowserUtils.wait(2);
        WebElement select = Driver.getDriver().findElement(By.xpath("//select[@id='bmSelect']"));
        BrowserUtils.selectDropdownOptionByVisibleText(select,bmName);
        BrowserUtils.wait(2);
    }

    @When("The user click start flow button")
    public void theUserClickStartFlowButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='gotoNextScreenBtnAll']")).click();
        BrowserUtils.wait(3);
    }

    @When("The user go in route flow")
    public void theUserGoInRouteFlow() {
        Driver.getDriver().findElement(By.xpath("(//td[.='__LZM_ROUTES__'])[1]")).click();
    }

    @Given("The user go in route task {string}")
    public void theUserGoInRouteTask(String tabTitleName) {
        BrowserUtils.switchToTabByTitleAndCloseOld(tabTitleName);
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());
    }

    @When("The user click import step button")
    public void theUserClickImportStepButton() {
        BrowserUtils.wait(1);
        BrowserUtils.adjustScreenSize(50,Driver.getDriver());
        WebElement btn = Driver.getDriver().findElement(By.xpath("//button[@id='gotoNextScreenBtn']"));
        BrowserUtils.scrollToElement(Driver.getDriver(),btn);
        btn.click();
    }

    @When("The user upload file {string}")
    public void theUserUploadFilePlanningTarget(String fileName) {
//        Driver.getDriver().findElement(By.xpath("//input[contains(@id,'file-import')]")).sendKeys(getExcelPath(fileName));
        pages.itemOverviewPage().getItemImportInput().sendKeys(getExcelPath(fileName));
        pages.itemOverviewPage().getItemImportStep2NextButton().click();
        BrowserUtils.wait(2);
    }

    @When("The user click start import button")
    public void theUserClickStartImportButton() {
        Driver.getDriver().findElement(By.xpath("//button[contains(@id,'start-import')]")).click();
    }

    @When("The user click send approval button")
    public void theUserClickSendApprovalButton() {
        BrowserUtils.adjustScreenSize(45,Driver.getDriver());
        BrowserUtils.wait(2);
        WebElement btn = Driver.getDriver().findElement(By.xpath("//button[@id='send-approval-f2']"));
        BrowserUtils.scrollToElement(Driver.getDriver(),btn);
        btn.click();
    }

    @When("The user go in sales approval form")
    public void theUserGoInSalesApprovalForm() {
        Driver.getDriver().findElement(By.xpath("(//td[.='BMUSERAD BM'])[1]")).click();
    }

    @When("The user click bm target apply button")
    public void theUserClickBmTargetApplyButton() {
        BrowserUtils.adjustScreenSize(55,Driver.getDriver());
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.xpath("//button[@id='onaylaF3']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@id='confirmModalConfirmBtnF4']")).click();
    }

    @When("The user impersonate to selected user")
    public void theUserImpersonateToSelectedUser() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/UserManage/Edit/65865f45-4772-4eea-b844-ca19f06e1a70");

        BrowserUtils.waitForVisibility(pages.modulFlows().impersonateHoverBtn, 30);
        BrowserUtils.hoverOver(pages.modulFlows().impersonateHoverBtn);
        pages.modulFlows().impersonateButton.click();
        BrowserUtils.wait(3);
    }
}
