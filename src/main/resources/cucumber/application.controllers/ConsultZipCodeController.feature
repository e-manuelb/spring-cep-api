Feature: ConsultZipCodeController use
  Scenario:
    Call ConsultZipController with correct params
    Given I have a correct zipCode
    When I search for the correct zipCode 12345678
    Then The response must be OK "200 OK"
  Scenario:
    Call ConsultZipController with incorrect params
    Given I have a incorrect zipCode
    When I search for the incorrect zipCode 12345678
    Then I should have receive a exception with incorrect zipCode 12345678