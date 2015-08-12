package com.business;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
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
				ref_element.get(n-1).click();
				break;
			}
		}
	}
	
	public void scroll(DriverWrapper wrapper)
	{
		TouchActions touchs=new TouchActions(wrapper.getDriver());
		touchs.clickAndHold();
		touchs.scroll(10, 10);
		touchs.release();
	}
}
