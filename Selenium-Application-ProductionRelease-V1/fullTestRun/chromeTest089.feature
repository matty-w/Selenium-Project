Feature: Test089: Check The Assigned Analysis Elements Are Enabled On Assigned Analysis Page - CMS Operator

Scenario Outline: Test089: Check The Outstanding Analysis Elements Are Enabled On Outstanding Analysis Page - CMS Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then move to the page <nav-menu-id> <assigned-analysis-page> 
		Then check for table input <analysis-list-table>
		Then close the driver
		
		Examples:
			|browser |nav-menu-id           |assigned-analysis-page                                   |analysis-list-table                   |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AnalystAssignedList.aspx"|"ctl00_MainContent_grdAssignedAnalyst"|
