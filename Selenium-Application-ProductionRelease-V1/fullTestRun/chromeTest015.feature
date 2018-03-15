Feature: Test015: Check Navigation Inputs Are Visible and Enabled (CMS Supervisor)

	Scenario Outline: Test015: QA - Check Navigation Inputs Are Visible and Enabled (CMS Supervisor)
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then check page navigation is correctly working <menu-id>
		Then close the driver
		
		Examples:
		 |browser |menu-id               |
		 |"Chrome"|"ctl00_NavigationMenu"|