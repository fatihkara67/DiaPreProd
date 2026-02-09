Feature: Rule Scenarios

  Background:
    Given The user login with "fatihkara"

  Scenario: When a rule is created, Contacts that meet the event rule with or operator must be associated.
    When The user go in to item 'itemIdForEventRuleTests'
    When The user close item card
    When The user click rule tab
    When The user delete all rules if any exists
    When The user close item card
    When The user click rule tab
    When The user sets two different rule with or
    When The user clicks Set Rules button
    Then The user verify warning message 'Kural Başarıyla Kaydedildi'
    And The user clicks "Kişiler" tab
    And The user select "Evet" in "IsAssociated" select filter
#    Then The user go to rule association tab 'EVENT_CONTACT'
    Then The user go to items to verify detail info with two step for or 'İş Ortağı'
#    Then The user tear down all rules 'itemIdForEventRuleTests'


  Scenario: When a rule is created, Contacts that meet the event rule with and operator must be associated.
    When The user go in to item 'itemIdForEventRuleTests'
    When The user close item card
    When The user click rule tab
    When The user delete all rules if any exists
    When The user close item card
    When The user click rule tab
    When The user sets two different rule with and
    When The user clicks Set Rules button
    Then The user verify warning message 'Kural Başarıyla Kaydedildi'
    And The user clicks "Kişiler" tab
    And The user select "Evet" in "IsAssociated" select filter
    Then The user go to items to verify detail info with two step for and 'İş Ortağı'































#
#  Scenario: While a contact who does not meet with the relevant rule is added to the inList for this event,
#  this contact should be added to the associates.
#    When The user go in to item 'itemIdForEventRuleTests'
#    When The user click rule tab
#    When The user delete all rules if any exists
#    When The user sets a rule
#    When The user click Calculate button
#    When The user clicks view list button
#    When The user set an item in rule which is not in rule
#    When The user clicks Set Rules button
#    Then The item that is set in rule should appear in InList
#    Then The item that is set in rule should been associated according to 'EVENT_CONTACT'
#    Then The user tear down all rules 'itemIdForEventRuleTests'
#
#
#  Scenario: While a contact who meet the rule is added to the NotInList for this event,
#  this contact should be removed from the associates.
#    When The user edit an account to meet the rules 'TestAutomation'
#    When The user go in to item 'itemIdForEventRuleTests'
#    When The user click rule tab
#    When The user delete all rules if any exists
#    When The user sets two rule with or operator
#    When The user click Calculate button
#    When The user clicks view list button
#    When The user set an item out rule which is in rule
#    When The user clicks Set Rules button
#    Then The item that is set out rule should appear in NotInList
#    Then The item that is set out rule should not been associated 'EVENT_CONTACT' 'itemIdForEventRuleTests'
#    Then The user tear down all rules 'itemIdForEventRuleTests'
#    Then The user edit an account to meet the rules 'TearDown'
#
#
#  Scenario: When an account is edited to meet the event rules, contact that is associated with this account must be associated.
#    When The user edit an account to meet the rules 'TearDown'
#    When The user go in to item 'itemIdForEventRuleTests'
#    When The user click rule tab
#    When The user delete all rules if any exists
#    When The user sets two rule with or operator
#    When The user click Calculate button
#    When The user clicks Set Rules button
#    When The user edit an account to meet the rules 'TestAutomation'
#    Then The user verifies edited item is associated with two step 'EVENT_CONTACT' 'itemIdForEventRuleTests' 'itemIdForAssociationForContact'
#    When The user edit an account to meet the rules 'TearDown'
#    Then The user tear down all rules 'itemIdForEventRuleTests'
#
#
#  Scenario: When an account is edited to not meet the event rules, associate of this item should be removed
#    When The user edit an account to meet the rules 'TestAutomation'
#    When The user go in to item 'itemIdForEventRuleTests'
#    When The user click rule tab
#    When The user delete all rules if any exists
#    When The user sets two rule with or operator
#    When The user click Calculate button
#    When The user clicks Set Rules button
#    Then The user verifies edited item is associated with two step 'EVENT_CONTACT' 'itemIdForEventRuleTests' 'itemIdForAssociationForContact'
#    When The user edit an account to meet the rules 'TearDown'
#    Then The user verifies that association of this item is removed 'EVENT_CONTACT' 'itemIdForEventRuleTests'
#    Then The user tear down all rules 'itemIdForEventRuleTests'
#
#
#  Scenario: When rule is created with association name, this name should be seen in association table for event
#    When The user go in to item 'itemIdForEventRuleTests'
#    When The user click rule tab
#    When The user delete all rules if any exists
#    When The user sets two different rule with and
#    When The user clicks Set Rules button with association name 'RuleTestAutomation'
#    Then The user go to rule association tab 'EVENT_CONTACT'
#    Then The user verifies that associated item has association name 'RuleTestAutomation'
#    Then The user tear down all rules 'itemIdForEventRuleTests'
#
#
#  Scenario: When rule is created with a random association name,this name should be seen in association table for event
#    When The user go in to item 'itemIdForEventRuleTests'
#    When The user click rule tab
#    When The user delete all rules if any exists
#    When The user sets two different rule with and
#    When The user clicks Set Rules button with random association name
#    Then The user go to rule association tab 'EVENT_CONTACT'
#    Then The user verifies that associated item has association name 'Random'
#    Then The user tear down all rules 'itemIdForEventRuleTests'