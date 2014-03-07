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

import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;
import com.anjukeinc.iata.ui.thread.Log;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class test {
	//private Browser driver = null;
	private WebDriver driver = new FirefoxDriver();;
	private String QAHomePage = "http://shanghai.anjuke.com/prop/view/195236714";
	private  int height;
	@BeforeMethod
	public void startUp() {
		
		//driver = FactoryBrowser.factoryBrowser();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver = null;
	}
 
	@Test(groups = {"undaily"})
	public void sssssss() throws InterruptedException {

//		driver.get(QAHomePage);
//		Thread.sleep(2000);	
//	    String setscroll = null ; 
//	   
//	    JavascriptExecutor jse=(JavascriptExecutor) driver;  
//	    for(height =0;height<=10000;height+=40){	
//		    setscroll="document.documentElement.scrollTop="+height;
//	    try{
//	          jse.executeScript(setscroll);  
//	       } catch (Exception e) {  
//	           System.out.println("Fail to set the scroll.");  
//	       }  
//	   }
		driver.get("http://shanghai.anjuke.com/community/view/9332");
	    Wait<WebDriver> wait = new WebDriverWait(driver, 20);
	    WebElement element = wait.until(visibilityOfElementLocated(By.tagName("//*[@id='commqalist']/li[1]/a")));
	    
	}
	
	public ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {    
	    return new ExpectedCondition<WebElement>() {    
	          public WebElement apply(WebDriver driver) {    
	            WebElement element = driver.findElement(by);    
	            return element.isDisplayed() ? element : null;    
	          }    
	    };    
	} 
}
