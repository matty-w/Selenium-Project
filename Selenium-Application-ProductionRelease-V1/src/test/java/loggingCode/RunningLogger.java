package loggingCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import userInterfaceCode.GuiLogging;

public class RunningLogger 
{
	public void createRunLog()
	{
		String f = new File("").getAbsolutePath();
		String path = f+"//Misc//GuiLogging";
		String logFilePath = f+"//Misc//GuiLogging//run.txt";
		File directory = new File(path);
		File logFile = new File(logFilePath);
		
		if(!(directory.exists()))
		{
			directory.mkdir();
		}
		
		if(logFile.exists())
			return;
	}
	
	public void writeToLog(String logLine) 
	{
		String f = new File("").getAbsolutePath();
		String path = f+"//Misc//GuiLogging";
		String logFilePath = f+"//Misc//GuiLogging//run.txt";
		File directory = new File(path);
		
		if(!(directory.exists()))
		{
			directory.mkdir();
		}
		
		File logFile = new File(logFilePath);
		
		FileWriter fw;
		try 
		{
			fw = new FileWriter(logFile, true);
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
			Date date = new Date();
			String dateString = dateFormat.format(date).toString();
			String dateStringTrim = dateString.replaceAll("\\s", "");
			String dateFinal = dateStringTrim.substring(0, 2)+"-"+dateStringTrim.substring(2, 4)+
					"-"+dateStringTrim.substring(4, 8)+"_"+dateStringTrim.substring(8, dateStringTrim.length());
			
			fw.write("["+dateFinal+"] - "+logLine);
			fw.write(System.lineSeparator());
			fw.close();
		} 
		catch (IOException e)
		{
			try 
			{
				GuiLogging.createExceptionLog(e);
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}

	}
	
	private String nameRunLog()
	{
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
		Date date = new Date();
		String dateString = dateFormat.format(date).toString();
		String dateStringTrim = dateString.replaceAll("\\s", "");
		String dateFinal = dateStringTrim.substring(0, 2)+"-"+dateStringTrim.substring(2, 4)+
				"-"+dateStringTrim.substring(4, 8)+"_"+dateStringTrim.substring(8, dateStringTrim.length());
		String logName = "RunningLog_"+dateFinal;
		String logNameNoColons = logName.replaceAll(":", "-");
		return logNameNoColons;
	}
	
	public void replaceFile()
	{
		String logName = nameRunLog();
		replaceLogFile(logName);
	}
	
	private void replaceLogFile(String logNameNoColons)
	{
		String f = new File("").getAbsolutePath();
		String path = f+"//Misc//GuiLogging";
		String logFilePath = f+"//Misc//GuiLogging//run.txt";
		File logFile = new File(logFilePath);
		File newLogFile = new File(path+"//"+logNameNoColons+".txt");
		try 
		{
		    FileUtils.copyFile(logFile, newLogFile);
		    FileUtils.forceDelete(logFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
