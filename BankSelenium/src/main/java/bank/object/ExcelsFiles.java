package main.java.bank.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelsFiles {
	
//	@SuppressWarnings("unused")
	public Sheet readExcelFile(String filePath, String fileName, String sheetName) throws IOException {
		
		File file = new File(filePath+"\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		String fileExtension = fileName.substring(fileName.indexOf("."));
		Workbook wrk = null;
		
		switch (fileExtension) {
		
		case ".xlsx": {
			wrk = new XSSFWorkbook(inputStream);
			break;
			}
		case ".xls": {
			wrk = new HSSFWorkbook(inputStream);
			break;
			}
		
		default: break;
		}
		
		Sheet sheet = wrk.getSheet(sheetName);
		
		
		
		return sheet;
		
	}

}
