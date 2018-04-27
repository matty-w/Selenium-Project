Feature: Test077: QA - Check Elements Are Enabled on Claim Incident Audit Trail Page - CH Supervisor : Action - Collision Report

Scenario Outline: Test077: QA - Check Elements Are Enabled on Claim Incident Audit Trail Page - CH Supervisor : Action - Collision Report
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
		Then click the element <collision-tab>
		Then check for table input <correspondent-table>
		Then check the element exists <add-comment-button>
		Then click the element <add-comment-button>
		Then check for table input <comment-table>
		Then check the element exists <comment-cancel>
		Then check the element exists <comment-save>
		Then click the element <comment-cancel>
		Then close the driver
		
		Examples:
			|browser |navigation-menu       |action-button                                        |unassign-button                                                              |overview-tab                                           |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |evidence-capture-tab                                                |correspondent-table                                                                            |add-comment-button                                                                                |comment-table                   |comment-cancel                                                                                        |comment-save                                                                                       |
			|"Chrome"|"ctl00_NavigationMenu"|"ctl00_MainContent_grdFNOLIncidentList_ctl02_btnview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_tab"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_grdCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnAddCollisionReport"|"tblCollisionReportPopupComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnCancelCollisionComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnAddCollisionComment"|
