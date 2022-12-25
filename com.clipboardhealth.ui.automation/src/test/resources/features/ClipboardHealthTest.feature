Feature: Clipboard Health Test
  Scenario: Successful product search and assertion
    Given User is on Home Page.
    When User clicks on hamburger menu in the top left corner.
    And Scroll down and then Click on the TV, Appliances and Electronics link under Shop by Category section.
    When Click on Televisions under Tv, Audio & Cameras sub section.
    And Scroll down and filter the results by Brand ‘Samsung’.
    When Sort the Samsung results with price High to Low.
    And Click on the second highest priced item
    When User Switch the Window
    Then Assert that About this item section is present and log this section text to report.

