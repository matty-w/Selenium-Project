Feature: Test030: Check Elements Are Enabled on Manage CH Users Page - CMS Admin

	Scenario Outline: Test030: QA - Check Elements Are Enabled on Manage CH Users Page - CMS Admin
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
			|browser |menuId                |page-address                                                    |user-table                   |add-user-button                                |add-user-table |tag    |add-user-cancel                           |add-user-save                             |
			|"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/ClaimsHandlerRolesAndUsers.aspx"|"ctl00_MainContent_grdFleets"|"ctl00_MainContent_btnConfirmAddClaimsHandlers"|"PopupTableCon"|"class"|"ctl00_MainContent_btnClaimsHandlerCancel"|"ctl00_MainContent_btnCreateClaimsHandler"|