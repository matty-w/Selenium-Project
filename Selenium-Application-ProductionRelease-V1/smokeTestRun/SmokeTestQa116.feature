Feature: Test116: QA - Check Elements Are Enabled on Video Viewer Page - CMS Admin

	Scenario Outline: Test116: QA - Check Elements Are Enabled on Video Viewer Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then move to the page <menuId> <page-address>
		Then check for table input <video-table>
		Then check the element exists <filter-button>
		Then close the driver
		
		Examples:
			|browser |menuId                |page-address                                     |video-table                   |filter-button                |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/VideoViewer.aspx"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_btnFilter"|