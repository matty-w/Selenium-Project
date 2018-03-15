Feature: Test007: Successful Login Test CMS Operator

	Scenario Outline: Test007: QA - Attempt To Login/Logout With Correct Details (CMS Operator)
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then type into textbox <email-textbox> <email-value>
		Then type into textbox <password-textbox> <password-value>
		Then click the element <login-button> <login-tagType>
		Then check login attempt was successful <expected-page-login>
		Then click the element <logout-button> <logout-tagType>
		Then check correct page loaded <expected-page-logout>
		Then close the driver
		
	Examples:
	|browser  |email-textbox|email-value                                  |password-value|password-textbox|login-button |login-tagType|logout-button    |logout-tagType|expected-page-login                                 |expected-page-logout                          |	
	|"Chrome" |"txtEmail"   |"test.cms09@collisionmanagementsystems.co.uk"|"QApassword1!"|"txtPassword"   |"LoginButton"|"class"      |"ctl00$btnLogOut"|"name"        |"https://qa.cmsdriveguard.co.uk/CMSAnalystHome.aspx"|"https://qa.cmsdriveguard.co.uk/Account/Login"|
	    
