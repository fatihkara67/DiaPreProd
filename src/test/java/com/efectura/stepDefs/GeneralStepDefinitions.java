package com.efectura.stepDefs;

import com.efectura.pages.BasePage;
import com.efectura.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.guieffect.qual.UI;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
//        BrowserUtils.adjustScreenSize(70, Driver.getDriver());
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
            System.out.println("actualValue: " + actualValue + " | expectedValue: " + expectedValue);
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

        List<WebElement> textareas = driver.findElements(By.xpath("//textarea[contains(@class,'fixed-textarea')]"));

        WebElement activeTextarea = textareas.stream()
                .filter(WebElement::isDisplayed)
                .filter(WebElement::isEnabled)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Interactable textarea bulunamadı"));


        if (BrowserUtils.isElementDisplayed(activeTextarea)) {
            activeTextarea.sendKeys(comment);
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
        BrowserUtils.waitForVisibility(pages.generalPage().getInfoMessage(),18);
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
        BrowserUtils.adjustScreenSize(75,driver);
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[normalize-space(text())='" + attribute +
                "']     /ancestor::label     //input[@type='checkbox']"));

        System.out.println("//span[normalize-space(text())='" + attribute +
                "']     /ancestor::label     //input[@type='checkbox']");

        BrowserUtils.moveToElement(element);

        element.click();
    }

    @And("The user click Save button in family edit page")
    public void theUserClickSaveButtonInFamilyEditPage() {
        Driver.getDriver().findElement(By.xpath("//button[@id='saveChangeButton']")).click();
    }

    @And("The user clicks save button in edit family save modal")
    public void theUserClicksSaveButtonInEditFamilySaveModal() {
        BrowserUtils.wait(1);
        Driver.getDriver().findElement(By.xpath("//button[@id='saveButtonFamily']")).click();
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



    private final WebDriver driver = Driver.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    // -----------------------------------------------------------------------
    // Given
    // -----------------------------------------------------------------------

    @Given("the user opens the {string} modal")
    public void theUserOpensTheModal(String modalTitle) {
        // Modal'ın body'de görünür olduğunu doğrula
        WebElement modal = BrowserUtils.waitForVisibility(
                By.cssSelector(".ef-enhanced-modal-dialog"), 15);
        WebElement title = modal.findElement(By.cssSelector(".ef-enhanced-modal-title"));
        assert title.getText().contains(modalTitle)
                : "Beklenen modal başlığı: " + modalTitle + ", bulunan: " + title.getText();
    }

    // -----------------------------------------------------------------------
    // When – plain text inputs
    // -----------------------------------------------------------------------

    @When("the user fills the {string} input field with {string}")
    public void theUserFillsTheInputFieldWith(String fieldLabel, String value) {
        WebElement input;

        switch (fieldLabel) {
            case "Kod":
                input = BrowserUtils.waitForVisibility(By.id("inputCode"), 10);
                input.clear();
                input.sendKeys(value);
                break;

            case "Etkinlik Adı":
                // id içinde boşluk olduğu için CSS attribute selector kullanıyoruz
                input = BrowserUtils.waitForVisibility(
                        By.cssSelector("input.DIA_Event_Name"), 10);
                input.clear();
                input.sendKeys(value);
                break;

            default:
                throw new IllegalArgumentException("Tanımsız input alanı: " + fieldLabel);
        }
    }

    // -----------------------------------------------------------------------
    // When – Select2 single-select dropdowns
    // -----------------------------------------------------------------------

    @When("the user selects {string} from the {string} dropdown")
    public void theUserSelectsFromTheDropdown(String optionText, String fieldLabel) {

        String nativeSelectId = resolveNativeSelectId(fieldLabel);

        // 1) Select2'nin görünür wrapper span'ine tıkla (dropdown'ı açar)
        WebElement select2Opener = BrowserUtils.waitForClickability(
                By.cssSelector("#" + nativeSelectId
                        + " + span.select2-container .select2-selection"), 10);
        select2Opener.click();

        // 2) Açılan arama kutusuna seçmek istediğimiz metni yaz
        WebElement searchInput = BrowserUtils.waitForVisibility(
                By.cssSelector(".select2-container--open .select2-search__field"), 10);
        searchInput.clear();
        searchInput.sendKeys(optionText);
        BrowserUtils.wait(1);

        // 3) Filtrelenmiş listede tam eşleşen seçeneğe tıkla
        WebElement option = BrowserUtils.waitForClickability(
                By.xpath("//ul[contains(@class,'select2-results__options')]"
                        + "/li[normalize-space(text())='" + optionText + "']"), 10);
        option.click();
    }

    // -----------------------------------------------------------------------
    // When – Select2 multi-select dropdowns
    // -----------------------------------------------------------------------

    @When("the user selects {string} from the {string} multi-select dropdown")
    public void theUserSelectsFromTheMultiSelectDropdown(String optionText, String fieldLabel) {

        String nativeSelectId = resolveNativeSelectId(fieldLabel);

        // 1) Multi-select için selection alanına tıkla (ul içindeki search li'si dropdown'ı açar)
        WebElement select2Selection = BrowserUtils.waitForClickability(
                By.cssSelector("#" + nativeSelectId
                        + " + span.select2-container .select2-selection--multiple"), 10);
        select2Selection.click();

        // 2) Açılan search input'a metni yaz
        WebElement searchInput = BrowserUtils.waitForVisibility(
                By.cssSelector(".select2-container--open .select2-search__field"), 10);
        searchInput.clear();
        searchInput.sendKeys(optionText);

        // 3) Filtrelenmiş listede tam eşleşen seçeneğe tıkla
        WebElement option = BrowserUtils.waitForClickability(
                By.xpath("//ul[contains(@class,'select2-results__options')]"
                        + "/li[normalize-space(text())='" + optionText + "']"), 10);
        option.click();
    }

    // -----------------------------------------------------------------------
    // When – Quill rich text editor
    // -----------------------------------------------------------------------

    @When("the user fills the {string} rich text editor with {string}")
    public void theUserFillsTheRichTextEditorWith(String fieldLabel, String text) {
        // Quill'in contenteditable div'i
        WebElement quillEditor = BrowserUtils.waitForVisibility(
                By.cssSelector(".ql-editor[contenteditable='true']"), 10);
        BrowserUtils.moveToElement(quillEditor);
        quillEditor.click();
        quillEditor.clear();
        quillEditor.sendKeys(text);
    }

    // -----------------------------------------------------------------------
    // When – Flatpickr date inputs
    // -----------------------------------------------------------------------

    @When("the user fills the {string} date field with {string}")
    public void theUserFillsTheDateFieldWith(String fieldLabel, String dateValue) {
        String inputId;

        switch (fieldLabel) {
            case "Başlangıç Tarihi":
                inputId = "DIA_Start_Date_E";
                break;
            case "Bitiş Tarihi":
                inputId = "DIA_Finish_Date_E";
                break;
            default:
                throw new IllegalArgumentException("Tanımsız tarih alanı: " + fieldLabel);
        }

        // Flatpickr input readonly olduğu için JS ile değer set ediyoruz
        WebElement dateInput = BrowserUtils.waitForVisibility(By.id(inputId), 10);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('readonly');", dateInput);
        dateInput.clear();
        dateInput.sendKeys(dateValue);

        // Flatpickr instance'ına değeri set et
        ((JavascriptExecutor) driver).executeScript(
                "const fp = document.getElementById(arguments[0])._flatpickr; " +
                        "if(fp){ fp.setDate(arguments[1], true); }", inputId, dateValue);
    }

    // -----------------------------------------------------------------------
    // When – Button click
    // -----------------------------------------------------------------------

    @When("the user clicks the {string} button")
    public void theUserClicksTheButton(String buttonLabel) {
        WebElement button;

        switch (buttonLabel) {
            case "Yeni Oluştur":
                button = BrowserUtils.waitForClickability(By.id("createItem"), 10);
                break;
            case "İptal Et":
                button = BrowserUtils.waitForClickability(By.id("cancelItem"), 10);
                break;
            default:
                // Genel fallback: button text'e göre bul
                button = BrowserUtils.waitForClickability(
                        By.xpath("//button[normalize-space(text())='" + buttonLabel + "']"), 10);
        }

        button.click();
    }

    // -----------------------------------------------------------------------
    // Then
    // -----------------------------------------------------------------------

    @Then("the new product should be created successfully")
    public void theNewProductShouldBeCreatedSuccessfully() {
        // Modal kapandıktan sonra başarı mesajı veya toast kontrolü yapılır.
        // Projedeki toast/notification yapısına göre güncelle.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".ef-enhanced-modal-dialog")));
        System.out.println("Yeni ürün başarıyla oluşturuldu.");
    }

    // -----------------------------------------------------------------------
    // Helper – Alan adını native select id'ye çevir
    // -----------------------------------------------------------------------

    /**
     * Feature dosyasındaki Türkçe alan adını HTML'deki native select id'ye eşler.
     * Select2 her zaman gizli bir native <select> ile çalışır;
     * select'i programatik olarak değiştirip change event'ini tetiklemek
     * en güvenilir yöntemdir.
     */
    private String resolveNativeSelectId(String fieldLabel) {
        switch (fieldLabel) {
            case "Temas Tipi":            return "attribute-4953";
            case "Tarz / Stil":           return "attribute-3822";
            case "İlgili Ürün":           return "attribute-4951";
            case "İlgili Marka":          return "attribute-5028";
            case "Etkinlik Türü":         return "attribute-3821";
            case "Şehir":                 return "attribute-4922";
            case "Müşteri Ortamında mı?": return "attribute-4925";
            case "Ajans Seçimi":          return "attribute-6024";
            default:
                throw new IllegalArgumentException(
                        "Bilinmeyen dropdown alanı: " + fieldLabel);
        }
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
        BrowserUtils.wait(2);
        pages.itemOverviewPage().getImportInput().sendKeys(CommonExcelReader.getExcelPath(fileName));
        BrowserUtils.wait(2);
    }

    @When("The user import attribute file")
    public void theUserImportAttributeFile() {
        BrowserUtils.adjustScreenSize(70,driver);
        BrowserUtils.moveToElement(pages.itemOverviewPage().getItemImportStep2NextButton());
        BrowserUtils.wait(1);
        pages.itemOverviewPage().getItemImportStep2NextButton().click();
        BrowserUtils.wait(5);
        BrowserUtils.waitForVisibility(By.xpath("//button[contains(@id,'import-step-edit')]"),40);
        Driver.getDriver().findElement(By.xpath("//button[contains(@id,'import-step-edit')]")).click();
        BrowserUtils.wait(1);
        BrowserUtils.waitForVisibility(By.xpath("//button[contains(@id,'import-apply-button')]"),40);
        Driver.getDriver().findElement(By.xpath("//button[contains(@id,'import-apply-button')]")).click();
        BrowserUtils.wait(420);
    }

    @Then("The user verifies that attributes are created")
    public void theUserVerifiesThatAttributesAreCreated() {
        boolean isCreated = pages.dbProcess().isAttributeCreated();
        Assert.assertTrue("Attribute'lar oluşturulmadı!!",isCreated);
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
            driver.findElement(By.xpath("//button[@id='saveChangeButton']")).click();
            driver.findElement(By.xpath("//textarea[@id='floatingComment']")).sendKeys("Test Automation - Unselect ReadOnly");
            Driver.getDriver().findElement(By.xpath("//button[@id='floatingSaveButton']")).click();
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
            driver.findElement(By.xpath("//button[@id='saveChangeButton']")).click();
            driver.findElement(By.xpath("//textarea[@id='floatingComment']")).sendKeys("Test Automation - Unselect ReadOnly");
            Driver.getDriver().findElement(By.xpath("//button[@id='floatingSaveButton']")).click();
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
        BrowserUtils.waitForVisibility(By.xpath("//p[.='TOPLU EYLEMLER']"),70);
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(By.id("bulkActionModal"),45);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='bulkActionIframe']")));

    }

    @When("The user select {string} in bulk actions")
    public void theUserSelectInBulkActions(String bulkOption) {
//        BrowserUtils.adjustScreenSize(80,driver);
        BrowserUtils.wait(3);
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='bulkActionIframe']")));
        String locate = "//div[.='" + bulkOption + "']";
