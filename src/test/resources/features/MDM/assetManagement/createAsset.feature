@regression
Feature: Asset Management Test Case
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
  Then The User waits until the createItem element is visible with a timeout of 120 seconds

  Scenario: Create Asset on Fletum with invalid family
    And   The User clicks on the createItem element
    Given The user waits until the element with id  Infoitem is visible.
    Then  The User waits until the uniqueCode element is visible with a timeout of 120 seconds
    And   The User inputs the value from cont into the inputCode field
    And   The User presses the down arrow key and then presses Enter in the Choose Family element
    And   The User clicks on the Categories element
    Then  The User waits until the Root Categories element is visible with a timeout of 120 seconds
    And   The user clicks on the Root Checkbox
    And   The User clicks on the createButton element
    Then  The User waits until the page contains "EMPTY_FAMILY" with a timeout of 15 seconds

  Scenario: Create Asset on Fletum without Categories
    And   The User clicks on the createItem element
    Given The user waits until the element with id  Infoitem is visible.
    Then  The User waits until the uniqueCode element is visible with a timeout of 120 seconds
    And   The User inputs the value from cont into the inputCode field
    And   The User presses the down arrow key and then presses Enter in the Cooler element
    And   The User clicks on the createButton element
    # bu step incelenecek
    Then  The User waits until the page contains "Please choose categories" text with a timeout of 120 seconds

  Scenario: Cancel Asset creation in Fletum
    And   The User clicks on the createItem element
    Given The user waits until the element with id  Infoitem is visible.
    Then  The User waits until the uniqueCode element is visible with a timeout of 120 seconds
    And   The User inputs the value from cont into the inputCode field
    And   The User presses the down arrow key and then presses Enter in the Cooler element
    And   The User clicks on the Categories element
    Then  The User waits until the Root Categories element is visible with a timeout of 120 seconds
    And   The user clicks on the Root Checkbox
    And   The User clicks on the cancelButton element
    Then  The User waits until the createItem element is visible with a timeout of 120 seconds

  Scenario Outline: Create Asset on Fletum with valid credentials - "<Family>"
    And   The User clicks on the createItem element
    Given The user waits until the element with id  Infoitem is visible.
    Then  The User waits until the uniqueCode element is visible with a timeout of 120 seconds
    And   The User inputs the value from cont into the inputCode field
    And   The User presses the down arrow key and then presses enter in the "<Family>" element in Asset
    And   The User clicks on the Categories element
#    And   The User clicks on the Asset Categories element
    And   The user clicks on the Root Checkbox
    And   The User clicks on the createButton element
    Examples:
      | Family  |
      | COOLER3 |


  Scenario Outline: Delete Asset on Fletum with valid credentials - "<Family>"-cancel button
  And  The user enters "199955523515555" into Code field
  And  The user clicks on Search button
  And  The user clicks delete button- "<Family>"
  And  The user clicks cancel button in popup
  Examples:
    | Family  |
    | COOLER3 |

  Scenario Outline: Delete Asset on Fletum with valid credentials - "<Family>"
    And  The user enters "199955523515555" into Code field
    And  The user clicks on Search button
    And  The user clicks delete button- "<Family>"
    And  The user clicks delete button in popup
    Then The User waits until the page contains "Öğe Başarıyla Silindi." with a timeout of 120 seconds-Asset
    Examples:
      | Family |
      | Cooler |


