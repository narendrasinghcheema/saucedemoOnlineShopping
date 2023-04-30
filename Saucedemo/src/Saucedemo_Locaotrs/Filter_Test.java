package Saucedemo_Locaotrs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Filter_Test {

	String Filter_Value = "";
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement Product_filter;
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement pries;
	

	
	public Filter_Test(WebDriver IDriver77)
	{
		this.driver = IDriver77;
	}

//==================================================================
	static ArrayList<String> pricesList = new ArrayList<>();
//==================================================================	
	static List<Double> PriceListIn_double = new ArrayList<>();
//==================================================================
	static ArrayList<String> capture = new ArrayList<>();
//==================================================================
	
	public void filter_Test(String textfor_Filter)
	{
		Select select = new Select(Product_filter);
		
		select.selectByVisibleText(textfor_Filter);
		
		for(WebElement ele : driver.findElements(By.xpath("//div[@class='inventory_item_price']")))
		{
			pricesList.add(ele.getText());
		}
		System.out.println("List of pirce are = "+pricesList);
		
		this.Filter_Value = textfor_Filter;
		
		
	}
	
	public void verifying_given_Filter_Is_givin_correct_result()
	{
		if(Filter_Value.equals("Price (high to low)") || Filter_Value.equals("Price (low to high)"))
		{
			boolean isIncreasing_order = true;
			boolean isDecreasing_Order = true;
			
		
			for(String ele1 : pricesList)
			{
				PriceListIn_double.add(Double.parseDouble(ele1.substring(1)));
			}
			System.out.println("values == "+PriceListIn_double);
			for(int i=0; i< PriceListIn_double.size()-1; i++)
			{
				if(PriceListIn_double.get(i) > PriceListIn_double.get(i+1))
				{
					isIncreasing_order = false;
				}
				if(PriceListIn_double.get(i) < PriceListIn_double.get(i+1))
				{
					isDecreasing_Order = false;
				}
			}
			
			if(isIncreasing_order)
			{
				System.out.println("yes the filter apply low to hight");
			}else if(isDecreasing_Order)
			{
				System.out.println("yes te filter apply is hight to low");
			}
		}
		if(Filter_Value.equals("Name (Z to A)") || (Filter_Value.equals("Name (A to Z)")))
		{
			
			
			for(WebElement ele : driver.findElements(By.xpath("//div[@class='inventory_item_name']")))
			{
				capture.add(ele.getText());
			}
			
			boolean atoz = true;
			boolean ztoa = true;
			
			for(int i=0;i<capture.size()-1;i++)
			{
				if(capture.get(i).compareTo(capture.get(i+1)) < 0)
				{
					ztoa = false;
					break;
				}
				if(capture.get(i).compareTo(capture.get(i+1)) > 0)
				{
					atoz = false;
					break;
				}
			}
			
			if(atoz)
			{
				System.out.println("the filter apply is A to Z");
			}else if(ztoa)
			{
				System.out.println("the filter apply is Z to A");
			}
		}
		
		

	}
	
	
	
}
