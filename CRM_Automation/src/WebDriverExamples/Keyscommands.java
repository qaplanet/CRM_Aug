package WebDriverExamples;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class Keyscommands
{
	public static void main(String[] args)
	{
		FirefoxDriver Driver=new FirefoxDriver();		
		Actions Act=new Actions(Driver);
		//------------------------------------------------
		//To click
		Act.click(Driver.findElement(By.id("id"))).perform();
		//-----------------------------------------------------
		WebElement E=Driver.findElement(By.id("id"));
		//-------------------------------------------------------
		//To click
		Act.click(E).perform();
		//To double click
		Act.doubleClick(E).perform();
		//to perform right click
		Act.contextClick(E).perform();
		//----------------------------------------------------------
		WebElement src=Driver.findElement(By.id("id"));
		WebElement Des=Driver.findElement(By.id("id"));
		//-------------------------------------------------
		//Click and hold
		Act.clickAndHold(src).perform();
		//Mouse over
		Act.moveToElement(Des).perform();
		//Release mouse
		Act.release(Des).perform();
		//---------------------------------------------
		//Drag and drop
		Act.dragAndDrop(src, Des).perform();
		//-------------------------------------------------
		//How to perform keyborad actions
		Act.sendKeys(Keys.ARROW_DOWN).perform();
		Act.sendKeys(Keys.ENTER).perform();
	}
}
