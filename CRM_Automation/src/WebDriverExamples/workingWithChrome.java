package WebDriverExamples;

import org.openqa.selenium.chrome.ChromeDriver;

public class workingWithChrome {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
	}
}
