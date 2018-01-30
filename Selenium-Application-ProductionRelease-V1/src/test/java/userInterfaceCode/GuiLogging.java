package userInterfaceCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GuiLogging 
{
	public static void createExceptionLog(IOException guiError) throws IOException
	{
		String f = new File("").getAbsolutePath();
		String path = f+"//Misc//GuiLogging";
		
		String logFilePath = f+"//Misc//GuiLogging//exception.txt";
		File directory = new File(path);
		
		if(!(directory.exists()))
		{
			directory.mkdir();
		}
		
		File logFile = new File(logFilePath);
		FileWriter fw = new FileWriter(logFile, true);
		PrintWriter pw = new PrintWriter(fw);
		guiError.printStackTrace(pw);
		fw.close();
		pw.close();
	}
}
