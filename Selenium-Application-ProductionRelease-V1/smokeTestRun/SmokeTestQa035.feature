Feature: Test035: Impersonate RR Operator, Check Elements On Closed FNOL Incidents - RR Admin

Scenario Outline: Test035: QA - Impersonate RR Operator, Check Elements On Closed FNOL Incidents - RR Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then impersonate user <original-user> <user-to-impersonate> <expected-page>
		Then move to the page <menuId> <closed-page>
		Then check for table input <filter-table>
		Then check the element exists <filter-button>
		Then check for table input <closed-table>
		Then click the element <revert-button>
		Then close the driver

		Examples:
			|browser |tag    |menuId                |original-user|user-to-impersonate|expected-page                                          |closed-page                                              |filter-table                  |filter-button                |closed-table                         |revert-button    |
		  |"Chrome"|"class"|"ctl00_NavigationMenu"|"rr admin"   |"rr operator"      |"https://qa.cmsdriveguard.co.uk/FleetOperatorHome.aspx"|"https://qa.cmsdriveguard.co.uk/ClosedFNOLIncidents.aspx"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_btnFilter"|"ctl00_MainContent_grdClosedFNOLList"|"ctl00_btnLogOut"|