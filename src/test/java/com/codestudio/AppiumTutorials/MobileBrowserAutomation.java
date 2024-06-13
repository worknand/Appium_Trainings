package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MobileBrowserAutomation {
	
static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
        capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14.0");
		capabilities.setCapability("udid", "63854d07bfc2");
		capabilities.setCapability("deviceName", "POCO M6 Pro 5G");
		//capabilities.setCapability("appPackage", "com.android.chrome");
		//capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("chromedriverExecutable", "C:\\Users\\nanda\\eclipse-workspace\\Appium_Trainings\\driver\\chromedriver-win64\\chromedriver.exe");
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		System.out.println("Application started");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.google.com/");
		
	WebElement search=driver.findElement(By.xpath("//textarea[@name='q']"));
	
	search.sendKeys("Australia");
	search.sendKeys(Keys.ENTER);
	
		
		
		
/*	WebElement withOutAccount=driver.findElement(By.id("com.android.chrome:id/signin_fre_dismiss_button"));
	withOutAccount.click();
	
	WebElement gotItButton=driver.findElement(By.id("com.android.chrome:id/ack_button"));
	gotItButton.click();
	
	//searchbox
	WebElement searchBox=driver.findElement(By.id("com.android.chrome:id/search_box_text"));
	searchBox.sendKeys("Australia");  */
		
		Thread.sleep(3000);
		 
		System.out.println("Successful");
		
		driver.quit();


}
}
