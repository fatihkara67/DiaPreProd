@flow @modul-flow @preprod
Feature: Module Flows Cases

  Scenario: Plain Modul Made Flow Without Reject or Revise
    Given The user get blocked budget
    Given The user get actual budget
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "Modül Akışı" flow
    Given The user select "Modül Yapım" as form type
    Given The user fill start form with musteri code "999999999"
    Given The user verify blocked budget with "10000"
    Given The user login with "satismuduru"
#    Given The user verify process list flow step "Satış Müdürü Keşif Onayı"
    Given The user go in Task and submit
    Given The user login with "offtrademanagerguncel"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user change distributor help
    Given The user verify blocked budget with "0"
    Given The user change distributor help
    Given The user verify blocked budget with "10000"
    Given The user submit the task
    Given The user login with "Tedarikçi"
    Given The user fill vendor form with initial budget "5000"
    Given The user login with "sahamuduru"
    Given The user go in Task and submit
    Given The user verify blocked budget with "5000"
    Given The user login with "satismuduru"
    Given The user go in Task and submit
    Given The user login with "bolgemuduru"
    Given The user go in Task and submit
    Given The user login with "offtrademanagerguncel"
    Given The user go in Task and submit
    Given The user login with "Tedarikçi"
    Given The user fill vendor invoice form with invoice "1000"
    Given The user login with "sahamuduru"
    Given The user go in Task and submit
    Given The user login with "offtradeuzmani"
    Given The user go in Task and submit
    Given The user verify blocked budget with "0"
    Given The user verify actual budget with "1000"
    Given The user go to Flow logs page
    And The user enters "FlowNumber" into "Form Numarası" filter text input box flow
    Then The user verify "Form Numarası" text filter with value "TEST" in "eventLogs_table" flow

  Scenario: Plain Modul Made Flow With Reject sales
    Given The user get blocked budget
    Given The user get actual budget
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "Modül Akışı" flow
    Given The user select "Modül Yapım" as form type
    Given The user fill start form with musteri code "999999999"
    Given The user verify blocked budget with "10000"
    Given The user login with "satismuduru"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user reject the task
    Given The user verify blocked budget with "0"

  Scenario: Plain Modul Made Flow With Revise sales
    Given The user get blocked budget
    Given The user get actual budget
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "Modül Akışı" flow
    Given The user select "Modül Yapım" as form type
    Given The user fill start form with musteri code "999999999"
    Given The user verify blocked budget with "10000"
    Given The user login with "satismuduru"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user revise the task
    Given The user verify blocked budget with "10000"

#  Scenario: Plain Modul Made Flow With Reject offtrade
#    Given The user get blocked budget
#    Given The user get actual budget
#    Given The user login with "sahamuduru"
#    Given The user go to "panel" page
#    Given The user go in "Modül Akışı" flow
#    Given The user select "Modül Yapım" as form type
#    Given The user fill start form with musteri code "999999999"
#    Given The user verify blocked budget with "10000"
#    Given The user login with "satismuduru"
#    Given The user go in Task and submit
#    Given The user login with "offtrademanager"
#    Given The user go in Task "DIA: ConfirmationForm"
#    Given The user reject the task
#    Given The user verify blocked budget with "0"


#------------------------------------------
  Scenario: Plain Modul Budget Flow Without Reject or Revise
    Given The user get blocked budget
    Given The user get actual budget
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "Modül Akışı" flow
    Given The user select "Modül Bütçe Desteği" as form type
    Given The user fill start form with musteri code "999999999" and budget "1250"
    Given The user verify blocked budget with "1250"
    Given The user login with "satismuduru"
    Given The user go in Task and submit
    Given The user login with "bolgemuduru"
    Given The user go in Task and submit
    Given The user login with "offtrademanagerguncel"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user change distributor help
    Given The user verify blocked budget with "0"
    Given The user change distributor help
    Given The user verify blocked budget with "1250"
    Given The user submit the task
    Given The user login with "sahamuduru"
    Given The user go in Task "DIA: SalesFlowForm"
    Given The user fill invoice form with amount "1100"
    Given The user login with "offtradeuzmani"
    Given The user go in Task and submit
    Given The user login with "offtrademanagerguncel"
    Given The user go in Task and submit
    Given The user verify blocked budget with "0"
    Given The user verify actual budget with "1100"


#  Scenario: Plain Modul Budget Flow Without Reject or Revise 2
#    Given The user get blocked budget
#    Given The user get actual budget
#    Given The user login with "sahamuduru"
#    Given The user go to "panel" page
#    Given The user go in "Modül Akışı" flow
#    Given The user select "Modül Bütçe Desteği" as form type
#    Given The user fill start form with musteri code "999999999" and budget "1250"
#    Given The user verify blocked budget with "1250"
#    Given The user login with "satismuduru"
#    Given The user go in Task and submit
#    Given The user login with "bolgemuduru"
#    Given The user go in Task and submit
#    Given The user login with "offtrademanager"
#    Given The user go in Task "DIA: ConfirmationForm"
#    Given The user change distributor help
#    Given The user verify blocked budget with "0"
#    Given The user change distributor help
#    Given The user verify blocked budget with "1250"
#    Given The user submit the task

  Scenario: Plain Modul Budget Flow With Reject
    Given The user get blocked budget
    Given The user get actual budget
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "Modül Akışı" flow
    Given The user select "Modül Bütçe Desteği" as form type
    Given The user fill start form with musteri code "999999999" and budget "1250"
    Given The user verify blocked budget with "1250"
    Given The user login with "satismuduru"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user reject the task
    Given The user verify blocked budget with "0"


  Scenario: Stand Flow Full Cycle
    Given The user get blocked budget for stand
    Given The user get actual budget for stand
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "On Trade Stand Akışı" flow
    Given The user fill start form for '999999999' and markaisi 0
    Then The user verifies info "Form başarıyla gönderildi." appears
    Given The user login with "skgmtest"
    Given The user go in Task and submit
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
#    Given The user go in Task and submit
    Given The user get total price
    Given The user verify stand blocked budget with "1200"
    Given The user login with "Tedarikçi"
    Given The user fill vendor1 form
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user verify new total price
    Given The user submit the task
    Given The user verify stand blocked budget with "1200"
    Given The user login with "Tedarikçi"
    Given The user go in Task "DIA: StandFlowForm"
    Given The user fill vendor2 form and submit
    Given The user login with "kgu"
    Given The user go in Task and submit
    Given The user verify stand blocked budget with "1100"
    Given The user login with "Tedarikçi"
    Given The user go in Task "DIA: StandFlowForm"
    Given The user fill vendor3 form and submit
#    Given The user login with "kgu"
#    Given The user go in Task and submit
    Given The user verify stand blocked budget with "0"
    Given The user verify stand actual budget with "1000"

