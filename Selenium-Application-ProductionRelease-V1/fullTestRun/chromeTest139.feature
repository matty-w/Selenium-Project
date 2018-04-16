Feature: Test139: Check Elements Are Enabled on Closed FNOL Incidents - RR Operator : View - Evidence

Scenario Outline: Test139: Check Elements Are Enabled on Closed FNOL Incidents - RR Operator : View - Evidence
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr operator qa
		Then move to the page <menuId> <assigned-page>
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then click the element <evidence-tab>
		Then check the element exists <evidence-capture-tab>
		Then check for table input <evidence-table>
		Then close the driver

		Examples:
			|browser |menuId                |assigned-page                                            |action-button                                      |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |evidence-capture-tab                                                |evidence-table                                                                   |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/ClosedFNOLIncidents.aspx"|"ctl00_MainContent_grdClosedFNOLList_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_grdEvidencesList"|