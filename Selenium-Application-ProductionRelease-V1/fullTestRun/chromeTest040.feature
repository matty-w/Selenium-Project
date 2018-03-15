Feature: Test040: Check Elements Are Enabled on Manage Fleet Page - CH Admin : Vehicles

Scenario Outline: Test040: Check Elements Are Enabled on Manage Fleet Page - CH Admin : Vehicles
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch admin qa
		Then move to the page <nav-menu-id> <manage-fleet-page>
		Then click the element <edit-button>
		Then check the element exists <fleet-details-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then click the element <vehicles-tab>
		Then check for table input <vehicles-filter-table>
		Then check for table input <vehicles-table>
		Then check the element exists <add-new-vehicle-button>
		Then click the element <add-new-vehicle-button>
		Then check for table input <vehicle-details-table>
		Then check for table input <odometer-table>
		Then check for table input <associated-vehicle-table>
		Then check the element exists <add-vehicle-cancel>
		Then check the element exists <add-vehicle-save>
		Then click the element <add-vehicle-cancel>
		Then close the driver
		
		Examples:
			|browser |tag    |nav-menu-id           |manage-fleet-page                                    |fleet-manager-table          |edit-button                                |fleet-details-tab                                   |vehicles-tab                                          |drivers-tab                                          |fleet-details-table|vehicles-filter-table     |vehicles-table                                                         |add-new-vehicle-button                                                   |vehicle-details-table|odometer-table|associated-vehicle-table|add-vehicle-cancel                                                   |add-vehicle-save                                                            |driver-table                                                            |add-new-driver-button                                                 |driver-details-table   |policy-details-table         |associate-vehicle-table|add-driver-cancel                                                  |add-driver-save                                                        |
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"|"ctl00_MainContent_grdFleets"|"ctl00_MainContent_grdFleets_ctl02_btnEdit"|"ctl00_MainContent_tcFleetManager_tbpnlAddFleet_tab"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"PanelFleet"       |"tblCMSDeviceReportFilter"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_gvwVehicles"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnAddVehicle"|"tblVehicleDetails"  |"Table1"      |"tblAssociatedVehicle"  |"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnCancel"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnCreateVehicle"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_grdDriversList"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnAddDriver"|"tblDriverPopupDetails"|"tblDriverPolicyPopupDetails"|"tblAssociatedVehicle" |"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnCancel"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnSaveDriver"|
