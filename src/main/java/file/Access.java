package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Access {
	public static XSSFWorkbook wk;
	
	public Sheet openFile() throws IOException
	{
		try {
			FileInputStream is = new FileInputStream("./excel/amazondata.xlsx");
			wk = new XSSFWorkbook(is);
			Sheet sheet = wk.getSheet("bestselling");
			return sheet;
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no file found");
			throw e;
		}
	}
	
	public void closeFile() throws IOException
	{
		FileOutputStream os = new FileOutputStream("./excel/amazondata.xlsx");
		wk.write(os);
		wk.close();
	}

}
