package com.efectura.pages.MDMPages.ConnectorManagement4;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class ConnectorHomePage extends BasePage {
    @FindBy(xpath = "//div[@id='filter-Id']")
    private WebElement idFilter;
    @FindBy(xpath = "//input[@id='filter-Id-from']")
    private WebElement idFilterFrom;
    @FindBy(xpath = "//td[@class='sorting_1']")
    private WebElement verifyIdFilterFrom;
    @FindBy(xpath = "//tr//td[2]")
    private WebElement verifyConnectorCodeFilter;
    @FindBy(xpath = "//input[@id='filter-SKU']")
    private WebElement codeFilter;
    @FindBy(xpath = "//a[normalize-space()='Connector Overview']")
    private WebElement verifyContactEditButton;
    @FindBy (xpath = "//a[normalize-space()='testttsema']")
    private WebElement editListItem;

    public ConnectorHomePage() {
    }
    public void clickIdFilter(String id) {
        idFilter.click();

    }
    public void idFilterFrom(String id) {
        idFilterFrom.click();
        idFilterFrom.sendKeys(id);
    }
    public void verifyIdFilter(String id) {
        BrowserUtils.wait(5);
        assertTrue(verifyIdFilterFrom.getText().equalsIgnoreCase(id));
    }
    public void verifyConnectorCodeFilter(String code) {
        BrowserUtils.wait(10);
        assertTrue(verifyConnectorCodeFilter.getText().equalsIgnoreCase(code));
    }
    public void verifyResetButton() {
        assertTrue(true);
        BrowserUtils.wait(5);
    }
    public void verifyEditPage() {
        BrowserUtils.wait(5);
        assertTrue(verifyContactEditButton.isDisplayed());

    }
    public void clickListItem() {
        BrowserUtils.waitForVisibility(editListItem, 20);
        editListItem.click();
    }
}

