Feature: Test065: Check Elements Are Enabled on Outstanding Analysis Page  - CMS Supervisor : Incident Details - Evidence

Scenario Outline: Test065: Check Elements Are Enabled on Outstanding Analysis Page  - CMS Supervisor : Incident Details - Evidence
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
		Then click the element <evidence-tab>
		Then check for table input <evidence-table>
		Then check the element exists <incident-details-tab>
		Then click the element <incident-details-tab>
		Then check the element exists <unassign-button>
		Then click the element <unassign-button>
		Then close the driver

		Examples:
			|browser |menuId                |assigned-page                                       |assign-button                                             |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-report-tab                                            |unassign-button                                                                         |evidence-table                                                                   |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSAnalystHome.aspx"|"ctl00_MainContent_grdOutstandingAnalysis_ctl02_btnAssign"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_grdEvidencesList"|