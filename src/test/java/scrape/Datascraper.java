package scrape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.BaseTest;
import file.Access;

public class Datascraper extends BaseTest {
	
	 List<String> link = new ArrayList<String>();
	 List<String> dname = new ArrayList<String>();
	Sheet sheet;
	@Test
	public void getData() throws InterruptedException, IOException
	{
		
		
		
		
		List <WebElement> departments = driver.findElements(By.xpath("//div[@role='treeitem']"));
			
		for(int i=0; i<departments.size(); i++)
		{ 
			
			
			try {
			link.add(departments.get(i).findElement(By.xpath(".//a")).getAttribute("href").toString());
			dname.add(departments.get(i).findElement(By.xpath(".//a")).getText());
			}
			catch(Exception e)
			{
				
			}
		}
		
	
		openEachDeparment();
		
	}

	private void openEachDeparment() throws InterruptedException, IOException {
		
	
		
		int row=1;
		
		for(int i=0; i<link.size(); i++)
		{
		
			
			
			
		driver.get(link.get(i));
		List <WebElement> items = driver.findElements(By.id("gridItemRoot"));
			
			for(int k=0; k<items.size(); k++)
			{
				
				
				sheet = new Access().openFile();
				
				Row row3=sheet.createRow(row);
									
				row3.createCell(0).setCellValue(dname.get(i));
						
				
				
				
				
				
				System.out.println(items.get(k).findElement(By.xpath(".//div/div[2]/div/a[2]/span/div")).getText());
				row3.createCell(1).setCellValue(items.get(k).findElement(By.xpath(".//div/div[2]/div/a[2]/span/div")).getText());
				
				
				
				
				
					
				try {
			//	WebElement sprice = items.get(k).findElement(By.xpath(".//span[contains(text(),'$')]"));
					List <WebElement> prices = items.get(k).findElements(By.xpath(".//span[contains(text(),'$')]"));
					
					String pricesis="";
					
						for(int m=0; m<prices.size(); m++)
						{
								System.out.print(prices.get(m).getText());
								pricesis= pricesis+prices.get(m).getText();
								if(prices.size()>1 && m<1)
								{
									System.out.print("-");
									pricesis= pricesis+"-";
								}
						}
						
						//Cell cll2 = sheet.createRow(row).createCell(2);
					//	cll2.setCellValue(pricesis);
						row3.createCell(2).setCellValue(pricesis);
				}
	
				catch(Exception e)
				{
					
				}
				System.out.println(" ");
				
				row++;
				new Access().closeFile();
			}
			
			
			//*[@id="gridItemRoot"]/div/div[2]/div/div[2]/a/span/span[2]
			//*[@id="gridItemRoot"]/div/div[2]/div/div[2]/a/span
			//*[@id="gridItemRoot"]/div/div[2]/div/div/a/span/span
			//*[@id="gridItemRoot"]/div/div[2]/div/div/a/span
		
			
			
		}
	}
	
	
	
	



}
