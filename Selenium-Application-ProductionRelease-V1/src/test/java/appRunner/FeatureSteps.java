package appRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import consoleRunner.ConsoleRunner;
import testCodes.TestCodes;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fileCreator.CreateExcelWorkbook;
import loggingCode.RunningLoggerStringValues;
import testStepMethods.QuickStepMethods;
import testStepMethods.StepMethods;

public class FeatureSteps 
{
	boolean createTitle = true;
	boolean failTitleAlreadyAdded = false;
	
	Scenario scenario;
	static WebDriver driver = null;
	
	List<Integer> codesForTest = new ArrayList<Integer>();

	
	int runnerCode = 0;
	int testStep = 0;
	static int testNumber = 0;
	
	String currentBrowser;
	
	StepMethods stepMethods = new StepMethods();
	
	QuickStepMethods quickStepMethods = new QuickStepMethods();
	
	RunningLoggerStringValues loggerValues = new RunningLoggerStringValues();
	
	
	TestCodes testCodes = new TestCodes();
	
	CreateExcelWorkbook cew = new CreateExcelWorkbook();
	
	@Before
	public void before(Scenario scenarioTemp)
	{
		testNumber++;
		this.scenario = scenarioTemp;
	}
	
	@Given("^The driver is open \"([^\"]*)\"$")
	public void openDriver(String browser)
	{
		try
		{
			currentBrowser = browser;
			if(browser.equals("Chrome"))
			{
				if(driver == null)
				{
				    ChromeOptions chromeOptions = new ChromeOptions();
					//chromeOptions.setHeadless(true);
					//chromeOptions.setProxy(null);
					
					String f = new File("").getAbsolutePath();
					
					System.setProperty("webdriver.chrome.driver", f+"//Misc//webDrivers//chromedriver.exe");
					driver = new ChromeDriver(chromeOptions);
				}
			}
			if(browser.equals("IE"))
			{
				String f = new File("").getAbsolutePath();
				System.setProperty("webdriver.ie.driver", f+"//Misc//webDrivers//IEDriverServer.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				driver = new InternetExplorerDriver();
			}
			if(browser.equals("Opera"))
			{
				String f = new File("").getAbsolutePath();
				System.setProperty("webdriver.chrome.driver", f+"//Misc//webDrivers//operadriver.exe");
				driver = new ChromeDriver();
			}
			if(browser.equals("Edge"))
			{
				String f = new File("").getAbsolutePath();
				System.setProperty("webdriver.edge.driver", f+"//Misc//webDrivers//MicrosoftWebDriver.exe");
				driver = new EdgeDriver();
			}
			runnerCode = stepMethods.openTheDriver(browser, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.driverError, testCodes.testOpenBrowser));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
		
	}
	
	@When("^The window is maximised$")
	public void maximiseBrowserWindow()
	{
		try
		{
			runnerCode = stepMethods.maximiseTheBrowser(driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.driverError, testCodes.testMaximiseScreen));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^close the driver$")
	public void closeDriver()
	{
		try
		{
			int totalTests = ConsoleRunner.getTestTotal();
			if(totalTests == testNumber)
			{
				runnerCode = stepMethods.closeTheDriver(driver);
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.driverError, testCodes.testCloseBrowser));
				assertionTest(codesForTest, "");
				codesForTest.clear();
			}
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("wait specified time \"([^\"]*)\"$")
	public void waitForSpecifiedTime(String timeSeconds)
	{
		String intString = timeSeconds;
		int stringToInt = Integer.parseInt(intString);
		try
		{
			TimeUnit.SECONDS.sleep(stringToInt);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Then("^navigate to DriveGuard$")
	public void navigateToDriveGuard()
	{
		try
		{
			runnerCode = stepMethods.checkCorrectPageReached("https://cmsdriveguard.co.uk/Account/Login", driver, false);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToDriveGuardProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^navigate to DriveGuard production$")
	public void navigateToDriveGuardProduction()
	{
		try
		{
			runnerCode = stepMethods.checkCorrectPageReached("https://cmsdriveguard.co.uk/Account/Login", driver, false);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToDriveGuardProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^navigate to DriveGuard qa$")
	public void navigateToDriveGuardQa()
	{
		try
		{
			runnerCode = stepMethods.checkCorrectPageReached("https://qa.cmsdriveguard.co.uk/Account/Login", driver, false);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToDriveGuardQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^check the element exists \"([^\"]*)\"$")
	public void checkElementExists(String webElement)
	{
		try
		{
			runnerCode = stepMethods.checkElement(webElement, "id", driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementExists));
			assertionTest(codesForTest, webElement);
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^check the element exists \"([^\"]*)\" \"([^\"]*)\"$")
	public void checkElementExists(String webElement, String tagType)
	{
		try
		{
			runnerCode = stepMethods.checkElement(webElement, tagType, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementExists));
			assertionTest(codesForTest, webElement);
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^type into textbox \"([^\"]*)\" \"([^\"]*)\"$")
	public void typeIntoTextbox(String webElement, String textValue)
	{
		try
		{
			runnerCode = stepMethods.typeIntoTextbox(webElement, "id",textValue, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testTypeIntoTextbox));
			assertionTest(codesForTest, webElement);
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^type into textbox \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void typeIntoTextbox(String webElement, String tagType, String textValue)
	{
		try
		{
			runnerCode = stepMethods.typeIntoTextbox(webElement, tagType, textValue, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testTypeIntoTextbox));
			assertionTest(codesForTest, webElement);
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^click the element \"([^\"]*)\"$")
	public void clickSelectedElement(String webElement)
	{
		try
		{
			runnerCode = stepMethods.clickElement(webElement, "id", driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testClickButton));
			assertionTest(codesForTest, webElement);
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^check the element within iFrame \"([^\"]*)\" \"([^\"]*)\"$")
	public void checkSelectedElementWithinIframe(String elementToCheckId, String iFrameElementId)
	{
		runnerCode = stepMethods.checkElementWithinIframe(elementToCheckId, iFrameElementId, "id", "id", driver);
		codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementWithinIframe));
		assertionTest(codesForTest, elementToCheckId);
		codesForTest.clear();
	}
	
	@Then("^click the element within iFrame \"([^\"]*)\" \"([^\"]*)\"$")
	public void clickSelectedElementWithinIframe(String elementToClickId, String iFrameElementId)
	{
		runnerCode = stepMethods.clickElementWithinIframe(elementToClickId, iFrameElementId, "id", "id", driver);
		codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testClickOnElementWithinIframe));
		assertionTest(codesForTest, elementToClickId);
		codesForTest.clear();
	}
	
	@Then("^click the element within iFrame \"([^\"]*)\" \"([^\"]*) \"([^\"]*)\" \"([^\"]*)\"$")
	public void clickSelectedElementWithinIframe(String elementToClickId, String iFrameElementId, String elementToClickTag, String iframeToClickTag)
	{
		runnerCode = stepMethods.clickElementWithinIframe(elementToClickId, iFrameElementId, elementToClickTag, iframeToClickTag, driver);
		codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testClickOnElementWithinIframe));
		assertionTest(codesForTest, elementToClickId);
		codesForTest.clear();
	}
	
	@Then("^select option from dropdown box \"([^\"]*)\" \"([^\"]*)\"$")
	public void selectOptionFromDropdown(String dropDownId, String dropdownOptionNumber)
	{
		int dropdownOption = Integer.parseInt(dropdownOptionNumber);
		runnerCode = stepMethods.selectOptionFromDropdown(dropDownId, "id", dropdownOption, driver);
		codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.selectOptionOnDropdownBox));
		assertionTest(codesForTest, dropDownId);
		codesForTest.clear();
	}
	
	@Then("^select option from dropdown box \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void selectOptionFromDropdown(String dropDownId, String tag, String dropdownOptionNumber)
	{
		int dropdownOption = Integer.parseInt(dropdownOptionNumber);
		runnerCode = stepMethods.selectOptionFromDropdown(dropDownId, tag, dropdownOption, driver);
		codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.selectOptionOnDropdownBox));
		assertionTest(codesForTest, dropDownId);
		codesForTest.clear();
	}
	
	@Then("^click the alert window$")
	public void clickAlertBox()
	{
		runnerCode = stepMethods.clickOnAlertBox(driver);
		codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.clickOnAlertBox));
		assertionTest(codesForTest, "");
		codesForTest.clear();

	}
	
	@Then("^check login attempt was successful \"([^\"]*)\"$")
	public void checkLoginWasSuccessful(String expectedPage)
	{
		try
		{
			runnerCode = stepMethods.assertCorrectPageHasLoadedForLogin(expectedPage, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testGenericLogin));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^click the element \"([^\"]*)\" \"([^\"]*)\"$")
	public void clickSelectedElement(String webElement, String tagType)
	{
		try
		{
			runnerCode = stepMethods.clickElement(webElement, tagType, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testClickButton));
			assertionTest(codesForTest, webElement);
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^check correct page loaded \"([^\"]*)\"$")
	public void checkTheCorrectPageHasLoaded(String expectedPage)
	{
		try
		{
			runnerCode = stepMethods.checkCorrectPageReached(expectedPage, driver, false);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToPage));
			assertionTest(codesForTest, expectedPage);
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^check for table input \"([^\"]*)\"$")
	public void checkForTableInput(String tableId)
	{
		try
		{
			runnerCode = stepMethods.createExpectedInputList(tableId, "id", "table", driver);
			
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
				runnerCode = stepMethods.checkElementIsVisible(element);
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementIsVisible));
				assertionTest(codesForTest, description);
				codesForTest.clear();
			}
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^check for table input \"([^\"]*)\" \"([^\"]*)\"$")
	public void checkForTableInput(String container, String tag)
	{
		try
		{
			if(tag.equals("class"))
			{
				runnerCode = stepMethods.createExpectedInputList(container, tag, "table", driver);
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
				runnerCode = stepMethods.checkElementIsVisible(element);
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.testCheckElementIsVisible));
				assertionTest(codesForTest, description);
				codesForTest.clear();
			}
		}
		catch(Exception e)
		{
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
		}
	}
	
	@Then("^impersonate user \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void impersonateUser(String originalUser, String userToImpersonate, String expectedPage)
	{
		try
		{
			List<String> testStringInfo = new ArrayList<String>();
			String impersonateButton = "";
			
			if(originalUser.equals("rr admin"))
				if(userToImpersonate.equals("rr operator"))
					impersonateButton = "ctl00_MainContent_gvwUsers_ctl03_btnImpersonate";
				else if(userToImpersonate.equals("rr supervisor"))
					impersonateButton = "ctl00_MainContent_gvwUsers_ctl04_btnImpersonate";
			
			testStringInfo.add(impersonateButton);
			testStringInfo.add(expectedPage);
			
			runnerCode = quickStepMethods.impersonateUser(testStringInfo, driver);
			
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.impersonateUser));
			assertionTest(codesForTest, userToImpersonate);
			codesForTest.clear();
			
		}
		catch(Exception e)
		{
			
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
				runnerCode = stepMethods.clickNavigationElement(menuId, chosenElement, designatedPage, skipPopup, driver);
				codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToPage));
				assertionTest(codesForTest, description);
				codesForTest.clear();
			}
		}
		catch(Exception e)
		{
		}
	}
	
	
	@Then("^check page navigation is correctly working \"([^\"]*)\"$")
	public void checkNavigationWorks(String menuId)
	{
		try
		{
			boolean elementFound = false;
			boolean skipPopup = true;
			List<String> hrefList = new ArrayList<String>();
			Set<WebElement> elementSet = new HashSet<WebElement>();
			List<WebElement> hrefTags = new ArrayList<WebElement>();
			
			try
			{
				WebElement menuDiv = driver.findElement(By.id(menuId));
				elementFound = true;
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
					runnerCode = stepMethods.clickNavigationElement(menuId, navigationElement, expectedPage, skipPopup, driver);
					codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToPage));
					assertionTest(codesForTest, description);
					codesForTest.clear();
				}
			}
			catch(Exception e)
			{
				if(elementFound == false)
				{
					runnerCode = testCodes.elementNotFound;
					codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webElementError, testCodes.findNavigationBar));
					assertionTest(codesForTest, menuId);
					codesForTest.clear();
				}
				else
				{
					codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webAddressError, testCodes.testNavigateToPage));
					assertionTest(codesForTest, menuId);
					codesForTest.clear();
				}

			}
		}
		catch(Exception e)
		{
		}
	}
	
