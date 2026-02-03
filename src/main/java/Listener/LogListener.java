package Listener;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BasePackage.BaseClass;
import Utils.Log;




public class LogListener  implements WebDriverListener   {
	
	 @Override
	    public void beforeClick(WebElement element) {
	        Log.info("Before clicking element: " + element);
	    }

	    @Override
	    public void afterClick(WebElement element) {
	        Log.info("After clicking element");
	    }

	    @Override
	    public void beforeGet(WebDriver driver, String url) {
	        Log.info("Navigating to URL: " + url);
	    }

	    @Override
	    public void afterGet(WebDriver driver, String url) {
	        Log.info("Navigation completed");
	    }

	    @Override
	    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
	        Log.error("Exception occurred in: " + method.getName(), e);
	    }

}
