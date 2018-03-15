Feature: Test042: Check Elements Are Enabled on Manage Users Page - RR Admin

Scenario Outline: Test042: Check Elements Are Enabled on Manage Users Page - RR Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then check for table input <user-table>
		Then check the element exists <add-user-button>
		Then click the element <add-user-button>
		Then check for table input <add-user-table> <tag>
		Then check the element exists <add-user-cancel>
		Then check the element exists <add-user-save>
		Then click the element <add-user-cancel>
		Then close the driver
		
		Examples:
			|browser |tag    |user-table                  |add-user-button                      |add-user-table     |add-user-cancel                  |add-user-save                   |
			|"Chrome"|"class"|"ctl00_MainContent_gvwUsers"|"ctl00_MainContent_btnConfirmAddUser"|"innertableComment"|"ctl00_MainContent_btnUserCancel"|"ctl00_MainContent_btnSaveUsers"|