@activity5
Feature: Login Test
Scenario Outline: Testing login with examples
Given the user is on  home page
When user enters with username "<usernames>" and  password "<passwords>"
And clicks Submit Button
Then get confirmation message as "<message>"


Examples:
    | usernames  | passwords | message   |
    | alice | Secret123   | Invalid credentials |
    | bob   | Wrong@123   | Invalid credentials  |