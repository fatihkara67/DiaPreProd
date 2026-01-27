@flow @preprod
Feature: Panel Page Scenarios

  Background:
    Given The user login with "offtrademanagerguncel"
    Given The user go to "panel" page

    Scenario: Task list Assign task
#  Scenario: Form Name Filter
#    And The user enters "Stand" into "İsim" filter text input box
#    Then The user verify "İsim" text filter with value "Stand" in "panelTable"

#  Scenario: Form Name Filter
#    And The user enters "Stand" into "Son versiyon" filter text input box
#    Then The user verify "Son versiyon" text filter with value "Stand" in "panelTable"
#
#  Scenario: Form Name Filter Reset
#    And The user enters "Stand" into "İsim" filter text input box
#    And The user reset the basic filters
#    And The user verify Reset button func for "İsim" text filter

#  Scenario: Form Name Asc Sort
#    When The user click 'İsim' header for asc sort
#    Then The user verify 'İsim' header asc sorted in 'panelTable'
#
#  Scenario: Form Name Desc Sort
#    When The user click 'İsim' header for desc sort
#    Then The user verify 'İsim' header desc sorted in 'panelTable'

  Scenario: Form Start Button Navigate Control
    Given The user go in "Modül Akışı" flow
    Then The user verify flow start page is open

  Scenario: History navigation control
    When The user go in 'Modül Akışı' flow history
    Then The  user verify history page is open

  Scenario: Process List ongoing Flow Navigation
    When The user go in 'Modül Akışı' flow history
    When The user click first ongoing flow

  Scenario: Process List Flow Step Control
    When The user take flow step info in task list
    Given The user go to "panel" page
    When The user go in 'Modül Akışı' flow history
    Then The user verify the step in process list

  Scenario: Process List Ongoing Flow Status Control
    When The user take flow step info in task list
    Given The user go to "panel" page
    When The user go in 'Modül Akışı' flow history
    Then The user verify ongoing flow status

  Scenario: Process List Flow Detail Button Control
    When The user go in 'Modül Akışı' flow history
    When The user click flow detail button
    Then The user verify flow details modal is open


