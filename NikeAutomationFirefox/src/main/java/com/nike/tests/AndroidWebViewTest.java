package com.nike.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.android.chimpchat.adb.AdbBackend;
import com.android.chimpchat.core.IChimpDevice;

import org.openqa.selenium.interactions.touch.TouchActions;

public class AndroidWebViewTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File app = new File(classpathRoot, "src/main/resources/selendroid-test-app.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        
        capabilities.setCapability("browserName","android");
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName","selendroid");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "io.selendroid.testapp");
        capabilities.setCapability("appActivity", ".HomeScreenActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	
//    	SelendroidCapabilities caps = new SelendroidCapabilities("io.selendroid.testapp:0.10.0");
//    	driver = new SelendroidDriver(caps);
//    	
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void webView() throws InterruptedException {
        try{
        	Thread.sleep(6000);
        	//WebElement button = driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview"));
        	WebElement button = driver.findElement(By.className("android.widget.ImageButton"));
        button.click();
        Thread.sleep(6000);
        
        /*TouchActions e1=new TouchActions(driver);
        WebElement pages = driver.findElement(By.id("vp_pages"));
        TouchActions flick = new TouchActions(driver).flick(pages, -100, 0, 0);
        flick.perform();
        
        TouchAction ta = new TouchActionBuilder().pointerDown(300, 400).
        		pointerMove(-100, 400).pointerUp().build(); 
        		ta.perform(driver);
        
        */
        
        Set<String> contextNames = driver.getContextHandles();
        System.out.println(contextNames);
        for (String contextName : contextNames) {
          if (contextName.contains("WEBVIEW")){
        	  System.out.println(contextName);
              driver.context(contextName);
              driver.get("http://m.nike.com/us/en_us/pd/air-zoom-pegasus-32-running-shoe/pid-10294427/pgid-10266840");
              System.out.println("link opened");
          }
        }
        //driver.context("NATIVE_APP");
        
        //NATIVE_APP
//        contextNames = driver.getContextHandles();
//        for (String contextName : contextNames) {
//          if (contextName.contains("NATIVE_APP")){
//        	  System.out.println(contextName);
//              driver.context(contextName);
//          }
//        }
        Thread.sleep(16000);
//        
        try{
        WebElement el=driver.findElement(By.id("rect"));
        
        TouchAction act=new TouchAction(driver);
        act.press(el, 10, 10).release().perform();
        }catch(Throwable th){th.printStackTrace();}
        
        try{
            WebElement el=driver.findElement(By.id("rect"));
            
            TouchAction act=new TouchAction(driver);
            act.press(200, 800).moveTo(-50, 0).perform();
            }catch(Throwable th){th.printStackTrace();}
            
        
        
//        IChimpDevice chimpDevice;
//        AdbBackend adbBackend = new AdbBackend();
//        chimpDevice = adbBackend.waitForConnection();
//        chimpDevice.drag(300, 800, 100, 800, 30, 1000);
//        chimpDevice.dispose();
        
        
        Thread.sleep(6000);
        
        }catch(Throwable th){
        	th.printStackTrace();
        }
    }

}