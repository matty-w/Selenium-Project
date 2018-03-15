Feature: Test014: Check Navigation Inputs Are Visible and Enabled (CMS Admin)

	Scenario Outline: Test014: QA - Check Navigation Inputs Are Visible and Enabled (CMS Admin)
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then check page navigation is correctly working <menu-id>
		Then close the driver
		
		Examples:
		 |browser |menu-id               |
		 |"Chrome"|"ctl00_NavigationMenu"|