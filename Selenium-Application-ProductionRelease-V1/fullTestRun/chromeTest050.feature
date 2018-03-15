Feature: Test050: Check Elements Are Enabled on Analysis Audit Trail Page - CMS Supervisor : Incident Details - Incident Details

Scenario Outline: Test050: Check Elements Are Enabled on Analysis Audit Trail Page - CMS Supervisor : Incident Details - Incident Details
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then click the element <incident-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-report-tab>
		Then click the element <incident-details-tab>
		Then check for table input <unassign-table>
		Then check for table input <response-table>
		Then check the element exists <add-response-button>
		Then click the element <add-response-button>
		Then check for table input <comment-table>
		Then check the element exists <comment-save>
		Then check the element exists <comment-cancel>
		Then click the element <comment-cancel>
		Then close the driver

		Examples:
			|browser |incident-button                                        |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-report-tab                                            |unassign-table|response-table                                                                               |add-response-button                                                                        |comment-table       |comment-cancel                                                                        |comment-save                                                                       |
		  |"Chrome"|"ctl00_MainContent_grdAnalysisAuditTrail_ctl02_btnView"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_grdResponsesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnAddResponse"|"tblResponseComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnCancel"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnAdd"|