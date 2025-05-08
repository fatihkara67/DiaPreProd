@regression
Feature: Asset Management Test Cases- Asset Home Page

  Background:
    When The User opens the browser with the given url
    And  The User inputs a valid username "validUsername"
    And  The User inputs a valid password "validPassword"
    And  The User clicks the Submit button
    Then The User waits until the MDM element is visible with a timeout of 120 seconds
    And  The User performs a mouseover on the MDM element
    And  The User performs a mouseover on the Asset Management element
    And  The User performs a mouseover on the Asset element
    And  The User clicks on the Asset element
    And  The User gets the current URL and stores it in "itemType=Asset" Asset page

  Scenario: Verify Code Filter -Valid Unique Code
    And The user enters "TEST123456" into Code field
    And The user clicks on Search button
    #bu adımda fail
    And The user verify on code filter functionality "TEST123456"

  Scenario:  Verify Code Filter -Valid Unique Code partial
    And The user enters "TEST" into Code field
    And The user clicks on Search button
#    And the user verify on code filter functionality with partial unique code "TEST"

  Scenario: Verify Code Filter - Invalid Unique Code
    And The user enters "sema12345" into Code field
    And The user clicks on Search button
    And the user verify on code filter functionality  with invalid unique code "Eşleşen kayıt bulunamadı"

  Scenario: Verify Label Filter - Valid Label
    And The user enters "TEST123456" into Label field
    And The user clicks on Search button
    #And the user verify on label filter functionality with partial unique code "TEST123456"

  Scenario: Verify Label Filter - Partial Label
    And The user enters "test" into Label field
    And The user clicks on Search button
#    And the user verify on label filter functionality with partial unique code "Test"

  Scenario: Verify Label Filter - Invalid  Label
    And The user enters "sema12345" into Label field
    And The user clicks on Search button
    And the user verify on code filter functionality  with invalid unique code "Eşleşen kayıt bulunamadı"

  Scenario: Create List- cancel button
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "otomasyon" List Name
    # And  The user enters "_5458429214" Can view
   #  And  The user enters "1757483988_5392786463" Can edit
   #  And The user clicks cancel button-New List
    # Then The user verifies "otomasyon" is not visible

  Scenario: Create List- create button
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "otomasyon" List Name
    # And  The user enters "_5458429214" Can view
    #  And  The user enters "1757483988_5392786463" Can edit
    # And The user clicks create button-New List
     # Then The user verifies "otomasyon" is visible

  Scenario: Create List- create button-exist user
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "Sematestyeni" List Name
   #  And  The user enters "_5458429214" Can view
     #And  The user enters "1757483988_5392786463" Can edit
    # And  The user clicks create button-New List
  #   Then The user verifies error message "USER_LIST_ALREADY_EXISTS" is displayed

  Scenario: Create List- delete list-cancel button
    #bakılacak bu step
    And The user selects deleted element-asset
   #  And The user clicks cancel button in delete popup-asset
  #   Then The user verifies "otomasyon" is visible

  Scenario: Create List- delete list
    And The user selects deleted element-asset
      #And The user clicks cancel button in delete popup-asset
    # And The user clicks delete button in delete popup
     # Then The user verifies "otomasyon" is not visible

  Scenario Outline: Asset Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries |
      | 250     |
      | 25      |
      | 50      |
      | 100     |
      | 10      |

  Scenario:Asset Home Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

  Scenario:Asset Home Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable

  Scenario:Asset Home Page Verify Item next Button Unclickable Condition
    When The user clicks last page button
    And  The user verifies next button is not clickable

  Scenario:Asset Home Page Verify Last Page Button Unclickable Condition
    When The user clicks last page button
   # And  The user verifies last page button is not clickable

  Scenario:Asset Home Page Verify First Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies first page button is clickable

  Scenario:Asset Home Page Verify Previous Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies previous page button is clickable

  Scenario:Asset Home Page Verify Item next Button Clickable Condition
    And  The user verifies next button is clickable

  @semaaa
  Scenario:Asset Home Page Verify Last Page Button Clickable Condition
    And  The user verifies last page button is clickable

  Scenario: Verify export button
    When  The user clicks on Export button
   # Then  The user verify that the export was "Success"

  Scenario: Reset Button Control
    And The user enters "test2123" into Code field
    And the user clicks on Reset button
    And the user verify Reset button functionality

