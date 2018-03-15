Feature: Test027: Check Elements Are Enabled on CMS Fleet Report Page - CMS Admin

	Scenario Outline: Test027: QA - Check Elements Are Enabled on CMS Fleet Report Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then move to the page <menuId> <page-address>
		Then check for table input <fleet-table>
		Then check the element exists <export-button>
		Then close the driver
		
		Examples:
			|browser |menuId                |page-address                                        |fleet-table                        |export-button                    |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetReport.aspx"|"ctl00_MainContent_grdFleetReports"|"ctl00_MainContent_btExportToCSV"|