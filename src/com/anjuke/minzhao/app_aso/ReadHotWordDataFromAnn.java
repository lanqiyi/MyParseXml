package com.anjuke.minzhao.test;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;

public class ReadHotWordDataFromAnn {

	private Browser driver = null;
	private String temp = null;
	private String appnameEncode = null;
	private String appHotWordEncode = null;

	DataRelativeByAnn9 DataSummary = new DataRelativeByAnn9();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = FactoryBrowser.factoryBrowser();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(groups = {"unstable","undaily"})
	public void ReadHotWordDataFromAnn9() {
		
		dologin(driver, DataSummary .UserName, DataSummary.Password);
//		GetDataFromASO(testData.uri_app_hotword);
	}
	
	public void GetDataFromASO(String uri) {

		driver.get(DataSummary .ASOUrl);
		GetCompanyPage(DataSummary.GanJiTab, "赶集懒人网", driver,uri);
		GetCompanyPage(DataSummary.AnjukeTab, "安居客二手房", driver,uri);
		GetCompanyPage(DataSummary.AnjukeXINFangTab, "安居客新房", driver,uri);
		GetCompanyPage(DataSummary.AnjukeHaozuTab, "安居客好租", driver,uri);
		GetCompanyPage(DataSummary.SouFangTab, "搜房网", driver,uri);

	}

	public void GetCompanyPage(String locator, String sheetname, Browser driver,String uri) {

		driver.refresh();
		driver.click("//*[@id='btn_apps']", "点击页面下拉框");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.check(locator, 5)) {
			driver.moveToElement(locator);
			driver.click(locator, sheetname);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Test(DataSummary.ASORankTable, sheetname,uri);
		} else {
			System.out.print("error");
		}
	}

	public void Test(String locator, String SHEETNAME, String uri) {

		int count = driver.getElementCount(locator);
		List<PageElement> AppHotWordDistrubution = new ArrayList<PageElement>();

		for (int i = 1; i <= count; i++) {
			PageElement PageHotWords = new PageElement();
			PageHotWords.setAppName(SHEETNAME);
			PageHotWords.setAppHotWord(driver.getText(getHotwordElement(i),"获取第" + i + "行热词"));
			PageHotWords.setAppRank(driver.getText(getHotwordRankElement(i),"获取第" + i + "行排名"));
			PageHotWords.setAppWeight(driver.getText(getHotwordASOElement(i),"获取第" + i + "行权重"));
			System.out.println(driver.getText(getHotwordElement(i),"获取第" + i + "行热词"));
			AppHotWordDistrubution.add(PageHotWords);
			
		}
		for (PageElement element : AppHotWordDistrubution) {

			testHttpClient httpclient = new testHttpClient();
			GetMD5Security md5test = new GetMD5Security();

			NameValuePair[] values = new NameValuePair[5];
			try {
				appnameEncode = java.net.URLEncoder.encode(element.getAppName(),"utf-8");
				appHotWordEncode = java.net.URLEncoder.encode(element.getAppHotWord(),"utf-8");
				temp = md5test.getMD5Str(appnameEncode + "&"+ "46b5742601ef99db4da653dd3f332bf3");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			values[0] = new NameValuePair("names", appnameEncode);
			values[1] = new NameValuePair("words",appHotWordEncode);
			values[2] = new NameValuePair("rankings", element.getAppRank());	
			values[3] = new NameValuePair("weights", element.getAppWeight());
			values[4] = new NameValuePair("signcode", temp);
			
			try {
				httpclient.PostHttpClient(DataSummary.domain, DataSummary.port, uri, values);
				
			} catch (IOException e) {

				e.printStackTrace();
			} 

		}
	}

	public String dologin(Browser driver, String name, String pass) {
		driver.get(DataSummary.BaseUrl);
		if (driver.check(DataSummary.Login, 5)) {
			driver.click(DataSummary.Login, "点击登录按钮");
		} else {
			driver.refresh();
			driver.click(DataSummary.Login, "点击登录按钮");
		}
		driver.type("//*[@id='txtemail']", name, "用户名");
		driver.type("//*[@id='password']", pass, "密码");
		driver.click(DataSummary.LoginSubmit, "登录");
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
