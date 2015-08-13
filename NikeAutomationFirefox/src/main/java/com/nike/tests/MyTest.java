package com.nike.tests;

import io.appium.java_client.AppiumDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nike.Setup;

public class MyTest extends Setup {

	@Test
	public void myTest()
	{
		
		
		new WebDriverWait(driver, 10000)
        .until(ExpectedConditions.presenceOfElementLocated(By.id("org.mozilla.firefox:id/url_bar_title")));
   try {   
	  WebElement titlebar= driver.findElement(By.id("org.mozilla.firefox:id/url_bar_title"));
	  titlebar.click();
	  
	  
	   Thread.sleep(2000);
	   //WebElement addBar=driver.findElement(By.id("org.mozilla.firefox:id/url_edit_text"));
	   WebElement addBar=driver.findElement(By.className("android.widget.EditText"));
	  
	   
	   System.out.println("Sending URL");
	   addBar.sendKeys("http://www.nike.com\n");
	   
	   System.out.println("URL Sent");
	   Thread.sleep(7000);
		  
	   
	   Set<String> contextNames = ((AppiumDriver)driver).getContextHandles();
	   for (String contextName : contextNames) {
	       System.out.println(contextNames); //prints out something like NATIVE_APP \n WEBVIEW_1
	   }
	   
   } catch (Exception e) {
       driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
       e.printStackTrace();
   }

		
	}
}