//##############################################################################################################################
	
	@Then("^log in as cms admin$")
	public void logInAsCmsAdmin()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/CMSFleetManager.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSAdminProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as cms supervisor$")
	public void logInAsCmsSupervisor()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/AnalysisAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSSupervisorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as cms operator$")
	public void logInAsCmsOperator()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/CMSAnalystHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCMSOperatorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch admin$")
	public void logInAsChAdmin()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimsHandlerRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHAdminProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch supervisor$")
	public void logInAsChSupervisor()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHSupervisorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch operator$")
	public void logInAsChOperator()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimHandlerHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHOperatorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr admin$")
	public void logInAsRrAdmin()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/RapidResponderRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRRAdminProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr supervisor$")
	public void logInAsRrSupervisor()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/FNOLIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRRSupervisorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr operator$")
	public void logInAsRrOperator()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/FleetOperatorHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRROperatorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as cms admin production$")
	public void logInAsCmsAdminProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/CMSFleetManager.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSAdminProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as cms supervisor production$")
	public void logInAsCmsSupervisorProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/AnalysisAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSSupervisorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as cms operator production$")
	public void logInAsCmsOperatorProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/CMSAnalystHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCMSOperatorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch admin production$")
	public void logInAsChAdminProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimsHandlerRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHAdminProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch supervisor production$")
	public void logInAsChSupervisorProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHSupervisorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch operator production$")
	public void logInAsChOperatorProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/ClaimHandlerHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsCHOperatorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr admin production$")
	public void logInAsRrAdminProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/RapidResponderRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRRAdminProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr supervisor production$")
	public void logInAsRrSupervisorProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/FNOLIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRRSupervisorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr operator production$")
	public void logInAsRrOperatorProduction()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "",
					"", "LoginButton", "https://cmsdriveguard.co.uk/FleetOperatorHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.loginUnsuccessful, testCodes.testLoginAsRROperatorProd));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as cms admin qa$")
	public void logInAsCmsAdminQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms07@collisionmanagementsystems.co.uk",
					"QApassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/CMSFleetManager.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSAdminQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as cms supervisor qa$")
	public void logInAsCmsSupervisorQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms08@collisionmanagementsystems.co.uk",
					"QApassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/AnalysisAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSSupervisorQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as cms operator qa$")
	public void logInAsCmsOperatorQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms09@collisionmanagementsystems.co.uk",
					"QApassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/CMSAnalystHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCMSOperatorQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch admin qa$")
	public void logInAsChAdminQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms04@collisionmanagementsystems.co.uk",
					"QACHpassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/ClaimsHandlerRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCHAdminQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch supervisor qa$")
	public void logInAsChSupervisorQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms05@collisionmanagementsystems.co.uk",
					"QACHpassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/ClaimIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCHSupervisorQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as ch operator qa$")
	public void logInAsChOperatorQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms06@collisionmanagementsystems.co.uk",
					"QACHpassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/ClaimHandlerHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsCHOperatorQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr admin qa$")
	public void logInAsRrAdminQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms01@collisionmanagementsystems.co.uk",
					"QARRpassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/RapidResponderRolesAndUsers.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsRRAdminQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr supervisor qa$")
	public void logInAsRrSupervisorQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms02@collisionmanagementsystems.co.uk",
					"QARRpassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/FNOLIncidentAuditTrail.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsRRSupervisorQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
		}
	}
	
	@Then("^log in as rr operator qa$")
	public void logInAsRrOperatorQa()
	{
		try
		{
			List<String> pageInfo = new ArrayList<String>();
			pageInfo.addAll(Arrays.asList("txtEmail", "txtPassword", "test.cms03@collisionmanagementsystems.co.uk",
					"QARRpassword1!", "LoginButton", "https://qa.cmsdriveguard.co.uk/FleetOperatorHome.aspx"));
			runnerCode = quickStepMethods.logInAsUser(pageInfo, driver);
			codesForTest.addAll(Arrays.asList(runnerCode, testCodes.webPageFunctionalityError, testCodes.testLoginAsRROperatorQa));
			assertionTest(codesForTest, "");
			codesForTest.clear();
		}
		catch(Exception e)
		{
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
