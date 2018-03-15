Feature: Test001: open browser

	Scenario Outline: Test001: Open the chrome browser, maximise, and then close
		Given The driver is open <browser>
		When The window is maximised
		Then close the driver
		
	Examples:
	|browser |
	|"Chrome"|
		
