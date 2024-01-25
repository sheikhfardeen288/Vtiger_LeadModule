package Module;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtils;
import CommonUtils.PropertyFileUtils;
import CommonUtils.WebDriverUtils;



public class LeadModule extends BaseClass {

		
		PropertyFileUtils putils = new PropertyFileUtils();
		ExcelUtils eutils = new ExcelUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		
		@Test
		public void CreateLead() throws InterruptedException, IOException {
			//To read data from Excel

		
		//To read data from Excel
//		String FIRSTNAME = eutils.getdatafromExcel("Lead", 0, 1);
//		String LASTNAME = eutils.getdatafromExcel("Lead", 1, 1);
//		String COMPANY = eutils.getdatafromExcel("Lead", 2, 1);
//		String GROUP = eutils.getdatafromExcel("Lead", 3, 1);
//		
		
		//To Launch browser 	
		
				
			//Step6:Login to application
	
				
				driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
				
				driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
				
				driver.findElement(By.name("firstname")).sendKeys("Fardeen");
				
				
				driver.findElement(By.name("lastname")).sendKeys("Sheikh");
				driver.findElement(By.name("company")).sendKeys("FS_Associate");
				
				driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
				
				WebElement Groupdropdown = driver.findElement(By.name("assigned_group_id"));
				Select s = new Select (Groupdropdown);
				s.selectByVisibleText("Support Group");
				
				
				
				driver.findElement(By.name("button")).click();
				
			
				
				
				
				
	}

}
