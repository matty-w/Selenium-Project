Feature: Check Elements Are Enabled on Claim Incident Audit Trail Page - CH Supervisor : Action - Evidence Capture Forms : 1st Party Evidence

Scenario Outline: Check Elements Are Enabled on Claim Incident Audit Trail Page - CH Supervisor : Action - Evidence Capture Forms : 1st Party Evidence
	Given The driver is open <browser>
	When The window is maximised
	Then navigate to DriveGuard qa
	Then log in as ch supervisor qa
	Then click the element <action-button>
	Then check the element exists <overview-tab>
	Then check the element exists <incident-tab>
	Then check the element exists <evidence-tab>
	Then check the element exists <collision-tab>
	Then check the element exists <evidence-capture-tab>
	Then click the element <evidence-capture-tab>
	Then click the element <first-party-button>
	Then wait specified time <time>
	Then check the element within iFrame <radio-yes-one> <frame-id>
	Then check the element within iFrame <radio-no-one> <frame-id>
	Then close the driver
	
	
	
	Examples:
	|browser |time|frame-id    |action-button                                        |overview-tab                                           |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |evidence-capture-tab                                                |first-party-button                                                                                         |radio-yes-one      |radio-no-one      |
	|"Chrome"|"2" |"ModalPopup"|"ctl00_MainContent_grdFNOLIncidentList_ctl02_btnview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_tab"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm_ucEvidenceCaptureForms_btnFirstPartyEvidence"|"rdoNamedDriverYes"|"rdoNamedDriverNo"|
