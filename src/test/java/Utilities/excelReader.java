package Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	public static Object[][] getTestData(String filePath, String sheetName) throws Exception {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows();// gives the count of rows including header

		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();// gives the count total no of columns in a row

		Object[][] data = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);
				if (cell == null) {
					data[i - 1][j] = "";
				} else {
					data[i - 1][j] = cell.toString();

				}
			}

		}

		workbook.close();

		return data;

	}
}
