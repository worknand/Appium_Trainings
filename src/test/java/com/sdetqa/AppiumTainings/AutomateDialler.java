package com.sdetqa.AppiumTainings;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateDialler {
	
static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("udid", "85KRN7YTNNXK5DWO");
		capabilities.setCapability("deviceName", "Redmi 9");
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity","com.android.contacts.activities.TwelveKeyDialer");
		capabilities.setCapability("automationName", "Appium");
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement one=driver.findElement(By.id("com.android.contacts:id/one"));
		WebElement two=driver.findElement(By.id("com.android.contacts:id/two"));
		WebElement three=driver.findElement(By.id("com.android.contacts:id/three"));
		WebElement four=driver.findElement(By.id("com.android.contacts:id/four"));
		WebElement five=driver.findElement(By.id("com.android.contacts:id/five"));
		WebElement six=driver.findElement(By.id("com.android.contacts:id/six"));
		WebElement seven=driver.findElement(By.id("com.android.contacts:id/seven"));
		WebElement eight=driver.findElement(By.id("com.android.contacts:id/eight"));
		WebElement nine=driver.findElement(By.id("com.android.contacts:id/nine"));
		WebElement zero=driver.findElement(By.id("com.android.contacts:id/zero"));
		
		WebElement call_sim1=driver.findElement(By.id("com.android.contacts:id/call_sim1"));

		seven.click();
		eight.click();
		four.click();
		five.click();
		two.click();
		eight.click();
		two.click();
		two.click();
		seven.click();
		nine.click();
		
		call_sim1.click();
		
}
}