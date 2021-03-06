Feature: Test108: Check Elements Are Enabled on Assigned Claims Handler Incidents Page - CH Operator : Action - Evidence

Scenario Outline: Test108: Check Elements Are Enabled on Assigned Claims Handler Incidents Page - CH Operator : Action - Evidence
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch operator qa
		Then move to the page <menuId> <assigned-page>
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then check the element exists <evidence-capture-tab>
		Then click the element <evidence-tab>
		Then check for table input <evidence-table>
		Then check the element exists <add-evidence-button>
		Then click the element <add-evidence-button>
		Then check for table input <add-evidence-table>
		Then check the element exists <add-evidence-cancel>
		Then check the element exists <add-evidence-save>
		Then click the element <add-evidence-cancel>
		Then close the driver
		
		Examples:
			|browser |menuId                |assigned-page                                                 |action-button                                        |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-tab                                                   |evidence-capture-tab                                                |evidence-table                                                                   |add-evidence-button                                                            |add-evidence-table        |add-evidence-cancel                                                       |add-evidence-save                                                      |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AssignedClaimHandlerList.aspx"|"ctl00_MainContent_grdAssignedFNOLList_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_grdEvidencesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnAddEvidence"|"tblEvidencesPopupDetails"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnCancel"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnAdd"|