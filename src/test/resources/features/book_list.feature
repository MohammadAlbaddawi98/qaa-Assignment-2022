Feature: book list functions

  As a web surfer , I want to be able to do function on book list such as Edit,Delete and Create book

  @search @web @chrome
  Scenario: Edit book information from book list
    Given a web browser is on books page.
    When pressed on "edit" botton for "The Grapes of Wrath" book.
    Then change book title to "The Grapes of Wraths" and year to "1995"

  Scenario: Delete book from book list
    Given a web browser is on books page.
    When pressed on "delete" botton for "War and Peace" book.
    Then check if "War and Peace" still exist in book list

  Scenario Outline: Create a new book to book list
    Given a web browser is on books page.
    When pressed on Create book botton.
    Then enter book title "<NewTitle>" and year "<NewYear>"
    Examples:
      | NewTitle                      | NewYear |
      | War and Peace and love        | 1990    |
      | The Murderess 1995            | 1995    |
      | Grapes of Wrath	              | 1995    |
      | Captain MiC                   | 1996M    |
