Feature: home bottons check functions

  As a web surfer , I want to be able to click on main bottons and its will move to target page

  @search @web @chrome
  Scenario Outline: Main button
    Given  a web browser is on Home page
    When pressed on "<botton>" botton.
    Then "<botton>" page are shown.
    Examples:
      | botton  |
      | Home    |
      | Books   |
      | Authors |