package com.efectura.stepDefs;

import com.efectura.utilities.BrowserConsoleUtils;
import com.efectura.utilities.ConfigurationReader;
import com.efectura.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setup(Scenario scenario) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        logger.info(":::: Starting test automation ::::");
        logger.info("Browser type :: {}", ConfigurationReader.getProperty("browser"));
        logger.info("Environment :: {}", ConfigurationReader.getProperty("url"));
        logger.info("Test scenario :: {}", scenario.getName());
        Driver.getDriver().manage().window().setSize(new Dimension(1920, 1080));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @After
    public static void tearDown(Scenario scenario) {

//        try {
//            BrowserConsoleUtils.assertNoConsoleErrors(Driver.getDriver());
//        } catch (AssertionError e) {
//            // Senaryoya log düşsün diye
//            scenario.log(e.getMessage());
//            throw e; // test FAIL
//        }

        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
            logger.error("Test scenario :: {} :: Failed", scenario.getName());
        } else {
            logger.info("Test scenario :: {} :: Passed", scenario.getName());
        }
        Driver.closeDriver();

        try {
           Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}