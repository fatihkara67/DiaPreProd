package com.efectura.pages.MDMPages.CampaignManagement;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CampaignHomePage extends BasePage {

    @FindBy(xpath = "//tr//td[2]")
    private WebElement verifyCampaignCodeFilter;

    @FindBy(xpath = "//td[normalize-space()='TESTSETSET123123']")
    private WebElement deletingObject;

    @FindBy(xpath = "//tr//td[3]")
    private List<WebElement> labelValues;

    @FindBy(xpath = "//tr//td[2]")
    private List<WebElement> codeValues;

    @FindBy(xpath = "//span/ul/li[@role='treeitem']")
    private List<WebElement> itemStatusFilterOptions;

    @FindBy(xpath = "//div[@id='notifyjs-container-top-right']/div/span")
    private WebElement warning;

    @FindBy(xpath = "//ul/li[@class='list-item']/p")
    private List<WebElement> listItemNames;

    @FindBy(xpath = "//div/i[@title='DeleteList']")
    private List<WebElement> listDeleteButtons;

    @FindBy(xpath = "//*[@id=\"ok1\"]/div[2]/ul[2]/li[1]/div/i[3]")
    private WebElement otomasyonListDelete;


    public CampaignHomePage() {
    }

    public void verifyCampaignCodeFilter(String code) {
        BrowserUtils.wait(10);
        assertTrue(verifyCampaignCodeFilter.getText().equalsIgnoreCase(code));
    }

    public void verifyDeletingObject(String code) {
        for (WebElement codeValue : codeValues) {
            assertTrue(codeValue.getText().equalsIgnoreCase(code));
        }
    }

    public void verifyCodeFilterFunctionalityWithPartialCode(String partialCode) {
        Assert.assertTrue(verifyCampaignCodeFilter.getText().toLowerCase().contains(partialCode.toLowerCase()));
    }

    public void verifyLabelFilterFunctionalityWithPartialLabel(String partialLabel) {
        for (WebElement labelValue : labelValues) {
            Assert.assertTrue(labelValue.getText().toLowerCase().contains(partialLabel.toLowerCase()));
        }
    }

    public void selectOptionOfItemStatus(String itemStatus) {
        for (WebElement itemStatusOption : itemStatusFilterOptions) {
            if (itemStatusOption.getText().equalsIgnoreCase(itemStatus)) {
                itemStatusOption.click();
                break;
            }
        }
    }

    public void verifyWarningIsDisplayed(String expectedWarning) {
        BrowserUtils.waitForVisibility(warning,3);
        System.out.println("AAAAAAAAAAAAAAAA" + warning.getText());
        Assert.assertEquals(warning.getText(), expectedWarning);
    }

    public void clickDeleteButtonOfList(String listName) {
        BrowserUtils.wait(3);
        for (int i = 0; i < listItemNames.size(); i++) {
            if(listItemNames.get(i).getText().equalsIgnoreCase(listName)) {
                BrowserUtils.hoverOver(listItemNames.get(i));
                BrowserUtils.hoverOver(listDeleteButtons.get(i));
                BrowserUtils.wait(3);
                listDeleteButtons.get(i).click();

            }
        }
    }
}
