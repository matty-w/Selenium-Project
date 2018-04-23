Feature: Test044: QA - Check Elements Are Enabled on FNOL Incident Audit Page - RR Supervisor : Evidence Capture Forms - 3rd Party Evidence

Scenario Outline: Test044: QA - Check Elements Are Enabled on FNOL Incident Audit Page - RR Supervisor : Evidence Capture Forms - 3rd Party Evidence
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
	Then click the element <third-party-button>
	Then wait specified time <time>
	Then check the element within iFrame <driver-name-textbox> <frame-id>
	Then check the element within iFrame <driver-dob-textbox> <frame-id>
	Then check the element within iFrame <driver-num-textbox> <frame-id>
	Then click the element within iFrame <next-one> <frame-id> 
	Then wait specified time <time>
	Then check the element within iFrame <reg-textbox> <frame-id>
	Then check the element within iFrame <manu-textbox> <frame-id>
	Then check the element within iFrame <model-textbox> <frame-id>
	Then check the element within iFrame <colour-textbox> <frame-id>
	Then check the element within iFrame <prev-two> <frame-id>
	Then click the element within iFrame <next-two> <frame-id> 
	Then wait specified time <time>
	Then check the element within iFrame <driver-injury-yes> <frame-id>
	Then check the element within iFrame <driver-injury-no> <frame-id>
	Then check the element within iFrame <prev-three> <frame-id>
	Then click the element within iFrame <next-three> <frame-id>
	Then wait specified time <time>
	Then check the element within iFrame <accident-desc-textarea> <frame-id>
	Then check the element within iFrame <tp-opinion-textbox> <frame-id>
	Then check the element within iFrame <prev-four> <frame-id>
	Then click the element within iFrame <next-four> <frame-id>
	Then wait specified time <time>
	Then check the element within iFrame <passenger-yes> <frame-id>
	Then check the element within iFrame <passenger-no> <frame-id>
	Then check the element within iFrame <prev-five> <frame-id>
	Then check the element within iFrame <submit-button> <frame-id> 
	Then click the element <close-button> <tag>
	Then wait specified time <time>
	Then close the driver
	
	
	
	Examples:
	|browser |admin-user|impersonate-user|expected-page                                          |time|tag    |frame-id    |action-button                                        |overview-tab                                           |incident-tab                                                    |evidence-tab                                              |evidence-capture-tab                                                |third-party-button                                                                                         |driver-name-textbox|driver-dob-textbox|driver-num-textbox  |next-one |reg-textbox         |manu-textbox|model-textbox|colour-textbox|prev-two |next-two     |driver-injury-yes    |driver-injury-no    |prev-three       |next-three   |accident-desc-textarea  |tp-opinion-textbox|prev-four        |next-four    |passenger-yes           |passenger-no           |prev-five        |submit-button|close-button  |
	|"Chrome"|"rr admin"|"rr operator"   |"https://qa.cmsdriveguard.co.uk/FleetOperatorHome.aspx"|"2" |"class"|"ModalPopup"|"ctl00_MainContent_grdFNOLIncidentList_ctl02_btnview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_tab"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm_ucEvidenceCaptureForms_btnThirdPartyEvidence"|"txtDriverName"    |"txtDriverDOB"    |"txtDriverTelephone"|"Button1"|"txtCarRegistration"|"txtCarMake"|"txtCarModel"|"txtCarColour"|"Button2"|"btnNextDiv2"|"rdoDriverInjuredYes"|"rdoDriverInjuredNo"|"btnPreviousDiv1"|"btnNextDiv3"|"txtAccidentDescription"|"txtPartyAtFault" |"btnPreviousDiv2"|"btnNextDiv4"|"rdoDriverPassengersYes"|"rdoDriverPassengersNo"|"btnPreviousDiv3"|"btnSubmit"  |"close-window"|
