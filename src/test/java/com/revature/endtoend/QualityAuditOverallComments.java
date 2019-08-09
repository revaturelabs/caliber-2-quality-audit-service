package com.revature.endtoend;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.h2.server.web.WebServer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QualityAuditOverallComments
{

	public static WebDriver driver;
	public final String URL = "http://localhost:4200/caliber/vp/audit";

	@BeforeClass
	public void setup() 
	{
		
		System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void checkingPage()//Checks if on correct page. This test should run first
	{
		QualityAuditPOM qualityAuditPOM = new QualityAuditPOM(driver);
		String expectedTitle = qualityAuditPOM.title;
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(dependsOnMethods = { "checkingPage"})
	public void testOverallComments()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 7);
		List<WebElement> overallCommentList = driver.findElements(By.tagName("textarea"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(overallCommentList.get(overallCommentList.size()-1).getTagName())));
		
		String placeHolder = overallCommentList.get(overallCommentList.size()-1).getAttribute("value");
		
		overallCommentList.get(overallCommentList.size()-1).clear();
		overallCommentList.get(overallCommentList.size()-1).sendKeys("Hello");
		
		List <WebElement> overallTitleElement = driver.findElements(By.tagName("a"));
		overallTitleElement.get(0).click();
		
		driver.navigate().refresh();
		overallCommentList = driver.findElements(By.tagName("textarea"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(overallCommentList.get(overallCommentList.size()-1).getTagName())));
		
		assertTrue("Hello".equals(overallCommentList.get(overallCommentList.size()-1).getAttribute("value")));
		
		overallCommentList.get(overallCommentList.size()-1).clear();
		overallCommentList.get(overallCommentList.size()-1).sendKeys(placeHolder);
		overallTitleElement = driver.findElements(By.tagName("a"));
		overallTitleElement.get(0).click();
	}	
}
