package com.multitest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {

	WebDriver driver;

	//@BeforeMethod
	@BeforeClass
	public void Initalization() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishwa\\Desktop\\SeleniumJars\\chromedriver.exe");

		driver = new ChromeDriver();// run time polymorphismge
		driver.get("https://www.amazon.ca");

		driver.manage().window().maximize(); // maximize the window

		System.out.println(driver.getTitle());
	}

	@Test(priority = 1)
	public void SelectDropDown() {

		WebElement dropdownbox = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdownbox);

		sel.selectByIndex(4);

		sel.selectByValue("search-alias=gift-cards");

		sel.selectByVisibleText("Musical Instruments, Stage & Studio");

		// sel.
	}

	@Test(priority = 2)
	public void AdvanceDropDown()

	{

		WebElement dropdownbox = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdownbox);

		List<WebElement> li = sel.getOptions();

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {
			li.get(i).click();

			System.out.println(li.get(i).getText());
		}

	}

	//@AfterMethod
	
	@AfterClass
	public void CleanUp() {
		driver.close();
	}

}
