package Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import BasePackage.BaseClass;

public class RetryClass extends BaseClass  implements IRetryAnalyzer  {

	

	int counter = 0;
	int maxRetry = 1;

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Test has failed, Retrying again  " + result.getMethod().getMethodName());
		if (counter < maxRetry) {
			counter++;
			return true;
		}
		return false;
	}

	
}
