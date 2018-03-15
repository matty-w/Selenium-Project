package testStepMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import loggingCode.RunningLogger;
import loggingCode.RunningLoggerStringValues;
import testCodes.TestCodes;

public class GenericMethods 
{
	List<WebElement> inputElements = new ArrayList<WebElement>();
	List<WebElement> expectedInputList = new ArrayList<WebElement>();

	TestCodes tc = new TestCodes();
	RunningLogger runningLogger = new RunningLogger();
	RunningLoggerStringValues loggerValues = new RunningLoggerStringValues();
	
	public int checkDriverIsOpen(WebDriver webDriver)
	{
		String windowHandle = webDriver.getWindowHandle();
		boolean driverPresent = (!windowHandle.equals(null));
		if(driverPresent == true)
			return 0;
		else
			return tc.driverNotPresent;
	}
	
	public int checkScreenHasMaximised(WebDriver webDriver)
	{
		try
		{
			webDriver.getWindowHandle();
			return 0;
		}
		catch(NoSuchWindowException e)
		{
			return tc.couldntMaximiseScreen;
		}
	}
	
	public int checkDriverHasClosed(WebDriver webDriver)
	{
		boolean driverNotPresent = webDriver.toString().contains("(null)");
		if(driverNotPresent == true)
			return 0;
		else
			return tc.driverCloseError;
	}
	
	public int goToPage(String page, WebDriver webDriver)
	{
		try
		{
			int testCode = 0;
			JavascriptExecutor executor = (JavascriptExecutor)webDriver;
			webDriver.navigate().to(page);
			
			WebDriverWait wait = new WebDriverWait(webDriver, 10);
			 
			wait.until(new ExpectedCondition<Boolean>() 
			{
				public Boolean apply(WebDriver wdriver) 
				{
					return executor.executeScript("return document.readyState").equals("complete");
				}
			});
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = webDriver.findElement(By.tagName("html"));
			element.isDisplayed();
			
			return testCode;
		}
		catch(Exception e)
		{
			return tc.pageCannotLoad;
		}
	}
	
	public int loadPage(String page, WebDriver webDriver)
	{
		try
		{
			int testCode = 0;
			JavascriptExecutor executor = (JavascriptExecutor)webDriver;
			WebDriverWait wait = new WebDriverWait(webDriver, 10);
			wait.until(new ExpectedCondition<Boolean>() 
			{
				public Boolean apply(WebDriver wdriver) 
				{
					return executor.executeScript("return document.readyState").equals("complete");
				}
			});
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = webDriver.findElement(By.tagName("html"));
			element.isDisplayed();
			
			return testCode;
		}
		catch(Exception e)
		{
			return tc.pageCannotLoad;
		}
	}
	
