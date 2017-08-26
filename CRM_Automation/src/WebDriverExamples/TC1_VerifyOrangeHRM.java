package WebDriverExamples;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class TC1_VerifyOrangeHRM 
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//Maximize browser
		Driver.manage().window().maximize();
		//---------------------------------------------------------
		//Open HRM application
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		Thread.sleep(3000);
		//Verify home page
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home Page displayed");
		}
		else
		{
			System.out.println("Failed to open home page");
			return;
		}
		//-----------------------------------------------------------------
		//Create web elements for User name,password,login and clear
		WebElement objUserName=Driver.findElement(By.name("txtUserName"));
		WebElement objPassword=Driver.findElement(By.name("txtPassword"));		
		WebElement objLogin=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		//---------------------------------------------------------------------
		//Verify user name
		if(objUserName.isDisplayed())
		{
			System.out.println("User name displayed");
		}
		//Verify password
		if(objPassword.isDisplayed())
		{
			System.out.println("Password displayed");
		}
		//Verify login and clear
		if(objLogin.isDisplayed() && objClear.isDisplayed())
		{
			System.out.println("Login and clear buttons are displayed");
		}
		//--------------------------------------------------------------------
		String strUserName="qaplanet1";
		String strPassword="user1";
		//----------------------------------------------------------------
		//Login to orangeHRM
		//--------------------------------------------------------------
		objUserName.clear();
		objUserName.sendKeys(strUserName);
		objPassword.clear();
		objPassword.sendKeys(strPassword);
		objLogin.click();
		Thread.sleep(3000);
		//----------------------------------------------------------------
		//Verify OrangeHRM
		if(Driver.getTitle().equals("OrangeHRM"))
		{
			System.out.println("OrangeHRM page displayed");
		}
		else
		{
			System.out.println("Failed to login");
			return;
		}
		//Get welcome text
		String sWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		//Verify welcome text
		if(sWelText.equals("Welcome "+strUserName))
		{
			System.out.println("Welcome "+strUserName+" displayed");
		}
		//Create webelements for Change Password & logout
		WebElement objCP=Driver.findElement(By.linkText("Change Password"));
		WebElement objLogout=Driver.findElement(By.linkText("Logout"));
		if(objCP.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("Change Password & logout displayed");
		}
		//--------------------------------------------------------------
		//Click on logout
		objLogout.click();
		Thread.sleep(3000);
		//Verify home page
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Signoff sucessfull & Home Page displayed");
		}
		else
		{
			System.out.println("Failed to Signoff");
			return;
		}
		//----------------------------------------------------------------
		Driver.close();
		Driver.quit();
	}
}
