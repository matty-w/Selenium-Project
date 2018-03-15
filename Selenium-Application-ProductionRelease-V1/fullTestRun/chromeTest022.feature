Feature: Test022: Check Navigation Across RR Operator Is Working 

Scenario Outline: Test022: QA - Check Navigation Across RR Operator Is Working 
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr operator qa
		Then check page navigation is correctly working <menuId>
		Then close the driver

		Examples:
			|browser |menuId                |
		  |"Chrome"|"ctl00_NavigationMenu"|