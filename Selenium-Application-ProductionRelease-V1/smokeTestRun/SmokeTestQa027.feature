Feature: Test027: Impersonate RR Operator, Check Elements On Assigned FNOL Incidents - RR Admin

Scenario Outline: Test027: QA - Impersonate RR Operator, Check Elements On Assigned FNOL Incidents - RR Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then impersonate user <original-user> <user-to-impersonate> <expected-page>
		Then move to the page <menuId> <assigned-page>
		Then check for table input <assigned-table>
		Then check the element exists <create-incident-button>
		Then click the element <create-incident-button>
		Then check for table input <create-incident-table> <tag>
		Then check the element exists <create-incident-cancel>
		Then check the element exists <create-incident-next>
		Then wait specified time <time>
		Then click the element <location-by-postcode>
		Then type into textbox <postcode-textbox> <postcode>
		Then click the element <search-button>
		Then wait specified time <time>
		Then click the element <create-incident-next>
		Then check for table input <create-incident-table> <tag>
		Then check the element exists <previous-button>
		Then click the element <create-vehicle-button>
		Then click the element <create-incident-next>
		Then check for table input <create-incident-table> <tag>
		Then type into textbox <vehicle-reg-textbox> <test-data>
		Then type into textbox <manufacturer-textbox> <test-data>
		Then type into textbox <model-textbox> <test-data>
		Then type into textbox <colour-textbox> <test-data>
		Then select option from dropdown box <vehicle-type-dropdown> <dropdown-option>
		Then select option from dropdown box <powertrain-dropdown> <dropdown-option>
		Then select option from dropdown box <associate-fleet-dropdown> <dropdown-option>
		Then click the element <create-incident-next>
		Then check for table input <create-incident-table> <tag>
		Then check for table input <policy-table>
		Then check for table input <driver-table>
		Then click the element <create-incident-cancel>
		Then click the alert window
		Then click the element <revert-button>
		Then close the driver
		
		Examples:
		
			|browser |time|tag    |original-user|user-to-impersonate|menuId                |assigned-page                                         |expected-page                                          |revert-button    |assigned-table                         |create-incident-button                     |create-incident-table|create-incident-cancel                        |create-incident-next                        |postcode  |location-by-postcode                                   |postcode-textbox                                        |search-button                                 |previous-button                                 |create-vehicle-button                                |vehicle-details-table|test-data|vehicle-reg-textbox                                        |manufacturer-textbox                                |model-textbox                                |colour-textbox                                |vehicle-type-dropdown                              |powertrain-dropdown                             |associate-fleet-dropdown                      |dropdown-option|dropdown-option-test|policy-table                 |driver-table          |
			|"Chrome"|"2" |"class"|"rr admin"   |"rr operator"      |"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/AssignedFNOLList.aspx"|"https://qa.cmsdriveguard.co.uk/FleetOperatorHome.aspx"|"ctl00_btnLogOut"|"ctl00_MainContent_grdAssignedFNOLList"|"ctl00_MainContent_btnCreateManualIncident"|"innertableComment"  |"ctl00_MainContent_ucManualIncident_btnCancel"|"ctl00_MainContent_ucManualIncident_btnNext"|"nn12 8eq"|"ctl00_MainContent_ucManualIncident_rdbLocByPostalCode"|"ctl00_MainContent_ucManualIncident_txtSpecificLocation"|"ctl00_MainContent_ucManualIncident_btnSearch"|"ctl00_MainContent_ucManualIncident_btnPrevious"|"ctl00_MainContent_ucManualIncident_btnCreateVehicle"|"tblVehicleDetails"  |"test"   |"ctl00_MainContent_ucManualIncident_txtVehicleregistration"|"ctl00_MainContent_ucManualIncident_txtManufacturer"|"ctl00_MainContent_ucManualIncident_txtModel"|"ctl00_MainContent_ucManualIncident_txtColour"|"ctl00_MainContent_ucManualIncident_ddlVehicleType"|"ctl00_MainContent_ucManualIncident_ddlFuelType"|"ctl00_MainContent_ucManualIncident_ddlFleets"|"1"            |"100"               |"tblDriverPolicyPopupDetails"|"tblAssociatedVehicle"|