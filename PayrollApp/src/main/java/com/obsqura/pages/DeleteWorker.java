package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteWorker {
	public WebDriver driver;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr[1]/td[8]/a[3]/span")
	WebElement deleteicon;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr/td")
	List<WebElement> rows;

	public DeleteWorker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterdeleteWorker(String workerName) {

		int rowCount = rows.size();
		for (int i = 1; i <= rowCount; i++) {
			String sValue = null;
			sValue = driver.findElement(By.xpath("//*[@id=\"w1\"]/table/tbody/tr[" + i + "]/td[2]")).getText();
			if (sValue.equalsIgnoreCase(workerName)) {
				deleteicon.click();
				driver.switchTo().alert().accept();
				break;

			}

		}
	}

	public void deleteWorkeraction(String worker) {
		this.enterdeleteWorker(worker);

	}
}
