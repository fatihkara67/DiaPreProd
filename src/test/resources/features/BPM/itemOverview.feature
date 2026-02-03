 @preprod
Feature: Item Overview Scenarios

  Background:
    Given The user login with "fatihkara"

  Scenario: Remove column
    Given The user go to 'Contact' overview page
    And  The user click columns button
    And The user remove 'Öğe Durumları' from columns
    And  The user clicks overview save button

  Scenario: Columns Adding
    Given The user go to 'Contact' overview page
    And  The user click columns button
    And The user add 'Öğe Durumları' to columns
    And  The user clicks overview save button

  Scenario: Account Attribute Adding From Item Type
    Given The user go to family edit page
    And  The user clicks "Özellikler" tab in edit family
#    And The user click 'İş Ortağı Bilgileri' attribute group
    And The user click 'SON ROTA ADI' check box
    And The user click Save button in family edit page
    And The user enters "update for family attribute by automation" in comment area
    And The user clicks save button in edit family save modal
    Then The user verifies info "Changes saved successfully." appears

  Scenario: Support Mail Test
    When The user click support button
    When The user fill support inputs
    When The user upload support file
    When The user click send ticket button
    Then The user verifies info "Ticket Başarıyla Gönderildi" appears
    Then The user verify mail is sent

  Scenario: Roof card event creation
    When The user go to roof card item
    When The user click event create button
    When The user fill event create inputs
    When The user click create event button

#  Scenario: Password update
#    When The user go to profile page
#    When The user click password accordion
#    When The user fill password
#    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
#    Then The user send new password to telegram
#    Given The user login with "fatihkara"
#    When The user go to profile page
#    When The user click password accordion
#    When The user fill password back
#    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears


  Scenario: Association Type
    When The user go to assoc type
    When The user select readOnly checkbox
    And The user enters "update by automation" in comment area
    And The user clicks save button in assoc type save modal
#    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
    When The user go to account edit item
    And The user clicks "Komşu" tab
    And The user verify assoc tab disabled
    When The user go to assoc type
    When The user unselect readOnly checkbox
    And The user enters "update by automation" in comment area
    And The user clicks save button in assoc type save modal
    When The user go to account edit item
    And The user clicks "Komşu" tab
    And The user verify assoc tab enabled


  Scenario: Edit Item Compare Item
    Given The user go to edit item '1975501'
    When The user click edit item side bar button
    When The user click addToComparison button
    Given The user go to edit item '1975503'
    When The user click edit item side bar button
    When The user click addToComparison button
    When The user click viewComparison button

  Scenario: Compare Item Page
    When The user go to 'CompareItem' page
    When The user get 2 'Event' item id
    When The user fill id inputs
    When The user click compare button

  Scenario: Overview Item Edit
    Given The user go to 'Contact' overview page
    When The user get item info
#    And The user enters "semaotomasyon" into "Code" filter text input box
    And The user enters selected into "Fletum Kimlik" filter text input box
    When The user click overview edit button
    When The user update name
    When The user click overview edit button
    Then The user verify name is edited

  Scenario: BackupPage
    Given The user go to BackupPage
    When The user select table 'my_database.staging_account_dummy'

  Scenario: User Group Permission
    Given The user go to edit item for user permission
    And The user clicks "Kullanıcı Grubu İzinleri" tab
    When The user select first two checkbox in permissions
    When The user click read and write bulk button
    When The user click save permission button
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
    When The user select first two checkbox in permissions
    When The user click kalıt bulk button
    When The user click save permission button
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears

  Scenario: Global Search
    When The user go to user manage page
    And The user enters "burcu.bulut" into "UserName" filter text input box
    When The user impersonate 'burcu.bulut'
    When The user search in global search 'Hare Meyveli'
    Then The user verify no result


  Scenario: Bulk Action Category Change
    Given The user go to 'Contact' overview page
    And The user select "All in" in "Category" select filter
    When The user get category of first two items
    When The user select first two items
    When The user click bulk action button
    When The user select 'Kategori Değiştir' in bulk actions
    When The user select 'Genel' under 'IWSA'


  Scenario: Event - File Assoc
    Given The user go to 'Event' overview page
    When The User clicks on the createButton element
    When The user select create item family 'WALKERS'
    When The user fill event create attributes
    When The user select category for create
    When The user complete create
    When The user verify created event edit page is open
