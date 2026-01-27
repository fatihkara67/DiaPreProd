package com.efectura.pages.BPM;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Driver;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

@Getter
public class MenuFlows extends BasePage {

    TaskList taskList = new TaskList();

    @FindBy(xpath = "//input[@id='formNo']")
    private WebElement formNumberInput;

    @FindBy(xpath = "//input[@id='noktaTrackKodu']")
    private WebElement musteriNoInputBox;

    @FindBy(xpath = "//button[@id='searchButton']")
    private WebElement getirBtn;

    @FindBy(xpath = "//h4[contains(text(),'Nokta Bilgileri')]")
    private WebElement trackInfoHeader;

    @FindBy(xpath = "//span[@id='select2-vendorList-container']")
    private WebElement vendorSelect;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement vendorInput;

    @FindBy(xpath = "//li[contains(.,'Vendor')]")
    private WebElement efecturaVendorOption;

    @FindBy(xpath = "//input[@id='docDate']")
    private WebElement docDateInput;

    @FindBy(xpath = "//input[@id='fileInput']")
    private WebElement fileInput;

    @FindBy(xpath = "//select[@id='docType']")
    private WebElement docTypeSelect;

    @FindBy(xpath = "(//span[@class='flatpickr-day today'])[1]")
    private WebElement todayDate;

    @FindBy(xpath = "//ul[@id='select2-docType-results']/li/span")
    private List<WebElement> docOptions;

    @FindBy(xpath = "(//button[contains(text(),'Onaya Gönder')])[1]")
    private WebElement flowSubmitButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement vendorListSubmitButton;

    @FindBy(xpath = "//div[contains(@class, 'notyf__wrapper')]/div[2]")
    private WebElement menuFlowsInfoMessage;

    @FindBy(xpath = "//input[@id='toplamButce']")
    private WebElement totalBudgetInput;

    @FindBy(xpath = "//input[@id='invoiceAmount']")
    private WebElement invoiceAmountInput;

    @FindBy(xpath = "//input[@id='invoiceNo']")
    private WebElement invoiceNoInput;

