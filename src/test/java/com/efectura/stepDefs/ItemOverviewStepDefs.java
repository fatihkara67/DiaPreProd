package com.efectura.stepDefs;

import com.efectura.pages.BPM.Offstand;
import com.efectura.utilities.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static com.efectura.pages.BasePage.getColumnData;
import static com.efectura.utilities.BrowserUtils.*;
import static com.efectura.utilities.CommonExcelReader.getExcelPath;

public class ItemOverviewStepDefs extends BaseStep {

    @And("The user verify Reset button func for {string} text filter")
    public void theUserVerifyResetButtonFuncForTextFilter(String columnName) {
        String locate = "//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/preceding-sibling::th)+1]//input";
        WebElement textFilterInputBox = Driver.getDriver().findElement(By.xpath(locate));
        String actualValue = BrowserUtils.getValueInInputBox(textFilterInputBox);
        Assert.assertEquals("", actualValue);
    }

    @When("The user selects {string} as main category")
    public void theUserSelectsAsMainCategory(String mainCategory) {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.itemOverviewPage().getCategorySelect(), mainCategory);
    }

    @And("The user add {string} to columns")
    public void theUserAddToColumns(String columnName) {
        BrowserUtils.wait(2);
        WebElement matchingElement = pages.itemOverviewPage().getToBeSelectedColumns().stream()
                .filter(el -> el.getText().trim().equalsIgnoreCase(columnName))
                .findFirst()
                .orElse(null);

        BrowserUtils.dragAndDrop(matchingElement, pages.itemOverviewPage().getAlreadySelectedColumns().get(0));
        BrowserUtils.wait(1);

    }

    @And("The user remove {string} from columns")
    public void theUserRemoveFromColumns(String columnName) {
        BrowserUtils.wait(2);



        WebElement matchingElement = pages.itemOverviewPage().getAlreadySelectedColumns().stream()
                .filter(el -> el.getText().trim().split("\n")[0].equalsIgnoreCase(columnName))
                .findFirst()
                .orElse(null);


//        for (WebElement element : pages.itemOverviewPage().getAlreadySelectedColumns()) {
//            System.out.println("selected columns: " + element.getText());
//            if (element.getText().trim().equalsIgnoreCase(columnName)) {
//                matchingElement = element;
//            }
//        }

                System.out.println("already Element: " + matchingElement.getText());

        BrowserUtils.dragAndDrop(matchingElement, pages.itemOverviewPage().getToBeSelectedArea());
        BrowserUtils.wait(5);
    }

    @And("The user select {string} for category in create")
    public void theUserSelectNewNodeForCategoryInCreate(String category) {
        WebElement categoryElement = Driver.getDriver().findElement(By.xpath("//ul/li/ul/li/a[text()='" + category + "']"));
        categoryElement.click();
    }

    @And("The user click on {string} button in create modal")
    public void theUserClickOnCreateButtonInCreateModal(String btnName) {
        if (btnName.equalsIgnoreCase("Create")) {
            pages.itemOverviewPage().getCreateButtonInCreateModal().click();
        } else if (btnName.equalsIgnoreCase("Cancel")) {
            pages.itemOverviewPage().getCancelButtonInCreateModal().click();
        } else {
            throw new RuntimeException("Invalid Button Name in this modal: " + btnName);
        }

    }

    @And("The user click on {string} tab in create modal")
    public void theUserClickOnCategoriesTabInCreateModal(String tabNameInCreateModal) {
        WebElement tab = Driver.getDriver().findElement(By.xpath("//a[text()='" + tabNameInCreateModal + "']"));
        tab.click();
    }

    @And("The user clicks cancel button in overview delete popup")
    public void theUserClicksCancelButtonInOverviewDeletePopup() {
        pages.itemOverviewPage().getCancelBtnInDeleteModal().click();
    }

    @And("The user verifies {string} button is {string}")
    public void theUserVerifiesButtonIs(String btnName, String btnStatus) {
        pages.generalPage().verifyButtonStatus(btnName,btnStatus);
    }

    @When("The user clicks {string} pagination button")
    public void theUserClicksLastPageTablePaginationButton(String btnName) {
        pages.generalPage().clickPaginationButton(btnName);
    }

    @And("The user clicks add list button")
    public void theUserClicksAddListButton() {
        BrowserUtils.wait(1);
        pages.itemOverviewPage().openSideAccordionInOverview();
        BrowserUtils.waitForVisibility(pages.itemOverviewPage().getCreateListButton(), 15);
        pages.itemOverviewPage().getCreateListButton().click();
    }

    @Then("The user verifies New List popup is open")
    public void theUserVerifiesNewListPopupIsOpen() {
        BrowserUtils.waitForVisibility(pages.itemOverviewPage().getNewListPopup(), 10);
        Assert.assertTrue(pages.itemOverviewPage().getNewListPopup().isDisplayed());
    }

    @When("The user enters list name as {string}")
    public void theUserEntersListNameAs(String listName) {
        pages.itemOverviewPage().getListNameInputBox().sendKeys(listName);
    }

    @Then("The user verify list {string} exists")
    public void theUserVerifyListExists(String listName) {
        if (pages.itemOverviewPage().getAllListsAccordion().getAttribute("class").contains("active")) {
            pages.itemOverviewPage().getAllListsAccordion().click();
        }

        boolean exists = pages.itemOverviewPage().getAvaliableLists().stream()
                .anyMatch(e -> listName.equals(e.getText()));
        Assert.assertTrue(exists);
    }

    @Then("The user verify list {string} do not exists")
    public void theUserVerifyListDoNotExists(String listName) {
        if (pages.itemOverviewPage().getAllListsAccordion().getAttribute("class").contains("active")) {
            pages.itemOverviewPage().getAllListsAccordion().click();
        }

        boolean exists = pages.itemOverviewPage().getAvaliableLists().stream()
                .anyMatch(e -> listName.equals(e.getText()));
        Assert.assertFalse(exists);
    }

    @And("The user clicks delete button in {string} list")
    public void theUserClicksDeleteButtonInList(String listName) {
        pages.itemOverviewPage().clickDeleteBtnOfList(listName);
    }

    @And("The user clicks {string} button in delete list modal")
    public void theUserClicksCancelButtonInCreateListModal(String btnName) {
        String locate = "//div[@id='delete-list-modal']/div/div/div/button[contains(text(),'" + btnName + "')]";
        WebElement button = Driver.getDriver().findElement(By.xpath(locate));
        button.click();
    }

    @And("The user clicks {string} button in create list modal")
    public void theUserClicksButtonInCreateListModal(String btnName) {
        String locate = "//div[@id='create-new-list']/div/div/div/button[contains(text(),'" + btnName + "')]";
        WebElement btn = Driver.getDriver().findElement(By.xpath(locate));
        BrowserUtils.waitForClickability(btn,10);
        btn.click();
        BrowserUtils.wait(1);
    }

    @When("The user click on export {string} button in overview")
    public void theUserClickOnExportButtonInOverview(String btnText) {
        WebElement exportBtn = Driver.getDriver().findElement(By.xpath("//a[contains(@id,'-" + btnText + "')]"));
        pages.itemOverviewPage().getOverviewExportDropdownBtn().click();
        exportBtn.click();

    }

    String username;
    String locale;
    String itemType;
    List<String> requiredAttributes;
    List<String> familiesOfImportItem;
    @Given("The user get import info")
    public void theUserGetImportInfo(DataTable dataTable) {
        Map<String,String> mapParam = dataTable.asMap(String.class, String.class);
        username = mapParam.get("username");
        itemType = mapParam.get("itemType");
        locale = pages.dbProcess().getUserLocale(username);
        familiesOfImportItem = pages.dbProcess().getFamiliesOfImportItem(itemType,locale);

        String familiesAsString = familiesOfImportItem.stream()
                .map(val -> "'" + val + "'")         // her elemanı tek tırnakla sar
                .collect(Collectors.joining(", ", "(", ")"));

        requiredAttributes = pages.dbProcess().getRequiredAttributes(itemType,familiesAsString,locale);
    }

    Map<String,Integer> indexAndHeaders = new HashMap<>();
    @When("The user create excel file")
    public void theUserCreateExcelFile() throws IOException {
        String filePath = getExcelPath(itemType);
        CommonExcelReader.createExcelFile(itemType);
        CommonExcelReader.setColumnHeader(filePath,0,"SKU");
        CommonExcelReader.setColumnHeader(filePath,1,"Category");
        CommonExcelReader.setColumnHeader(filePath,2,"Family");
        CommonExcelReader.setColumnHeader(filePath,3,"isTestEvent");

        CommonExcelReader.setColumnHeader(filePath,4,"NewBoolean");
        CommonExcelReader.setColumnHeader(filePath,5,"NewText");
        CommonExcelReader.setColumnHeader(filePath,6,"NewSelect");
        CommonExcelReader.setColumnHeader(filePath,7,"NewDate");
        CommonExcelReader.setColumnHeader(filePath,12,"E-Posta");

        indexAndHeaders.put("SKU",0);
        indexAndHeaders.put("Category",1);
        indexAndHeaders.put("Family",2);
        indexAndHeaders.put("isTestEvent",3);
        for (int i = 8; i < requiredAttributes.size() + 8; i++) {
            CommonExcelReader.setColumnHeader(filePath,i,requiredAttributes.get(i-8));
            indexAndHeaders.put(requiredAttributes.get(i-8),i);
        }
    }

    List<String> newSKUs = new ArrayList<>();
    int countOfImportedItems;
    @When("The user fill item import excel with {int} value")
    public void theUserFillItemImportExcelWithValue(int rowCount) throws IOException {
        countOfImportedItems = rowCount;
        String boolValue;
        if (locale.contains("tr")) boolValue = "Hayır";
        else boolValue = "No";
        List<String> categories = pages.dbProcess().getCategoriesOfImportItem(itemType,locale);

        System.out.println("categories: " + categories);

        if (categories.size() != 1)
            categories.removeIf(item -> item.equals(pages.dbProcess().getTopCategoryOfImportItem(itemType,locale)));

        List<String> families = pages.dbProcess().getFamiliesOfImportItem(itemType,locale);

        for (int i = 0; i < rowCount; i++) {
            String randomSku = UUID.randomUUID().toString();
            CommonExcelReader.updateCellValue(Offstand.getExcelPath(itemType),"SKU",i + 1, randomSku);
            newSKUs.add(randomSku);
            CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",i+1,categories.get(new Random().nextInt(categories.size())));
            CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family", i+1,families.get(new Random().nextInt(families.size())));


            for (int j = 0; j < requiredAttributes.size(); j++) {
                String attributeCode = requiredAttributes.get(j);
                String attributeType = pages.dbProcess().getAttributeType(attributeCode);
                if (attributeType.contains("Text"))
                    CommonExcelReader.updateCellValue(getExcelPath(itemType),attributeCode,i+1,UUID.randomUUID().toString());
                else if (attributeType.contains("Number"))
                    CommonExcelReader.updateCellValue(getExcelPath(itemType),attributeCode,i+1,String.valueOf((long) (Math.random() * 1_000_000_0000L) + 9_000_000_000L));
                else if (attributeType.contains("Select")) {
                    List<String> attributeOptions = pages.dbProcess().getAttributeOptions(attributeCode,locale);
                    CommonExcelReader.updateCellValue(getExcelPath(itemType),attributeCode,i+1,attributeOptions.get(new Random().nextInt(attributeOptions.size())));
                }
                else if (attributeType.contains("Bool"))
                    CommonExcelReader.updateCellValue(getExcelPath(itemType),attributeCode,i+1,boolValue);
                else if (attributeType.contains("Date")) {
                    CommonExcelReader.updateCellValue(getExcelPath(itemType),attributeCode,i + 1,"02.09.2025 12:00");
                }
            }

        }

    }

    @When("The user import the file")
    public void theUserImportTheFile() {
        pages.itemOverviewPage().getItemImportButton().click();
        pages.itemOverviewPage().getItemImportInput().sendKeys(getExcelPath(itemType));
        pages.itemOverviewPage().getItemImportStep2NextButton().click();
        pages.itemOverviewPage().getMatchColumnsButton().click();
        pages.itemOverviewPage().getSaveMatchColumnsButton().click();
        BrowserUtils.wait(1);
        pages.itemOverviewPage().getItemImportStep3NextButton().click();
        BrowserUtils.wait(1);
        pages.itemOverviewPage().getLastImportButton().click();
        BrowserUtils.wait(5);

    }

    @Then("The user verify items are created")
    public void theUserVerifyItemsAreCreated() {
        String newSKUsAsString = newSKUs.stream().map(val -> "'" + val + "'")
                .collect(Collectors.joining(", ", "(", ")"));
        List<String> actualSKUs = pages.dbProcess().getSkuOfImportedItems(newSKUsAsString);
        Assert.assertEquals(countOfImportedItems,actualSKUs.size());
    }

    @When("The user click create button")
    public void theUserClickCreateButton() {
        BrowserUtils.waitForVisibility(pages.itemOverviewPage().getCreateItemButton(),60);
        pages.itemOverviewPage().getCreateItemButton().click();
    }

    @When("The user select {string} for family")
    public void theUserSelectSMSForFamily(String family) {
        BrowserUtils.wait(1);
        pages.itemOverviewPage().getCreateItemFamilies().stream().
                filter(el -> el.getText().equals(family)).findFirst().ifPresent(WebElement::click);
    }

    @When("The user click nextt button")
    public void theUserClickNexttButton() {
        BrowserUtils.wait(1);
        BrowserUtils.waitForClickability(pages.itemOverviewPage().getNextButton(),20);
        pages.itemOverviewPage().getNextButton().click();
    }

    @When("The user select categoryy")
    public void theUserSelectCategoryy() {
        pages.itemOverviewPage().getCreateItemCategoryTab().click();
        pages.itemOverviewPage().getKurumsalCategory().click();
    }

    @When("The user click nextToRuleButton")
    public void theUserClickNextToRuleButton() {
        pages.itemOverviewPage().getNextToRuleButton().click();
    }

    @When("The user create rule")
    public void theUserCreateRule() {
        pages.itemOverviewPage().getRuleSelectArrow().click();
        pages.itemOverviewPage().getRuleAttributeInput().sendKeys("Kullanıcı Adı");
        pages.itemOverviewPage().getRuleOption().click();
        pages.itemOverviewPage().getRuleValueInput().sendKeys("SEDAİ");
    }

    @When("The user click nextToPreviewButton")
    public void theUserClickNextToPreviewButton() {
        pages.itemOverviewPage().getNextToPreviewButton().click();
    }

    @When("The user click createItem button in modal")
    public void theUserClickCreateItemButtonInModal() {
        pages.itemOverviewPage().getCreateItemButtonInModal().click();
        BrowserUtils.wait(2);
    }

    String errorColumn;
    @When("The user update {string} excel with random {string} in index {int}")
    public void theUserUpdateExcelWithRandomInIndex(String excelFile, String columnName, int index) throws IOException {
        errorColumn = columnName;
        CommonExcelReader.updateCellValue(getExcelPath(excelFile), columnName,index,"random");
    }

    @When("The user click edit button")
    public void theUserClickEditButton() {
        pages.itemOverviewPage().getImportEditButton().click();
        BrowserUtils.wait(2);
        BrowserUtils.adjustScreenSize(45,Driver.getDriver());
        BrowserUtils.wait(2);
    }

    @When("The user click item import button")
    public void theUserClickItemImportButton() {
        pages.itemOverviewPage().getItemImportButton().click();
    }

    @When("The user upload the file")
    public void theUserUploadTheFile() {
        pages.itemOverviewPage().getItemImportInput().sendKeys(getExcelPath(itemType));
        pages.itemOverviewPage().getItemImportStep2NextButton().click();
    }

    @Then("The user verify error message")
    public void theUserVerifyErrorMessage() {
        BrowserUtils.wait(10);
        WebElement table = Driver.getDriver().findElement(By.id("edit-import-table"));
        
        if (errorColumn.equalsIgnoreCase("Family")) {
            Assert.assertEquals("IMPORT_FAMILY_NOT_FOUND", getColumnData(table, "ErrorMessage").get(0));
        } else if (errorColumn.equalsIgnoreCase("Category")) {
            Assert.assertEquals("IMPORT_INVALID_CATEGORY", getColumnData(table, "ErrorMessage").get(0));
        } else if (errorColumn.equalsIgnoreCase("Attribute")) {
            Assert.assertEquals("IMPORT_REQUIRED_ATTRIBUTE_MISSING:" + blankAttributeCode, getColumnData(table, "ErrorMessage").get(0));
        }

    }

    @When("The user click edit import cancel button")
    public void theUserClickEditImportCancelButton() {
        pages.itemOverviewPage().getEditImportModalCancelButton().click();
    }

    @When("The user click import preview cancel button")
    public void theUserClickImportPreviewCancelButton() {
        pages.itemOverviewPage().getImportPreviewModalCancel().click();
    }

    String blankAttributeCode;
    @When("The user left the attribute empty")
    public void theUserLeftTheAttributeEmpty() throws IOException {
        errorColumn = "Attribute";
        countOfImportedItems = 1;
        String boolValue;
        if (locale.contains("tr")) boolValue = "Hayır";
        else boolValue = "No";

        Random random = new Random();
        int sayi = random.nextInt(requiredAttributes.size());

        CommonExcelReader.updateCellValue(getExcelPath(itemType),requiredAttributes.get(sayi),1,"");
        blankAttributeCode = requiredAttributes.get(sayi);


//        for (int i = 0; i < 1; i++) {
//
//            for (int j = 0; j < requiredAttributes.size(); j++) {
//                String attributeCode = requiredAttributes.get(j);
//                String attributeType = pages.dbProcess().getAttributeType(attributeCode);
//                if (attributeType.contains("Text")) {
//                    CommonExcelReader.updateCellValue(CommonExcelReader.getExcelPath(itemType),attributeCode,i+1,"");
//                    blankAttributeCode = attributeCode;
//                }
//                else if (attributeType.contains("Number"))
//                    CommonExcelReader.updateCellValue(CommonExcelReader.getExcelPath(itemType),attributeCode,i+1,String.valueOf((long) (Math.random() * 1_000_000_0000L) + 9_000_000_000L));
//                else if (attributeType.contains("Select")) {
//                    List<String> attributeOptions = pages.dbProcess().getAttributeOptions(attributeCode,locale);
//                    CommonExcelReader.updateCellValue(CommonExcelReader.getExcelPath(itemType),attributeCode,i+1,attributeOptions.get(new Random().nextInt(attributeOptions.size())));
//                }
//                else if (attributeType.contains("Bool"))
//                    CommonExcelReader.updateCellValue(CommonExcelReader.getExcelPath(itemType),attributeCode,i+1,boolValue);
//                else if (attributeType.contains("Date")) {
//                    CommonExcelReader.updateCellValue(CommonExcelReader.getExcelPath(itemType),attributeCode,i + 1,"02.09.2025 12:00");
//                }
//            }
//
//        }

    }

    @When("The user click {string} button")
    public void theUserClickButton(String buttonName) {


        String locate = "//div[contains(@class,'header')]/button[contains(normalize-space(),'" + buttonName + "')]";
        List<WebElement> buttons = driver.findElements(By.xpath(locate));

        for (WebElement button : buttons) {
            if (button.isDisplayed()) {
                button.click();
            }
        }

//        Driver.getDriver().findElement(By.xpath(locate)).click();

    }

    List<String> selectedTexts = new ArrayList<>();
    @When("The user get selected export options")
    public void theUserGetSelectedExportOptions() {
        selectedTexts = pages.itemOverviewPage().getSelectedExportOptions().stream()
                .map(WebElement::getText)
                .map(String::trim)
                .map(t -> t.equalsIgnoreCase("Kod") ? "Fletum Kod" : t).toList();
    }

    @When("The user complete the export")
    public void theUserCompleteTheExport() {
        Driver.getDriver().findElement(By.xpath("//button[@id='export-columns-next']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@id='export-columns-done']")).click();
//        BrowserUtils.wait(2);
    }

    @Then("The user verify file is downloaded")
    public void theUserVerifyFileIsDownloaded() {
        boolean isDownloaded = BrowserUtils.isNewExcelDownloaded
                (System.getProperty("user.home") + "/Downloads",10);
        Assert.assertTrue("Dosya indirilmedi",isDownloaded);

    }

    @When("The user complete right import process")
    public void theUserCompleteRightImportProcess() {
        pages.itemOverviewPage().getItemImportButton().click();
        pages.itemOverviewPage().getItemImportInput().sendKeys(getExcelPath(itemType));
        pages.itemOverviewPage().getItemImportStep2NextButton().click();
    }

    String defaultFamily;
    @When("The user get default family {string}")
    public void theUserGetDefaultFamily(String itemType) {
        defaultFamily = pages.dbProcess().getDefaultImportFamily(itemType);

        if (itemType.equals("Product")) {
            defaultFamily = "defaultAttributeTestFamily";
        }

    }


    Map<String,String> categoriesCodeAndLabels = new HashMap<>();
    Map<String,String> familiesCodeAndLabels = new HashMap<>();
    String anyFamily1;
    String anyFamily3;
    String anyFamily5;
    String anyFamily6;
    String randomSku1;
    String randomSku2;
    String randomSku3;
    String randomSku4;
    String randomSku5;
    String anyCategory2;
    String anyCategory4;
    String anyCategory5;
    String anyCategory6;
    String anyCategory7;
    String anySKU6;
    String anySKU7;
    String anySKU8;
    String randomName;
    String randomName7;
    String oldName8;
    @When("The user fill import excel for create")
    public void theUserFillImportExcelForCreate() throws IOException {
        String filePath = getExcelPath(itemType);
        CommonExcelReader.setColumnHeader(filePath,indexAndHeaders.get("DIA_FirstName"),"İsim");
        categoriesCodeAndLabels = pages.dbProcess().getCategories(itemType);
        familiesCodeAndLabels = pages.dbProcess().getFamilies(itemType);

        randomSku1 = UUID.randomUUID().toString();
        anyFamily1 = familiesCodeAndLabels.values().iterator().next();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",1,randomSku1);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",1, anyFamily1);

        randomSku2 = UUID.randomUUID().toString();
