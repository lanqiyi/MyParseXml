package com.anjuke.minzhao.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;

public class ReadDataFromASO {
	
	private Browser driver = null;
	private String BaseUrl ="http://www.ann9.com/";
	private String ASOUrl ="https://my.ann9.com/aso/app";
	private String AnjukeUrl= "https://my.ann9.com/itc/rank?aid=415606289";
	private String SoufangUrl= "https://my.ann9.com/itc/rank?aid=413993350";
	private String Login= "//*[@id='userlogon']";
	private String UserName = "1160106876@qq.com";
	private String Password = "hongzezhen1986";
	private String LoginSubmit = "//*[@id='btnSubmit']";
	private String AnjukeTab ="//*[@id='ui-id-7']";
	private static String ASORankTable ="//*[@id='dataTableContent']/tr";
	private  String HotWord[] =new String[100];
	private  String Rank[] =new String[100];
	private  String ASO[] =new String[100];
	private  String Filename1 = "AppStore应用热词分布.xls";
	private  String Filename2 = "iPhone应用排名趋势.xls";
	
	DataRelativeByAnn9 testData = new DataRelativeByAnn9();
	@BeforeMethod
	public void setUp() throws Exception {
		driver = FactoryBrowser.factoryBrowser();
	}
	@AfterMethod
	public void tearDown() throws Exception {	
		driver.quit();
	}
	@Test
	public void testReadDataFromAnn9(){
		
		dologin(driver,UserName,Password);
		Workbook wb = POITest.createExcel();
		GetDataFromASO(1,wb);
//		GetDataFromSearchAppRank(0,wb);
		
	}
	

	public void GetDataFromASO(int flag,Workbook wb){
	
		driver.get(ASOUrl);
		GetCompanyPage(AnjukeTab,"安居客二手房",driver,wb,flag);
		GetCompanyPage("//*[@id='ui-id-12']","安居客新房",driver,wb,flag);
		GetCompanyPage("//*[@id='ui-id-13']","安居客好租",driver,wb,flag);
		GetCompanyPage("//*[@id='ui-id-5']","搜房网",driver,wb,flag);
		GetCompanyPage(testData.GanJiTab,"赶集懒人网",driver,wb,flag);
		
		
	}
	
	private void GetDataFromSearchAppRank(int flag,Workbook wb) {
		
		driver.get(AnjukeUrl);
		driver.click("//*[@id='radiodate']/label[2]/span", "点击近一月");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		TestiPhone(ASORankTable,wb,"安居客iPhone",flag);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.get(SoufangUrl);
		driver.click("//*[@id='radiodate']/label[2]/span", "点击近一月");
		driver.click("//*[@id='rdChartShow']/label[2]/span","点击iPhone");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {e.printStackTrace();}
		TestiPhone(ASORankTable,wb,"搜房iPhone",flag);
		
	}
	
