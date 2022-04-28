package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="Feature/OrangeHRM.feature",glue="StepDefinition")
public class TestRunner extends AbstractTestNGCucumberTests{

	
	
}
	