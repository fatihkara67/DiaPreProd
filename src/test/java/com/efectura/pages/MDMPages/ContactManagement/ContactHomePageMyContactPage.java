package com.efectura.pages.MDMPages.ContactManagement;
import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.efectura.pages.SystemPages.CurrenciesPage.isButtonActive;

public class ContactHomePageMyContactPage extends BasePage {
    @FindBy(xpath = "//tr//td[@class='sorting_1']")
    private List<WebElement> myContactsNames;
    @FindBy(xpath = "//input[@class='pagination-text']")
    private WebElement peginationText;
    @FindBy(xpath = "//span[@id='items_next']")
    private WebElement itemNextButton;
    @FindBy(xpath = "//div[@id='items_info']")
    private WebElement showingEntriesText;
    @FindBy(xpath = "//span[@id='items_previous']")
    private WebElement itemPreviousButton;
    @FindBy(xpath = "//button[@id='firtPageTable']")
    private WebElement itemLeftPreviousButton;
    @FindBy(xpath = "//div[@class='custom-button-right custom-button-page']")
    private WebElement itemRightNextButton;
    @FindBy(id = "inputCode")
    private WebElement uniqueCodeElement;

    public ContactHomePageMyContactPage() {
    }

    public void verifyMyContact() {
        BrowserUtils.waitForVisibility(myContactsNames.get(0), 20);
        Assert.assertTrue(myContactsNames.size() > 0);
    }

    public void clickItemNextButton() {
        BrowserUtils.waitForVisibility(itemNextButton, 20);
        itemNextButton.click();
    }

    public void verifyItemNextShowingEntriesText() {
        BrowserUtils.wait(5);
        Assert.assertFalse(showingEntriesText.getText().contains("11 to 1"));

    }
    public void clickItemPreviousButton() {
        BrowserUtils.wait(5);
        itemPreviousButton.click();
    }
    public void verifyItemPreviousShowingEntriesText() {
        BrowserUtils.wait(5);
        System.out.println(showingEntriesText.getText());
        Assert.assertTrue(showingEntriesText.getText().contains("1 to 10"));
    }
    public void verifyItemPreviousButtonUnclickable(){
        BrowserUtils.wait(7);
        Assert.assertFalse(isButtonActive(itemPreviousButton));
    }
    public void verifyItemLeftPreviousButtonUnclickable(){
        String classes = itemLeftPreviousButton.getAttribute("class");
        Assert.assertTrue(classes.contains("disabled"));
    }
    public void verifyNextPageButtonUnClickable() {
        BrowserUtils.wait(8);
        Assert.assertFalse(isButtonActive(itemNextButton));
    }
    public void setUniqueCodeElement(String uniqueCode1){
        uniqueCodeElement.sendKeys(uniqueCode1);
    }
}