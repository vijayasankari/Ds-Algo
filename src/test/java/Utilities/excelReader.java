package Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	static int rowCount;
	static int colCount;

	public static Object[][] getTestData(String filePath, String sheetName) throws Exception {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet(sheetName);

		 rowCount = sheet.getPhysicalNumberOfRows();// gives the count of rows including header

		 colCount = sheet.getRow(0).getPhysicalNumberOfCells();// gives the count total no of columns in a row

		Object[][] data = new Object[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);
				if (cell == null) {
					data[i][j] = "";
				} else {
					data[i][j] = cell.toString();

				}
			}

		}

		workbook.close();

		return data;

	}
	
	public static String getTryEditorCode(String codeType) {
		String filepath = configReader.getProperty("filepath");
	    String SheetName="TryEditor";
	    String code=null;
		try {
			Object[][] fetchedData = excelReader.getTestData(filepath, SheetName);
			int i=0;
				
				for(int j=0;j<colCount;j++) {
					String value=(String) fetchedData[i][j];
					//System.out.println("value is"+value);
					if (value.equalsIgnoreCase(codeType)) {
						code=(String) fetchedData[i+1][j];
						
					}
					i=0;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
}
