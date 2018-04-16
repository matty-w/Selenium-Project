Feature: Test118: Check Elements Are Enabled on Closed Claims Handler Incidents Page - CH Operator : View - Collision Report

Scenario Outline: Test118: Check Elements Are Enabled on Closed Claims Handler Incidents Page - CH Operator : View - Collision Report
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch operator qa
		Then move to the page <menuId> <closed-page>
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then check the element exists <evidence-capture-tab>
		Then click the element <collision-tab>
		Then check for table input <collision-table>
		Then close the driver
		
		Examples:
			|browser |menuId                |closed-page                                               |action-button                                      |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-tab                                                   |evidence-capture-tab                                                |collision-table                                                                                 |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/ClosedClaimIncidents.aspx"|"ctl00_MainContent_grdClosedFNOLList_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_grdCollisionReport"|