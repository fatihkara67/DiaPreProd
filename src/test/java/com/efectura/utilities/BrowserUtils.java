package com.efectura.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;


import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertTrue;


/**
 * A utility class containing helper methods for common browser related operations.
 */

public class BrowserUtils {
    /**
     * Geçerli web sayfasının ekran görüntüsünü alır ve ekran görüntüsünün dosya yolunu döndürür.
     *
     * @param name Ekran görüntüsü dosyasına verilecek ad.
     * @return Ekran görüntüsünün dosya yolu.
     */
    public static String getScreenshot(String name) {
        // Adding date and time to the screenshot name to make it unique
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        String path;
        // Determining the file path based on the operating system
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }
        TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    /**
     * Belirtilen web öğesinin sayfada görüntülenip görüntülenmediğini doğrular.
     * Eğer öğe görüntülenmiyorsa, test verilen mesajla başarısız olacaktır.
     *
     * @param element Görünürlüğü kontrol edecek web elementi.
     * @param message Elemanın görünmemesi durumunda görüntülenecek mesaj.
     */
    public static void verifyElementDisplayed(WebElement element, String message) {
        try {
            assertTrue(message, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail(message);
        }
    }

    /**
     * Verilen web öğesine çift tıklama gerçekleştirir.
     *
     * @param element Çift tıklanacak web elementi.
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }
    /**
     * Kaynak elemandan hedef elemana sürükle bırak işlemi gerçekleştirir.
     *
     * @param source Sürüklenecek kaynak öğe.
     * @param target Üzerine bırakılacak hedef öğe.
     */
    public static void dragAndDrop(WebElement source, WebElement target) {
        //bir öğenin bir başka öğene sürüklenmesi işlemidir.
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(source, target).build().perform();
    }
    /**
     * Belirtilen web öğesi üzerinde fareyle üzerine gelme eylemi gerçekleştirir.
     *
     * @param element Üzerine gelinecek web elementi.
     */
    public static void hoverOver(WebElement element) {
        //üzerine gelmek veya odaklanmak için kullanılIR
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).build().perform();
    }
    /**
     * mouse  işaretçisini belirtilen web öğesine taşır.
     *
     * @param element Fare işaretçisinin taşınacağı web öğesi.
     */
    public static void moveToElement(WebElement element) {
        //üzerine gelmek veya odaklanmak için kullanılIR
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).build().perform();
    }
    /**
     * Geçerli iş parçacığını belirli bir saniye boyunca duraklatır.
     *
     * @param secs İş parçacığının duraklatılacağı saniye sayısı.
     */
    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * Geçerli iş parçacığını belirli bir saniye boyunca duraklatır.
     *
     * @param seconds İş parçacığının duraklatılacağı saniye sayısı.
     * Eğer iş parçacığı uyurken kesilirse @, InterruptedException'ı atar
     */
    public static void waitSeconds(int seconds) throws InterruptedException {
        long millis = seconds * 1000L;
        long startTime = System.currentTimeMillis();
        long remainingTime = millis;

        while (remainingTime > 0) {
            try {
                Thread.sleep(remainingTime);
            } catch (InterruptedException e) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                remainingTime = millis - elapsedTime;
                // Re-interrupt the thread to propagate the interruption
                Thread.currentThread().interrupt();
                throw e;
            }
            remainingTime = millis - (System.currentTimeMillis() - startTime);
        }
    }
    /**
     * Başlığına göre bir hedef pencereye gider
     *
     * @param targetTitle hedef pencerenin başlığı
     */
    public static void navigateToWindow(String targetTitle) {
        //arklı tarayıcı pencereleri veya sekmeleri arasında geçiş yapmak için kullanılan bir işlemdir.
        String currentWindow = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(currentWindow);
    }
    /**
     * Belirtilen öğenin görünür olmasını bekler
     *
     * @param element - Beklenecek WebElement
     * @param timeToWaitInSec - Saniye cinsinden beklenecek süre
     * @return Görünür WebElement
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        //bir web sayfasındaki bir öğenin görünürlüğünü beklemek için kullanıLIR
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), ofSeconds(timeToWaitInSec) );
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * Bir öğenin görünür olmasını bekler
     *
     * @param locator - öğe bulucu
     * @param timeToWaitInSec - saniye cinsinden bekleme süresi
     * @return WebElement - görünür öğe
     */
    public static WebElement waitForVisibility(By locator, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    /**
     * Öğenin tıklanabilir olmasını bekler
     *
     * @param element - tıklanacak WebElement
     * @param timeToWaitInSec - saniye cinsinden zaman aşımı
     * @return WebElement
     */
    public static WebElement waitForClickability(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * Bir öğenin tıklanabilir olmasını bekler
     *
     * @param locator
     * @param timeToWaitInSec
     * @return WebElement
     */
    public static WebElement waitForClickable(By locator, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    /**
     * Selects an option from a dropdown by visible text.
     *
     * @param dropdownElement The dropdown WebElement.
     * @param optionToSelect  The option to select by visible text.
     */
    public static void selectDropdownOptionByVisibleText(WebElement dropdownElement, String optionToSelect) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionToSelect);
    }
    /**
     * Selects an option from a dropdown by index.
     *
     * @param dropdownElement The dropdown WebElement.
     * @param index           The index of the option to select.
     */
    public static void selectDropdownOptionByIndex(WebElement dropdownElement, int index) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }


    public static void selectDropdownOptionByRandom(WebElement dropdownElement, WebDriver driver) {
        Select select = new Select(dropdownElement);

        // 1) Seçilebilir (value'su boş olmayan ve enabled) option'ları topla
        List<WebElement> selectable = select.getOptions()
                .stream()
                .filter(WebElement::isEnabled)
                .filter(o -> {
                    String v = o.getAttribute("value");
                    return v != null && !v.trim().isEmpty();
                }).toList();

        if (selectable.isEmpty()) {
            System.out.println("No selectable options (non-empty values). Skipping.");
            return;
        }

        // 2) Mevcut seçim değerini al
        String currentValue = null;
        try {
            currentValue = select.getFirstSelectedOption().getAttribute("value");
        } catch (NoSuchElementException ignore) {}

        // 3) Rastgele ama mevcut seçime eşit olmayan bir option seç
        Random rnd = new Random();
        WebElement candidate;
        if (selectable.size() == 1) {
            candidate = selectable.get(0);
            // tek seçenek mevcut seçili ise yine de seçmeyi deneyip devam edeceğiz
        } else {
            // Mevcut değerle aynıysa başka bir tane seç
            do {
                candidate = selectable.get(rnd.nextInt(selectable.size()));
            } while (currentValue != null && currentValue.equals(candidate.getAttribute("value")));
        }

        String targetValue = candidate.getAttribute("value");

        // 4) Seçimi yap
        select.selectByValue(targetValue);

        // 5) Değişikliği doğrula; olmadıysa JS ile change tetikle
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            wait.until(d -> {
                String now = new Select(dropdownElement).getFirstSelectedOption().getAttribute("value");
                return targetValue.equals(now);
            });
        } catch (TimeoutException te) {
            // Bazı select2 durumlarında native select seçiliyor ama change dinleyicisi çalışmıyor olabilir
            ((JavascriptExecutor) driver).executeScript(
                    "const el = arguments[0]; el.value = arguments[1]; " +
                            "el.dispatchEvent(new Event('change', { bubbles: true }));",
                    dropdownElement, targetValue
            );
            // Bir kez daha doğrula
            wait.until(d -> {
                String now = new Select(dropdownElement).getFirstSelectedOption().getAttribute("value");
                return targetValue.equals(now);
            });
        }

        System.out.println("Selected value: " + targetValue);
    }



    /**
     * Selects an option from a dropdown by value attribute.
     *
     * @param dropdownElement The dropdown WebElement.
     * @param value           The value attribute of the option to select.
     */
    public static void selectDropdownOptionByValue(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
    /**
     * Adına veya kimliğine göre belirtilen çerçeveye geçer.
     *
     * @param frameNameOrId geçiş yapılacak çerçevenin adı veya kimliği
     */
    public static void switchToFrame(String frameNameOrId) {
        Driver.getDriver().switchTo().frame(frameNameOrId);
    }

    /**
     * Belirtilen metinle başlayan dinamik bir öğeye tıklar.
     *
     * @param searchText başlangıcında aranacak metni yazın
     */

    public static void clickDynamicElementStartsWith(String searchText) {
        String xpath = "//*[starts-with(text(),'" + searchText + "')]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        element.click();
    }
    /**
     * belirtilen nitelik değerini içeren dinamik bir öğeye tıklayın.
     *
     * @param attributeName aranacak özelliğinin adını belirtir
     * @param attributeValue aranacak özelliğin değerinin
     */
    public static void clickDynamicElementByAttribute(String attributeName, String attributeValue) {
        String xpath = "//*[@"+attributeName+"='"+attributeValue+"']";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        element.click();
    }
    /**
     * Bir uyarıyı kabul eder ve metnini döndürür.
     *
     * @return uyarı metnini
     */
    public static String handleAlertAcceptByReturningMessage() {
        Alert alert = Driver.getDriver().switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }
    /**
     * Bir uyarıyı kabul eder
     *
     * @return uyarı metnini
     */
    public static void handleAlertAccept() {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    /**
     * Bir uyarıyı reddeder ve metnini döndürür.
     *
     * @return uyarı metnini
     */
    public static String handleAlertDismissByReturningMessage() {
        Alert alert = Driver.getDriver().switchTo().alert();
        String text = alert.getText();
        alert.dismiss();
        return text;
    }/**
     * Bir uyarıyı reddeder ve metnini döndürür.
     *
     * @return uyarı metnini
     */
    public  static void handleAlertDismiss() {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();
    }
    /**
     * Belirtilen başlığa sahip tarayıcı sekmesine geçiş yapar.
     *
     * @param title Geçiş yapılacak tarayıcı sekmesinin başlığı.
     */
    public static void switchToTab(String title) {
        WebDriver driver = Driver.getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Window Handles Sayısı: " + driver.getWindowHandles().size());
           // Tüm açık pencere tanıtıcılarının listesini alın
        for (String windowHandle : driver.getWindowHandles()) {
            // Her pencere tanıtıcısına geçin ve başlığını kontrol edin
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)) {
                // Başlık eşleşirse döngüden çık
                break;
            }
        }
    }
    public static void selectOption(WebElement selectElement, String value) {
        Select select = new Select(selectElement);
        select.selectByValue(value);
    }



    // Seçenek seçilmiş mi kontrol etme metodunu tanımla
    public static boolean isOptionSelected(WebElement selectElement, String value) {
        Select select = new Select(selectElement);
        return select.getFirstSelectedOption().getAttribute("value").equals(value);
    }

    public static String getSelectedOption(WebElement dropdown) {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Elementi hem yatayda hem dikeyde görünür hale getirir
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // JavaScript kullanarak zoom seviyesini %80 yap
    public static void adjustScreenSize(int size, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + size + "%'");
    }

    public static String getValueInInputBox(WebElement inputBox) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        return (String) js.executeScript("return arguments[0].value;", inputBox);
    }

    public static void switchToTabByTitleAndCloseOld(String expectedTitle) {
        WebDriver driver = Driver.getDriver();
        String originalWindow = driver.getWindowHandle();

        // Yeni tab açılana kadar bekle (toplam pencere sayısı 2 olmalı)
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        // Belirtilen title'a sahip yeni tab'e geç
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(expectedTitle)) {
                // Doğru tab bulundu
                // Eski tab'ı kapat
                driver.switchTo().window(originalWindow);
                driver.close();

                // Yeni tab'e tekrar geç
                driver.switchTo().window(handle);
                return;
            }
        }

        throw new RuntimeException("Expected tab with title '" + expectedTitle + "' was not found.");
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(By locator) {
        try {
            return Driver.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static boolean isButtonActive(WebElement button) {
        String classAttribute = button.getAttribute("class");
        return !classAttribute.contains("disabled");
    }

    public static void scrollToRightEnd(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Sayfanın toplam genişliği kadar sağa kaydır
        js.executeScript("window.scrollTo(document.body.scrollWidth, 0)");
    }

    public static void waitForAttribute(WebElement element, String attribute) {
        while (element.getAttribute(attribute) == null) {
            BrowserUtils.wait(1);
        }
    }

    public static WebElement getRandomElementFromList(List<WebElement> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("Liste boş veya null olamaz.");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size()); // 0 ile size-1 arası
        return elements.get(randomIndex);
    }

    public static boolean isNewExcelDownloaded(String downloadDirPath, long maxAgeSeconds) {
        File dir = new File(downloadDirPath);
        File[] xlsxFiles = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".xlsx"));

        if (xlsxFiles == null || xlsxFiles.length == 0) {
            return false;
        }

        File latestFile = Arrays.stream(xlsxFiles)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);

        if (latestFile == null) return false;

        long currentTime = System.currentTimeMillis();
        long lastModified = latestFile.lastModified();

        long ageInSeconds = (currentTime - lastModified) / 1000;
        return ageInSeconds <= maxAgeSeconds;
    }

    public static String getLatestDownloadedExcelPath() {
        // 1) Kullanıcının home directory'si
        String userHome = System.getProperty("user.home");

        // 2) OS'e göre Downloads klasörünü hesapla
        File downloadsDir = new File(userHome, "Downloads");

        if (!downloadsDir.exists() || !downloadsDir.isDirectory()) {
            return null; // yoksa bırakalım
        }

        // 3) Sadece .xlsx dosyalarını listele
        File[] xlsxFiles = downloadsDir.listFiles((d, name) -> name.toLowerCase().endsWith(".xlsx"));

        if (xlsxFiles == null || xlsxFiles.length == 0) {
            return null; // Excel yoksa
        }

        // 4) En son indirilen Excel'i bul
        File latestFile = Arrays.stream(xlsxFiles)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);

        return latestFile != null ? latestFile.getAbsolutePath() : null;
    }

    public static String getFormattedNow(String zoneId) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zoneId));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return now.format(fmt);
    }

    public static boolean isAfter(String s1, String s2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n");
        LocalDateTime d1 = LocalDateTime.parse(s1.trim(), formatter);
        LocalDateTime d2 = LocalDateTime.parse(s2.trim(), formatter);
        return d1.isAfter(d2);
    }

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * İstenen tarihi date input'a set eder
     */
    public static void selectDate(WebElement dateInput, LocalDate date) {

        String formattedDate = date.format(FORMATTER);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript(
                "arguments[0].value = arguments[1];" +
                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                        "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                dateInput,
                formattedDate
        );
    }

    /**
     * Bugünün tarihini seçer
     */
    public static void selectToday(WebElement dateInput) {
        selectDate(dateInput, LocalDate.now());
    }

    private static final String TELEGRAM_BOT_TOKEN = "6538211561:AAEVRYoo03lBKnqhTUUU3lne9nfvpRGHa08";
    public static void sendMessageToTelegram(String message, String chatId) {
        try {
            // Telegram API URL
            String urlString = "https://api.telegram.org/bot" + TELEGRAM_BOT_TOKEN + "/sendMessage";

            // URL bağlantısı oluştur
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            // Mesajı JSON formatında gönderme
            String postData = "chat_id=" + URLEncoder.encode(chatId, "UTF-8") +
                    "&text=" + URLEncoder.encode(message, "UTF-8");

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(postData.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            }

            // Yanıtı kontrol et
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Message sent to Telegram successfully: \n" + message);
            } else {
                System.out.println("Failed to send message to Telegram. Status Code: \n" + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}




