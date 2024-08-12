package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetName,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testScriptData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;

	}
	public void setDataBackToExcel(String sheetName,int row,int cell,String data) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/testScriptData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Cell cell1 = wb.getSheet(sheetName).getRow(row).createCell(cell);
		cell1.setCellType(CellType.STRING);
		cell1.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testScriptData1.xlsx");
				wb.write(fos);
		wb.close();

	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testScriptData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	public int getCellCount(String sheetname,int row) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\testScriptData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		short cellCount = wb.getSheet(sheetname).getRow(row).getLastCellNum();
		return cellCount;
	}
}
