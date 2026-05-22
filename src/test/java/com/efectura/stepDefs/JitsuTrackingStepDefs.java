package com.efectura.stepDefs;

import com.efectura.utilities.DatabaseManager;
import com.efectura.utilities.DbConfigs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;
import java.time.Instant;

public class JitsuTrackingStepDefs extends BaseStep {

    private static final String CH_URL   = DbConfigs.CLICKHOUSE_PREPROD;
    private static final String CH_USER  = DbConfigs.CLICKHOUSE_USERNAME;
    private static final String CH_PASS  = DbConfigs.DB_PASSWORD;
    private static final String TABLE    = "default.mdm_web_specific_events";
    private static final int    WAIT_SEC = 10;

    private Instant testStartTime;

    // -------------------------------------------------------------------------
    // Given
    // -------------------------------------------------------------------------

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        testStartTime = Instant.now().minusSeconds(2);
        pages.loginPage().theUserIsOnTheHomePage();
    }

    // -------------------------------------------------------------------------
    // When
    // -------------------------------------------------------------------------

    @When("The user logs in with {string} and {string}")
    public void theUserLogsInWith(String username, String password) {
        testStartTime = Instant.now().minusSeconds(2);
        pages.loginPage().setUsernameField(username);
        pages.loginPage().setPasswordField(password);
        pages.loginPage().clickLoginButton();
    }

    // -------------------------------------------------------------------------
    // Then
    // -------------------------------------------------------------------------

    @Then("The user verifies {string} event is sent to Jitsu")
    public void theUserVerifiesEventIsSentToJitsu(String eventType) throws InterruptedException {
        int count = waitForEventInDb(eventType, null, null);
        Assert.assertTrue(
                "'" + eventType + "' event'i ClickHouse'a düşmedi (bekleme: " + WAIT_SEC + "sn)",
                count > 0
        );
    }

    @Then("The user verifies {string} event has property {string} with value {string}")
    public void theUserVerifiesEventHasPropertyWithValue(
            String eventType, String column, String expectedValue) throws InterruptedException {
        int count = waitForEventInDb(eventType, column, expectedValue);
        Assert.assertTrue(
                "'" + eventType + "' event'inde '" + column + "' = '" + expectedValue + "' bulunamadı",
                count > 0
        );
    }

    @Then("The user verifies {string} event has non-empty property {string}")
    public void theUserVerifiesEventHasNonEmptyProperty(
            String eventType, String column) throws InterruptedException {
        String query = "SELECT COUNT(*) FROM " + TABLE +
                " WHERE event_type = ? AND _timestamp >= toDateTime(?)" +
                " AND isNotNull(" + column + ") AND toString(" + column + ") != ''";
        int count = waitForCount(query, eventType);
        Assert.assertTrue(
                "'" + eventType + "' event'inde '" + column + "' boş ya da null geldi",
                count > 0
        );
    }

    @Then("The user verifies {string} event has field {string}")
    public void theUserVerifiesEventHasField(
            String eventType, String column) throws InterruptedException {
        boolean exists = columnExistsInTable(column);
        Assert.assertTrue(
                "'" + column + "' kolonu tabloda yok",
                exists
        );
        int count = waitForEventInDb(eventType, null, null);
        Assert.assertTrue("'" + eventType + "' event'i DB'de bulunamadı", count > 0);
    }

    // -------------------------------------------------------------------------
    // Yardımcı metodlar
    // -------------------------------------------------------------------------

    private int waitForEventInDb(String eventType, String column, String value)
            throws InterruptedException {
        long deadline = System.currentTimeMillis() + (WAIT_SEC * 1000L);
        int count = 0;
        while (System.currentTimeMillis() < deadline) {
            count = queryEventCount(eventType, column, value);
            if (count > 0) return count;
            Thread.sleep(1000);
        }
        return count;
    }

    private int queryEventCount(String eventType, String column, String value) {
        StringBuilder sql = new StringBuilder(
                "SELECT COUNT(*) FROM " + TABLE +
                        " WHERE event_type = ? AND _timestamp >= toDateTime(?)"
        );
        if (column != null && value != null) {
            sql.append(" AND toString(").append(column).append(") = ?");
        }
        try (Connection conn = getClickHouseConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            ps.setString(1, eventType);
            ps.setString(2, formatInstant(testStartTime));
            if (column != null && value != null) ps.setString(3, value);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("[JitsuTracking] Sorgu hatası: " + e.getMessage());
        }
        return 0;
    }

    private int waitForCount(String query, String eventType) throws InterruptedException {
        long deadline = System.currentTimeMillis() + (WAIT_SEC * 1000L);
        while (System.currentTimeMillis() < deadline) {
            try (Connection conn = getClickHouseConnection();
                 PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, eventType);
                ps.setString(2, formatInstant(testStartTime));
                ResultSet rs = ps.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) return rs.getInt(1);
            } catch (SQLException e) {
                System.err.println("[JitsuTracking] Sorgu hatası: " + e.getMessage());
            }
            Thread.sleep(1000);
        }
        return 0;
    }

    private boolean columnExistsInTable(String columnName) {
        String sql = "SELECT COUNT(*) FROM system.columns " +
                "WHERE table = 'mdm_web_specific_events' AND name = ?";
        try (Connection conn = getClickHouseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, columnName);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.err.println("[JitsuTracking] Schema hatası: " + e.getMessage());
            return false;
        }
    }

    private String formatInstant(Instant instant) {
        return instant.toString().replace("T", " ").substring(0, 19);
    }

    private Connection getClickHouseConnection() throws SQLException {
        return DatabaseManager.getConnection(CH_URL, CH_USER, CH_PASS);
    }

    @When("The user navigates to list page and tracking starts")
    public void theUserNavigatesToListPageAndTrackingStarts() {
        testStartTime = Instant.now().minusSeconds(2);
    }

}