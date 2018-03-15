Feature: Test026: Check Elements Are Enabled on CMS Fleet Manager Page - CMS Admin: Drivers

	Scenario Outline: Test026: QA - Check Elements Are Enabled on CMS Fleet Manager Page - CMS Admin: Drivers
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then click the element <add-fleet-button>
		Then click the element <drivers-tab>
		Then check the element exists <fleet-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then check the element exists <drivers-cancel>
		Then check the element exists <drivers-save>
		Then check the element exists <add-new-driver>
		Then click the element <add-new-driver>
		Then check the element exists <add-driver-cancel>
		Then check the element exists <add-driver-save>
		Then check for table input <add-driver-table>
		Then click the element <add-driver-cancel>
		Then click the element <drivers-cancel>
		Then close the driver		
		
		
		Examples:
			|browser |add-fleet-button               |vehicles-tab                                          |add-driver-table|fleet-tab                                             |drivers-tab                                          |add-new-driver                                                        |add-driver-cancel                                                  |add-driver-save                                                        |drivers-cancel                           |drivers-save                           |
			|"Chrome"|"ctl00_MainContent_btnAddFleet"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"tblDriverPopup"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlAddFleet"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnAddDriver"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnCancel"|"ctl00_MainContent_tcFleetManager_tbpnlDrivers_ucDrivers_btnSaveDriver"|"ctl00_MainContent_btnCancelFleetDetails"|"ctl00_MainContent_btnSaveFleetDetails"|