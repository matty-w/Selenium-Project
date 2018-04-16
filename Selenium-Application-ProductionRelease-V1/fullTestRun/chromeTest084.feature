Feature: Test084: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator

	Scenario Outline: Test084: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then check for table input <analysis-list-table>
		Then close the driver
		
		Examples:
			|browser |analysis-list-table                       |
			|"Chrome"|"ctl00_MainContent_grdOutstandingAnalysis"|