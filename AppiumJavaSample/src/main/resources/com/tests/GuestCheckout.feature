@GuestCheckout
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
   	Then wait for 3000 ms
    Then choose cart
    Then choose guest_checkout
    Then sendkeys Capt Jack in g_firstname
    Then sendkeys Sparrow in g_lastname
    Then sendkeys Black Perl in g_addr1
    Then sendkeys Caribbean Sea in g_addr2
    Then sendkeys Beaverton in g_city
    Then sendkeys 97005 in g_zip
    #Then select g_state
    Then wait for 3000 ms
    Then close browser
    
Examples:
    | browser | platform | country | os |
    |  chrome   |  mobile  |  US  | ios_simulator |