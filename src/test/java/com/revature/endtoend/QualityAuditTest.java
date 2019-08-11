package com.revature.endtoend;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QualityAuditTest {
	public static WebDriver driver;
	 //public final String URL = "http://localhost:4200/caliber/vp/audit";
	public final String URL = System.getenv("CALIBER_BASE_URL") + "/caliber/vp/audit";

	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
	    chromeOptions.addArguments("--start-maximized");

	    
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get(URL);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void confirmQualityAuditPage() {
		QualityAuditPOM qualityAuditPOM = new QualityAuditPOM(driver);
		assertEquals(driver.getTitle(), qualityAuditPOM.title);
	}
	
	@Test(dependsOnMethods = "confirmQualityAuditPage", priority = 7)
	public void testOverallComments(){
		
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
	
	@Test(dependsOnMethods = "confirmQualityAuditPage", priority = 2)
	public void testFlagButton() {// this test the functionality of pressing the pencil button for a modal window to pop up
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

	@Test(dependsOnMethods = "testFlagButton", priority = 3)
	public void testGreenBtn() { //tests to see if after click the green flag does the delete,submit,little flag appear
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

	@Test(priority = 3)
	public void testRedBtn(){
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

	@Test(priority = 4)
	public void testWriteIndividualComments() {
		QualityAuditPOM qualityAuditPOM = new QualityAuditPOM(driver);

		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));

		// if the comments are not saved this becomes false and the test fails
		boolean individualCommentsSaved = true;

		// iterate through list of textareas and add a comment
		List<WebElement> individualComments = driver.findElements(By.tagName("textarea"));

		// if there are no individual elements make the test false
		if (individualComments.size() <= 1) {
			individualCommentsSaved = false;
		}

		for (int i = 0; i < individualComments.size() - 1; i++) {
			individualComments.get(i).clear();
			individualComments.get(i).sendKeys("Comment " + i);
		}

		individualComments.get(individualComments.size() - 1).click();

		// refresh page to verify data is stored
		driver.navigate().refresh();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea")));

		// iterate through comments and compare value to expected value
		individualComments = driver.findElements(By.tagName("textarea"));
		for (int i = 0; i < individualComments.size() - 1; i++) {
			String currentComment = individualComments.get(i).getAttribute("value");
			String expectedComment = "Comment " + i;

			if (!currentComment.equals(expectedComment)) {
				// the comment is not equal to the expected value so fail the test
				individualCommentsSaved = false;
			}
		}

		assertEquals(true, individualCommentsSaved);
	}

	@Test(priority = 5)
	public void testSortRandomly() {
		QualityAuditPOM qualityAuditPOM = new QualityAuditPOM(driver);

		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggleNoteSort")));

		// if a difference is found this becomes true and test succeeds
		boolean differenceFound = false;

		// test 3 times in case of extremely unlucky chance that random order is also
		// alphabetical order.
		for (int i = 0; i < 3; i++) {
			// keep looking if a difference is not found yet
			if (differenceFound == false) {
				// get list of sorted names
				List<WebElement> sortedNameElements = driver.findElements(By.className("dropup"));
				qualityAuditPOM.pressSortButton();
				// get list of random names
				List<WebElement> randomNameElements = driver.findElements(By.className("dropup"));
				qualityAuditPOM.pressSortButton();

				// find any differences between the two lists of names
				for (int j = 0; j < sortedNameElements.size(); j++) {
					// if the names are different assertNotEquals
					if (!sortedNameElements.get(j).getText().equals(randomNameElements.get(j).getText())) {
						assertNotEquals(sortedNameElements.get(j).getText(), randomNameElements.get(j).getText());
						differenceFound = true;
					}
				}
			}
		}
		assertEquals(true, differenceFound);
	}

	@Test(dependsOnMethods = "testSortRandomly", priority = 6)
	public void testSortAlphabetically() {
		QualityAuditPOM qualityAuditPOM = new QualityAuditPOM(driver);

		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toggleNoteSort")));

		// if the list is in order this becomes false and the test fails
		boolean inOrder = true;

		// grab all the sorted names
		List<WebElement> sortedNameElements = driver.findElements(By.className("dropup"));
		// iterate through names and compare to the next name
		for (int i = 0; i < sortedNameElements.size() - 1; i++) {
			if (sortedNameElements.get(i).getText().compareTo(sortedNameElements.get(i + 1).getText()) < 0) {
//				System.out.println(sortedNameElements.get(i).getText());
//				System.out.println(sortedNameElements.get(i+1).getText());
			} else {
//				System.out.println("failed");
//				System.out.println(sortedNameElements.get(i).getText());
//				System.out.println(sortedNameElements.get(i+1).getText());
				inOrder = false;
			}
		}
		assertEquals(true, inOrder);
	}
	@Test(priority=7)
	  public void CategoryTest() throws InterruptedException {
	
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
