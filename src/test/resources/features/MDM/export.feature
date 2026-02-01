 @preprod
Feature: Export Scenarios

  Background:
    Given The user login with "fatihkara"

  Scenario: Export For Under 10000 data
    Given The user go to 'Event' overview page
    When The user click 'Dışarı Aktar' button
    When The user get selected export options
    When The user complete the export
    Then The user verifies info "EXPORT_SUCCESS" appears
    Then The user verify file is downloaded

  Scenario: Export For Above 10000 data
    Given The user go to 'Contact' overview page
    When The user click 'Dışarı Aktar' button
    When The user get selected export options
    When The user complete the export
    Then The user verifies info "Mail Gönderildi" appears

  Scenario: Transaction Tables Export
    Given The user go to edit item '3495770'
    And The user clicks "TRX_ICHEDEF_PLANLAMA" tab
    When The user click 'Dışarı Aktar' button
    When The user get selected export options
    When The user complete the export
    When The user wait 1 second
    Then The user verifies info "Başarılı" appears
    When The user wait 1 second
    Then The user verify file is downloaded
    When The user wait 8 second
    Given The user go to edit item '1782611'
    And The user clicks "Faturalar" tab
    When The user click 'Dışarı Aktar' button
    When The user get selected export options
    When The user complete the export
    Then The user verifies info "Başarılı" appears
    When The user wait 1 second
    Then The user verify file is downloaded
    And The user clicks "Siparişler" tab
    When The user click 'Dışarı Aktar' button
    Then The user verifies info "NoDataToExport" appears