package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class WoolworthsRewardsTest {

@Test  

	//Automating Woolworths Rewards website for User registration
	
	public void test() {

        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.woolworthsrewards.com.au/");
        
        WebElement joinNow = driver.findElement(By.xpath("//a[@href='https://www.woolworthsrewards.com.au/register_single.html']"));
    
        joinNow.click();
        
        WebElement howItWorks = driver.findElement(By.xpath("//*[@id=\"anonymous-header\"]/nav/div/div/div[1]/ul/li[2]/a"));
        
        //assertion is failing because the page displayed after clicking Join Now is always blank 
        
        assertTrue(howItWorks.isDisplayed());
        
        driver.close();
   
        driver.quit();
  
	}

}
