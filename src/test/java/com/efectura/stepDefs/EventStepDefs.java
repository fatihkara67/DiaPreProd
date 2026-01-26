package com.efectura.stepDefs;

import com.efectura.utilities.Driver;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EventStepDefs extends BaseStep {

    @When("The user fill related brand attribute")
    public void theUserFillRelatedBrandAttribute() {
        WebElement input = Driver.getDriver().findElement(By.xpath("//*[@id=\"required-attributes\"]/div[1]/div/span/span[1]/span/ul/li/input"));
        input.click();
        input.sendKeys("Tekirdağ");
        WebElement firstOption = Driver.getDriver().findElement(By.xpath("//*[@id=\"select2-attribute-5028-results\"]/li[1]"));
        firstOption.click();

    }

}
