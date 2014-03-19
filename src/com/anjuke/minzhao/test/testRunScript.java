package com.anjuke.minzhao.test;

/**
 * 该用例完成检测问答正常搜索功能
 * @Author minzhao
 * @time 2013-07-17 
 * @update 2013-10-31
 */
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.anjuke.ui.publicfunction.PublicProcess;
import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;
import com.anjukeinc.iata.ui.thread.Log;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testRunScript {
	private Browser driver = null;
	//private WebDriver driver = new FirefoxDriver();;
	private String QAHomePage = "http://shanghai.anjuke.com/sale/?from=navigation";
	
	
	
	@BeforeMethod
	public void startUp() {
		
		driver = FactoryBrowser.factoryBrowser();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver = null;
	}
 
	@Test(groups = {"undaily"})
	public void verifyQASearch() throws InterruptedException {
		
		String script =null;
		driver.get(QAHomePage);
		driver.click("//*[@id='prop_name_qt_prop_1']","the first prop");
		
//		for(int i =0;i<=10000;i+=10){
//			script="document.documentElement.scrollTop="+i;
//			driver.runScript(script);
//		}
		driver.switchWindo(2);
		new PublicProcess().ScrollToAnyHeight(driver,10000);
		//driver.runScript(script);
	}
}

