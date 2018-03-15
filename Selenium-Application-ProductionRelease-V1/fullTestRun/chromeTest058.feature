Feature: Test058: Check Elements Are Enabled on Assigned Analysis Page  - CMS Supervisor : Incident Details - Evidence

Scenario Outline: Test058: Check Elements Are Enabled on Assigned Analysis Page  - CMS Supervisor : Incident Details - Evidence
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then move to the page <menuId> <assigned-page>
		Then click the element <incident-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then click the element <evidence-tab>
		Then check for table input <evidence-table>
		Then close the driver

		Examples:
			|browser |menuId                |assigned-page                                            |incident-button                                     |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-tab                                                   |evidence-table                                                                   |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AnalystAssignedList.aspx"|"ctl00_MainContent_grdAssignedAnalyst_ctl02_btnView"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_grdEvidencesList"|