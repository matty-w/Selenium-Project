Feature: Test066: Check Elements Are Enabled on Outstanding Analysis Page  - CMS Supervisor : Incident Details - Collision Report

Scenario Outline: Test066: Check Elements Are Enabled on Outstanding Analysis Page  - CMS Supervisor : Incident Details - Collision Report
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then move to the page <menuId> <assigned-page>
		Then click the element <assign-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-report-tab>
		Then click the element <collision-report-tab>
		Then check for table input <collision-table>
		Then check the element exists <add-collision-button>
		Then click the element <add-collision-button>
		Then check for table input <comment-table>
		Then check the element exists <comment-save>
		Then check the element exists <comment-cancel>
		Then click the element <comment-cancel>
		Then check the element exists <incident-details-tab>
		Then click the element <incident-details-tab>
		Then check the element exists <unassign-button>
		Then click the element <unassign-button>
		Then close the driver

		Examples:
			|browser |menuId                |assigned-page                                       |assign-button                                             |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-report-tab                                            |unassign-button                                                                         |collision-table                                                                                |add-collision-button                                                                              |comment-table                   |comment-cancel                                                                                        |comment-save                                                                                       |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSAnalystHome.aspx"|"ctl00_MainContent_grdOutstandingAnalysis_ctl02_btnAssign"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_grdCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnAddCollisionReport"|"tblCollisionReportPopupComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnCancelCollisionComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport_ucCollisionReport_btnAddCollisionComment"|