Feature: Test041: Check Elements Are Enabled on Manage Fleet Page - CH Admin

Scenario Outline: Test041: Check Elements Are Enabled on Manage Fleet Page - CH Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch admin qa
		Then move to the page <nav-menu-id> <manage-fleet-page>
		Then click the element <edit-button>
		Then check the element exists <fleet-details-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then click the element <drivers-tab>
		Then check for table input <driver-table>
		Then check the element exists <add-new-driver-button>
		Then click the element <add-new-driver-button>
		Then check for table input <driver-details-table>
		Then check for table input <policy-details-table>
		Then check for table input <associated-vehicle-table>
		Then check the element exists <add-driver-cancel>
		Then check the element exists <add-driver-save>
		Then click the element <add-driver-cancel>
		Then close the driver
		
		Examples:
			|browser |tag    |nav-menu-id           |manage-fleet-page                                    |edit-button                                |fleet-details-tab                                   |vehicles-tab                                          |drivers-tab                                          |associated-vehicle-table|driver-table                                                            |add-new-driver-button                                                 |driver-details-table   |policy-details-table         |associate-vehicle-table|add-driver-cancel                                                  |add-driver-save                                                        |
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"|"ctl00_MainContent_grdFleets_ctl02_btnEdit"|"ctl00_MainContent_tcFleetManager_tbpnlAddFleet_tab"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"tblAssociatedVehicle"  |"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_grdDriversList"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnAddDriver"|"tblDriverPopupDetails"|"tblDriverPolicyPopupDetails"|"tblAssociatedVehicle" |"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnCancel"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnSaveDriver"|
