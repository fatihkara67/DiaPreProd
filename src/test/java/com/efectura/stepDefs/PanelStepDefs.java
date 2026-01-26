package com.efectura.stepDefs;

import com.efectura.pages.BasePage;
import com.efectura.pages.GeneralPage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PanelStepDefs extends BaseStep {

    @When("The user go in {string} flow history")
    public void theUserGoInFlowHistory(String flowName) {
        WebElement flowRow = Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + flowName + "')]"));
        flowRow.click();
    }

    @Then("The  user verify history page is open")
    public void theUserVerifyHistoryPageIsOpen() {
        Assert.assertEquals(
                "https://dia-preprod-ui.efectura.com/Process/ProcessDefinitonDetail?id=SalesFlow_V3.1:1:7a0ec3d6-3321-11ef-8958-0242ac130003",
                Driver.getDriver().getCurrentUrl());
    }

    @When("The user click first ongoing flow")
    public void theUserClickFirstOngoingFlow() {
        pages.taskList().getSearchAllFilterInput().sendKeys("Devam");
        BrowserUtils.wait(1);
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
//        BrowserUtils.scrollToElement(Driver.getDriver(), pages.panel().getOngoingNavigateButton().get(0));

//        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", pages.panel().getOngoingNavigateButton().get(0));
        pages.panel().getOngoingNavigateButton().get(0).click();

        BrowserUtils.wait(2);
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: ConfirmationForm");
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());
        Assert.assertEquals("DIA: ConfirmationForm",Driver.getDriver().getTitle());

    }

    String formNumber;
    String flowStep;
    @When("The user take flow step info in task list")
    public void theUserTakeFlowStepInfoInTaskList() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskList");
        BrowserUtils.waitForVisibility(pages.taskList().getSearchAllFilterInput(),15);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("taskListTable")));
        flowStep = GeneralPage.getColumnData(tableElement,"Akış Adımı").get(0);
        System.out.println("flowStep: " + flowStep);
        formNumber = GeneralPage.getColumnData(tableElement,"Form Numarası").get(0);
        System.out.println("form number: " + formNumber);
    }

    @Then("The user verify the step in process list")
    public void theUserVerifyTheStepInProcessList() {
        pages.taskList().getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(3);
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        BrowserUtils.wait(3);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("processListTable")));
        String flowStepInProcessList = GeneralPage.getColumnData(tableElement,"Akış Adımı").get(0);
        System.out.println("flowStepInProcessList: " + flowStepInProcessList);
        Assert.assertEquals(formNumber + " nolu akışın adımı panelde farklı!!!", flowStep, flowStepInProcessList);
    }

    @Then("The user verify ongoing flow status")
    public void theUserVerifyOngoingFlowStatus() {
        pages.taskList().getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(2);
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
//        Assert.assertEquals("Devam Etmekte", pages.panel().getProcessListFlowStatusButtons().get(0).getText());

        boolean found = pages.panel().getActionButtons().stream()
                .anyMatch(el -> "Devam Etmekte".equals(el.getAttribute("data-original-title")));

        Assert.assertTrue(found);

    }

    @When("The user click flow detail button")
    public void theUserClickFlowDetailButton() {
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        BrowserUtils.wait(1);
//        ((JavascriptExecutor) Driver.getDriver()).
//                executeScript("arguments[0].click();", pages.panel().getProcessListFlowDetailButtons().get(0));

        pages.panel().getProcessListFlowDetailButtons().get(0).click();

    }

    @Then("The user verify flow details modal is open")
    public void theUserVerifyFlowDetailsModalIsOpen() {
        BrowserUtils.waitForVisibility(pages.panel().getProcessListDetailModalHeader(),45);
        Assert.assertTrue("Akış Detayları Modal'ı Açılmadı!",pages.panel().getProcessListDetailModalHeader().isDisplayed());
    }
}
