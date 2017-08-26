package WebDriverExamples;
import org.openqa.selenium.firefox.FirefoxDriver;
public class WorkingWithFireFoxDriver
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "F:\\D-Drive\\FromC\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
	}
}
