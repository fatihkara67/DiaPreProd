package com.efectura.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class Message extends BasePage {
    public Message() {

    }

    @FindBy(xpath = "//button[@id='createItem']")
    private WebElement createItemButton;

    @FindBy(xpath = "//div[@class='info-family']/span")
    private List<WebElement> createItemFamilies;

    @FindBy(xpath = "//input[@id='inputCode' and @placeholder='EnterCode']")
    private WebElement createItemCodeInput;

    @FindBy(xpath = "//input[@id='notification-name']")
    private WebElement notificationNameInput;

    @FindBy(xpath = "//select[@id='select-provider']")
    private WebElement providerSelect;

    @FindBy(xpath = "//button[@id='nextStepItemAttr']")
    private WebElement nextButton;

    @FindBy(xpath = "//button[@id='wizard-next-btn']")
    private WebElement secondNextButton;

    @FindBy(xpath = "//button[@id='lastStepNotificationAttr']")
    private WebElement ruleNextButton;

    @FindBy(xpath = "//button[@id='last-step-preview']")
    private WebElement scheduleNextButton;

    @FindBy(xpath = "//button[@id='mailTypeNext']")
    private WebElement mailTypeNextButton;

    @FindBy(xpath = "//button[@id='wizard-publish-btn']")
    private WebElement sendButton;

    @FindBy(xpath = "//button[@id='next-step-body']")
    private WebElement bodyNextButton;

    @FindBy(xpath = "//div[@class='custom-modal-body tab-pane fade in active']/div/ul/li/a[@id='_fast-categories']")
    private WebElement messageCreateCategoryTab;

    @FindBy(xpath = "//div[@class='tree-checkbox']")
    private WebElement rootCategory;

    @FindBy(xpath = "//span[@title=' Kural Seçiniz']")
    private WebElement ruleAttributeSelect;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement ruleSelectInput;

    @FindBy(xpath = "/html/body/span/span/span[2]/ul/li/ul/li")
    private WebElement firstAttributeOption;

    @FindBy(xpath = "//*[@id=\"builder-Account_rule_0\"]/div[5]/input")
    private WebElement attributeValueInput;

    @FindBy(xpath = "//input[contains(@class,'SMS_Body')]")
    private WebElement smsBodyInput;

    @FindBy(xpath = "//input[@id='runNowCheckbox']")
    private WebElement nowScheduleOption;

    @FindBy(xpath = "//h3[contains(text(),'QuickAccess')]")
    private WebElement quickAccessText;

    @FindBy(xpath = "//div[@class='notyf__message']")
    private WebElement infoMessage;

    @FindBy(xpath = "//div[1]/div/div[3]/div/input")
    private WebElement pushDeeplinkInput;

    @FindBy(xpath = "//div[3]/div[2]/div/div[1]/div[1]/input")
    private WebElement pushTitleInput;

    @FindBy(xpath = "//div[3]/div[2]/div/div[1]/div[2]/input")
    private WebElement pushBodyInput;

    @FindBy(xpath = "//input[contains(@class,'Email_Title')]")
    private WebElement emailTitleInput;

    @FindBy(xpath = "//span[.='RichTextEditor']")
    private WebElement emailRichTextEditor;

    @FindBy(xpath = "//div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/p")
    private WebElement emailBodyInput;

    //------import------
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElement popUpOkButton;

    @FindBy(xpath = "//span[text()='Select import type']")
    private WebElement selectImportTypeElement;

    @FindBy(xpath = "//span/span/span[1]/input")
    private WebElement selectImportTypeInputBox;

    @FindBy(xpath = "//ul/li[contains(@id,'select2')]")
    private List<WebElement> filteredImportTypeOptions;

    @FindBy(id = "addcsvfile")
    private WebElement addCsvInputElement;

    @FindBy(xpath = "//button[contains(text(),'Save Changes')]")
    private WebElement saveChangesButtonInAreYouSureModal;

    @FindBy(xpath = "//span[@id='Import']")
    private WebElement importButton;

}
