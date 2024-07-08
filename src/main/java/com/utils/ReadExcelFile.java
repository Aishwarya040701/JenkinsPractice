package com.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static XSSFWorkbook workBook;
	public static XSSFSheet workSheet;

	public static void ExcelConnection(String sheetName) {
		try {
			FileInputStream file = new FileInputStream("src/test/resources/TestData/UserInformation.xlsx");
			workBook = new XSSFWorkbook(file);
			workSheet = workBook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	public static String ExcelReadDataFromCell(int row, int column) {

		return workSheet.getRow(row).getCell(column).getStringCellValue();

	}

}
