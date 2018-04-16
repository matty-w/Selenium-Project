Feature: Test137: Check Elements Are Enabled on Closed FNOL Incidents - RR Operator : View - Overview

Scenario Outline: Test137: Check Elements Are Enabled on Closed FNOL Incidents - RR Operator : View - Overview
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr operator qa
		Then move to the page <menuId> <assigned-page>
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <evidence-capture-tab>
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
			|browser |menuId                |assigned-page                                            |action-button                                      |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |evidence-capture-tab                                                |unassign-table|response-table                                                                    |add-response-button                                                                     |comment-table       |comment-cancel                                                                        |comment-save                                                                       |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/ClosedFNOLIncidents.aspx"|"ctl00_MainContent_grdClosedFNOLList_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_grdResponsesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddResponseOverview"|"tblResponseComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnCancel"|"ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails_ucIncidentDetails_btnAdd"|