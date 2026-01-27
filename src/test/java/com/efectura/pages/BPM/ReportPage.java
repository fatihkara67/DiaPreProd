package com.efectura.pages.BPM;

import com.efectura.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ReportPage extends BasePage {

    @FindBy(xpath = "//select[@id='dropdownReports']")
    private WebElement reportSelect;

    @FindBy(xpath = "//button[@id='showReport']")
    private WebElement showReportButton;

    @FindBy(xpath = "//div[@id='exportReport']/button")
    private WebElement mainExportButton;

    @FindBy(xpath = "//a[@id='export-reports']")
    private WebElement exportCurrentView;

    @FindBy(xpath = "//a[@class='export-email']")
    private WebElement exportSendMail;

    @FindBy(xpath = "//*[@id=\"tableReport\"]/tbody/tr/td/button")
    private List<WebElement> flowsButtons;

    @FindBy(xpath = "//*[@id=\"ek-dosyalar-tablosu\"]/tbody/tr/td[6]/i[2]")
    private List<WebElement> flowDetailEyeIcons;

    @FindBy(xpath = "//*[@id=\"preview-container\"]/a")
    private WebElement filePreviewDownloadButton;

    @FindBy(xpath = "//button[@id='closeModalButton']")
    private WebElement closeFilePreviewModalButton;

    @FindBy(xpath = "//button[@id='customCloseModalButton']")
    private WebElement closeFlowDetailModalButton;


}
