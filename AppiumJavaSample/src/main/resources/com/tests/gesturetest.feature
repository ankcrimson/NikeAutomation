@GestureTest
Feature: Finding Shoe and Applying Gestures

Scenario Outline: Finding Shoe and Applying Gestures

    Given Browser is <browser> on <platform> and os is <os>
    And Webpage is http://m.nike.com/us/en_us/pd/air-zoom-pegasus-32-running-shoe/pid-10294427/pgid-10266840
    #    Then sample scroll
	Then wait for 3000 ms
    Then scroll 0 350
    Then wait for 3000 ms
    Then choose size1
    Then select skusize
    Then choose add_cart
    #Then wait for 3000 ms
    Then choose cart
    Then wait for 3000 ms
    Then close browser
    
Examples:
    | browser | platform | country | os |
    |  chrome   |  mobile  |  US  | android |