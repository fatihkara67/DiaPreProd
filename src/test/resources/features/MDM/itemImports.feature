 @preprod
Feature: Item Imports

  Background:
    Given The user login with "fatihkara"

#  Scenario: Contact Import
#    Given The user go to 'Contact' overview page
#    Given The user get import info
#      | username | fatihkara |
#      | itemType | Contact   |
#    When The user create excel file
#    When The user fill item import excel with 2 value
#    When The user import the file
##    When The user complete right import process
#    Then The user verify items are created
#
#  Scenario: Contact Hatalı Import
#    Given The user go to 'Contact' overview page
#    Given The user get import info
#      | username | fatihkara |
#      | itemType | Contact   |
#    When The user create excel file
#    When The user fill item import excel with 1 value
#    When The user update "Contact" excel with random "Family" in index 1
#    When The user click item import button
#    When The user upload the file
#    When The user click edit button
#    Then The user verify error message
#    When The user click edit import cancel button
#    When The user click import preview cancel button
#    When The user create excel file
#    When The user fill item import excel with 1 value
#    When The user update "Contact" excel with random "Category" in index 1
#    When The user click item import button
#    When The user upload the file
#    When The user click edit button
#    Then The user verify error message
#
#
#  Scenario: Event Import
#    Given The user go to 'Event' overview page
#    Given The user get import info
#      | username | fatihkara |
#      | itemType | Event     |
#    When The user create excel file
#    When The user fill item import excel with 2 value
#    When The user import the file
#    Then The user verify items are created
#
#  Scenario: Event Hatalı Import
#    Given The user go to 'Event' overview page
#    Given The user get import info
#      | username | fatihkara |
#      | itemType | Event     |
#    When The user create excel file
#    When The user fill item import excel with 1 value
#    When The user update "Event" excel with random "Family" in index 1
#    When The user click item import button
#    When The user upload the file
#    When The user click edit button
#    Then The user verify error message
#    When The user click edit import cancel button
#    When The user click import preview cancel button
#    When The user create excel file
#    When The user fill item import excel with 1 value
#    When The user update "Event" excel with random "Category" in index 1
#    When The user click item import button
#    When The user upload the file
#    When The user click edit button
#    Then The user verify error message
#    When The user click edit import cancel button
#    When The user click import preview cancel button
#    When The user create excel file
#    When The user fill item import excel with 1 value
#    When The user left the attribute empty
#    When The user click item import button
#    When The user upload the file
#    When The user click edit button
#    Then The user verify error message


  Scenario: Attribute Import
    When The user go to attribute page
    When The user upload the 'Attribute' file
#    When The user upload "Attribute" file
    When The user import attribute file
    Then The user verifies that attributes are created
    Then The user tear down all changes in Attribute Case


  Scenario: Contact Import New
    Given The user go to 'Contact' overview page
    Given The user get import info
      | username | fatihkara |
      | itemType | Contact   |
    When The user get default family 'Contact'
    When The user create excel file
    When The user fill import excel for create
    When The user import the file new
    Then The user verify import for create
#    When The user fill item import excel with 2 value


  Scenario: Contact Import New 2
    Given The user go to 'Contact' overview page
    Given The user get import info
      | username | fatihkara |
      | itemType | Contact   |
    When The user get default family 'Contact'
    When The user create excel file2
    When The user fill import excel for create2
    When The user import the file new
    Then The user verify import for create2

  Scenario: Event Import New
    Given The user go to 'Event' overview page
    Given The user get import info
      | username | fatihkara |
      | itemType | Event     |
    When The user get default family 'Event'
    When The user create excel file
    When The user fill import excel for create event
    When The user import the file new
#    Then The user verify import for create
    Then The user verify import for create event


  Scenario: Product Import New
    Given The user go to 'Product' overview page
    Given The user get import info
      | username | fatihkara |
      | itemType | Product   |
    When The user get default family 'Product'
    When The user create excel file
    When The user fill import excel for create product
    When The user import the file new
#    Then The user verify import for create
    Then The user verify import for create product


  Scenario: Event Import With Association
    Given The user go to 'Event' overview page
    Given The user get import info
      | username | fatihkara |
      | itemType | Event     |
    When The user get default family 'Event'
    When The user create excel file
    When The user fill import excel for create event
    When The user import the file new
    Then The user verify import for create event

