package com.revature.endtoend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class QualityAuditPOM {
	
	public String title = "Caliber | Performance Management";
	
	@FindBy(how = How.ID, using = "toggleNoteSort")
	public WebElement sortButton;
	

	public QualityAuditPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void pressSortButton() {
		this.sortButton.click();
	}
}
