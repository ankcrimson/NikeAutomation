package com.tests;

import org.junit.runner.RunWith;

import com.actions.MyActions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.TestCase;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"com.actions"},tags={"@Complete"})
public class CucumberRunner{

	
	public void mytest()
	{
		
	}
}
