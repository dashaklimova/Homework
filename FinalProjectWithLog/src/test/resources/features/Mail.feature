Feature: Test mail.ru page 
@UI
Scenario: Checking login with correct data 
	Given I am on home mail.ru page 
	When I login with correct data 
	Then I see login is succesfull 
@UI	
Scenario: Checking sent message several users 
	Given I am on home mail.ru page 
	When I login with correct data 
	And I send a message to several users 
	Then I see message is sent 
@UI	
Scenario: Checking basket cleansing 
	Given I am on home mail.ru page 
	When I login with correct data 
	And I delete message 
	Then I see that message is deleted 
@UI	
Scenario: Checking message move to spam 
	Given I am on home mail.ru page 
	When I login with correct data 
	And I move message to spam 
	Then I see that message is in spam 
@UI	
Scenario: Checking spam message is deleted 
	Given I am on home mail.ru page 
	When I login with correct data 
	And I move message to spam 
	And I clean spam folder 
	Then I see spam folder is clean 
@UI	
Scenario: Checking message move to spam and back 
	Given I am on home mail.ru page 
	When I login with correct data 
	And I move message to spam 
	Then I see message move back from spam 
@UI	
Scenario: Checking messages are flagged 
	Given I am on home mail.ru page 
	When I login with correct data 
	And I mark several messages by flag 
	Then I see messages with flags in folder 
@UI	
Scenario: Checking files field 
	Given I am on home mail.ru page 
	When I login with correct data 
	And I click on folder field 
	Then I see message about folder field 
@UI	
Scenario: Checking presence of icons 
	Given I am on home mail.ru page 
	Then I see that field with icons is displayed 
	
	
	