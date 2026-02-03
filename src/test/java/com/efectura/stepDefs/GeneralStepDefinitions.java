package com.efectura.stepDefs;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.CommonExcelReader;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static com.efectura.pages.BasePage.getColumnData;
import static com.efectura.utilities.CommonExcelReader.getExcelPath;

public class GeneralStepDefinitions extends BaseStep {


    @And("The user select {string} in {string} select filter")
    public void theUserSelectInSelectFilter(String selectOption, String selectFilter) {
        BrowserUtils.adjustScreenSize(70, Driver.getDriver());
        pages.generalPage().selectOptionInSelectFilter(selectOption,selectFilter);
        BrowserUtils.wait(5);
    }

    @And("The user enters {string} into {string} filter text input box")
    public void theUserEntersIntoFilterTextInputBox(String value, String columnName) {
        pages.generalPage().useTextFilter(value,columnName);
    }

    @Then("The user verify {string} warning")
    public void theUserVerifyEMPTY_FAMILYWarning(String expectedWarningText) {
        BrowserUtils.waitForVisibility(pages.generalPage().getGeneralWarningElement(),30);
        Assert.assertEquals(expectedWarningText, pages.generalPage().getGeneralWarningElement().getText());
    }

    @And("The user select family {string} in create modal")
    public void theUserSelectFamilyCoolerInCreateModal(String family) {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.generalPage().getFamilySelectInCreateModal(),family);
    }

    @Then("The user verify {string} select filter with value {string} in {string}")
    public void theUserVerifySelectFilterWithValue(String columnName, String expectedValue, String table) {
        BrowserUtils.wait(2);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty(table)));
        List<String> values =  getColumnData(tableElement,columnName);

        System.out.println(values);
        BrowserUtils.wait(10);
        for (String actualValue : values) {
            Assert.assertEquals(expectedValue,actualValue);
        }
    }

    @Then("The user verify {string} text filter with value {string} in {string}")
    public void theUserVerifyTextFilterWithValueIn(String columnName, String expectedValue, String table) {
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

    @And("The user verify empty data table info {string}")
    public void theUserVerifyEmptyDataTableInfoNoMatchingRecordsFound(String emptyTableInfo) {
        Assert.assertEquals(emptyTableInfo, pages.generalPage().getEmptyDataTableInfo().getText());
    }

    @And("The User clicks on delete button in table")
    public void theUserClicksOnDeleteButtonInTable() {
        BrowserUtils.wait(2);
        BrowserUtils.adjustScreenSize(80,Driver.getDriver());
        pages.generalPage().getDeleteBtnInTable().click();
    }

    @And("The user clicks on edit button in table")
    public void theUserClicksOnEditButtonInTable() {
        pages.itemOverviewPage().closeSideAccordionInOverview();
        BrowserUtils.wait(3);
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        pages.generalPage().getEditBtnInTable().click();
    }

    @When("The user enters {string} in comment area")
    public void the_user_enters_in_comment_area(String comment) {
//        pages.contactEditPage().setChangeCommentArea(comment);
        BrowserUtils.wait(2);
//        BrowserUtils.waitForVisibility(pages.generalPage().getChangeSaveCommentTextArea(),15);
        if (BrowserUtils.isElementDisplayed(By.xpath("//textarea[@id='comment']"))) {
            pages.generalPage().getChangeSaveCommentTextArea().sendKeys(comment);
        }
    }

    @And("The user verify item status is not {string} on item with code {string}")
    public void theUserVerifyItemStatusIsNotOnItemWithCodeTEST(String status, String itemCode) {
        Assert.assertFalse(pages.generalPage().getItemStatus(itemCode).isEmpty());
        Assert.assertNotEquals(status,pages.generalPage().getItemStatus(itemCode));
    }

    @And("The user verify item status is {string} on item with code {string}")
    public void theUserVerifyItemStatusIsOnItemWithCode(String status, String itemCode) {
        Assert.assertFalse(pages.generalPage().getItemStatus(itemCode).isEmpty());
        Assert.assertEquals(status,pages.generalPage().getItemStatus(itemCode));
    }

    @Then("The user verify that first item with code {string} has association on {string}")
    public void theUserVerifyThatFirstItemWithCodeHasAssociationOn(String itemCode, String associationTypeCode) throws SQLException {
        BrowserUtils.wait(2);
        Assert.assertTrue(pages.editItemPage().getAssociations(itemCode,associationTypeCode));
    }

    @And("The user reset the basic filters")
    public void theUserResetTheBasicFilters() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForClickability(pages.generalPage().getBasicResetButton(),20);
        pages.generalPage().getBasicResetButton().click();
        BrowserUtils.wait(2);
    }

    @And("The user verify Reset button func for {string} simple select filter")
    public void theUserVerifyResetButtonFuncForSimpleSelectFilter(String filterName) {
        String locate = "//span[contains(@id,'-" + filterName + "')]/span[text()='Select']";
        WebElement simpleSelectFilterPlaceholder = Driver.getDriver().findElement(By.xpath(locate));
        Assert.assertTrue(simpleSelectFilterPlaceholder.isDisplayed());
    }

    @When("The user select {string} in table show entry select")
    public void theUserSelectInTableShowEntrySelect(String tableShowSize) {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.generalPage().getTableShowEntrySelect(),tableShowSize);
    }

    @Then("The user verifies that table contains right rows according to {string}")
    public void theUserVerifiesThatTableContainsRightRowsAccordingTo(String length) {
        BrowserUtils.wait(1);
        pages.generalPage().verifyTableContainsRightRowsAccordingToLength(length);
//        Assert.assertTrue(BrowserUtils.isOptionSelected(pages.generalPage().getTableShowEntrySelect(), length));
        Select select = new Select(pages.generalPage().getTableShowEntrySelect());
        Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"),length.split(" ")[0]);
    }

    @When("The user click {string} header for asc sort")
    public void theUserClickHeaderForAscSort(String headerName) {
        pages.generalPage().clickHeaderForAscSort(headerName);
    }

    @Then("The user verify {string} header asc sorted in {string}")
    public void theUserVerifyHeaderAscSortedInTable(String headerName, String table) {

        BrowserUtils.wait(2);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty(table)));
        List<String> values =  getColumnData(tableElement,headerName);

        System.out.println(values);
        BrowserUtils.wait(2);

        List<String> sorted = new ArrayList<>(values);
        Collections.sort(sorted);

        Assert.assertEquals("Liste ASC (artan) şekilde sıralı değil.", sorted, values);


    }

    @When("The user click {string} header for desc sort")
    public void theUserClickHeaderForDescSort(String headerName) {
        pages.generalPage().clickHeaderForDescSort(headerName);
    }

    @Then("The user verify {string} header desc sorted in {string}")
    public void theUserVerifyHeaderDescSortedInTable(String headerName,String table) {
        BrowserUtils.wait(2);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty(table)));
        List<String> values =  getColumnData(tableElement,headerName);

        System.out.println(values);
        BrowserUtils.wait(2);

        List<String> sorted = new ArrayList<>(values);
        sorted.sort(Collections.reverseOrder()); // DESC sıralama

        Assert.assertEquals("Liste DESC (azalan) şekilde sıralı değil.", sorted, values);
    }


    @When("The user go to {string} overview page")
    public void theUserGoToAccountOverviewPage(String item) {
        pages.itemOverviewPage().goToItemOverviewPage(item);
    }

    @Then("The user verify warning message {string}")
    public void theUserVerifyWarningMessage(String expectedMessageText) {
        BrowserUtils.wait(1);
        Assert.assertEquals(expectedMessageText, pages.generalPage().getInfoMessage().getText());
    }

    @Then("The user verify {string} table displayed")
    public void theUserVerifyTableReportTableDisplayed(String id) {
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.id(id)),45);

        Assert.assertTrue(id + " tablosu yüklenmedi",
                BrowserUtils.isElementDisplayed(Driver.getDriver().findElement(By.id(id))));
    }

    @Then("The user verify advanced filter group displayed")
    public void theUserVerifyAdvancedFilterGroupDisplayed() {

        BrowserUtils.waitForVisibility(pages.generalPage().getAdvancedFilterContainer(),45);

        Assert.assertTrue("Advanced Filter Group Gelmedi",
                BrowserUtils.isElementDisplayed(pages.generalPage().getAdvancedFilterContainer()));
    }

    @Then("The user verify {string} table has data")
    public void theUserVerifyTableReportTableHasData(String id) {
        WebElement table = Driver.getDriver().findElement(By.id(id));
        Assert.assertTrue("Tabloda veri yok", getColumnData(table,"Fletum Kimlik").size() > 1);
    }

    @Given("The user go to import page")
    public void theUserGoToImportPage() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Import");
    }

    @And("The user accepts the popup OK")
    public void theUserAcceptsThePopupOK() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"modalUploadInfo\"]/div/div/div[3]/button")).click();
    }

    @Given("The user go to family edit page")
    public void theUserGoToFamilyEditPage() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Settings/EditFamily/27");
    }

    @And("The user clicks {string} tab in edit family")
    public void theUserClicksTabInEditFamily(String tabName) {
        List<WebElement> tabs = pages.generalPage().getEditFamilyTabs();

        IntStream.range(1, tabs.size())   // 0 yerine 1 → ilk eleman atlandı
                .mapToObj(tabs::get)
                .filter(el -> el.getText().trim().equalsIgnoreCase(tabName))
                .findFirst()
                .ifPresent(WebElement::click);
        BrowserUtils.wait(3);
    }

    @And("The user click {string} attribute group")
    public void theUserClickAttributeGroup(String attributeGroup) {
        for (WebElement element : pages.generalPage().getEditFamilyAttributeGroups()) {
            if (element.getText().trim().equalsIgnoreCase(attributeGroup)) {
                element.click();
                break;
            }
        }
        BrowserUtils.wait(3);
    }

    @And("The user click {string} check box")
    public void theUserClickCheckBox(String attribute) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='" + attribute +
                "']     /ancestor::label     //input[@type='checkbox']"));

        System.out.println("//span[normalize-space(text())='" + attribute +
                "']     /ancestor::label     //input[@type='checkbox']");

        element.click();
    }

    @And("The user click Save button in family edit page")
    public void theUserClickSaveButtonInFamilyEditPage() {
        Driver.getDriver().findElement(By.xpath("//button[@id='saveButtonFamily']")).click();
    }

    @And("The user clicks save button in edit family save modal")
    public void theUserClicksSaveButtonInEditFamilySaveModal() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"efe-primary-btn-model\"]")).click();
    }

    @When("The user click support button")
    public void theUserClickSupportButton() {
        Driver.getDriver().findElement(By.xpath("//a[@id='userSupportBtn']")).click();
    }

    String uniqueMailBody;
    @When("The user fill support inputs")
    public void theUserFillSupportInputs() {
        uniqueMailBody = UUID.randomUUID().toString();
        System.out.println("uniqueMailBody: " + uniqueMailBody);

        Driver.getDriver().findElement(By.xpath("//input[@id='ticketTitle']")).
                sendKeys("Test Automation Title");

        Driver.getDriver().findElement(By.xpath("//textarea[@id='explanationTicket']")).
                sendKeys("test automation ticket explanation - " + uniqueMailBody);

    }

    @When("The user upload support file")
    public void theUserUploadSupportFile() {
        Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']")).
        sendKeys(getExcelPath("Attribute"));
    }

    @When("The user click send ticket button")
    public void theUserClickSendTicketButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='sendTicket']")).click();
        BrowserUtils.wait(1);
    }

    @Then("The user verify mail is sent")
    public void theUserVerifyMailIsSent() {
        BrowserUtils.wait(5);
        boolean iSent = pages.dbProcess().isSupportMailSent(uniqueMailBody);

        Assert.assertTrue("Support Maili Db'ye düşmedi!!", iSent);

    }

    @When("The user go to roof card item")
    public void theUserGoToRoofCardItem() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Enrich/EditItem/1978203");
    }

    @When("The user click event create button")
    public void theUserClickEventCreateButton() {
        pages.offstand().getSideBarButton().click();
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.xpath("//button[@id='CreateEventButton']")).click();
        BrowserUtils.wait(2);

    }

    String eventName;
    @When("The user fill event create inputs")
    public void theUserFillEventCreateInputs() {
        eventName = UUID.randomUUID().toString();
        Driver.getDriver().findElement(By.xpath("//div[2]/div/div[1]/div[3]/div[1]/div/input")).
                sendKeys(eventName);


        WebElement temasTipSelect = Driver.getDriver().findElement(By.xpath("//select[@id='attribute-4953']"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"select2-attribute-4953-container\"]")).click();
        BrowserUtils.wait(5);
        Driver.getDriver().findElement(By.xpath("/html/body/span/span/span[1]/input")).
                sendKeys("Birebir" + Keys.ENTER);
//        BrowserUtils.selectDropdownOptionByVisibleText(temasTipSelect,"Birebir");

        WebElement tarzStillSelect = Driver.getDriver().findElement(By.xpath("//select[@id='attribute-3822']"));
        BrowserUtils.selectDropdownOptionByRandom(tarzStillSelect,Driver.getDriver());
        Driver.getDriver().findElement(By.xpath("//div[2]/div/div[1]/div[3]/div[3]/div/span")).click();
//        Driver.getDriver().findElement(By.xpath("")).sendKeys("");

        BrowserUtils.selectToday(Driver.getDriver().findElement(By.xpath("//input[@id='DIA_Start_Date_E']")));
        BrowserUtils.selectDate(Driver.getDriver().findElement(By.xpath("//input[@id='DIA_Finish_Date_E']")),
                LocalDate.now().plusDays(10));

        WebElement isCustomerSelect = Driver.getDriver().findElement(By.xpath("//select[@id='attribute-4925']"));
        BrowserUtils.selectDropdownOptionByVisibleText(isCustomerSelect,"Hayır");



    }

    @When("The user click create event button")
    public void theUserClickCreateEventButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='createItem']")).click();
        BrowserUtils.wait(4);
    }

    @When("The user go to attribute page")
    public void theUserGoToAttributePage() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Settings/Attributes");
    }

    @When("The user click import button")
    public void theUserClickImportButton() {
        BrowserUtils.wait(5);
        pages.itemOverviewPage().getItemImportButton().click();
    }

    @When("The user upload the {string} file")
    public void theUserUploadTheFile(String fileName) {
        Driver.getDriver().findElement(By.xpath("//button[contains(@id,'Import')]")).click();
        BrowserUtils.wait(2);
        pages.itemOverviewPage().getItemImportInput().sendKeys(CommonExcelReader.getExcelPath(fileName));
        BrowserUtils.wait(2);
    }

    @When("The user import attribute file")
    public void theUserImportAttributeFile() {
        pages.itemOverviewPage().getItemImportStep2NextButton().click();
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.xpath("//button[@id='import-step-edit']")).click();
        BrowserUtils.wait(1);
        pages.itemOverviewPage().getApplyImportValidationButton().click();
        BrowserUtils.wait(10);
    }

    @Then("The user verifies that attributes are created")
    public void theUserVerifiesThatAttributesAreCreated() {
        boolean isCreated = pages.dbProcess().isAttributeCreated();
    }

    @Then("The user tear down all changes in Attribute Case")
    public void theUserTearDownAllChangesInAttributeCase() {
        pages.dbProcess().deleteTestAttributes();
    }

    @When("The user go to profile page")
    public void theUserGoToProfilePage() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/User/Index");
    }

    @When("The user click password accordion")
    public void theUserClickPasswordAccordion() {
        BrowserUtils.adjustScreenSize(50,Driver.getDriver());
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.xpath("//span[@class='accordion-title']")).click();
    }

    String newPassword;
    @When("The user fill password")
    public void theUserFillPassword() {
        newPassword = UUID.randomUUID().toString();
        Driver.getDriver().findElement(By.xpath("//input[@id='OldPassword']")).
                sendKeys(ConfigurationReader.getProperty("flowsPassword"));
        Driver.getDriver().findElement(By.xpath("//input[@id='NewPassword']")).sendKeys(newPassword);
        Driver.getDriver().findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(newPassword);
        Driver.getDriver().findElement(By.xpath("//button[@name='save']")).click();
    }

    @Then("The user send new password to telegram")
    public void theUserSendNewPasswordToTelegram() {
        BrowserUtils.sendMessageToTelegram("New Password: " + newPassword,"-5196344491");
        BrowserUtils.wait(10);
        ConfigurationReader.setProperty("flowsPassword",newPassword);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.wait(10);
    }

    @When("The user fill password back")
    public void theUserFillPasswordBack() {
        BrowserUtils.adjustScreenSize(50,Driver.getDriver());
        BrowserUtils.wait(2);
        Driver.getDriver().findElement(By.xpath("//input[@id='OldPassword']")).sendKeys(newPassword);

        Driver.getDriver().findElement(By.xpath("//input[@id='NewPassword']")).sendKeys("asdasd123");

        Driver.getDriver().findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("asdasd123");

        Driver.getDriver().findElement(By.xpath("//button[@name='save']")).click();

    }

    @When("The user go to assoc type")
    public void theUserGoToAssocType() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Settings/EditAssociationType?id=283");
    }

    @When("The user select readOnly checkbox")
    public void theUserSelectReadOnlyCheckbox() {
        WebElement assocReadOnlyCheckbox = Driver.getDriver().findElement(By.xpath("//input[@id='readonly']"));

        if (assocReadOnlyCheckbox.getAttribute("old-value").equals("false")) {
            assocReadOnlyCheckbox.click();
            Driver.getDriver().findElement(By.xpath("//button[@id='saveModal_']")).click();
        }

    }

    @And("The user clicks save button in assoc type save modal")
    public void theUserClicksSaveButtonInAssocTypeSaveModal() {

        if (BrowserUtils.isElementDisplayed(By.xpath("//button[@id='savebutton']"))) {
            Driver.getDriver().findElement(By.xpath("//button[@id='savebutton']")).click();
        }

    }

    @When("The user go to account edit item")
    public void theUserGoToAccountEditItem() {
        BrowserUtils.wait(3);
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Enrich/EditItem/1782611");
        BrowserUtils.wait(5);
    }

    @And("The user verify assoc tab disabled")
    public void theUserVerifyAssocTabDisabled() {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//table/thead/tr[1]/th[3]/div/div")).
                getAttribute("class").contains("disabled"));
    }

    @When("The user unselect readOnly checkbox")
    public void theUserUnselectReadOnlyCheckbox() {
        WebElement assocReadOnlyCheckbox = Driver.getDriver().findElement(By.xpath("//input[@id='readonly']"));

        if (assocReadOnlyCheckbox.getAttribute("old-value").equals("true")) {
            assocReadOnlyCheckbox.click();
            Driver.getDriver().findElement(By.xpath("//button[@id='saveModal_']")).click();
        }
    }

    @And("The user verify assoc tab enabled")
    public void theUserVerifyAssocTabEnabled() {
        Assert.assertFalse(Driver.getDriver().findElement(By.xpath("//table/thead/tr[1]/th[3]/div/div")).
                getAttribute("class").contains("disabled"));
    }

    @Given("The user go to edit item {string}")
    public void theUserGoToEditItem(String itemId) {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Enrich/EditItem/" + itemId);
    }


    @When("The user wait {int} second")
    public void theUserWaitSecond(int secondAmount) {
        BrowserUtils.wait(secondAmount);
    }

    @Given("The user go to BackupPage")
    public void theUserGoToBackupPage() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Reports/BackupPage");
    }

    @When("The user select table {string}")
    public void theUserSelectTable(String option) {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"renderBodyWrap\"]/div[2]/div/span/span[1]/span/span[2]")).click();
        BrowserUtils.wait(1);
        WebElement select = Driver.getDriver().findElement(By.xpath("//select[@id='dropdownBackupTables']"));

        BrowserUtils.selectDropdownOptionByVisibleText(select,option);
        BrowserUtils.wait(3);

    }

    WebDriver driver = Driver.getDriver();
    @When("The user impersonate {string}")
    public void theUserImpersonate(String userName) {
        driver.findElement(By.xpath("//tr/td[2][text()='" + userName + "']")).click();
        BrowserUtils.waitForVisibility(pages.generalPage().impersonateHoverBtn, 30);
        BrowserUtils.hoverOver(pages.generalPage().impersonateHoverBtn);
        pages.generalPage().impersonateButton.click();
        BrowserUtils.wait(3);
    }

    @When("The user search in global search {string}")
    public void theUserSearchInGlobalSearch(String searchInput) {
        driver.findElement(By.xpath("//input[@id='globalSearchInput']")).sendKeys(searchInput);
        BrowserUtils.wait(3);
    }

    @Then("The user verify no result")
    public void theUserVerifyNoResult() {
        boolean isNoResultTextVisible = BrowserUtils.isElementDisplayed(By.xpath("//*[@id=\"searchEmpty\"]/div"));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"searchEmpty\"]/div")).getText());
        Assert.assertTrue("No Result Text gelmedi",isNoResultTextVisible);
        Assert.assertEquals("Sonuç bulunamadı", driver.findElement(By.xpath("//*[@id=\"searchEmpty\"]/div")).getText());
    }

    @When("The user go to user manage page")
    public void theUserGoToUserManagePage() {
        driver.get("https://dia-preprod-ui.efectura.com/UserManage");
    }


    @When("The user click bulk action button")
    public void theUserClickBulkActionButton() {
        driver.findElement(By.xpath("//button[@data-original-title='TOPLU EYLEMLER']")).click();
        BrowserUtils.waitForVisibility(By.xpath("//p[.='TOPLU EYLEMLER']"),60);
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(By.id("bulkActionModal"),45);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='bulkActionIframe']")));

    }

    @When("The user select {string} in bulk actions")
    public void theUserSelectInBulkActions(String bulkOption) {
        String locate = "//div[.='" + bulkOption + "']";
//        driver.findElement(By.xpath("//div[.='Kategori Ekle']")).click();

        By kategoriEkle = By.xpath("//*[normalize-space(.)='Kategori Ekle']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(kategoriEkle));

        // Bazı UI'larda element görünür ama üstünde başka layer olur -> önce scroll
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        el.click();

        driver.findElement(By.xpath("//button[.='İleri']")).click();
    }

    @When("The user select {string} under {string}")
    public void theUserSelectUnder(String sub, String main) {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div/div/div[2]/div/div/div[1]/div[1]/div[2]/label")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div/span/span[2]")).click();
        BrowserUtils.wait(3);

    }
}
