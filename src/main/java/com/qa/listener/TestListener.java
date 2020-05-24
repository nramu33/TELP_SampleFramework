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

    public synchronized void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);
    }

    public synchronized void onFinish(ITestContext context) {
        ExtentService.getInstance().flush();
    }

    public synchronized void onTestStart(ITestResult result) {
        ExtentTestManager.createMethod(result, true);
    }

    public synchronized void onTestSuccess(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    public synchronized void onTestFailure(ITestResult result) {
        ExtentTestManager.log(result, true);
        try {
			ExtentTestManager.getTest().addScreenCaptureFromPath(TestUtil.takeScreenShot("screenshot"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public synchronized void onTestSkipped(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

}
