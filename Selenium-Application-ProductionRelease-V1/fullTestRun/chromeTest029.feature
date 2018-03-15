Feature: Test029: Check Elements Are Enabled on Manage RR Users Page - CMS Admin

	Scenario Outline: Test029: QA - Check Elements Are Enabled on Manage RR Users Page - CMS Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms admin qa
		Then move to the page <menuId> <page-address>
		Then check for table input <user-table>
		Then check the element exists <add-user-button>
		Then click the element <add-user-button>
		Then check the element exists <add-user-cancel>
		Then check the element exists <add-user-save>
		Then check for table input <add-user-table> <tag>
		Then click the element <add-user-cancel>
		Then close the driver
		
		Examples:
			|browser |menuId                |page-address                                                     |user-table                   |add-user-button                                |add-user-table |tag    |add-user-cancel                            |add-user-save                              |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/RapidResponderRolesAndUsers.aspx"|"ctl00_MainContent_grdFleets"|"ctl00_MainContent_btnConfirmAddRapidResponder"|"PopupTableCon"|"class"|"ctl00_MainContent_btnRapidResponderCancel"|"ctl00_MainContent_btnCreateRapidResponder"|