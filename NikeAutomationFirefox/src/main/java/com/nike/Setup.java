package com.nike;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Setup {

	public WebDriver driver;
	@Before
	public void setup()
	{
        File appDir = new File("src/main/resources");
        File app = new File(appDir, "Firefox.apk"); //my case ìdemo1.apkî
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("autoLaunch", true);        
        capabilities.setCapability("deviceName","GT-I9300");
        capabilities.setCapability(CapabilityType.BROWSER_NAME,  "");
        capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
        capabilities.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "org.mozilla.firefox");  
        capabilities.setCapability("appActivity", "org.mozilla.gecko.BrowserApp");  //my case RootActivity
        try{
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        
        }catch(MalformedURLException ex){ex.printStackTrace();}

	}
	
	@After
	public void end()
	{
		driver.quit();
	}
}
