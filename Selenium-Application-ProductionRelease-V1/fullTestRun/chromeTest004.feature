Feature: Test004: Unsuccessful Login Test

	Scenario Outline: Test004: QA - Attempt To Login With Incorrect Credentials
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then type into textbox <email-textbox> <textbox-value>
		Then type into textbox <password-textbox> <textbox-value>
		Then click the element <login-button> <tagType>
		Then check correct page loaded <expected-page>
		Then close the driver
		
	Examples:
	|browser  |email-textbox|textbox-value|password-textbox|login-button |tagType|expected-page                                 |	
	|"Chrome" |"txtEmail"   |"test"       |"txtPassword"   |"LoginButton"|"class"|"https://qa.cmsdriveguard.co.uk/Account/Login"|
	                