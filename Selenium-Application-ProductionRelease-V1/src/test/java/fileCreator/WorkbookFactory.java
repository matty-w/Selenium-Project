package fileCreator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import loggingCode.RunningLogger;
import loggingCode.RunningLoggerStringValues;

public class WorkbookFactory
{	
	RunningLogger runningLogger = new RunningLogger();
	RunningLoggerStringValues loggerValues = new RunningLoggerStringValues();
	
	protected XSSFCellStyle createWorksheetCellStyle(XSSFWorkbook workbook, int redHex, int greenHex, int blueHex) 
	{
		try
		{
			runningLogger.writeToLog(loggerValues.createWorksheetCellStyle);
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(redHex, greenHex, blueHex)));
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); 
			runningLogger.writeToLog(loggerValues.worksheetCellStyleCreated);
			return cellStyle;
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.createWorksheetCellStyleError);
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
			return null;
		}
	}

	protected void writeToFile(XSSFWorkbook workbook, String FILE_NAME) 
	{
		try
		{
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
	        workbook.write(outputStream);
	        outputStream.flush();
	        outputStream.close();
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.writingToFileError);
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}

	protected void createExcelRow(List<Integer> sheetNumbers, Object[][] datatypes, XSSFWorkbook workbook, 
			XSSFCellStyle cellStylePass, XSSFCellStyle cellStyleFail,String errorDescription, boolean failTitleExists) 
	{
		try
		{
			runningLogger.writeToLog(loggerValues.createExcelRow);
			XSSFSheet worksheetFull = workbook.getSheetAt(sheetNumbers.get(0));
			XSSFSheet worksheetFail = workbook.getSheetAt(sheetNumbers.get(1));
			
			Row row1 = worksheetFull.getRow(1);
			Cell totalStepsCell = row1.getCell(0);
			Cell totalPassCell = row1.getCell(1);
			Cell totalFailCell = row1.getCell(2);
			Cell totalFailPercent = row1.getCell(3);
			itterateCellValue(totalStepsCell);
			
			
			if(errorDescription.equals("") || errorDescription.equals(null))
			{
				double currentCellValuePass = totalPassCell.getNumericCellValue();
				double newValuePass = currentCellValuePass+1;
				totalPassCell.setCellValue(newValuePass);

		        for (Object[] datatype : datatypes) 
		        {
		        	int lastRow = worksheetFull.getLastRowNum()+1;
		            Row row = worksheetFull.createRow(lastRow);
		            int colNum = 0;
		            
		            for (Object field : datatype) 
		            {
		            	colNum = createCell(row, colNum, field, worksheetFull, cellStylePass);
		            }
		        }
			}
			else
			{
				itterateCellValue(totalFailCell);
		        for (Object[] datatype : datatypes) 
		        {
		        	int lastRowFull = worksheetFull.getLastRowNum()+1;
		        	int lastRowFail = worksheetFail.getLastRowNum()+1;
		        	
		            Row rowFull = worksheetFull.createRow(lastRowFull);
		            Row rowFail = worksheetFail.createRow(lastRowFail);
		            int colNumFull = 0;
		            int colNumFail = 0;
		            for (Object field : datatype) 
		            {
		            	colNumFull = createCell(rowFull, colNumFull, field, worksheetFull, cellStyleFail);
		            	colNumFail = createCell(rowFail, colNumFail, field, worksheetFail, cellStyleFail);
		            }
		        }
			}
			calculateAndUpdateFailPercent(totalStepsCell, totalPassCell, totalFailPercent);
			runningLogger.writeToLog(loggerValues.excelRowCreated);
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	protected void createExcelTitleCells(boolean wasFail, boolean titleAlreadyCreated, Object[][] datatypes, XSSFCellStyle cellStyleTestTitle,
			XSSFSheet worksheetFull, XSSFSheet worksheetFail) 
	{
		try
		{
			if(wasFail == true)
			{
				if(titleAlreadyCreated == false)
				{
					runningLogger.writeToLog(loggerValues.createTitleRow);
				    for (Object[] datatype : datatypes) 
				    {
				    	Row rowFail = worksheetFail.createRow(worksheetFail.getLastRowNum()+1);
				    	int colNumFail = 0;
				        for (Object field : datatype) 
				        {
				        	colNumFail = createCell(rowFail, colNumFail, field, worksheetFail, cellStyleTestTitle);
				        }
				    }
				    runningLogger.writeToLog(loggerValues.titleRowCreated);
				}
			}
			else
			{
			    for (Object[] datatype : datatypes) 
			    {
			        Row row = worksheetFull.createRow(worksheetFull.getLastRowNum()+1);
			        int colNum = 0;
			        for (Object field : datatype) 
			        {
			        	colNum = createCell(row, colNum, field, worksheetFull, cellStyleTestTitle);
			        }
			    }
			}
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	protected int createCell(Row row, int colNum, Object field, XSSFSheet worksheet, XSSFCellStyle cellStyle)
	{
        Cell cell = row.createCell(colNum++);
        cell.setCellValue((String) field);
        int cellNum = cell.getColumnIndex();
        worksheet.autoSizeColumn(cellNum);
        cell.setCellStyle(cellStyle);
        
        return colNum;
	}
	
	protected String renameFile()
	{
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy HH:mm:ss");
			Date date = new Date();
			String dateString = dateFormat.format(date).toString();
			String dateStringTrim = dateString.replaceAll("\\s", "");
			String dateFinal = dateStringTrim.substring(0, 2)+"-"+dateStringTrim.substring(2, 4)+
					"-"+dateStringTrim.substring(4, 8)+"_"+dateStringTrim.substring(8, dateStringTrim.length());
			String logName = "SeleniumTests_"+dateFinal;
			String logNameNoColons = logName.replaceAll(":", "-");
			return logNameNoColons;
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
			return "ErrorRenamingFile";
		}
	}
	
	protected void replaceLogFile(String workbookLocation, String logNameNoColons)
	{
		try 
		{
			File logFile = new File(workbookLocation, "log.xlsx");
			File newLogFile = new File(workbookLocation, logNameNoColons+".xlsx");
		    FileUtils.copyFile(logFile, newLogFile);
		    FileUtils.forceDelete(logFile);
		} 
		catch (IOException e) 
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	private void itterateCellValue(Cell selectedCell)
	{
		try
		{
			double currentCellValue = selectedCell.getNumericCellValue();
			double newValue = currentCellValue+1;
			selectedCell.setCellValue(newValue);
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
	
	private void calculateAndUpdateFailPercent(Cell totalStepsCell, Cell totalPassCell, Cell percentCell)
	{
		try
		{
			double currentCellValueSteps = totalStepsCell.getNumericCellValue();
			double currentCellValuePass = totalPassCell.getNumericCellValue();
			double newValuePass = (currentCellValuePass/currentCellValueSteps) * 100;
			double maxNumber = 100.0;
			double newValuePercentFail = maxNumber - newValuePass;
			percentCell.setCellValue(newValuePercentFail);
		}
		catch(Exception e)
		{
			runningLogger.writeToLog(loggerValues.errorString+e.getMessage());
		}
	}
}