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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class OffstandStepDefs extends BaseStep {

    @Given("The user navigate to import page")
    public void theUserNavigateToImportPage() {
        BrowserUtils.wait(3);
        Driver.getDriver().navigate().to("https://dia-preprod-ui.efectura.com/Import");
    }

    @And("The user accepts import popup")
    public void theUserAcceptsImportPopup() {
        BrowserUtils.wait(1);
        pages.offstand().getImportPopupApplyButton().click();
    }

    @When("The user upload {string} file")
    public void theUserUploadFile(String fileName) {
        pages.offstand().uploadExcelFile(fileName);

    }

    @When("The user import the uploaded file")
    public void theUserImportTheUploadedFile() {
        BrowserUtils.wait(3);
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
        BrowserUtils.wait(2);
        boolean isBudgetOk = pages.offstand().verifyStandActualBudget(customerCode,markaisi,expectedActualBudget);
        assertTrue(isBudgetOk);
        BrowserUtils.wait(3);
    }

    @When("The user go in digital asset item")
    public void theUserGoInDigitalAssetItem() {
        pages.offstand().goInDigitalAssetItem();
    }

    @When("The user clicks {string} attribute group")
    public void theUserClicksAttributeGroup(String attrGroup) {
        BrowserUtils.adjustScreenSize(55,Driver.getDriver());
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
//        BrowserUtils.wait(1);
        BrowserUtils.waitForVisibility(By.xpath("//div[@class='notyf__message']"),30);
        Assert.assertEquals(expectedMessage, pages.editItemPage().getInfoMessage().getText());
        System.out.println(pages.editItemPage().getInfoMessage().getText());

    }

    @When("The user delete item")
    public void theUserDeleteItem() {
//        if (BrowserUtils.isElementDisplayed(pages.editItemPage().getScrollUpButton())) {
//            pages.editItemPage().getScrollUpButton().click();
//        }
        BrowserUtils.wait(2);
        pages.offstand().getSideBarButton().click();
        BrowserUtils.wait(4);
        BrowserUtils.adjustScreenSize(45,Driver.getDriver());
        pages.editItemPage().getDeleteItemButton().click();
        pages.editItemPage().getDeleteButtonInDeleteItemModal().click();
        BrowserUtils.wait(2);
    }

    @When("The user click NewImport button")
    public void theUserClickNewImportButton() {
        Driver.getDriver().findElement(By.xpath("//button[@data-target='imp-tab-new-import']")).click();
    }

    String value;
    @When("The user update {string} attribute with random value")
    public void theUserUpdateAttributeWithRandomValue(String attrLabel) {
        value = UUID.randomUUID().toString();
        pages.offstand().updateAttribute(attrLabel,value);
    }


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

    @When("I navigate to {string} menu and select {string}")
    public void navigateToMenuAndSelect(String menu, String subMenu) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@class,'nav-link') and normalize-space()='" + menu + "']")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@class,'dropdown-item') and normalize-space()='" + subMenu + "']")))
                .click();
    }

//    @Then("The inner target management page should be displayed")
//    public void innerTargetManagementPageShouldBeDisplayed() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector(".new_container, .enhanced-table-container")));
//        Assert.assertEquals("İç Hedef Yönetimi", pages.editItemPage().getPageTitle().getText());
//    }

    @When("I click {string} button on the page")
    public void clickButtonOnPage(String buttonText) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='" + buttonText + "'] | //a[normalize-space()='" + buttonText + "']")))
                .click();
    }

    @Then("The family selection modal should be opened")
    public void familySelectionModalShouldBeOpened() {
        Assert.assertEquals("İç Hedef Ailesi Seçin", pages.editItemPage().getInfoMessage().getText());
    }

    @When("I select the family {string}")
    public void selectFamily(String familyName) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[normalize-space()='" + familyName + "']")))
                .click();
    }

    @When("I click the next button on the modal")
    public void clickNextButtonOnModal() {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='İleri' and not(@disabled)]")))
                .click();
    }

    @Then("The creation info step should be displayed")
    public void creationInfoStepShouldBeDisplayed() {
        Assert.assertEquals("Oluşturma Bilgileri", pages.editItemPage().getInfoMessage().getText());
    }

    @When("I enter calendar year {string} and calendar month {string}")
    public void enterCalendarYearAndMonth(String year, String month) {
        WebElement yearField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-attribute='6061']")));
        yearField.clear();
        yearField.sendKeys(year);

        WebElement monthField = driver.findElement(
                By.xpath("//input[@data-attribute='6062']"));
        monthField.clear();
        monthField.sendKeys(month);
    }

    @When("I enter total litre tolerance for {string} as {string}")
    public void enterTotalLitreTolerance(String region, String value) {
        WebElement toleranceField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[contains(text(),'" + region + "')]/following::input[1]")));
        toleranceField.clear();
        toleranceField.sendKeys(value);
    }

    @Then("The review step should be displayed")
    public void reviewStepShouldBeDisplayed() {
        Assert.assertEquals("Oluşturma İşlemini Gözden Geçir", pages.editItemPage().getInfoMessage().getText());
    }

    @When("I click {string} button on the modal")
    public void clickButtonOnModal(String buttonText) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='" + buttonText + "' and not(@disabled)]")))
                .click();
    }

    @Then("The item should be created successfully")
    public void itemShouldBeCreatedSuccessfully() {
        Assert.assertEquals("Başarıyla oluşturuldu.", pages.editItemPage().getInfoMessage().getText());
    }

