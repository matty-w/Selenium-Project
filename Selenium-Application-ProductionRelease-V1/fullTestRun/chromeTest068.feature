Feature: Test068: Check Elements Are Enabled on Claim Incident Audit Trail Page - CH Supervisor : Action - Overview

Scenario Outline: Test068: Check Elements Are Enabled on Claim Incident Audit Trail Page - CH Supervisor : Action - Overview
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch supervisor qa
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then check the element exists <evidence-capture-tab>
		Then check for table input <unassign-table>
		Then check for table input <response-table>
		Then check the element exists <add-response-button>		
		Then click the element <add-response-button>
		Then check for table input <comment-table>
		Then check the element exists <add-response-cancel>
		Then check the element exists <add-response-save>
		Then click the element <add-response-cancel>
		Then click the element <unassign-button>
		Then close the driver
		
		Examples:
			|browser |navigation-menu       |action-button                                        |unassign-button                                                              |overview-tab                                           |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |evidence-capture-tab                                                |unassign-table|response-table                                                                    |add-response-button                                                                     |comment-table       |add-response-cancel                                                                |add-response-save                                                               |
			|"Chrome"|"ctl00_NavigationMenu"|"ctl00_MainContent_grdFNOLIncidentList_ctl02_btnview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_tab"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_grdResponsesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddResponseOverview"|"tblResponseComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnCancelOverview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddOverview"|
