Feature: Event Cases

  Background:
    Given The user login with "fatihkara"
    Given The user go to 'Event' overview page


  Scenario: Event Item Creation With Rule
    When The user click create button
    When The user select 'WALKERS' for family
    When The user click nextt button
#    When The user fill related brand attribute
    When The user select categoryy
    When The user click nextToRuleButton
    When The user create rule
    When The user click nextToPreviewButton
    When The user click createItem button in modal

