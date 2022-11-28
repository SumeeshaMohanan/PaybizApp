package com.obsqura.utilities;

public class ExcelDataProvider {

	
	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtility excel = new ExcelUtility(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				data[i - 1][j] = cellData;
			}
		}
		return data;
	}

}
