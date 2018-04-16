Feature: Test092: Check The Assigned Analysis Elements (Evidence) Are Enabled On Assigned Analysis Page (Evidence) - CMS Operator

Scenario Outline: Test092: Check The Assigned Analysis Elements (Evidence) Are Enabled On Assigned Analysis Page (Evidence) - CMS Operator
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
		Then click the element <evidence-tab>
		Then check for table input <evidence-table>
		Then check the element exists <add-evidence-button>
		Then click the element <add-evidence-button>
		Then check for table input <evidence-popup-table>
		Then check the element exists <evidence-popup-cancel>
		Then check the element exists <commit-evidence-button>
		Then click the element <evidence-popup-cancel>
		Then close the driver
		
		Examples:
			|browser |nav-menu-id           |assigned-analysis-page                                   |analysis-list-table                   |incident-button                                     |overview-tab                                             |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |evidence-table                                                                   |add-evidence-button                                                            |evidence-popup-table      |evidence-popup-cancel                                                     |commit-evidence-button                                                 |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AnalystAssignedList.aspx"|"ctl00_MainContent_grdAssignedAnalyst"|"ctl00_MainContent_grdAssignedAnalyst_ctl02_btnView"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_grdEvidencesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnAddEvidence"|"tblEvidencesPopupDetails"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnCancel"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnAdd"|
