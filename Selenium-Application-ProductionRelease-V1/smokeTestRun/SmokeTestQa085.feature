Feature: Test085: QA - Check Elements Are Enabled on Outstanding Claims Handler Incidents Page - CH Operator

Scenario Outline: Test085: QA - Check Elements Are Enabled on Outstanding Claims Handler Incidents Page - CH Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch operator qa
		Then check for table input <claims-table>
		Then close the driver
		
		Examples:
			|browser |claims-table                      |
			|"Chrome"|"ctl00_MainContent_grdNewFNOLData"|