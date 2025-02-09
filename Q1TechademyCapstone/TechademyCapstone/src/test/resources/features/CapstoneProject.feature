
Feature: Automate web interactions using BDD

  Background:
    Given I launch the URL "http://the-internet.herokuapp.com/"

  Scenario: Verify the Title of the Homepage
    Then I verify the title of the page as "The Internet"


  Scenario: Verify A/B Testing Page Text
    Then I click on AB Testing link
    Then I verify the text on the page as "A/B Test Variation 1"
    And I navigate back to home page


  Scenario: Select Dropdown Option
    When I click on Dropdown
    And I select "Option 1" from the dropdown
    Then I confirm "Option 1" is selected
    And I navigate back to home page


  Scenario: Verify Frames Page Hyperlinks
    When I click on Frames
    Then I verify "Nested Frames" hyperlink is present
    And I verify "iFrame" hyperlink is present
    And I close the browser