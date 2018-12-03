Feature:Gmail.com Test

  Scenario: Check gmail.com
    Given Open https://www.google.com/intl/ru/gmail/about/#
    When Select Login tab
      Then The LoginEmail page opens
    When Fill email field and click next
      Then The Account page opens
    When Click on the Account
      Then Check the email
    When Click on the Write button and write message
      Then Opening a sent message and verify it
    When Remove from the list of incoming mail
      Then Open the Trash and check the successful removal