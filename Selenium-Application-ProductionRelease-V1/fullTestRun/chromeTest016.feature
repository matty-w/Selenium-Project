Feature: Test016: Check Navigation Inputs Are Visible and Enabled For CMS Operator

	Scenario Outline: Test016: QA - Check Navigation Inputs Are Visible and Enabled For CMS Supervisor
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then check page navigation is correctly working <menu-id>
		Then close the driver
		
		Examples:
		 |browser |menu-id               |
		 |"Chrome"|"ctl00_NavigationMenu"|