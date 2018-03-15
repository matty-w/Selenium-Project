Feature: Test045: Check Elements Are Enabled on Manage Fleet Page - RR Admin : Vehicles

Scenario Outline: Test045: Check Elements Are Enabled on Manage Fleet Page - RR Admin : Vehicles
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then move to the page <menuId> <manage-fleet-page>
		Then click the element <edit-button>
		Then click the element <vehicles-tab>
		Then check the element exists <fleet-details-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then check for table input <vehicle-filter-table>
		Then check the element exists <filter-button>
		Then check for table input <vehicle-table>
		Then check the element exists <add-new-vehicle-button>
		Then click the element <add-new-vehicle-button>
		Then check for table input <vehicle-details-table>
		Then check for table input <odometer-table>
		Then check for table input <associate-vehicle-table>
		Then check the element exists <add-vehicle-cancel>
		Then check the element exists <add-vehicle-save>
		Then click the element <add-vehicle-cancel>
		Then close the driver
		
		Examples:
			|browser |tag    |menuId                |manage-fleet-page                                    |edit-button                                |fleet-details-tab                                     |vehicles-tab                                          |drivers-tab                                          |vehicle-filter-table      |vehicle-table                                                          |filter-button                                                        |add-new-vehicle-button                                                   |vehicle-details-table|odometer-table|associate-vehicle-table|add-vehicle-cancel                                                   |add-vehicle-save                                                            |
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"|"ctl00_MainContent_grdFleets_ctl02_btnEdit"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlAddFleet"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"tblCMSDeviceReportFilter"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_gvwVehicles"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnFilter"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnAddVehicle"|"tblVehicleDetails"  |"Table1"      |"tblAssociatedVehicle" |"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnCancel"|"ctl00_MainContent_tcFleetManager_tbpnlVehicles_ucVehicles_btnCreateVehicle"|