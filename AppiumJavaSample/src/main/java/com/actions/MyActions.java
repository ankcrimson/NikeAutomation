package com.actions;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.business.Home;
import com.helpers.DriverWrapper;
import com.helpers.PageElementsHelper;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyActions {
	DriverWrapper wrapper;
	
	
	public void setup()
	{
		if(wrapper==null)
		wrapper=new DriverWrapper();
	}

	
	@Given("^Browser is (.+) on (.+) and os is (.+)$")
	public void browserSelection(String browser,String platform,String os) throws Throwable {
		Class.forName("com.helpers.PageElementsHelper");
		System.setProperty("browser", browser);
		System.setProperty("platform", platform);
		System.setProperty("os", os);
		setup();
	   // throw new PendingException();
	}

	@Given("^Webpage is (.+)$")
	public void openUrl(String url)
	{
		Home business=new Home();
		business.openURL(wrapper, url);
		File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
	}
	

@Then("^search for (.+)$")
public void searchForText(String text) throws Throwable {
    Home home=new Home();
    home.searchText(wrapper, text);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}

@Then("^click on (\\d+)st link$")
public void clickOnLinkPos(int n) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.clickNthLink(wrapper, n);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}

@Then("^pick (\\d) from (.+) list$")
public void clickOnLink(int n,String eName) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.choose(wrapper,n, eName);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}

@Then("^choose (.+)$")
public void clickOnLink(String eName) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.choose(wrapper, eName);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}



@Then("^sendkeys (.+) in (.+)$")
public void sendKeys(String text,String eName) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.sendText(wrapper, eName, text);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}


@Then("^select (.+)$")
public void select(String skusize) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.select(wrapper, skusize);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}

@Then("^scroll (\\d+) (\\d+)$")
public void scroll(int x, int y) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.scroll(wrapper, x, y);
	File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}


@Then("^wait for (\\d+) ms$")
public void waitForMillis(int time) throws Throwable {
    int wait=time;
    Thread.sleep(wait);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}


@Then("^sample scroll$")
public void sampleScroll() throws Throwable {
    Home home=new Home();
    home.scroll(wrapper);
    File screenshot = ((TakesScreenshot)wrapper.getDriver()).getScreenshotAs(OutputType.FILE);
}



@Then("^close browser$")
public void close_browser() throws Throwable {
	wrapper.close();
}

}
