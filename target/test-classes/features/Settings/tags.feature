@regression
Feature: Tags Page Test Cases
  Background:
    Given The User opens the browser with the given url
    Given The User inputs a valid username "validUsername"
    Given The User inputs a valid password "validPassword"
    Given The User clicks the Submit button
    When  The User waits until the System element is visible with a timeout of 120 seconds
    When  The user is on the Tags page


  Scenario: Users should reach Tags page.
    Then  The user verifies that reached the "Tags" page.

  Scenario: Refresh button should be active in Tags page
    Then The user verifies that Refresh button is active

  Scenario Outline: The User verify label filter works correctly
    When  The user enters "<entries>" in to label filter
    Then  The User verifies that label filter results contains "<entries>"

    Examples:
      | entries   |
      | ozum      |
      | bağbozumu |

  Scenario: If there is no value in the filter result, it should say 'Eşleşen kayıt bulunamadı'
    When The user enters 'quxysobekps' in to label filter
    Then The user verifies that 'Eşleşen kayıt bulunamadı' is displayed in table

  Scenario: The filter should return IDs between 33 and 39 inclusive
    When The user enters 33 and 39 in to Id filter
    When The user clicks update button in Id filter
    Then The user verifies that ids are between 33 and 39 inclusive

  Scenario: 'IdFromMustBeLessThanIdTo' warning should displayed if idFrom is greater than idTo
    When The user enters 67 and 63 in to Id filter
    When The user clicks update button in Id filter
    Then The user verifies that 'IdFromMustBeLessThanIdTo' warning is displayed

  Scenario: Type filter should filter the selected value
    When The user select 'Etkileşimler' from Type filter
    Then The user verifies that table has only 'Etkileşimler' values

  Scenario: Reset button works correctly on Label filter
    When The user enters "abcd" in to label filter
    When The user clicks reset button
    Then The user verifies that label filter has no value

  Scenario: Reset button works correctly on Id filter
    When The user enters 67 and 63 in to Id filter
    When The user clicks reset button
    Then The user verifies that Id filter has no value

  Scenario: Reset button should work correctly on ItemType filter
    When The user select 'Etkileşimler' from Type filter
    When The user clicks reset button
    Then The user verifies that ItemType filter has value 'Tüm Tipler'

  Scenario: Id values should be ascending order with no action
    Then The user verifies that id values are ascending order with no action

  Scenario: Id values should be able to be descending order
    When The user clicks Id header for descending sort
    Then The user verifies that id values are descending order

  Scenario: Label values should be able to be ascending order
    When The user clicks Label header for ascending sort
    Then The user verifies that Label values are ascending order

  Scenario: Label values should be able to be descending order
    When The user clicks Label header for descending sort
    Then The user verifies that Label values are descending order

  Scenario: ItemType values should be able to be ascending order
    When The user clicks ItemType header for ascending sort
    Then The user verifies that ItemType values are ascending order

  Scenario: ItemType values should be able to be descending order
    When The user clicks ItemType header for descending sort
    Then The user verifies that ItemType values are descending order

  Scenario: First and previous buttons should be inactive in first page of Tags table
    When The user enters '1' in to pagination input box
    Then The user verifies that first and previous pagination buttons are inactive in first page of table in Tags page

  Scenario: Last and next buttons should be inactive in last page of Tags table
    When The user enters last page number in to pagination input box in Tags page
    Then The user verifies that last and next pagination buttons are inactive in last page of table in Tags page

  Scenario: The user should go to last page after clicking the last pagination button
    When The user clicks last pagination button in Tags page
    Then The user verifies that table is in last page in Tags page

  Scenario: The user should go to first page after clicking the first pagination button
    When The user clicks last pagination button in Tags page
    When The user clicks first pagination button in Tags page
    Then The user verifies that table is in first page in Tags page

  Scenario: The user should be able to go next page after clicking next pagination button
    When The user clicks next pagination button in Tags page
    Then The user verifies that table go to next page in Tags page

  Scenario: The user should be able to go previous page after clicking previous pagination button
    When The user clicks next pagination button in Tags page
    When The user clicks previous pagination button in Tags page
    Then The user verifies that table go to previous page in Tags page

  Scenario: The Cancel button in DeleteCurrency popup should be active
    When The user clicks tag delete button
    Then The user verifies that Cancel button is active in DeleteCurrency popup