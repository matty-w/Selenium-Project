package consoleRunner;

import java.io.File;
import java.io.IOException;
import appRunner.RunTests;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import fileCreator.CreateExcelWorkbook;
import loggingCode.RunningLogger;

public class ConsoleRunner 
{
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				boolean fullRun = false;
				
				
				
				String f = new File("").getAbsolutePath();
				String featureLocation;
				
				if(fullRun == true)
					featureLocation = f+"\\fullTestRun\\";
				else
					featureLocation = f+"\\singleTest\\";
				
				String resultingFileLocation = f+"\\excelFileLocation\\";
				ClassLoader classLoader = getClass().getClassLoader();
				ResourceLoader resourceLoader = new MultiLoader(classLoader);
				RuntimeOptionsFactory roFactory = new RuntimeOptionsFactory(RunTests.class);
				RuntimeOptions ro = roFactory.create();
				ro.getFeaturePaths().clear();
				ro.getFeaturePaths().add(featureLocation);
				ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
				cucumber.runtime.Runtime runtime = new cucumber.runtime.Runtime(resourceLoader, classFinder, classLoader, ro);
				RunningLogger runningLogger = new RunningLogger();
				
				CreateExcelWorkbook workbookCreator = new CreateExcelWorkbook();
				
				workbookCreator.createExcelWorkbook(resultingFileLocation);
				
				try 
				{
					runtime.run();
					
					workbookCreator.replaceFile(resultingFileLocation);
					runningLogger.replaceFile();
				} 
				catch (IOException e1)
				{
					runningLogger.writeToLog(e1.getMessage());
				}
			}
		});
	}
}
