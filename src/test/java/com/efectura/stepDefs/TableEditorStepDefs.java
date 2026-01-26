package com.efectura.stepDefs;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class TableEditorStepDefs extends BaseStep {

    WebDriver driver = Driver.getDriver();

    @When("The user click CreateNew tab")
    public void theUserClickCreateNewTab() {
        pages.tableEditorPage().getCreateNewTab().click();
    }

    @When("The user click create table button")
    public void theUserClickCreateTableButton() {
        pages.tableEditorPage().getCreateTableButton().click();
    }


    String random;
    @When("The user fill table info")
    public void theUserFillTableInfo() {
        BrowserUtils.wait(1);
        for (WebElement input : pages.tableEditorPage().getCreateTableInputs()) {
            if (input.getAttribute("id").contains("schema")) {
                input.sendKeys("dbo");
                continue;
            }
            random = UUID.randomUUID().toString().replace("-", "");
            System.out.println(random);
            input.sendKeys("test67" + random);
        }

        BrowserUtils.selectDropdownOptionByRandom(pages.tableEditorPage().getItemTypeSelect(),driver);
        BrowserUtils.selectDropdownOptionByRandom(pages.tableEditorPage().getAttributeColumnSelect(),driver);
        BrowserUtils.selectDropdownOptionByRandom(pages.tableEditorPage().getFamilySelect(),driver);




    }

    @When("The user add column button")
    public void theUserAddColumnButton() {
        pages.tableEditorPage().getAddColumnButton().click();
    }

    @When("The user fill table")
    public void theUserFillTable() {
        pages.tableEditorPage().getTableNameInput().sendKeys("test67");
        pages.tableEditorPage().getTableTypeSelectOpenerButton().click();
        BrowserUtils.getRandomElementFromList(pages.tableEditorPage().getTableTypeSelectOptions()).click();
        BrowserUtils.wait(3);
        System.out.println(UUID.randomUUID().toString().replace("-", "_"));
    }

    String databaseType;
    @When("The user select {string} for db type")
    public void theUserSelectSQLServerForDbType(String dbType) {
        databaseType = dbType;
        BrowserUtils.selectDropdownOptionByVisibleText(pages.tableEditorPage().getDbTypeSelect(),dbType);
    }

    @Then("The user verify schema name select")
    public void theUserVerifySchemaNameSelect() {
        if (databaseType.equalsIgnoreCase("SQLServer")) {
            Assert.assertFalse(BrowserUtils.isElementDisplayed(pages.tableEditorPage().getSchemaNameSelect()));
        } else if (databaseType.equalsIgnoreCase("ClickHouse")) {
            Assert.assertTrue(BrowserUtils.isElementDisplayed(pages.tableEditorPage().getSchemaNameSelect()));
        }
    }

    @When("The user select the created table")
    public void theUserSelectTheCreatedTable() {
        BrowserUtils.selectDropdownOptionByVisibleText(pages.tableEditorPage().getTableListSelect(),"test67" + random);
    }
}
