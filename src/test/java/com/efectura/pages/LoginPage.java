package com.efectura.pages;


import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Constants;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {
    @FindBy(xpath = "//iframe[@id='nr-ext-rsicon']")
    private WebElement iframe;
    @FindBy(id = "Username")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@id='password-field']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//img[@id='navLogo']")
    private WebElement successfulLoginConfirmation;
    @FindBy(xpath = "//div[@class='validation-summary-errors text-danger']")
    private WebElement loginErrorText;
    @FindBy(xpath = "//label[@id='warning-text']")
    private WebElement emptyLoginErrorText;
    @FindBy(xpath = "//a[@class='colorWhite']")
    private WebElement forgotYourPasswordText;
    @FindBy(xpath = "//a[contains(text(),'← Return to login page')]")
    private WebElement returnToLoginPageText;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailBox;
    @FindBy(xpath = "//input[@id='submit']")
    private WebElement sendButton;
    @FindBy(xpath = "//li[contains(text(),'Account cannot be found, please contact your syste')]")
    private WebElement forgotPasswordErrorText;
    @FindBy(xpath = "//img[@src='https://docs.microsoft.com/en-us/azure/active-directory/develop/media/howto-add-branding-in-azure-ad-apps/ms-symbollockup_signin_dark.png']")
    private WebElement signInWithMicrosoftButton;

    public LoginPage() {
    }

    public void theUserIsOnTheHomePage() {
        driver.get(ConfigurationReader.getProperty("url"));
    }

    public void setUsernameField(String username) {
        if (username.equalsIgnoreCase("validUsername")) {
            usernameField.sendKeys(ConfigurationReader.getProperty("validUsername"));
        } else if (username.equalsIgnoreCase("invalidUsername")) {
            usernameField.sendKeys(ConfigurationReader.getProperty("invalidUsername"));
        } else {
            usernameField.sendKeys("");
        }
    }

    public void setPasswordField(String password) {
        // driver.switchTo().frame(iframe);
        if (password.equalsIgnoreCase("validPassword")) {
            passwordField.sendKeys(ConfigurationReader.getProperty("validPassword"));
        } else if (password.equalsIgnoreCase("invalidPassword")) {
            passwordField.sendKeys(ConfigurationReader.getProperty("invalidPassword"));
        } else {
            passwordField.sendKeys("");
        }
        //  driver.switchTo().defaultContent();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginVerify(String expectedResult) {
        if (expectedResult.equalsIgnoreCase("successful login")) {
            loginVerification();
        } else if (expectedResult.equalsIgnoreCase("session opening error empty")) {
            BrowserUtils.waitForVisibility(emptyLoginErrorText, 20);
            Assert.assertTrue(emptyLoginErrorText.isDisplayed());
        } else {
            BrowserUtils.waitForVisibility(loginErrorText, 20);
            Assert.assertTrue(loginErrorText.isDisplayed());
        }
    }
    private void loginVerification() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("Home/Index"));
    }

    public void clickForgotYourPassword() {
        BrowserUtils.waitForVisibility(forgotYourPasswordText,20);
        forgotYourPasswordText.click();
    }
    public void clickReturnToLoginPageText() {
        BrowserUtils.waitForVisibility(returnToLoginPageText,20);
        returnToLoginPageText.click();
    }
    public void setEmailBox(String email){
        if (email.equalsIgnoreCase("valid email")) {
            emailBox.sendKeys(Constants.VALID_EMAIL);
        }
        else if (email.equalsIgnoreCase("invalid email")) {
            emailBox.sendKeys(Constants.INVALID_EMAIL);
        }
        else{
            emailBox.sendKeys(Constants.INVALID_FORMAT_EMAIL);
    }
    }
    public void clickSendButton(){
        BrowserUtils.waitForVisibility(sendButton,20);
        sendButton.click();
    }
    public void verifyForgotPasswordErrorText(String text){
        BrowserUtils.waitForVisibility(forgotPasswordErrorText,20);
        Assert.assertTrue(forgotPasswordErrorText.getText().equalsIgnoreCase(text));
    }
    public void clickSignInWithMicrosoftButton(){
        BrowserUtils.waitForVisibility(signInWithMicrosoftButton,20);
        signInWithMicrosoftButton.click();
    }

    public void loginWith(String username) {


        usernameField.sendKeys(username);
        passwordField.sendKeys(ConfigurationReader.getProperty("flowsPassword"));
        loginButton.click();
    }
}