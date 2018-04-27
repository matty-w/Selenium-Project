Feature: Test017: Check Elements Are Enabled on Manage Fleet Page - RR Admin : Drivers

Scenario Outline: Test017: QA - Check Elements Are Enabled on Manage Fleet Page - RR Admin : Drivers
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then move to the page <menuId> <manage-fleet-page>
		Then click the element <edit-button>
		Then click the element <drivers-tab>
		Then check the element exists <fleet-details-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then check for table input <driver-table>
		Then check the element exists <add-new-driver-button>
		Then click the element <add-new-driver-button>
		Then check for table input <driver-details-table>
		Then check for table input <policy-table>
		Then check for table input <associate-vehicle-table>
		Then check the element exists <add-driver-cancel>
		Then check the element exists <add-driver-save>
		Then click the element <add-driver-cancel>
		Then close the driver
		
		Examples:
			|browser |tag    |menuId                |manage-fleet-page                                    |edit-button                                |fleet-details-tab                                     |vehicles-tab                                          |drivers-tab                                          |driver-table                                                            |add-new-driver-button                                                 |driver-details-table   |policy-table                 |associate-vehicle-table|add-driver-cancel                                                  |add-driver-save                                                        |
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"|"ctl00_MainContent_grdFleets_ctl02_btnEdit"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlAddFleet"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_grdDriversList"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnAddDriver"|"tblDriverPopupDetails"|"tblDriverPolicyPopupDetails"|"tblAssociatedVehicle" |"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnCancel"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnSaveDriver"|