package com.efectura.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BrowserConsoleUtils {

    // Fail ettirecek anahtar kelimeler
    private static final List<String> ERROR_KEYWORDS = Arrays.asList(
            "Uncaught",
            "TypeError",
            "ReferenceError",
            "Failed to fetch",
            "Cannot read properties",
            "net::ERR_"
    );

    // Bilinçli olarak ignore edilecek gürültüler
    private static final List<String> IGNORE_KEYWORDS = Arrays.asList(
            "ResizeObserver loop limit exceeded",
            "Deprecation",
            "favicon.ico"
    );

    public static void assertNoConsoleErrors(WebDriver driver) {

        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);

        StringBuilder errors = new StringBuilder();

        for (LogEntry entry : entries) {
            String level = entry.getLevel().getName();
            String message = entry.getMessage();

            boolean isErrorLevel =
                    level.equalsIgnoreCase("SEVERE")
                            || level.equalsIgnoreCase("ERROR");

            boolean matchesErrorKeyword =
                    ERROR_KEYWORDS.stream().anyMatch(message::contains);

            boolean isIgnored =
                    IGNORE_KEYWORDS.stream().anyMatch(message::contains);

            if ((isErrorLevel || matchesErrorKeyword) && !isIgnored) {
                errors.append("[")
                        .append(new Date(entry.getTimestamp()))
                        .append("] ")
                        .append(level)
                        .append(" - ")
                        .append(message)
                        .append("\n");
            }
        }

        if (errors.length() > 0) {
            throw new AssertionError(
                    "❌ Browser Console Error bulundu:\n" + errors
            );
        }
    }
}

