package com.anjuke.minzhao.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;

public class ReadDataFromAnn {

	private Browser driver = null;
	private String temp = null;
	private String appnameEncode = null;
	private int HasTwoColumn = 1;
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
	public void testReadDataFromAnn9() {
		int flag = 0;// 是否导入一个月的数据,1 代表导入1个月
		
		dologin(driver, testData.UserName, testData.Password);
		GetAppDataByiPhone(flag,"0");//0代表不是选择ipad
		GetAppDataByiPad(flag,"1");

	}
	public void GetAppDataByiPad(int flag,String iPadflag){
		
		HasTwoColumn = 1;	
		GetDataFromSearchAppRank(testData.AnjukeiPadUrl, "安居客HD", HasTwoColumn,flag,iPadflag,3);
		GetDataFromSearchAppRank(testData.SouFangiPadUrl, "搜房HD",HasTwoColumn,flag,iPadflag,3);

		HasTwoColumn = 0;
		GetDataFromSearchAppRank(testData.AnjukeHaoZuiPadUrl, "安居客好租HD",HasTwoColumn, flag,iPadflag,3);
	}
	public void GetAppDataByiPhone(int flag,String iPadflag){
	
//		GetDataFromSearchAppRank(testData.AnjukeUrl, "安居客iPhone", HasTwoColumn,flag,iPadflag,1);
//		GetDataFromSearchAppRank(testData.SoufangUrl, "搜房iPhone",HasTwoColumn,flag,iPadflag,1);
//		GetDataFromSearchAppRank(testData.GanJiUrl, "赶集懒人iPhone",HasTwoColumn, flag,iPadflag,1);
//		GetDataFromSearchAppRank(testData.HaoZuUrl, "安居客好租iPhone",HasTwoColumn, flag,iPadflag,1);
		
		driver.refresh();
		HasTwoColumn = 0;
		GetDataFromSearchAppRank(testData.XINFangUrl, "安居客新房iPhone",HasTwoColumn, flag,iPadflag,1);
	}


	private void GetDataFromSearchAppRank(String PageUrl, String SheetName, int HasTwoColumn,int flag,String iPadflag,int appType) {

		driver.get(PageUrl);		
		driver.click("//*[@id='radiodate']/label[2]/span", "点击近一月");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(!iPadflag.equals("1")){
			driver.click("//*[@id='rdChartShow']/label[2]/span", "点击iPhone");
		}else{
			driver.click("//*[@id='rdChartShow']/label[3]/span", "点击iPad");
		}
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(HasTwoColumn == 1){
			TestiPhone(testData.ASORankTable, SheetName, appType + "", flag,testData.uri_app_ranking );
		    TestiPhone(testData.ASORankTable, SheetName, appType +1+"", flag,testData.uri_app_ranking );
		}else{
			TestiPhone_XINFANG(testData.ASORankTable, SheetName, appType+ "", flag,testData.uri_app_ranking );
		}

	}

