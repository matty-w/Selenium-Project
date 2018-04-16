Feature: Test123: Check Elements Are Enabled on Outstanding FNOL Incidents Page - RR Operator : Action - Evidence

Scenario Outline: Test123: Check Elements Are Enabled on Outstanding FNOL Incidents Page - RR Operator : Action - Evidence
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr operator qa
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <evidence-capture-tab>
		Then click the element <evidence-tab>
		Then check for table input <evidence-table>
		Then check the element exists <add-evidence-button>
		Then click the element <add-evidence-button>
		Then check for table input <add-evidence-table>
		Then check the element exists <add-evidence-cancel>
		Then check the element exists <add-evidence-save>
		Then click the element <add-evidence-cancel>
		Then check the element exists <incident-details-tab>
		Then click the element <incident-details-tab>
		Then check the element exists <unassign-button>
		Then click the element <unassign-button>
		Then close the driver

		Examples:
			|browser |action-button                                   |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |evidence-capture-tab                                                |unassign-button                                                                         |evidence-table                                                                   |add-evidence-button                                                            |add-evidence-table        |add-evidence-cancel                                                       |add-evidence-save                                                      |
		  |"Chrome"|"ctl00_MainContent_grdNewFNOLData_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_grdEvidencesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnAddEvidence"|"tblEvidencesPopupDetails"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnCancel"|"ctl00_MainContent_tcIncidnetDetails_tbpnlevidences_ucEvidences_btnAdd"|