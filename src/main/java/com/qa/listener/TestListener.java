package com.qa.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.qa.util.TestUtil;

public class TestListener implements ITestListener {
	//This method will executed when Test Execution is started
	/*Strategy used to generate statistics for the current run 
	Available strategies are: 
	•BDD: Strategy for BDD-style (Gherkin) tests
	•CLASS: Used for 2 levels: Class, Test
	•SUITE: Used for 3 levels: Suite, Class, Test
	•TEST: Used for 1 level only: Test
	 */
	//You can Define the AnalysisStartegy as per your requirement
	public synchronized void onStart(ITestContext context) {
		ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);
	}
	//On start of each test this method will crete a method in extent report
	public synchronized void onTestStart(ITestResult result) {
		ExtentTestManager.createMethod(result, true);
	}
	//On test success, we will log the result
	public synchronized void onTestSuccess(ITestResult result) {
		ExtentTestManager.log(result, true);
	}
	//On test failure, we will log the result and take the screenshot of the failure
	public synchronized void onTestFailure(ITestResult result) {
		ExtentTestManager.log(result, true);
		try {
			ExtentTestManager.getTest().addScreenCaptureFromPath(TestUtil.takeScreenShot("screenshot"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//This will log the Test as skippped in report
	public synchronized void onTestSkipped(ITestResult result) {
		ExtentTestManager.log(result, true);
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	//Once the test Execution is finished we will flush the ExtentService Instance
	//flush() method will Aggregate all the test results and build the final report file
	public synchronized void onFinish(ITestContext context) {
		ExtentService.getInstance().flush();
	}
}
