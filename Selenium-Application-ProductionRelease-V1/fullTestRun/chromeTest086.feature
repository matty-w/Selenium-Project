Feature: Test086: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator : Incident Details

	Scenario Outline: Test086: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator : Incident Details
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then click the element <assign-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then click the element <incident-tab>
		Then check for table input <unassign-table>
		Then check for table input <response-table>
		Then click the element <unassign-button>
		Then close the driver
		
		Examples:
			|browser |assign-button                                             |unassign-table|unassign-button                                                                         |response-table                                                                               |comment-table       |overview-tab                                             |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |
			|"Chrome"|"ctl00_MainContent_grdOutstandingAnalysis_ctl02_btnAssign"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_grdResponsesList"|"tblResponseComment"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|