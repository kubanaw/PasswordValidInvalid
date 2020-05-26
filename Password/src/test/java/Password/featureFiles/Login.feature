Feature: Login to account at webdriverunivsity.com using login portal 

Background: 
	Given I access webdriverunivsity.com
	When I click on the login portal button
	And I enter a username 

Scenario: Login account with a valid password
	And I enter a "webdriver123" password
	When I click on the login button
	Then I should be presented with a succesfful validation alert

Scenario: Login account with a invalid password
	And I enter a "invalid" password
	When I click on the login button
	Then I should be presented with a unsuccesfful validation alert