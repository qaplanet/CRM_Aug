package WebDriverExamples;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TC2_Addemployee 
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//Maximize browser
		Driver.manage().window().maximize();
		//wait object
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//Create object for actions class
		Actions Act=new Actions(Driver);
		//---------------------------------------------------------
		//Open HRM application
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		//Verify home page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
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
		WebElement objUserName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
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
		//----------------------------------------------------------------
		//Verify OrangeHRM
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
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
		//Verify user name
		String[] Arr=sWelText.split(" ");
		if(Arr[1].equals(strUserName))
		{
			System.out.println(strUserName+" displayed");
		}
		//Create webelements for Change Password & logout
		WebElement objCP=Driver.findElement(By.linkText("Change Password"));
		WebElement objLogout=Driver.findElement(By.linkText("Logout"));
		if(objCP.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("Change Password & logout displayed");
		}
		//-------------------------------------------------------------------
		//Create PIM object
		WebElement objPIM=Driver.findElement(By.id("pim"));
		//Mouse over on PIM
		Act.moveToElement(objPIM).perform();
		//click on add employee
		Driver.findElement(By.linkText("Add Employee")).click();
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		//Verify PIM : Add Employee
		if(Driver.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText().equals("PIM : Add Employee"))
		{
			System.out.println("PIM : Add Employee displayed");
		}
		//Get employee id
		String sEmpCode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
		//--------------------------------------------------------
		String sFN="Sreedhar";
		String sLN="M";
		//---------------------------------------------------------------
		//Create webelement for save 
		WebElement objSave=Driver.findElement(By.id("btnEdit"));
		//Click on save
		objSave.click();
		//wait for alert
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		//Verify alert
		if(A.getText().equals("Last Name Empty!"))
		{
			System.out.println("Last Name Empty! displayed");
			A.accept();
		}
		//Enter last name
		Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		//Click on save
		objSave.click();
		//wait for alert
		Alert A1=wait.until(ExpectedConditions.alertIsPresent());
		//Verify alert
		if(A1.getText().equals("First Name Empty!"))
		{
			System.out.println("First Name Empty! displayed");
			A1.accept();
		}	
		//Enter First Name 
		Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
		//Click on save
		objSave.click();
		//wait for Personal Details
		boolean res=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details"));
		if(res)
		{
			System.out.println("Personal Details displayed");
		}
		//Switch to parent frame
		Driver.switchTo().parentFrame();
		//---------------------------------------------------------------
		//Mouse over on PIM
		Act.moveToElement(objPIM).perform();
		//click on Employee List
		Driver.findElement(By.linkText("Employee List")).click();
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
		//Verify Employee Information
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		{
			System.out.println("Employee Information displayed");
		}		
		//Get row count
		int rc=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		int i;
		for(i=1;i<=rc;i++)
		{
			//Get Emp ID from second column
			String EmpID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			//Get Emp Name from third column
			String EmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if(sEmpCode.equals(EmpID) && EmpName.equals(sFN+" "+sLN))
			{
				System.out.println(EmpID+","+EmpName+" displayed at: "+i);
				break;
			}
		}
		//go to top frame
		Driver.switchTo().defaultContent();
		//--------------------------------------------------------------
		//Click on logout
		objLogout.click();
		//Verify home page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
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
