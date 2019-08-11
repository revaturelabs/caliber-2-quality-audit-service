package com.revature.endtoend;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CreateNewCategory {
	@Test
	  public void CategoryTest() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
      String OS = System.getProperty("os.name");
		if (OS.startsWith("Windows")) {
			System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
		}else if(OS.startsWith("Mac"))
			System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver");
		else {
			System.setProperty("webdriver.chrome.driver","src/test/drivers/chromedriverLinux");
		}
		ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
		WebDriver driver = new ChromeDriver(options);
		String baseUrl = "http://localhost:4200/caliber/";
		
		String actualTitle = "";
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);
		    
		    
		    //TimeUnit.MILLISECONDS.sleep(600);
		    driver.findElement(By.id("quality-link")).click();
		    //TimeUnit.SECONDS.sleep(4);
		    driver.findElement(By.cssSelector(".fa-plus")).click();
		    //TimeUnit.SECONDS.sleep(1);
		    driver.findElement(By.linkText("ALM")).click();
		    
		    driver.findElement(By.cssSelector(".fa-plus")).click();
		    //TimeUnit.SECONDS.sleep(1);
		   
		    driver.findElement(By.linkText("JUnit")).click();
		
		    assertTrue(driver.findElement(By.xpath("//span[contains(.,\'JUnit ×\')]")).isDisplayed());
		    //assertTrue(driver.findElement(By.xpath("//span[contains(.,\'ASP.NET �\')]")).isDisplayed());
			 
	
	}
}