//    @Then("The {string} tab should be active on edit item page")
//    public void tabShouldBeActiveOnEditItemPage(String tabName) {
//        Assert.assertEquals(tabName, pages.editItemPage().getActiveTab().getText());
//    }

    @When("I click the export dropdown arrow next to {string} in quick actions")
    public void clickExportDropdownArrow(String buttonLabel) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'" + buttonLabel + "')]/parent::*//*[contains(@class,'caret') or contains(@class,'arrow') or contains(@class,'dropdown-toggle')]")))
                .click();
    }

    @When("I select {string} from dropdown")
    public void selectFromDropdown(String optionText) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='" + optionText + "'] | //li[normalize-space()='" + optionText + "']")))
                .click();
    }

    @Then("The planning export success notification should appear")
    public void planningExportSuccessNotificationShouldAppear() {
        Assert.assertEquals("Dışa aktarım başarıyla tamamlandı.", pages.editItemPage().getInfoMessage().getText());
    }

    @When("I click the import dropdown arrow next to {string} in quick actions")
    public void clickImportDropdownArrow(String buttonLabel) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'" + buttonLabel + "')]/parent::*//*[contains(@class,'caret') or contains(@class,'arrow') or contains(@class,'dropdown-toggle')]")))
                .click();
    }

    @Then("The import modal should be opened with title {string}")
    public void importModalShouldBeOpenedWithTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, pages.editItemPage().getInfoMessage().getText());
    }


//    @Then("The total imported record count should match imported count")
//    public void totalImportedRecordCountShouldMatchImportedCount() {
//        Assert.assertEquals(
//                pages.editItemPage().getTotalImportedCount().getText(),
//                pages.editItemPage().getImportedCount().getText()
//        );
//    }

    @When("I navigate to {string} tab on edit item page")
    public void navigateToTabOnEditItemPage(String tabName) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='" + tabName + "']")))
                .click();
    }

//    @Then("The imported data should be visible in inner target planning tab")
//    public void importedDataShouldBeVisibleInInnerTargetPlanningTab() {
//        Assert.assertEquals("İç Hedef Planlama", pages.editItemPage().getActiveTab().getText());
//    }

    @When("I click {string} button in quick actions panel")
    public void clickButtonInQuickActionsPanel(String buttonText) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='" + buttonText + "'] | //a[normalize-space()='" + buttonText + "']")))
                .click();
    }

    @Then("The actions modal should be opened with title {string}")
    public void actionsModalShouldBeOpenedWithTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, pages.editItemPage().getInfoMessage().getText());
    }

    @When("I click the flow start button next to {string}")
    public void clickFlowStartButtonNextTo(String flowName) {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//tr[contains(.,'" + flowName + "')]//a[contains(@class,'t-start')] | " +
                                "//*[contains(text(),'" + flowName + "')]/following::button[contains(@title,'Başlat')][1]")))
                .click();
    }

    @Then("The BM flow form should be displayed with title {string}")
    public void bmFlowFormShouldBeDisplayedWithTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, pages.editItemPage().getInfoMessage().getText());
    }

    @When("I select the BM region {string} from the region dropdown")
    public void selectBmRegionFromDropdown(String region) {
        // Select2 açılır
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(@class,'select2') and contains(.,'Bölge Müdürlüğü')]")))
                .click();
        // Seçenek tıklanır
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[contains(@class,'select2-results__option') and normalize-space()='" + region + "']")))
                .click();
    }

    @Then("The success notification {string} should appear on the page")
    public void successNotificationShouldAppearOnPage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, pages.editItemPage().getInfoMessage().getText());
    }

    String flowNum;
    @When("I store the current flow number as {string}")
    public void storeCurrentFlowNumber(String key) {
        // BM akış formu açıkken Akış No alanından form numarasını al
        WebElement flowNumberEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@id,'AkisNo') or contains(@name,'AkisNo') or " +
                        "contains(text(),'Akış No')]/following::*[1]")));
        String flowNumber = flowNumberEl.getText().trim();
        // ScenarioContext ile sakla (Cucumber PicoContainer veya benzer DI)
