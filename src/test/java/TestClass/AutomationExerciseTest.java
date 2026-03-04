package TestClass;
import Utils.Log;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageClasses.AutomationExercisePage;
import PageClasses.LoginPage;

@Listeners(Utils.TestListener.class)
public class AutomationExerciseTest extends BaseClass {
	
	@Test
	public void testOnLogin() {
		
		AutomationExercisePage ap = new AutomationExercisePage();
		
		LoginPage lp =   ap.clickLogin();
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Automation Exercise - Signup / Login");
	}

}
