Feature: Test112: QA - Check Elements Are Enabled on Crash Confirmation Page - CMS Admin

	Scenario Outline: Test112: QA - Check Elements Are Enabled on Crash Confirmation Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then move to the page <menuId> <page-address>
		Then check for table input <filter-table>
		Then check the element exists <filter-button>
		Then close the driver
		
		Examples:
			|browser |menuId                |page-address                                                  |filter-table                  |filter-button                |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSConfirmedCrashManager.aspx"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_btnFilter"|