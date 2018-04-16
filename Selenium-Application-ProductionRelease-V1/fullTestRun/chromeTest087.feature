Feature: Test087: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator : Evidence

	Scenario Outline: Test087: Check Elements Are Enabled on Outstanding Analysis Page - CMS Operator : Evidence
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms operator qa
		Then click the element <assign-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then click the element <evidence-tab>
		Then check for table input <evidence-table>
		Then check the element exists <evidence-button>
		Then click the element <evidence-button>
		Then check for table input <add-evidence-table>
		Then check the element exists <evidence-cancel-button>
		Then check the element exists <commit-evidence-button>
		Then click the element <evidence-cancel-button>
		Then click the element <incident-tab>
		Then click the element <unassign-button>
		Then close the driver
		
		Examples:
			|browser |assign-button                                             |unassign-button                                                                         |evidence-table                                                                   |evidence-button                                                                |add-evidence-table            |evidence-cancel-button                                                    |commit-evidence-button                                                 |overview-tab                                             |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |
			|"Chrome"|"ctl00_MainContent_grdOutstandingAnalysis_ctl02_btnAssign"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_grdEvidencesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnAddEvidence"|"tblEvidencesPopupDetails"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnCancel"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnAdd"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|