Feature: basic Search

  As a web surfer , I want to be able to search and find book by name

  @search @web @chrome
  Scenario Outline: simple search
    Given  a web browser is on main website page.
    When the search phrase  "<key>" is entered.
    Then results for "<key>" are shown
    Examples:
      | key |
      | Princess Isambo	   |