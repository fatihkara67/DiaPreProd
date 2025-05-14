Feature: Offstand Import Cases

  Scenario: Import
    Given The user get stand actual budget for '971981' and markaisi 0
    Given The user update 'MUSTERI_KODU' cells with '971981' in 1 to 2
    Given The user update 'MARKA_ISI' cells with '0' in 1 to 2
    Given The user update 'TOPLAM_TUTAR' cell with '25' in 1
    Given The user update 'TOPLAM_TUTAR' cell with '30' in 2
    Given The user login with "offtrademanager"
    Given The user navigate to import page
    And The user accepts import popup
    When The user select "OFFSTAND" for importType
    When The user upload "OFFSTAND" file
    When The user import the uploaded file
    Then The user verify stand actual budget for '971981' and markaisi 0 with budget "55"
    When The user go in digital asset item
    When The user clicks "Özellikler" tab
    When The user clicks "Genel Bilgi" attribute group
    When The user update 'TOPLAM KALEM TUTARI' attribute with value '60'
    When The user clicks "Genel Bilgi" attribute group
    And The user clicks save button in edit item
    And The user enters "-------" in comment area
    And The user clicks save button in edit item save modal
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
    Then The user verify stand actual budget for '971981' and markaisi 0 with budget "60"
    When The user delete item
#    Then The user verifies info "Öğe Başarıyla Silindi." appears
    Then The user verify stand actual budget for '971981' and markaisi 0 with budget "0"

