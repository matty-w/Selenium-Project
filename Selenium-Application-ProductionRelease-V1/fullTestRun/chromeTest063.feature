Feature: Test063: Check Elements Are Enabled on Outstanding Analysis Page  - CMS Supervisor : Incident Details - Overview

Scenario Outline: Test063: Check Elements Are Enabled on Outstanding Analysis Page  - CMS Supervisor : Incident Details - Overview
		Given The driver is open <browser>
		When The window is maximised
		Then navigate to DriveGuard qa
		Then log in as cms supervisor qa
		Then move to the page <menuId> <assigned-page>
		Then click the element <assign-button>
		Then check the element exists <overview-tab>
		Then check the element exists <incident-details-tab>
		Then check the element exists <evidence-tab>
		Then check the element exists <collision-report-tab>
		Then check for table input <unassign-table>
		Then check for table input <response-table>
		Then check the element exists <add-response-button>
		Then click the element <add-response-button>
		Then check for table input <comment-table>
		Then check the element exists <comment-save>
		Then check the element exists <comment-cancel>
		Then click the element <comment-cancel>
		Then check the element exists <unassign-button>
		Then click the element <unassign-button>
		Then close the driver

		Examples:
			|browser |menuId                |assigned-page                                       |assign-button                                             |overview-tab                                             |incident-details-tab                                            |evidence-tab                                              |collision-report-tab                                            |unassign-table|response-table                                                                    |add-response-button                                                                     |comment-table       |comment-cancel                                                                     |comment-save                                                                    |unassign-button                                                              |
		  |"Chrome"|"ctl00_NavigationMenu"|"https://qa.cmsdriveguard.co.uk/CMSAnalystHome.aspx"|"ctl00_MainContent_grdOutstandingAnalysis_ctl02_btnAssign"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnloverview"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlincidentdetails"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlevidences"|"__tab_ctl00_MainContent_tcIncidnetDetails_tbpnlCollisionReport"|"tblActions"  |"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_grdResponsesList"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddResponseOverview"|"tblResponseComment"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnCancelOverview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnAddOverview"|"ctl00_MainContent_tcIncidnetDetails_tbpnloverview_ucIncOverview_btnUnassign"|