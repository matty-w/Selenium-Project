Feature: Test080: Check Elements Are Enabled on FNOL Incident Audit Page - RR Supervisor : Evidence Capture Forms

Scenario Outline: Test080: Check Elements Are Enabled on FNOL Incident Audit Page - RR Supervisor : Evidence Capture Forms
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr supervisor qa
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <evidence-capture-tab>
		Then click the element <evidence-capture-tab>
		Then check for table input <evidence-capture-table>
		Then close the driver
		
		Examples:
			|browser |navigation-menu       |action-button                                        |unassign-button                                                              |overview-tab                                           |incident-tab                                                    |evidence-tab                                              |evidence-capture-tab                                                |evidence-capture-table        |
			|"Chrome"|"ctl00_NavigationMenu"|"ctl00_MainContent_grdFNOLIncidentList_ctl02_btnview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnUnassign"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_tab"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"tblEvidenceCaptureFormsOuter"|
