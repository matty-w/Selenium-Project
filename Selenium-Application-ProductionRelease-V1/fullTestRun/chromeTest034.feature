Feature: Test034: Check Elements Are Enabled on Assessment Report Raw Page - CMS Admin

	Scenario Outline: Test034: QA - Check Elements Are Enabled on Assessment Report Raw Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then move to the page <menuId> <page-address>
		Then check for table input <report-table>
		Then check the element exists <filter-button>
		Then close the driver
		
		Examples:
			|browser |menuId                |page-address                                                        |report-table                  |filter-button                |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/DeterminationPerformanceReport.aspx"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_btnFilter"|