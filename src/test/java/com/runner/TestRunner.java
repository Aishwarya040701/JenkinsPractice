package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature", glue = { "com.stepdefinition"}, plugin = {
		"pretty",
		"html:target/Report.html" }, 
tags = "@Login or @Product or @Cart or @Information or @ProductCheckout", monochrome = true, dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
	
	

}