//        anyCategory2 = categoriesCodeAndLabels.keySet().iterator().next();
        anyCategory2 = categoriesCodeAndLabels.values().iterator().next();
        System.out.println(categoriesCodeAndLabels);

        System.out.println("anyCategory2: " + anyCategory2);

        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",2,randomSku2);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",2, anyCategory2);

        anyFamily3 = familiesCodeAndLabels.values().iterator().next();
        randomSku3 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",3, anyFamily3);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"İsim",3, randomSku3);


        anyCategory4 = categoriesCodeAndLabels.values().iterator().next();
        randomSku4 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",4, anyCategory4);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"İsim",4, randomSku4);


        anyCategory5 = categoriesCodeAndLabels.values().iterator().next();
        anyFamily5 = familiesCodeAndLabels.values().iterator().next();
        randomSku5 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",5, anyCategory5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",5, anyFamily5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",5, randomSku5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"İsim",5, randomSku5);
        System.out.println("random5 : " + randomSku5);

        anySKU6 = pages.dbProcess().getAnySku("Contact","1");
        randomName = UUID.randomUUID().toString();

        anyCategory6 = categoriesCodeAndLabels.keySet().iterator().next();

        System.out.println("anyCategory6: " + anyCategory6);

        anyFamily6 = familiesCodeAndLabels.values().iterator().next();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",6, anyCategory6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",6, anyFamily6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",6, anySKU6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"İsim",6, randomName);


        anySKU8 = pages.dbProcess().getAnySku("Contact","3");
        oldName8 = pages.dbProcess().getName(anySKU8);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",8, anySKU8);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"İsim",8, "");



        newItemSkus.add(randomSku1);
        newItemSkus.add(randomSku2);
        newItemSkus.add(randomSku3);
        newItemSkus.add(randomSku4);
        newItemSkus.add(randomSku5);


    }

    String importTime;
    @When("The user import the file new")
    public void theUserImportTheFileNew() {

        BrowserUtils.wait(15);
        BrowserUtils.scrollToElement(driver,pages.itemOverviewPage().getSaveMatchColumnsButton());
        pages.itemOverviewPage().getSaveMatchColumnsButton().click();
        BrowserUtils.wait(2);
        BrowserUtils.waitForVisibility(pages.editItemPage().getInfoMessage(),90);
        Assert.assertEquals("ValidationCompleted", pages.editItemPage().getInfoMessage().getText());

        importTime = BrowserUtils.getFormattedNow("UTC");
        System.out.println("import time utc: " + importTime);

        BrowserUtils.wait(4);

        BrowserUtils.waitForVisibility(pages.itemOverviewPage().getApplyImportValidationButton(),80);
        pages.itemOverviewPage().getApplyImportValidationButton().click();
        //FileUploaded
        BrowserUtils.wait(1);

        BrowserUtils.waitForVisibility(pages.editItemPage().getInfoMessage(),90);
        Assert.assertEquals("FileUploaded", pages.editItemPage().getInfoMessage().getText());
        System.out.println(pages.editItemPage().getInfoMessage().getText());
    }

    @Then("The user verify import for create")
    public void theUserVerifyImportForCreate() {
        BrowserUtils.wait(50);

        String actualFamily1 = pages.dbProcess().getFamilyOfImportedItem(randomSku1);
        String actualCategory1 = pages.dbProcess().getCategoryOfImportedItem(randomSku1);
        Assert.assertEquals("Boş bırakılan item'ın kategorisi ROOT olmadı","Tümü",actualCategory1);
        Assert.assertEquals("Family dosyadaki gibi olmadı",anyFamily1,actualFamily1);

        String actualFamily2 = pages.dbProcess().getFamilyOfImportedItem(randomSku2);
        String actualCategory2 = pages.dbProcess().getCategoryOfImportedItem(randomSku2);
        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory2,actualCategory2);
        Assert.assertEquals("Boş bırakılan item'ın family'si default family olmadı",defaultFamily,actualFamily2);

        String actualFamily3 = pages.dbProcess().getFamilyOfImportedItemWithName(randomSku3);
