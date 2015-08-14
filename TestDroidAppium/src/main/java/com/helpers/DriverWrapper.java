package com.helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
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
	Properties env=new Properties();
    File propfile=new File("src/credentials/credentials.properties");
    try{
    	java.io.FileReader fr=new java.io.FileReader(propfile);
    	env.load(fr); 
    }catch(Exception ex){ex.printStackTrace();}
    String testdroid_username = env.getProperty("TESTDROID_USERNAME");
    String testdroid_password = env.getProperty("TESTDROID_PASSWORD");
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
	String device_os=props.getProperty("os");
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
		else if(device_os.equalsIgnoreCase("android"))
		{
			try{
			DesiredCapabilities  capabilities = new DesiredCapabilities();
		    //----TESTDROID
			capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("deviceName", "Android Device");
	        capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("testdroid_username", testdroid_username);
	        capabilities.setCapability("testdroid_password", testdroid_password);
	        capabilities.setCapability("testdroid_target", "chrome");
	        capabilities.setCapability("testdroid_project", "LocalAppium");
	        capabilities.setCapability("testdroid_testrun", "Android Run 1");
	        //capabilities.setCapability("testdroid_device", "Samsung Galaxy Nexus GT-I9250 4.2.2"); // Freemium device
	        //capabilities.setCapability("testdroid_device", "Nvidia Shield Tablet"); // Freemium device
	        capabilities.setCapability("testdroid_device", "Samsung Galaxy Nexus SPH-L700 4.3"); // Freemium device
	        //----TESTDROID
		    driver = new AndroidDriver(new URL("http://appium.testdroid.com/wd/hub"), capabilities);
			
			}catch(Exception ex){ex.printStackTrace();}
		}
		else if(device_os.equalsIgnoreCase("ios"))
		{
			try{
				DesiredCapabilities  capabilities = new DesiredCapabilities();
			    //----TESTDROID
				capabilities.setCapability("platformName", "iOS");
		        capabilities.setCapability("device", "iphone");
		        capabilities.setCapability("deviceName", "iOS Phone");
		        capabilities.setCapability("browserName", "Safari");
				capabilities.setCapability("testdroid_username", testdroid_username);
		        capabilities.setCapability("testdroid_password", testdroid_password);
		        capabilities.setCapability("testdroid_target", "safari");
		        capabilities.setCapability("testdroid_project", "LocaliOSAppium");
		        capabilities.setCapability("testdroid_testrun", "IOS Run 1");
		      //capabilities.setCapability("testdroid_device", "iPad 3 A1416 8.2");
		        capabilities.setCapability("testdroid_device", "iPhone 5 A1429 6.1.4");
		        //capabilities.setCapability("testdroid_device", "iPhone 4S A1387 6.1.3");
		        //capabilities.setCapability("testdroid_device", "iPad 2 A1395 7.0.4");
			    //----TESTDROID
			    driver = new IOSDriver(new URL("http://appium.testdroid.com/wd/hub"), capabilities);
				
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
