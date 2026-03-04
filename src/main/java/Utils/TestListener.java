package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BasePackage.BaseClass;


public class TestListener extends BaseClass implements ITestListener {

	private static ExtentReports extent = ExtentManager.getExtent();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        Log.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
        Log.info("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("Test failed: " + result.getMethod().getMethodName(), result.getThrowable());

        String path = ScreenShotUtils.capture(driver, result.getMethod().getMethodName());

        test.get().fail(result.getThrowable());
        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
        Log.warn("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}