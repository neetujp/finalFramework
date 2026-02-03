package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageClasses.AELoginPage;
import PageClasses.AutomationExercisePage;
import PageClasses.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void testToLogin() {

		AutomationExercisePage ap = new AutomationExercisePage();

		LoginPage lp = ap.clickLogin();

		AELoginPage al = lp.clickLoginToPage("neetujp11@gmail.com", "Bahrain@2017");

		String title = driver.getTitle();

		Assert.assertEquals(title, "Automation Exercise");

	}
}