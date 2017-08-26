package WebDriverExamples;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithWebTable 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		Driver.get("http://classroom:90/webapp/AssertXPath.html");
		//---------------------------------------------------------------
		//Verify home page
		if(wait.until(ExpectedConditions.titleIs("AssertXPath")))
		{
			System.out.println("hom epage displayed");
		}
		//--------------------------------------------------------
		//Get row count
		int rc=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr")).size();
		System.out.println(rc);
		//Get column count
		int colc=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr[1]/td")).size();
		System.out.println(colc);
		//Get cell count
		int cc=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr/td")).size();
		System.out.println(cc);
		//---------------------------------------------------
		//Get cell data
		//-----------------------------------------------------
		for(int i=1;i<=rc;i++)
		{
			for(int j=1;j<=colc;j++)
			{
				//Get cell data
				String cellData=Driver.findElement(By.xpath("//table[@id='idCourse']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(cellData);
			}
		}
		System.out.println("**********************************************************");
		//------------------------------------------------------------------------------
		List<WebElement> TDS=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr/td"));
		//Print cell data by using iterator
		Iterator<WebElement> ITR=TDS.iterator();
		while (ITR.hasNext()) {
			WebElement TD =ITR.next();
			System.out.println(TD.getText());			
		}
		//Print cell data by using for each
		for(WebElement TD : TDS)
		{
			System.out.println(TD.getText());
		}
		Driver.close();
		Driver.quit();
	}
}