//        String actualFamily3 = pages.dbProcess().getFamilyOfImportedItemWithEventName(randomSku3);
//        String actualFamily3 = pages.dbProcess().getFamilyOfImportedItemWithProductName(randomSku3);
        String actualCategory3 = pages.dbProcess().getCategoryOfImportedItemWithName(randomSku3);
//        String actualCategory3 = pages.dbProcess().getCategoryOfImportedItemWithEventName(randomSku3);
//        String actualCategory3 = pages.dbProcess().getCategoryOfImportedItemWithProductName(randomSku3);
        String importTime3 = pages.dbProcess().getImportTimeWithName(randomSku3);
//        String importTime3 = pages.dbProcess().getImportTimeWithEventName(randomSku3);
//        String importTime3 = pages.dbProcess().getImportTimeWithProductName(randomSku3);
        Assert.assertEquals("Boş bırakılan item'ın kategorisi ROOT olmadı","ROOT",actualCategory3);
        Assert.assertEquals("family dosyadaki gibi olmadı",anyFamily3,actualFamily3);
        System.out.println("import time 3: " + importTime3);
        Assert.assertTrue(BrowserUtils.isAfter(importTime3,importTime));



        String actualFamily4 = pages.dbProcess().getFamilyOfImportedItemWithName(randomSku4);
        String actualCategory4 = pages.dbProcess().getCategoryOfImportedItemWithName(randomSku4);
        String importTime4 = pages.dbProcess().getImportTimeWithName(randomSku4);
        Assert.assertEquals("Boş bırakılan item'ın family'si default family olmadı",defaultFamily,actualFamily4);
        Assert.assertEquals("category dosyadaki gibi olmadi",anyCategory4,actualCategory4);
        Assert.assertTrue(BrowserUtils.isAfter(importTime4,importTime));
        System.out.println("import time 4: " + importTime4);


        String actualFamily5 = pages.dbProcess().getFamilyOfImportedItem(randomSku5);
        String actualCategory5 = pages.dbProcess().getCategoryOfImportedItem(randomSku5);
        String importTime5 = pages.dbProcess().getImportTimeWithName(randomSku5);
        String actualName5 = pages.dbProcess().getName(randomSku5);
        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory5,actualCategory5);
        Assert.assertEquals("Family dosyadaki gibi olmadı",anyFamily5,actualFamily5);
        Assert.assertTrue(BrowserUtils.isAfter(importTime5,importTime));
        Assert.assertEquals("isim dosyadaki gibi değil",randomSku5,actualName5);


        String actualFamily6 = pages.dbProcess().getFamilyOfImportedItem(anySKU6);
        String actualCategory6 = pages.dbProcess().getCategoryOfImportedItem(anySKU6);
        String importTime6 = pages.dbProcess().getImportTimeWithName(randomName);
        String actualName6 = pages.dbProcess().getName(anySKU6);
        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory6,actualCategory6);
        Assert.assertEquals("Family dosyadaki gibi olmadı",actualFamily6,actualFamily6);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime6,importTime));
        Assert.assertEquals("isim dosyadaki gibi değil",randomName,actualName6);


        String actualName7 = pages.dbProcess().getProductName(anySKU7,itemType);
        Assert.assertEquals("isim dosyadaki gibi değil",randomName7,actualName7);

        String actualName8 = pages.dbProcess().getName(anySKU8);
        Assert.assertEquals("isim dosyadaki gibi değil",oldName8,actualName8);




    }


    @When("The user create excel file2")
    public void theUserCreateExcelFile2() throws IOException {
        String filePath = getExcelPath(itemType);
        CommonExcelReader.createExcelFile(itemType);
        CommonExcelReader.setColumnHeader(filePath,0,"SKU");
        indexAndHeaders.put("SKU",0);
        for (int i = 1; i < requiredAttributes.size() + 1; i++) {
            CommonExcelReader.setColumnHeader(filePath,i,requiredAttributes.get(i-1));
            indexAndHeaders.put(requiredAttributes.get(i-1),i);
        }
    }

    String anySKU9;
    String randomName9;
    @When("The user fill import excel for create2")
    public void theUserFillImportExcelForCreate2() throws IOException {

        String filePath = getExcelPath(itemType);
        CommonExcelReader.setColumnHeader(filePath,indexAndHeaders.get("DIA_FirstName"),"İsim");

        anySKU9 = pages.dbProcess().getAnySku("Contact","4");
        randomName9 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",1, anySKU9);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"İsim",1, randomName9);



    }

    @Then("The user verify import for create2")
    public void theUserVerifyImportForCreate2() {
        BrowserUtils.wait(30);
        String actualFamily9 = pages.dbProcess().getFamilyOfImportedItem(anySKU9);

        String actualCategory9 = pages.dbProcess().getCategoryOfImportedItem(anySKU9);


        String actualName9 = pages.dbProcess().getName(anySKU9);
        Assert.assertEquals("isim dosyadaki gibi değil",randomName9,actualName9);
//        Assert.assertEquals("Boş bırakılan item'ın family'si default family olmadı",defaultFamily,actualFamily9);
//        Assert.assertEquals("Boş bırakılan item'ın kategorisi ROOT olmadı","ROOT",actualCategory9);


    }

    List<String> newItemSkus = new ArrayList<>();
    @When("The user fill import excel for create event")
    public void theUserFillImportExcelForCreateEvent() throws IOException {
        String filePath = getExcelPath(itemType);
        CommonExcelReader.setColumnHeader(filePath,indexAndHeaders.get("DIA_Event_Name"),"Etkinlik Adı");
        categoriesCodeAndLabels = pages.dbProcess().getCategories(itemType);
        familiesCodeAndLabels = pages.dbProcess().getFamilies(itemType);

        randomSku1 = UUID.randomUUID().toString();
        anyFamily1 = familiesCodeAndLabels.values().iterator().next();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",1,randomSku1);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",1, anyFamily1);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"NewText",1, "TestAutomation");
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"NewSelect",1, "Option1");

        randomSku2 = UUID.randomUUID().toString();
//        anyCategory2 = categoriesCodeAndLabels.keySet().iterator().next();
        anyCategory2 = categoriesCodeAndLabels.values().iterator().next();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",2,randomSku2);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",2, anyCategory2);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"NewDate",2, getFormattedDateWithoutHour(1));
        BrowserUtils.forceCustomDateFormat(getExcelPath(itemType),"NewDate");
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"NewBoolean",2, "Doğru");
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"NewSelect",2, "Option2");

        anyFamily3 = familiesCodeAndLabels.values().iterator().next();
        randomSku3 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",3, anyFamily3);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Etkinlik Adı",3, randomSku3);


        anyCategory4 = categoriesCodeAndLabels.values().iterator().next();
        randomSku4 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",4, anyCategory4);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Etkinlik Adı",4, randomSku4);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"NewBoolean",4, "Yanlış");
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"NewSelect",4, "Option3");


        anyCategory5 = categoriesCodeAndLabels.keySet().iterator().next();
        System.out.println("anyCategory5: " + anyCategory5);

        anyFamily5 = familiesCodeAndLabels.values().iterator().next();
        randomSku5 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",5, anyCategory5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",5, anyFamily5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",5, randomSku5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Etkinlik Adı",5, randomSku5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"isTestEvent",5, "Yanlış");
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Event_Type",5, "Konferans");
        System.out.println("random5 : " + randomSku5);

        anySKU6 = pages.dbProcess().getAnySku("Event","1");
        randomName = UUID.randomUUID().toString();

//        anyCategory6 = categoriesCodeAndLabels.keySet().iterator().next();
        anyCategory6 = categoriesCodeAndLabels.values().iterator().next();
        System.out.println("anyCategory6: " + anyCategory6);

        anyFamily6 = familiesCodeAndLabels.values().iterator().next();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",6, anyCategory6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",6, anyFamily6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",6, anySKU6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Etkinlik Adı",6, randomName);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"DIA_Finish_Date_E",6,getFormattedDateWithoutHour(1));
        BrowserUtils.forceCustomDateFormat(getExcelPath(itemType),"DIA_Finish_Date_E");
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"DIA_Start_Date_E",6,getFormattedDateWithoutHour(-1));
        BrowserUtils.forceCustomDateFormat(getExcelPath(itemType),"DIA_Start_Date_E");


        anySKU8 = pages.dbProcess().getAnySku("Event","3");
        oldName8 = pages.dbProcess().getEventName(anySKU8,"Event");
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",7, anySKU8);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Etkinlik Adı",7, "");

        newItemSkus.add(randomSku1);
        newItemSkus.add(randomSku2);
        newItemSkus.add(randomSku3);
        newItemSkus.add(randomSku4);
        newItemSkus.add(randomSku5);

    }

    @When("The user fill import excel for create product")
    public void theUserFillImportExcelForCreateProduct() throws IOException {
        String filePath = getExcelPath(itemType);
        CommonExcelReader.setColumnHeader(filePath,indexAndHeaders.get("DIA_URUNGRUPKOD"),"Ürün Grup Kodu");
        categoriesCodeAndLabels = pages.dbProcess().getCategories(itemType);
        familiesCodeAndLabels = pages.dbProcess().getFamilies(itemType);

        randomSku1 = UUID.randomUUID().toString();
        anyFamily1 = familiesCodeAndLabels.values().iterator().next();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",1,randomSku1);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",1, anyFamily1);

        randomSku2 = UUID.randomUUID().toString();
//        anyCategory2 = categoriesCodeAndLabels.keySet().iterator().next();
        anyCategory2 = categoriesCodeAndLabels.values().iterator().next();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",2,randomSku2);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",2, anyCategory2);

        anyFamily3 = familiesCodeAndLabels.values().iterator().next();
        randomSku3 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",3, anyFamily3);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Ürün Grup Kodu",3, randomSku3);


        anyCategory4 = categoriesCodeAndLabels.values().iterator().next();
        randomSku4 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",4, anyCategory4);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Ürün Grup Kodu",4, randomSku4);


        anyCategory5 = categoriesCodeAndLabels.values().iterator().next();
        anyFamily5 = familiesCodeAndLabels.values().iterator().next();
        randomSku5 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",5, anyCategory5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",5, anyFamily5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",5, randomSku5);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Ürün Grup Kodu",5, randomSku5);
        System.out.println("random5 : " + randomSku5);

        anySKU6 = pages.dbProcess().getAnySku("Product","1");
        randomName = UUID.randomUUID().toString();
        anyCategory6 = categoriesCodeAndLabels.values().iterator().next();
        anyFamily6 = familiesCodeAndLabels.values().iterator().next();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Category",6, anyCategory6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Family",6, anyFamily6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",6, anySKU6);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Ürün Grup Kodu",6, randomName);


        anySKU8 = pages.dbProcess().getAnySku("Event","3");
        oldName8 = pages.dbProcess().getEventName(anySKU8,"Product");
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",8, anySKU8);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"Ürün Grup Kodu",8, "");

        newItemSkus.add(randomSku1);
        newItemSkus.add(randomSku2);
        newItemSkus.add(randomSku3);
        newItemSkus.add(randomSku4);
        newItemSkus.add(randomSku5);

    }

    @Then("The user verify import for create product")
    public void theUserVerifyImportForCreateProduct() {
        BrowserUtils.wait(30);

        String actualFamily1 = pages.dbProcess().getFamilyOfImportedItem(randomSku1);
        String actualCategory1 = pages.dbProcess().getCategoryOfImportedItem(randomSku1);
        Assert.assertEquals("Boş bırakılan item'ın kategorisi ROOT olmadı","Ürün",actualCategory1);
        Assert.assertEquals("Family dosyadaki gibi olmadı",anyFamily1,actualFamily1);

        String actualFamily2 = pages.dbProcess().getFamilyOfImportedItem(randomSku2);
        String actualCategory2 = pages.dbProcess().getCategoryOfImportedItem(randomSku2);
        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory2,actualCategory2);
        Assert.assertEquals("Boş bırakılan item'ın family'si default family olmadı",defaultFamily,actualFamily2);

