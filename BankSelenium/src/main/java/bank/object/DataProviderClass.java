package main.java.bank.object;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	Object [][] logInSet;
	
	@DataProvider(name="LogInProvider")
	public Object [][] getData() throws IOException{
		
		ExcelsFiles file = new ExcelsFiles();
		Sheet sheet = file.readExcelFile(Mapping.ExcelFilePath, Mapping.ExcelFile, Mapping.SheetName);
		int rowCount= sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		logInSet = new Object[rowCount][colCount];
		for (int i=1; i<rowCount+1;i++) {
			for (int j=0;j<colCount;j++) {
				Row row = sheet.getRow(i);
				String cellvalue= row.getCell(j).getStringCellValue();
				System.out.println(cellvalue);
				logInSet[i-1][j] = cellvalue;
				
			}
		}
		return logInSet;
	}
}
