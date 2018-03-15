Feature: Test021: Check Navigation Across RR Supervisor Is Working

Scenario Outline: Test021: QA - Check Navigation Across RR Supervisor Is Working
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr supervisor qa
		Then check page navigation is correctly working <menuId>
		Then close the driver

		Examples:
			|browser |menuId                |
			|"Chrome"|"ctl00_NavigationMenu"|