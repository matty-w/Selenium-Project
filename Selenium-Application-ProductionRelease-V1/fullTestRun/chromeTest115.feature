Feature: Test115: Check Elements Are Enabled on Closed Claims Handler Incidents Page - CH Operator : View - Overview

Scenario Outline: Test115: Check Elements Are Enabled on Closed Claims Handler Incidents Page - CH Operator : View - Overview
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
		Then check for table input <actions-table>
		Then check for table input <response-table>
		Then check the element exists <add-response-button>
		Then click the element <add-response-button>
		Then check for table input <comment-table>
		Then check the element exists <comment-cancel>
		Then check the element exists <comment-save>
		Then click the element <comment-cancel>
		Then close the driver
		
		Examples:
			|browser |menuId                |closed-page                                               |action-button                                      |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-tab                                                   |evidence-capture-tab                                                |actions-table|response-table                                                                    |add-response-button                                                                     |comment-table       |comment-cancel                                                                     |comment-save                                                                    |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/ClosedClaimIncidents.aspx"|"ctl00_MainContent_grdClosedFNOLList_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"tblActions" |"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_grdResponsesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddResponseOverview"|"tblResponseComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnCancelOverview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddOverview"|