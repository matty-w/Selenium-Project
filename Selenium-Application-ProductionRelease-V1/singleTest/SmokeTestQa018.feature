Feature: Test018: Check Elements Are Enabled on Email Manager Page - RR Admin

Scenario Outline: Test018: QA - Check Elements Are Enabled on Email Manager Page - RR Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then move to the page <menuId> <manage-fleet-page>
		Then check for table input <user-table-body>
		Then check the element exists <add-recipient-button>
		Then click the element <add-recipient-button>
		Then check for table input <add-recipient-table> <tag>
		Then check the element exists <add-recipient-cancel>
		Then check the element exists <add-recipient-save>
		Then click the element <add-recipient-cancel>
		Then check for table input <external-body-table>
		Then check the element exists <save-button>
		Then check the element exists <cancel-button>
		Then close the driver
		
		Examples:
			|browser |tag    |menuId                |manage-fleet-page                                 |fnol-alert-table      |user-table-body             |add-recipient-button               |add-recipient-table|add-recipient-cancel        |add-recipient-save                    |external-body-table                      |cancel-button                            |save-button                           |
			|"Chrome"|"class"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/EmailManager.aspx"|"PaneltableStyleWhite"|"ctl00_MainContent_grdUsers"|"ctl00_MainContent_btnAddRecipient"|"PopupTableCon"    |"ctl00_MainContent_btCancel"|"ctl00_MainContent_btnCreateRecipient"|"ctl00_MainContent_grdExternalRecipients"|"ctl00_MainContent_btnCancelUsersDetails"|"ctl00_MainContent_btnSaveUsersDetail"|