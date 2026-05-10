@preprod
Feature: Target Cases

  Scenario: Target export import
    When The user clear related tables
    Given The user login with "fatihkara"
    When The user impersonate to st
    When The user go to related target item
    When The user click edit item side bar button
    When The user export target file
    When The user wait 8 second
    When The user edit target export file
    When The user click target import button
    When The user upload the target file
#    When The user upload file 'PlanningTarget'
    When The user import target file


  Scenario: İç Hedef Onay Akışı
    Given The user login with "fatihkara"
    When The user impersonate to selected user
    When The user go to related target item
    When The user click edit item side bar button
    When The user click flow button
    Given The user go in "BM Akışı" flow
    When The user select bm 'Tümü'
    When The user click start flow button
    When The user go in route flow
    Given The user go in route task "DIA: BmFlowForm"
    When The user click import step button
    When The user upload file 'BMTarget'
    When The user click start import button
    When The user click send approval button
    When The user go in sales approval form
    Given The user go in route task "DIA: BmFlowForm"
    When The user click bm target apply button
    Then The user verifies info "BM hedefleri başarıyla onaylandı." appears




  Scenario: SP kullanıcısı item oluşturur, export/import yapar, Marmara için BM akışı başlatır ve BMUSER2 görevi görür

    # ── Bölüm 0: Item Oluşturma ──────────────────────────────────────────────
    Given The user login with "STPLANLAMA"
#    When I navigate to "Veriler" menu and select "İç Hedef Yönetimi"
#    Then The inner target management page should be displayed

    Given The user go to 'Target' overview page
#    When I click "Yeni Oluştur" button on the page
    When The User clicks on the createButton element
#    Then The family selection modal should be opened

#    When I select the family "Satış Planlama İç Hedef"
    When The user select create item family 'Satış Planlama'
#    And I click the next button on the modal
#    Then The creation info step should be displayed
    When I enter calendar year "2027" and calendar month "9"
#    And I enter total litre tolerance for "Marmara" as "1000"
    When The user click category next button in create
    When The user click category next button2 in create
    When The user click assoc next button in create
#    And I click the next button on the modal
#    Then The review step should be displayed

    When The user click the create button on the modal
    When The user verify created item edit page is open
#    When I click "İç Hedef Oluştur" button on the modal
#    Then The item should be created successfully
#    And The "Özellikler" tab should be active on edit item page

    # ── Bölüm 1: SP Dışa Aktarım / İçe Aktarım ──────────────────────────────────
    When I open the right sidebar on edit item page
#    And I click the export dropdown in quick actions
#    And I select the planning export option
#    Then The planning export file should be downloaded successfully
#
#    When I click the import dropdown in quick actions
#    And I select the planning import option
#    Then The import modal should be opened
#
#    When I upload the planning import excel file
#    And I click the next button on the import modal
#    Then The column preview step should be displayed
#
#    When I click the next button on the import modal
#    Then The data validation step should be displayed
#
#    When I verify there are no errors in validation
#    And I click the import action button
#    Then The import success screen should be displayed
#
#    When I close the import modal

    When The user export target file
    When The user wait 8 second
    When The user edit target export file
    When The user click target import button
    When The user upload the target file
#    When The user upload file 'PlanningTarget'
    When The user import target file

    # ── Bölüm 2: BM Akışı Başlatma (Marmara) ─────────────────────────────────────
    When I open the right sidebar on edit item page
    And I click the flows button in quick actions
    Then The actions modal should be opened

    When I click the flow start button for BM flow
    Then The BM flow form should be loaded

    When I select the BM region "Marmara Bölge"
    And I click the flow start submit button
    Then The success notification "Form başarıyla gönderildi." should appear
    And I save the flow number from the page

    # ── BMUSER2 ile login ve görevi görme ─────────────────────────────────────────
    When The user login with "BMUSER2"
    And I navigate to the task list page
    Then The task list should contain the BM flow task for saved flow number