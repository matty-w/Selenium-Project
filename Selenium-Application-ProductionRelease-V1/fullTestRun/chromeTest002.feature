Feature: Test002: Web Address Test

	Scenario Outline: Test002: QA - Open the chrome browser, navigate to DriveGuard, and close the browser
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then close the driver
		
	Examples:
	|browser        |
	|"Chrome"       |