Feature: Test039: Check Elements Are Enabled on Manage Fleet Page - CH Admin : Fleet Details

Scenario Outline: Test039: Check Elements Are Enabled on Manage Fleet Page - CH Admin : Fleet Details
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch admin qa
		Then move to the page <nav-menu-id> <manage-fleet-page>
		Then click the element <edit-button>
		Then check the element exists <fleet-details-tab>
		Then check the element exists <vehicles-tab>
		Then check the element exists <drivers-tab>
		Then check for table input <fleet-details-table> <tag>
		Then close the driver
		
		Examples:
			|browser |tag    |nav-menu-id           |manage-fleet-page                                    |edit-button                                |fleet-details-tab                                   |vehicles-tab                                          |drivers-tab                                          |fleet-details-table|
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"|"ctl00_MainContent_grdFleets_ctl02_btnEdit"|"ctl00_MainContent_tcFleetManager_tbpnlAddFleet_tab"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlVehicles"|"__tab_ctl00_MainContent_tcFleetManager_tbpnlDrivers"|"PanelFleet"       |
