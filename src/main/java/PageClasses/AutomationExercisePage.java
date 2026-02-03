package PageClasses;
import Utils.Log;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class AutomationExercisePage extends BaseClass{
	
	public AutomationExercisePage() {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement loginBtn;
	
	
	public LoginPage  clickLogin() {
		 loginBtn.click();
		 Log.info("Clicking Login button");

		 
		 return new LoginPage();
	}

}