//        String actualFamily3 = pages.dbProcess().getFamilyOfImportedItemWithName(randomSku3);
//        String actualFamily3 = pages.dbProcess().getFamilyOfImportedItemWithEventName(randomSku3);
        String actualFamily3 = pages.dbProcess().getFamilyOfImportedItemWithProductName(randomSku3);
//        String actualCategory3 = pages.dbProcess().getCategoryOfImportedItemWithName(randomSku3);
//        String actualCategory3 = pages.dbProcess().getCategoryOfImportedItemWithEventName(randomSku3);
        String actualCategory3 = pages.dbProcess().getCategoryOfImportedItemWithProductName(randomSku3);
//        String importTime3 = pages.dbProcess().getImportTimeWithName(randomSku3);
//        String importTime3 = pages.dbProcess().getImportTimeWithEventName(randomSku3);
        String importTime3 = pages.dbProcess().getImportTimeWithProductName(randomSku3);
        Assert.assertEquals("Boş bırakılan item'ın kategorisi ROOT olmadı","ROOT",actualCategory3);
        Assert.assertEquals("family dosyadaki gibi olmadı",anyFamily3,actualFamily3);
        System.out.println("import time 3: " + importTime3);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime3,importTime));



        String actualFamily4 = pages.dbProcess().getFamilyOfImportedItemWithProductName(randomSku4);
        String actualCategory4 = pages.dbProcess().getCategoryOfImportedItemWithProductName(randomSku4);
        String importTime4 = pages.dbProcess().getImportTimeWithProductName(randomSku4);
        Assert.assertEquals("Boş bırakılan item'ın family'si default family olmadı",defaultFamily,actualFamily4);
//        Assert.assertEquals("category dosyadaki gibi olmadi",anyCategory4,actualCategory4);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime4,importTime));
        System.out.println("import time 4: " + importTime4);


        String actualFamily5 = pages.dbProcess().getFamilyOfImportedItem(randomSku5);
        String actualCategory5 = pages.dbProcess().getCategoryOfImportedItem(randomSku5);
        String importTime5 = pages.dbProcess().getImportTimeWithProductName(randomSku5);
//        String actualName5 = pages.dbProcess().getName(randomSku5);
//        String actualName5 = pages.dbProcess().getEventName(randomSku5,itemType);
        String actualName5 = pages.dbProcess().getProductName(randomSku5,itemType);
        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory5,actualCategory5);
        Assert.assertEquals("Family dosyadaki gibi olmadı",anyFamily5,actualFamily5);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime5,importTime));
        Assert.assertEquals("isim dosyadaki gibi değil",randomSku5,actualName5);


        String actualFamily6 = pages.dbProcess().getFamilyOfImportedItem(anySKU6);
        String actualCategory6 = pages.dbProcess().getCategoryOfImportedItem(anySKU6);
        String importTime6 = pages.dbProcess().getImportTimeWithProductName(randomName);
        String actualName6 = pages.dbProcess().getProductName(anySKU6,itemType);
        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory6,actualCategory6);
        Assert.assertEquals("Family dosyadaki gibi olmadı",actualFamily6,actualFamily6);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime6,importTime));
        Assert.assertEquals("isim dosyadaki gibi değil",randomName,actualName6);


        String actualName7 = pages.dbProcess().getProductName(anySKU7,itemType);
        Assert.assertEquals("isim dosyadaki gibi değil",randomName7,actualName7);

        String actualName8 = pages.dbProcess().getProductName(anySKU8,itemType);
        Assert.assertEquals("isim dosyadaki gibi değil",oldName8,actualName8);
    }

    @Then("The user verify import for create event")
    public void theUserVerifyImportForCreateEvent() {
        BrowserUtils.wait(30);

        String actualFamily1 = pages.dbProcess().getFamilyOfImportedItem(randomSku1);
        String actualCategory1 = pages.dbProcess().getCategoryOfImportedItem(randomSku1);
//        Assert.assertEquals("Boş bırakılan item'ın kategorisi ROOT olmadı","ROOT",actualCategory1);
        Assert.assertEquals("Family dosyadaki gibi olmadı",anyFamily1,actualFamily1);

        String actualFamily2 = pages.dbProcess().getFamilyOfImportedItem(randomSku2);
        String actualCategory2 = pages.dbProcess().getCategoryOfImportedItem(randomSku2);
        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory2,actualCategory2);
        Assert.assertEquals("Boş bırakılan item'ın family'si default family olmadı",defaultFamily,actualFamily2);


        String actualFamily3 = pages.dbProcess().getFamilyOfImportedItemWithEventName(randomSku3);
        String actualCategory3 = pages.dbProcess().getCategoryOfImportedItemWithEventName(randomSku3);
        String importTime3 = pages.dbProcess().getImportTimeWithEventName(randomSku3);
        Assert.assertEquals("Boş bırakılan item'ın kategorisi ROOT olmadı","ROOT",actualCategory3);
        Assert.assertEquals("family dosyadaki gibi olmadı",anyFamily3,actualFamily3);
        System.out.println("import time 3: " + importTime3);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime3,importTime));



        String actualFamily4 = pages.dbProcess().getFamilyOfImportedItemWithEventName(randomSku4);
        String actualCategory4 = pages.dbProcess().getCategoryOfImportedItemWithEventName(randomSku4);
        String importTime4 = pages.dbProcess().getImportTimeWithEventName(randomSku4);
        Assert.assertEquals("Boş bırakılan item'ın family'si default family olmadı",defaultFamily,actualFamily4);
//        Assert.assertEquals("category dosyadaki gibi olmadi",anyCategory4,actualCategory4);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime4,importTime));
        System.out.println("import time 4: " + importTime4);


        String actualFamily5 = pages.dbProcess().getFamilyOfImportedItem(randomSku5);
        String actualCategory5 = pages.dbProcess().getCategoryOfImportedItem(randomSku5);
        String importTime5 = pages.dbProcess().getImportTimeWithEventName(randomSku5);
//        String actualName5 = pages.dbProcess().getName(randomSku5);
        String actualName5 = pages.dbProcess().getEventName(randomSku5,itemType);
        String actualIsTestEvent5 = pages.dbProcess().getIsTestEvent(randomSku5,itemType);
        String actualEventType5 = pages.dbProcess().getEventType(randomSku5);
//        String actualName5 = pages.dbProcess().getProductName(randomSku5,itemType);
//        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory5,actualCategory5);
        Assert.assertEquals("Family dosyadaki gibi olmadı",anyFamily5,actualFamily5);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime5,importTime));
        Assert.assertEquals("isim dosyadaki gibi değil",randomSku5,actualName5);
        Assert.assertEquals("IsTestEvent dosyadaki gibi değil","false",actualIsTestEvent5);
        Assert.assertEquals("Event_Type dosyadaki gibi değil","Konferans",actualEventType5);


        String actualFamily6 = pages.dbProcess().getFamilyOfImportedItem(anySKU6);
        String actualCategory6 = pages.dbProcess().getCategoryOfImportedItem(anySKU6);
        String importTime6 = pages.dbProcess().getImportTimeWithEventName(randomName);
        String actualName6 = pages.dbProcess().getEventName(anySKU6,itemType);

        String actualFinisDate6 = pages.dbProcess().getEventDate(anySKU6,"DIA_Finish_Date_E");
        actualFinisDate6 = BrowserUtils.formatDateDayMonthYear(actualFinisDate6);

        Assert.assertEquals("Kategori dosyadaki gibi olmadı",anyCategory6,actualCategory6);
        Assert.assertEquals("Family dosyadaki gibi olmadı",actualFamily6,actualFamily6);
//        Assert.assertTrue(BrowserUtils.isAfter(importTime6,importTime));
        Assert.assertEquals("isim dosyadaki gibi değil",randomName,actualName6);
        Assert.assertEquals("Finish date dosyadaki gibi değil",getFormattedDateWithoutHour(1),actualFinisDate6);


        String actualName7 = pages.dbProcess().getEventName(anySKU7,itemType);
        Assert.assertEquals("isim dosyadaki gibi değil",randomName7,actualName7);

        String actualName8 = pages.dbProcess().getEventName(anySKU8,itemType);
        Assert.assertEquals("isim dosyadaki gibi değil",oldName8,actualName8);
    }

    @And("The user click columns button")
    public void theUserClickColumnsButton() {
        BrowserUtils.waitForVisibility(pages.itemOverviewPage().getConfigureColumnsButton(),20);
        pages.itemOverviewPage().getConfigureColumnsButton().click();
        BrowserUtils.wait(3);
//        pages.userHomePage().columnsButton();
    }

    @And("The user clicks overview save button")
    public void theUserClicksOverviewSaveButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='EfSaveColumns']")).click();
        BrowserUtils.wait(4);
    }

    @When("The user click edit item side bar button")
    public void theUserClickEditItemSideBarButton() {
        pages.offstand().getSideBarButton().click();
        BrowserUtils.wait(1);
    }

    @When("The user click addToComparison button")
    public void theUserClickAddToComparisonButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='comparison-add-btn']")).click();
    }

    @When("The user click viewComparison button")
    public void theUserClickviewComparisonButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='compareBtn']")).click();
    }

    String selectedId;
    @When("The user get item info")
    public void theUserGetItemInfo() {
        BrowserUtils.adjustScreenSize(60,driver);
        BrowserUtils.wait(2);
        WebElement table = Driver.getDriver().findElement(By.id("items"));
        List<String> data = getColumnData(table,"Fletum Kimlik");
        selectedId = data.get(0);
        System.out.println("selectedId: " + selectedId);
    }

    @And("The user enters selected into {string} filter text input box")
    public void theUserEntersSelectedIntoFilterTextInputBox(String columnName) {
        pages.generalPage().useTextFilter(selectedId,columnName);
        BrowserUtils.wait(5);
    }

    @When("The user click overview edit button")
    public void theUserClickOverviewEditButton() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"items\"]/tbody/tr/td[16]/a[1]")).click();
    }

    String randomValue = UUID.randomUUID().toString();
    @When("The user update name")
    public void theUserUpdateName() {
        WebElement input = Driver.getDriver().findElement(By.xpath("//input[@class='inline-edit-input' and @data-field='DIA_FirstName']"));
        input.sendKeys(Keys.CONTROL + "A");
        input.sendKeys(randomValue);
    }

    @Then("The user verify name is edited")
    public void theUserVerifyNameIsEdited() {
        boolean isEdited = pages.dbProcess().isNameEdited(selectedId, randomValue);
        Assert.assertTrue("İsim Editlenmedi!!", isEdited);
    }

    @Given("The user go to edit item for user permission")
    public void theUserGoToEditItemForUserPermission() {
        Driver.getDriver().get("https://dia-preprod-ui.efectura.com/Enrich/EditItem/1782611");
    }

    @When("The user select first two checkbox in permissions")
    public void theUserSelectFirstTwoCheckboxInPermissions() {
        Driver.getDriver().findElements(By.xpath("//input[contains(@id,'group-permission-checkbox')]/following-sibling::label")).get(0).click();
        Driver.getDriver().findElements(By.xpath("//input[contains(@id,'group-permission-checkbox')]/following-sibling::label")).get(1).click();
    }

    @When("The user click read and write bulk button")
    public void theUserClickReadAndWriteBulkButton() {
        Driver.getDriver().findElement(By.xpath("//button[contains(@data-permission,'ReadAndWrite')]")).click();
    }

    @When("The user click save permission button")
    public void theUserClickSavePermissionButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='group-permissions-table-AddNew']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@id='save-permission']")).click();
    }

    @When("The user click kalıt bulk button")
    public void theUserClickKalitBulkButton() {
        Driver.getDriver().findElement(By.xpath("//button[@data-permission='NoChoice']")).click();
    }

    String itemCode;
    @When("The user set unique code value")
    public void theUserSetUniqueCodeValue() {
        BrowserUtils.waitForVisibility(pages.message().getCreateItemCodeInput(),30);
        itemCode = UUID.randomUUID().toString();
        pages.message().getCreateItemCodeInput().sendKeys(itemCode);
        System.out.println("itemCode: " + itemCode);
    }

    @When("The user select {string} as provider")
    public void theUserSelectAsProvider(String provider) {
        BrowserUtils.wait(1);
//        BrowserUtils.selectDropdownOptionByVisibleText(pages.message().getProviderSelect(),provider);
        driver.findElement(By.xpath("//*[@id=\"select2-select-provider-container\"]")).click();
        driver.findElement(By.xpath("//li[.='" + provider + "']")).click();

    }

    @When("The user click next button")
    public void theUserClickNextButton() {
        BrowserUtils.wait(1);
        BrowserUtils.waitForClickability(pages.message().getNextButton(),20);
        pages.message().getNextButton().click();
    }

    @When("The user select category")
    public void theUserSelectCategory() {
        //pages.message().getMessageCreateCategoryTab().click();
        BrowserUtils.wait(2);
        pages.message().getRootCategory().click();
    }

    @When("The user click second next button")
    public void theUserClickSecondNextButton() {
        BrowserUtils.wait(1);
        BrowserUtils.moveToElement(pages.message().getSecondNextButton());
        BrowserUtils.wait(1);
        pages.message().getSecondNextButton().click();
    }

    @When("The user select {string} as attribute")
    public void theUserSelectAsAttribute(String attribute) {
        pages.message().getRuleAttributeSelect().click();
        pages.message().getRuleSelectInput().sendKeys(attribute);
        BrowserUtils.wait(1);
        pages.message().getFirstAttributeOption().click();
    }

    @When("The user set {string} as attribute value")
    public void theUserSetAsAttributeValue(String value) {
        pages.message().getAttributeValueInput().sendKeys(value);
    }

    @When("The user click rule next button")
    public void theUserClickRuleNextButton() {
        BrowserUtils.wait(1);
        pages.message().getRuleNextButton().click();
    }

    String smsBody;
    @When("The user set sms body")
    public void theUserSetSmsBody() {
        smsBody = "SmsBody-" + UUID.randomUUID();
        pages.message().getSmsBodyInput().sendKeys(smsBody);
        System.out.println("smsBody: " + smsBody);
    }

    @When("The user click body next button")
    public void theUserClickBodyNextButton() {
        BrowserUtils.wait(1);
        pages.message().getBodyNextButton().click();
    }

    @When("The user select schedule as now")
    public void theUserSelectScheduleAsNow() {
//        BrowserUtils.wait(1);
//        pages.message().getNowScheduleOption().click();
    }

    @When("The user clicks schedule next button")
    public void theUserClicksScheduleNextButton() {
        BrowserUtils.wait(1);
        pages.message().getScheduleNextButton().click();
    }

    @When("The user clicks send button")
    public void theUserClicksSendButton() {
        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
        BrowserUtils.wait(1);
        BrowserUtils.moveToElement(pages.message().getSendButton());
        BrowserUtils.wait(1);
        pages.message().getSendButton().click();
        BrowserUtils.wait(11);
    }

