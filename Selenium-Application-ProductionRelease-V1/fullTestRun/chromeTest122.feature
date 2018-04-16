Feature: Test122: Check Elements Are Enabled on Outstanding FNOL Incidents Page - RR Operator : Action - Incident Details

Scenario Outline: Test122: Check Elements Are Enabled on Outstanding FNOL Incidents Page - RR Operator : Action - Incident Details
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr operator qa
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <evidence-capture-tab>
		Then click the element <incident-details-tab>
		Then check for table input <unassign-table>
		Then check for table input <response-table>
		Then check the element exists <add-response-button>
		Then click the element <add-response-button>
		Then check for table input <comment-table>
		Then check the element exists <comment-save>
		Then check the element exists <comment-cancel>
		Then click the element <comment-cancel>
		Then click the element <unassign-button>
		Then close the driver

		Examples:
			|browser |action-button                                   |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |evidence-capture-tab                                                |unassign-table|response-table                                                                               |add-response-button                                                                        |comment-table       |comment-cancel                                                                        |comment-save                                                                       |unassign-button                                                                         |
		  |"Chrome"|"ctl00_MainContent_grdNewFNOLData_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_grdResponsesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnAddResponse"|"tblResponseComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnCancel"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnAdd"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnUnassign"|