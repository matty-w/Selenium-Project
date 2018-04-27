Feature: Test090: QA - Check Elements Are Enabled on Outstanding Claims Handler Incidents Page - CH Operator : Action - Evidence Capture Forms

Scenario Outline: Test090: QA - Check Elements Are Enabled on Outstanding Claims Handler Incidents Page - CH Operator : Action - Evidence Capture Forms
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch operator qa
		Then click the element <action-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-tab>
		Then check the element exists <evidence-capture-tab>
		Then click the element <evidence-capture-tab>
		Then check for table input <evidence-capture-table>
		Then close the driver
		
		Examples:
			|browser |claims-table                      |action-button                                   |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-tab                                                   |evidence-capture-tab                                                |evidence-capture-table        |
			|"Chrome"|"ctl00_MainContent_grdNewFNOLData"|"ctl00_MainContent_grdNewFNOLData_ctl02_btnview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"tblEvidenceCaptureFormsOuter"|