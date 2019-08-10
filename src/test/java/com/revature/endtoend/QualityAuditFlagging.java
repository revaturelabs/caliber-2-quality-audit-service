package com.revature.endtoend;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QualityAuditFlagging
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
	
	@Test(dependsOnMethods = "checkingPage")
	public void testFlagButton()// this test the functionality of pressing the pencil button for a modal window to pop up
	{
		WebDriverWait wait = new WebDriverWait(driver, 7);
		List<WebElement> btnPencilList = driver.findElements(By.className("fa-pen"));
		List<WebElement> noteRoleList = driver.findElements(By.className("NoteRow"));
		Actions action = new Actions(driver);
		action.moveToElement(noteRoleList.get(1)).perform();
		action.click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(btnPencilList.get(0)));
		btnPencilList.get(0).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flagTrainee")));
		assertTrue(driver.findElement(By.id("flagTrainee")).isDisplayed());
	}
	
	@Test(dependsOnMethods = "testFlagButton")
	public void testGreenBtn() //tests to see if after click the green flag does the delete,submit,little flag appear
	{
		WebDriverWait wait = new WebDriverWait(driver, 7);
		WebElement greenFlag = driver.findElement(By.xpath("//*[@id='greenFlag']"));
		greenFlag.click();
		WebElement littleSymbol = driver.findElement(By.xpath("//*[@id='flagTrainee']/div/div/div[1]/div[2]/div/em"));
		WebElement btnDelete = driver.findElement(By.xpath("//*[@id='flagTrainee']/div/div/div[2]/button[1]"));
		WebElement btnSubmit = driver.findElement(By.xpath("//*[@id='flagTrainee']/div/div/div[2]/button[2]"));
		assertTrue(btnDelete.isDisplayed());
		assertTrue(btnSubmit.isDisplayed());
		assertTrue(littleSymbol.isDisplayed());
		assertTrue(littleSymbol.getAttribute("class").equals("fas fa-flag fa-1x fa-green")); //if green flag is clicked little symbol should be green
		WebElement comment = driver.findElement(By.xpath("//*[@id='comment']"));
		comment.clear();
		comment.sendKeys("Hello World");
		greenFlag.click();
		btnSubmit.click();
		WebElement cornerFlag = driver.findElement(By.xpath("//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[1]/div/div[1]"));
		assertTrue(cornerFlag.getAttribute("class").equals("flag-note-area-green dropbtn"));//checks when green flag is clicked then a green corner tag appears
		Actions action = new Actions(driver);
		action.moveToElement(cornerFlag).perform();
		action.build().perform();
		WebElement flagComment = driver.findElement(By.xpath("//*[@id=\'noTrainees\']/app-associate/div/table/tbody/tr[2]/td[1]/div/div[2]/ul/li"));
		wait.until(ExpectedConditions.visibilityOf(flagComment));
		assertTrue(flagComment.isDisplayed());
		assertTrue(flagComment.getText().equals("Hello World"));
	}
	
	@Test
	public void testRedBtn()
	{

		WebDriverWait wait = new WebDriverWait(driver, 7);
		List<WebElement> btnPencilList = driver.findElements(By.className("fa-pen"));
		List<WebElement> noteRoleList = driver.findElements(By.className("NoteRow"));
		Actions action = new Actions(driver);
		action.moveToElement(noteRoleList.get(1)).perform();
		action.click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(btnPencilList.get(0)));
		btnPencilList.get(0).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flagTrainee")));
		assertTrue(driver.findElement(By.id("flagTrainee")).isDisplayed());
		
		WebElement redFlag = driver.findElement(By.xpath("//*[@id=\'redFlag\']"));
		WebElement littleSymbol = driver.findElement(By.xpath("//*[@id='flagTrainee']/div/div/div[1]/div[2]/div/em"));
		redFlag.click();
		WebElement comment = driver.findElement(By.xpath("//*[@id='comment']"));
		comment.clear();
		comment.sendKeys("last Test");
		redFlag.click();
		WebElement btnSubmit = driver.findElement(By.xpath("//*[@id='flagTrainee']/div/div/div[2]/button[2]"));
		btnSubmit.click();
		
		WebElement cornerFlag = driver.findElement(By.xpath("//*[@id=\"noTrainees\"]/app-associate/div/table/tbody/tr[2]/td[1]/div/div[1]"));
		assertTrue(cornerFlag.getAttribute("class").equals("flag-note-area-red dropbtn"));//checks when red flag is clicked then a red corner tag appears
		action = new Actions(driver);
		action.moveToElement(cornerFlag).perform();
		action.build().perform();
		WebElement flagComment = driver.findElement(By.xpath("//*[@id=\'noTrainees\']/app-associate/div/table/tbody/tr[2]/td[1]/div/div[2]/ul/li"));
		wait.until(ExpectedConditions.visibilityOf(flagComment));
		assertTrue(flagComment.isDisplayed());
		assertTrue(flagComment.getText().equals("last Test"));
		

	}
}
