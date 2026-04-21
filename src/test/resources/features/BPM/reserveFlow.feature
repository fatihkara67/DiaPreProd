@flow @menu-flow @preprod
Feature: Reserve Flows Cases

  Scenario: Reserve Flow Report Control
    Given The user login with "satismuduru"
    Given The user go to "panel" page
    Given The user go in "Offtrade Rezerv Akışı" flow
    Given The user fill reserve start form with musteri code "999999999"
    When The user send fillReserveReport endpoint request
    Given The user login with "fatihkara"
    Given The user go to "report" page
    When The user select 'OfftradeReserveTrackingReports' report
    Then The user verify 'tableReport' table has data
    Then The user verify created flow in report