//        driver.findElement(By.xpath("//div[.='Kategori Ekle']")).click();

        By kategoriEkle = By.xpath("//*[normalize-space(.)='Kategori Ekle']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(kategoriEkle));

//        driver.findElement(By.xpath(locate)).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[4]/div[2]")).click();

        // Bazı UI'larda element görünür ama üstünde başka layer olur -> önce scroll
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
//        el.click();

        BrowserUtils.moveToElement(driver.findElement(By.xpath("//button[.='İleri']")));
        driver.findElement(By.xpath("//button[.='İleri']")).click();
    }

    @When("The user select {string} under {string}")
    public void theUserSelectUnder(String sub, String main) {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div/div/div[1]/div[1]/div")).click();
        driver.findElement(By.xpath("//.[.='IWSA']")).click();
        driver.findElement(By.xpath("//.[.='Genel [7]']")).click();
        BrowserUtils.wait(3);

    }

    @When("The user close item card")
    public void theUserCloseItemCard() {
        if (!pages.membershipAccountRulePage().getAccordionButton().getAttribute("class").contains("active")) {
            pages.membershipAccountRulePage().getAccordionButton().click();
        }
        BrowserUtils.wait(1);
    }

    @Then("The user verify {string} date filter with value today in {string}")
    public void theUserVerifyDateFilterWithValueTodayIn(String columnName, String table) {
        BrowserUtils.wait(2);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty(table)));
        List<String> values =  getColumnData(tableElement,columnName);
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println(values);
        BrowserUtils.wait(2);
        for (String actualValue : values) {
            Assert.assertTrue(actualValue.split(" ")[0].contains(today));
//            Assert.assertEquals(expectedValue,actualValue);
        }
    }

    String randomComment;
    @And("The user enters random in comment area")
    public void theUserEntersRandomInCommentArea() {
        //        pages.contactEditPage().setChangeCommentArea(comment);
        BrowserUtils.wait(2);
//        BrowserUtils.waitForVisibility(pages.generalPage().getChangeSaveCommentTextArea(),15);
        randomComment = UUID.randomUUID().toString();
        if (BrowserUtils.isElementDisplayed(By.xpath("//textarea[@id='comment']"))) {
            pages.generalPage().getChangeSaveCommentTextArea().sendKeys(randomComment);
        }
    }

    @Then("The user verify history table comment")
    public void theUserVerifyHistoryTableComment() {
        String historyLastComment = driver.findElement(By.xpath("//*[@id='history_table_ItemNewHistory']/tbody/tr[1]/td[4]")).getText();

        Assert.assertEquals(randomComment, historyLastComment);

    }

    @And("The user select item at order {int} in association tab")
    public void theUserSelectItemAtOrderInAssociationTab(int assocCheckboxOrder) {
        pages.editItemPage().selectItemAtOrderInAssociationTab(assocCheckboxOrder);
    }

    @When("The user go to {string} attribute page")
    public void theUserGoToAttributePage(String attributeLabel) throws SQLException {
//        int attributeId = pages.dbProcess().getAttributeIdByLabel(attributeLabel);
        String query = "SELECT Id FROM Attributes WHERE Code = 'Event_Type'";
        ResultSet rs = Database.getInstance().createStatement().executeQuery(query);
        rs.next();
        int attributeId = rs.getInt("Id");

        System.out.println("attr id: " + attributeId);
        driver.get("https://dia-preprod-ui.efectura.com/Settings/EditAttribute/" + attributeId);
        driver.get("https://dia-preprod-ui.efectura.com/Settings/EditAttribute?id=" + attributeId);
        BrowserUtils.wait(3);
    }

    String randomDefaultValueString;
    @When("The user fill default value input with random string")
    public void theUserFillDefaultValueInputWithRandomString() {
        randomDefaultValueString = UUID.randomUUID().toString();

        WebElement input = driver.findElement(By.xpath("//h6[contains(.,'Varsayılan Değer Metni')]/following-sibling::input"));

        input.sendKeys(Keys.CONTROL + "a"); // hepsini seç
        input.sendKeys(Keys.DELETE);        // sil
        input.sendKeys(randomDefaultValueString);
    }

    @When("The user click save button in attribute edit page")
    public void theUserClickSaveButtonInAttributeEditPage() {
        driver.findElement(By.xpath("//button[@id='savebutton']")).click();
    }

    @When("The user click save button in attribute edit page save modal")
    public void theUserClickSaveButtonInAttributeEditPageSaveModal() {
        driver.findElement(By.xpath("//button[@id='saveButtonAttr']")).click();
    }

    @Then("The user verify {string} attribute default value is random in create page")
    public void theUserVerifyAttributeDefaultValueIsRandomInCreatePage(String attributeLabel) {
        int attributeId = pages.dbProcess().getAttributeIdByLabel(attributeLabel);

        String locate = "//input[@data-attribute='" + attributeId + "']";
        WebElement attributeInputElement = driver.findElement(By.xpath(locate));

        Assert.assertEquals("Default attribute değeri create sırasında gelmedi",
                randomDefaultValueString, BrowserUtils.getValueInInputBox(attributeInputElement));

    }

    @When("The user clicks {string} button")
    public void theUserClicksButton(String buttonName) {
        driver.findElement(By.xpath("//button[.='" + buttonName + "']")).click();
        BrowserUtils.wait(2);
    }

    @When("The user send fillReserveReport endpoint request")
    public void theUserSendFillReserveReportEndpointRequest() {
        String response = BrowserUtils.sendFillOfftradeReserveTrackingReportRequest();
        Assert.assertTrue("Fill Reserve Report Endpoint requesti başarısız", response.contains("Finished"));
    }

    @When("The user fills the {string} input field with random value")
    public void theUserFillsTheInputFieldWithRandomValue(String fieldLabel) {
        WebElement input;
        String value = UUID.randomUUID().toString();

        switch (fieldLabel) {
            case "Kod":
                input = BrowserUtils.waitForVisibility(By.id("inputCode"), 10);
                input.clear();
                input.sendKeys(value);
                break;

            case "Etkinlik Adı":
                // id içinde boşluk olduğu için CSS attribute selector kullanıyoruz
                input = BrowserUtils.waitForVisibility(
                        By.cssSelector("input.DIA_Event_Name"), 10);
                input.clear();
                input.sendKeys(value);
                break;

            default:
                throw new IllegalArgumentException("Tanımsız input alanı: " + fieldLabel);
        }
    }
}
