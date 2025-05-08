package com.efectura.pages.SystemPages;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BlackListPage extends BasePage {
    @FindBy(xpath = "//a[@id='create-tag-button']")
    private WebElement blackListNewCreateButton;
    @FindBy(xpath = "//input[@id='black-phone']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='black-card']")
    private WebElement cardNumber;
    @FindBy(xpath = "//div[@class='modal-dialog modalPage']//div[@class='pull-right']")
    private WebElement addButton;
    @FindBy(xpath = "//div[@class='pull-right']//a[@id='cancelItem']")
    private WebElement cancelButton;
    @FindBy(xpath = "//span[normalize-space()='Changes saved successfully.']")
    private WebElement savedText;
    @FindBy(xpath = "//input[@id='phoneNumber']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//tr//td[2]")
    private List<WebElement> phoneNumbers;
    @FindBy(xpath = "//tbody/tr[1]/td[10]/a[1]")
    private WebElement deleteButton;
    @FindBy(xpath = "//button[@id='deleteLocaleBtn']")
    private WebElement deleteButtonPopup;
    @FindBy(xpath = "//div[@id='openModal']//button[@type='button'][normalize-space()='Cancel']")
    private WebElement cancelButtonPopup;
    @FindBy(xpath = "//a[@title='ActivateBlacklist']")
    private WebElement activeBlackListButton;
    @FindBy(xpath = "//div[@id='activateBlacklist']//button[@type='button'][normalize-space()='Cancel']")
    private WebElement cancelButtonActivePopup;
    @FindBy(xpath = "//button[@id='activate-blacklist']")
    private WebElement activateBlackListActivePopup;
    @FindBy(id = "notifyjs-container-top-right")
    private WebElement activateBlackListText;
    @FindBy(xpath = "//input[@id='passivePhoneNumber']")
    private WebElement passivePhoneNumberField;
    @FindBy(xpath = "//input[@id='cardNumber']")
    private WebElement cardNumbersField;
    @FindBy(xpath = "//input[@id='passiveCardNumber']")
    private WebElement passiveCardNumbersField;

    public BlackListPage() {
    }

    public void verifyBlackListNewCreateButton(int timeout) {
        BrowserUtils.waitForVisibility(blackListNewCreateButton, timeout);
        Assert.assertTrue(blackListNewCreateButton.isDisplayed());
    }

    public void clickBlackListNewCreateButton() {
        blackListNewCreateButton.click();
    }

    public void setPhoneNumber(String phone) {
        phoneNumber.sendKeys(phone);
    }

    public void setCardNumber(String card) {
        cardNumber.sendKeys(card);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void verifySavedText(String text) {
        BrowserUtils.waitForVisibility(savedText, 20);
        Assert.assertTrue(savedText.getText().equalsIgnoreCase(text));
    }

    public void setPhoneNumberField(String phoneNumber) {
        BrowserUtils.waitForVisibility(phoneNumberField, 20);
        if (phoneNumber.equalsIgnoreCase("fullNumber")) {
            phoneNumberField.sendKeys(Constants.FULL_PHONE_NUMBER);
        } else if (phoneNumber.equalsIgnoreCase("partialNumber")) {
            phoneNumberField.sendKeys(Constants.PARTIAL_PHONE_NUMBER);
        } else if (phoneNumber.equalsIgnoreCase("invalidNumber")) {
            phoneNumberField.sendKeys(Constants.INVALID_PHONE_NUMBER);
        } else {
            phoneNumberField.sendKeys(phoneNumber);
        }
        BrowserUtils.wait(5);
    }

    public void verifyPhoneNumber(String phoneNumber) {
        BrowserUtils.waitForVisibility(phoneNumberField, 30);
        if (phoneNumber.equalsIgnoreCase("fullNumber")) {
            Assert.assertTrue(phoneNumbers.size() == 1);
        } else if (phoneNumber.equalsIgnoreCase("partialNumber")) {
            Assert.assertTrue(phoneNumbers.size() > 1);
        } else {
            Assert.assertTrue(phoneNumbers.size() < 1);
        }
    }

    public void verifyPhoneNumberCancel(String phoneNumber) {
        boolean isDisplayed = false;
        if (phoneNumbers.size() == 1 || phoneNumbers.size() == 2) {
            isDisplayed = true;
            BrowserUtils.waitForVisibility(phoneNumberField, 30);
        }
        Assert.assertTrue(isDisplayed);
    }

    public void verifyResetButton() {
        BrowserUtils.wait(1);
        Assert.assertTrue(phoneNumbers.size() > 1);
    }

    public void clickDeleteButton() {
        BrowserUtils.waitForVisibility(deleteButton, 20);
        deleteButton.click();
    }

    public void clickDeleteButtonPopup() {
        BrowserUtils.waitForVisibility(deleteButtonPopup, 20);
        deleteButtonPopup.click();
    }

    public void clickCancelButtonPopup() {
        BrowserUtils.waitForVisibility(cancelButtonPopup, 20);
        cancelButtonPopup.click();
    }

    public void clickActiveButton() {
        BrowserUtils.waitForVisibility(activeBlackListButton, 20);
        activeBlackListButton.click();
    }

    public void clickActiveButtonPopup() {
        BrowserUtils.waitForVisibility(activateBlackListActivePopup, 20);
        activateBlackListActivePopup.click();
    }

    public void clickCancelButtonActivePopup() {
        BrowserUtils.waitForVisibility(cancelButtonActivePopup, 20);
        cancelButtonActivePopup.click();
    }

    public void verifyActiveBlackListButton() {
        BrowserUtils.wait(2);
        Assert.assertTrue(phoneNumbers.size() < 1);
    }

    public void verifyActiveText() {
        BrowserUtils.waitForVisibility(activateBlackListText, 20);
        Assert.assertTrue(activateBlackListText.isDisplayed());
    }

    public void setPassivePhoneNumberField(String phoneNumber) {
        BrowserUtils.waitForVisibility(passivePhoneNumberField, 20);
        if (phoneNumber.equalsIgnoreCase("fullNumber")) {
            passivePhoneNumberField.sendKeys(Constants.FULL_PHONE_NUMBER);
        } else if (phoneNumber.equalsIgnoreCase("partialNumber")) {
            passivePhoneNumberField.sendKeys(Constants.PARTIAL_PHONE_NUMBER);
        } else {
            passivePhoneNumberField.sendKeys(Constants.INVALID_PHONE_NUMBER);
        }
        BrowserUtils.wait(5);
    }

    public void setCardNumberField(String cardNumber) {
        BrowserUtils.waitForVisibility(cardNumbersField, 20);
        if (cardNumber.equalsIgnoreCase("fullNumber")) {
            cardNumbersField.sendKeys(Constants.FULL_CARD_NUMBER);
        } else if (cardNumber.equalsIgnoreCase("partialNumber")) {
            cardNumbersField.sendKeys(Constants.PARTIAL_CARD_NUMBER);
        } else if (cardNumber.equalsIgnoreCase("invalidNumber")) {
            cardNumbersField.sendKeys(Constants.INVALID_CARD_NUMBER);
        } else {
            cardNumbersField.sendKeys(cardNumber);
        }
        BrowserUtils.wait(5);
    }

    public void setPassiveCardNumberField(String cardNumber) {
        BrowserUtils.waitForVisibility(passiveCardNumbersField, 20);
        if (cardNumber.equalsIgnoreCase("fullNumber")) {
            passiveCardNumbersField.sendKeys(Constants.FULL_CARD_NUMBER);
        } else if (cardNumber.equalsIgnoreCase("partialNumber")) {
            passiveCardNumbersField.sendKeys(Constants.PARTIAL_CARD_NUMBER);
        } else if (cardNumber.equalsIgnoreCase("invalidNumber")) {
            passiveCardNumbersField.sendKeys(Constants.INVALID_CARD_NUMBER);
        } else {
            passiveCardNumbersField.sendKeys(cardNumber);
        }
        BrowserUtils.wait(5);
    }

    public void onTheBlackListPage() {
        driver.navigate().to("https://sandbox.efectura.com/Settings/BlackList");
    }

}