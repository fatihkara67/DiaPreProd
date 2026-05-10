Feature: ShowProcess Permission - Akış Görünürlük Kontrolü
  # Permission: ShowProcess_Akış_Versiyon_V3.1
  # Bu test; ilgili permission sistemde tanımlı olduğunu,
  # BMUSER2'nin bu permission'a sahip olmadığını ve
  # bu nedenle "Modül Akışı" akışını göremediğini doğrular.

  Background:
    Given The process definition page URL is "https://dia-preprod-ui.efectura.com/Process/ProcessDefinition"
    And The permission name is "ShowProcess_Akış_Versiyon_V3.1"
    And The target flow name is "Modül Akışı"

  Scenario: ShowProcess_Akış_Versiyon_V3.1 permission'ı sistemde tanımlıdır
    Given I query the RolePermissions table for permission "ShowProcess_Akış_Versiyon_V3.1"
    Then The permission should exist in the system

  Scenario: BMUSER2 kullanıcısı ShowProcess_Akış_Versiyon_V3.1 permission'ına sahip değildir
    Given I query the permissions of user "BMUSER2"
    Then The user "BMUSER2" should NOT have permission "ShowProcess_Akış_Versiyon_V3.1"

  Scenario: BMUSER2 login olduğunda Modül Akışı akışını göremez
    Given The permission "ShowProcess_Akış_Versiyon_V3.1" exists in the system
    And The user "BMUSER2" does not have permission "ShowProcess_Akış_Versiyon_V3.1"
    When The user login with "BMUSER2"
    And I navigate to the process definition page
    Then The process table should NOT contain a row with name "Modül Akışı"

  Scenario: BMUSER2 - ShowProcess izni olmayan kullanıcı Modül Akışını göremez (uçtan uca)
    Given The permission "ShowProcess_Akış_Versiyon_V3.1" exists in the system
    And The user "BMUSER2" does not have permission "ShowProcess_Akış_Versiyon_V3.1"
    When The user login with "BMUSER2"
    And I navigate to the process definition page
    Then The process table should be visible
    And The process table should NOT contain a row with name "Modül Akışı"
    And I take a screenshot named "BMUSER2_no_modul_akisi"