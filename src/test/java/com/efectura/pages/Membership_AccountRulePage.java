package com.efectura.pages;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Driver;
import com.efectura.utilities.Pages;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.efectura.pages.MDMPages.EditItemPage.clickRuleTab2;
import static com.efectura.pages.MDMPages.EditItemPage.getStringListFromWebElementList;
import static com.efectura.utilities.BrowserUtils.getValueInInputBox;

@Getter
public class Membership_AccountRulePage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'menu-group')]")
    private List<WebElement> navBarMenuGroups;

    @FindBy(xpath = "//li[contains(@class,'menu-group')][2]/ul/li")
    private List<WebElement> mdmMenuOptions;

    @FindBy(xpath = "//li[contains(@class,'menu-group')][2]/ul/li")
    private List<WebElement> eventsMenuOptions;

    @FindBy(xpath = "//li[contains(@class,'menu-group')][2]/ul/li")
    private List<WebElement> personsMenuOptions;

    @FindBy(xpath = "//a[contains(text(),'Code')]")
    private WebElement codeFilter;
    
    @FindBy(xpath = "//input[@placeholder='Code']")
    private WebElement codeFilterInputBox;

    @FindBy(xpath = "//th")
    private WebElement overviewColumnNames;

    @FindBy(xpath = "//a[@title='Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//a[text()='Similar']")
    private WebElement similarOverviewLink;

    @FindBy(xpath = "//a[contains(@class,'showRuleTabLi')]")
    private WebElement ruleTab;

    @FindBy(xpath = "//a[contains(@class,'linkAssociation')]")
    private WebElement accountAssociateTab;

    @FindBy(xpath = "//span[@title=' Kural Seçiniz']")
    private WebElement ruleAttributeDropDown;

    @FindBy(xpath = "//span/input[@role='textbox']")
    private WebElement ruleAttributeSearchInputBox;

    @FindBy(xpath = "//div[@class='rule-value-container']/input")
    private WebElement ruleAttributeValueInputBox;

    @FindBy(xpath = "//div[@class='rule-value-container']/input")
    private List<WebElement> ruleAttributeValueInputBoxes;

    @FindBy(xpath = "//button[text()='ViewList']")
    private WebElement viewListButton;

    @FindBy(xpath = "//button[contains(.,'Calculate')]")
    private WebElement calculateButton;

    @FindBy(xpath = "//select[@id='filter-InRule']")
    private WebElement inRuleFilterSelectElement;

    @FindBy(xpath = "//td[3]/input")
    private List<WebElement> checkBoxesInViewList;

    @FindBy(xpath = "//table//tr/th[text()='Label']/ancestor::table//tbody/tr/td[count(//table//tr/th[text()='Label']/preceding-sibling::th)+1]")
    private List<WebElement> labelValuesInViewList;

    @FindBy(xpath = "//button[contains(text(),'Save Changes')]")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//button[@id='btn-set']")
    private WebElement setRulesButton;

    @FindBy(xpath = "//textarea[@id='resultIn']")
    private WebElement inListTextArea;

    @FindBy(xpath = "//textarea[@id='resultNotIn']")
    private WebElement notInListTextArea;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement continueButtonInSetRulesModal;

    @FindBy(xpath = "//input[@id='rule-name']")
    private WebElement ruleNameInputBox;

    @FindBy(xpath = "//select[@id='IsAssociatedassociationTable']")
    private WebElement associatedFilterSelectElement;

    @FindBy(xpath = "//a[contains(.,'Associated')]")
    private WebElement associatedFilter;

    @FindBy(xpath = "//li[contains(text(),'Yes')]")
    private WebElement associatedFilterYesOption;

    @FindBy(xpath = "//th[@aria-controls='DataTables_Table_0']")
    private List<WebElement> accountTabTableHeaders;

    @FindBy(xpath = "//tr[1]/td")
    private List<WebElement> firstRowElementsInTable;

    @FindBy(xpath = "//table//tr/th[text()='Label']/ancestor::table//tbody/tr/td[count(//table//tr/th[text()='Label']/preceding-sibling::th)+1]\n")
    private List<WebElement> labelValues;

    @FindBy(xpath = "//table//tr/th[text()='AssociationName']/ancestor::table//tbody/tr/td[count(//table//tr/th[text()='AssociationName']/preceding-sibling::th)+1]")
    private List<WebElement> assocNameValues;

    @FindBy(xpath = "//tr/td[1]/a")
    private List<WebElement> idValues;

    @FindBy(xpath = "//button[@id='btn-deleteAll']")
    private WebElement deleteAllRulesButton;

    @FindBy(xpath = "//button[@id='delete-confirmed']")
    private WebElement deleteButtonInDeleteConfirmModal;

    @FindBy(xpath = "//span/ul/li/ul/li[1]")
    private WebElement searchedRuleOption;

    @FindBy(xpath = "//button[@id='add-rule']")
    private WebElement addRuleButton;

    @FindBy(xpath = "//span[contains(text(),'Calculated User')]")
    private WebElement calculatedInfo;

    @FindBy(xpath = "//div[3]/div/div[1]/div[2]/label[2]")
    private WebElement globalOrButton;

    @FindBy(xpath = "//a[text()=' Id ']")
    private WebElement idFilter;

    @FindBy(xpath = "//input[@id='Id_from-associationTable']")
    private WebElement idFromInputBox;

    @FindBy(xpath = "//input[@id='Id_to-associationTable']")
    private WebElement idToInputBox;

    @FindBy(xpath = "//div[17]/div/div/div/div/div[1]/div/div[1]/div[1]/div/span[3]/div/a")
    private WebElement idUpdateButton;

    @FindBy(xpath = "//header[span[contains(text(),'Distributor Basis Code')]]/following-sibling::input")
    private WebElement distributorBasisCodeInputBox;

    @FindBy(xpath = "//header[span[contains(text(),'Contact Mobile')]]/following-sibling::input")
    private WebElement contactMobileInputBox;

    @FindBy(xpath = "//header[span[contains(text(),'Contact Email')]]/following-sibling::input")
    private WebElement contactEmailInputBox;

    @FindBy(xpath = "//a[contains(text(),'ACCOUNT_INFO')]")
    private WebElement accountInfoSection;

    @FindBy(xpath = "//body")
    private WebElement body;

    @FindBy(xpath = "//*[@id='oz-scroll']")
    private WebElement scrollUpButton;

