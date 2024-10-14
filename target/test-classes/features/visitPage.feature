Feature: Home Page Test

  @checkURL
  Scenario: Checking url
    Given the user is on home page
    Then the URL should be displayed correctly

  @checkPageTitle
  Scenario: Checking page title
    Given the user is on home page
    Then the web page title should be displayed correctly
