package com.efectura.pages.MDMPages;

import com.efectura.pages.BasePage;
import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ItemOverviewPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'list-header all')]")
    private WebElement allListsAccordion;

    @FindBy(xpath = "//li[@class='list-item']/p")
    private List<WebElement> avaliableLists;

    @FindBy(xpath = "//ul[@class='lists-name']/li/p")
    private List<WebElement> listOptions;

    @FindBy(xpath = "//div[contains(@class,'category-accordion')]")
    private WebElement overviewSideAccordion;

    @FindBy(xpath = "//thead/tr[2]/th[position()=count(//thead/tr[1]/th[contains(text(), 'Code')]/preceding-sibling::th) + 1]/input")
    private WebElement itemOverviewCodeFilterInputBox;

    @FindBy(xpath = "//span[@id='refresh']")
    private WebElement itemOverviewRefreshButton;

    @FindBy(xpath = "//a[@title='Reset Filters SB']//i[@class='fa fa-undo']")
    private WebElement basicFilterResetBtn;

    @FindBy(xpath = "//select[@id='categories']")
    private WebElement categorySelect;

    @FindBy(xpath = "//button[@id='configure-columns']")
    private WebElement configureColumnsButton;

    @FindBy(xpath = "//button[@id='cancelColumn']")
    private WebElement columnsCancelButton;

    @FindBy(xpath = "//button[@id='EfSaveColumns']")
    private WebElement columnsSaveButton;

    @FindBy(xpath = "//ul[@id='sortable2']/li")
    private List<WebElement> alreadySelectedColumns;

    @FindBy(xpath = "//ul[@id='sortable1']/li")
    private List<WebElement> toBeSelectedColumns;

    @FindBy(xpath = "//ul[@id='sortable1']")
    private WebElement toBeSelectedArea;

    @FindBy(xpath = "//a[@id='_fast-categories']")
    private WebElement categoriesTabInCreateNewModal;

    @FindBy(id = "createItem")
    private WebElement createNewItemButton;

    @FindBy(xpath = "//button[@id='saveItem']")
    private WebElement createButtonInCreateModal;

    @FindBy(xpath = "//div[contains(@class,'modalFooter')]/button[contains(text(),'Cancel')]")
    private WebElement cancelButtonInCreateModal;

    @FindBy(xpath = "//select[@id='items-ItemStatuses']")
    private WebElement itemStatusSelect;

    @FindBy(xpath = "//button[contains(@id,'cancelPopup')]")
    private WebElement cancelBtnInDeleteModal;

    @FindBy(xpath = "//a[@id='createNewList']")
    private WebElement createListButton;

    @FindBy(xpath = "//div[@id='create-new-list']/div/div/div/button[text()='Cancel']")
    private WebElement createNewListCancelButton;

    @FindBy(xpath = "//div[contains(@class,'modal-header')]/h4[normalize-space()='New List']")
    private WebElement newListPopup;

    @FindBy(xpath = "//input[@id='input-list']")
    private WebElement listNameInputBox;

    @FindBy(xpath = "//button[@id='create-list']")
    private WebElement listCreateButton;

    @FindBy(xpath = "//div[contains(@class,'accordion-container')]")
    private WebElement accordionContainer;

    @FindBy(xpath = "//button[@id='export-dropdown']")
    private WebElement overviewExportDropdownBtn;

    @FindBy(xpath = "//button[@id='importUser']")
    private WebElement itemImportButton;

    @FindBy(xpath = "//input[@id='file-import']")
    private WebElement itemImportInput;

    @FindBy(xpath = "//button[@id='import-step-two']")
    private WebElement itemImportStep2NextButton;

    @FindBy(xpath = "//button[@id='import-step-three']")
    private WebElement itemImportStep3NextButton;

    @FindBy(xpath = "//button[@id='open-match-columns']")
    private WebElement matchColumnsButton;

    @FindBy(xpath = "//button[@id='save-match-columns']")
    private WebElement saveMatchColumnsButton;

    @FindBy(xpath = "//button[@id='apply-details-button']")
    private WebElement applyImportValidationButton;

    @FindBy(xpath = "//button[@id='start-import']")
    private WebElement lastImportButton;

    @FindBy(xpath = "//button[@id='createItem']")
    private WebElement createItemButton;

    @FindBy(xpath = "//div/div/div[3]/div[2]/div/div[2]")
    private List<WebElement> createItemFamilies;

    @FindBy(xpath = "//button[@id='nextStepItemAttr']")
    private WebElement nextButton;

    @FindBy(xpath = "//button[@id='next-step-segment-build']")
    private WebElement nextToRuleButton;

    @FindBy(xpath = "//button[@id='last-step-preview']")
    private WebElement nextToPreviewButton;

    @FindBy(xpath = "//button[@id='create-segment']")
    private WebElement createItemButtonInModal;

    @FindBy(xpath = "//a[@id='_fast-categories']")
    private WebElement createItemCategoryTab;

    @FindBy(xpath = "//a[text()='Kurumsal İletişim ']")
    private WebElement kurumsalCategory;

    @FindBy(xpath = "//*[@id=\"builder-Account_rule_0\"]/div[3]/span/span[1]/span/span[2]")
    private WebElement ruleSelectArrow;

    @FindBy(xpath = "//span[1]/input")
    private WebElement ruleAttributeInput;

    @FindBy(xpath = "/html/body/span/span/span[2]/ul/li[1]/ul/li")
    private WebElement ruleOption;

    @FindBy(xpath = "//*[@id=\"builder-Account_rule_0\"]/div[5]/input")
    private WebElement ruleValueInput;

    @FindBy(xpath = "//button[@title='Hesapla']")
    private WebElement calculateButton;

    @FindBy(xpath = "//div[@id='calculate-process']")
    private WebElement calculateCountInfo;

    @FindBy(xpath = "//button[@id='edit-import']")
    private WebElement importEditButton;

    @FindBy(xpath = "//*[@id=\"import-edit-modal\"]/div/div/div[3]/button[1]")
    private WebElement editImportModalCancelButton;

    @FindBy(xpath = "//*[@id=\"import-preview-modal\"]/div/div/div[3]/button[1]")
    private WebElement importPreviewModalCancel;

    @FindBy(xpath = "//li[contains(@class,'is-selected')]/div[2]")
    private List<WebElement> selectedExportOptions;


    public ItemOverviewPage() {
    }


    public void goToItemOverviewPage(String item) {
        driver.get(ConfigurationReader.getProperty("itemLinkWithoutItemName") + item);
    }

    public void selectList(String listName) {
        if (allListsAccordion.getAttribute("class").contains("active")) {
            allListsAccordion.click();
        }

        avaliableLists.stream()
                .filter(element -> element.getText().equals(listName))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void openSideAccordionInOverview() {
        boolean isSidebarOpen = BrowserUtils.isElementDisplayed(accordionContainer);
        if (!isSidebarOpen) {
            overviewSideAccordion.click();
        } else {
            System.out.println("Accordion butonuna tıklanmadı!!!");
        }
    }

    public void closeSideAccordionInOverview() {
        boolean isSidebarOpen = BrowserUtils.isElementDisplayed(accordionContainer);
        if (isSidebarOpen) {
            overviewSideAccordion.click();
        }
    }

    public void clickDeleteBtnOfList(String listName) {
        WebElement target = avaliableLists.stream().filter(e -> listName.equals(e.getText()))
                .findFirst().orElse(null);
        String locate = "//li[p[text()='" +listName + "']]//i[@data-original-title='DeleteList']";
        WebElement deleteBtn = Driver.getDriver().findElement(By.xpath(locate));
        BrowserUtils.hoverOver(target);
        deleteBtn.click();
    }
}
