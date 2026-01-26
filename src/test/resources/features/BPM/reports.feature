@preprod
Feature: Report

  Background:
    Given The user login with "fatihkara"
    Given The user go to "report" page


  Scenario: Menu Tracking Report
    When The user select 'MenuTrackingReports' report
    Then The user verify 'tableReport' table displayed
    Then The user verify advanced filter group displayed
    Then The user verify 'tableReport' table has data
    And The user enters "zafer" into "Müşteri Adı" filter text input box
    Then The user verify "Müşteri Adı" text filter with value "zafer" in "tableReport"
    And The user reset the basic filters
    And The user verify Reset button func for "Müşteri Adı" text filter
    When The user click flows button in flow report
    Then The user verify 'veri-tablosu' table displayed
    When The user click eye icon
    Then The user verify file preview displayed
    When The user click ExportCurrentView button
    Then The user verify warning message 'Başarılı'

  Scenario: Module Tracking Report
    When The user select 'ModuleTrackingReports' report
    Then The user verify 'tableReport' table displayed
    Then The user verify advanced filter group displayed
    Then The user verify 'tableReport' table has data
    And The user enters "Zong" into "Şehir" filter text input box
    And The user enters "Diamo" into "Segmentasyon" filter text input box
    Then The user verify "Şehir" text filter with value "Zong" in "tableReport"
    Then The user verify "Segmentasyon" text filter with value "Diamo" in "tableReport"
    And The user reset the basic filters
    And The user verify Reset button func for "Şehir" text filter
    And The user verify Reset button func for "Segmentasyon" text filter
    When The user click flows button in flow report
    Then The user verify 'veri-tablosu' table displayed
    When The user click eye icon
    Then The user verify file preview displayed
    When The user click ExportCurrentView button
    Then The user verify warning message 'Başarılı'