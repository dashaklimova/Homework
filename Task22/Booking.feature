Feature: Test booking page 

Scenario: Checking Moscow hotels list is not empty 
	Given I am on home booking page 
	When I enter city 
	And I fill dates 
	And I click CheckPricesButton 
	Then I see a full list of hotels 
	
Scenario: Checking hotel rating
	Given I am on home booking page 
	When I enter city 
	And I fill dates 
	And I click CheckPricesButton 
	And I sort hotels with a rating of more than nine 
	And I go to the page with the hotel 
	Then I see that the hotel rating is over nine 
	
	