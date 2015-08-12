package com.helpers;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/*
 * To act like a Driver Wrapper responsible for managing the web/appium driver
 */
public class DriverWrapper {
	private WebDriver driver;
public WebDriver getDriver()
{
	if(driver!=null)
		return driver;
	Properties props=System.getProperties();
	
	/*
	DesiredCapabilities  capabilities = new DesiredCapabilities();
    capabilities.setCapability("device","Android");
    capabilities.setCapability("app", "Chrome");
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    capabilities.setCapability(CapabilityType.VERSION, "4.3");
    capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
    WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
     */
	
	String platform=props.getProperty("platform");
	String browser="firefox";
	
	if(props.containsKey("browser"))
	{
	browser=props.getProperty("browser").trim().toLowerCase();	
	//System.out.println(browser);
	}
	//System.out.println(props);
	if(browser.equals("chrome"))
	{
		if(platform.equalsIgnoreCase("desktop"))
		{
			String os=props.get("os.name").toString();
		if(os.equalsIgnoreCase("linux"))
			if(props.get("os.arch").toString().equals("amd64"))
				System.setProperty("webdriver.chrome.driver", "src/main/resources/execs/chromedriver_l64");
			else
				System.setProperty("webdriver.chrome.driver", "src/main/resources/execs/chromedriver_l32");
		else if(os.toUpperCase().contains("MAC"))
		{
			System.setProperty("webdriver.chrome.driver", "src/main/resources/execs/chromedriver_mac");
		}
		else
			System.setProperty("webdriver.chrome.driver", "src/main/resources/execs/chromedriver.exe");
		driver=new ChromeDriver();
		}
		else
		{
			try{
			DesiredCapabilities  capabilities = new DesiredCapabilities();
		    capabilities.setCapability("deviceName","Nirajbrands");
		    capabilities.setCapability("touchEnabled",true);
		    capabilities.setCapability("browserName", "Chrome");
		   // capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		    capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
		    capabilities.setCapability("platformName", "Android");
		    
		    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
	else
	{
		driver=new FirefoxDriver();
	}
	
	
	return driver;
}
public void close()
{
if(driver!=null)
{
	driver.close();
}
}
}
