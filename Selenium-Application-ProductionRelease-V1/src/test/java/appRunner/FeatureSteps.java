package appRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import testCodes.TestCodes;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fileCreator.CreateExcelWorkbook;
import loggingCode.RunningLogger;
import loggingCode.RunningLoggerStringValues;
import testStepMethods.QuickStepMethods;
import testStepMethods.StepMethods;

public class FeatureSteps 
{
	boolean createTitle = true;
	boolean failTitleAlreadyAdded = false;
	
	Scenario scenario;
	WebDriver driver;
	
	List<Integer> codesForTest = new ArrayList<Integer>();

	
	int runnerCode = 0;
	int testStep = 0;
	
	String currentBrowser;
	
	StepMethods stepMethods = new StepMethods();
	
	QuickStepMethods quickStepMethods = new QuickStepMethods();
	
	RunningLogger runningLogger = new RunningLogger();
	RunningLoggerStringValues loggerValues = new RunningLoggerStringValues();
	
	
	TestCodes testCodes = new TestCodes();
	
	CreateExcelWorkbook cew = new CreateExcelWorkbook();
	
	@Before
	public void before(Scenario scenarioTemp)
	{
		this.scenario = scenarioTemp;
	}
	
	@Given("^The driver is open \"([^\"]*)\"$")
	public void openDriver(String browser)
	{
		try
		{
			if(browser.equals("Chrome"))
			{
				String f = new File("").getAbsolutePath();
				currentBrowser = browser;
				System.setProperty("webdriver.chrome.driver", f+"//Misc//webDrivers//chromedriver.exe");
				driver = new ChromeDriver();
			}
			if(browser.equals("IE"))
			{
				String f = new File("").getAbsolutePath();
				currentBrowser = browser;
				System.setProperty("webdriver.ie.driver", f+"//Misc//webDrivers//IEDriverServer.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				driver = new InternetExplorerDriver();
			}
			if(browser.equals("Opera"))
			{
				String f = new File("").getAbsolutePath();
				currentBrowser = browser;
				System.setProperty("webdriver.chrome.driver", f+"//Misc//webDrivers//operadriver.exe");
				driver = new ChromeDriver();
			}
			if(browser.equals("Edge"))
			{
				String f = new File("").getAbsolutePath();
				currentBrowser = browser;
				System.setProperty("webdriver.edge.driver", f+"//Misc//webDrivers//MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			}
			runnerCode = stepMethods.openTheDriver(browser, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.driverError, testCodes.testOpenBrowser));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.openChromeDriver+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
		
	}
	
	@When("^The window is maximised$")
	public void maximiseBrowserWindow()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.maximiseWindow);
			runnerCode = stepMethods.maximiseTheBrowser(driver);
			runningLogger.writeToLog(loggerValues.windowMaximised);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.driverError, testCodes.testMaximiseScreen));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.windowMaximised+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^close the driver$")
	public void closeDriver()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.closeDriver);
			runnerCode = stepMethods.closeTheDriver(driver);
			runningLogger.writeToLog(loggerValues.closeDriverComplete);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.driverError, testCodes.testCloseBrowser));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.closeDriver+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^navigate to DriveGuard$")
	public void navigateToDriveGuard()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.navigateToDriveguard);
			runnerCode = stepMethods.checkCorrectPageReached("https://cmsdriveguard.co.uk/Account/Login", driver, false);
			runningLogger.writeToLog(loggerValues.driveguardNavigated);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToDriveGuardProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^navigate to DriveGuard production$")
	public void navigateToDriveGuardProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.navigateToDriveguard+loggerValues.production);
			runnerCode = stepMethods.checkCorrectPageReached("https://cmsdriveguard.co.uk/Account/Login", driver, false);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToDriveGuardProd));
			runningLogger.writeToLog(loggerValues.driveguardNavigated);
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^navigate to DriveGuard qa$")
	public void navigateToDriveGuardQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.navigateToDriveguard+loggerValues.production);
			runnerCode = stepMethods.checkCorrectPageReached("https://qa.cmsdriveguard.co.uk/Account/Login", driver, false);
			runningLogger.writeToLog(loggerValues.driveguardNavigated);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToDriveGuardProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^check the element exists \"([^\"]*)\"$")
	public void checkElementExists(String webElement)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.checkElement+webElement);
			runnerCode = stepMethods.checkElement(webElement, "id", driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementExists));
			assertionTest(codesForTest, webElement);
			runningLogger.writeToLog(loggerValues.checkElement+webElement+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^check the element exists \"([^\"]*)\" \"([^\"]*)\"$")
	public void checkElementExists(String webElement, String tagType)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.checkElement+webElement);
			runnerCode = stepMethods.checkElement(webElement, tagType, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementExists));
			assertionTest(codesForTest, webElement);
			runningLogger.writeToLog(loggerValues.checkElement+webElement+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^type into textbox \"([^\"]*)\" \"([^\"]*)\"$")
	public void typeIntoTextbox(String webElement, String textValue)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.typeIntoTextbox+webElement);
			runnerCode = stepMethods.typeIntoTextbox(webElement, "id",textValue, driver);
			runningLogger.writeToLog(loggerValues.textboxTypedInto+webElement+" : "+textValue);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testTypeIntoTextbox));
			assertionTest(codesForTest, webElement);
			runningLogger.writeToLog(loggerValues.typeIntoTextbox+webElement+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^type into textbox \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void typeIntoTextbox(String webElement, String tagType, String textValue)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.typeIntoTextbox+webElement);
			runnerCode = stepMethods.typeIntoTextbox(webElement, tagType, textValue, driver);
			runningLogger.writeToLog(loggerValues.textboxTypedInto+webElement+" : "+textValue);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testTypeIntoTextbox));
			assertionTest(codesForTest, webElement);
			runningLogger.writeToLog(loggerValues.typeIntoTextbox+webElement+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^click the element \"([^\"]*)\"$")
	public void clickSelectedElement(String webElement)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.clickElement+webElement);
			runnerCode = stepMethods.clickElement(webElement, "id", driver);
			runningLogger.writeToLog(loggerValues.elementClicked+webElement);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testClickButton));
			assertionTest(codesForTest, webElement);
			runningLogger.writeToLog(loggerValues.clickElement+webElement+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^click the element \"([^\"]*)\" \"([^\"]*)\"$")
	public void clickSelectedElement(String webElement, String tagType)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.clickElement+webElement);
			runnerCode = stepMethods.clickElement(webElement, tagType, driver);
			runningLogger.writeToLog(loggerValues.elementClicked+webElement);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testClickButton));
			assertionTest(codesForTest, webElement);
			runningLogger.writeToLog(loggerValues.clickElement+webElement+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^check correct page loaded \"([^\"]*)\"$")
	public void checkTheCorrectPageHasLoaded(String expectedPage)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.checkPageLoaded+expectedPage);
			runnerCode = stepMethods.checkCorrectPageReached(expectedPage, driver, false);
			runningLogger.writeToLog(loggerValues.pageLoaded+expectedPage);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToPage));
			assertionTest(codesForTest, expectedPage);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^check for table input \"([^\"]*)\"$")
	public void checkInputSanity(String tableId)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.createExpectedInputListTable+tableId);
			runnerCode = stepMethods.createExpectedInputList(tableId, "id", "table", driver);
			runningLogger.writeToLog(loggerValues.expectedInputCreated+tableId);
			
			if(runnerCode != 0)
			{
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.noInputsInContainerFail));
				assertionTest(codesForTest, tableId);
				codesForTest.clear();
			}
	 		List<WebElement> usableElements = stepMethods.getExpectedInputList();
			
			for(int i = 0; i < usableElements.size(); i++)
			{
				WebElement element = usableElements.get(i);
				String description = element.getAttribute("type")+": "+element.getAttribute("id");
				runningLogger.writeToLog(loggerValues.checkElementVisible+element.getAttribute("id"));
				runnerCode = stepMethods.checkElementIsVisible(element);
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementIsVisible));
				assertionTest(codesForTest, description);
				codesForTest.clear();
			}
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^check for table input \"([^\"]*)\" \"([^\"]*)\"$")
	public void checkInputSanity(String container, String tag)
	{
		try
		{
			if(tag.equals("class"))
			{
				runningLogger.writeToLog(loggerValues.createExpectedInputListTable+container);
				runnerCode = stepMethods.createExpectedInputList(container, tag, "table", driver);
				runningLogger.writeToLog(loggerValues.expectedInputCreated+container);
			}
				
			
			if(runnerCode != 0)
			{
				String tableId = tag+" - "+container;
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.noInputsInContainerFail));
				assertionTest(codesForTest, tableId);
				codesForTest.clear();
			}
			List<WebElement> usableElements = stepMethods.getExpectedInputList();
			
			for(int i = 0; i < usableElements.size(); i++)
			{
				WebElement element = usableElements.get(i);
				String description = element.getAttribute("type")+": "+element.getAttribute("id");
				runningLogger.writeToLog(loggerValues.checkElementVisible+element.getAttribute("id"));
				runnerCode = stepMethods.checkElementIsVisible(element);
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementIsVisible));
				assertionTest(codesForTest, description);
				codesForTest.clear();
			}
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^check impersonate functionality \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void checkImpersonateFunctionality(String impersonateButtonId, String revertButton, String expectedPage)
	{
		try
		{
			List<String> testStringInfo = new ArrayList<String>();
			String originalPage = driver.getCurrentUrl();
			
			testStringInfo.add(impersonateButtonId);
			testStringInfo.add(revertButton);
			testStringInfo.add(originalPage);
			testStringInfo.add(expectedPage);
			
			runnerCode = quickStepMethods.impersonateUserAndRevert(testStringInfo, driver);
			
			//TODO
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testImpersonateFunctionality));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^check column sort for table \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void checkSortColumnForTable(String tableId, String sortColumnButton, String firstColumn)
	{
		try
		{
			//TODO
			List<String> testStringInfo = new ArrayList<String>();
			
			testStringInfo.add(tableId);
			testStringInfo.add(sortColumnButton);
			testStringInfo.add(firstColumn);
			
			runnerCode = quickStepMethods.checkTableSort(testStringInfo, driver);
			
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testSortColumnFunctionality));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^move to the page \"([^\"]*)\" \"([^\"]*)\"$")
	public void moveToPage(String menuId, String page)
	{
		try
		{
			boolean skipPopup = true;
			String designatedPage = "";
			WebElement chosenElement = null;
			Set<WebElement> elementSet = new HashSet<WebElement>();
			List<WebElement> hrefTags = new ArrayList<WebElement>();
			
			try
			{
				runningLogger.writeToLog(loggerValues.checkElement+menuId);
				WebElement menuDiv = driver.findElement(By.id(menuId));
				List<WebElement> navigationOptions = menuDiv.findElements(By.tagName("a"));
				
				for(WebElement o : navigationOptions)
				{
					if(o.getAttribute("class").equals("popout level1 static"))
						skipPopup = false;
					String href = o.getAttribute("href");
					String hrefId = href.substring(href.lastIndexOf("/")+1, href.length());
					if(hrefId.endsWith("#"))
					{
						hrefId = hrefId.substring(0, hrefId.length()-1);
					}
					WebElement hrefElement = o.findElement(By.xpath("//a[contains(@href,'"+hrefId+"')]"));
					hrefTags.add(hrefElement);
				}
				
				elementSet.addAll(hrefTags);
				hrefTags.clear();
				hrefTags.addAll(elementSet);
					
				for(WebElement navElement : hrefTags)
				{
					if(navElement.getAttribute("href").equals(page))
					{
						designatedPage = navElement.getAttribute("href");
						chosenElement = navElement;
					}
				}
			}
			catch(Exception e)
			{
				runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
				runnerCode = testCodes.elementNotFound;
			}
			
			if(runnerCode != 0)
			{
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementExists));
				assertionTest(codesForTest, menuId);
				codesForTest.clear();
			}
			else
			{
				String href = chosenElement.getAttribute("href");
				String hrefId = href.substring(href.lastIndexOf("/")+1, href.length());
				String description = hrefId;
				runningLogger.writeToLog(loggerValues.moveToAnotherPage+page);
				runnerCode = stepMethods.clickNavigationElement(menuId, chosenElement, designatedPage, skipPopup, driver);
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToPage));
				assertionTest(codesForTest, description);
				codesForTest.clear();
			}
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	
	@Then("^check page navigation is correctly working \"([^\"]*)\"$")
	public void checkNavigationWorks(String menuId)
	{
		try
		{
			runningLogger.writeToLog(loggerValues.checkNavigationWorking);
			boolean skipPopup = true;
			List<String> hrefList = new ArrayList<String>();
			Set<WebElement> elementSet = new HashSet<WebElement>();
			List<WebElement> hrefTags = new ArrayList<WebElement>();
			
			try
			{
				WebElement menuDiv = driver.findElement(By.id(menuId));
				List<WebElement> navigationOptions = menuDiv.findElements(By.tagName("a"));
				
				for(WebElement o : navigationOptions)
				{
					if(o.getAttribute("class").equals("popout level1 static"))
						skipPopup = false;
					String href = o.getAttribute("href");
					String hrefId = href.substring(href.lastIndexOf("/")+1, href.length());
					if(hrefId.endsWith("#"))
					{
						hrefId = hrefId.substring(0, hrefId.length()-1);
					}
					WebElement hrefElement = o.findElement(By.xpath("//a[contains(@href,'"+hrefId+"')]"));
					hrefTags.add(hrefElement);
				}
				elementSet.addAll(hrefTags);
				hrefTags.clear();
				hrefTags.addAll(elementSet);
				
				for(WebElement navElement : hrefTags)
				{
					String href = navElement.getAttribute("href");
					String hrefId = href.substring(href.lastIndexOf("/")+1, href.length());
					hrefList.add(hrefId);
				}
				
				for(String hrefSearch : hrefList)
				{
					WebElement navigationElement = driver.findElement(By.xpath("//a[contains(@href,'"+hrefSearch+"')]"));
					String expectedPage = navigationElement.getAttribute("href");
					String href = navigationElement.getAttribute("href");
					String hrefId = href.substring(href.lastIndexOf("/")+1, href.length());
					String description = hrefId;
					runningLogger.writeToLog(loggerValues.clickElement+navigationElement);
					runnerCode = stepMethods.clickNavigationElement(menuId, navigationElement, expectedPage, skipPopup, driver);
					codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToPage));
					assertionTest(codesForTest, description);
					codesForTest.clear();
				}
			}
			catch(Exception e)
			{
				runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToPage));
				assertionTest(codesForTest, menuId);
				codesForTest.clear();
			}
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
//##############################################################################################################################
	
	@Then("^log in as cms admin$")
	public void logInAsCmsAdmin()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsAdmin);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/CMSFleetManager.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSAdminProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as cms supervisor$")
	public void logInAsCmsSupervisor()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsSupervisor);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/AnalysisAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSSupervisorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as cms operator$")
	public void logInAsCmsOperator()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsOperator);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/CMSAnalystHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCMSOperatorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsOperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch admin$")
	public void logInAsChAdmin()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHAdmin);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimsHandlerRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHAdminProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch supervisor$")
	public void logInAsChSupervisor()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHSupervisor);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHSupervisorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch operator$")
	public void logInAsChOperator()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHOperator);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimHandlerHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHOperatorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHOperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr admin$")
	public void logInAsRrAdmin()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRRAdmin);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/RapidResponderRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRRAdminProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRRAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr supervisor$")
	public void logInAsRrSupervisor()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRRSupervisor);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/FNOLIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRRSupervisorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRRSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr operator$")
	public void logInAsRrOperator()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRROperator);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/FleetOperatorHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRROperatorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRROperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as cms admin production$")
	public void logInAsCmsAdminProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsAdmin+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/CMSFleetManager.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSAdminProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as cms supervisor production$")
	public void logInAsCmsSupervisorProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsSupervisor+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/AnalysisAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSSupervisorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as cms operator production$")
	public void logInAsCmsOperatorProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsOperator+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/CMSAnalystHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCMSOperatorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsOperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch admin production$")
	public void logInAsChAdminProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHAdmin+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimsHandlerRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHAdminProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch supervisor production$")
	public void logInAsChSupervisorProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHSupervisor+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHSupervisorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch operator production$")
	public void logInAsChOperatorProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHOperator+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimHandlerHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHOperatorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHOperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr admin production$")
	public void logInAsRrAdminProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRRAdmin+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/RapidResponderRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRRAdminProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRRAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr supervisor production$")
	public void logInAsRrSupervisorProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRRSupervisor+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/FNOLIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRRSupervisorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRRSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr operator production$")
	public void logInAsRrOperatorProduction()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRROperator+loggerValues.production);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/FleetOperatorHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRROperatorProd));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRROperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as cms admin qa$")
	public void logInAsCmsAdminQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsAdmin+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSAdminQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as cms supervisor qa$")
	public void logInAsCmsSupervisorQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsSupervisor+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/AnalysisAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSSupervisorQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as cms operator qa$")
	public void logInAsCmsOperatorQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCmsOperator+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/CMSAnalystHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSOperatorQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCmsOperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch admin qa$")
	public void logInAsChAdminQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHAdmin+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/ClaimsHandlerRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCHAdminQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch supervisor qa$")
	public void logInAsChSupervisorQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHSupervisor+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/ClaimIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCHSupervisorQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as ch operator qa$")
	public void logInAsChOperatorQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsCHOperator+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/ClaimHandlerHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCHOperatorQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsCHOperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr admin qa$")
	public void logInAsRrAdminQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRRAdmin+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/RapidResponderRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsRRAdminQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRRAdmin+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr supervisor qa$")
	public void logInAsRrSupervisorQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRRSupervisor+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/FNOLIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsRRSupervisorQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRRSupervisor+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	@Then("^log in as rr operator qa$")
	public void logInAsRrOperatorQa()
	{
		try
		{
			runningLogger.writeToLog(loggerValues.loginAsRROperator+loggerValues.qa);
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://qa.cmsdriveguard.co.uk/FleetOperatorHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsRROperatorQa));
			assertionTest(codesForTest, "");
			runningLogger.writeToLog(loggerValues.loginAsRROperator+loggerValues.asserted);
			codesForTest.clear();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
//###############################################################################################################################	
	
	private void assertionTest(List<Integer> testCodes, String testString)
	{
		List<String> stringValues = new ArrayList<String>();
		List<Boolean> boolValues = new ArrayList<Boolean>();
		stringValues.addAll(Arrays.asList(scenario.getName(), currentBrowser));
		try
		{
			boolValues.addAll(Arrays.asList(createTitle, false, failTitleAlreadyAdded));
			createTitle = cew.createTestTitle(boolValues, stringValues);
			assertEquals(runnerCode, 0);
			testStep++;
			codesForTest.add(testStep);
			cew.appendExcelSpreadsheet(stringValues, codesForTest, testString, failTitleAlreadyAdded);
			boolValues.clear();
			System.out.println("PASS");
		}
		catch(AssertionError e)
		{
			boolValues.clear();
			createTitle = true;
			boolValues.addAll(Arrays.asList(createTitle, true, failTitleAlreadyAdded));
			failTitleAlreadyAdded = true;
			testStep++;
			codesForTest.add(testStep);
			createTitle = cew.createTestTitle(boolValues, stringValues);
			cew.appendExcelSpreadsheet(stringValues, codesForTest, testString, failTitleAlreadyAdded);
			boolValues.clear();
			System.out.println("FAIL");
		}
	}
}
