package testStepMethods;

import java.util.List;

import org.openqa.selenium.WebDriver;

import loggingCode.RunningLogger;

public class QuickStepMethods
{
	StepMethods stepMethods = new StepMethods();
	RunningLogger runningLogger = new RunningLogger();
	
	public int logInAsUser(List<String> pageInfo, WebDriver webDriver)
	{
		int testCode = 0;
		testCode = stepMethods.typeIntoTextbox(pageInfo.get(0), "id", pageInfo.get(2), webDriver);
		if(testCode != 0)
			return testCode;
		testCode = stepMethods.typeIntoTextbox(pageInfo.get(1), "id", pageInfo.get(3), webDriver);
		if(testCode != 0)
			return testCode;
		testCode = stepMethods.clickElement(pageInfo.get(4), "class", webDriver);
		if(testCode != 0)
			return testCode;
		testCode = stepMethods.assertPageTransitionSuccessful(pageInfo.get(5), webDriver, true);
		if(testCode != 0)
			return testCode;
		return testCode;
	}
	
	public int impersonateUserAndRevert(List<String> pageInfo, WebDriver webDriver)
	{
		int testCode = 0;
		testCode = stepMethods.clickElement(pageInfo.get(0), "id", webDriver);
		if(testCode != 0)
			return testCode;
		testCode = stepMethods.assertPageTransitionSuccessful(pageInfo.get(3), webDriver, false);
		if(testCode != 0)
			return testCode;
		testCode = stepMethods.clickElement(pageInfo.get(1), "id", webDriver);
		if(testCode != 0)
			return testCode;
		testCode = stepMethods.assertPageTransitionSuccessful(pageInfo.get(2), webDriver, false);
		if(testCode != 0)
			return testCode;
		
		return testCode;
	}
	
	public int impersonateUser(List<String> pageInfo, WebDriver webDriver)
	{
		
		int testCode = 0;
		testCode = stepMethods.clickElement(pageInfo.get(0), "id", webDriver);
		if(testCode != 0)
			return testCode;
		testCode = stepMethods.assertPageTransitionSuccessful(pageInfo.get(1), webDriver, false);
		if(testCode != 0)
			return testCode;
		
		return testCode;
	}
	
	public int checkTableSort(List<String> pageInfo, WebDriver webDriver)
	{
		runningLogger.writeToLog("CTS1");
		int testCode = 0;
		testCode = stepMethods.checkElement(pageInfo.get(0), "id", webDriver);
		if(testCode != 0)
			return testCode;
		runningLogger.writeToLog("CTS2");
		testCode = stepMethods.checkElement(pageInfo.get(1), "href", webDriver);
		if(testCode != 0)
			return testCode;
		runningLogger.writeToLog("CTS3");
		testCode = stepMethods.sortAndCheckTable(pageInfo.get(1), pageInfo.get(0), "href", "id",webDriver);
		if(testCode != 0)
			return testCode;
		
		return testCode;
	}
}
