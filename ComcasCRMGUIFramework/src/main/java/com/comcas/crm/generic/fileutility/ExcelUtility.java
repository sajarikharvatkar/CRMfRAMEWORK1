package com.comcas.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	//get data from Excel file
	public String getDataFromExceFile(String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheetname);
	    Row row=sh.getRow(rowNum);
		  Cell c=row.getCell(cellNum);
		  String data=c.getStringCellValue();		
		return data;
		
	}
	//get row count 
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheetname);
	int rowcount=sh.getLastRowNum();
		return rowcount;
		
	}
	//send data back to excel
	public void sendDataBackToExcel(String sheetname,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheetname);
	    Row row=sh.getRow(rowNum);
		  Cell c=row.createCell(cellNum);
		  
		  FileOutputStream fo=new FileOutputStream("./testData/testScriptdata.xlsx");
		  wb.write(fo);
		  wb.close(); //if u are not written close workbook then workbook object is open in excel sheet because multiple objects are opened the excel sheet may get crash
		
	}

}
