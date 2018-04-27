Feature: Test103: QA - Check Elements Are Enabled on CMS Fleet Manager Page - CMS Admin

	Scenario Outline: Test103: QA - Check Elements Are Enabled on CMS Fleet Manager Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then check for table input <fleet-manager-table>
		Then check the element exists <add-fleet-button>
		Then close the driver
		
		
		
		
		Examples:
		 |browser |fleet-manager-table          |add-fleet-button               |
		 |"Chrome"|"ctl00_MainContent_grdFleets"|"ctl00_MainContent_btnAddFleet"|
	    
