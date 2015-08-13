package com.actions;

import com.business.Home;
import com.helpers.DriverWrapper;

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
	}
	

@Then("^search for (.+)$")
public void searchForText(String text) throws Throwable {
    Home home=new Home();
    home.searchText(wrapper, text);
}

@Then("^click on (\\d+)st link$")
public void clickOnLinkPos(int n) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.clickNthLink(wrapper, n);
}

@Then("^pick (\\d) from (.+) list$")
public void clickOnLink(int n,String eName) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.choose(wrapper,n, eName);
}

@Then("^choose (.+)$")
public void clickOnLink(String eName) throws Throwable {
    //throw new PendingException();
	Home home=new Home();
    home.choose(wrapper, eName);
}


@Then("^wait for (\\d+) ms$")
public void waitForMillis(int time) throws Throwable {
    int wait=time;
    Thread.sleep(wait);
}


@Then("^sample scroll$")
public void sampleScroll() throws Throwable {
    Home home=new Home();
    home.scroll(wrapper);
}



@Then("^close browser$")
public void close_browser() throws Throwable {
	wrapper.close();
}

}
