@PaypalCheckout
Feature: Finding Shoe and Applying Gestures

Scenario Outline: Finding Shoe and Applying Gestures

    Given Browser is <browser> on <platform> and os is <os>
    And Webpage is http://www.store.nike.com
    Then choose country_chooser
    Then choose <country>
    #Then wait for 3000 ms
    Then choose Men
    #Then wait for 2000 ms
    Then choose Shoes
    #Then wait for 2000 ms
    Then choose Running
    #Then wait for 5000 ms
    Then choose shoe
#    Then sample scroll
	Then wait for 3000 ms
    Then scroll 0 350
    Then wait for 3000 ms
    Then choose size1
    Then select skusize
    Then choose add_cart
    #Then wait for 3000 ms
    Then choose cart
    Then choose paypal_checkout
    Then wait for 3000 ms
    Then close browser
    
Examples:
    | browser | platform | country | os |
    |  chrome   |  mobile  |  US  | ios_simulator |