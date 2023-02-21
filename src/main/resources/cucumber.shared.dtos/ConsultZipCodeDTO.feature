Feature: Create ConsultZipCodeDTO
  Scenario: ConsultZipCodeDTO create success
    Given I have a ConsultZipCodeDTO
    When I create the consultZipCodeDTO
    Then ConsultZipDTO must have correct values