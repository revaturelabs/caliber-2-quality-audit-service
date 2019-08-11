package com.revature.endtoend;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 * Navigation from Quality Audit to Assess Batch
 */

public class NavigationQtoA {
protected WebDriver driver; 
	
	@Test
	public void qualityAudit() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\doaak\\Desktop\\Project3\\caliber-2-meta\\quality-audit-service\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		String url = "http://localhost:4200/caliber/vp/audit";
		String url1 = "";
		driver.get("http://localhost:4200/caliber/vp/audit");

		url1 = driver.getCurrentUrl();

		if (url1.equals(url)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

	}        
	
	@Test
	public void qualityAuditNav() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\doaak\\Desktop\\Project3\\caliber-2-meta\\quality-audit-service\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/caliber/vp/audit");
		String url = "http://localhost:4200/caliber/vp/audit";
		String url1 = "";
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("assess-link")).click();
		assertEquals(driver.getCurrentUrl(), url);

		if (url1.equals(url)) {
			System.out.println("Failed");
		} else {
			System.out.println("Right");
		}
	}


}
