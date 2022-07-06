package com.multitest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HWTestNGfirstrun {

	@Test(priority=1)
	public void PrintInReverse()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishwa\\Desktop\\SeleniumJars\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();//run time polymorphismge
		driver.get("https://www.amazon.ca");
		
		driver.manage().window().maximize(); //maximize the window
		
		System.out.println(driver.getTitle());
		
		WebElement dropdownbox = driver.findElement(By.id("searchDropdownBox"));
		
		Select sel = new Select(dropdownbox);
		
		List<WebElement> li = sel.getOptions();
		
		System.out.println(li.size());
		
		for(int i = li.size()-1; i>=0 ; i--)
		{
			li.get(i).click();
			
			System.out.println(li.get(i).getText());
		}
		driver.close();
	}
	
	@Test(priority=2)
	public void PrintTillIndia(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ishwa\\Desktop\\SeleniumJars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//run time polymorphismge
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		driver.manage().window().maximize(); //maximize the window
		
		System.out.println(driver.getTitle());
		
		WebElement country = driver.findElement(By.name("country"));
		
		Select sel = new Select(country);
		
		List<WebElement> list= sel.getOptions();
		
		System.out.println(list.size());
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equalsIgnoreCase("INDIA")) {
				//i=list.size();
				
				list.get(i).click();
				break;
				
			}
			
			
		}
		
		driver.close();
	}
	}


