package com.efectura.pages;

import com.efectura.utilities.BrowserUtils;
import com.efectura.utilities.Driver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class GeneralPage extends BasePage {

    @FindBy(xpath = "//div[@class='notyf__message']")
    private WebElement generalWarningElement;

    @FindBy(xpath = "//select[@id='chooseFamilies']")
    private WebElement familySelectInCreateModal;

    @FindBy(xpath = "//tbody/tr/td[@class='dataTables_empty']")
    private WebElement emptyDataTableInfo;

    @FindBy(xpath = "//a[contains(@class,'t-edit')]")
    private WebElement editBtnInTable;

    @FindBy(xpath = "//a[contains(@class,'danger-btn')]")
    private WebElement deleteBtnInTable;

    @FindBy(xpath = "//select[contains(@id,'-ItemStatuses')]")
    private WebElement tableItemStatusSelect;

    @FindBy(xpath = "//select[contains(@id,'-Family')]")
    private WebElement tableFamilySelect;

    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement changeSaveCommentTextArea;


    // you can use selectFilter as IsAssociated, Family, ItemStatuses in feature file
    public void selectOptionInSelectFilter(String selectOption, String selectFilter) {

        WebElement selectElement = driver.findElement(By.xpath("//select[contains(@id,'-" + selectFilter + "')]"));
        BrowserUtils.selectDropdownOptionByVisibleText(selectElement,selectOption);

    }

    public void useTextFilter(String value, String columnName) {
        //thead/tr[1]/th[normalize-space()='Address']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='Address']/preceding-sibling::th)+1]//input
        String locate = "//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/following::tr[1]/th[position()=count(//thead/tr[1]/th[normalize-space()='" + columnName +
                "']/preceding-sibling::th)+1]//input";

        WebElement filterInput = Driver.getDriver().findElement(By.xpath(locate));
        filterInput.sendKeys(value + Keys.ENTER);

    }



}
