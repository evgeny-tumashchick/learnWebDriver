@common

Feature: Search [search criteria] using [search resource]
  As a [search resource]
  I want to search [search criteria]
  So that [search criteria] found in search result

  Scenario: User finds the [selenium] word on google search
    Given open google
    When search for "selenium"
    Then "selenium" found in search result
