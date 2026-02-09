package com.efectura.pages.BPM;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class Panel extends BasePage {

    @FindBy(xpath = "//tr/td[3]")
    private List<WebElement> formNames;

    @FindBy(xpath = "//td/a")
    private List<WebElement> flowStartButtons;

    @FindBy(xpath = "//select[contains(@id,'formType')]")
    private WebElement formTypeSelect;

    @FindBy(xpath = "//a[contains(@data-original-title,'Devam Etmekte')]")
    private List<WebElement> ongoingNavigateButton;

    @FindBy(xpath = "//div[contains(@class,'table-action')]/button[contains(@class, 't-preview')][1]")
    private List<WebElement> processListFlowStatusButtons;

    @FindBy(xpath = "//a[@data-original-title='Akış Ayrıntılarını Göster']")
    private List<WebElement> processListFlowDetailButtons;

    @FindBy(xpath = "//h4[contains(text(),'Akış Detayları')]")
    private WebElement processListDetailModalHeader;

    @FindBy(xpath = "//a[contains(@class,'t-preview filter-btn')]")
    private List<WebElement> actionButtons;


    public void goInFlow(String formName) {
        BrowserUtils.wait(2);
        for (int i = 0; i < formNames.size(); i++) {
            if (formNames.get(i).getText().equalsIgnoreCase(formName)) {
                BrowserUtils.wait(2);
                flowStartButtons.get(i).click();
            }
        }
//        BrowserUtils.waitForVisibility(formTypeSelect,5);
        BrowserUtils.wait(6);
    }

}
