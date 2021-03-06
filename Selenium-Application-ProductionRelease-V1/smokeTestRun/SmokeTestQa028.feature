Feature: Test028: Impersonate RR Operator, Check Elements On Assigned FNOL Incidents : Overview - RR Admin

Scenario Outline: Test028: QA - Impersonate RR Operator, Check Elements On Assigned FNOL Incidents : Overview - RR Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then impersonate user <original-user> <user-to-impersonate> <expected-page>
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
			|browser |menuId                |original-user|user-to-impersonate|expected-page                                          |assigned-page                                         |action-button                                        |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |evidence-capture-tab                                                |unassign-table|response-table                                                                    |add-response-button                                                                     |comment-table       |comment-cancel                                                                     |comment-save                                                                    |
		  |"Chrome"|"ctl00_NavigationMenu"|"rr admin"   |"rr operator"      |"https://qa.cmsdriveguard.co.uk/FleetOperatorHome.aspx"|"https://qa.cmsdriveguard.co.uk/AssignedFNOLList.aspx"|"ctl00_MainContent_grdAssignedFNOLList_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_grdResponsesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddResponseOverview"|"tblResponseComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnCancelOverview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddOverview"|