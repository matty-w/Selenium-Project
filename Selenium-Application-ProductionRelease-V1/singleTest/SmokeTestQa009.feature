Feature: Test009: Check Navigation Is Working Across CH Operator Pages

Scenario Outline: Test009: QA - Check Navigation Is Working Across CH Operator Pages
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch operator qa
		Then check page navigation is correctly working <menu-id>
		Then close the driver
		
		Examples:
			|browser |menu-id               |
			|"Chrome"|"ctl00_NavigationMenu"|