package com.efectura.pages.SystemPages;

import com.efectura.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class TableEditorPage extends BasePage {

    @FindBy(xpath = "//a[@href='#create-tab']")
    private WebElement createNewTab;

    @FindBy(xpath = "//*[@id=\"table-form-edit\"]/section[2]//div/button[3]")
    private WebElement createTableButton;

    @FindBy(xpath = "//div[2]/div/div/div[2]/form/section[1]/div/div/input")
    private List<WebElement> createTableInputs;

    @FindBy(xpath = "//*[@id=\"table-form-edit\"]/section[1]/div/div[4]/select")
    private WebElement itemTypeSelect;

    @FindBy(xpath = "//*[@id=\"table-form-edit\"]/section[1]/div/div[4]/span[2]/span[1]/span/span[2]")
    private WebElement itemTypeSelectOpener;

    @FindBy(xpath = "//*[@id=\"table-form-edit\"]/section[1]/div/div[5]/select")
    private WebElement familySelect;

    @FindBy(xpath = "//*[@id=\"table-form-edit\"]/section[1]/div/div[7]/select")
    private WebElement AttributeColumnSelect;

    @FindBy(xpath = "//*[@id=\"db-type-create\"]")
    private WebElement dbTypeSelect;

    @FindBy(xpath = "//*[@id=\"table-form-edit\"]/section[2]//div/button[2]")
    private WebElement addColumnButton;

    @FindBy(xpath = "//*[@id=\"table-form-edit\"]/section[2]/div/button[1]")
    private WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"columns-table-create\"]/tbody/tr/td[1]/input")
    private WebElement tableNameInput;

    @FindBy(xpath = "//*[@id=\"columns-table-create\"]/tbody/tr/td[2]/div/button")
    private WebElement tableTypeSelectOpenerButton;

    @FindBy(xpath = "//*[@id=\"columns-table-create\"]/tbody/tr/td[2]/div/div/input")
    private WebElement tableTypeSelectSearchInput;

    @FindBy(xpath = "//*[@id=\"columns-table-create\"]/tbody/tr/td[2]/div/div/div/div")
    private List<WebElement> tableTypeSelectOptions;

    @FindBy(xpath = "//select[@id='schema-name-create']")
    private WebElement schemaNameSelect;

    @FindBy(xpath = "//select[@id='table-list']")
    private WebElement tableListSelect;

    @FindBy(xpath = "//*[@id=\"tables-tab\"]/section[1]/div/div[2]/button[1]")
    private WebElement deleteButton;




}
