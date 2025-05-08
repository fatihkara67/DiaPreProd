@regression
Feature: Currencies Test Cases
  Background:
    Given The User opens the browser with the given url
    Given The User inputs a valid username "validUsername"
    Given The User inputs a valid password "validPassword"
    Given The User clicks the Submit button
    When  The User waits until the System element is visible with a timeout of 120 seconds
    When  The user on the currencies page

  Scenario: Users verify reach currencies page
    Then  The user verifies that reached the "Currencies" page.

  Scenario: The user verifies that Refresh button is active in Currencies page
    Then The user verifies that Refresh button is active

  Scenario Outline: The User verify code filter works correctly
    When  The user enters "<entries>" in to code filter
    Then  The User verifies that code filter results contains "<entries>"

    Examples:
      | entries |
      | l       |
      | dollar  |

  Scenario: If there is no value in the filter result, it should say 'Eşleşen kayıt bulunamadı'
    When The user enters 'quxysobekps' in to code filter
    Then The user verifies that 'Eşleşen kayıt bulunamadı' is displayed in table

  Scenario: The user verifies code values are ascending order
    Then The user verifies that code values are ascending order with no action

  Scenario: The user verifies that code values descending order
    When The user clicks data header for descending sort
    Then The user verifies that code values are descending order

  Scenario: The user verifies that status values are ascending order
    When The user clicks status header for ascending sort
    Then The user verifies that status values are ascending order

  Scenario: The user verifies that status values are descending order
    When The user clicks status header for descending sort
    Then The user verifies that status values are descending order

  Scenario: The user verifies that filter reset button works correctly
    When The user enters "abcd" in to code filter
    When The user clicks reset button
    Then The user verifies that code filter has no value

  Scenario: Cancel button should be active in AddCurrency popup
    When The user clicks CreateNew button in Currencies page
    Then The user verifies that Cancel button is active in AddCurrency popup

  Scenario: AddCurrency popup should be closed after clicking the cancel button
    When The user clicks CreateNew button in Currencies page
    When The user clicks cancel button in AddCurrency popup
    Then The user verifies that AddCurrency popup is closed

  Scenario: The user should be able to create a new currency with a non existing Code value
    When The user clicks CreateNew button in Currencies page
    When The user enters a non existing Code value in to CurrencyCode input box 'AddCurrency'
    When The user clicks Save button in AddCurrency popup
    Then The user verifies that the 'Değişiklikler başarıyla kaydedildi.' info appears in the top right
    Then The user verifies that current currencies include new currency

  Scenario: The user should not be able to create a new currency with an already existing Code value
    When The user clicks CreateNew button in Currencies page
    When The user enters an already existing Code value in to CurrencyCode input box 'AddCurrency'
    When The user clicks Save button in AddCurrency popup
    Then The user verifies that the 'SKU benzersiz olmalı' warning appears in the top right

  Scenario: The user verifies that cancel button is active in EditCurrency popup
    When The user clicks a currency edit button
    Then The user verifies that cancel button is active in EditCurrency popup

    #timeOut
  Scenario: The user verifies that Save button is inactive without changes in EditCurrency popup
    When The user clicks a currency edit button
    Then The user verifies that Save button is inactive without change in EditCurrency popup

    #timeOut
  Scenario: The user verifies that closing of EditCurrency popup after clicking the cancel button
    When The user clicks a currency edit button
    When The user clicks cancel button in EditCurrency popup
    Then The user verifies that EditCurrency popup is closed

  Scenario: The user verifies that 'Save' button is active after change CurrencyCode in EditCurrency popup
    When The user clicks a currency edit button
    When The user enter 'a' in to CurrencyCode input box in EditCurrency popup
    Then The user verifies that Save button is active in EditCurrency popup

  Scenario: Save button should be active after change Status in EditCurrency popup
    When The user clicks a currency edit button
    When The user clicks Status checkbox in EditCurrency popup
    Then The user verifies that Save button is active in EditCurrency popup

    #timeOut
  Scenario: Save button should be inactive without changes in AddCurrency popup
    When The user clicks CreateNew button in Currencies page
    Then The user verifies that Save button is inactive without change in AddCurrency popup

  Scenario: Save button should be active, whenever user enters Code value AddCurrency popup
    When The user clicks CreateNew button in Currencies page
    When The user enters 'a' in to CurrencyCode input box in AddCurrency popup
    Then The user verifies that Save button is active in AddCurrency popup

  Scenario: First and previous buttons should be inactive in first page of currencies table
    When The user enters '1' in to pagination input box
    Then The user verifies that first and previous pagination buttons are inactive in first page of table in Currencies

    #NoSuchElement
  Scenario: Last and next buttons should be inactive in last page of currencies table
    When The user enters last page number in to pagination input box in Currencies page
    Then The user verifies that last and next pagination buttons are inactive in last page of table in Currencies page

  Scenario: The user should go to last page after clicking the last pagination button
    When The user clicks last pagination button in Currencies page
    Then The user verifies that table is in last page

  Scenario: The user should go to first page after clicking the first pagination button
    When The user clicks last pagination button in Currencies page
    When The user clicks first pagination button in Currencies page
    Then The user verifies that table is in first page in Currencies page

  Scenario: The user should be able to go next page after clicking next pagination button
    When The user clicks next pagination button in Currencies page
    Then The user verifies that table go to next page in Currencies page

  Scenario: The user should be able to go previous page after clicking previous pagination button
    When The user clicks next pagination button in Currencies page
    When The user clicks previous pagination button in Currencies page
    Then The user verifies that table go to previous page in Currencies page

  Scenario: The user should not be able to edit a currency with an already existing Code value
    When The user clicks a currency edit button
    When The user enters an already existing Code value in to CurrencyCode input box 'EditCurrency'
    When The user clicks Save button in EditCurrency popup
    Then The user verifies that the 'SKU benzersiz olmalı' warning appears in the top right

  Scenario: The user should be able to edit a currency with a non existing Code value
    When The user clicks a currency edit button
    When The user enters a non existing Code value in to CurrencyCode input box 'EditCurrency'
    When The user clicks Save button in EditCurrency popup
    Then The user verifies that the 'Değişiklikler başarıyla kaydedildi.' info appears in the top right
    #bu adımda fail
    Then The user verifies that current currencies include edited currency

  Scenario: The user should be able to edit currency status
    When The user clicks a currency edit button
    When The user clicks Status checkbox in EditCurrency popup
    When The user clicks Save button in EditCurrency popup
    Then The user verifies that the 'Değişiklikler başarıyla kaydedildi.' info appears in the top right
    Then User verifies that status of the currency has changed

  Scenario: The Cancel button in DeleteCurrency popup should be able to active
    When The user clicks a currency delete button
    Then The user verifies that Cancel button is active in DeleteCurrency popup

    #timeOut
  Scenario: The Delete button in DeleteCurrency popup should be active
    When The user clicks a currency delete button
    Then The user verifies that Delete button is active in DeleteCurrency popup

  #timeout
  Scenario: The user should be able to close DeleteCurrency popup after clicking the cancel button
    When The user clicks a currency delete button
    When The user clicks Cancel button in DeleteCurrency popup
    Then The user verifies that DeleteCurrency popup is closed

  Scenario: The user should be able to delete a currency
    When The user clicks a currency delete button
    When The user clicks Delete button in DeleteCurrency popup
    Then The user verifies that the 'Değişiklikler başarıyla kaydedildi.' info appears in the top right
    #bu adımda fail
    Then The user verifies that current currencies do not include deleted currency



