Feature: Test043: Check Elements Are Enabled on Manage Fleet Page -  RR Admin

Scenario Outline: Test043: Check Elements Are Enabled on Manage Fleet Page -  RR Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then move to the page <menuId> <manage-fleet-page>
		Then check for table input <manage-fleet-table>
		Then close the driver
		
		Examples:
			|browser |tag    |menuId                |manage-fleet-page                                    |manage-fleet-table           |
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"|"ctl00_MainContent_grdFleets"|