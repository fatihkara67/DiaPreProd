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

  Scenario: Reserve Flow Full Cycle
    Given The user login with "satismuduru"
    Given The user go to "panel" page
    Given The user go in "Offtrade Rezerv Akışı" flow
    Given The user fill reserve start form with musteri code "999999999"
    Given The user login with "MarketingManager"
    Given The user go in Task "DIA: ConfirmationFormReserve"
    When The user select 'Favori Reklam' as vendor
    Given The user submit the task 'Başarılı'
    Given The user login with "FavoriRe"
    Given The user go in Task "DIA: ReservFlowForm"
    Given The user fill reserve vendor offer form with price "1500"
    Given The user login with "MarketingManager"
    Given The user go in Task "DIA: ConfirmationFormReserve"
    Given The user submit the task 'Başarılı'
    Given The user login with "FavoriRe"
    Given The user go in Task "DIA: ReservFlowForm"
    Given The user fill Proforma form
    Given The user login with "MarketingManager"
    Given The user go in Task "DIA: ConfirmationFormReserve"
    Given The user submit the task 'Başarılı'
    Given The user login with "FavoriRe"
    Given The user go in Task "DIA: ReservFlowForm"
    Given The user fill reserve vendor invoice form with price "1100"
