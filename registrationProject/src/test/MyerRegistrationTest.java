package test;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*This Test Case validates the registration process of a new user with all valid data*/

class MyerRegistrationTest {

		protected static WebDriver browser;
		
		
		@Test
		public void Joinin() {
		
		//System.setProperty("webdriver.chrome.driver", driverpathfromsystem());
			
		browser = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(browser, 10);
		
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
	    browser.navigate().to("https://www.myer.com.au/");
	    browser.manage().window().maximize();
	    
	    browser.findElement(By.xpath("//*[@id=\"header-element\"]/div[1]/div/div[1]/div[2]/div/button")).click();
		
	    browser.findElement(By.xpath("//*[@id=\"dropdownJoinLink\"]/span/span")).click();
	    
	    browser.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testmyer12349@gmail.com");
	    
	    browser.findElement(By.xpath("//*[@id=\"loginButton\"]/span")).click();
	    
	    browser.findElement(By.xpath("//*[@id=\"joinPasswordInput\"]")).sendKeys("Test12345");
	    
	    Select title = new Select(browser.findElement(By.xpath("//*[@id=\"joinTitleInput\"]")));
	    title.selectByVisibleText("Mr");
	    
	    browser.findElement(By.xpath("//*[@id=\"joinFirstNameInput\"]")).sendKeys("FirstName");
	    
	    browser.findElement(By.xpath("//*[@id=\"joinLastNameInput\"]")).sendKeys("LastName");
	    
	    browser.findElement(By.xpath("//*[@id=\"joinMobileInput\"]")).sendKeys("0400000000");
	    
	    Select drpCountry = new Select(browser.findElement(By.xpath("//*[@id=\"addressCountryInput\"]")));
		drpCountry.selectByVisibleText("Australia");
		
		 WebElement address = browser.findElement(By.xpath("//*[@id=\"autoSuggestInput\"]"));//*[@id="autoSuggestInput"]
	     address.sendKeys("23 Redden Crescent, RIVERSTONE  NSW 2765"); 
	     
	     WebElement firstItem = browser.findElement(By.xpath("//*[@id=\"suggestion-0\"]"));
	    
	     firstItem.click();
	     
	     if ( !browser.findElement(By.xpath("//*[@id=\"joinMarketingCheckbox\"]")).isSelected() )
	     {
	          browser.findElement(By.xpath("//*[@id=\"joinMarketingCheckbox\"]")).click();
	          
	     }
	     
	     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"join-button\"]")));
	     //click on join
	     browser.findElement(By.xpath("//*[@id=\"join-button\"]")).click(); 
		 
	     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"messageText\"]/span[1]")));
		WebElement var=browser.findElement(By.xpath("//*[@id=\"messageText\"]/span[1]"));
		assertTrue(var.isDisplayed());
			
		
			browser.manage().deleteAllCookies();
		
			browser.close();
			
		}
}