Feature: ShippingPrice enum use
  Scenario: Success get ShippingPrice
    Given I have a ShippingPrice enum
    When I invoke him
    Then ShippingPrice must have correct values