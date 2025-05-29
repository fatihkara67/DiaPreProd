Feature: Menu Flows Cases

  Scenario: Plain Menu Flow Without Reject or Revise
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "Menü Talep Akışı" flow
    Given The user fill menu start form with musteri code "999999999"
    Given The user login with "skgmtest"
    Given The user go in menu Task "DIA: ConfirmationForm"
    Given The user select vendor as "Menu Vendor"
    Given The user submit the task
    Given The user login with "tedarikçimenü"
    Given The user fill menu vendor form with budget "5000"
    Given The user login with "skgmtest"
    Given The user go in menu Task "DIA: ConfirmationForm"
    Given The user submit the task
    Given The user login with "sahamuduru"
    Given The user go in menu Task "DIA: MenuFlowForm"
    Given The user submit the task
    Given The user login with "skgmtest"
    Given The user go in menu Task "DIA: ConfirmationForm"
    Given The user submit the task
    Given The user login with "tedarikçimenü"
    Given The user fill second menu vendor form
    Given The user login with "skgmtest"
    Given The user go in menu Task "DIA: ConfirmationForm"
    Given The user submit the task
    Given The user login with "tedarikçimenü"
    Given The user fill menu vendor invoice form with invoice "1000"