	public void TestiPhone(String locator, String name, String type, int flag,String uri) {

		int count = 2;
		if (flag == 1) {
			count = driver.getElementCount(locator);
		}
		List<PageIphoneElement> AppiPhoneRank = new ArrayList<PageIphoneElement>();
		for (int i = 2; i <= count; i++) {
			PageIphoneElement iPhoneRank = new PageIphoneElement();
			iPhoneRank.setAppName(name);
			iPhoneRank.setDate(driver.getText(getDateFromIOS(i), "获取第" + i+ "行日期"));
			iPhoneRank.setAppRankType(type);

			if ((type.equals("1"))||(type.equals("3"))) {
				
				iPhoneRank.setAppRank((driver.getText(getHotwordElement(i),"获取第" + i + "行iPhone生活免费")).split(" ")[0]);

			} else {
				iPhoneRank.setAppRank((driver.getText(getiPhoneTotalElement(i),"获取第" + i + "行iPhone总榜免费")).split(" ")[0]);

			}
			AppiPhoneRank.add(iPhoneRank);

		}
		for (PageIphoneElement ss : AppiPhoneRank) {

			testHttpClient httpclient = new testHttpClient();
			GetMD5Security md5test = new GetMD5Security();

			NameValuePair[] values = new NameValuePair[6];
			try {
				appnameEncode = java.net.URLEncoder.encode(ss.getAppName(),
						"utf-8");
				temp = md5test.getMD5Str(appnameEncode + "&"
						+ "46b5742601ef99db4da653dd3f332bf3");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			values[0] = new NameValuePair("names", appnameEncode);
			values[1] = new NameValuePair("types", ss.getAppRankType());
			values[2] = new NameValuePair("rankings", ss.getAppRank());
			values[3] = new NameValuePair("signcode", temp);
			values[4] = new NameValuePair("dates", ss.getDate());
			values[5] = new NameValuePair("init", 1 + "");
			System.out.print(ss.getDate());
			try {
				httpclient.PostHttpClient(testData.domain, testData.port, uri, values);
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}
	public void TestiPhone_XINFANG(String locator, String name, String type, int flag,String uri) {

		int count = 2;
		if (flag == 1) {
			count = driver.getElementCount(locator);
		}
		List<PageIphoneElement> AppiPhoneRank = new ArrayList<PageIphoneElement>();
		for (int i = 2; i <= count; i++) {
			PageIphoneElement iPhoneRank = new PageIphoneElement();
			iPhoneRank.setAppName(name);
			iPhoneRank.setDate(driver.getText(getDateFromIOS(i), "获取第" + i+ "行日期"));
			iPhoneRank.setAppRankType(type);

			if (type.equals("1")||type.equals("3")) {
				iPhoneRank.setAppRank((driver.getText(getHotwordElement(i),"获取第" + i + "行iPhone生活免费")).split(" ")[0]);
			}
			AppiPhoneRank.add(iPhoneRank);

		}
		for (PageIphoneElement ss : AppiPhoneRank) {

			testHttpClient httpclient = new testHttpClient();
			GetMD5Security md5test = new GetMD5Security();

			NameValuePair[] values = new NameValuePair[6];
			try {
				appnameEncode = java.net.URLEncoder.encode(ss.getAppName(),
						"utf-8");
				temp = md5test.getMD5Str(appnameEncode + "&"
						+ "46b5742601ef99db4da653dd3f332bf3");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			values[0] = new NameValuePair("names", appnameEncode);
			values[1] = new NameValuePair("types", ss.getAppRankType());
			values[2] = new NameValuePair("rankings", ss.getAppRank());
			values[3] = new NameValuePair("signcode", temp);
			values[4] = new NameValuePair("dates", ss.getDate());
			values[5] = new NameValuePair("init", 1+ "");
			try {
				
				httpclient.PostHttpClient(testData.domain, testData.port, uri, values);
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}
	public String dologin(Browser driver, String name, String pass) {
		driver.get(testData.BaseUrl);
		if (driver.check(testData.Login, 5)) {
			driver.click(testData.Login, "点击登录按钮");
		} else {
			driver.refresh();
			driver.click(testData.Login, "点击登录按钮");
		}
		driver.type("//*[@id='txtemail']", name, "用户名");
		driver.type("//*[@id='password']", pass, "密码");
		driver.click(testData.LoginSubmit, "登录");
		return driver.getText("//*[@class='headlogo']/div[2]/li[2]/a",
				"获取登录后的用户名", 10);
	}

	public static String getHotwordElement(int n) {
		String element = "//*[@id='dataTableContent']/tr[" + n + "]/td[2]";
		return element;
	}

	public static String getHotwordRankElement(int n) {
		String element = "//*[@id='dataTableContent']/tr[" + n + "]/td[5]";
		return element;
	}

	public static String getHotwordASOElement(int n) {
		String element = "//*[@id='dataTableContent']/tr[" + n + "]/td[6]";
		return element;
	}

	/** 获取横坐标日期 **/
	public static String getDateFromIOS(int n) {
		String element = "//*[@id='dataTableContent']/tr[" + n + "]/td[1]";
		return element;
	}

	/** 获取iphone免费总榜 **/
	public static String getiPhoneTotalElement(int n) {
		String element = "//*[@id='dataTableContent']/tr[" + n + "]/td[3]";
		return element;
	}

}
