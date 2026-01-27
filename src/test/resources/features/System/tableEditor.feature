Feature: PreProd Table Editor

  Background:
    Given The user login with "offtrademanager"
    Given The user go to "tableEditor" page

  Scenario: End to end
    When The user click CreateNew tab
    When The user select 'ClickHouse' for db type
    Then The user verify schema name select
    When The user select 'SQLServer' for db type
    Then The user verify schema name select
    When The user click create table button
    Then The user verify warning message '403'
    When The user fill table info
    When The user add column button
    When The user click create table button
    Then The user verify warning message 'ErrorSavingTable'
    When The user fill table
    When The user click create table button
#    Then The user verify warning message 'TableSavedSuccessfully'
    When The user select the created table
