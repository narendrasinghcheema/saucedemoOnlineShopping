package Saucedemo_Locaotrs;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import graphql.Assert.*;

public class LoginTesting {

	WebDriver driver;
	
	String user_N = "";
	String User_P = "";
	
	String afterLogin_url = "https://www.saucedemo.com/inventory.html";
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement User_Name;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement User_Password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement Login_Buttone;
	
	@FindBy(xpath = "//div[@class='error-message-container error']")
	WebElement error_checking;
	
	public LoginTesting(WebDriver IDriver1)
	{
		this.driver = IDriver1;
	}
	
	public void Login_Test(String Name, String Password)
	{
		User_Name.sendKeys(Name);
		User_Password.sendKeys(Password);
		this.user_N = Name;
		this.User_P = Password;
	}
	
	public void Login_Test_Verify_with_Invalid_Data()
	{
		Login_Buttone.click();
		String error = error_checking.getText();
		switch (error)
		{
		
		case "Epic sadface: Username and password do not match any user in this service":
			System.out.println("Epic sadface: Username and password do not match any user in this service");
			System.out.println("User was not able to Login with this\nUserName = "+user_N+"\nPassword = "+User_P);
			break;
	     }
		
	}
	public void Login_Test_Verify_with_valid_Data()
	{
		Login_Buttone.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getCurrentUrl(), afterLogin_url, "User is Successfully Loged-in");
		
	}
}
