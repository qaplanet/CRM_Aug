package WebDriverExamples;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
public class EX1
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "F:\\D-Drive\\FromC\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		//-------------------------------------------------
		//Open application
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		Thread.sleep(2000);
		//------------------------------------------------
		//Enter user name
		Driver.findElement(By.name("txtUserName")).clear();
		Driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		//Enter password
		Driver.findElement(By.name("txtPassword")).clear();
		Driver.findElement(By.name("txtPassword")).sendKeys("user1");
		//click on login
		Driver.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		//Click on logout
		Driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		//------------------------------------------------------------
		Driver.close();
		Driver.quit();
	}
}
