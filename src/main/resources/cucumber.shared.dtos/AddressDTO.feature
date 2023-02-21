Feature: Create AddressDTO
  Scenario: Create AddressDTO success
    Given I have a AddressDTO
    When I create the addressDTO
    Then AddressDTO must have correct values