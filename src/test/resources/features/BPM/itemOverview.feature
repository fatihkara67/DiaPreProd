 @preprod
Feature: Item Overview Scenarios

  Background:
    Given The user login with "fatihkara"

  Scenario: Remove and Adding column
    Given The user go to 'Contact' overview page
    And  The user click columns button
    When The user remove one column
    And  The user clicks overview save button
    And  The user click columns button
    And The user add the removed column
    And  The user clicks overview save button

#  Scenario: Columns Adding
#    And The user add 'Öğe Durumları' to columns
#    And The user add the removed column
#    And  The user clicks overview save button
    #    And The user remove 'Öğe Durumları' from columns

  Scenario: Account Attribute Adding From Item Type
    Given The user go to family edit page
    And  The user clicks "Özellikler" tab in edit family
#    And The user click 'İş Ortağı Bilgileri' attribute group
    And The user click 'SON ROTA ADI' check box
    And The user click Save button in family edit page
    And The user enters "update for family attribute by automation" in comment area
    And The user clicks save button in edit family save modal
    Then The user verifies positive info "Changes saved successfully." appears

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
#    When the user fills the "Kod" input field with "EVT-2025-001"
    When the user fills the "Kod" input field with random value
    And the user fills the "Etkinlik Adı" input field with "Test Etkinlik"
    And the user selects "Birebir" from the "Temas Tipi" dropdown
    And the user selects "Sohbet" from the "Tarz / Stil" multi-select dropdown
#    And the user selects "Şarap" from the "İlgili Ürün" multi-select dropdown
    And the user selects "Eğitim" from the "Etkinlik Türü" dropdown
#    And the user fills the "Açıklama" rich text editor with "Bu bir test etkinlik açıklamasıdır."
    And the user fills the "Başlangıç Tarihi" date field with "01.06.2025"
    And the user fills the "Bitiş Tarihi" date field with "30.06.2025"
#    And the user selects "İstanbul" from the "Şehir" multi-select dropdown
    And the user selects "Hayır" from the "Müşteri Ortamında mı?" dropdown
#    When The user fill event create inputs
    When The user click category tab
    When The user select category for create 'On-Trade'
    When The user click create event button
    Then The user verifies info "Başarılı" appears

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
#    And The user enters "update by automation" in comment area
#    And The user clicks save button in assoc type save modal
#    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
    When The user go to account edit item
    And The user clicks "Komşu" tab
    And The user verify assoc tab disabled
    When The user go to assoc type
    When The user unselect readOnly checkbox
#    And The user enters "update by automation" in comment area
#    And The user clicks save button in assoc type save modal
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
    When The user verify created item edit page is open

  Scenario: Add List
    Given The user go to 'Event' overview page
    When The user select first two checkbox in overview
    When The user click add list button
    When The user click create new list button
    When The user fill new list name
    When The user click save list button
    Then The user verifies info "USER_LIST_ADDED" appears
    When The user wait 3 second
#    Then The user verify new list is created

  Scenario: Agency Budget
    Given The user go to 'Event' overview page
    When The User clicks on the createButton element
    When The user select create item family 'WALKERS'
    When The user fill event create attributes
#    When The user select category for create
    When The user select category for create 'On-Trade'
    When The user click category next button in create
    When The user complete create for agency budget
    When The user verify created item edit page is open

  Scenario: Event Overview Advanced Filter Check
    Given The user go to 'Event' overview page
    When The user click advanced filter button
    When The user select 'Etkinlik Türü' in first filter select
    When The user select 'Konferans' in first filter value select
    When The user click add filter button
    When The user select 'Fletum Kod' in second filter value select
    When The user select 'İçeren' in second filter operator select
    When The user fill second filter input with 'test'
    When The user click apply filter button
    Then The user verify "Etkinlik Türü" select filter with value "Konferans" in "overviewTable"
    Then The user verify "Fletum Kod" text filter with value "test" in "overviewTable"

  Scenario: Event Overview Advanced Filter Date Check
#    Given The user create single event
#    Given The user send getBatchStatus request
#    Then The user verify Single Account Create scenario
    Given The user go to 'Event' overview page
    When The user click advanced filter button
    When The user select 'Bitiş Tarihi' in first filter select
    When The user click date filter area
    When The user click add filter button
    When The user click second cancel filter button
    When The user click apply filter button
    Then The user verify "Bitiş Tarihi" date filter with value today in "overviewTable"


  Scenario: Product Item Clone
