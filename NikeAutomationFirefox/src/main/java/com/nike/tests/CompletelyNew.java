package com.nike.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CompletelyNew {
	public AppiumDriver driver;
	@Before
	public void setup()
	{
        File appDir = new File("src/main/resources");
        File app = new File(appDir, "selendroid-test-app.apk"); //my case ìdemo1.apkî
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //
//        capabilities.setCapability("autoLaunch", true);        
        capabilities.setCapability("deviceName","GT-I9300");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformVersion", "4.3");
        capabilities.setCapability("automationName","selendroid");
        //capabilities.setCapability("appPackage", "io.selendroid.testapp");  
        //capabilities.setCapability("appActivity", ".HomeScreenActivity");  //my case RootActivity
        try{
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        
        }catch(MalformedURLException ex){ex.printStackTrace();}

	}
	
	@Test
	public void test()
	{
		WebElement wv_start=driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview"));
				wv_start.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("io.selendroid.testapp:id/mainWebView")));
		try{
		Thread.sleep(5000);
		}catch(Exception ex){}
		System.out.println(driver.getContextHandles());
			System.out.println(driver.getPageSource());
		driver.zoom(100, 600);
		try{
			Thread.sleep(5000);
			}catch(Exception ex){}
	}
	
	
	@After
	public void end()
	{
		driver.quit();
	}

}