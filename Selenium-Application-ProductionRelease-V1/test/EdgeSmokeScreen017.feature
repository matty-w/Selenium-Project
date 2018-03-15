Feature: Test018: Check Navigation Between Pages Is Working RR Operator QA (Edge)

	Scenario Outline: Test018: Check Navigation Between Pages Is Working RR Operator QA (Edge)
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then check column sort for table <menuId> <sort-button> <column-id>
		Then close the driver
		
		Examples:
		|browser|menuId                      |sort-button                                 |column-id                                     |
		|"Edge" |"ctl00_MainContent_gvwUsers"|"ctl00$MainContent$gvwUsers','Sort$UserName"|"ctl00_MainContent_gvwUsers_ctl02_lblUserName"|