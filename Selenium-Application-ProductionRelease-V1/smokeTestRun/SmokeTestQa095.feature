Feature: Test095: QA - Check Elements Are Enabled on Closed Claims Handler Incidents Page - CH Operator

Scenario Outline: Test095: QA - Check Elements Are Enabled on Closed Claims Handler Incidents Page - CH Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch operator qa
		Then move to the page <menuId> <closed-page>
		Then check for table input <filter-table>
		Then check the element exists <filter-button>
		Then check for table input <closed-table>
		Then close the driver
		
		Examples:
			|browser |menuId                |closed-page                                               |filter-table                  |filter-button                |closed-table                         |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/ClosedClaimIncidents.aspx"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_btnFilter"|"ctl00_MainContent_grdClosedFNOLList"|