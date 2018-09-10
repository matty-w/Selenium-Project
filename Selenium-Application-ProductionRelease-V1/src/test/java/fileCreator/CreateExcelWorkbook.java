package fileCreator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import loggingCode.RunningLoggerStringValues;
import testCodes.TestCodes;

public class CreateExcelWorkbook extends WorkbookFactory
{
	TestCodeConverter testCodeConverter = new TestCodeConverter();
	RunningLoggerStringValues loggerValues = new RunningLoggerStringValues();
	TestCodes tc = new TestCodes();
	
	
	private static String FN = "";
	
	public void createExcelWorkbook(String FILE_NAME)
	{
		
		FN = FILE_NAME+"\\log.xlsx";
		File logFile = new File(FN);
		if(logFile.exists())
		{
			return;
		}
		else
		{
			try
			{
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet chromeTestSheet = workbook.createSheet("Chrome Tests");
				XSSFSheet chromeFailSheet = workbook.createSheet("Chrome Test Fails");
				XSSFSheet operaTestSheet = workbook.createSheet("Opera Tests");
				XSSFSheet operaFailSheet = workbook.createSheet("Opera Test Fails");
				XSSFSheet edgeTestSheet = workbook.createSheet("Edge Tests");
				XSSFSheet edgeFailSheet = workbook.createSheet("Edge Test Fails");
				XSSFSheet ieTestSheet = workbook.createSheet("IE Tests");
				XSSFSheet ieFailSheet = workbook.createSheet("IE Test Fails");
				
				chromeTestSheet.autoSizeColumn(0);
				chromeFailSheet.autoSizeColumn(0);
				operaTestSheet.autoSizeColumn(0);
				operaFailSheet.autoSizeColumn(0);
				edgeTestSheet.autoSizeColumn(0);
				edgeFailSheet.autoSizeColumn(0);
				ieTestSheet.autoSizeColumn(0);
				ieFailSheet.autoSizeColumn(0);
				
				XSSFCellStyle titleStyle = workbook.createCellStyle();
				titleStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(94, 133, 212)));
				titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); 
				
				int worksheetNumbers = workbook.getNumberOfSheets();
				
				Object[][] datatypes = {
						{"Test", "Test Scenario", "Pass Or Fail", "Reason (If Fail)"}};
				
				Object[][] testStats = {
					{"Total Steps Completed","Total Steps Passed","Total Steps Failed", "Total Fail Percentage"}};
				
