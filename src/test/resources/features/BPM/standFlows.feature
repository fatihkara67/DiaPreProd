@flow @stand-flow @preprod
Feature: Stand Flows Cases


  Scenario: Tailor Stand Flow Full Cycle
    Given The user get blocked budget for stand '971981'
    Given The user get actual budget for stand '971981'
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "On Trade Stand Akışı" flow
    Given The user select "Tailor Made" as form type
    Given The user fill start2 form for '971981' and markaisi 0
#    Given The user fill start form for '999999999' and markaisi 0
    Then The user verifies info "Form başarıyla gönderildi." appears
    Given The user login with "skgmtest"
    Given The user go in Task and submit
    When The user wait 8 second
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user select vendor 'Efectura Vendor'
#    Given The user go in Task and submit
#    Given The user get total price
    Given The user submit the task 'Başarılı'
#    Given The user verify stand blocked budget with "1200"
    Given The user login with "Tedarikçi"
#    Given The user fill vendor1 form
    Given The user fill tailor vendor1 form
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
#    Given The user verify new total price
    Given The user submit the task 'Başarılı'
    Given The user verify stand blocked budget with "1200" for '971981'
    Given The user login with "Tedarikçi"
    Given The user go in Task "DIA: Stand Akış Formu"
    Given The user fill vendor2 form and submit
    Given The user login with "kgu"
    Given The user go in Task and submit
    Given The user verify stand blocked budget with "1200" for '971981'
    Given The user login with "Tedarikçi"
    Given The user go in Task "DIA: Stand Akış Formu"
    Given The user fill vendor3 form and submit
#    Given The user login with "kgu"
#    Given The user go in Task and submit
    Given The user verify stand blocked budget with "0" for '971981'
    Given The user verify stand actual budget with "1000" for '971981'



  Scenario: Stand Tailor - Reject Case
    Given The user get blocked budget for stand '971981'
    Given The user get actual budget for stand '971981'
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "On Trade Stand Akışı" flow
    Given The user select "Tailor Made" as form type
    Given The user fill start2 form for '971981' and markaisi 0
    Then The user verifies info "Form başarıyla gönderildi." appears
    Given The user login with "skgmtest"
    Given The user go in Task and submit
    When The user wait 8 second
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user select vendor 'Efectura Vendor'
    Given The user submit the task 'Başarılı'
    Given The user login with "Tedarikçi"
    Given The user fill tailor vendor1 form
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user submit the task 'Başarılı'
    Given The user verify stand blocked budget with "1200" for '971981'
    Given The user login with "Tedarikçi"
    Given The user go in Task "DIA: Stand Akış Formu"
    Given The user fill vendor2 form and submit
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user reject the task
    Given The user verify stand blocked budget with "0" for '971981'



  Scenario: Standart Stand Flow Full Cycle
    Given The user get blocked budget for stand '999999999'
    Given The user get actual budget for stand '999999999'
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "On Trade Stand Akışı" flow
    Given The user fill start form for '999999999' and markaisi 0
    Then The user verifies info "Form başarıyla gönderildi." appears
    Given The user verify stand blocked budget with "600" for '999999999'
    Given The user login with "skgmtest2"
    Given The user search form
    Then The user verify "Göreve Atanan" text filter with value "skgm2 soyad" in "taskList_table"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user select kalem 'JW_Ağac_Stand_tr'
    Given The user submit the task 'Başarılı'
#    Given The user go in Task and submit
    When The user wait 8 second
    Given The user verify stand blocked budget with "1200" for '999999999'
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user submit the task 'Başarılı'
#    Given The user get total price
    Given The user login with "Tedarikçi"
    Given The user go in Task "DIA: Stand Akış Formu"
    Given The user submit the task 'Form başarıyla gönderildi.'
    Given The user login with "Tedarikçi"
#    Given The user go in Task "DIA: StandFlowForm"
    Given The user fill last vendor form and complete
    Given The user verify stand blocked budget with "0" for '999999999'
    Given The user verify stand actual budget with "1000" for '999999999'


  Scenario: Standart Stand Flow Full Cycle - Bolge
    Given The user get blocked budget for stand '971982'
    Given The user get actual budget for stand '971982'
    Given The user login with "sahamuduru"
    Given The user go to "panel" page
    Given The user go in "On Trade Stand Akışı" flow
    Given The user fill start form for '971982' and markaisi 0
    Then The user verifies info "Form başarıyla gönderildi." appears
    Given The user verify stand blocked budget with "600" for '971982'
    Given The user login with "skgm3"
    Given The user search form
    Then The user verify "Göreve Atanan" text filter with value "skgm3 skgm3" in "taskList_table"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user select kalem 'JW_Ağac_Stand_tr'
    Given The user submit the task 'Başarılı'
    When The user wait 8 second
    Given The user verify stand blocked budget with "1200" for '971982'
    Given The user login with "kgu"
    Given The user go in Task "DIA: ConfirmationForm"
    Given The user submit the task 'Başarılı'
    Given The user login with "Tedarikçi"
    Given The user go in Task "DIA: Stand Akış Formu"
    Given The user submit the task 'Form başarıyla gönderildi.'
    Given The user login with "Tedarikçi"
    Given The user fill last vendor form and complete
    Given The user verify stand blocked budget with "0" for '971982'
    Given The user verify stand actual budget with "1000" for '971982'