@dev @regression @preprod
Feature: Message Sending Cases

  Background:
    Given The user login with "fatihkara"
    Given The user go to 'PushNotification' overview page
    And   The user click create button

  Scenario: Sms Case
    When The user select 'SMS' for family
    When The user select 'SMS' for NotificationType
    When The user set unique code value
    When The user select 'Geocell' as provider
    When The user set notification name
    When The user select category
    When The user click second next button
    When The user click createWithRule button
    When The user select 'İK Personel Email' as attribute
    When The user set 'fatih.kara@efectura.com' as attribute value
    When The user click second next button
    When The user set sms body
    When The user click second next button
    When The user select schedule as now
    When The user click second next button
    When The user clicks send button
    Then The user verifies edit item navigate
#    Then The user verify the sms with db 'DEV_MDM'


  @core
  Scenario: Push case
#    When The user select 'PUSH' for family
#    When The user click next button
    When The user select 'PUSH' for NotificationType
    When The user set notification name
    When The user set unique code value
    When The user select 'Default' as provider
#    When The user set deeplink
    When The user select category
    When The user click second next button
    When The user click createWithRule button
    When The user select 'İK Personel Email' as attribute
    When The user set 'fatih.kara@efectura.com' as attribute value
    When The user click second next button
    When The user set push title
    When The user set push body
    When The user click body next button
    When The user select schedule as now
    When The user clicks schedule next button
    When The user clicks send button
#    Then The user verify the push with db 'DEV_MDM'


  Scenario: Email Case
    When The user select 'EMAIL' for family
    When The user select 'EMAIL' for NotificationType
    When The user set unique code value
    When The user select 'Default' as provider
    When The user set notification name
    When The user set email title
    When The user select category
    When The user click second next button
    When The user click createWithRule button
    When The user select 'İK Personel Email' as attribute
    When The user set 'fatih.kara@efectura.com' as attribute value
    When The user click second next button
    When The user set email body
    When The user click second next button
    When The user select schedule as now
    When The user click second next button
    When The user clicks send button
    Then The user verifies edit item navigate
#    Then The user verifies info "Changes saved successfully." appears
    Then The user verify the email

