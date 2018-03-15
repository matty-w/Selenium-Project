Feature: Test017: Check Page Navigation Is Working Across The CH Admin Pages

Scenario Outline: Test017: QA - Check Page Navigation Is Working Across The CH Admin Pages
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch admin qa
		Then check page navigation is correctly working <navigation-menu>
		Then close the driver
		
		Examples:
			|browser |navigation-menu       |
			|"Chrome"|"ctl00_NavigationMenu"|
