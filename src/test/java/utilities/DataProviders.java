package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] loginData() throws IOException{
		
		String path = ".\\testData\\loginTestData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int tot_row = xlutil.getRowCount("Sheet1");
		int tot_cols = xlutil.getCellCount("Sheet1", 1);
		
		String logData[][] = new String[tot_row][tot_cols];
		
		for(int i=1;i<=tot_row;i++) {
			for(int j=0;j<tot_cols;j++) {
				logData[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logData;
	}

}
