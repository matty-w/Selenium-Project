Feature: Test094: Check The Assigned Analysis Elements (Proximity Report) Are Enabled On Assigned Analysis Page (Proximity Report) - CMS Operator

Scenario Outline: Test094: Check The Assigned Analysis Elements (Proximity Report) Are Enabled On Assigned Analysis Page (Proximity Report) - CMS Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then move to the page <nav-menu-id> <assigned-analysis-page> 
		Then click the element <proximity-button>
		Then check for table input <proximity-table>
		Then check the element exists <proximity-cancel>
		Then check the element exists <proximity-commit-button>
		Then click the element <proximity-cancel>
		Then close the driver
		
		Examples:
			|browser |nav-menu-id           |assigned-analysis-page                                   |analysis-list-table                   |proximity-button     |proximity-table         |proximity-cancel             |proximity-commit-button      |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AnalystAssignedList.aspx"|"ctl00_MainContent_grdAssignedAnalyst"|"lnkAccidentAnalysis"|"tblAnalystAssignedList"|"ctl00_MainContent_btnCancel"|"ctl00_MainContent_btnCommit"|