#    Given The user go to 'Product' overview page
#    When The User clicks on the createButton element
#    When The user select create item family 'Auto_Product'
#    When The user fill product create attributes
#    When The user select category for create 'Ürün'
#    When The user complete create
    When The user go to edit item '3499092'
    When The user verify created item edit page is open
    When The user click edit item side bar button
    When The user click clone button
    When The user fill product clone item info
    Then the user verify clone message

  Scenario: Edit Item Attribute Navigation
    When The user go to edit item '3499092'
    When The user clicks "Ürün Grubu" attribute group
    When The user click 'Ürün Adı' attribute header
    Then The user verifies 'Ürün Adı' attribute edit page is open

  Scenario: Edit Item Family Navigation
    When The user go to edit item '1782611'
    When The user click edit item side bar button
    When The user click family title
    Then The user verify family overview page is open

  Scenario: Edit Item Status Navigation
    When The user go to edit item '1782611'
    When The user click edit item side bar button
    When The user click status title
    Then The user verify item status page is open

  Scenario: Edit Item Tags Navigation
    When The user go to edit item '1782611'
    When The user click edit item side bar button
    When The user click tags title
    Then The user verify tags page is open

  Scenario: Currency Atribute
    When The user go to edit item '3621034'
    When The user click "SYSTEM_ATTRIBUTES_Product" attribute group
#  //header/a[contains(.,'Price')]/parent::header/following-sibling::div/span
    When The user click 'Para Birimi' attribute header
    Then The user verifies 'Para Birimi' attribute edit page is open

  Scenario: Transaction Table Create
    When The user go to transaction page
    When The user click create transaction button
    When The user select db type 'SQL Sunucusu'
    When The user fill transaction create inputs
    When The user click create transaction create button
    Then The user verifies info "TableSavedSuccessfully" appears
    And The user enters created name into "TabName" filter text input box
    Then The user verify "TabName" text filter with value in "transaction_pages_table"
    Then The user delete created transaction

  Scenario: PreProd Seatunnel
    When The user go to seatunnel page
    Then The user verify dashboard
    When The user click 'Finished Jobs' seatunnel tab
    Then The user verify finished jobs table

  Scenario: PreProd FindAndMatch
    When The user go to findAndMatch page
    When The user select 'Etkinlik - Hediye İlişkisi' association type
    When The user select primary item attribute 'Etkinlik Adı'
    When The user select secondary item attribute 'Adı'
    When The user click find and match preview button
    Then The user verify "İlk Özellik Değeri" text filter with value "AutomationFindAndMatch" in "findAndMatchTable"
    Then The user verify "İkinci Özellik Değeri" text filter with value "AutomationFindAndMatch" in "findAndMatchTable"
    Then The user verify "Zaten Bağlı" text filter with value "Bağlı Değil" in "findAndMatchTable"
    When The user click connect button in find and match table
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
    Then The user verify items has association
    Then The user delete association between items

  Scenario: Edit Item History
    When The user go to edit item '3499092'
    When The user clicks "Özellikler" tab
    When The user clicks "Ürün Grubu" attribute group
    When The user update 'Ürün Ek Grup Kodu' attribute with random value
    When The user clicks "Önizleme" tab
    And The user clicks save button in edit item
    And The user enters random in comment area
    And The user clicks save button in edit item save modal
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
    When The user clicks "Tarihçe" tab
    When The user click 'Yenile' button
    Then The user verify history table comment
    And The user clicks "Dijital Varlıklar" tab
    And The user select "Hayır" in "IsAssociated" select filter
    And The user select item at order 1 in association tab
    And The user clicks save button in edit item
    And The user enters random in comment area
    And The user clicks save button in edit item save modal
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
    When The user clicks "Tarihçe" tab
    When The user click 'Yenile' button
    Then The user verify history table comment

  Scenario: Attribute Default Value String
    When The user go to 'Ürün Grup Kodu' attribute page
    When The user clicks "Genel Özellikler" attribute group
    When The user fill default value input with random string
    When The user click save button in attribute edit page
    And The user enters random in comment area
    When The user click save button in attribute edit page save modal
    Then The user verifies info "Changes saved successfully" appears
    Given The user go to 'Product' overview page
    When The User clicks on the createButton element
    When The user select create item family 'Auto_Product'
    Then The user verify 'Ürün Grup Kodu' attribute default value is random in create page

  Scenario: DataConnector
    Given The user go to 'DataConnector' overview page
    When The User clicks on the createButton element
    When The user select saved connect 'test'
    When The user click test connect button
    Then The user verifies info "Bağlantı Başarılı" appears
    When The user click first next button
    When The user click sql button
    When The user fill sql query
    When The user click run query button
    When The user click data connect second next button
    When The user select 'Etkinlikler' for data connect item type
    When The user select 'Pazarlama' for data connect family
    When the user select 'FirstItemId' for data connect sku
    When The user map attribute 'Etkinlik Adı (DIA_Event_Name)'
    When The user click data connect third next button
    When The user set cron expression
    When The user click data connect create button
    When The user verify created item edit page is open

  Scenario: StandBudgetGeneralReport Kalem Ekleme
