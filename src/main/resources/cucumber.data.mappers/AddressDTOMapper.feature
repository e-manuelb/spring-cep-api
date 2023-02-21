Feature: AddressDTOMapper use
  Scenario: Success mapTo
    Given I have a Address to convert to AddressDTO
    When I convert this Address to AddressDTO
    Then The AddressDTO must be formatted as well
  Scenario: Success mapFrom
    Given I have a AddressDTO to convert to Address
    When I convert this AddressDTO to Address
    Then The Address must be formatted as well