	public void GetCompanyPage(String locator, String info , Browser driver,Workbook wb,int flag){
		
		driver.refresh();
		driver.click("//*[@id='btn_apps']","点击页面下拉框");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		if (driver.check(locator, 5)) {
			
			driver.moveToElement(locator);
            driver.click(locator, info);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {e.printStackTrace();}
			Test(ASORankTable,wb,info,flag);
		}
		else{
			System.out.print("error");
		}
	}
	public void Test ( String locator ,Workbook wb,String SHEETNAME,int flag){
	
			int count = driver.getElementCount(locator);	
			for(int i =1; i<=count; i++){
				HotWord[i-1] = driver.getText(getHotwordElement(i), "获取第"+i+"行热词");		
				Rank[i-1] = driver.getText(getHotwordRankElement(i), "获取第"+i+"行排名");
				ASO[i-1] = driver.getText(getHotwordASOElement(i), "获取第"+i+"行权重");
			}
			try {	
				Sheet sheet = POITest.createNewSheet(wb, SHEETNAME,flag);
				POITest.WriteSheetData(sheet, count, HotWord, Rank, ASO);
				POITest.WriteExcel(wb,Filename2);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public void TestiPhone ( String locator ,Workbook wb,String SHEETNAME,int flag){
		
		int count = driver.getElementCount(locator);	
		for(int i =2; i<=count; i++){
			HotWord[i-2] = driver.getText(getDateFromIOS(i), "获取第"+i+"行日期");		
			Rank[i-2] = (driver.getText(getHotwordElement(i), "获取第"+i+"行iPhone生活免费")).split(" ")[0];
			ASO[i-2] = (driver.getText(getiPhoneTotalElement(i), "获取第"+i+"行iPhonee总榜免费")).split(" ")[0];
			
		}
		try {	
			Sheet sheet = POITest.createNewSheet(wb, SHEETNAME,flag);
			POITest.WriteSheetData(sheet, count-1, HotWord, Rank, ASO);
			POITest.WriteExcel(wb,Filename1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String dologin(Browser driver, String name, String pass){
		driver.get(BaseUrl);
		 if (driver.check(Login, 5)) {
	            driver.click(Login, "点击登录按钮");
	        } else {
	            driver.refresh();
	            driver.click(Login, "点击登录按钮");
	        }
		 driver.type("//*[@id='txtemail']", name, "用户名");
	     driver.type("//*[@id='password']", pass, "密码");
	     driver.click(LoginSubmit, "登录");
	     return driver.getText("//*[@class='headlogo']/div[2]/li[2]/a", "获取登录后的用户名", 10);
	}
	
	public static String getHotwordElement(int n) {
	        String element = "//*[@id='dataTableContent']/tr["+n+"]/td[2]";
	        return element;
	    }
	 public static String getHotwordRankElement(int n) {
	        String element = "//*[@id='dataTableContent']/tr["+n+"]/td[5]";
	        return element;
	    }
	 public static String getHotwordASOElement(int n) {
	        String element = "//*[@id='dataTableContent']/tr["+n+"]/td[6]";
	        return element;
	    }
	 /**获取横坐标日期**/
	 public static String getDateFromIOS(int n) {
	        String element = "//*[@id='dataTableContent']/tr["+n+"]/td[1]";
	        return element;
	    }
	 /**获取iphone免费总榜**/
	 public static String getiPhoneTotalElement(int n) {
	        String element = "//*[@id='dataTableContent']/tr["+n+"]/td[3]";
	        return element;
	    }
	 public static class POITest{
		 
		    public static Workbook createExcel(){
		    	 Workbook wb = new HSSFWorkbook();
		    	 return wb;
		    }
		    public static Sheet createNewSheet(Workbook wb,String SheetName,int flag){
		    	Sheet sheet = wb.createSheet(SheetName);
		    	// 设置excel每列宽度
		    	if(flag == 1){
		    		sheet.setColumnWidth(0, 15000);
		    		sheet.setColumnWidth(1, 3500);
		    		sheet.setColumnWidth(2, 3500);
		    		Row row = sheet.createRow((short) 0); 
		    		row.createCell(0).setCellValue("热词");
		    		row.createCell(1).setCellValue("排名"); 
		    		row.createCell(2).setCellValue("权重"); 
		    	}else{
		    		sheet.setColumnWidth(0, 3500);
		    		sheet.setColumnWidth(1, 5000);
		    		sheet.setColumnWidth(2, 5000);
		    		Row row = sheet.createRow((short) 0); 
		    		row.createCell(0).setCellValue("日期");
		    		row.createCell(1).setCellValue("iPhone生活免费"); 
		    		row.createCell(2).setCellValue("iPhone总榜免费"); 
		    	}
		    	return sheet;
		    }
		    public static Sheet WriteSheetData(Sheet sheet,int count,String[] HotWord, String[] Rank, String[] ASO ) {
		    	
		    	for(int i=1;i<=count;i++){
		        	   Row tr =sheet.createRow((short)i);
		        	   tr.createCell(0).setCellValue(HotWord[i-1]);
		        	   tr.createCell(1).setCellValue(Integer.parseInt(Rank[i-1]));
		        	   tr.createCell(2).setCellValue(Integer.parseInt(ASO[i-1]));
		           }
		    	return sheet;
		    }
		    public static void WriteExcel(Workbook wb, String FILENAME)throws IOException{
		    	
		    	FileOutputStream fileOut = new FileOutputStream(FILENAME); 
	            wb.write(fileOut); 
	            fileOut.close();
		    }
		    
	        //读取EXCEL
	        public static void readWorkBook() throws Exception { 
	        
	            InputStream inp = new FileInputStream("workbook.xls"); 
	            Workbook wb = WorkbookFactory.create(inp); 
	            Sheet sheet = wb.getSheetAt(0); 
	           
	            for (Row row : sheet) { 
	              for (Cell cell : row) { 
	                   System.out.print(cell.toString() + "  "); 
	                }
	                System.out.println(); 
	            } 
	             inp.close(); 
	        }
	       
	    }
}
