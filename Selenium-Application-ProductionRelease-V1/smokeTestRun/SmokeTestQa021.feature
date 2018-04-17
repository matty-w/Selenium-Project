Feature: Test021: Impersonate RR Supervisor - RR Admin

Scenario Outline: Test021: QA - Impersonate RR Supervisor - RR Admin
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as rr admin qa
		Then check impersonate functionality <impersonate-button-id> <revert-button-id> <expected-page>
		Then close the driver
		
		Examples:
			|browser |impersonate-button-id                            |revert-button-id |expected-page                                               |
			|"Chrome"|"ctl00_MainContent_gvwUsers_ctl04_btnImpersonate"|"ctl00_btnLogOut"|"https://qa.cmsdriveguard.co.uk/FNOLIncidentAuditTrail.aspx"|