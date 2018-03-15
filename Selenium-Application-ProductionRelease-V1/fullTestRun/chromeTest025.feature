Feature: Test025: Check Elements Are Enabled on CMS Fleet Manager Page - CMS Admin: Vehicles

	Scenario Outline: Test025: QA - Check Elements Are Enabled on CMS Fleet Manager Page - CMS Admin: Vehicles
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then click the element <add-fleet-button>
		Then click the element <vehicles-tab>
		Then check the element exists <vehicles-table>
		Then check for table input <vehicles-table>
		Then check the element exists <fleet-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then check the element exists <add-new-vehicle>
		Then check the element exists <vehicles-cancel>
		Then check the element exists <vehicles-save>
		Then click the element <add-new-vehicle>
		Then check the element exists <vehicle-table-popup>
		Then check for table input <vehicle-table-popup>
		Then check the element exists <add-vehicle-cancel>
		Then check the element exists <add-vehicle-save>
		Then click the element <add-vehicle-cancel>
		Then click the element <filter-button>
		Then click the element <vehicles-cancel>
		Then close the driver
		
		Examples:
			|browser |add-fleet-button               |vehicles-tab                                          |vehicles-table            |fleet-tab                                             |drivers-tab                                          |add-new-vehicle                                                          |vehicles-cancel                          |vehicles-save                          |add-vehicle-cancel                                                   |add-vehicle-save                                                            |vehicle-table-popup|filter-button                                                        |
			|"Chrome"|"ctl00_MainContent_btnAddFleet"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"tblCMSDeviceReportFilter"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlAddFleet"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnAddVehicle"|"ctl00_MainContent_btnCancelFleetDetails"|"ctl00_MainContent_btnSaveFleetDetails"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnCancel"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnCreateVehicle"|"tblVehiclePopup"  |"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnFilter"|