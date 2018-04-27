package consoleRunner;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import appRunner.RunTests;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import fileCreator.CreateExcelWorkbook;

public class ConsoleRunner 
{
	static int totalTests = 0;
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				boolean fullRun = false;
				
				
				
				String f = new File("").getAbsolutePath();
				String featureLocation;
				
				if(fullRun == true)
				{
					featureLocation = f+"\\smokeTestRun\\";
					File dir = new File(featureLocation);
					Collection<?> tests = FileUtils.listFiles(dir, new WildcardFileFilter("*.feature"), null);
					int testNum = tests.size();
					totalTests = testNum;
				}
				else
				{
					featureLocation = f+"\\singleTest\\";
					File dir = new File(featureLocation);
					Collection<?> tests = FileUtils.listFiles(dir, new WildcardFileFilter("*.feature"), null);
					int testNum = tests.size();
					totalTests = testNum;
				}
					
				
				String resultingFileLocation = f+"\\excelFileLocation\\";
				ClassLoader classLoader = getClass().getClassLoader();
				ResourceLoader resourceLoader = new MultiLoader(classLoader);
				RuntimeOptionsFactory roFactory = new RuntimeOptionsFactory(RunTests.class);
				RuntimeOptions ro = roFactory.create();
				ro.getFeaturePaths().clear();
				ro.getFeaturePaths().add(featureLocation);
				ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
				cucumber.runtime.Runtime runtime = new cucumber.runtime.Runtime(resourceLoader, classFinder, classLoader, ro);
				
				CreateExcelWorkbook workbookCreator = new CreateExcelWorkbook();
				
				workbookCreator.createExcelWorkbook(resultingFileLocation);
				final long startTime = System.nanoTime();
				
				try 
				{
					runtime.run();
					
					workbookCreator.replaceFile(resultingFileLocation);
					final long duration = System.nanoTime() - startTime;
					System.out.println(duration);
				} 
				catch (IOException e1)
				{
				}
			}
		});
	}
	
	public static int getTestTotal()
	{
		return totalTests;
	}
}
