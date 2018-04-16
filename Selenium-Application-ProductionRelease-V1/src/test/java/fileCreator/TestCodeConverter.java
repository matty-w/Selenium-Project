package fileCreator;

import testCodes.TestCodes;

public class TestCodeConverter 
{
	TestCodes tc = new TestCodes();
	
	protected String testDescription(int testCode)
	{
		if(testCode == tc.noInputsInContainerFail)
			return "Element Container Fail - No Inputs Found";
		if(testCode == tc.testOpenBrowser)
			return "Open The Browser";
		if(testCode == tc.testMaximiseScreen)
			return "Maximise The Browser";
		if(testCode == tc.testCloseBrowser)
			return "Close The Browser";
		if(testCode == tc.testNavigateToDriveGuardProd)
			return "Navigate To DriveGuard";
		if(testCode == tc.testTypeIntoTextbox)
			return "Type Into The Textbox";
		if(testCode == tc.testClickButton)
			return "Click The Button";
		if(testCode == tc.testNavigateToPage)
			return "Navigate To The Page";
		if(testCode == tc.testCheckElementExists)
			return "Check For Element";
		if(testCode == tc.testCheckElementIsVisible)
			return "Check Element Is Visible";
		if(testCode == tc.testLoginAsCMSAdminProd)
			return "Login As CMS Admin (Production)";
		if(testCode == tc.testLoginAsCMSSupervisorProd)
			return "Login As CMS Supervisor (Production)";
		if(testCode == tc.testLoginAsCMSOperatorProd)
			return "Login As CMS Operator (Production)";
		if(testCode == tc.testLoginAsCHAdminProd)
			return "Login As CH Admin (Production)";
		if(testCode == tc.testLoginAsCHSupervisorProd)
			return "Login As CH Supervisor (Production)";
		if(testCode == tc.testLoginAsCHOperatorProd)
			return "Login As CH Operator (Production)";
		if(testCode == tc.testLoginAsRRAdminProd)
			return "Login As RR Admin (Production)";
		if(testCode == tc.testLoginAsRRSupervisorProd)
			return "Login As RR Supervisor (Production)";
		if(testCode == tc.testLoginAsRROperatorProd)
			return "Login As RR Operator (Production)";
		if(testCode == tc.testLoginAsCMSAdminQa)
			return "Login As CMS Admin (QA)";
		if(testCode == tc.testLoginAsCMSSupervisorQa)
			return "Login As CMS Supervisor (QA)";
		if(testCode == tc.testLoginAsCMSOperatorQa)
			return "Login As CMS Operator (QA)";
		if(testCode == tc.testLoginAsCHAdminQa)
			return "Login As CH Admin (QA)";
		if(testCode == tc.testLoginAsCHSupervisorQa)
			return "Login As CH Supervisor (QA)";
		if(testCode == tc.testLoginAsCHOperatorQa)
			return "Login As CH Operator (QA)";
		if(testCode == tc.testLoginAsRRAdminQa)
			return "Login As RR Admin (QA)";
		if(testCode == tc.testLoginAsRRSupervisorQa)
			return "Login As RR Supervisor (QA)";
		if(testCode == tc.testLoginAsRROperatorQa)
			return "Login As RR Operator (QA)";
		if(testCode == tc.checkPageExceptionLeak)
			return "Check Page Exception Leak - Check Code (Bug)";
		if(testCode == tc.clearElementExceptionLeak)
			return "Clear Element Exception Leak - Check Code (Bug)";
		if(testCode == tc.testImpersonateFunctionality)
			return "Test The Impersonate Functionality Of The User (Impersonate/Revert)";
		if(testCode == tc.testSortColumnFunctionality)
			return "Test The Sort Functionality Of The Table";
		if(testCode == tc.testNavigateToDriveGuardQa)
			return "Navigate To DriveGuard QA";
		if(testCode == tc.testGenericLogin)
			return "Check To See Whether Login Was Successful";
		if(testCode == tc.findNavigationBar)
			return "Attempt To Find Navigation Bar For Logged In User";
		return "Invalid test, please check codebase, code given: "+testCode;
	}
	
	protected String createErrorContext(int errorCode, int contextCode)
	{
		if(errorCode == 0)
			return "";
		else
		{
			String error = "";
			String errorContext = "";
			String completeErrorLine = "";
			
			
			if(contextCode == tc.driverError)
				errorContext = "Driver Error";
			else if(contextCode == tc.webElementError)
				errorContext = "Web Element Error";
			else if(contextCode == tc.webAddressError)
				errorContext = "Web Address Error";
			else if(contextCode == tc.webPageFunctionalityError)
				errorContext = "Web Page Functionality Error";
			else if(contextCode == tc.cucumberError)
				errorContext = "Error Located In Test";
			else
				error = "Unknown Error Code. Code Used: "+errorCode;
			
			
			
			if(errorCode == tc.driverNotPresent)
				error = "The Driver Could Not Be Found And/Or Did Not Open Successfully";
			else if(errorCode == tc.couldntMaximiseScreen)
				error = "The Driver Could Not Maximise To Fill The Screen";
			else if(errorCode == tc.driverCloseError)
				error = "The Driver Could Not Be Closed And Is Still Open";
			else if(errorCode == tc.webPageNotReached)
				error = "The Webpage Could Not Be Reached";
			else if(errorCode == tc.elementNotFound)
				error = "The Web Element Could Not Be Found";
			else if(errorCode == tc.webElementNotVisible)
				error = "The Web Element Was Not Visible On The Page";
			else if(errorCode == tc.elementCouldntBeClicked)
				error = "The Web Element Could Not Be Clicked";
			else if(errorCode == tc.elementCouldntBeCleared)
				error = "The Web Element Could Not Be Cleared";
			else if(errorCode == tc.noInputElementsInContainer)
				error = "The Web Element Provided Contains No Input Or Select Elements";
			else if(errorCode == tc.noExpectedElementsInContainer)
				error = "The Web Element Provided Contains No Expected Input Or Select Elements (Check For Hidden Elements On Page)";
			else if(errorCode == tc.loginUnsuccessful)
				error = "The Site Was Unable To Login As The User. Check Email And Password For User";
			else if(errorCode == tc.sameStringAfterTableSort)
				error = "The String Value Returned After Sort Was The Same Before The Sort Took Place. Check Table To See There Are Enough Entries For Test";
			else if(errorCode == tc.incorrectSortingResultLowerAboveHigh)
				error = "The Sort Produced An Incorrect Result. The Top Search Was Below The Previous Entry Alphabetically";
			else if(errorCode == tc.incorrectPageReached)
				error = "The Incorrect Page Was Reached, Check Whether A Log In Attept Was Performed Above";
			else if(errorCode == tc.couldntTypeValueInElement)
				error = "Error Typing Value Into The Element, Either The Element Does Not Exist, Or There Is No Value To Type. Check Test";
			else if(errorCode == tc.pageTimeoutOnElementClick)
				error = "Once The Element Was Clicked, There Was No Response Within 60 Seconds From The Page. The Server Appears To Be Responding Slowly";
			else
				error = "Unknown Error Code. Code Used: "+errorCode;
			
			completeErrorLine = errorContext+": "+error+".";
			
			return completeErrorLine;
		}
	}
}
