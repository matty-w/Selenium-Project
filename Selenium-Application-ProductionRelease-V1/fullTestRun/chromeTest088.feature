Feature: Test088: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator : Collision Report

	Scenario Outline: Test088: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator : Collision Report
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then click the element <assign-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then click the element <collision-tab>
		Then check for table input <correspondant-table>
		Then check the element exists <collision-comment-button>
		Then click the element <collision-comment-button>
		Then check for table input <collision-comment-table>
		Then check the element exists <collision-comment-cancel>
		Then check the element exists <add-comment-button>
		Then click the element <collision-comment-cancel>
		Then click the element <incident-tab>
		Then click the element <unassign-button>
		Then close the driver
		
		Examples:
			|browser |assign-button                                             |unassign-button                                                                         |correspondant-table                                                                            |collision-comment-button                                                                          |collision-comment-table         |collision-comment-cancel                                                                              |add-comment-button                                                                                 |overview-tab                                             |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |
			|"Chrome"|"ctl00_MainContent_grdOutstandingAnalysis_ctl02_btnAssign"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_grdCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnAddCollisionReport"|"tblCollisionReportPopupComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnCancelCollisionComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnAddCollisionComment"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|