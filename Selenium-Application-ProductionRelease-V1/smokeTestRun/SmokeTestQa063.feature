Feature: Test063: QA - Check Elements Are Enabled on Closed FNOL Incidents - RR Operator

Scenario Outline: Test063: QA - Check Elements Are Enabled on Closed FNOL Incidents - RR Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr operator qa
		Then move to the page <menuId> <closed-page>
		Then check for table input <filter-table>
		Then check the element exists <filter-button>
		Then check for table input <closed-table>
		Then close the driver

		Examples:
			|browser |tag    |menuId                |closed-page                                              |filter-table                  |filter-button                |closed-table                         |
		  |"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/ClosedFNOLIncidents.aspx"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_btnFilter"|"ctl00_MainContent_grdClosedFNOLList"|