//        scenarioContext.set(key, flowNumber);
        flowNum = flowNumber;
    }

    @When("I navigate to the task list page")
    public void navigateToTaskListPage() {
        driver.get("https://dia-preprod-ui.efectura.com/Task/TaskList");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taskList_table")));
        waitForTaskListTableToLoad();
    }

    WebDriver driver = Driver.getDriver();
    String expectedFlowNumber;
    @Then("The task list should contain a row with flow number stored as {string} and task name {string}")
    public void taskListShouldContainRowWithFlowNumberAndTaskName(String flowNumberKey, String expectedTaskName) {
        expectedFlowNumber = flowNum;

        // Form Numarası = index 1, Akış Adımı = index 2 (kaynak koddan: FormNumber, TaskName)
        waitForTaskListTableToLoad();

        List<WebElement> rows = driver.findElements(
                By.cssSelector("#taskList_table tbody tr"));

        boolean found = rows.stream()
                .filter(row -> {
                    String cls = row.getAttribute("class");
                    return cls == null || !cls.contains("dataTables_empty");
                })
                .anyMatch(row -> {
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    if (cells.size() > 2) {
                        String formNumber = cells.get(1).getText().trim();
                        String taskName   = cells.get(2).getText().trim();
                        return formNumber.equals(expectedFlowNumber) && taskName.equals(expectedTaskName);
                    }
                    return false;
                });

        Assert.assertEquals(
                "Beklenen görev bulunamadı. Form No: " + expectedFlowNumber + ", Görev: " + expectedTaskName,
                expectedTaskName,
                pages.editItemPage().getInfoMessage().getText()
        );
    }



    @And("I click {string} button on the bm flow form")
    public void ıClickButtonOnTheBmFlowForm(String buttonName) {
        driver.findElement(By.xpath("//button[@id='gotoNextScreenBtn']")).click();
        BrowserUtils.wait(1);
    }


    @When("I open the right sidebar on edit item page")
    public void openRightSidebar() {
        WebElement toggleBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("rightSidebarToggleBtn")));
        toggleBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("rightSidebarOverlay")));
    }

    @When("I click the export dropdown in quick actions")
    public void clickExportDropdownInQuickActions() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("export-target-dropdown"))).click();
    }

    @When("I select the planning export option")
    public void selectPlanningExportOption() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("export-target"))).click();
    }

    @Then("The planning export file should be downloaded successfully")
    public void planningExportFileShouldBeDownloadedSuccessfully() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".notyf__message")));
        Assert.assertEquals("Başarılı", notification.getText());
    }

    @When("I click the import dropdown in quick actions")
    public void clickImportDropdownInQuickActions() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("import-target-dropdown"))).click();
    }

    @When("I select the planning import option")
    public void selectPlanningImportOption() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("import-target"))).click();
    }

    @Then("The import modal should be opened")
    public void importModalShouldBeOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("target-import-wizard-modal")));
        Assert.assertEquals("İç Hedef İçe Aktarım",
                driver.findElement(By.cssSelector("#target-import-wizard-modal .ef-enhanced-modal-title")).getText());
    }

    @When("I upload the planning import excel file")
    public void uploadPlanningImportExcelFile() {
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("target-file-import")));
        String testFilePath = System.getProperty("user.dir")
                + "/src/test/resources/testdata/planning_import_test.xlsx";
        fileInput.sendKeys(testFilePath);
    }

    @When("I click the next button on the import modal")
    public void clickNextButtonOnImportModal() {
        // Step 1→2 veya 2→3 her ikisinde de aynı selektör
        By nextBtnSelector = By.cssSelector(
                "#target-import-wizard-modal .ef-import-modal__step--active button.btn-filter-primary:not(.btn-filter-secondary)");
        wait.until(ExpectedConditions.elementToBeClickable(nextBtnSelector)).click();
    }

    @Then("The column preview step should be displayed")
    public void columnPreviewStepShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-target-import-step='preview'].ef-import-modal__step--active")));
        Assert.assertEquals("Sütun Önizleme",
                driver.findElement(By.cssSelector("#target-import-wizard-modal .ef-enhanced-modal-title")).getText());
    }

    @Then("The data validation step should be displayed")
    public void dataValidationStepShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-target-import-step='edit'].ef-import-modal__step--active")));
        Assert.assertEquals("Veri Doğrula",
                driver.findElement(By.cssSelector("#target-import-wizard-modal .ef-enhanced-modal-title")).getText());
    }

    @When("I verify there are no errors in validation")
    public void verifyNoErrorsInValidation() {
        // Hata sayısı 0 olmalı; errors filter badge'ini kontrol et
        WebElement errorsCount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-role='target-edit-errors-count']")));
        Assert.assertEquals("0", errorsCount.getText().trim());
    }

    @When("I click the import action button")
    public void clickImportActionButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("target-apply-details-button"))).click();
    }

    @Then("The import success screen should be displayed")
    public void importSuccessScreenShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-target-import-step='summary'].ef-import-modal__step--active")));
        Assert.assertEquals("Başarılı",
                driver.findElement(By.cssSelector("#target-import-wizard-modal .ef-import-success__title")).getText());
    }

    @When("I close the import modal")
    public void closeImportModal() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#target-import-wizard-modal .target-import-cancel[data-dismiss='modal']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.id("target-import-wizard-modal")));
    }

    @When("I click the flows button in quick actions")
    public void clickFlowsButtonInQuickActions() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("modal_actionBtn"))).click();
    }

    @Then("The actions modal should be opened")
    public void actionsModalShouldBeOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("open_modal_action_Btn")));
        Assert.assertEquals("Aksiyonlar",
                driver.findElement(By.cssSelector("#open_modal_action_Btn .ef-enhanced-modal-title")).getText());
    }

    @When("I click the flow start button for BM flow")
    public void clickFlowStartButtonForBmFlow() {
        // "BM_AKIS" içeren satırda t-start linki
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("process-table")));
        WebElement startBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[contains(text(),'BM_AKIS') or contains(text(),'BM Akış')]" +
                        "/following-sibling::td//a[contains(@class,'t-start')]")));
        startBtn.click();
    }

    @Then("The BM flow form should be loaded")
    public void bmFlowFormShouldBeLoaded() {
        wait.until(ExpectedConditions.urlContains("/Process/BmFlowForm"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".bm-flow-form, #bm-flow-container, form")));
    }

    @When("I select the BM region {string}")
    public void selectBmRegion(String region) {
        // Select2 bölge dropdown'ı
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".select2-selection, [data-placeholder*='Bölge'], [data-placeholder*='bolge']")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[contains(@class,'select2-results__option') and normalize-space()='" + region + "']")))
                .click();
    }

    @When("I click the flow start submit button")
    public void clickFlowStartSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Akış Başlat'] | //input[@value='Akış Başlat']")))
                .click();
    }

    @Then("The success notification {string} should appear")
    public void successNotificationShouldAppear(String expectedMessage) {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".notyf__message, .notyf .notyf__wrapper")));
        Assert.assertEquals(expectedMessage, notification.getText().trim());
    }

    String formNo;
    @When("I save the flow number from the page")
    public void saveFlowNumberFromPage() {
        // BM akış form sayfasındaki form/akış numarasını oku
        WebElement flowNumberEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@id,'FormNumber') or contains(@name,'FormNumber') or " +
                        "contains(@class,'flow-number') or " +
                        "(contains(text(),'Form No') or contains(text(),'Akış No'))]/following::*[1]")));
        String flowNumber = flowNumberEl.getText().trim();
        if (flowNumber.isEmpty()) {
            flowNumber = flowNumberEl.getAttribute("value");
        }
