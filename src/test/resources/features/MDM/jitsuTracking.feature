@preprod @tracking
Feature: Jitsu User Tracking - Login

  Background:
    Given The user is on the login page

  Scenario: Login flow tüm event'leri doğru şekilde Jitsu'ya gönderilmeli
    Given The user is on the login page
    Then The user verifies "page_view" event is sent to Jitsu
    Then The user verifies "page_view" event has property "path" with value "/Account/Login"
    Then The user verifies "page_view" event has property "title" with value "Oturum aç"
    When The user logs in with "validUsername" and "validPassword"
    Then The user verifies "login_attempted" event is sent to Jitsu
    Then The user verifies "login_attempted" event has property "login_method" with value "standard"
    Then The user verifies "login_attempted" event has property "username" with value "Efectura"
    Then The user verifies "login_attempted" event has non-empty property "time_to_submit"
    Then The user verifies "login_attempted" event has field "captcha_shown"

  Scenario: Liste sayfası açıldığında page_view ve list_viewed event'leri Jitsu'ya gönderilmeli
    Given The user login with "fatihkara"
    When The user navigates to list page and tracking starts
    When The user go to 'Contact' overview page
    Then The user verifies "page_view" event is sent to Jitsu
    Then The user verifies "list_viewed" event is sent to Jitsu