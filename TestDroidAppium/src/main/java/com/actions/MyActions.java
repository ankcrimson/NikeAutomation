package com.actions;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.business.Home;
import com.helpers.DriverWrapper;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyActions {
	DriverWrapper wrapper;
	String screenshots="target/screenshots/";
	File screenshotDir;
	String device;
	public void setup()
	{
		if(wrapper==null)
		wrapper=new DriverWrapper();
		screenshots+=(new Date()).getTime()+"_"+device+"/";
		screenshotDir=new File(screenshots);
		screenshotDir.mkdirs();
		System.out.println("Using Screenshot Directory As "+screenshots);
	}

	
	@Given("^Browser is (.+) on (.+) and os is (.+) with (.+)$")
	public void browserSelection(String browser,String platform,String os,String device) throws Throwable {
		System.setProperty("browser", browser);
		System.setProperty("platform", platform);
		System.setProperty("os", os);
		System.setProperty("device", device);
		this.device=device.replaceAll(" ", "_");
		setup();
	   // throw new PendingException();
	}

	@Given("^Webpage is (.+)$")
	public void openUrl(String url)
	{
		Home business=new Home();
		business.openURL(wrapper, url);
		File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
		File newScsht=new File(screenshotDir,(new Date()).getTime()+"_openUrl.png");
		screenshot.renameTo(newScsht);
	}
	

@Then("^search for (.+)$")
public void searchForText(String text) throws Throwable {
    Home home=new Home();
    home.searchText(wrapper, text);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
    File newScsht=new File(screenshotDir,(new Date()).getTime()+"_searchText.png");
	screenshot.renameTo(newScsht);
}

@Then("^click on (\\d+)st link$")
public void clickOnLinkPos(int n) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.clickNthLink(wrapper, n);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
    File newScsht=new File(screenshotDir,(new Date()).getTime()+"_clickLink.png");
	screenshot.renameTo(newScsht);
}

@Then("^pick (\\d) from (.+) list$")
public void clickOnLink(int n,String eName) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.choose(wrapper,n, eName);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
    File newScsht=new File(screenshotDir,(new Date()).getTime()+"_clickLink_2.png");
	screenshot.renameTo(newScsht);
}

@Then("^choose (.+)$")
public void clickOnLink(String eName) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.choose(wrapper, eName);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
    File newScsht=new File(screenshotDir,(new Date()).getTime()+"_clickLink_3.png");
	screenshot.renameTo(newScsht);
}


@Then("^wait for (\\d+) ms$")
public void waitForMillis(int time) throws Throwable {
    int wait=time;
    Thread.sleep(wait);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
    File newScsht=new File(screenshotDir,(new Date()).getTime()+"_waitMillis.png");
	screenshot.renameTo(newScsht);
}


@Then("^sample scroll$")
public void sampleScroll() throws Throwable {
    Home home=new Home();
    home.scroll(wrapper);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
    File newScsht=new File(screenshotDir,(new Date()).getTime()+"_scroll.png");
	screenshot.renameTo(newScsht);
    
}



@Then("^close browser$")
public void close_browser() throws Throwable {
	wrapper.close();
}

}
