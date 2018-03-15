Feature: Test010: Successful Login Test Claims Handler Operator

	Scenario Outline: Test010: QA - Attempt To Login/Logout With Correct Details (CH Operator)
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
	|browser  |email-textbox|email-value                                  |password-value  |password-textbox|login-button |login-tagType|logout-button    |logout-tagType|expected-page-login                                   |expected-page-logout                          |	
	|"Chrome" |"txtEmail"   |"test.cms06@collisionmanagementsystems.co.uk"|"QACHpassword1!"|"txtPassword"   |"LoginButton"|"class"      |"ctl00$btnLogOut"|"name"        |"https://qa.cmsdriveguard.co.uk/ClaimHandlerHome.aspx"|"https://qa.cmsdriveguard.co.uk/Account/Login"|
	    
            