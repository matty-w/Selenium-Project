Feature: Test055: Check Elements Are Enabled on Assigned Analysis Page - CMS Supervisor

Scenario Outline: Test055: Check Elements Are Enabled on Assigned Analysis Page - CMS Supervisor
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then move to the page <menuId> <assigned-page>
		Then check for table input <assigned-table>
		Then close the driver

		Examples:
			|browser |menuId                |assigned-page                                            |assigned-table                        |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AnalystAssignedList.aspx"|"ctl00_MainContent_grdAssignedAnalyst"|