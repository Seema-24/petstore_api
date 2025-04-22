package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	String sheetName = "Sheet1";
	
	//DataProvider 1
	
	@DataProvider(name= "Data")
	public String[][] getAllData() throws IOException {
		
		String path = System.getProperty("user.dir") + "//testData//userData.xlsx"; //taking xl file from testData
		
		ExcelUtility xlutils = new ExcelUtility(path); //creating obj fro XLUtility

		int totalRows = xlutils.getRowCount(sheetName);
		int totalCols = xlutils.getCellCount(sheetName, 1);
		
		String apiData[][] = new String[totalRows][totalCols]; //created for two dimensional array which can stored row and col
		
		for (int i = 1; i <= totalRows; i++) {      // 1  //read data from xl storing in two dimensional array
			
			for (int j = 0; j < totalCols; j++) {  // 0     // i is rows j is col
				
				apiData[i-1][j] = xlutils.getCellData(sheetName, i, j);    // 1, 0
			}
		}
		
		return apiData; //returning two dimensional array
	}
	
	//Data Provider 2
	@DataProvider(name= "Usernames")
	public String[] getUsernames() throws IOException {
		
		String path = ".\\testData\\userData.xlsx"; //taking xl file from testData
		
		ExcelUtility xlutils = new ExcelUtility(path); //creating obj from XLUtility

		int totalRows = xlutils.getRowCount(sheetName);
		
		String apiData[] = new String[totalRows]; //created for one dimensional array which can stored rows only
		
		for (int i = 1; i <= totalRows; i++) {      // 1  //read data from xl storing in two dimensional array
				
			apiData[i-1] = xlutils.getCellData(sheetName, i, 1);    // sheetname , 1, 1
		}
		
		return apiData; //returning one dimensional array
	}
}
