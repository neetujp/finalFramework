package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageClasses.AELoginPage;
import PageClasses.AutomationExercisePage;
import PageClasses.LoginPage;
import Utils.ExcelUtils;

public class LoginTest extends BaseClass {
	
	
	

	@Test
	public void testToLogin() throws Exception {
		
		String path = "C:/Users/NeetuJayapalan/Desktop/LoginData.xlsx";

        String email = ExcelUtils.getCellData(path, "Sheet1", 1, 0);
        String password = ExcelUtils.getCellData(path, "Sheet1", 1, 1);

		AutomationExercisePage ap = new AutomationExercisePage();

		LoginPage lp = ap.clickLogin();

		AELoginPage al = lp.clickLoginToPage(email, password);

		String title = driver.getTitle();

		Assert.assertEquals(title, "Automation Exercise");

	}
}