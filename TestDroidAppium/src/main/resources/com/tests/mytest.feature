Feature: Finding Shoe and Applying Gestures

Scenario Outline: Finding Shoe and Applying Gestures

    Given Browser is <browser> on <platform> and os is <os> with <device>
    And Webpage is http://www.store.nike.com
    Then choose country_chooser
    Then choose <country>
    Then wait for 3000 ms
    Then choose Men
    Then wait for 2000 ms
    Then choose Shoes
    Then wait for 2000 ms
    Then choose Running
    Then wait for 5000 ms
    Then choose shoe
    Then sample scroll
    Then wait for 3000 ms
    Then close browser
    
Examples:
    | browser | platform | country | os | device |
    |  chrome   |  mobile  |  US  | android | Samsung Galaxy Nexus GT-I9250 4.2.2 |
    |  chrome   |  mobile  |  US  | android | Nvidia Shield Tablet |
    |  chrome   |  mobile  |  US  | android | Samsung Galaxy Nexus SPH-L700 4.3 |
    |  safari   |  mobile  |  US  | ios | iPad 3 A1416 8.2 |
    |  safari   |  mobile  |  US  | ios | iPhone 5 A1429 6.1.4 |
    |  safari   |  mobile  |  US  | ios | iPhone 4S A1387 6.1.3 |
    |  safari   |  mobile  |  US  | ios | iPad 2 A1395 7.0.4 |