//span[contains(text(),'Unsaved Changes')]
    @FindBy(xpath = "/html/body/div[3]/div/div[6]/div[3]/div[2]/div[3]/div/div[1]/div/button[1]")
    private WebElement unsavedChangesButton;

    @FindBy(xpath = "//a[@id='savebutton']")
    private WebElement saveButtonInChangeItemModal;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div[1]/div[4]")
    private WebElement accordionButton;

    @FindBy(xpath = "//td[text()='No matching records found']")
    private WebElement noMatchingRecordsText;

    @FindBy(xpath = "//div[@class='notyf__message']")
    private WebElement ruleSaveWarning;

    @FindBy(xpath = "//span[text()='All rules deleted and saved.']")
    private WebElement allRuleDeleteWarning;

    @FindBy(id = "_attributes")
    private WebElement attributesTab;

    @FindBy(xpath = "//a[contains(text(),'InRule')]")
    private WebElement inRuleFilter;

    @FindBy(xpath = "//span[@id='arrowbtn-down']")
    private WebElement scrollRightButton;

    @FindBy(xpath = "//input[@id='rule-assoc-name']")
    private WebElement ruleAssociationNameInputBox;

    @FindBy(xpath = "//input[@id='rule-random-assoc']")
    private WebElement ruleRandomAssociationNameCheckBox;

    @FindBy(xpath = "//span[contains(text(),'ClearAll')]")
    private List<WebElement> clearAllButtonsInRuleTab;

    @FindBy(xpath = "//span[contains(text(),'AddFromList')]")
    private List<WebElement> addFromListButtonsInListAndNotInList;

    @FindBy(xpath = "//ul[contains(@class,'menu-notin')]/li/a")
    private List<WebElement> notInListOptions;

    @FindBy(xpath = "//ul[contains(@class,'menu-in')]/li/a")
    private List<WebElement> inListOptions;

    @FindBy(xpath = "//div[@class='notyf__message']")
    private WebElement infoMessage;




    public void goToItemOverview(String itemName) {
        for (WebElement menuGroup : navBarMenuGroups) {
            if (menuGroup.getText().equals("MDM")) {
                BrowserUtils.hoverOver(menuGroup);
                for (WebElement mdmOption : mdmMenuOptions) {
                    if (mdmOption.getText().equals(itemName)) {
                        BrowserUtils.hoverOver(mdmOption);
                        mdmOption.click();
                    }
                }
            }
            else if (menuGroup.getText().equals("Events")) {
                BrowserUtils.hoverOver(menuGroup);
                for (WebElement mdmOption : mdmMenuOptions) {
                    if (mdmOption.getText().equals(itemName)) {
                        BrowserUtils.hoverOver(mdmOption);
                        mdmOption.click();
                    }
                }
            }
            else if (menuGroup.getText().equals("Persons")) {
                BrowserUtils.hoverOver(menuGroup);
                for (WebElement mdmOption : mdmMenuOptions) {
                    if (mdmOption.getText().equals(itemName)) {
                        BrowserUtils.hoverOver(mdmOption);
                        mdmOption.click();
                    }
                }
            }
        }
    }

    public void goToItemEditPage(String itemId) {
        BrowserUtils.wait(3);
        Driver.getDriver().get(ConfigurationReader.getProperty("editItemLinkWithoutId") + ConfigurationReader.getProperty(itemId));

        BrowserUtils.wait(5);
    }

    public void goToSimilarOverview() {
        BrowserUtils.hoverOver(navBarMenuGroups.get(1));
        BrowserUtils.hoverOver(eventsMenuOptions.get(1));
//        BrowserUtils.waitForVisibility(similarOverviewLink,5);
        similarOverviewLink.click();
    }



    public void setARule() {
        BrowserUtils.waitForVisibility(ruleAttributeDropDown,10);
        ruleAttributeDropDown.click();
        BrowserUtils.wait(2);
        ruleAttributeSearchInputBox.sendKeys("First Name");
        driver.findElement(By.xpath("//li[text()='First name']")).click();
        ruleAttributeValueInputBox.sendKeys("ygcsl");
    }

    public void clickViewListButton() {
        viewListButton.click();
        BrowserUtils.wait(10);
    }

    String labelValueThatIsSetInRule;
    public void setAnItemInRuleWhichIsNotInRule() {
        BrowserUtils.wait(4);
        inRuleFilter.click();
        BrowserUtils.selectDropdownOptionByVisibleText(inRuleFilterSelectElement, "No");
        BrowserUtils.wait(2);
        inRuleFilter.click();
        checkBoxesInViewList.get(0).click();
        labelValueThatIsSetInRule = labelValuesInViewList.get(0).getText();
        saveChangesButton.click();
    }

    public void clickSetRulesButton() {
        setRulesButton.click();
        ruleNameInputBox.sendKeys("test automation");
        continueButtonInSetRulesModal.click();
        BrowserUtils.wait(2);
    }

    public void verifyTheItemThatIsSetInRuleIsAppearInInList() {
        BrowserUtils.wait(2);
        Assert.assertTrue(getValueInInputBox(inListTextArea).contains(labelValueThatIsSetInRule));
        BrowserUtils.wait(10);
    }

    public void verifyTheItemThatIsSetInRuleIsAssociated(String tabName) {
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//a[contains(text(),'" + tabName + "')]")).click();
        BrowserUtils.wait(6);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[contains(text(),'" + tabName + "')]")).click();
        BrowserUtils.wait(5);
        associatedFilter.click();
        associatedFilterYesOption.click();
        BrowserUtils.wait(3);
        //Assert.assertEquals(labelValueThatIsSetInRule, labelValues.get(0).getText());
        Assert.assertTrue(labelValues.stream().anyMatch(element -> element.getText().contains(labelValueThatIsSetInRule)));
        BrowserUtils.wait(2);
    }

    public void tearDownAllChanges() {
        BrowserUtils.wait(3);
        BrowserUtils.waitForVisibility(deleteAllRulesButton,10);
        BrowserUtils.waitForClickability(deleteAllRulesButton,10);
        deleteAllRulesButton.click();
        BrowserUtils.wait(2);
        deleteButtonInDeleteConfirmModal.click();
        BrowserUtils.wait(4);
//        BrowserUtils.waitForVisibility(allRuleDeleteWarning,20);
    }

    String numberOfCalculatedBeforeEditItem;
    public void setTwoRuleWithOrOperator() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForVisibility(ruleAttributeDropDown,10);
        ruleAttributeDropDown.click();
        BrowserUtils.wait(2);
        ruleAttributeSearchInputBox.sendKeys("Distributor Basis Code");
        searchedRuleOption.click();
        ruleAttributeValueInputBox.sendKeys("TestAutomation");
        addRuleButton.click();
        globalOrButton.click();
        ruleAttributeDropDown.click();
        BrowserUtils.wait(2);
        ruleAttributeSearchInputBox.sendKeys("Distributor Basis Code");
        searchedRuleOption.click();
        BrowserUtils.wait(1);
        ruleAttributeValueInputBoxes.get(1).sendKeys("Automation");
    }


    String idOfEditedItem = "293705";
    public void editAnAccountToMeetTheRules(String attributeValueToChange) {
        driver.get(ConfigurationReader.getProperty("editItemLinkWithoutId") + idOfEditedItem);
        attributesTab.click();
        accountInfoSection.click();
        BrowserUtils.wait(2);
        scrollBy(0,distributorBasisCodeInputBox.getLocation().getY());
        String currentDistributorBasisCodeInputBoxValue = getValueInInputBox(distributorBasisCodeInputBox);
        if (!currentDistributorBasisCodeInputBoxValue.equals(attributeValueToChange)) {
            distributorBasisCodeInputBox.clear();
            distributorBasisCodeInputBox.sendKeys(attributeValueToChange);
            scrollUpButton.click();
            BrowserUtils.wait(3);
            unsavedChangesButton.click();
            BrowserUtils.wait(2);
            saveButtonInChangeItemModal.click();
        }
        BrowserUtils.wait(4);
    }

    public static void scrollBy(int xOffset, int yOffset) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ")");
    }

    public void verifyEditedItemIsAssociated(String tabName, String itemIdForRule) {
        driver.get(ConfigurationReader.getProperty("editItemLinkWithoutId") + ConfigurationReader.getProperty(itemIdForRule));
        BrowserUtils.wait(15);
        driver.navigate().refresh();
        BrowserUtils.wait(16);
        driver.findElement(By.xpath("//a[contains(text(),'" + tabName + "')]")).click();
        BrowserUtils.waitForVisibility(associatedFilter,30);
        associatedFilter.click();
        associatedFilterYesOption.click();
        BrowserUtils.wait(6);
        Assert.assertEquals(idOfEditedItem, idValues.get(0).getText());
    }

    public void clickCalculateButton() {
        calculateButton.click();
        BrowserUtils.waitForVisibility(calculatedInfo, 8);
        numberOfCalculatedBeforeEditItem = calculatedInfo.getText().split(" ")[0];
    }

    public void deleteItemChanges() {
        Driver.getDriver().get(ConfigurationReader.getProperty("editItemLinkWithoutId") + idOfEditedItem);
        accountInfoSection.click();
        scrollBy(0,distributorBasisCodeInputBox.getLocation().getY());
        distributorBasisCodeInputBox.clear();
        distributorBasisCodeInputBox.sendKeys("TestAutomation");
    }
    public void verifyAssociationOfTheItemRemoved(String tabName, String itemIdForRule) {
        BrowserUtils.wait(10);
        driver.get(ConfigurationReader.getProperty("editItemLinkWithoutId") + ConfigurationReader.getProperty(itemIdForRule));
        BrowserUtils.wait(17);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[contains(text(),'" + tabName + "')]")).click();
        BrowserUtils.wait(9);
        BrowserUtils.waitForVisibility(associatedFilter,30);
        associatedFilter.click();
        associatedFilterYesOption.click();
        Assert.assertTrue(noMatchingRecordsText.isDisplayed());
    }

    public void waitForRemovingOfAssociation() {
        BrowserUtils.waitForVisibility(accountAssociateTab,8);
        Driver.getDriver().navigate().refresh();
        accountAssociateTab.click();
        BrowserUtils.waitForVisibility(associatedFilter,30);
        associatedFilter.click();
        associatedFilterYesOption.click();
        int n = 0;
        while (!noMatchingRecordsText.isDisplayed() || n != 10) {
            Driver.getDriver().navigate().refresh();
            BrowserUtils.waitForVisibility(accountAssociateTab,8);
            accountAssociateTab.click();
            BrowserUtils.waitForVisibility(associatedFilter,10);
            associatedFilter.click();
            associatedFilterYesOption.click();
            n++;
        }
    }

    String labelValueThatIsSetOutRule;
    public void setItemOutRuleWhichIsInRule() {
        BrowserUtils.wait(2);
        checkBoxesInViewList.get(0).click();
        labelValueThatIsSetOutRule = labelValuesInViewList.get(0).getText();
        BrowserUtils.wait(3);
        saveChangesButton.click();
    }

    public void verifyTheItemThatIsSetOutRuleIsAppearInInList() {
        BrowserUtils.wait(2);
        System.out.println("AAAAAAAAAA:  " + labelValueThatIsSetOutRule);
        System.out.println("BBBBBBBBBB:  " + getValueInInputBox(notInListTextArea));
        Assert.assertTrue(getValueInInputBox(notInListTextArea).contains(labelValueThatIsSetOutRule));
    }

    public void verifyItemThatIsSetOutRuleNotAssociated(String tabName, String itemIdForRule) {
        Driver.getDriver().get(ConfigurationReader.getProperty("editItemLinkWithoutId") + ConfigurationReader.getProperty(itemIdForRule));
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//a[contains(text(),'" + tabName + "')]")).click();
        associatedFilter.click();
        associatedFilterYesOption.click();
        BrowserUtils.wait(1);
        Assert.assertTrue(BrowserUtils.isElementDisplayed(noMatchingRecordsText));
    }

    String contactMobileValue = "411339174643";
    String contactEmailValue = "1336024";
    public void setTwoDifferentRuleWithOr(Pages pages) {
        pages.editItemPage().closeShowcase();
//        BrowserUtils.adjustScreenSize(70,driver);
        BrowserUtils.waitForVisibility(ruleAttributeDropDown,10);
        BrowserUtils.wait(2);
        ruleAttributeDropDown.click();
        BrowserUtils.wait(2);
        ruleAttributeSearchInputBox.sendKeys("Track Kod");
        searchedRuleOption.click();
        ruleAttributeValueInputBox.sendKeys(contactMobileValue);
        BrowserUtils.scrollToRightEnd(driver);
        BrowserUtils.wait(1);
        addRuleButton.click();
        BrowserUtils.wait(2);
        globalOrButton.click();
        ruleAttributeDropDown.click();
        BrowserUtils.wait(2);
        ruleAttributeSearchInputBox.sendKeys("Track Kod");
        searchedRuleOption.click();
        BrowserUtils.wait(1);
        ruleAttributeValueInputBoxes.get(1).sendKeys(contactEmailValue);
    }

    public void verifyDetailInfoForRuleOfOr(List<String> ids) {

//        List<String> idValuesAsString = getStringListFromWebElementList(ids);
        for (String id : ids) {
            Driver.getDriver().get(ConfigurationReader.getProperty("editItemLinkWithoutId") + id);
//            BrowserUtils.wait(3);
//            accountInfoSection.click();
            BrowserUtils.wait(2);

            WebElement attribute = driver.findElement(By.xpath(
                    "//span[normalize-space()='Track Kod']/ancestor::header/following-sibling::input"
            ));

            String trackKod = getValueInInputBox(attribute);
//            String actualContactMobile = getValueInInputBox(contactMobileInputBox);
            Assert.assertTrue(contactEmailValue.equals(trackKod) || contactMobileValue.equals(trackKod));
        }
    }

    public void verifyDetailInfoOfAssociatedItemsForOr(String tabName) {
        verifyDetailInfoForRuleOfOr(getStringListFromWebElementList(idValues));
    }

    public void setTwoDifferentRuleWithAnd() {
        BrowserUtils.waitForVisibility(ruleAttributeDropDown,10);
        BrowserUtils.wait(2);
        ruleAttributeDropDown.click();
        BrowserUtils.wait(2);
        ruleAttributeSearchInputBox.sendKeys("Track Kod");
        searchedRuleOption.click();
        ruleAttributeValueInputBox.sendKeys(contactEmailValue);
        BrowserUtils.wait(1);
        addRuleButton.click();
        BrowserUtils.wait(1);
        ruleAttributeDropDown.click();
        BrowserUtils.wait(2);
        ruleAttributeSearchInputBox.sendKeys("Vergi Dairesi Adı");
        searchedRuleOption.click();
        BrowserUtils.wait(1);
        ruleAttributeValueInputBoxes.get(1).sendKeys("3C62BA9A-2");



    }

