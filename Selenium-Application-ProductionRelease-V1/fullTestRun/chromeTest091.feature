Feature: Test091: Check The Assigned Analysis Elements (Incident Details) Are Enabled On Assigned Analysis Page (Incident Details) - CMS Operator

Scenario Outline: Test091: Check The Assigned Analysis Elements (Incident Details) Are Enabled On Assigned Analysis Page (Incident Details) - CMS Operator
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
		Then click the element <incident-tab>
		Then check for table input <unassign-table>
		Then check for table input <response-table>
		Then close the driver
		
		Examples:
			|browser |nav-menu-id           |assigned-analysis-page                                   |analysis-list-table                   |incident-button                                     |overview-tab                                             |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |unassign-table|response-table                                                                    |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AnalystAssignedList.aspx"|"ctl00_MainContent_grdAssignedAnalyst"|"ctl00_MainContent_grdAssignedAnalyst_ctl02_btnView"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_grdResponsesList"|
