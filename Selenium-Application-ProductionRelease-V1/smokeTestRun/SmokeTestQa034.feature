Feature: Test034: Impersonate RR Operator, Check Elements On Assigned FNOL Incidents: Evidence Capture Forms : Witness Evidence - RR Admin

Scenario Outline: Test034: QA - Impersonate RR Operator, Check Elements On Assigned FNOL Incidents: Evidence Capture Forms : Witness Evidence - RR Admin
	Given The driver is open <browser>
	When The window is maximised
	Then navigate to DriveGuard qa
	Then log in as rr admin qa
	Then impersonate user <admin-user> <impersonate-user> <expected-page>
	Then wait specified time <time>
	Then click the element <action-button>
	Then check the element exists <overview-tab>
	Then check the element exists <incident-tab>
	Then check the element exists <evidence-tab>
	Then check the element exists <evidence-capture-tab>
	Then click the element <evidence-capture-tab>
	Then click the element <witness-button>
	Then wait specified time <time>
	Then check the element within iFrame <witness-name-textbox> <frame-id>
	Then check the element within iFrame <dob-textbox> <frame-id>
	Then check the element within iFrame <telephone-textbox> <frame-id>
	Then check the element within iFrame <opinion-textbox> <frame-id>
	Then check the element within iFrame <submit-button> <frame-id> 
	Then click the element <close-button> <tag>
	Then wait specified time <time>
	Then close the driver
	
	
	
	Examples:
	|browser |admin-user|impersonate-user|expected-page                                          |time|tag    |frame-id    |action-button                                   |overview-tab                                           |incident-tab                                                    |evidence-tab                                              |evidence-capture-tab                                                |witness-button                                                                                          |witness-name-textbox|dob-textbox    |telephone-textbox    |opinion-textbox         |submit-button  |close-button  |
	|"Chrome"|"rr admin"|"rr operator"   |"https://qa.cmsdriveguard.co.uk/FleetOperatorHome.aspx"|"2" |"class"|"ModalPopup"|"ctl00_MainContent_grdNewFNOLData_ctl02_btnview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_tab"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm_ucEvidenceCaptureForms_btnWitnessEvidence"|"txtWitnessName"    |"txtWitnessDOB"|"txtWitnessTelephone"|"txtPartyAtFaultWitness"|"btnSubmitForm"|"close-window"|
