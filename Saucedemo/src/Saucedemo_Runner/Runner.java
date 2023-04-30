package Saucedemo_Runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Saucedemo_Locaotrs.FetchingItmesfrom_Cart;
import Saucedemo_Locaotrs.Filter_Test;
import Saucedemo_Locaotrs.HomePage;
import Saucedemo_Locaotrs.LoginTesting;
import SelectionFor_theBrowser.Browser_Selection;

public class Runner {

	LoginTesting obj1;
	HomePage obj2;
	FetchingItmesfrom_Cart obj3;
	Filter_Test obj4;
	WebDriver driver;
	
	@Test(priority = 1)
	public void Login()
	{
		driver = Browser_Selection.Select("Firefox", "https://www.saucedemo.com/");
		obj1 = PageFactory.initElements(driver, LoginTesting.class);
		
		//Login with invalid data
		obj1.Login_Test("standard_user", "secret");
		
	
		obj1.Login_Test_Verify_with_Invalid_Data();
		
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Login with valid data
		obj1.Login_Test("standard_user", "secret_sauce");
		obj1.Login_Test_Verify_with_valid_Data();
	}
	
	@Test(priority = 2)
	public void Add_first_Product_from_Inside()
	{
		obj2 = PageFactory.initElements(driver, HomePage.class);
		obj2.add_Products_to_cartList();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj2.Add_choosen_Product_from_Inside(2);
		
	}
	
	@Test(dependsOnMethods = "Add_first_Product_from_Inside")
	public void Add_2nd_Product_from_Inside()
	{
		driver.navigate().to("https://www.saucedemo.com/inventory.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		obj2.Add_choosen_Product_from_Inside(3);
	}
	
	@Test(priority = 3)
	public void TestingNumber_OfItmesin_cart()
	{
		obj3 = PageFactory.initElements(driver, FetchingItmesfrom_Cart.class);
		obj3.afterclick_onbuket_cartpage_should_open_verifying_it();
		obj3.check_Number_ofItems_Present_in_a_cart();
	}
	
	@Test(priority = 4)
	public void Filter()
	{
		obj4 = PageFactory.initElements(driver, Filter_Test.class);
		driver.navigate().to("https://www.saucedemo.com/inventory.html");
		obj4.filter_Test("Name (A to Z)");
		obj4.verifying_given_Filter_Is_givin_correct_result();
	}
	
}
