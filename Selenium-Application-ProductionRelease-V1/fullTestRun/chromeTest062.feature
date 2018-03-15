Feature: Test062: Check Elements Are Enabled on Outstanding Analysis Page - CMS Supervisor

Scenario Outline: Test062: Check Elements Are Enabled on Outstanding Analysis Page - CMS Supervisor
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then move to the page <menuId> <assigned-page>
		Then check for table input <outstanding-table>
		Then close the driver

		Examples:
			|browser |menuId                |assigned-page                                       |outstanding-table                         |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSAnalystHome.aspx"|"ctl00_MainContent_grdOutstandingAnalysis"|