    String formNumber = "";
    public void fillMenuFlowForm(String lastCustomerCode) {
        BrowserUtils.adjustScreenSize(60, Driver.getDriver());
        formNumber = BrowserUtils.getValueInInputBox(formNumberInput);
        System.out.println("Form Number: " + formNumber);
        musteriNoInputBox.sendKeys(lastCustomerCode);
        getirBtn.click();
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(trackInfoHeader,20);
        BrowserUtils.scrollToElement(Driver.getDriver(), docDateInput);

        List<String> docTypes = Arrays.asList("Tütün Alkol Denetim Belgesi", "Menü İçeriği Dökümanı", "İşletme Menü Talep Ve Bilgilendirme Yazısı");

        docDateInput.click();
        BrowserUtils.wait(1);
        todayDate.click();

        WebElement uploadInfo = null;
        for (int i = 0; i < 3; i++) {
            BrowserUtils.selectDropdownOptionByVisibleText(docTypeSelect,docTypes.get(i));
            fileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
            BrowserUtils.wait(2);
            uploadInfo = Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + docTypes.get(i) + "')]"));
            BrowserUtils.waitForVisibility(uploadInfo,60);
        }
        BrowserUtils.waitForVisibility(uploadInfo,60);
        BrowserUtils.scrollToElement(Driver.getDriver(), flowSubmitButton);
        flowSubmitButton.click();
        BrowserUtils.waitForVisibility(menuFlowsInfoMessage,60);
        Assert.assertEquals("Form başarıyla gönderildi.", menuFlowsInfoMessage.getText());

    }

    public void goInMenuTask(String tabTitleName) {
        BrowserUtils.wait(1);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskList");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),60);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(4);
        BrowserUtils.waitForClickability(taskList.getFirstColumn(),30);
        taskList.getFirstColumn().click();
//        BrowserUtils.switchToTab("DIA: ConfirmationForm");
        BrowserUtils.switchToTabByTitleAndCloseOld(tabTitleName);
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());
    }

    public void fillMenuVendorForm(String budget) {
        BrowserUtils.wait(2);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskListVendor");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),60);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(4);
        taskList.getFirstColumn().click();
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: MenuFlowForm");
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());

        totalBudgetInput.sendKeys(budget);

        List<String> docTypes = Arrays.asList("Menü Tasarım Dokümanı", "Bütçe Hesap Dokümanı");

        docDateInput.click();
        BrowserUtils.wait(1);
        todayDate.click();

        WebElement uploadInfo = null;
        for (String docType : docTypes) {
            BrowserUtils.selectDropdownOptionByVisibleText(docTypeSelect, docType);
            fileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
            BrowserUtils.wait(2);

            BrowserUtils.wait(2);
            uploadInfo = Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + docType + "')]"));
            BrowserUtils.waitForVisibility(uploadInfo,60);
        }

        vendorListSubmitButton.click();
        BrowserUtils.waitForVisibility(menuFlowsInfoMessage,60);
        Assert.assertEquals("Başarılı", menuFlowsInfoMessage.getText());
        System.out.println("Vendor Total Budget = " + budget);

    }

    public void fillSecondMenuVendorForm() {
        BrowserUtils.wait(2);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskListVendor");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(), 60);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(4);
        taskList.getFirstColumn().click();
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: MenuFlowForm");
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());


        List<String> docTypes = List.of("Teslimat Kanıt Belgeleri");

        docDateInput.click();
        BrowserUtils.wait(1);
        todayDate.click();

        WebElement uploadInfo = null;
        for (String docType : docTypes) {
            BrowserUtils.selectDropdownOptionByVisibleText(docTypeSelect, docType);
            fileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
            BrowserUtils.wait(2);
            uploadInfo = Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + docType + "')]"));
            BrowserUtils.waitForVisibility(uploadInfo, 60);
        }

        vendorListSubmitButton.click();
        BrowserUtils.waitForVisibility(menuFlowsInfoMessage,60);
        Assert.assertEquals("Başarılı", menuFlowsInfoMessage.getText());
    }

    public void fillMenuVendorInvoiceForm(String invoiceAmount) {
        BrowserUtils.wait(2);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Task/TaskListVendor");
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(taskList.getSearchAllFilterInput(),60);
        taskList.getSearchAllFilterInput().sendKeys(formNumber);
        BrowserUtils.wait(5);
        BrowserUtils.waitForClickability(taskList.getFirstColumn(),30);
        taskList.getFirstColumn().click();
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: MenuFlowForm");
        BrowserUtils.wait(3);
        System.out.println("Title: " + Driver.getDriver().getTitle());

        List<String> docTypes = List.of("Tedarikçi Faturası");

        docDateInput.click();
        BrowserUtils.wait(1);
        todayDate.click();
        invoiceAmountInput.sendKeys(invoiceAmount);
        invoiceNoInput.sendKeys("FK-67");

        WebElement uploadInfo = null;
        for (String docType : docTypes) {
            BrowserUtils.selectDropdownOptionByVisibleText(docTypeSelect, docType);
            fileInput.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DiaPreprodTestAutomation\\src\\test\\java\\com\\efectura\\pages\\BPM\\ModulFlows.java");
            BrowserUtils.wait(2);

            BrowserUtils.wait(2);
            uploadInfo = Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + docType + "')]"));
            BrowserUtils.waitForVisibility(uploadInfo,60);
        }

        vendorListSubmitButton.click();
        BrowserUtils.waitForVisibility(menuFlowsInfoMessage,60);
        Assert.assertEquals("Başarılı", menuFlowsInfoMessage.getText());
        System.out.println("Vendor Invoice = " + invoiceAmount);
    }
}
