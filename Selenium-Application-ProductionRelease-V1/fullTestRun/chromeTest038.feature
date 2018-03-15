Feature: Test0038: Check Elements Are Enabled on Manage Fleet Page - CH Admin

Scenario Outline: Test038: Check Elements Are Enabled on Manage Fleet Page - CH Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch admin qa
		Then move to the page <nav-menu-id> <manage-fleet-page>
		Then check for table input <fleet-manager-table>
		Then close the driver
		
		Examples:
			|browser |tag    |nav-menu-id           |manage-fleet-page                                    |fleet-manager-table          |
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"|"ctl00_MainContent_grdFleets"|
