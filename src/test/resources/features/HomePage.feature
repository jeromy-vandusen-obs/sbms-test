Feature: Home Page

  @UsesMessages
  Scenario: View personalized message
    Given the messages collection contains a message for the language "en" that says "Hello World"
    When I navigate to the home page
    Then I will see a personalized message that says "Hello World"

  @UsesMessages
  Scenario: View all messages
    Given the messages collection contains exactly these messages:
      | language | content       |
      | en       | Hello World   |
      | fr       | Bonjour Monde |
      | pt       | Olá Mondo     |
    When I navigate to the home page
    Then I will see a table of messages containing exactly these messages in this order:
      | Language | Content       |
      | en       | Hello World   |
      | fr       | Bonjour Monde |
      | pt       | Olá Mondo     |
