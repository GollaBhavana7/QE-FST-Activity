@Activity3
Feature:Testing with Tags
@SimpleAlert
@SmokeTest
Scenario: Testing with Simple Alert
Given user is on the page
When user clicks the simple alert button
Then alert opens
And read the text from it and print it
And close the alert
And read the result text
@ConfirmAlert
Scenario: Testing with Confirm Alert
Given user is on the page
When user clicks the Confirm Alert button
Then alert opens
And read the text from it and print it
And close the alert with Cancel
And read the result text
@PromptAlert
Scenario Outline: Testing with prompt Alert
Given user is on the page
When user clicks the prompt alert button
Then alert opens
And read the text from it and print it
And write a custom message in it
And close the alert
And read the result text