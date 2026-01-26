package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ReportStepDefs extends BaseStep {

    @When("The user select {string} report")
    public void theUserSelectOutletPointHistoryReport(String reportName) {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.reportPage().getReportSelect(),reportName);
        pages.reportPage().getShowReportButton().click();
        BrowserUtils.waitForClickability(pages.reportPage().getMainExportButton(),30);
        BrowserUtils.wait(1);
    }

    String reportSentDate;
    @When("The user click ExportCurrentView button")
    public void theUserClickExportCurrentViewButton() {
        pages.reportPage().getMainExportButton().click();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        reportSentDate = ZonedDateTime.now(ZoneOffset.UTC).format(formatter);

        pages.reportPage().getExportCurrentView().click();
        BrowserUtils.waitForVisibility(pages.generalPage().getFlowInfoMessage(),25);
        String infoText = pages.generalPage().getFlowInfoMessage().getText();

//        Assert.assertEquals("BAŞARILI",infoText);


    }

    @When("The user click flows button in flow report")
    public void theUserClickFlowsButtonInFlowReport() {
        pages.reportPage().getFlowsButtons().get(0).click();
        BrowserUtils.wait(1);
    }

    @When("The user click eye icon")
    public void theUserClickEyeIcon() {
        pages.reportPage().getFlowDetailEyeIcons().get(0).click();
    }

    @Then("The user verify file preview displayed")
    public void theUserVerifyFilePreviewDisplayed() {
        Assert.assertTrue("File preview indirme butonu gelmedi",
                BrowserUtils.isElementDisplayed(pages.reportPage().getFilePreviewDownloadButton()));
        pages.reportPage().getCloseFilePreviewModalButton().click();
        BrowserUtils.wait(1);
        pages.reportPage().getCloseFlowDetailModalButton().click();
    }
}
