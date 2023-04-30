package Saucedemo_Locaotrs;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import graphql.Assert;

public class HomePage {

	static WebDriver driver;
	
	static int n = 0;
	
	
	@FindBy(xpath = "//div[contains(@class,'inventory_item_name')]")
	WebElement Items_Names;
	
	@FindBy(xpath = "//div[contains(@class,'inventory_details_price')]")
	WebElement Price;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn_primary btn_small btn_inventory') and contains(text(),'Add to cart')]")
	WebElement Add_to_cart;
	
	@FindBy(xpath = "//*[@class='shopping_cart_badge']")
	static
	WebElement add_to_cart;
	
	@FindBy(xpath = "//*[contains(@class,'shopping_cart_badge') and contains(text(),'%s')]")
	WebElement Buket_added;
	
	 public HomePage(WebDriver IDriver2)
	 {
		 this.driver = IDriver2;
	 }
	 
	static ArrayList<String> items = new ArrayList<>();
	public ArrayList<String> add_Products_to_cartList()
	{
		int i = 0;
		for(WebElement ele : driver.findElements(By.xpath("//div[contains(@class,'inventory_item_name')]")))
		{
			items.add(ele.getText());
		}
		System.out.println("Itmes are = ");
		
		for(String item : items)
		{
			i++;
			System.out.println(i+" = "+item);
			
		}
		System.out.println("so there are total = "+i+" products");
		
		return items;
	}
	
	public void Add_choosen_Product_from_Inside(int number)
	{
		for(int i=1;i<items.size();i++)
		{
			if(i == number)
			{
				String Product_Name = items.get(i);
				
				String xp = String.format("//div[contains(@class,'inventory_item_name') and contains(text(),'%s')]", Product_Name);
				driver.findElement(By.xpath(xp)).click();
				
				System.out.println("Product Name is = "+Product_Name+"\nthe Price for the same product is = "+Price.getText());
				
				
			}
			
		}
		Add_to_cart.click();
	}
}
	

