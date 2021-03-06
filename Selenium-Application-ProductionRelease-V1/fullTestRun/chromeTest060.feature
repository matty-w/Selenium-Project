Feature: Test060: Check Elements Are Enabled on Assigned Analysis Page - CMS Supervisor : Proximity Report

Scenario Outline: Test060: Check Elements Are Enabled on Assigned Analysis Page - CMS Supervisor : Proximity Report
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then move to the page <menuId> <assigned-page>
		Then click the element <proximity-button>
		Then check for table input <proximity-table>
		Then check the element exists <proximity-cancel>
		Then check the element exists <proximity-save>
		Then close the driver

		Examples:
			|browser |menuId                |assigned-page                                            |proximity-button     |proximity-table               |proximity-cancel             |proximity-save               |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AnalystAssignedList.aspx"|"lnkAccidentAnalysis"|"tblProximityReportParameters"|"ctl00_MainContent_btnCancel"|"ctl00_MainContent_btnCommit"|