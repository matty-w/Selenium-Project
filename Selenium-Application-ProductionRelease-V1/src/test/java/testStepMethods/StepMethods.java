package testStepMethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import loggingCode.RunningLogger;
import loggingCode.RunningLoggerStringValues;
import testCodes.TestCodes;

public class StepMethods 
{
	List<WebElement> inputElements = new ArrayList<WebElement>();
	List<WebElement> usableElements = new ArrayList<WebElement>();
	
	GenericMethods genericMethod = new GenericMethods();
	
	RunningLogger runningLogger = new RunningLogger();
	RunningLoggerStringValues loggerValues = new RunningLoggerStringValues();
	TestCodes tc = new TestCodes();
	
	public int openTheDriver(String driverChoice, WebDriver webDriver)
	{
		int testCode = 0;
		if(driverChoice.equals("Chrome"))
		{
			testCode = genericMethod.checkDriverIsOpen(webDriver);
			return testCode;
		}
		return testCode;
	}
	
	public int maximiseTheBrowser(WebDriver webDriver)
	{
		int testCode = 0;
		try
		{
			runningLogger.writeToLog("Maximise Window");
			webDriver.manage().window().maximize();
			runningLogger.writeToLog("Window Maximised");
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
		
		testCode = genericMethod.checkScreenHasMaximised(webDriver);
		return testCode;
	}
	
	public int closeTheDriver(WebDriver webDriver)
	{
		int testCode = 0;
		try
		{
			webDriver.quit();
			testCode = genericMethod.checkDriverHasClosed(webDriver);
			return testCode;
		}
		catch(Exception e)
		{
			testCode = tc.driverCloseError;
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
			return testCode;
		}
	}
	
	public int checkCorrectPageReached(String pageToNavigateTo, WebDriver webDriver, boolean loginAttempt)
	{
		int testCode = 0;
		testCode = genericMethod.goToPage(pageToNavigateTo, webDriver);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.checkPageReached(pageToNavigateTo, webDriver, loginAttempt);
		if(testCode != 0)
			return testCode;
		
		return testCode;
	}
	
	public int assertPageTransitionSuccessful(String pageToNavigateTo, WebDriver webDriver, boolean loginAttempt)
	{
		int testCode = 0;
		testCode = genericMethod.loadPage(pageToNavigateTo, webDriver);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.checkPageReached(pageToNavigateTo, webDriver, loginAttempt);
		if(testCode != 0)
			return testCode;
		
		return testCode;
	}
	
	public int checkElement(String elementID, String tagType, WebDriver webDriver)
	{
		int testCode = 0;
		testCode = genericMethod.verifyElement(elementID, tagType, webDriver);
		if(testCode != 0)
			return testCode;
		WebElement webElement = createConfirmedElement(elementID, tagType, webDriver);
		testCode = genericMethod.elementIsVisible(webElement);
		if(testCode != 0)
			return testCode;
		return testCode;
	}
	
	public int sortAndCheckTable(String sortButtonId, String topColumnId, String sortButtonTag, String topColumnTag, WebDriver webDriver)
	{
		//TODO
		int testCode = 0;
		testCode = genericMethod.verifyElement(topColumnId, topColumnTag, webDriver);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.verifyElement(sortButtonId, sortButtonTag, webDriver);
		if(testCode != 0)
			return testCode;
		WebElement webElementBeforeSort = createConfirmedElement(topColumnId, topColumnTag, webDriver);
		String webElementString = webElementBeforeSort.findElement(By.xpath("//span")).getText();
		runningLogger.writeToLog(webElementString);
		WebElement sortButton = createConfirmedElement(sortButtonId, sortButtonTag, webDriver);
		testCode = genericMethod.clickElement(sortButton, webDriver);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.verifyElement(topColumnId, topColumnTag, webDriver);
		if(testCode != 0)
			return testCode;
		WebElement webElementAfterSort = createConfirmedElement(topColumnId, topColumnTag, webDriver);
		String webElementString2 = webElementAfterSort.findElement(By.xpath("//span")).getText();
		runningLogger.writeToLog(webElementString2);
		testCode = genericMethod.compareSortStrings(webElementString, webElementString2);
		if(testCode != 0)
			return testCode;
		return testCode;
	}
	
	public int typeIntoTextbox(String elementID, String tagType, String textValue, WebDriver webDriver)
	{
		int testCode = 0;
		
		testCode = genericMethod.verifyElement(elementID, tagType, webDriver);
		if(testCode != 0)
			return testCode;
		WebElement element = createConfirmedElement(elementID, tagType, webDriver);
		testCode = genericMethod.elementIsVisible(element);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.clickElement(element, webDriver);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.clearElement(element, webDriver);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.typeValueIntoElement(element, textValue, webDriver);
		if(testCode != 0)
			return testCode;
		
		return testCode;
	}
	
	public int clickElement(String elementTag, String tagType, WebDriver webDriver)
	{
		int testCode = 0;
		testCode = genericMethod.verifyElement(elementTag, tagType, webDriver);
		if(testCode != 0)
			return testCode;
		WebElement element = createConfirmedElement(elementTag, tagType, webDriver);
		testCode = genericMethod.elementIsVisible(element);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.clickElement(element, webDriver);
		if(testCode != 0)
			return testCode;
		return testCode;
	}
	
	public int selectOptionFromDropdown(String elementId, String tagType, int option, WebDriver webDriver)
	{
		int testCode = 0;
		testCode = genericMethod.verifyElement(elementId, tagType, webDriver);
		if(testCode != 0)
			return testCode;
		WebElement element = createConfirmedElement(elementId, tagType, webDriver);
		testCode = genericMethod.elementIsVisible(element);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.selectOptionFromDropdown(element, option);
		
		return testCode;
	}
	
	public int clickElementWithinIframe(String elementTag, String iFrameElement, String tagTypeElement, String tagTypeFrame, WebDriver webDriver)
	{
		int testCode = 0;
		testCode = genericMethod.createIframeDriver(iFrameElement, tagTypeFrame, webDriver);
		if(testCode != 0)
			return testCode;
		webDriver.switchTo().defaultContent();
		WebDriver iFrameDriver = createIframeDriver(iFrameElement, webDriver);
		testCode = genericMethod.verifyElement(elementTag, tagTypeElement, iFrameDriver);
		if(testCode != 0)
			return testCode;
		WebElement element = createConfirmedElement(elementTag, tagTypeElement, webDriver);
		testCode = genericMethod.elementIsVisible(element);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.clickIframeElement(element, iFrameDriver);
		if(testCode != 0)
			return testCode;
		webDriver.switchTo().defaultContent();
		return testCode;
	}
	
	public int checkElementWithinIframe(String elementTag, String iFrameElement, String tagTypeElement, String tagTypeFrame, WebDriver webDriver)
	{
		int testCode = 0;
		testCode = genericMethod.createIframeDriver(iFrameElement, tagTypeFrame, webDriver);
		if(testCode != 0)
			return testCode;
		webDriver.switchTo().defaultContent();
		WebDriver iFrameDriver = createIframeDriver(iFrameElement, webDriver);
		testCode = genericMethod.verifyElement(elementTag, tagTypeElement, iFrameDriver);
		if(testCode != 0)
			return testCode;
		WebElement element = createConfirmedElement(elementTag, tagTypeElement, webDriver);
		testCode = genericMethod.elementIsVisible(element);
		if(testCode != 0)
			return testCode;
		webDriver.switchTo().defaultContent();
		return testCode;
	}
	
	public int clickOnAlertBox(WebDriver webDriver)
	{
		int testCode = 0;
		testCode = genericMethod.isAlertPresent(webDriver);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.clickAlertBox(webDriver);
		if(testCode != 0)
			return testCode;
		webDriver.switchTo().defaultContent();
		return testCode;
		
	}
	
	private WebDriver createIframeDriver(String frameId, WebDriver webDriver) 
	{
		WebElement iFrame = webDriver.findElement(By.id(frameId));
		WebDriver driver2 = webDriver.switchTo().frame(iFrame);
		return driver2;
	}

	public int assertCorrectPageHasLoadedForLogin(String expectedPage, WebDriver webDriver)
	{
		int testCode = 0;
		testCode = genericMethod.checkPageReached(expectedPage, webDriver, true);		
		return testCode;
	}
	
	public int clickNavigationElement(String menuId,WebElement navElement,String expectedPage,boolean skipPopMenu,WebDriver driver) 
	{
		int testCode = 0;
		WebElement menuDiv = driver.findElement(By.id(menuId));
		if(skipPopMenu == true)
		{
			testCode = genericMethod.clickElement(navElement, driver);
		}
		else
		{
			List<WebElement> popoutMenuOptions = menuDiv.findElements(By.cssSelector("li.has-popup.static"));
			if(navElement.isDisplayed())
			{
				testCode = genericMethod.clickElement(navElement, driver);
			}
			else
			{
				for(WebElement dropdownOption : popoutMenuOptions)
				{
					dropdownOption.click();
					if(navElement.isDisplayed())
					{
						testCode = genericMethod.clickElement(navElement, driver);
						break;
					}
				}
			}
		}

		if(testCode != 0)
			return testCode;
		testCode = genericMethod.loadPage(expectedPage, driver);
		if(testCode != 0)
			return testCode;
		testCode = genericMethod.checkPageReached(expectedPage, driver, false);
		if(testCode != 0)
			return testCode;
		return testCode;
	}
	
	public int checkElementIsVisible(WebElement element)
	{
		int testCode = 0;
		testCode = genericMethod.elementIsVisible(element);
		return testCode;
	}
	
	public int checkElemetIsEnabled(WebElement element)
	{
		int testCode = 0;
		testCode = genericMethod.elementIsEnabled(element);
		return testCode;
	}
	
	private WebElement createConfirmedElement(String elementTag, String tagType, WebDriver webDriver)
	{
		WebElement element = null;
		if(tagType.equals("id"))
			element = webDriver.findElement(By.id(elementTag));
		else if(tagType.equals("name"))
			element = webDriver.findElement(By.name(elementTag));
		else if(tagType.equals("class"))
			element = webDriver.findElement(By.className(elementTag));
		else if(tagType.equals("css"))
			element = webDriver.findElement(By.cssSelector(elementTag));
		else if(tagType.equals("href"))
		{
			String href = elementTag;
			element = webDriver.findElement(By.xpath(href));
		}

		
		return element;
	}
	
	public int createExpectedInputList(String container, String tag, String divOrTable, WebDriver webDriver)
	{
		int testCode = 0;
		
		if(divOrTable.equals("table"))
			testCode = genericMethod.createTableInputList(container, tag, webDriver);
		
		if(testCode == 0)
		{
			inputElements = genericMethod.getInputList();
			testCode = genericMethod.createExpectedInputList(inputElements, webDriver, container, tag);
			
			if(testCode == 0)
			{
				usableElements = genericMethod.getExpectedInputList();
				return testCode;
			}
		}
		return testCode;
	}			
	
	public List<WebElement> getInputList()
	{
		return inputElements;
	}
	
	public List<WebElement> getExpectedInputList()
	{
		return usableElements;
	}
}
