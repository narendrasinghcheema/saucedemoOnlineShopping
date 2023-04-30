package Saucedemo_Locaotrs;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import graphql.Assert.*;

public class FetchingItmesfrom_Cart {

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement addCartLogo;
	
	WebDriver driver;
	
	static ArrayList<String> sr = new ArrayList<>();
	
	@FindBy(xpath = "//div[contains(@class,'inventory_item_name')]")
	WebElement checkingNumberofItems;
	
	public FetchingItmesfrom_Cart(WebDriver IDriver10)
	{
		this.driver = IDriver10;
	}
	
	public void afterclick_onbuket_cartpage_should_open_verifying_it()
	{
		addCartLogo.click();
		assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
	}
     
	public void check_Number_ofItems_Present_in_a_cart()
	{
		int i = 0;
		for(WebElement s : driver.findElements(By.xpath("//div[contains(@class,'inventory_item_name')]")))
		{
			sr.add(s.getText());
		}
		
		for(String s : sr)
		{
			i++;
			System.out.println(s);
		}
		System.out.println("there are totale = "+i+" items in the shopping cart");
	}
	
	
}
