Feature: Test035: Check Elements Are Enabled on Assessment Report Tesco Page - CMS Admin

	Scenario Outline: Test035: Check Elements Are Enabled on Assessment Report Tesco Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised 
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then move to the page <menuId> <page-address>
		Then check for table input <report-table>
		Then check the element exists <filter-button>
		Then close the driver
		
		Examples:
			|browser |menuId                |page-address                                                                                          |report-table                  |filter-button                |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/DeterminationPerformanceReport.aspx?FleetFilter=Tesco&AutoSelect=true"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_btnFilter"|