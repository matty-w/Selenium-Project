Feature: Test105: Check Elements Are Enabled on Assigned Claims Handler Incidents Page - CH Operator 

Scenario Outline: Test105: Check Elements Are Enabled on Assigned Claims Handler Incidents Page - CH Operator 
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch operator qa
		Then move to the page <menuId> <assigned-page>
		Then check for table input <assigned-table>
		Then close the driver
		
		Examples:
			|browser |menuId                |assigned-page                                                 |assigned-table                         |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AssignedClaimHandlerList.aspx"|"ctl00_MainContent_grdAssignedFNOLList"|