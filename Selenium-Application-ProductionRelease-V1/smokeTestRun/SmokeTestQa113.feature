Feature: Test113: QA - Check Elements Are Enabled on Crash Audit Report Page - CMS Admin

	Scenario Outline: Test113: QA - Check Elements Are Enabled on Crash Audit Report Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then move to the page <menuId> <page-address>
		Then check for table input <fleet-table>
		Then check the element exists <export-pdf-button>
		Then check the element exists <export-csv-button>
		Then close the driver
		
		Examples:
			|browser |menuId                |page-address                                        |fleet-table                        |export-pdf-button                 |export-csv-button                |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSCrashReport.aspx"|"ctl00_MainContent_grdCrashReports"|"ctl00_MainContent_btnExportToPDF"|"ctl00_MainContent_btExportToCSV"|