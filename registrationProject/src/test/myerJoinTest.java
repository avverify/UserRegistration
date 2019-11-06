package test;


import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


class myerJoinTest {

		protected static WebDriver browser;
		
		
		@Test
		public void Joinin() {
		
		//System.setProperty("webdriver.chrome.driver", driverpathfromsystem());
		
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	    browser.navigate().to("https://www.myer.com.au/");
	    
	    browser.findElement(By.xpath("//*[@id=\"header-element\"]/div[1]/div/div[1]/div[2]/div/button")).click();
		
	    browser.findElement(By.xpath("//*[@id=\"dropdownJoinLink\"]/span/span")).click();
	    
	    browser.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("rpmdocs24@gmail.com");
	    
	    browser.findElement(By.xpath("//*[@id=\"loginButton\"]/span")).click();
	    
	    browser.findElement(By.xpath("//*[@id=\"joinPasswordInput\"]")).sendKeys("Apple12s");
	    
	    Select title = new Select(browser.findElement(By.xpath("//*[@id=\"joinTitleInput\"]")));
	    title.selectByVisibleText("Mrs");
	    
	    browser.findElement(By.xpath("//*[@id=\"joinFirstNameInput\"]")).sendKeys("xxxx");
	    
	    browser.findElement(By.xpath("//*[@id=\"joinLastNameInput\"]")).sendKeys("yyyyyy");
	    
	    browser.findElement(By.xpath("//*[@id=\"joinMobileInput\"]")).sendKeys("0453423176");
	    
	    Select drpCountry = new Select(browser.findElement(By.xpath("//*[@id=\"addressCountryInput\"]")));
		drpCountry.selectByVisibleText("Australia");
		
		 WebElement address = browser.findElement(By.xpath("//*[@id=\"autoSuggestInput\"]"));//*[@id="autoSuggestInput"]
	     address.sendKeys("9 Banjo street, Riverstone, NSW, 2765"); 
	     
	     WebElement firstItem = browser.findElement(By.xpath("//*[@id=\"suggestion-0\"]"));
	    
	     firstItem.click();
	     
	    
	     if ( !browser.findElement(By.xpath("//*[@id=\"joinMarketingCheckbox\"]")).isSelected() )
	     {
	          browser.findElement(By.xpath("//*[@id=\"joinMarketingCheckbox\"]")).click();
	          
	     }
	     browser.findElement(By.xpath("//*[@id=\"join-button\"]")).click();
		  
		
	WebElement var=browser.findElement(By.xpath("//*[@id=\"messageText\"]/span[1]"));
	assertTrue("Jalready registerd", var.isDisplayed());
			
		} 

		@After
		public void cleanUp(){
			browser.manage().deleteAllCookies();
		}
		
		@AfterClass
		public static void tearDown(){
			browser.close();
		}	
	}
