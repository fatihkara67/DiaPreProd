@preprod
Feature: Target Cases

  Scenario: Target export import
    When The user clear related tables
    Given The user login with "fatihkara"
    When The user go to related target item
    When The user click edit item side bar button
#    When The user export target file
    When The user click target import button
    When The user upload file 'PlanningTarget'
    When The user import target file


  Scenario: İç Hedef Onay Akışı
    Given The user login with "fatihkara"
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