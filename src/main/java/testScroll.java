import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testScroll {
	@Test
	public void f() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		WebElement box = driver.findElement(By.name("q"));
		box.sendKeys("selenium java tutorial");
		Thread.sleep(2000);
		box.submit();
		driver.findElement(By.xpath("//*[@class='VuuXrf' and contains(text(),'Guru99')]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);

		// bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		// top of the page
		js.executeScript("window.scrollBy(0,-(document.body.scrollHeight))");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(document.body.scrollWidth,0)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(-(document.body.scrollWidth),0)");
		Thread.sleep(2000);
		// scrollintoview

//	  WebElement email = driver.findElement(By.xpath("//*[@class='text' and @name='email' and @value = 'you@email.com']"));
//	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
//		
//	  wait.until(ExpectedConditions.elementToBeClickable(email));
//	  
//	  
//	 js.executeScript( "arguments[0].scrollIntoView();",email);
//	  Thread.sleep(2000);
//	  
		driver.quit();

	}
}
