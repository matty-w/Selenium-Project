Feature: Test093: Check The Assigned Analysis Elements (Collision) Are Enabled On Assigned Analysis Page (Collision) - CMS Operator

Scenario Outline: Test093: Check The Assigned Analysis Elements (Collision) Are Enabled On Assigned Analysis Page (Collision) - CMS Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then move to the page <nav-menu-id> <assigned-analysis-page> 
		Then click the element <incident-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then click the element <collision-tab>
		Then check for table input <correspondant-table>
		Then check the element exists <add-collision-button>
		Then click the element <add-collision-button>
		Then check for table input <add-collision-table>
		Then check the element exists <add-collision-cancel>
		Then check the element exists <add-comment-button>
		Then click the element <add-collision-cancel>
		Then close the driver
		
		Examples:
			|browser |nav-menu-id           |assigned-analysis-page                                   |analysis-list-table                   |incident-button                                     |overview-tab                                             |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |evidence-table                                                                   |correspondant-table                                                                            |add-collision-button                                                                              |add-collision-table             |add-collision-cancel                                                                                  |add-comment-button                                                                                 |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AnalystAssignedList.aspx"|"ctl00_MainContent_grdAssignedAnalyst"|"ctl00_MainContent_grdAssignedAnalyst_ctl02_btnView"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_grdEvidencesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_grdCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnAddCollisionReport"|"tblCollisionReportPopupComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnCancelCollisionComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnAddCollisionComment"|
