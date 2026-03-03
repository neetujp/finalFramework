package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BasePackage.BaseClass;


public class TestListener extends BaseClass implements ITestListener {

	 @Override
	    public void onTestStart(ITestResult result) {
	        Log.info("Test started: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        Log.info("Test passed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        Log.error("Test failed: " + result.getMethod().getMethodName(), result.getThrowable());

	        // Take screenshot
	        ScreenShotUtils.capture(driver, result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        Log.warn("Test skipped: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onStart(ITestContext context) { }

	    @Override
	    public void onFinish(ITestContext context) { }
}