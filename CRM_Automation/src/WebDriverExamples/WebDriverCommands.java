package WebDriverExamples;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCommands
{
	public static void main(String[] args)
	{
		//Create object and it will launch a browser
		FirefoxDriver Driver=new FirefoxDriver();
		//Navigate commands
		//----------------------------------------------
		//To open web page
		Driver.navigate().to("URL");
		//To go previous page
		Driver.navigate().back();
		//To go to next page
		Driver.navigate().forward();
		//TO refresh web page
		Driver.navigate().refresh();
		//----------------------------------------------
		//TO get current browsers handle / id
		String handle=Driver.getWindowHandle();
		//TO get all opened browsers handles
		Set<String> HNDS=Driver.getWindowHandles();
		//Switch to next browser
		Driver.switchTo().window(handle);
		//-----------------------------------------------------  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//***************************************************************
		//To find multiple elements
		Driver.findElements(By.className("className"));
		//------------------------------------------------------------------
		//To get button count
		int BC=Driver.findElements(By.className("button")).size();
		//To get links count
		int LC=Driver.findElements(By.tagName("a")).size();
		//--------------------------------------------------------------
		//To get row count
		int rc=Driver.findElements(By.xpath("//table/tbody/tr")).size();
		//To get column count
		int colc=Driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
		//To get cell count
		int cellc=Driver.findElements(By.xpath("//table/tbody/tr/td")).size();
		//------------------------------------------------------------------
	}
}
