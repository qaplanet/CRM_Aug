package WebDriverExamples;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownCommands
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://classroom:90/webapp/SelectAWebSite.html");
		Thread.sleep(2000);
		//----------------------------------------------
		//Create webelement
		WebElement E=Driver.findElement(By.name("OptWeb"));
		//------------------------------------------------
		//Create select object
		Select obj=new Select(E);
		//--------------------------------------------------
		//Get all options
		List<WebElement> Ops=obj.getOptions();
		
		//Print all values from drop down using : Iterator object
		Iterator<WebElement> ITR=Ops.iterator();
		while (ITR.hasNext())
		{
			WebElement webElement = ITR.next();
			System.out.println(webElement.getText());
		}
		//Way 2:Print all values from drop down using for each
		for(WebElement E1 : Ops)
		{
			System.out.println(E1.getText());
		}
		//-----------------------------------------------------
		Driver.close();
		Driver.quit();
	}
}
