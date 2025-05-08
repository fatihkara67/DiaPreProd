@regression
Feature: Contact Management Test Cases- Contact Edit Page
  Background:
    When The User opens the browser with the given url
    And  The User inputs a valid username "validUsername"
    And  The User inputs a valid password "validPassword"
    And  The User clicks the Submit button
    Then The User waits until the MDM element is visible with a timeout of 15 seconds
    And  The User performs a mouseover on the MDM element
    And  The User performs a mouseover on the Contact Management element
    And  The User performs a mouseover on the Contact element
    And  The User clicks on the Contact element
    And  The User gets the current URL and stores it in "itemType=Contact"

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses- save button
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    Then The user verify Edit Page
    And The user clicks accordion button
    And  The user selects "<ItemStatus>"
    And  the user clicks on unsaved change button
    And  The user enters "-------" in  comment area
    And  The user clicks save button
    And  the user verifies item status success message

    Examples:
      | ItemStatus |
      | Aktif      |
      | Pasif      |

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses - cancel button
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    Then The user verify Edit Page
    And The user clicks accordion button
    And  The user selects "<ItemStatus>"
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks cancel button
#    And the user verifies item status not change

    Examples:
      | ItemStatus |
      | Aktif      |
#      | Active     |
      #|Approved   |

  Scenario: Edit item added list
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks list drop down button
    And  The user clicks new list item-contact
  #  Then The user verifies item is added

  Scenario: Edit item removed list
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks accordion button
    And The user clicks removed button
    #Then The user verifies item is removed

#  Scenario:Contact Group Permission Verify Item First Page Button Unclickable Condition
#    And The user enters "semaotomasyon" into Code field
#    And The user clicks on Search button
#    And The user clicks on Edit Button
#    And The user clicks group permission tab
    #And  The user verifies previous button is not clickable asset

#  Scenario:Contact Group Permission Verify Item Previous Page Button Unclickable Condition
#    And The user enters "semaotomasyon" into Code field
#    And The user clicks on Search button
#    And The user clicks on Edit Button
#    And The user clicks group permission tab
#    And The user verifies previous page button is not clickable asset

#  Scenario:Contact Group Permission Verify Item next Button clickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks group permission tab
#    When The user clicks next page button asset
#    And  The user verifies next button is clickable asset

#  Scenario:Contact Group Permission Verify Previous Page Button clickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks group permission tab
#    When The user clicks next page button asset
#    When The user clicks next page button asset
#    When The user clicks previous page button asset
#    And  The user verifies previous button is clickable asset

#  Scenario:Contact Group Permission Verify Last Page Button clickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks group permission tab
#    When The user clicks last page button asset
#    And  The user verifies last button is clickable asset
#
#  Scenario:Contact Group Permission Verify Last Page Button Unclickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks group permission tab
#    When The user clicks last page button asset
#    And  The user verifies last button is unclickable asset

#  Scenario:Contact Group Permission Verify Item next Button unclickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks group permission tab
#    When The user clicks last page button asset
#    And  The user verifies next button is unclickable asset

#  Scenario:Contact Group Permission Verify Item First Page Button Clickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks group permission tab
#    When The user clicks last page button asset
   # And  The user verifies first page button is clickable asset

#  Scenario:Contact User Permission Verify Item First Page Button Unclickable Condition
#    And The user enters "semaotomasyon" into Code field
#    And The user clicks on Search button
#    And The user clicks on Edit Button
#    And The user clicks user permission tab
#    And The user verifies first page button is not clickable user

#  Scenario:Contact User Permission Verify Item Previous Page Button Unclickable Condition
#    And The user enters "semaotomasyon" into Code field
#    And The user clicks on Search button
#    And The user clicks on Edit Button
#    And The user clicks user permission tab
#    And The user verifies previous page button is not clickable user

#  Scenario:Contact User Permission Verify Item next Button clickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks user permission tab
#    When The user clicks next page button user
#    And  The user verifies next button is clickable user

#  Scenario:Contact User Permission Verify Previous Page Button clickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks user permission tab
#    When The user clicks next page button user
#    When The user clicks next page button user
#    When The user clicks previous page button user
#    And  The user verifies previous button is clickable user

#  Scenario:Contact User Permission Verify Last Page Button clickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks user permission tab
#    When The user clicks last page button user
#    And  The user verifies last button is clickable user

#  Scenario:Contact User Permission Verify Last Page Button Unclickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks user permission tab
#    When The user clicks last page button user
#    And  The user verifies last button is unclickable asset

