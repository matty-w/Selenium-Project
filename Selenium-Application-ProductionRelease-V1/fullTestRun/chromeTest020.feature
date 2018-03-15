Feature: Test020: Check Navigation Is Working Across RR Admin Pages

Scenario Outline: Test020: QA - Check Navigation Is Working Across RR Admin Pages
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then check page navigation is correctly working <menuId>
		Then close the driver
		
		Examples:
			|browser |menuId                |
			|"Chrome"|"ctl00_NavigationMenu"|