				for(int i = 0; i < worksheetNumbers; i++)
				{
					int rowNum = 0;
					if(i%2 == 0)
						rowNum = 2;
						
					XSSFSheet worksheet = workbook.getSheetAt(i);
					
			        for (Object[] datatype : datatypes) 
			        {
			            Row row = worksheet.createRow(rowNum++);
			            int colNum = 0;
			            for (Object field : datatype) 
			            {
			            	colNum = createCell(row, colNum, field, worksheet, titleStyle);
			            }
			        }
			        
			        if(i%2 == 0)
			        {
			            Row row = worksheet.createRow(0);
			            Row row2 = worksheet.createRow(1);
				        for (Object[] testStat : testStats) 
				        {
				            int colNum = 0;
				            for (Object field : testStat) 
				            {
				            	Cell intCell = row2.createCell(colNum);
				            	intCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				                Cell cell = row.createCell(colNum++);
				                cell.setCellValue((String) field);
				                intCell.setCellValue(0);
				                int cellNum = cell.getColumnIndex();
				                worksheet.autoSizeColumn(cellNum);
				                cell.setCellStyle(titleStyle);
				            }
				        }
			        }
				}
				writeToFile(workbook, FN);
			}
			catch(Exception e)
			{
			}
		}
	}
	
	public boolean createTestTitle(List<Boolean> boolValues, List<String> stringValues)
	{
		boolean createTitle = boolValues.get(0);
		boolean wasFail = boolValues.get(1);
		boolean titleAlreadyCreated = boolValues.get(2);
		if(createTitle == true)
		{
			String testNumber = stringValues.get(0).substring(0, 8);
			String scenarioStringCut = stringValues.get(0).substring(8);
			
			String browser = stringValues.get(1);
			
			Object datatypes[][] = {
					{testNumber, scenarioStringCut, "", ""}};
			
			try 
			{
				//File file = new File(FN);
				//BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
				//XSSFWorkbook workbook = new XSSFWorkbook(is);
				
				OPCPackage pkg = OPCPackage.open(new File(FN));
				XSSFWorkbook workbook = new XSSFWorkbook(pkg);
				
				File tmp = File.createTempFile("tempSpreadsheet", ".xlsx");
				FileOutputStream os = new FileOutputStream(tmp);
				
				XSSFCellStyle cellStyleTestTitle = createWorksheetCellStyle(workbook, 197, 182, 159);
				
				if(browser.equals("Chrome"))
				{
					XSSFSheet worksheetFull = workbook.getSheetAt(0);
					XSSFSheet worksheetFail = workbook.getSheetAt(1);
					createExcelTitleCells(wasFail, titleAlreadyCreated, datatypes, cellStyleTestTitle, worksheetFull, worksheetFail);
				}
				if(browser.equals("Opera"))
				{
					XSSFSheet worksheetFull = workbook.getSheetAt(2);
					XSSFSheet worksheetFail = workbook.getSheetAt(3);
					createExcelTitleCells(wasFail, titleAlreadyCreated, datatypes, cellStyleTestTitle, worksheetFull, worksheetFail);
				}
				if(browser.equals("Edge"))
				{
					XSSFSheet worksheetFull = workbook.getSheetAt(4);
					XSSFSheet worksheetFail = workbook.getSheetAt(5);
					createExcelTitleCells(wasFail, titleAlreadyCreated, datatypes, cellStyleTestTitle, worksheetFull, worksheetFail);
				}
				if(browser.equals("IE"))
				{
					XSSFSheet worksheetFull = workbook.getSheetAt(6);
					XSSFSheet worksheetFail = workbook.getSheetAt(7);
					createExcelTitleCells(wasFail, titleAlreadyCreated, datatypes, cellStyleTestTitle, worksheetFull, worksheetFail);
				}
				//is.close();
		        workbook.write(os);
		        os.flush();
		        os.close();
		        tmp.deleteOnExit();
		        pkg.close();
				//workbook.close();
				//writeToFile(workbook, FN);
			} 
			catch (Exception e) 
			{
			}
			return false;
		}
		return false;
	}

	public void appendExcelSpreadsheet(List<String> stringValues, List<Integer> testCodes, String webElement, boolean failTitleExists)
	{
		try 
		{
			String browser = stringValues.get(1);
			String constructedWebElement = ": '"+webElement+"'";
			if(constructedWebElement.equals(": ''"))
				constructedWebElement = "";
			String passOrFail = "PASS";
			String scenarioString = stringValues.get(0);
			String testNumberOriginal = scenarioString.substring(0, 8);
			String testNumber = testCodes.get(3)+" - "+testNumberOriginal;
			String testDescription = testCodeConverter.testDescription(testCodes.get(2)) +" "+constructedWebElement;
			String errorDescription = testCodeConverter.createErrorContext(testCodes.get(0), testCodes.get(1));
					
			if(testCodes.get(0) != 0)
				passOrFail = "FAIL";
			
			//File file = new File(FN);
			//BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
			//XSSFWorkbook workbook = new XSSFWorkbook(is);
			
			OPCPackage pkg = OPCPackage.open(new File(FN));
			XSSFWorkbook workbook = new XSSFWorkbook(pkg);
			
			File tmp = File.createTempFile("tempSpreadsheet", ".xlsx");
			FileOutputStream os = new FileOutputStream(tmp);
			
			XSSFCellStyle cellStylePass = createWorksheetCellStyle(workbook, 132, 195, 123);
			XSSFCellStyle cellStyleFail = createWorksheetCellStyle(workbook, 247, 99, 99);
			
			Object[][] datatypes = {
					{testNumber, testDescription, passOrFail, errorDescription}};
			
			List<Integer> sheets = new ArrayList<Integer>();
			if(browser.equals("Chrome"))
			{
				sheets.add(0);
				sheets.add(1);
				createExcelRow(sheets, datatypes, workbook, cellStylePass, cellStyleFail, errorDescription, failTitleExists);
			}
			if(browser.equals("Opera"))
			{
				sheets.add(2);
				sheets.add(3);
				createExcelRow(sheets, datatypes, workbook, cellStylePass, cellStyleFail, errorDescription, failTitleExists);
			}
			if(browser.equals("Edge"))
			{
				sheets.add(4);
				sheets.add(5);
				createExcelRow(sheets, datatypes, workbook, cellStylePass, cellStyleFail, errorDescription, failTitleExists);
			}
			if(browser.equals("IE"))
			{
				sheets.add(6);
				sheets.add(7);
				createExcelRow(sheets, datatypes, workbook, cellStylePass, cellStyleFail, errorDescription, failTitleExists);
			}
			//is.close();
	        workbook.write(os);
	        os.flush();
	        os.close();
	        tmp.deleteOnExit();
	        pkg.close();
			//workbook.close();
			//writeToFile(workbook, FN);
			
		} 
		catch (Exception e) 
		{
		}
	}
	
	public void replaceFile(String workbookLocation)
	{
		try
		{
			String logName = renameFile();
			replaceLogFile(workbookLocation, logName);
		}
		catch(Exception e)
		{
		}
	}
}