	public int checkPageReached(String expectedWebPage, WebDriver webDriver, boolean loginAttempt)
	{
		try
		{
			int testCode = 0;
			String currentPage = webDriver.getCurrentUrl();
			boolean correctPageReached = currentPage.equals(expectedWebPage);
			if(correctPageReached == true)
				return testCode;
			else if(currentPage.equals("") || currentPage.equals(null))
				return tc.nullPageOrAddress;
			else if(correctPageReached == false)
			{
				if(loginAttempt == true)
					return tc.loginUnsuccessful;
				else
					return tc.incorrectPageReached;
			}
			
			return testCode;
		}
		catch (Exception e) 
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
			return tc.checkPageExceptionLeak;
		}
	}
	
	public int checkElementById(String elementID, WebDriver webDriver)
	{
		try
		{
			int testCode = 0;
			webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			WebElement element = webDriver.findElement(By.id(elementID));
			element.isDisplayed();
			
			return testCode;
		}
		catch(Exception e)
		{
			return tc.elementNotFound;
		}
	}
	
	public int elementIsVisible(WebElement webElement)
	{
		int testCode = 0;
		boolean isVisible = webElement.isDisplayed();
		if(isVisible == false)
			return tc.webElementNotVisible;
		else
			return testCode;
	}
	
	public int elementIsEnabled(WebElement webElement)
	{
		int testCode = 0;
		boolean isEnabled = webElement.isEnabled();
		if(isEnabled == false)
			return tc.elementNotFound;
		else
			return testCode;
	}
	
	public int verifyElement(String elementTag, String tagType, WebDriver webDriver)
	{
		try
		{
			int testCode = 0;
			if(tagType.equals("id"))
			{
				webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				WebElement element = webDriver.findElement(By.id(elementTag));
				element.isDisplayed();
				return testCode;
			}
			else if(tagType.equals("name"))
			{
				webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				WebElement element = webDriver.findElement(By.name(elementTag));
				element.isDisplayed();
				return testCode;
			}
			else if(tagType.equals("class"))
			{
				webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				WebElement element = webDriver.findElement(By.className(elementTag));
				element.isDisplayed();
				return testCode;
			}
			else if(tagType.equals("css"))
			{
				webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				WebElement element = webDriver.findElement(By.cssSelector(elementTag));
				element.isDisplayed();
				return testCode;
			}
			else if(tagType.equals("href"))
			{
				runningLogger.writeToLog("href1");
				webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				runningLogger.writeToLog("href2");
				
				
				String href = elementTag;
				runningLogger.writeToLog("href3");
				runningLogger.writeToLog("//*[@id='ctl00_MainContent_gvwUsers']/tbody/tr[1]/th[1]/a");
				runningLogger.writeToLog(elementTag);
				WebElement element = webDriver.findElement(By.xpath(href));
				runningLogger.writeToLog("href4");
				element.isDisplayed();
				runningLogger.writeToLog("href5");
				return testCode;
			}
			else
			{
				return tc.incorrectTagGivenInTest;
			}
				
		}
		catch(Exception e)
		{
			return tc.elementNotFound;
		}
	}
	
	public int createIframeDriver(String frameId, String tag ,WebDriver webDriver)
	{
		int testCode = 0;
		try
		{
			if(tag.equals("id"))
			{
				WebElement iFrame = webDriver.findElement(By.id(frameId));
				WebDriver driver2 = webDriver.switchTo().frame(iFrame);
				driver2.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				return testCode;
			}
			if(tag.equals("name"))
			{
				WebElement iFrame = webDriver.findElement(By.name(frameId));
				WebDriver driver2 = webDriver.switchTo().frame(iFrame);
				driver2.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				return testCode;
			}
			if(tag.equals("class"))
			{
				WebElement iFrame = webDriver.findElement(By.className(frameId));
				WebDriver driver2 = webDriver.switchTo().frame(iFrame);
				driver2.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				return testCode;
			}
			if(tag.equals("css"))
			{
				WebElement iFrame = webDriver.findElement(By.cssSelector(frameId));
				WebDriver driver2 = webDriver.switchTo().frame(iFrame);
				driver2.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
				return testCode;
			}
			else
			{
				return tc.incorrectTagGivenInTest;
			}
		}
		catch(Exception e)
		{
			return 1000;
		}
	}
	
	
	public int clickElement(WebElement element, WebDriver webDriver)
	{
		int testCode = 0;
		try
		{
			webDriver.switchTo().defaultContent();
			JavascriptExecutor executor = (JavascriptExecutor) webDriver;
			webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			new Actions(webDriver).moveToElement(element).perform();
			executor.executeScript("arguments[0].click();", element);
		}
		catch(Exception e)
		{
			if(e instanceof org.openqa.selenium.TimeoutException)
				testCode = tc.pageTimeoutOnElementClick;
			else	
				testCode = tc.elementCouldntBeClicked;
		}

		return testCode;
	}
	
	public int clearElement(WebElement element, WebDriver webDriver)
	{
		try
		{
			int testCode = 0;
			element.click();
			element.clear();
			String elementText = element.getAttribute("value");
			
			if(elementText.equals(""))
				testCode = 0;
			else
				testCode = tc.elementCouldntBeCleared;
			return testCode;
		}
		catch(Exception e)
		{
			return tc.checkPageExceptionLeak;
		}
	}
	
	public int typeValueIntoElement(WebElement textbox, String textValue, WebDriver webDriver)
	{
		int testCode = 0;
		textbox.click();
		textbox.clear();
		textbox.sendKeys(textValue);
		String textBoxText = textbox.getAttribute("value");
		
		if(textBoxText.equals(""))
			testCode = tc.couldntTypeValueInElement;
		return testCode;
	}
	
	public int createTableInputList(String container, String tag, WebDriver webDriver)
	{
		int testCode = 0;
		List<WebElement> tempInputList = new ArrayList<WebElement>();
		WebElement tableToTest = null;
		
		if(tag.equals("id"))
		{
			List<WebElement> tables = webDriver.findElements(By.xpath("//table[@id='"+container+"']"));
			if(tables.size() > 1)
			{
				for(WebElement table : tables)
				{
					if(table.isDisplayed())
					{
						tableToTest = table;
						break;
					}
				}
				
				try
				{
					webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					tempInputList = tableToTest.findElements(By.xpath(".//td//input | .//td//select | .//td//a "
							+ "| .//td//textarea | .//td//submit | .//td//radio |.//td//file") );
					webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
				catch(Exception e)
				{
					return tc.elementNotFound;
				}
			}
			else
			{
				try
				{
					webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					WebElement table = webDriver.findElement(By.xpath("//table[@id='"+container+"']"));
					tempInputList = table.findElements(By.xpath(".//td//input | .//td//select | .//td//a "
							+ "| .//td//textarea | .//td//submit | .//td//radio |.//td//file") );
					webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
				catch(Exception e)
				{
					return tc.elementNotFound;
				}
			}
		}

		if(tag.equals("class"))
		{
			List<WebElement> tables = webDriver.findElements(By.xpath("//table[@class='"+container+"']"));
			if(tables.size() > 1)
			{
				for(WebElement table : tables)
				{
					if(table.isDisplayed())
					{
						tableToTest = table;
						break;
					}
				}
				
				try
				{
					webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					tempInputList = tableToTest.findElements(By.xpath(".//td//input | .//td//select | .//td//a "
							+ "| .//td//textarea | .//td//submit | .//td//radio |.//td//file") );
					webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
				catch(Exception e)
				{
					return tc.elementNotFound;
				}
			}
			else
			{
				try
				{
					webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					WebElement table = webDriver.findElement(By.xpath("//table[@class='"+container+"']"));
					tempInputList = table.findElements(By.xpath(".//td//input | .//td//select | .//td//a "
							+ "| .//td//textarea | .//td//submit | .//td//radio |.//td//file") );
					webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
				catch(Exception e)
				{
					return tc.elementNotFound;
				}
			}
		}

		if(tempInputList.isEmpty() || tempInputList == null)
		{
			return tc.noInputElementsInContainer;
		}
		else
		{
			inputElements = tempInputList;
			return testCode;
		}
	}
	
	public int compareSortStrings(String innerHtmlBeforeSort, String innerHtmlAfterSort)
	{
		int testCode = 0;
		
		String firstLetterBeforeSort = innerHtmlBeforeSort.substring(0, 1);
		String firstLetterAfterSort = innerHtmlAfterSort.substring(0, 1);
		
		if(firstLetterBeforeSort.equals(firstLetterAfterSort))
		{
			if(innerHtmlBeforeSort.equals(innerHtmlAfterSort))
				return tc.sameStringAfterTableSort;
			else
			{
				int result = innerHtmlBeforeSort.compareTo(innerHtmlAfterSort);
				if(result == 0)
					return tc.sameStringAfterTableSort;
				else if(result < 0)
					return testCode;
				else
					return tc.incorrectSortingResultLowerAboveHigh;
			}
		}
		
		int result = innerHtmlBeforeSort.compareTo(innerHtmlAfterSort);
		if(result < 0)
			return testCode;
		else
			return tc.incorrectSortingResultLowerAboveHigh;
	}
	
	public int createExpectedInputList(List<WebElement> containerInputList, WebDriver webDriver, String container, String tag)
	{
		int testCode = 0;
		List<WebElement> tempExpectedInput = new ArrayList<WebElement>();
		JavascriptExecutor executor = (JavascriptExecutor)webDriver;
		boolean checkForParents = true;
		List<WebElement> divUsable = null;
		
		try
		{
			List<WebElement> div = webDriver.findElements(By.xpath("//table[@id='"+container+"']//div[contains(@style,'display: none')] "
					+ "| //table[@id='"+container+"']//div[contains(@style,'display:none')]"));
			
			if(div.equals(null))
				checkForParents = false;
			else
			{
				List<WebElement> divsWithInputs = new ArrayList<WebElement>();
				for(WebElement d : div)
				{
					String divId = d.getAttribute("id");
					List<WebElement> divTemp = d.findElements(By.xpath("//div[@id='"+divId+"']//td//input "
							+ "| //div[@id='"+divId+"']//td//select | //div[@id='"+divId+"']//td//a | //div[@id='"+divId+"']//td//textarea "
							+ "| //div[@id='"+divId+"']//td//submit | //div[@id='"+divId+"']//td//radio"));
					if(!(divTemp.isEmpty()))
						divsWithInputs.add(d);
				}
				divUsable = divsWithInputs;
				checkForParents = true;
			}
		}
		catch(Exception e)
		{
			checkForParents = false;
		}
		
		
		for(WebElement item : containerInputList)
		{
			if(checkForParents == true)
			{
				if(checkForHiddenParents(item, divUsable, webDriver))
					checkElementShouldBePresent(item, executor, tempExpectedInput);
			}
			else
				checkElementShouldBePresent(item, executor, tempExpectedInput);

		}
		if(tempExpectedInput.isEmpty() || tempExpectedInput == null)
		{
			return tc.noExpectedElementsInContainer;
		}
		expectedInputList = tempExpectedInput;
		return testCode;
	}
	
	private void checkElementShouldBePresent(WebElement item, JavascriptExecutor executor, List<WebElement> tempExpectedInput)
	{
		if(!(item.getAttribute("id").trim().equals("")))
			if(item.isEnabled())
				if(item.getAttribute("hidden") == null)
					if(!(item.getAttribute("type").equals("hidden")))
						if(!(item.getAttribute("class").equals("HideButton")))
							if(!(item.getAttribute("style").contains("display: none") || item.getAttribute("style").contains("display:none")))
							{
								WebElement tdElement = (WebElement)executor.executeScript("return arguments[0].parentNode;", item);
								WebElement trElement = (WebElement)executor.executeScript("return arguments[0].parentNode;", tdElement);
								WebElement tableElement = (WebElement)executor.executeScript("return arguments[0].parentNode;", trElement);
								String parentElementString = trElement.getAttribute("style");
								if(parentElementString.equals(""))
									if(!(tableElement.getAttribute("style").contains("display: none") || tableElement.
											getAttribute("style").contains("display:none")))
										tempExpectedInput.add(item);
							}
	}
	
	private boolean checkForHiddenParents(WebElement element, List<WebElement> div, WebDriver webDriver)
	{
		boolean noHiddenParents = true; 
		
		String elementId = element.getAttribute("id");

		try
		{
			for(WebElement d : div)
			{
				String divId = d.getAttribute("id");
				List<WebElement> divInputs = webDriver.findElements(By.xpath("//div[@id='"+divId+"']//td//input "
						+ "| //div[@id='"+divId+"']//td//select | //div[@id='"+divId+"']//td//a | //div[@id='"+divId+"']//td//textarea "
								+ "| //div[@id='"+divId+"']//td//submit | //div[@id='"+divId+"']//td//radio"));
						
				for(WebElement divInput : divInputs)
				{
					if(elementId.equals(divInput.getAttribute("id")))
							noHiddenParents = false;
				}
			}

		}
		catch(Exception f)
		{
			noHiddenParents = true;
		}
		
		return noHiddenParents;
	}
	
	public List<WebElement> getInputList()
	{
		return inputElements;
	}
	
	public List<WebElement> getExpectedInputList()
	{
		return expectedInputList;
	}
}