//    public void verifyDetailInfoForRuleOfAnd(List<String> ids) {
//        for (String id : ids) {
//            Driver.getDriver().get(ConfigurationReader.getProperty("editItemLinkWithoutId") + id);
//            BrowserUtils.wait(3);
//            accountInfoSection.click();
//            String actualContactEmail = getValueInInputBox(contactEmailInputBox);
//            String actualContactMobile = getValueInInputBox(contactMobileInputBox);
//            Assert.assertTrue(contactEmailValue.equals(actualContactEmail) && contactMobileValue.equals(actualContactMobile));
//        }
//    }

    public void verifyDetailInfoOfAssociatedItemsForAnd() {
        verifyDetailInfoForRuleOfAnd(getStringListFromWebElementList(idValues));
    }

    public void deleteAllRulesIfAnyExists() {
        BrowserUtils.wait(6);
        if (deleteAllRulesButton.isEnabled()) {
            deleteAllRulesButton.click();
            BrowserUtils.wait(2);
            deleteButtonInDeleteConfirmModal.click();
            BrowserUtils.wait(1);

            BrowserUtils.wait(1);
            BrowserUtils.waitForVisibility(infoMessage,18);
            Assert.assertEquals("Tüm kurallar silindi ve kaydedildi.", infoMessage.getText());

            driver.navigate().refresh();
            BrowserUtils.wait(1);

        }


    }

    public void clickSetRulesButtonWithAssociationName(String assocName) {
        setRulesButton.click();
        ruleAssociationNameInputBox.sendKeys(assocName);
        continueButtonInSetRulesModal.click();
        BrowserUtils.wait(1);
        BrowserUtils.waitForVisibility(ruleSaveWarning,18);
        BrowserUtils.wait(5);
    }

    public void verifyAssociatedItemHasAssociationName(String expectedAssocName) {
        BrowserUtils.wait(5);
        for (WebElement assocNameValue : assocNameValues) {
            Assert.assertEquals(expectedAssocName,assocNameValue.getText());
        }
    }

    public void clickSetRulesButtonWithRandomAssociationName() {
        setRulesButton.click();
        BrowserUtils.wait(1);
        ruleRandomAssociationNameCheckBox.click();
        continueButtonInSetRulesModal.click();
        BrowserUtils.wait(1);
        BrowserUtils.waitForVisibility(ruleSaveWarning,18);
        BrowserUtils.wait(5);
    }

    public void clickClearAllButton(String ruleListType) {
        if (ruleListType.equals("inList")) {
            clearAllButtonsInRuleTab.get(0).click();
        } else {
            clearAllButtonsInRuleTab.get(1).click();
        }
    }

    public void verifyTheItemThatIsSetInRuleIsNotAppearInInList() {
        Assert.assertFalse(getValueInInputBox(inListTextArea).contains(labelValueThatIsSetInRule));
    }

    public void verifyTheItemThatIsSetOutRuleIsNotAppearInInList() {
        BrowserUtils.wait(2);
        Assert.assertFalse(getValueInInputBox(notInListTextArea).contains(labelValueThatIsSetOutRule));
    }


    public void takeValueOfItemInItemOverview(String header, String inOrNotInList) {
        if (inOrNotInList.equalsIgnoreCase("inList")) {
            labelValueThatIsSetInRule = getColumnData(itemOverviewTable,header).get(0);
        } else if (inOrNotInList.equalsIgnoreCase("notInList")) {
            labelValueThatIsSetOutRule = getColumnData(itemOverviewTable,header).get(0);
        }
    }

    public void selectListIn(String listName, String area) {
        if (area.equals("InList")) {
            addFromListButtonsInListAndNotInList.get(0).click();
            BrowserUtils.wait(1);
            inListOptions.stream()
                    .filter(listOption -> listOption.getText().equals(listName))
                    .findFirst()
                    .ifPresent(WebElement::click);

        } else if (area.equals("NotInList")) {
            addFromListButtonsInListAndNotInList.get(1).click();
            notInListOptions.stream()
                    .filter(listOption -> listOption.getText().equals(listName))
                    .findFirst()
                    .ifPresent(WebElement::click);
        }

    }


