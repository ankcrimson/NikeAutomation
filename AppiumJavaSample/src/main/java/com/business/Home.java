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
	
	public void scroll(DriverWrapper wrapper) {
		MobileDriver driver = (MobileDriver) wrapper.getDriver();
		HomePage page = new HomePage();
	/*	try {
			TouchAction act1 = new TouchAction(driver);
			act1.press(583, 752);
			act1.moveTo(218, 752);
			act1.release();
			act1.perform();
			// act1.perform();
			driver.performTouchAction(act1);
			System.out.println(1);
		} catch (Throwable ex) {
			System.out.println("--" + ex.getLocalizedMessage());
		}
		try {
			driver.swipe(583, 752, 218, 752, 1000);
			System.out.println(2);
		} catch (Throwable ex) {
			System.out.println("--" + ex.getLocalizedMessage());
		}
		
		try {
			TouchAction act1=new TouchAction(driver);
			act1.longPress(583, 742);
			act1.perform();
			driver.performTouchAction(act1);
			System.out.println(2);
		} catch (Throwable ex) {
			System.out.println("--" + ex.getLocalizedMessage());
		}
		try {
			TouchAction act1=new TouchAction(driver);
			act1.longPress(583, 742);
			act1.moveTo(218, 752);
			act1.release();
			//driver.performTouchAction(act1);
			act1.perform();
			TouchAction act2=new TouchAction(driver);
			act2.longPress(218, 742);
			act2.moveTo(518, 742);
			act2.release();
			act2.perform();
			//driver.performTouchAction(act1);
			
			MultiTouchAction act=new MultiTouchAction(driver);
			act.add(act1);
			act.add(act2);
			act.perform();
			driver.performMultiTouchAction(act);
			System.out.println(2);
		} catch (Throwable ex) {
			System.out.println("--" + ex.getLocalizedMessage());
		}
		*/
		try {
			TouchAction action=new TouchAction(driver);
			action.press(0, 1533).waitAction(300).moveTo(0, 219).release()
			.perform();
			System.out.println("3333333333333333");
		} catch (Throwable ex) {
			System.out.println("--" + ex.getLocalizedMessage());
			ex.printStackTrace();
		}
		
	}
}
