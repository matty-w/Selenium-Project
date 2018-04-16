Feature: Test128: Check Assigned FNOL Incidents Elements - RR Operator

Scenario Outline: Test128: Check Assigned FNOL Incidents Elements - RR Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr operator qa
		Then move to the page <menuId> <assigned-page>
		Then check for table input <assigned-table>
		Then check the element exists <create-incident-button>
		Then click the element <create-incident-button>
		Then check for table input <create-incident-table> <tag>
		Then check the element exists <create-incident-cancel>
		Then check the element exists <create-incident-next>
		Then click the element <create-incident-cancel>
		Then close the driver

		Examples:
			|browser |tag    |menuId                |assigned-page                                         |assigned-table                         |create-incident-button                     |create-incident-table|create-incident-cancel                        |create-incident-next                        |
		  |"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AssignedFNOLList.aspx"|"ctl00_MainContent_grdAssignedFNOLList"|"ctl00_MainContent_btnCreateManualIncident"|"innertableComment"  |"ctl00_MainContent_ucManualIncident_btnCancel"|"ctl00_MainContent_ucManualIncident_btnNext"|