//    @Then("The user verify the sms with db {string}")
//    public void theUserVerifyTheSmsWithDb(String dbName) {
////        BrowserUtils.wait(1);
//        String dbUrl = pages.dbProcess().getDbUrl(dbName);
//        pages.dbProcess().verifySmsIsSent(dbUrl,smsBody);
//        smsBody = "";
//    }


//    @Then("The user verifies info {string} appears")
//    public void theUserVerifiesInfoAppears(String expectedMessage) {
//        BrowserUtils.waitForVisibility(pages.message().getInfoMessage(),20);
//        Assert.assertEquals(expectedMessage, pages.message().getInfoMessage().getText());
//        BrowserUtils.wait(1);
//    }

    @When("The user set deeplink")
    public void theUserSetDeeplink() {
        pages.message().getPushDeeplinkInput().sendKeys("www.slk-automation.com");
    }

    String pushTitle;
    String pushBody;
    @When("The user set push title")
    public void theUserSetPushTitle() {
        pushTitle = "PushTitle-" + UUID.randomUUID();
        pages.message().getPushTitleInput().sendKeys(pushTitle);
        System.out.println("pushTitle: " + pushTitle);
    }

    @When("The user set push body")
    public void theUserSetPushBody() {
        pushBody = "PushBody-" + UUID.randomUUID();
        pages.message().getPushBodyInput().sendKeys(pushBody);
        System.out.println("pushBody: " + pushBody);
    }

