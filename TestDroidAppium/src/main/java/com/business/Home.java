package com.business;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.helpers.DriverWrapper;
import com.pages.HomePage;

public class Home extends CommonBusiness {
	
	public void searchText(DriverWrapper wrapper,String text)
	{
		HomePage page=new HomePage();
		WebElement searchBox=page.getElement(wrapper, "searchbar");
		searchBox.sendKeys(text);
		WebElement searchBtn=page.getElement(wrapper, "searchbtn");
		searchBtn.click();
	}

	
	public void clickNthLink(DriverWrapper wrapper,int num)
	{
		HomePage page=new HomePage();
		List<WebElement> links=page.getElements(wrapper, "resultLinks");
		System.out.println(links.size());
		links.get(num-1).click();
	}

	public void choose(DriverWrapper wrapper,String ref)
	{
		HomePage page=new HomePage();
		WebElement ref_element=page.getElement(wrapper, ref);
		ref_element.click();
	}
	public void choose(DriverWrapper wrapper,int n,String ref)
	{
		HomePage page=new HomePage();
		List<WebElement> ref_element=page.getElements(wrapper, ref);
		for(WebElement elem:ref_element)
		{
			if(elem.isDisplayed()&&elem.isEnabled())
			{
				elem.click();
				System.out.println("Chosen");
				break;
			}
		}
	}
	
	public void scroll(DriverWrapper wrapper)
	{
		MobileDriver driver=(MobileDriver)wrapper.getDriver();
		HomePage page=new HomePage();
		try{
			TouchAction act1=new TouchAction(driver);
			act1.press(200, 100);
			act1.press(100, 100);
			act1.release();
			act1.perform();
		}catch(Throwable ex){ex.printStackTrace();}
		try{
		MobileDriver driver1=(MobileDriver)driver;
		driver1.swipe(929, 440, 120, 440, 1000);
		}catch(Throwable ex){ex.printStackTrace();}
		
		try{
			MobileDriver driver1=(MobileDriver)driver;
			TouchAction action=new TouchAction(driver1);
			action.press(100, 100).moveTo(10, 100).release();
			driver1.performTouchAction(action);
			}catch(Throwable ex){ex.printStackTrace();}
			
		
	}
}
