Feature: Test104: QA - Check Elements Are Enabled on CMS Fleet Manager Page - CMS Admin: Fleet Details

	Scenario Outline: Test104: QA - Check Elements Are Enabled on CMS Fleet Manager Page - CMS Admin: Fleet Details
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then click the element <add-fleet-button>
		Then check the element exists <import-vehicles-button>
		Then check the element exists <add-fleet-cancel>
		Then check the element exists <add-fleet-save>
		Then check the element exists <fleet-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then check for table input <fleet-manager-table> <fd-tag>
		Then click the element <import-vehicles-button>
		Then check for table input <import-popup> <fd-tag>
		Then click the element <import-popup-cancel>
		Then click the element <add-fleet-cancel>
		Then close the driver
		
		Examples:
			|browser |add-fleet-button               |import-vehicles-button                                                            |add-fleet-cancel                         |add-fleet-save                         |fleet-tab                                             |vehicles-tab                                          |drivers-tab                                          |fleet-manager-table|import-popup       |fd-tag |import-popup-cancel                                                                        |
			|"Chrome"|"ctl00_MainContent_btnAddFleet"|"ctl00_MainContent_tcFleetManager_tbpnlAddFleet_ucAddFleet_btnImportVehicleDriver"|"ctl00_MainContent_btnCancelFleetDetails"|"ctl00_MainContent_btnSaveFleetDetails"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlAddFleet"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"PanelFleet"       |"innertableComment"|"class"|"ctl00_MainContent_tcFleetManager_tbpnlAddFleet_ucAddFleet_ucImportVehicleDriver_btnCancel"|