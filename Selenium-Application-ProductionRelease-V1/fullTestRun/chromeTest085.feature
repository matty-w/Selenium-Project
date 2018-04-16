Feature: Test085: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator : Overview

	Scenario Outline: Test085: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator : Overview
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then click the element <assign-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then check for table input <unassign-table>
		Then check for table input <response-table>
		Then click the element <add-response-button>
		Then check for table input <comment-table>
		Then check the element exists <add-response-cancel>
		Then check the element exists <ar-button>
		Then click the element <add-response-cancel>
		Then click the element <unassign-button>
		Then close the driver
		
		Examples:
			|browser |assign-button                                             |unassign-table|unassign-button                                                              |response-table                                                                    |add-response-button                                                                     |add-response-cancel                                                                |ar-button                                                                       |comment-table       |overview-tab                                             |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |
			|"Chrome"|"ctl00_MainContent_grdOutstandingAnalysis_ctl02_btnAssign"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_grdResponsesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddResponseOverview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnCancelOverview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddOverview"|"tblResponseComment"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|