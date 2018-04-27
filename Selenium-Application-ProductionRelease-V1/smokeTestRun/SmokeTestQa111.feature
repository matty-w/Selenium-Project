Feature: Test111: QA - Check Elements Are Enabled on Device Report Page - CMS Admin

	Scenario Outline: Test111: QA - Check Elements Are Enabled on Device Report Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then move to the page <menuId> <page-address>
		Then check for table input <filter-table>
		Then check for table input <device-table>
		Then check the element exists <export-button>
		Then check the element exists <filter-button>
		Then close the driver
		
		Examples:
			|browser |menuId                |page-address                                         |filter-table              |device-table                        |export-button                    |filter-button                |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSDeviceReport.aspx"|"tblCMSDeviceReportFilter"|"ctl00_MainContent_grdDeviceReports"|"ctl00_MainContent_btExportToCSV"|"ctl00_MainContent_btnFilter"|