package PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath ="//input[@data-qa='login-email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement passwordField ;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement loginBtn ;
	
	
	public AELoginPage  clickLoginToPage(String email, String password) {
	    emailField.sendKeys(email);
	    passwordField.sendKeys(password);
		loginBtn.click();
		return new AELoginPage();
	}
	
	

}
