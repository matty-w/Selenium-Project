Feature: Test044: Check Elements Are Enabled on Manage Fleet Page - RR Admin : Fleet Details

Scenario Outline: Test044: Check Elements Are Enabled on Manage Fleet Page - RR Admin : Fleet Details
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then move to the page <menuId> <manage-fleet-page>
		Then click the element <edit-button>
		Then check the element exists <fleet-details-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then check for table input <fleet-table> <tag>
		Then close the driver
		
		Examples:
			|browser |tag    |menuId                |manage-fleet-page                                    |edit-button                                |fleet-details-tab                                     |vehicles-tab                                          |drivers-tab                                          |fleet-table |
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"|"ctl00_MainContent_grdFleets_ctl02_btnEdit"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlAddFleet"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"PanelFleet"|