#    When The User opens the browser with the given url
#    And  The User inputs a valid username "validUsername"
#    And  The User inputs a valid password "validPassword"
#    And  The User clicks the Submit button
    Given The user go to StandBudgetGeneralReport page
    When The user clicks 'Kalem Ekle' button
    When The user fill customer code '999999999'
    When The user clicks 'Kontrol' button
    Then The user verifies info "Müşteri Kodu Geçerli" appears
    When The user select 'Hayır' in marka isi select
    When The user fill random kalem name with price '100'
    When The user clicks 'Kaydet' button
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears

  Scenario: The user navigates to item detail page by clicking a row in the list
    Given The user go to 'Event' overview page
    When the user clicks on the first row in the items table
    Then the user should be navigated to the item detail page
    And the item detail page URL should contain "/Enrich/EditItem/"


  Scenario: BMUSER2 - ShowProcess izni olmayan kullanıcı Modül Akışını göremez (uçtan uca)
#    Given The process definition page URL is "https://dia-preprod-ui.efectura.com/Process/ProcessDefinition"
    Given The user go to "panel" page
    And The permission name is "ShowProcess_Akış_Versiyon_V3.1"
    And The target flow name is "Modül Akışı"
    Given The permission "ShowProcess_Akış_Versiyon_V3.1" exists in the system
    And The user "BMUSER2" does not have permission "ShowProcess_Akış_Versiyon_V3.1"
    When The user login with "BMUSER2"
    Given The user go to "panel" page
#    And I navigate to the process definition page
    Then The process table should be visible
    And The process table should NOT contain a row with name "Modül Akışı"
    And I take a screenshot named "BMUSER2_no_modul_akisi"

  Scenario: Item Clone Random Sku Control
    Then ItemTypeRules tablosunda Type 82 için OtoSKU açık olmalıdır
    When The user get target item
    When The user go to selected target item
    When The user click edit item side bar button
    When The user click clone button
    Then Fletum Kod alanı görünmemelidir

  Scenario: Item Without Unassigned Records Scenario
    Given The user go to 'KPI' overview page
    Then The uncategorized section should not be visible
    Given The user go to 'Event' overview page
    Then The uncategorized section should be visible

  Scenario: Associated Attribute seçiliyken Associated Value kontrolü
    When The user go to attribute page
    When The user click attribute create button
    When The user select attribute type as 'Metin'
    When The user click attribute create next button
    When The user select item type 'Ürün'
    When The user set attribute code
    When The user select attribute group 'SYSTEM_ATTRIBUTES_Product'
    When The user click attribute create next button
    When The user select assoc attribute check box
    When The user click attribute create next button
    Then The user verifies info "Değişiklikler Başarıyla Kaydedildi" appears
    When The user click update button
    When The user go to edit assoc type page
    When The user clicks assoc type "Özellikler" tab
    Then The user verify assoc attribute displayed in assoc type
    Then The user delete test attribute

  Scenario: Unique Attribute Control
    When The user get item info for unique attribute case
    When The user go to second item page
    When The user clicks "Etkinlik Grubu" attribute group
    When The user update 'Etkinlik Adı' attribute
    When The user clicks "Önizleme" tab
    And The user clicks save button in edit item
    And The user enters "update for offstand by automation" in comment area
    And The user clicks save button in edit item save modal
    Then The user verifies info "Özellik değerleri benzersiz olmalıdır: Etkinlik Adı" appears

  Scenario: Add Favourite - History Control
    When The user tear down favourite history case
    When The user go to edit item '3620672'
    When The user click add favourite button
    When The user clicks "Tarihçe" tab
    When The user click 'Yenile' button
    Then The user verify "Yorum" text filter with value "Added to favorites" in "history_table_ItemNewHistory"
    When The user tear down favourite history case
    When The user click add favourite button
    When The user click 'Yenile' button
    Then The user verify "Yorum" text filter with value "Removed from favorites" in "history_table_ItemNewHistory"
    When The user tear down favourite history case

  Scenario: Roller İzinler Export
    When The user go to 'DIA_BASIC' edit role page
    When The user clicks assoc type "İzinler" tab
    When The user click permission export button
    When The user complete the export
    Then The user verifies info "Başarılı" appears

  Scenario: Default Category
    Then The user delete default category for 'WALKERS' family
    When The user go to 'WALKERS' family page
    When The user clicks assoc type "Varsayılan Kategoriler" tab
    When The user select category for create 'On-Trade'
    And The user click Save button in family edit page
    And The user enters "update for default category by automation" in comment area
    And The user clicks save button in edit family save modal
    Then The user verifies positive info "Changes saved successfully." appears
    Given The user go to 'Event' overview page
    When The User clicks on the createButton element
    When The user select create item family 'WALKERS'
    When The user fills the "Kod" input field with random value
    When The user click create next button
    Then The user verify category 'On-Trade' is selected
    Then The user delete default category for 'WALKERS' family









