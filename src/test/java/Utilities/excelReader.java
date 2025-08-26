package Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	public static List<Map<String, String>> getTestData(String filePath, String sheetName) throws Exception {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			workbook.close();
			file.close();
			throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in the workbook.");
		}

		// Get the header row (row 0) to use as keys for the maps
		XSSFRow headerRow = sheet.getRow(0);
		List<String> headers = new ArrayList<>();
		if (headerRow != null) {
			for (Cell cell : headerRow) {
				headers.add(cell.toString());
			}
		}

		int rowCount = sheet.getLastRowNum();// gives the count of rows excluding header

		List<Map<String, String>> data = new ArrayList<>();

		// Iterate through the remaining rows (starting from row 1)
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow dataRow = sheet.getRow(i);
			if (dataRow == null) {
				continue; // Skip empty rows
			}

			Map<String, String> rowMap = new HashMap<>();
			for (int j = 0; j < headers.size(); j++) {
				Cell cell = dataRow.getCell(j);
				String value;
				if (cell == null) {
					value = "";
				} else {
					value = cell.toString();
					rowMap.put(headers.get(j), value);
				}
			}
			data.add(rowMap);
		}
		workbook.close();

		return data;
	}
}
