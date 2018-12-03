$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Gmail.feature");
formatter.feature({
  "line": 1,
  "name": "Gmail.com Test",
  "description": "",
  "id": "gmail.com-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 7421699400,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Check gmail.com",
  "description": "",
  "id": "gmail.com-test;check-gmail.com",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Open https://www.google.com/intl/ru/gmail/about/#",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Select Login tab",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "The LoginEmail page opens",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Fill email field and click next",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "The Account page opens",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Click on the Account",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Check the email",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Click on the Write button and write message",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Opening a sent message and verify it",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Remove from the list of incoming mail",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Open the Trash and check the successful removal",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.openMainPage()"
});
formatter.result({
  "duration": 183254300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.navigateMenu()"
});
formatter.result({
  "duration": 2338179300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.researchOpens()"
});
formatter.result({
  "duration": 37661600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.clickOnTheLogin()"
});
formatter.result({
  "duration": 2039287600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.theAccountPageOpens()"
});
formatter.result({
  "duration": 12287669900,
  "status": "passed"
});
formatter.match({
  "location": "Steps.clickOnTheAccount()"
});
formatter.result({
  "duration": 407014400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.checkTheEmail()"
});
formatter.result({
  "duration": 113407700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.clickOnTheWriteAndWrite()"
});
formatter.result({
  "duration": 4305825800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.verifySendingMail()"
});
formatter.result({
  "duration": 2060428600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.removeFromTheListOfIncomingMail()"
});
formatter.result({
  "duration": 2917412000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.checkTheSuccessfulRemoval()"
});
formatter.result({
  "duration": 1381129400,
  "status": "passed"
});
formatter.after({
  "duration": 853983300,
  "status": "passed"
});
});