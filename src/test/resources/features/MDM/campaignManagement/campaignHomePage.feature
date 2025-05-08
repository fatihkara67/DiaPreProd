@regression
Feature: Campaign Management Test Cases- Campaign Home Page

  Background:
    When The User opens the browser with the given url
    And  The User inputs a valid username "validUsername"
    And  The User inputs a valid password "validPassword"
    And  The User clicks the Submit button
    Then The User waits until the MDM element is visible with a timeout of 120 seconds
    And  The User performs a mouseover on the MDM element
    And  The User performs a  mouseover on the Campaign Management element
    And  The User performs a  mouseover on the Campaign element
    And  The User clicks on the Campaign element
    And  The User gets the current URL and stores it in "itemType=Campaign" Asset page

  Scenario: Verify Code Filter -Valid Unique Code
    And The user enters "welcometestgeneric122" into Code field
    And The user clicks on Search button
    And The user verify on code filter functionality "welcometestgeneric122"-Campaign

  Scenario:  Verify Code Filter -Valid Unique Code partial
    And The user enters "TEST" into Code field
    And The user clicks on Search button
    And the user verify on code filter functionality with partial unique code "TEST"- Campaign

  Scenario: Verify Code Filter - Invalid Unique Code
    And The user enters "semaq.içüöt" into Code field
    And The user clicks on Search button
    And the user verify on code filter functionality  with invalid unique code "Eşleşen kayıt bulunamadı"

  Scenario: Verify Label Filter - Valid Label
    And The user enters "kara_test_itefor_kampanya" into Label field
    And The user clicks on Search button
    And the user verify on label filter functionality with partial unique code "kara_test_itefor_kampanya"- Campaign

  Scenario: Verify Label Filter - Partial Label
    And The user enters "for" into Label field
    And The user clicks on Search button
    And the user verify on label filter functionality with partial unique code "for"- Campaign

  Scenario: Verify Label Filter - Invalid  Label
    And The user enters "semaq.içüöt" into Label field
    And The user clicks on Search button
    And the user verify on code filter functionality  with invalid unique code "Eşleşen kayıt bulunamadı"

  Scenario Outline: Filter "<ItemStatus>" Item Statuses
    And The user clicks on ItemStatuses
    And The user clicks on "<ItemStatus>"
    And The user clicks on Search button
    #bu adımda fail
    And the incoming filter for "<ItemStatus>" should contain
    Examples:
      | ItemStatus |
      | Etkin      |
#      | Devre Dışı |

  # to do
  Scenario: Reset Button Control
    And The user enters "welcometestgeneric122" into Code field
    And The user enters "testbirthday1561" into Label field
    And the user clicks on Reset button
    And the user verify Reset button functionality

  Scenario: Deleting an item and declining the popup message
    And  The user enters "welcometestgeneric122" into Code field
    And  The user clicks on Search button
    And  The user clicks on Delete
    And  The user declines the popup message
    Then The user verify that "welcometestgeneric122" is visible-campaign

  Scenario Outline: Contact Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries |
      | 250     |
      | 25      |
      | 50      |
      | 100     |
      | 10      |

  Scenario: Verify My Count Star Item Functionality- One Contact
    And The user enters "welcometestgeneric122" into Code field
    And The user clicks on Search button
    And the user clicks on Star items

  Scenario: Verify export button
    When  The user clicks on Export button
 #   Then  The user verify that the export was "Success"

  Scenario: Verify Item Previous Button Unclickable Condition
    And  The user verifies previous button is not clickable

    #bu senaryoda fail
  Scenario: Verify Item next Button Unclickable Condition
    When The user clicks last page button
  #  And  The user verifies next button is not clickable

  Scenario: Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

#  Scenario: Verify Last Page Button Unclickable Condition
##    When The user clicks last page button
#    And  The user verifies last page button is not clickable

  Scenario: Campaign Create List- cancel button
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "otomasyon" List Name
    And  The user enters "muratkara" Can view
    And  The user enters "KUVGM Müdürü" Can edit
    And The user clicks cancel button-New List
    Then The user verifies "otomasyon" is not visible

  Scenario:Campaign Create List- create button
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "otomasyon" List Name
    And  The user enters "muratkara" Can view
    And  The user enters "KUVGM Müdürü" Can edit
    And The user clicks create button-New List
    Then The user verifies message "USER_LIST_ADDED" is displayed
    Then The user verifies "otomasyon" is visible

  Scenario:Campaign Create List- create button-exist user
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "otomasyon" List Name
    And  The user enters "muratkara" Can view
    And  The user enters "KUVGM Müdürü" Can edit
    And  The user clicks create button-New List
    Then The user verifies message "USER_LIST_ALREADY_EXISTS" is displayed

  Scenario:Campaign Create List- delete list-cancel button
    And  The user clicks delete icon of list 'otomasyon'
    And  The user clicks cancel button in delete popup
    Then The user verifies "otomasyon" is visible

  Scenario:Campaign Create List- delete list
    And  The user clicks delete icon of list 'otomasyon'
    And The user clicks delete button in delete popup
    Then The user verifies message "USER_LIST_DELETED" is displayed
    Then The user verifies "otomasyon" is not visible

  Scenario:Campaign edit -Attributes Tab
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Campaign edit -Preview Tab
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Önizleme" tab
   #  Then The user verifies preview tab details is displayed

  Scenario:Campaign edit -Item Comment Tab
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "ItemComment" tab
    #Then The user verifies itemComment tab details is displayed

  Scenario:Campaign edit - AbstractPreview Tab
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "CampaignPoints3" tab
   # Then The user verifies My Account tab details is displayed

  Scenario:Campaign edit - Campaign-Account Tab export
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "CAMPAIGN_ACCOUNT" tab
   # When  The user clicks on Export button ediitem
    #Then  The user verify that the export was "Success"

  Scenario:Campaign edit - RealtimeList Tab
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "RealtimeList" tab

  Scenario:Campaign edit - Categories Tab
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kategoriler" tab

  Scenario:Campaign edit - History Tab
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Tarihçe" tab

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses - cancel button-Campaign
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user selects "<ItemStatus>"
       #And the user clicks on unsaved change button
      # And The user enters "-------" in  comment area
       #And The user clicks cancel button
      # And the user verifies item status not change

    Examples:
      | ItemStatus |
      | Pasif      |
      | Aktif      |
      | On Hold_tr |
      | Taslak     |

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses- save button
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user selects "<ItemStatus>"
      # And the user clicks on unsaved change button
      # And The user enters "-------" in  comment area
      # And The user clicks save button
      # And the user verifies item status success message

    Examples:
      | ItemStatus |
      | Pasif      |
      | Aktif      |

  Scenario:Campaign edit - Campaign-Account Associated
    And The user enters "TestAutomation" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "CAMPAIGN_ACCOUNT" tab
    And The user Associated All filter


  Scenario:Campaign edit - Campaign-Account Tab Associated Filter No
    And  The user enters "TestAutomation" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "CAMPAIGN_ACCOUNT" tab
    And  The user Associated No filter
    Then The user verify No Filter