//    @FindBy(xpath = "//tr/td[1]/a")
//    private List<WebElement> idValues;
//
//    @FindBy(xpath = "//a[contains(text(),'ACCOUNT_CONTACT')]")
//    private WebElement accountContactTab;
//
//    @FindBy(xpath = "//a[contains(.,'Associated')]")
//    private WebElement associatedFilter;
//
//    @FindBy(xpath = "//li[contains(text(),'Yes')]")
//    private WebElement associatedFilterYesOption;
//
//    @FindBy(xpath = "//a[contains(text(),'ACCOUNT_INFO')]")
//    private WebElement accountInfoSection;
//
//    @FindBy(xpath = "//header[span[contains(text(),'Contact Mobile')]]/following-sibling::input")
//    private WebElement contactMobileInputBox;
//
//    @FindBy(xpath = "//header[span[contains(text(),'Contact Email')]]/following-sibling::input")
//    private WebElement contactEmailInputBox;


//    String contactMobileValue = "5461146716";
//    String contactEmailValue = "rule@rule.com";

//    public void verifyDetailInfoForRuleOfOr(List<String> ids) {
////        List<String> idValuesAsString = getStringListFromWebElementList(ids);
//        for (String id : ids) {
//            Driver.getDriver().get(ConfigurationReader.getProperty("editItemLinkWithoutId") + id);
//            BrowserUtils.wait(3);
//            accountInfoSection.click();
//            BrowserUtils.wait(2);
//            String actualContactEmail = getValueInInputBox(contactEmailInputBox);
//            String actualContactMobile = getValueInInputBox(contactMobileInputBox);
//            Assert.assertTrue(contactEmailValue.equals(actualContactEmail) || contactMobileValue.equals(actualContactMobile));
//        }
//    }

    // you can use selectFilter as IsAssociated, Family, ItemStatuses in feature file
    public void selectOptionInSelectFilter(String selectOption, String selectFilter) {

        WebElement selectElement = driver.findElement(By.xpath("//select[contains(@id,'-" + selectFilter + "')]"));
        BrowserUtils.selectDropdownOptionByVisibleText(selectElement,selectOption);
        BrowserUtils.wait(3);
    }

    @FindBy(xpath = "//ul[@class='nav nav-tabs current_nav_tabs']//li//a")
    private List<WebElement> editItemTabs;

    public void goToItemsToVerifyDetailInfoWithTwoStepForOr(String tabName) {
        List<String> contactIds = getStringListFromWebElementList(idValues);
        List<String> accountIds = new ArrayList<>();

        for (String contactId : contactIds) {
            driver.get(ConfigurationReader.getProperty("editItemLinkWithoutId") + contactId);
//            driver.findElement(By.xpath("//a[contains(text(),'" + tabName + "')]")).click();

            editItemTabs.stream()
                    .filter(e -> e.getText().trim().equals(tabName))
                    .findFirst()
                    .ifPresent(WebElement::click);

            BrowserUtils.wait(4);


            BrowserUtils.adjustScreenSize(70, Driver.getDriver());
            selectOptionInSelectFilter("Evet","IsAssociated");
            BrowserUtils.wait(5);
//            accountIds.add(idValues.get(0).getText());
            accountIds.add(getColumnData(driver.findElement(By.id("association-table")),"Öğe Kimliği").get(0));

//            for (String e : getColumnData(driver.findElement(By.id("association-table")),"Id")) {
//                accountIds
//            }


//            associatedFilter.click();
//            associatedFilterYesOption.click();
//            BrowserUtils.wait(1);
//            accountIds.add(idValues.get(0).getText());
        }
        System.out.println(accountIds);
        verifyDetailInfoForRuleOfOr(accountIds);
    }



    public void verifyDetailInfoForRuleOfAnd(List<String> ids) {
        for (String id : ids) {
            Driver.getDriver().get(ConfigurationReader.getProperty("editItemLinkWithoutId") + id);
            BrowserUtils.wait(3);

            WebElement attribute = driver.findElement(By.xpath(
                    "//span[normalize-space()='Track Kod']/ancestor::header/following-sibling::input"
            ));

            String trackKod = getValueInInputBox(attribute);


            WebElement attribute2 = driver.findElement(By.xpath(
                    "//span[normalize-space()='Vergi Dairesi Adı']/ancestor::header/following-sibling::input"
            ));

            String vergiNo = getValueInInputBox(attribute2);

            Assert.assertTrue("3C62BA9A-2".equals(vergiNo) && contactEmailValue.equals(trackKod));
        }
    }

    public void goToItemsToVerifyDetailInfoWithTwoStepForAnd(String tabName) {
        List<String> contactIds = getStringListFromWebElementList(idValues);
        List<String> accountIds = new ArrayList<>();

        for (String contactId : contactIds) {
            driver.get(ConfigurationReader.getProperty("editItemLinkWithoutId") + contactId);

            editItemTabs.stream()
                    .filter(e -> e.getText().trim().equals(tabName))
                    .findFirst()
                    .ifPresent(WebElement::click);

            BrowserUtils.wait(4);

            BrowserUtils.adjustScreenSize(70, Driver.getDriver());
            selectOptionInSelectFilter("Evet","IsAssociated");
            BrowserUtils.wait(5);
            accountIds.add(getColumnData(driver.findElement(By.id("association-table")),"Öğe Kimliği").get(0));

        }
        verifyDetailInfoForRuleOfAnd(accountIds);
    }

    String itemIdForAssociationForContact = "7";
    String itemIdForAssociationForUser = "292374";
    public void verifyEditedItemIsAssociatedWithTwoStep(String tabName, String itemIdForRule, String itemIdForAssociation) {
        driver.get(ConfigurationReader.getProperty("editItemLinkWithoutId") + ConfigurationReader.getProperty(itemIdForRule));
        driver.navigate().refresh();
        BrowserUtils.wait(17);
        driver.navigate().refresh();
        BrowserUtils.wait(15);
        driver.findElement(By.xpath("//a[contains(text(),'" + tabName + "')]")).click();
        BrowserUtils.waitForVisibility(associatedFilter,30);
        associatedFilter.click();
        associatedFilterYesOption.click();
        BrowserUtils.wait(5);
        Assert.assertEquals(ConfigurationReader.getProperty(itemIdForAssociation), idValues.get(0).getText());
    }

}
