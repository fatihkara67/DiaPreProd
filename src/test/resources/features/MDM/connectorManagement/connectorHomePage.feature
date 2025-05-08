@regression
Feature: Connector Management Test Cases- Connector Home Page
  Background:
    When   The User opens the browser with the given url
    And    The User inputs a valid username "validUsername"
    And    The User inputs a valid password "validPassword"
    And    The User clicks the Submit button
    Then   The User waits until the MDM element is visible with a timeout of 120 seconds
    And   The User performs a mouseover on the MDM element
    And   The User performs a mouseover on the Connector Management element
    And   The User performs a mouseover on the Connector element
    And   The User clicks on the Connector element
    And   The User gets the current URL and stores it in "itemType=Connector"

  #Scenario: Verify ID Filter - Unique ıd
   # And The user enters "53778" into ıd field
    #And the user clicks on Search button
   # And the user verify on ıd filter functionality "53778"

  Scenario:Connector Verify Label Filter - Valid Label
    And The user enters "XMLFile" into Label field
    And The user clicks on Search button
    #bu adımda fail
    And the user verify on label filter functionality with partial unique code "XMLFile"

  Scenario: Connector Verify Label Filter - Partial Unique Label
    And The user enters "File" into Label field
    And The user clicks on Search button
    #bu adımda fail
    And the user verify on label filter functionality with partial unique code "File"

  Scenario:Connector Verify Code Filter -Valid Unique Code
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And the user verify on code filter functionality "WindowTest"-connector

  Scenario:Connector Verify Code Filter -Valid partial Code
    And The user enters "test" into Code field
    And The user clicks on Search button
    And the user verify on code filter functionality with partial unique code "test"-connector

  Scenario: Reset Button Control
    And The user enters "test212129" into Code field
    And the user clicks on Reset button
    And the user verify Reset button functionality-connector

  Scenario Outline: Connector Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries |
      | 250     |
      | 25      |
      | 50      |
      | 100     |
      | 10      |

   # And   The user
   #  Scenario: Verify export button
   #    When  The user clicks on Export button
   #    Then  The user verify that the export was "Success" verify that the file is located in the downloads folder
    #And   The user verify that the file is in the correct format

  Scenario:Connector Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

  Scenario:Connector Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable

  Scenario:Connector Page Verify Item next Button Unclickable Condition
    When The user clicks last page button
    And  The user verifies next button is not clickable

  Scenario: Connector Page Verify Last Page Button Unclickable Condition
    When The user clicks last page button
    And  The user verifies last page button is not clickable

  Scenario:Connector Page Verify First Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies first page button is clickable

  Scenario:Connector Page Verify Previous Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies previous page button is clickable

  Scenario:Connector Page Verify Item next Button Clickable Condition
    And  The user verifies next button is clickable

  Scenario: Connector Page Verify Last Page Button Clickable Condition
    And  The user verifies last page button is clickable

  Scenario: Create List- create button
    And The user clicks category accordion button
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "otomasyon" List Name
    #And  The user enters "_5458429214" Can view
   # And  The user enters "1757483988_5392786463" Can edit
   # And The user clicks create button-New List
    #Then The user verifies "otomasyon" is visible

  Scenario: Create List- create button-exist user
    And The user clicks category accordion button
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "Sematestyeni" List Name
  #  And  The user enters "_5458429214" Can view
   # And  The user enters "1757483988_5392786463" Can edit
   # And  The user clicks create button-New List
   # Then The user verifies error message "USER_LIST_ALREADY_EXISTS" is displayed

  Scenario: Create List- delete list-cancel button
    And The user selects deleted element-asset
  #  And The user clicks cancel button in delete popup-asset
   # Then The user verifies "otomasyon" is visible

  Scenario: Create List- delete list
    And The user selects deleted element-asset
   # And The user clicks cancel button in delete popup-asset
   # And The user clicks delete button in delete popup
   # Then The user verifies "otomasyon" is not visible

  Scenario: Connector page edit verify
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    Then The user verify Edit Page-Connector

  Scenario: Verify Connector Star Item Functionality- One Contact
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And the user clicks on Star items
    And the user verify My Count badge count is correct

  Scenario: Verify Connector  Items Functionality- more than One Contact
    And The user enters "test" into Code field
    And The user clicks on Search button
    And the user clicks on Star items
    And the user verify My Count badge count is correct

  Scenario:Connector edit -Attributes Tab
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Connector edit -ItemComment Tab
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "ItemComment" tab

  Scenario:Connector edit -Categories Tab
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kategoriler" tab

  Scenario: Connector Edit item added list
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks list drop down button
 #   And  The user clicks new list item-connector
   # Then The user verifies item is added

  Scenario: Connector Edit item removed list
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
#    And  The user clicks removed button
#    Then The user verifies item is removed

  Scenario:Connector Group Permission Verify Item First Page Button Unclickable Condition
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks group permission tab
#    And  The user verifies previous button is not clickable asset


  Scenario:Connector Group Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks group permission tab
    And The user verifies previous page button is not clickable asset

  Scenario:Connector Group Permission Verify Item next Button clickable Condition
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks group permission tab
    When The user clicks next page button asset
    And  The user verifies next button is unclickable asset

  Scenario:Connector Group Permission Verify Previous Page Button clickable Condition
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks group permission tab
    When The user clicks next page button asset
    And  The user verifies previous button is clickable asset

  Scenario:Connector Group Permission Verify Last Page Button clickable Condition
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks group permission tab
    And The user verifies last button is clickable asset

  Scenario:Connector Group Permission Verify Last Page Button Unclickable Condition
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies last button is unclickable asset

  Scenario:Connector Group Permission Verify Item next Button unclickable Condition
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies next button is unclickable asset

  Scenario:Connector Group Permission Verify Item First Page Button Clickable Condition
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies first page button is clickable asset

  Scenario:Connector User Permission Verify Item First Page Button Unclickable Condition
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks user permission tab
    And The user verifies first page button is not clickable user


  Scenario:Connector User Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks user permission tab
    And The user verifies previous page button is not clickable user


  Scenario:Connector User Permission Verify Item next Button clickable Condition
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks user permission tab
    When The user clicks next page button user
    And  The user verifies next button is clickable user

  Scenario:Connector User Permission Verify Previous Page Button clickable Condition
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks user permission tab
    When The user clicks next page button user
    When The user clicks next page button user
    When The user clicks previous page button user
    And  The user verifies previous button is clickable user


  Scenario:Connector User Permission Verify Last Page Button clickable Condition
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks user permission tab
    And The user verifies last button is clickable user

  Scenario:Connector User Permission Verify Last Page Button Unclickable Condition
    And  The user enters "WindowTest" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks user permission tab
    When The user clicks last page button user
    And  The user verifies last button is unclickable user

  Scenario:Connector Edit item status Passive Item Status-cancel button
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks accordion button
    And The user selects "Pasif"
    And the user clicks on unsaved change button
    And The user clicks cancel button
      # And the user verifies item status not change

  Scenario:Connector Edit item status Passive  Item Status- save button
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks accordion button
    And The user selects "Pasif"
    And the user clicks on unsaved change button
    And The user clicks save button
    And the user verifies item status success message

  #Scenario:Connector Edit item status Passive Item Status-cancel button
    #And The user enters "randomSKU" into Code field
   # And the user clicks on Search button
    #And The user clicks on Edit Button
  #  And the user selects "Active"
   # And the user clicks on unsaved change button
   # And The user enters "-------" in  comment area
   # And The user clicks cancel button
   # And the user verifies item status not change

  Scenario:Connector Edit item status Active Item Status- save button
    And The user enters "WindowTest" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks accordion button
    And The user selects "Aktif"
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message