//    @Then("The user verify the push with db {string}")
//    public void theUserVerifyThePushWithDbDEV_MDM(String dbName) {
//        //        BrowserUtils.wait(1);
//        String dbUrl = pages.dbProcess().getDbUrl(dbName);
//        pages.dbProcess().verifyPushIsSent(dbUrl,pushBody);
//    }

    String emailTitle;
    String emailBody;
    @When("The user set email title")
    public void theUserSetEmailTitle() {
        BrowserUtils.wait(2);
        emailTitle = "emailTitle-" + UUID.randomUUID();
        pages.message().getEmailTitleInput().sendKeys(emailTitle);
        System.out.println("emailTitle: " + emailTitle);
    }


    @When("The user set email body")
    public void theUserSetEmailBody() {
//        pages.message().getEmailRichTextEditor().click();
//        BrowserUtils.adjustScreenSize(60,Driver.getDriver());
//        pages.message().getMailTypeNextButton().click();
//        emailBody = "emailBody-" + UUID.randomUUID();
//        BrowserUtils.wait(1);
//        pages.message().getEmailBodyInput().sendKeys(emailBody);
//        System.out.println("emailBody: " + emailBody);
        emailBody = UUID.randomUUID().toString();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='email-iframe']")));
        driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//a[@href='#sample/welcome']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//div[contains(text(),'Merhaba Anna')]")).click();
        driver.findElement(By.xpath("//textarea[contains(.,'Merhaba Anna')]")).sendKeys(emailBody);
        driver.switchTo().defaultContent();

    }

    @Then("The user verify the email")
    public void theUserVerifyTheEmail() {
        BrowserUtils.wait(15);
        pages.dbProcess().verifyEmailIsSent(emailBody);
    }

    WebDriver driver = Driver.getDriver();
    @When("The user select {string} for NotificationType")
    public void theUserSelectForNotificationType(String type) {
        BrowserUtils.wait(1);
//        BrowserUtils.selectDropdownOptionByVisibleText(pages.message().getProviderSelect(),type);

        driver.findElement(By.xpath("//div[3]/div[1]/div[2]/div[3]/span")).click();
        driver.findElement(By.xpath("//li[.='" + type + "']")).click();

    }

    String notificationName;
    @When("The user set notification name")
    public void theUserSetNotificationName() {
        BrowserUtils.waitForVisibility(pages.message().getNotificationNameInput(),30);
        notificationName = UUID.randomUUID().toString();
        pages.message().getNotificationNameInput().sendKeys(notificationName);
        System.out.println("notificationName: " + notificationName);
    }

    @When("The user click createWithRule button")
    public void theUserClickCreateWithRuleButton() {
        driver.findElement(By.xpath("//div[contains(@data-target-option,'rule-builder')]")).click();
    }

    @Then("The user verifies edit item navigate")
    public void theUserVerifiesEditItemNavigate() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("EditItem"));
    }

    List<Integer> itemIds = new ArrayList<>();
    @When("The user get {int} {string} item id")
    public void theUserGetEventItemId(int count, String itemType) {
        itemIds = pages.dbProcess().getItemId(count,itemType);
    }

    @When("The user fill id inputs")
    public void theUserFillIdInputs() {
        BrowserUtils.waitForVisibility(driver.findElement(By.xpath("//input[@id='id1']")),60);
        driver.findElement(By.xpath("//input[@id='id1']")).sendKeys(itemIds.get(0) + "");
        driver.findElement(By.xpath("//input[@id='id2']")).sendKeys(itemIds.get(1) + "");
    }

    @When("The user click compare button")
    public void theUserClickCompareButton() {
        driver.findElement(By.xpath("//button[@id='compareSubmit']")).click();
    }

    @When("The user go to related target item")
    public void theUserGoToRelatedTargetItem() {
        driver.get("https://dia-preprod-ui.efectura.com/Enrich/EditItem/3496234");
    }

    String selectedId1;
    String selectedId2;
    @When("The user get category of first two items")
    public void theUserGetCategoryOfFirstTwoItems() {
//        BrowserUtils.adjustScreenSize(60,driver);
        WebElement table = Driver.getDriver().findElement(By.id("items"));
        List<String> data = getColumnData(table,"Fletum Kimlik");
        selectedId1 = data.get(0);
        selectedId2 = data.get(1);
        System.out.println("selectedId1: " + selectedId1);
        System.out.println("selectedId2: " + selectedId2);
    }

    @When("The user select first two items")
    public void theUserSelectFirstTwoItems() {
//        BrowserUtils.adjustScreenSize(30,driver);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//td[1]/div/div/input/following-sibling::label"));
        BrowserUtils.moveToElement(checkboxes.get(0));
        checkboxes.get(0).click();
        checkboxes.get(1).click();
    }

    @When("The user select create item family {string}")
    public void theUserSelectCreateItemFamily(String family) {
        BrowserUtils.wait(12);
        pages.itemOverviewPage()
                .getCreateItemFamilies()
                .stream()
                .filter(el -> el.getText().trim().equalsIgnoreCase(family))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Family not found: " + family))
                .click();

        driver.findElement(By.xpath("//button[@id='nextStepItemAttr']")).click();

    }

    String optionText;
    @When("The user fill event create attributes")
    public void theUserFillEventCreateAttributes() {
        BrowserUtils.wait(30);

        optionText = "Redign 1";
        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[1]/div/span/span[1]/span")).click();
        BrowserUtils.wait(12);
        driver.findElement(By.xpath("//li[.='Test Ajansı']")).click();
//        driver.findElement(By.xpath("/html/body/div[2]/div/div[15]/div/div/div[3]/div[2]/div/div[1]/div/div[2]/div/div[1]/div/span/span[1]/span/ul/li[2]/input")).
//                sendKeys(optionText + Keys.ENTER);

//        optionText = select.getOptions().get(1).getText();



//        driver.findElement(By.xpath("//input[@id='3832 Localizable']")).sendKeys(UUID.randomUUID().toString());
//
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[3]/div/span")).click();
//        driver.findElement(By.xpath("//span/span/span[1]/input")).sendKeys("Birebir");
//        driver.findElement(By.xpath("//li[.='Birebir']")).click();
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[3]/div/span")).click();
////        WebElement temasTipSelect = driver.findElement(By.xpath("//select[@id='attribute-4953']"));
////        BrowserUtils.selectDropdownOptionByIndex(temasTipSelect,1);
//
//        BrowserUtils.wait(2);
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[4]/div/span/span[1]/span")).click();
//        driver.findElement(By.xpath("//li[.='Mentoring']")).click();
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[4]/div/span/span[1]/span")).click();
////        WebElement stillSelect = driver.findElement(By.xpath("//select[@id='attribute-3822']"));
////        BrowserUtils.selectDropdownOptionByIndex(stillSelect,1);
//
//        driver.findElement(By.xpath("//div[@id='3809 Localizable']//p")).sendKeys("açıklama" + UUID.randomUUID().toString());
//
//        driver.findElement(By.xpath("//input[@id='DIA_Start_Date_E']")).click();
//        BrowserUtils.wait(1);
//        driver.findElement(By.xpath("//div[14]/div[2]/div/div[2]/div/span[contains(@class,'flatpickr-day today')]")).click();
//
//        driver.findElement(By.xpath("//input[@id='DIA_Finish_Date_E']")).click();
//        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div/span[contains(@class,'flatpickr-day today')]/following-sibling::span[1]")).click();
//
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[16]/div/span/span[1]/span")).click();
//        driver.findElement(By.xpath("//li[.='Ankara']")).click();
////        WebElement citySelect = driver.findElement(By.xpath("//select[@id='attribute-4922']"));
////        BrowserUtils.selectDropdownOptionByIndex(citySelect,1);
//
//        driver.findElement(By.xpath("//*[@id=\"required-attributes\"]/div[19]/div/span")).click();
//        driver.findElement(By.xpath("//li[.='Hayır']")).click();
////        WebElement isCustomer = driver.findElement(By.xpath("//select[@id='attribute-4925']"));
////        BrowserUtils.selectDropdownOptionByVisibleText(isCustomer,"Hayır");
//
//        driver.findElement(By.xpath("//input[@id='4923 Localizable']")).sendKeys("mekan -" + UUID.randomUUID().toString());

        WebElement fileInputCreate = driver.findElement(By.xpath("//input[@id='inputImageOnCreate']"));
//        fileInputCreate.sendKeys("C:\\Users\\fkara\\Desktop\\workspace\\DIAGEO-PROD\\src\\test\\java\\com\\sema\\pages\\BPM\\ModulFlows.java");
        fileInputCreate.sendKeys(getExcelPath("Attribute"));
        BrowserUtils.wait(5);

        driver.findElement(By.xpath("//button[@id='next-step-btn']")).click();



    }

    @When("The user select category for create")
    public void theUserSelectCategoryForCreate() {
        //driver.findElement(By.xpath("//a[@id='_fast-categories']")).click();
        BrowserUtils.adjustScreenSize(70,driver);
        BrowserUtils.wait(3);
        BrowserUtils.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Anason Akademisi')]/preceding-sibling::div[1]")));
        driver.findElement(By.xpath("//div[contains(text(),'Anason Akademisi')]/preceding-sibling::div[1]")).click();
        driver.findElement(By.xpath("//button[@id='next-step-btn']")).click();
    }

    @When("The user complete create")
    public void theUserCompleteCreate() {
        driver.findElement(By.xpath("//button[@id='next-step-segment-build']")).click();
        BrowserUtils.wait(2);
//        driver.findElement(By.xpath("//button[@id='last-step-preview']")).click();

        if (BrowserUtils.isElementDisplayed(By.xpath("//button[@id='last-step-preview']"))) {
            driver.findElement(By.xpath("//button[@id='last-step-preview']")).click();
        }

        driver.findElement(By.xpath("//button[@id='create-segment']")).click();
    }

    @When("The user verify created item edit page is open")
    public void theUserVerifyCreatedItemEditPageIsOpen() {
        BrowserUtils.wait(10);
        String url = Driver.getDriver().getCurrentUrl();
        System.out.println("Url: " + url);
        Assert.assertTrue("Url: " + url, url.contains("https://dia-preprod-ui.efectura.com/Enrich/EditItem/"));
    }

    @When("The user upload the file {string}")
    public void theUserUploadTheFileContactLimitTest(String fileName) {
        pages.itemOverviewPage().getItemImportInput().sendKeys(getExcelPath(fileName));
        pages.itemOverviewPage().getItemImportStep2NextButton().click();
    }

    @Then("The user verify over limit error message")
    public void theUserVerifyOverLimitErrorMessage() {
        By locate = By.xpath("//div[@class='error-alert-message']");
        BrowserUtils.waitForVisibility(locate,30);
        Assert.assertEquals("Limitten fazla mesajı gelmedi","Dosyada Limitten Fazla Item Mevcut",
                driver.findElement(locate).getText());
    }

    @When("The user select first two checkbox in overview")
    public void theUserSelectFirstTwoCheckboxInOverview() {
        Driver.getDriver().findElements(By.xpath("//div/div[1]/div/table/tbody/tr/td/div/div/input/following-sibling::label")).get(0).click();
        Driver.getDriver().findElements(By.xpath("//div/div[1]/div/table/tbody/tr/td/div/div/input/following-sibling::label")).get(1).click();
    }

    @When("The user click add list button")
    public void theUserClickAddListButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='addToListButton']")).click();
    }

    @When("The user click create new list button")
    public void theUserClickCreateNewListButton() {
        Driver.getDriver().findElement(By.xpath("//a[@id='createListBulk']")).click();
    }

    @When("The user fill new list name")
    public void theUserFillNewListName() {
        String listName = UUID.randomUUID().toString();
        Driver.getDriver().findElement(By.xpath("//input[@id='input-list']")).sendKeys(listName.substring(0, 6));
    }

    @When("The user click save list button")
    public void theUserClickSaveListButton() {
        Driver.getDriver().findElement(By.xpath("//button[@id='create-list']")).click();
    }

    @When("The user select category for create {string}")
    public void theUserSelectCategoryForCreateOnTrade(String category) {
        //driver.findElement(By.xpath("//a[@id='_fast-categories']")).click();
        BrowserUtils.adjustScreenSize(70,driver);
        BrowserUtils.wait(3);
        BrowserUtils.moveToElement(driver.findElement(By.xpath("//div[@class='category-tree']//div[contains(text(),'" + category + "')]/preceding-sibling::div[1]")));

        System.out.println("//div[@class='category-tree']//div[contains(text(),'" + category + "')]/preceding-sibling::div[1]");
        driver.findElement(By.xpath("//div[@class='category-tree']//div[contains(text(),'" + category + "')]/preceding-sibling::div[1]")).click();

        driver.findElement(By.xpath("//button[@id='next-step-btn']")).click();
    }

    @When("The user complete create for agency budget")
    public void theUserCompleteCreateForAgencyBudget() {
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//button[@id='next-step-segment-build']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@data-attribute-code='Ajans_Etkinlik_Butcesi']")).sendKeys("10");

        driver.findElement(By.xpath("//input[@id='ib-99999']")).sendKeys(getExcelPath("Attribute"));
        driver.findElement(By.xpath("//input[@id='ib-99998']")).sendKeys(getExcelPath("Attribute"));

        BrowserUtils.moveToElement(driver.findElement(By.xpath("//button[@id='next-step-segment-budget']")));
        driver.findElement(By.xpath("//button[@id='next-step-segment-budget']")).click();
        BrowserUtils.wait(4);

        driver.findElement(By.xpath("//button[@id='last-step-preview']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[@id='create-segment']")).click();

    }

    @When("The user set new attributes")
    public void theUserSetNewAttributes() {
        List<String> newAttributes = new ArrayList<>(Arrays.asList(
                "NewText",
                "NewDate",
                "NewSelect",
                "NewBoolean"
        ));
        BrowserUtils.wait(10);

        for (String attribute : newAttributes) {
            BrowserUtils.moveToElement(driver.findElement(By.xpath("//button[@data-column='" + attribute + "']")));
            BrowserUtils.wait(1);
            driver.findElement(By.xpath("//button[@data-column='" + attribute + "']")).click();
            BrowserUtils.wait(1);
            driver.findElement(By.xpath("//input[@id='attr-create-code']")).sendKeys(attribute);

            WebElement select = driver.findElement(By.xpath("//select[@id='attr-create-type']"));
            String attributeType = "Metin";
            if (attribute.equals("NewText"))
                attributeType = "Metin";
            if (attribute.equals("NewDate"))
                attributeType = "Tarih";
            if (attribute.equals("NewSelect"))
                attributeType = "Tekli Seçim";
            if (attribute.equals("NewBoolean"))
                attributeType = "Bool";


            BrowserUtils.selectDropdownOptionByVisibleText(select,attributeType);

            if (attribute.equals("NewSelect")) {
                WebElement selectNewSelect = driver.findElement(By.xpath("//select[@id='attr-options-code-column']"));
                BrowserUtils.selectDropdownOptionByVisibleText(selectNewSelect,attribute);

                WebElement selectNewSelect2 = driver.findElement(By.xpath("//select[@id='attr-options-label-column']"));
                BrowserUtils.selectDropdownOptionByVisibleText(selectNewSelect2,attribute);
            }


            driver.findElement(By.xpath("//button[@id='attr-create-save-btn']")).click();
            BrowserUtils.wait(5);
        }


    }

    @When("The user click second import next button")
    public void theUserClickSecondImportNextButton() {
        BrowserUtils.moveToElement(pages.itemOverviewPage().getItemImportStep3NextButton());
        BrowserUtils.wait(1);
        pages.itemOverviewPage().getItemImportStep3NextButton().click();
        BrowserUtils.wait(1);
    }

    @Then("The user tear down new attributes")
    public void theUserTearDownNewAttributes() {
        BrowserUtils.wait(3);
        int deletenAttributeCount = pages.dbProcess().deleteTestAttributesInItemImport();
        Assert.assertEquals("Yeni oluşturulan attribute'lar silinemedi",4,deletenAttributeCount);
    }

    @Then("The user tear down new attributes before")
    public void theUserTearDownNewAttributesBefore() {
        BrowserUtils.wait(3);
        int deletenAttributeCount = pages.dbProcess().deleteTestAttributesInItemImport();
        System.out.println("Deleted attribute count: " + deletenAttributeCount);
    }

    @Then("The user delete new items")
    public void theUserDeleteNewItems() {

        int itemId;
        System.out.println("newItemSkus: " + newItemSkus);
        System.out.println("randomSku1: " + randomSku1);
        for (String sku : newItemSkus) {
            itemId = pages.dbProcess().getItemIdByCode(sku);
            pages.dbProcess().deleteCreatedItem(itemId + "");
        }

    }

    @Then("The user delete attribute options")
    public void theUserDeleteAttributeOptions() {
        pages.dbProcess().deleteAttributeOptions();
    }

    @When("The user select list {string}")
    public void theUserSelectList(String listName) {
//        BrowserUtils.adjustScreenSize(70,driver);
        BrowserUtils.scrollToElement(driver,driver.findElement(By.xpath("//div[@id='addFromList']")));
        BrowserUtils.wait(1);
        BrowserUtils.hoverOver(driver.findElement(By.xpath("//div[@id='addFromList']")));
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-in']/li/a[text()='" + listName + "']")).click();
    }

    @When("The user click advanced filter button")
    public void theUserClickAdvancedFilterButton() {
        driver.findElement(By.xpath("//button[contains(.,'Gelişmiş Filtreler')]")).click();
    }

    @When("The user select {string} in first filter select")
    public void theUserSelectInFirstFilterSelect(String firstFilter) {
        WebElement select1 = driver.findElement(By.xpath("/html/body/div[2]/div/section/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/select[1]"));
        BrowserUtils.selectDropdownOptionByVisibleText(select1,firstFilter);
        BrowserUtils.wait(5);
    }

    @When("The user select {string} in first filter value select")
    public void theUserSelectInFirstFilterValueSelect(String selectValue) {
        WebElement selectValue1 = driver.findElement(By.xpath("/html/body/div[2]/div/section/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/div/span/span[1]/span/span[1]/span"));
        selectValue1.click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(selectValue);
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
        BrowserUtils.wait(1);
    }

    @When("The user click add filter button")
    public void theUserClickAddFilterButton() {
        driver.findElement(By.xpath("//button[contains(.,'Daha Fazla Filtre')]")).click();
        BrowserUtils.wait(2);
    }

    @When("The user select {string} in second filter value select")
    public void theUserSelectInSecondFilterValueSelect(String filter2) {
        WebElement select2 = driver.findElement(By.xpath("/html/body/div[2]/div/section/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/select[1]"));
        BrowserUtils.selectDropdownOptionByVisibleText(select2,filter2);
        BrowserUtils.wait(2);
    }

    @When("The user fill second filter input with {string}")
    public void theUserFillSecondFilterInputWith(String filterInputValue2) {
        WebElement filterInput2 = driver.findElement(By.xpath("/html/body/div[2]/div/section/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/div[2]/input"));
        filterInput2.sendKeys(filterInputValue2);
    }

    @When("The user click apply filter button")
    public void theUserClickApplyFilterButton() {
        driver.findElement(By.xpath("//button[.='Güncelle']")).click();
        BrowserUtils.wait(2);
    }

    @When("The user select {string} in second filter operator select")
    public void theUserSelectInSecondFilterOperatorSelect(String operator2) {
        WebElement selectOperator2 = driver.findElement(By.xpath("/html/body/div[2]/div/section/div[3]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/select[2]"));
        BrowserUtils.selectDropdownOptionByVisibleText(selectOperator2,operator2);
        BrowserUtils.wait(1);
    }

    String newProductSku;
    @When("The user fill product create attributes")
    public void theUserFillProductCreateAttributes() {
        newProductSku = UUID.randomUUID().toString();
        driver.findElement(By.xpath("//input[@id='inputCode']")).sendKeys(newProductSku);


        driver.findElement(By.xpath("//div[3]/div/div[1]/div/span/span[1]/span/span[1]")).click();
        driver.findElement(By.xpath("//span[1]/span/span[1]/input")).sendKeys("Viski" + Keys.ARROW_DOWN + Keys.ENTER);

        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//div/div/div/div[3]/div/div[1]/div/div[3]/div/div[2]/div/input")).sendKeys(newProductSku);

        driver.findElement(By.xpath("//button[@id='next-step-btn']")).click();

    }

    @When("The user click clone button")
    public void theUserClickCloneButton() {
        driver.findElement(By.xpath("//button[@id='clonebtn']")).click();
    }

    String cloneItemSku;
    @When("The user fill product clone item info")
    public void theUserFillProductCloneItemInfo() {
        cloneItemSku = UUID.randomUUID().toString();
        driver.findElement(By.xpath("//input[@id='skuinputvalue']")).sendKeys(cloneItemSku);
//        driver.findElement(By.xpath("//h5[.=' Ürün Grup Kodu']/following-sibling::input")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[@id='clone-create']")).click();
    }

    @When("The user click {string} attribute header")
    public void theUserClickAttributeHeader(String attributeHeader) {
        driver.findElement(By.xpath("//a[contains(text(),'" + attributeHeader + "')]")).click();
        BrowserUtils.wait(2);
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: Özellik Düzenle");
    }

    @Then("The user verifies {string} attribute edit page is open")
    public void theUserVerifiesAttributeEditPageIsOpen(String attributeName) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://dia-preprod-ui.efectura.com/Settings/EditAttribute/4542"));
        Assert.assertTrue(currentUrl.contains("4542"));
        WebElement pageInfo = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/nav/a[4]"));
        Assert.assertTrue(pageInfo.getText().contains(attributeName));
    }

    String singleAccountSku;
    String singleAccountBatchId;
    String message;
    int itemCount;
    @Given("The user create single event")
    public void theUserCreateSingleEvent() throws JSONException {
        String sku = UUID.randomUUID().toString();
        JSONObject singleAccountResponse = BrowserUtils.singleEventCreate(sku,174);

        System.out.println("singleAccountResponse: " + singleAccountResponse);

        singleAccountBatchId = singleAccountResponse.getString("batchId");
        message = singleAccountResponse.getString("message");
        itemCount = singleAccountResponse.getInt("itemCount");

        System.out.println("singleAccountSku: " + singleAccountSku);
        System.out.println("itemCount: " + itemCount);
        System.out.println("singleAccountBatchId: " + singleAccountBatchId);
        System.out.println("Message: " + message);

    }

    @When("The user click date filter area")
    public void theUserClickDateFilterArea() {
//        driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div/div[2]/div/div/input[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement dateInput = driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div/div[2]/div/div/input[2]"));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dateInput);

// Sadece açık olan calendar içindeki today
        By visibleToday = By.cssSelector("div.flatpickr-calendar.open span.flatpickr-day.today");

        WebElement today = wait.until(ExpectedConditions.elementToBeClickable(visibleToday));
        js.executeScript("arguments[0].click();", today);


        WebElement hourInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div.flatpickr-calendar.open input.flatpickr-hour")
                )
        );

        js.executeScript(
                "arguments[0].focus();" +
                        "arguments[0].value='3';" +
                        "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                hourInput
        );


