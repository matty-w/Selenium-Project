Feature: Tes120: Check Elements Are Enabled on Outstanding FNOL Incidents Page - RR Operator

Scenario Outline: Test120: Check Elements Are Enabled on Outstanding FNOL Incidents Page - RR Operator
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr operator qa
		Then check for table input <fnol-table>
		Then check the element exists <create-manual-incident-button>
		Then click the element <create-manual-incident-button>
		Then check for table input <manual-incident-table> <tag>
		Then check the element exists <cancel-button>
		Then check the element exists <next-button>
		Then click the element <cancel-button>
		Then close the driver

		Examples:
			|browser |tag    |fnol-table                        |create-manual-incident-button              |manual-incident-table|cancel-button                                 |next-button                                 |
		  |"Chrome"|"class"|"ctl00_MainContent_grdNewFNOLData"|"ctl00_MainContent_btnCreateManualIncident"|"innertableComment"  |"ctl00_MainContent_ucManualIncident_btnCancel"|"ctl00_MainContent_ucManualIncident_btnNext"|