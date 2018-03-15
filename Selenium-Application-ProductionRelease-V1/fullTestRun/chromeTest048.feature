Feature: Test048: Check Elements Are Enabled on Analysis Audit Trail Page - CMS Supervisor

Scenario Outline: Test048: Check Elements Are Enabled on Analysis Audit Trail Page - CMS Supervisor
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then check for table input <filter-table>
		Then check for table input <audit-list-table>
		Then check the element exists <incident-button>
		Then close the driver

		Examples:
			|browser |filter-table                  |audit-list-table                         |incident-button                                        |
			|"Chrome"|"tblClosedFNOLIncidentsFilter"|"ctl00_MainContent_grdAnalysisAuditTrail"|"ctl00_MainContent_grdAnalysisAuditTrail_ctl02_btnView"|