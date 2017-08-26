package WebDriverExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitCommands 
{
	public static void main(String[] args)
	{
		FirefoxDriver Driver=new FirefoxDriver();
		//Explicit wait object
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//-----------------------------------------------------------
		//wait for title
		wait.until(ExpectedConditions.titleIs("title"));
		//wait for partial title
		wait.until(ExpectedConditions.titleContains("title"));
		//wait for alerts
		wait.until(ExpectedConditions.alertIsPresent());
		//wait for element present
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
		//wait until text displayed
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("xpath"), "text"));
		//wait for property value
		wait.until(ExpectedConditions.attributeToBe(By.name("name"), "attribute", "value"));
		//wait for element to be clickable 
		wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("locator"));
		//--------------------------------------------------------------
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		Driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	}
}