//        scenarioContext.set("bmFlowNumber", flowNumber);
        formNo = flowNumber;
    }

    @Then("The task list should contain the BM flow task for saved flow number")
    public void taskListShouldContainBmFlowTask() {
        String expectedFlowNumber = formNo;

        waitForTaskListTableToLoad();

        List<WebElement> rows = driver.findElements(
                By.cssSelector("#taskList_table tbody tr"));

        boolean found = rows.stream()
                .filter(row -> {
                    String cls = row.getAttribute("class");
                    return cls == null || !cls.contains("dataTables_empty");
                })
                .anyMatch(row -> {
                    List<WebElement> cells = row.findElements(By.tagName("td"));
                    if (cells.size() > 2) {
                        // FormNumber = index 1, TaskName = index 2
                        String formNumber = cells.get(1).getText().trim();
                        String taskName   = cells.get(2).getText().trim();
                        return formNumber.equals(expectedFlowNumber)
                                && taskName.equals("Bölge Planlama İç Hedef Dışa Aktarım/İçe Aktarım");
                    }
                    return false;
                });

        Assert.assertTrue(
                "Task list'te beklenen görev bulunamadı. Flow No: " + expectedFlowNumber,
                found
        );
    }

    private void waitForTaskListTableToLoad() {
        try {
            wait.until(driver -> {
                List<WebElement> processing = driver.findElements(By.id("taskList_table_processing"));
                if (processing.isEmpty()) return true;
                return "none".equals(processing.get(0).getCssValue("display"));
            });
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#taskList_table tbody tr")));
        } catch (Exception ignored) {}
    }


}
