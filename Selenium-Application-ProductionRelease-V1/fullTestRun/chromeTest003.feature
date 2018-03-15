Feature: Test003: Textbox Test

	Scenario Outline: Test003: QA - Navigate to DriveGuard, test the login textboxes, and then close the browser
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then type into textbox <textbox-element> <textbox-value>
		Then type into textbox <textbox-element2> <textbox-value>
		Then close the driver
		
	Examples:
	|browser        |textbox-element   |textbox-value|textbox-element2|	
	|"Chrome"       |"txtEmail"        |"test"       |"txtPassword"   | 
	                