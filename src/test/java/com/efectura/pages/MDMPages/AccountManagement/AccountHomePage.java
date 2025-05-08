package com.efectura.pages.MDMPages.AccountManagement;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountHomePage extends BasePage {
    @FindBy(xpath = "//a[normalize-space()='İlişkili']")
    private WebElement associatedFilterClick;
    @FindBy(xpath = "//span/span[1]/input")
    private WebElement associatedAllFilter;
    @FindBy(xpath = "(//input[@id='userselect'])[1]")
    private WebElement selectFirstItem;
    @FindBy(xpath = "//tbody/tr/td[3]/div[1]")
    private List<WebElement> noAssociatedText;
    @FindBy(xpath = "//span/span[1]/input")
    private WebElement associatedNoFilter;
    public void onTheAccountPage() {
        driver.navigate().to("https://sandbox.efectura.com/Enrich/Items?itemType=Account");
    }

    public void clickAssociatedFilter() {
        BrowserUtils.wait(7);
        associatedFilterClick.click();

    }

    public void clickAssociatedAllFilter() {
        BrowserUtils.waitForVisibility(associatedAllFilter, 30);
        associatedAllFilter.sendKeys("Tümü"+ Keys.ENTER);
        BrowserUtils.wait(3);
    }

    public void clicksSelectFirstItem() {
        BrowserUtils.wait(7);
        selectFirstItem.click();
        BrowserUtils.wait(5);
    }
    public void clickAssociatedNoFilter() {
        BrowserUtils.wait(10);
        associatedNoFilter.sendKeys("Hayır"+ Keys.ENTER);
    }
public void verifyAssociatedNoFilter(){
    BrowserUtils.wait(9);

    for (WebElement element : noAssociatedText) {
        Assert.assertEquals("Hayır", element.getText());

    }

}
}