Feature: Test037: Check Elements Are Enabled on Mange Users Page - CH Admin

Scenario Outline: Test037: Check Elements Are Enabled on Mange Users Page - CH Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as ch admin qa
		Then check for table input <user-table>
		Then check the element exists <add-user-button>
		Then click the element <add-user-button>
		Then check for table input <add-user-table> <tag>
		Then check the element exists <add-user-cancel>
		Then check the element exists <add-user-save>
		Then click the element <add-user-cancel>
		Then close the driver
		
		Examples:
			|browser |user-table                  |add-user-button                      |add-user-table     |tag    |add-user-cancel             |add-user-save                    |
			|"Chrome"|"ctl00_MainContent_gvwUsers"|"ctl00_MainContent_btnConfirmAddUser"|"innertableComment"|"class"|"ctl00_MainContent_btCancel"|"ctl00_MainContent_btnCreateUser"|