#  Scenario:Contact User Permission Verify Item next Button unclickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks user permission tab
#    When The user clicks last page button user
#    And  The user verifies next button is unclickable user

#  Scenario:Contact User Permission Verify Item First Page Button Clickable Condition
#    And  The user enters "semaotomasyon" into Code field
#    And  The user clicks on Search button
#    And  The user clicks on Edit Button
#    And  The user clicks user permission tab
#    When The user clicks last page button user
#    And  The user verifies first page button is clickable user

  Scenario:Contact edit -Preview Tab
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Önizleme" tab
    Then The user verifies preview tab details is displayed

  Scenario:Contact edit -Item Comment Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Yorumlar" tab

  Scenario:Contact edit - ACCOUNT_CONTACT Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "İş Ortağı" tab

  Scenario:Contact edit -  ACCOUNT_CONTACT Tab Associated
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    #bu adımda fail
    And The user clicks on Edit Button
    And The user clicks "İş Ortağı" tab
    And The user Associated All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit -  ACCOUNT_CONTACT Tab Associated Filter No
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "İş Ortağı" tab
    And  The user Associated No filter
    Then The user verify No Filter

   # Then The user verifies My Account tab details is displayed

 # Scenario:Contact edit - My Account Tab export
   # And The user enters "semaotomasyon" into Code field
  #  And the user clicks on Search button
   # And  The user clicks on Edit Button
   # And The user clicks "My Account" tab
   # When  The user clicks on Export button ediitem
    #Then  The user verify that the export was "Success"

  Scenario:Contact edit - Sharing Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Sharing" tab

  Scenario:Account edit - Sharing Tab Associated
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Sharing" tab
    And The user Associated All filter
    And The user clicks item
    And The user clicks accordion button
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit - Sharing Tab Associated Filter No
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Sharing" tab
    And  The user Associated No filter
    Then The user verify No Filter

  Scenario:Contact edit - Categories Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Kategoriler" tab

  Scenario:Contact edit - History Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Tarihçe" tab

  Scenario:Contact edit - XX_NEW Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "XX_NEW" tab

  Scenario:Contact edit - XX_NEW Associated
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "XX_NEW" tab
    And The user Associated All filter
    And The user clicks item
    And The user clicks accordion button
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit - XX_NEW Tab Associated Filter No
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "XX_NEW" tab
    And The user Associated No filter
    Then The user verify No Filter

  Scenario:Contact edit -Attributes Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Contact edit - Kitler Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Kitler" tab

  Scenario:Contact edit - Kitler Tab Associated
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Kitler" tab
    And The user Associated All filter
    And The user clicks item
    And The user clicks accordion button
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit - Kitler Tab Associated Filter No
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Kitler" tab
    And  The user Associated No filter
    Then The user verify No Filter

  Scenario:Contact edit -Event-Contact Tab
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Etkileşimler" tab

  Scenario:Contact edit - Event-Contact Tab Associated
    When The user clicks on Contact  category
    And The user enters "KaraBela" into Code field
    And The user clicks on Search button
    And The user clicks on Edit Button
    And The user clicks "Etkileşimler" tab
    And The user Associated All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user clicks accordion button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit -Event-Contact Tab Associated Filter No
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Etkileşimler" tab
    And  The user Associated No filter
    Then The user verify No Filter

  Scenario:Contact edit -Preview Tab Export Button
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Önizleme" tab
    And The user clicks accordion button
    And  The user clicks Export PDF button
    Then The user verifies the file is downloaded

  Scenario:Contact edit -Preview Tab Refresh  Button
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Önizleme" tab
    And  The user clicks Refresh button
    Then The user verifies refresh button

  Scenario: Contact Export Entity Button - Attributes
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks accordion button
    And  The user clicks Export Entity Button
    And  The user clicks Export Attributes
    Then The user dowloand Export Entity verifies

  Scenario: Contact Export Entity Button - Associations
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks accordion button
    And  The user clicks Export Entity Button
    And  The user clicks Export Associations
    Then The user dowloand Export Entity verifies

  Scenario: Contact Export Entity Button - Permission
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks accordion button
    And  The user clicks Export Entity Button
    And  The user clicks Export Permission
    Then The user dowloand Export Entity verifies

  Scenario Outline: Campaign-Account Associated Tab Status Fılter "<Status>"
    When The user clicks on Contact  category
    And  The user enters "KaraBela" into Code field
    And  The user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Etkileşimler" tab
    And  The user clicks Associated status
    And  The user selects  "<Status>"
    Then The user verifies displayed "<Status>" is correct
    Examples:
      | Status     |
      | Status:All |
      | Enabled    |
      | Disabled   |
