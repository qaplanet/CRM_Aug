package WebDriverExamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithAlerts {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//------------------------------------------------------
		//open web site
		Driver.get("http://classroom:90/webapp/AgeProb.html");
		//wait for home page
		boolean resTitle=wait.until(ExpectedConditions.titleIs("Age Problem"));
		if(resTitle)
		{
			System.out.println("Age Problem page displayed");
		}
		//Enter age
		Driver.findElement(By.id("idAge")).sendKeys("10");
		//Click on submit
		Driver.findElement(By.id("idSubGo")).click();
		//wait for alert
		wait.until(ExpectedConditions.alertIsPresent());
		//Switch to alert
		Alert A=Driver.switchTo().alert();
		//Verify Kid
		if(A.getText().equals("Kid"))
		{
			System.out.println("Kid displayed");
			A.accept();
		}
		Driver.close();
		Driver.quit();
	}
}