//        driver.findElement(By.xpath("/html/body/div[12]/div[2]/div/div[2]/div/span[@class='flatpickr-day today']")).click();
    }

    @When("The user click second cancel filter button")
    public void theUserClickSecondCancelFilterButton() {
        driver.findElements(By.xpath("//button[@class='btn-filter cancel-filter']")).get(1).click();
    }

    String batchStatusRequestBatchId;
    int batchStatusRequestCompletedCount;
    int batchStatusRequestTotalCount;
    int batchStatusRequestFailedCount;
    int batchStatusRequestPendingCount;
    @Given("The user send getBatchStatus request")
    public void theUserSendGetBatchStatusRequest() throws JSONException {
        JSONObject batchStatusResponse =
                BrowserUtils.waitUntilBatchCompleted(singleAccountBatchId, 120, 3);

//        JSONObject batchStatusResponse = Requests.getBatchStatus(singleAccountBatchId);
        System.out.println("batchStatusResponse: " + batchStatusResponse);

        batchStatusRequestBatchId = batchStatusResponse.getString("batchId");
        batchStatusRequestCompletedCount = batchStatusResponse.getInt("completedCount");
        batchStatusRequestTotalCount = batchStatusResponse.getInt("totalCount");
        batchStatusRequestPendingCount = batchStatusResponse.getInt("pendingCount");
        batchStatusRequestFailedCount = batchStatusResponse.getInt("failedCount");
    }



    int singleAccountCountFromDb;
    @Then("The user verify Single Account Create scenario")
    public void theUserVerifySingleAccountCreateScenario() {
//        BrowserUtils.wait(15);
//        singleAccountCountFromDb = databaseMethods.getItemCountBySku(singleAccountSku);
        singleAccountCountFromDb = BrowserUtils.waitForItemInDb(singleAccountSku,30);
    }


    @Then("the user verify clone message")
    public void theUserVerifyCloneMessage() {
        String text = "Item was cloned successfully.";
        Assert.assertTrue(BrowserUtils.isElementDisplayed(By.xpath("//*[contains(normalize-space(.), '" + text + "')]")));
    }

    @When("The user go to transaction page")
    public void theUserGoToTransactionPage() {
        driver.get("https://dia-preprod-ui.efectura.com/Settings/TransactionPage");
    }

    @When("The user click create transaction button")
    public void theUserClickCreateTransactionButton() {
        driver.findElement(By.xpath("//button[@id='transaction_pages_table-AddNew']")).click();
    }

    @When("The user select db type {string}")
    public void theUserSelectDbType(String dbType) {
        WebElement dbTypeSelect = driver.findElement(By.xpath("//select[@id='db-type-create']"));

        BrowserUtils.selectDropdownOptionByVisibleText(dbTypeSelect, dbType);

    }

    String tableName;
    @When("The user fill transaction create inputs")
    public void theUserFillTransactionCreateInputs() {
        tableName = "Automation_" + UUID.randomUUID().toString().replace("-","").substring(0,6);
        System.out.println("Table Name: " + tableName);
        driver.findElement(By.xpath("//input[@id='table-name-create']")).sendKeys(tableName);

        WebElement itemTypeSelect = driver.findElement(By.xpath("//select[contains(@data-placeholder,'SelectItemType')]"));
        BrowserUtils.selectDropdownOptionByVisibleText(itemTypeSelect,"Event");

        driver.findElement(By.xpath("//input[@id='item-id-column-create']")).sendKeys("Id");

        driver.findElement(By.xpath("//button[contains(.,'AddColumn')]")).click();
        driver.findElement(By.xpath("//*[@id='columns-table-create']/tbody/tr/td[1]/input")).sendKeys("Id");
        driver.findElement(By.xpath("//*[@id='columns-table-create']/tbody/tr/td[3]/input")).click();
    }

    @When("The user click create transaction create button")
    public void theUserClickCreateTransactionCreateButton() {
        driver.findElement(By.xpath("//button[contains(.,'CreateTable')]")).click();
    }

    @And("The user enters created name into {string} filter text input box")
    public void theUserEntersCreatedNameIntoFilterTextInputBox(String transactionName) {
        //thead/tr[1]/th[normalize-space()='Address']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='Address']/preceding-sibling::th)+1]//input
        String locate = "//thead/tr[1]/th[normalize-space()='" + transactionName +
                "']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='" + transactionName +
                "']/preceding-sibling::th)+1]//input";

        WebElement filterInput = Driver.getDriver().findElement(By.xpath(locate));
        filterInput.sendKeys(tableName + Keys.ENTER);
    }

    @Then("The user verify {string} text filter with value in {string}")
    public void theUserVerifyTextFilterWithValueIn(String columnName, String table) {
        BrowserUtils.wait(2);
        WebElement tableElement = Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty(table)));
        List<String> values =  getColumnData(tableElement,columnName);

        System.out.println(values);
        BrowserUtils.wait(2);
        for (String actualValue : values) {
            Assert.assertTrue(actualValue.toLowerCase().contains(tableName.toLowerCase()));
//            Assert.assertEquals(expectedValue,actualValue);
        }
    }

    @Then("The user delete created transaction")
    public void theUserDeleteCreatedTransaction() {
        pages.dbProcess().deleteTransaction(tableName);
    }

    @When("The user go to seatunnel page")
    public void theUserGoToSeatunnelPage() {
        driver.get("https://dia-preprod-ui.efectura.com/Settings/Sentinel");
    }

    String runningJobs;
    String finishedJobs;
    String pendingJobs;
    String failedJobs;
    @Then("The user verify dashboard")
    public void theUserVerifyDashboard() {
        driver.switchTo().frame(driver.findElement(By.id("seaTunnelFrame")));

        runningJobs = driver.findElement(By.xpath("//p[text()='Running Jobs']/following-sibling::p")).getText();
        System.out.println("runningJobs: " + runningJobs);
        Assert.assertTrue("runningJobs sayısı negatif",Integer.parseInt(runningJobs) >= 0);

        finishedJobs = driver.findElement(By.xpath("//p[text()='Finished Jobs']/following-sibling::p")).getText();
        System.out.println("finishedJobs: " + finishedJobs);
        Assert.assertTrue("finishedJobs sayısı negatif",Integer.parseInt(finishedJobs) >= 0);

        pendingJobs = driver.findElement(By.xpath("//p[text()='Pending Jobs']/following-sibling::p")).getText();
        System.out.println("pendingJobs: " + pendingJobs);
        Assert.assertTrue("pendingJobs sayısı negatif",Integer.parseInt(pendingJobs) >= 0);

        failedJobs = driver.findElement(By.xpath("//p[text()='Failed Jobs']/following-sibling::p")).getText();
        System.out.println("failedJobs: " + failedJobs);
        Assert.assertTrue("failedJobs sayısı negatif",Integer.parseInt(failedJobs) >= 0);


        boolean recentJobsTableVisible = BrowserUtils.isElementDisplayed(By.xpath("/html/body/div/div/main/div/div/div[4]/div[2]/table"));
        Assert.assertTrue("Recent Job Runs tablosu gelmedi", recentJobsTableVisible);

    }

    @When("The user click {string} seatunnel tab")
    public void theUserClickRunningJobsSeatunnelTab(String tabName) {
        driver.findElement(By.xpath("//a[normalize-space()='" + tabName + "']")).click();
        BrowserUtils.wait(3);
    }

    @Then("The user verify finished jobs table")
    public void theUserVerifyFinishedJobsTable() {
        List<WebElement> finishedJobsRows = driver.findElements(By.xpath("//tbody[contains(@class,'divide-y')]//tr"));

        int count = finishedJobsRows.size();


        while (isButtonActive(driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[3]/button[2]")))) {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[3]/button[2]")).click();
            BrowserUtils.wait(2);
            count += finishedJobsRows.size();
        }

        System.out.println("Finished Jobs Count: " + count);

    }

    @Then("The user delete item values")
    public void theUserDeleteItemValues() {
        BrowserUtils.wait(15);
        String query = "DELETE FROM ItemValues\n" +
                "    WHERE AttributeId IN (\n" +
                "    SELECT Id FROM Attributes\n" +
                "    WHERE Code In ('NewText','NewBoolean','NewSelect','NewDate')\n" +
                "    )";


        int affectedRows = 0;
        try (Connection conn = Database.getInstance();
             PreparedStatement ps = conn.prepareStatement(query)) {

//            ps.setString(1, "%Test Automation%");

            affectedRows = ps.executeUpdate();
            System.out.println("Silinen kayıt sayısı: " + affectedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @When("The user click family title")
    public void theUserClickFamilyTitle() {
        driver.findElement(By.xpath("//a[.='FamilySelect']")).click();
        BrowserUtils.wait(2);
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: Aileler");
    }

    @Then("The user verify family overview page is open")
    public void theUserVerifyFamilyOverviewPageIsOpen() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://dia-preprod-ui.efectura.com/Settings/Families"));
    }

    @When("The user click status title")
    public void theUserClickStatusTitle() {
        driver.findElement(By.xpath("//a[.='Öğe Durumu']")).click();
        BrowserUtils.wait(2);
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: Öğe Durumları");

    }

    @Then("The user verify item status page is open")
    public void theUserVerifyItemStatusPageIsOpen() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://dia-preprod-ui.efectura.com/Settings/ItemStatuses"));
    }

    @When("The user click tags title")
    public void theUserClickTagsTitle() {
        driver.findElement(By.xpath("//div[@class='sidebar-overlay-section']/a[.='Etiketler']")).click();
        BrowserUtils.wait(2);
        BrowserUtils.switchToTabByTitleAndCloseOld("DIA: Etiketler");
    }

    @Then("The user verify tags page is open")
    public void theUserVerifyTagsPageIsOpen() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://dia-preprod-ui.efectura.com/Settings/Tags"));
    }

    String anySKU10;
    @When("The user fill import excel for create3")
    public void theUserFillImportExcelForCreate3() throws IOException {
        anySKU10 = pages.dbProcess().getAnySku("Contact","10");
        String filePath = getExcelPath(itemType);
        CommonExcelReader.setColumnHeader(filePath,indexAndHeaders.get("DIA_FirstName"),"İsim");

        anySKU9 = pages.dbProcess().getAnySku("Contact","4");
        randomName9 = UUID.randomUUID().toString();
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",1, anySKU9);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"İsim",1, randomName9);

        CommonExcelReader.updateCellValue(getExcelPath(itemType),"SKU",2, anySKU10);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"İsim",2, randomName9);
        CommonExcelReader.updateCellValue(getExcelPath(itemType),"E-Posta",2, "xxx");
    }

    @When("The user import the file new by skipping failed ones")
    public void theUserImportTheFileNewBySkippingFailedOnes() {
        BrowserUtils.wait(15);
        BrowserUtils.scrollToElement(driver,pages.itemOverviewPage().getSaveMatchColumnsButton());
        pages.itemOverviewPage().getSaveMatchColumnsButton().click();
        BrowserUtils.wait(2);
        BrowserUtils.waitForVisibility(pages.editItemPage().getInfoMessage(),90);
        Assert.assertEquals("Doğrulama Başarısız: DIA_Email:'Value String' is not in the correct format.", pages.editItemPage().getInfoMessage().getText());

        driver.findElement(By.xpath("//input[@id='ef-import-edit-skip-errors']")).click();

        importTime = BrowserUtils.getFormattedNow("UTC");
        System.out.println("import time utc: " + importTime);

        BrowserUtils.wait(4);

        BrowserUtils.waitForVisibility(pages.itemOverviewPage().getApplyImportValidationButton(),80);
        pages.itemOverviewPage().getApplyImportValidationButton().click();
        //FileUploaded
        BrowserUtils.wait(1);

        BrowserUtils.waitForVisibility(pages.editItemPage().getInfoMessage(),90);
        Assert.assertEquals("FileUploaded", pages.editItemPage().getInfoMessage().getText());
        System.out.println(pages.editItemPage().getInfoMessage().getText());
    }

    @When("The user go to findAndMatch page")
    public void theUserGoToFindAndMatchPage() {
        driver.get("https://dia-preprod-ui.efectura.com/Enrich/FindAndMatch");
    }

    @When("The user select {string} association type")
    public void theUserSelectAssociationType(String assocType) {
        WebElement assocSelect = driver.findElement(By.xpath("//select[@id='association-type']"));

        BrowserUtils.selectDropdownOptionByVisibleText(assocSelect, assocType);
        BrowserUtils.wait(5);

    }

    @When("The user select primary item attribute {string}")
    public void theUserSelectPrimaryItemAttribute(String attributeName) {
        WebElement primaryContainer = driver.findElement(By.xpath("//span[@id='select2-selectPrimaryAttributes-container']"));
        primaryContainer.click();
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(attributeName);
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
    }

    @When("The user select secondary item attribute {string}")
    public void theUserSelectSecondaryItemAttribute(String attributeName) {
        WebElement secondaryContainer = driver.findElement(By.xpath("//span[@id='select2-selectSecondaryAttributes-container']"));
        secondaryContainer.click();
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(attributeName);
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.ENTER);
    }

    @When("The user click find and match preview button")
    public void theUserClickFindAndMatchPreviewButton() {
        driver.findElement(By.xpath("//button[@id='previewConnectedAttributes']")).click();
        BrowserUtils.wait(3);
    }

    @When("The user click connect button in find and match table")
    public void theUserClickConnectButtonInFindAndMatchTable() {
        driver.findElement(By.xpath("//button[@id='connect-attributes']")).click();
    }

    @Then("The user verify items has association")
    public void theUserVerifyItemsHasAssociation() {
        pages.itemOverviewPage().verifyFindAndMatchItemAssoc();
    }

    @Then("The user delete association between items")
    public void theUserDeleteAssociationBetweenItems() {
        String query = "DELETE FROM Associations\n" +
                "   WHERE FirstItemId = 3496510\n" +
                "   AND SecondItemId = 3496333";

        int affectedRows = 0;
        try (Connection conn = Database.getInstance();
             PreparedStatement ps = conn.prepareStatement(query)) {

//            ps.setString(1, "%Test Automation%");

            affectedRows = ps.executeUpdate();
            System.out.println("Silinen kayıt sayısı: " + affectedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("Association silinemedi",1,affectedRows);


    }

    @When("The user select saved connect {string}")
    public void theUserSelectSavedConnectTest(String connectName) {
        List<WebElement> savedConnections = driver.findElements(By.xpath("//div[@id='dc-src-saved-conn-chips']/button"));
        for (WebElement connection : savedConnections) {
            if (connection.getText().equals(connectName)) {
                connection.click();
                break;
            }
        }

    }

    @When("The user click test connect button")
    public void theUserClickTestConnectButton() {
        driver.findElement(By.xpath("//button[@id='dc-src-test-conn']")).click();
    }

    @When("The user click first next button")
    public void theUserClickFirstNextButton() {
        driver.findElement(By.xpath("//button[@id='dc-src-next']")).click();
    }

    @When("The user click sql button")
    public void theUserClickSqlButton() {
        driver.findElement(By.xpath("//button[@data-ds-tab='sql']")).click();
    }

    @When("The user fill sql query")
    public void theUserFillSqlQuery() {
        WebElement sqlTextArea = driver.findElement(By.xpath("//textarea[@id='dc-src-sql']"));

        String query = "SELECT FirstItemId,SecondItemId FROM Associations\n" +
                "   WHERE SecondItemId = 1188307\n" +
                "   AND FirstItemId = 1527140";
        sqlTextArea.sendKeys(query);
    }

    String resultCount;
    @When("The user click run query button")
    public void theUserClickRunQueryButton() {
        driver.findElement(By.xpath("//button[@id='dc-src-run-query']")).click();

        resultCount = driver.findElement(By.xpath("//span[@id='dc-src-sql-result-msg']/span")).getText().split(" ")[0];

        System.out.println("resultCount: " + resultCount);

    }

    @When("The user click data connect second next button")
    public void theUserClickDataConnectSecondNextButton() {
        driver.findElement(By.xpath("//*[@id=\"dc-create-modal\"]/div/div/div[2]/div[2]/div[2]/div/div[2]/button[3]")).click();
    }

    @When("The user click data connect third next button")
    public void theUserClickDataConnectThirdNextButton() {
        driver.findElement(By.xpath("//*[@id=\"dc-create-modal\"]/div/div/div[2]/div[2]/div[3]/div/div[2]/button[3]")).click();
    }

    @When("The user select {string} for data connect family")
    public void theUserSelectForDataConnectFamily(String family) {
        WebElement familySelect = driver.findElement(By.xpath("//select[@id='dc-is-familyid']"));
        BrowserUtils.selectDropdownOptionByVisibleText(familySelect,family);
    }

    @When("The user select {string} for data connect item type")
    public void theUserSelectForDataConnectItemType(String itemType) {
        WebElement itemTypeSelect = driver.findElement(By.xpath("//select[@id='dc-is-itemtype']"));
        BrowserUtils.selectDropdownOptionByVisibleText(itemTypeSelect, itemType);
    }

    @When("the user select {string} for data connect sku")
    public void theUserSelectForDataConnectSku(String skuOption) {
        WebElement skuSelect = driver.findElement(By.xpath("//select[@id='dc-is-sku-column']"));
        BrowserUtils.selectDropdownOptionByVisibleText(skuSelect,skuOption);
    }

    @When("The user map attribute {string}")
    public void theUserMapAttribute(String attributeName) {
        driver.findElement(By.xpath("//*[@id=\"dc-is-attr-rows\"]/div[1]/div[1]/input")).click();

        WebElement attributeSelect = driver.findElement(By.xpath("//*[@id=\"dc-is-attr-rows\"]/div[1]/div[4]/div/select"));
        BrowserUtils.selectDropdownOptionByVisibleText(attributeSelect,attributeName);

    }

    @When("The user set cron expression")
    public void theUserSetCronExpression() {
        driver.findElement(By.xpath("//input[@id='dc-enable-cron']")).click();

        String cron = BrowserUtils.getCronForNext2Minutes();
        System.out.println("cron: " + cron);
        driver.findElement(By.xpath("//input[@id='dc-cron-expression']")).sendKeys(cron);

    }

    @When("The user click data connect create button")
    public void theUserClickDataConnectCreateButton() {
        driver.findElement(By.xpath("//button[@id='dc-create-submit']")).click();
    }

    @Given("The user go to StandBudgetGeneralReport page")
    public void theUserGoToStandBudgetGeneralReportPage() {
        driver.get("https://dia-preprod-ui.efectura.com/Reports/StandBudgetGeneralReport");
        BrowserUtils.wait(2);
    }

    @When("The user fill customer code {string}")
    public void theUserFillCustomerCode(String customerCode) {
        driver.findElement(By.xpath("//input[@id='standTrackKodu']")).sendKeys(customerCode);

    }

    @When("The user select {string} in marka isi select")
    public void theUserSelectInMarkaIsiSelect(String markaOption) {
        WebElement markaSelect = driver.findElement(By.xpath("//select[@id='standMarkaisi']"));
        BrowserUtils.selectDropdownOptionByVisibleText(markaSelect,markaOption);
    }

    String randomKalem1;
    @When("The user fill random kalem name with price {string}")
    public void theUserFillRandomKalemNameWithPrice(String kalemPrice) {
        randomKalem1 = UUID.randomUUID().toString();
        System.out.println("randomKalem1: " + randomKalem1);
        List<WebElement> kalemNameInputs = driver.findElements(By.xpath("//input[@placeholder='Kalem İsmi']"));
        List<WebElement> kalemPriceInputs = driver.findElements(By.xpath("//input[@placeholder='Fiyat']"));


        kalemNameInputs.get(kalemNameInputs.size()-1).sendKeys(randomKalem1);
        kalemPriceInputs.get(kalemPriceInputs.size()-1).sendKeys(kalemPrice);
        BrowserUtils.wait(4);
    }

    String removedColumn;
    @When("The user remove one column")
    public void theUserRemoveOneColumn() {
        for (WebElement column : pages.itemOverviewPage().getAlreadySelectedColumns()) {
            if (!column.getAttribute("class").contains("item-default-columns")) {
                BrowserUtils.dragAndDrop(column, pages.itemOverviewPage().getToBeSelectedArea());
                BrowserUtils.wait(3);
                removedColumn = column.getText();
                System.out.println("Removed Column: " + removedColumn);
                break;
            }
        }
    }

    @And("The user add the removed column")
    public void theUserAddTheRemovedColumn() {
        BrowserUtils.wait(2);
        WebElement matchingElement = pages.itemOverviewPage().getToBeSelectedColumns().stream()
                .filter(el -> el.getText().trim().equalsIgnoreCase(removedColumn))
                .findFirst()
                .orElse(null);

        BrowserUtils.dragAndDrop(matchingElement, pages.itemOverviewPage().getAlreadySelectedColumns().get(0));
        BrowserUtils.wait(1);
    }

    @Then("The user verifies positive info {string} appears")
    public void theUserVerifiesPositiveInfoAppears(String message) {
        WebElement el = Driver.getDriver().findElement(
                By.xpath("//*[contains(.,'" + message + "')]")
        );

// attribute alma
        String classAttr = el.getAttribute("class");
        String idAttr = el.getAttribute("id");
        String style = el.getAttribute("style");

        System.out.println(classAttr);
        System.out.println(idAttr);
        System.out.println(style);
    }
}
