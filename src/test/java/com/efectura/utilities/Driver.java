package com.efectura.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {}

    public synchronized static WebDriver getDriver() {

        if (driverPool.get() == null) {

            String browser = ConfigurationReader.getProperty("browser").toLowerCase();

            switch (browser) {
                case "chrome":
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--disable-popup-blocking");

                    // 🔥 DOWNLOAD SETTINGS (EN ÖNEMLİ KISIM)
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("download.default_directory", "C:\\Downloads"); // istediğin path
                    prefs.put("download.prompt_for_download", false); // popup kapatır
                    prefs.put("download.directory_upgrade", true);
                    prefs.put("safebrowsing.enabled", true);
                    prefs.put("profile.default_content_setting_values.notifications", 2);

                    chromeOptions.setExperimentalOption("prefs", prefs);

                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;

                case "safari":
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    break;

                case "chromeheadless":
                    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");

                    // 🔥 HEADLESS DOWNLOAD FIX
                    Map<String, Object> headlessPrefs = new HashMap<>();
                    headlessPrefs.put("download.default_directory", "C:\\Downloads");
                    headlessPrefs.put("download.prompt_for_download", false);
                    headlessPrefs.put("safebrowsing.enabled", true);

                    options.setExperimentalOption("prefs", headlessPrefs);

                    driverPool.set(new ChromeDriver(options));
                    break;

                default:
                    throw new RuntimeException("Wrong browser name !");
            }
        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}