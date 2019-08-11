package com.revature.endtoend;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QAFeedback {
	protected WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\doaak\\Desktop\\Project3\\caliber-2-meta\\assessment-service\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void frownFeedback() throws InterruptedException {
		String className = "fa-frown-o";
		driver.get("http://localhost:4200/caliber/vp/audit");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.className("qcStatusIcon"));
		action.moveToElement(target).perform();
		System.out.println("Mouse Over");
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
		WebElement selectMenuOption = driver.findElement(By.className(className));

		selectMenuOption.click();
		System.out.println("Selected 'Frown' from Menu");

		assertEquals(driver.findElement(By.className(className)).getAttribute("class").split(" ")[2], className);
		driver.close();
	}

	@Test
	public void mehFeedback() throws InterruptedException {
		String className = "fa-meh-o";
		driver.get("http://localhost:4200/caliber/vp/audit");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.className("qcStatusIcon"));
		action.moveToElement(target).perform();
		System.out.println("Mouse Over");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
		WebElement selectMenuOption = driver.findElement(By.className(className));

		selectMenuOption.click();
		System.out.println("Selected 'Meh' from Menu");

		assertEquals(driver.findElement(By.className(className)).getAttribute("class").split(" ")[2], className);
		driver.close();
	}

	@Test (enabled=false)
	public void smileFeedback() throws InterruptedException {
		String className = "fa-smile-o";
		driver.get("http://localhost:4200/caliber/vp/audit");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.className("qcStatusIcon"));
		action.moveToElement(target).perform();
		System.out.println("Mouse Over");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
		WebElement selectMenuOption = driver.findElement(By.className(className));

		selectMenuOption.click();
		System.out.println("Selected 'Good' from Menu");

		assertEquals(driver.findElement(By.className(className)).getAttribute("class").split(" ")[2], className);
		driver.close();
	}

	@Test (enabled=false)
	public void questionFeedback() throws InterruptedException {
		String className = "fa-question-circle";
		driver.get("http://localhost:4200/caliber/vp/audit");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.className("qcStatusIcon"));
		action.moveToElement(target).perform();
		System.out.println("Mouse Over");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
		WebElement selectMenuOption = driver.findElement(By.className(className));

		selectMenuOption.click();
		System.out.println("Selected 'Question' from Menu");

		assertEquals(driver.findElement(By.className(className)).getAttribute("class").split(" ")[2], className);
		driver.close();
	}
	

	@Test(enabled=false)
	public void starFeedback() throws InterruptedException {
		String className = "fa-star";
		driver.get("http://localhost:4200/caliber/vp/audit");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(By.className("qcStatusIcon"));
		action.moveToElement(target).perform();
		System.out.println("Mouse Over");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
		WebElement selectMenuOption = driver.findElement(By.className(className));

		selectMenuOption.click();
		System.out.println("Selected 'Star' from Menu");

		assertEquals(driver.findElement(By.className(className)).getAttribute("class").split(" ")[2], className);
		driver.close();
	}


}
