package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	
	public void maximizewindow (WebDriver driver) {
		driver.manage().window().maximize();
		}
	
	public void minimizewindow(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	public void fullscreenwindow(WebDriver driver) {
		driver.manage().window().fullscreen();
		}
	
	public void waitwebelementtoload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handledropdown1(WebElement target, String text) {
		Select s = new Select(target);
		s.selectByVisibleText(text);
		
	}
	public void handledropdown(WebElement target, int index ) {
		Select s = new Select(target);
		s.selectByIndex(index);
		
	}
	public void handledropdown(WebElement target, String value) {
		Select s = new Select(target);
		s.selectByValue(value);
		
	}
	public void mousehover (WebDriver driver, WebElement target) {
		Actions a = new Actions (driver);
		a.moveToElement(target);
		a.perform();
	}
	public void rightclick (WebDriver driver, WebElement target) {
		Actions a = new Actions (driver);
		a.contextClick(target);
		a.perform();
	}
	public void doubleclick (WebDriver driver, WebElement target) {
		Actions a = new Actions (driver);
		a.doubleClick(target);
		a.perform();
	}
	public void click (WebDriver driver, WebElement target) {
		Actions a = new Actions (driver);
		a.click(target);
		a.perform();
	}
	
	public void Switch(WebDriver driver, String expectedurl) {
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		for(String e : ids) {
			String actaulurl = driver.switchTo().window(e).getCurrentUrl();
			System.out.println(actaulurl);
			
			
			if(actaulurl.contains(expectedurl)) {
				break;
			}
		}
		
	
	
	}
	
	public String screenshot(WebDriver driver, String Screenshotname) throws IOException {
		
		LocalDateTime ldt = LocalDateTime.now();
		String timestamp =ldt.toString().replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot)driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("./screenshot/"+Screenshotname+".png");
		FileUtils.copyFile(tempfile, destinationfile);
		return destinationfile.getAbsolutePath();
	}
	
	//Methods to handle the pop up's/
	
	public void okpopup (WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	
	public void cancelpopup (WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	public void textpopup (WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	
	public void valuepopup (WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	
	public void frames (WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	
	public void frames (WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
	
	
	public void frames (WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void pageload (WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	public void waitWebElementtodisplay(WebDriver driver, String Expetedurl) {
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(10));
		waits.until(ExpectedConditions.urlToBe(Expetedurl));
	}

}
