Feature: Test076: Check Elements Are Enabled on FNOL Incident Audit Page - RR Supervisor

Scenario Outline: Test076: Check Elements Are Enabled on FNOL Incident Audit Page - RR Supervisor
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr supervisor qa
		Then check for table input <filter-table>
		Then check the element exists <filter-button>
		Then check for table input <incident-table>
		Then check the element exists <create-incident-button>
		Then click the element <create-incident-button>
		Then check for table input <create-incident-table> <tag>
		Then check the element exists <create-incident-cancel>
		Then check the element exists <create-incident-next>
		Then click the element <create-incident-cancel>
		Then close the driver

		Examples:
			|browser |tag    |filter-table                  |filter-button                |incident-table                         |create-incident-button                     |create-incident-table|create-incident-cancel                        |create-incident-next                        |
			|"Chrome"|"class"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_btnFilter"|"ctl00_MainContent_grdFNOLIncidentList"|"ctl00_MainContent_btnCreateManualIncident"|"innertableComment"  |"ctl00_MainContent_ucManualIncident_btnCancel"|"ctl00_MainContent_ucManualIncident_btnNext"|