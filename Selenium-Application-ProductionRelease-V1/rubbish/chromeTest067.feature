Feature: Test068: Check Claim Incident Audit Trail Elements (Proximity Report) Are Visible On The Page - CH Supervisor

Scenario Outline: Test068: Check Claim Incident Audit Trail Elements (Proximity Report) Are Visible On The Page - CH Supervisor
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard
		Then log in as ch supervisor
		Then click the element <proximity-report>
		Then check for table input <proximity-table>
		Then check the element exists <proximity-cancel>
		Then check the element exists <commit-report-button>
		Then click the element <proximity-cancel>
		Then close the driver
		
		Examples:
			|browser |navigation-menu       |proximity-report     |proximity-table         |proximity-cancel             |commit-report-button         |
			|"Chrome"|"ctl00_NavigationMenu"|"lnkAccidentAnalysis"|"tblAnalystAssignedList"|"ctl00_MainContent_btnCancel"|"ctl00_MainContent_btnCommit"|
