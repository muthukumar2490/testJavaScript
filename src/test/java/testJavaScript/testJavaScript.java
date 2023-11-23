package testJavaScript;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testJavaScript {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		WebElement sbox = driver.findElement(By.name("q"));

//		js.executeScript("window.scrollBy(0,600)", "");
//		js.executeScript("window.scroolBy(0,document.body.scrollHeight)", "");

//		1) Example: Click a button to login and generate Alert window using JavaScriptExecutor.
		WebElement gmail = driver.findElement(By.xpath("//*[contains(text(),'Gmail')]"));
		js.executeScript("arguments[0].click();", gmail);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.urlToBe("https://www.google.com/gmail/about/"));
//		2. generate alert
//		js.executeScript("alert('hello js');") 
		
//		3. Example: Capture Scrape Data and Navigate to different pages using JavaScriptExecutor.
		
		
//		4. Fetch the details of the site like URL of the site, 
		String url = js.executeScript("return document.URL;").toString();
		System.out.println(url);
//		5. title name and 
		String title = 	js.executeScript("return document.title;").toString();
		System.out.println(title);
//		6. domain name of the site.
		String domain = js.executeScript("return document.domain;").toString();
		System.out.println(domain);
//		7. Then navigate to a different page.
		js.executeScript("window.location = 'https://www.facebook.com';");
//		8. Vertical scroll down by 600  pixels
		js.executeScript("window.scrollBy(0,600)","");
//		9. scroll to bottom of the page 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		
		
		Thread.sleep(2000);
		
		
		TakesScreenshot ts = ( TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File desfile = new File("C:\\Users\\KANNA\\eclipse-workspace\\testJavaScript\\screenshot\\"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(srcfile, desfile);
				
		driver.quit();

	}

}
