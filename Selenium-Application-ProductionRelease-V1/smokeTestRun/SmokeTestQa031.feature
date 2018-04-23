Feature: Test031: Impersonate RR Operator, Check Elements On Assigned FNOL Incidents: Evidence Capture Forms - RR Admin

Scenario Outline: Test031: QA - Impersonate RR Operator, Check Elements On Assigned FNOL Incidents: Evidence Capture Forms - RR Admin
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
		Then click the element <evidence-capture-tab>
		Then check for table input <evidence-capture-table>
		Then click the element <revert-button>
		Then close the driver
		
		Examples:
			|browser |menuId                |original-user|user-to-impersonate|expected-page                                          |assigned-page                                         |action-button                                        |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |evidence-capture-tab                                                |evidence-capture-table        |revert-button    |
			|"Chrome"|"ctl00_NavigationMenu"|"rr admin"   |"rr operator"      |"https://qa.cmsdriveguard.co.uk/FleetOperatorHome.aspx"|"https://qa.cmsdriveguard.co.uk/AssignedFNOLList.aspx"|"ctl00_MainContent_grdAssignedFNOLList_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"tblEvidenceCaptureFormsOuter"|"ctl00_btnLogOut"|