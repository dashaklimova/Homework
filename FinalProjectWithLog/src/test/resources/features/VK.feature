Feature: Test VK API 
@API
Scenario: Checking post message 
	When I post message 
	Then I see message is posted 
@API
Scenario: Checking edit message 
	When I post message 
	And I edit message 
	Then I see message is edited 
@API
Scenario: Checking delete message 
	When I post message 
	And I delete post 
	Then I see post is deleted