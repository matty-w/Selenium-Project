Feature: Test067: Check Elements Are Enabled on Claim Incident Audit Trail Page - CH Supervisor

Scenario Outline: Test067: Check Elements Are Enabled on Claim Incident Audit Trail Page - CH Supervisor
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch supervisor qa
		Then check for table input <filter-table>
		Then check for table input <audit-trail-table>
		Then check the element exists <filter-button>
		Then close the driver
		
		Examples:
			|browser |navigation-menu       |filter-table                  |audit-trail-table                      |filter-button                |
			|"Chrome"|"ctl00_NavigationMenu"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_grdFNOLIncidentList"|"ctl00_MainContent_btnFilter"|
