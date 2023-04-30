package SelectionFor_theBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Selection {

	public static WebDriver driver ;
	public static WebDriver Select(String Select_Browser, String url)
	{
		if(Select_Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}else if(Select_Browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
		
	}
}
