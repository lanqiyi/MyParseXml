package com.anjuke.minzhao.test;

/**
 * 该用例完成检测问答正常搜索功能
 * @Author minzhao
 * @time 2013-07-17 
 * @update 2013-10-31
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;


public class test {
	private Browser driver = null;
	//private WebDriver driver = new FirefoxDriver();;
	private String QAHomePage = "http://shanghai.anjuke.com/prop/view/195236714";
	private  int height;
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
      
	public void performSomeAction() {    
	    driver.get("http://shanghai.anjuke.com"); 
//	    WebElement myDynamicElement = (new WebDriverWait(, 10))
//	    		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='login_l']/div[1]/a[1]")));        
   }   
	
}
