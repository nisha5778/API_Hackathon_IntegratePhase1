package runner;
//import io.cucumber.junit.CucumberOptions;/// this creates a problem
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//reporting purpose
		monochrome=false,  //console output color
		dryRun = false,
		//tags = "@1CreateData", //tags from feature file
		features = {"src/test/resources/features/17AssignmentP.feature", 
					//"src/test/resources/features/18AssignmentSubP.feature",
					"src/test/resources/features/19Delete.feature",
					"src/test/resources/features/20AssignmentN.feature"},
					//"src/test/resources/features/21AssignmentSubN.feature"},
				//features = {"src/test/resources/features/20AssignmentN.feature"},
		glue= "stepdefinitions",
		plugin = {"pretty", "html:target/testResult1.html"
				,"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		//tags = "@1CreateDataP"
		) //location of step definition files

public class TestRunner extends AbstractTestNGCucumberTests{
	
}






//package runner;
///*
//import org.junit.runner.RunWith;
//import io.cucumber.junit.*;
//import org.junit.AfterClass;
//import org.junit.runner.RunWith;
//*/
//
//
////import io.cucumber.junit.CucumberOptions;/// this creates a problem
//
//import io.cucumber.testng.CucumberOptions;
//
////import org.junit.runner.RunWith;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//
//
////@RunWith(Cucumber.class)
//@CucumberOptions(
//plugin = {"pretty","html:Report/cucumber-reports.html"}, //reporting purpose
//			monochrome=true,  //console output color and removes unecessary options
//			dryRun=false ,
////		features = {"src\test\resources\features\17AssignmentP.feature",
////				"src\test\resources\features\18AssignmentN.feature",
////				"src\test\resources\features\19AssignmentSubP.feature",
////				"src\test\resources\features\20AssignmentSubN.feature",
////				"src\test\resources\features\21Delete.feature"},
//		
//		features = {"src\test\resources\features\18AssignmentN.feature"},
//		glue= "stepdefinitions")
//public class TestRunner {//extends AbstractTestNGCucumberTests{
//
//}

//AssignmentPositiveScenarios.feature
//postsubassignment.feature
//@1CreateDataP
//@assign
//@assignid- showing not found   id for already created assginment id-get grades