Feature: Test091: QA - Check Elements Are Enabled on Outstanding Claims Handler Incidents Page - CH Operator : Action - Evidence Capture Forms : 1st Party Evidence

Scenario Outline: Test091: QA - Check Elements Are Enabled on Outstanding Claims Handler Incidents Page - CH Operator : Action - Evidence Capture Forms : 1st Party Evidence
	Given The driver is open <browser>
	When The window is maximised
	Then navigate to DriveGuard qa
	Then log in as ch operator qa
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
	Then click the element within iFrame <next-one> <frame-id> 
	Then wait specified time <time>
	Then check the element within iFrame <radio-yes-two> <frame-id>
	Then check the element within iFrame <radio-no-two> <frame-id>
	Then check the element within iFrame <prev-two> <frame-id>
	Then click the element within iFrame <next-two> <frame-id> 
	Then wait specified time <time>
	Then check the element within iFrame <car-park> <frame-id>
	Then check the element within iFrame <roundabout> <frame-id>
	Then check the element within iFrame <lane-change> <frame-id>
	Then check the element within iFrame <concertina> <frame-id>
	Then check the element within iFrame <rear-shunt> <frame-id>
	Then check the element within iFrame <t-bone> <frame-id>
	Then check the element within iFrame <front> <frame-id>
	Then check the element within iFrame <other> <frame-id>
	Then check the element within iFrame <radio-yes-three> <frame-id>
	Then check the element within iFrame <radio-no-three> <frame-id>
	Then check the element within iFrame <description-box> <frame-id>
	Then check the element within iFrame <v-number-box> <frame-id>
	Then check the element within iFrame <prev-three> <frame-id>
	Then click the element within iFrame <next-three> <frame-id>
	Then wait specified time <time>
	Then check the element within iFrame <radio-yes-four> <frame-id>
	Then check the element within iFrame <radio-no-four> <frame-id>
	Then check the element within iFrame <prev-four> <frame-id>
	Then check the element within iFrame <submit> <frame-id>
	Then click the element <close-button> <tag>
	Then wait specified time <time>
	Then click the element <overview-tab>
	Then click the element <unassign-button>
	Then close the driver
	
	
	
	Examples:
	|browser |time|tag    |frame-id    |action-button                                   |overview-tab                                           |incident-tab                                                    |evidence-tab                                              |collision-tab                                                   |evidence-capture-tab                                                |first-party-button                                                                                         |radio-yes-one      |radio-no-one      |next-one     |radio-yes-two        |radio-no-two        |prev-two         |next-two     |car-park    |roundabout     |lane-change    |concertina     |rear-shunt    |t-bone    |front       |other     |radio-yes-three    |radio-no-three    |description-box         |v-number-box               |prev-three       |next-three   |radio-yes-four          |radio-no-four          |prev-four        |submit     |close-button  |unassign-button                                                              |
	|"Chrome"|"2" |"class"|"ModalPopup"|"ctl00_MainContent_grdNewFNOLData_ctl02_btnview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_tab"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm"|"ctl00_MainContent_tcIncidnetDetails_tbpnlEvidenceCaptureForm_ucEvidenceCaptureForms_btnFirstPartyEvidence"|"rdoNamedDriverYes"|"rdoNamedDriverNo"|"btnNextDiv2"|"rdoDriverInjuredYes"|"rdoDriverInjuredNo"|"btnPreviousDiv1"|"btnNextDiv3"|"rdoCarPark"|"rdoRoundabout"|"rdoLaneChange"|"rdoConcertina"|"rdoRearShunt"|"rdoTBone"|"rdoFrontOn"|"rdoOther"|"rdoDriverFaultYes"|"rdoDriverFaultNo"|"txtAccidentDescription"|"txtNumberVehiclesInvolved"|"btnPreviousDiv2"|"btnNextDiv4"|"rdoDriverPassengersYes"|"rdoDriverPassengersNo"|"btnPreviousDiv3"|"btnSubmit"|"close-window"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnUnassign"|
