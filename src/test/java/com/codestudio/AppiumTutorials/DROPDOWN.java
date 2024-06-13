package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DROPDOWN {
	
static AndroidDriver driver;
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14.0");
		capabilities.setCapability("udid", "63854d07bfc2");
		capabilities.setCapability("deviceName", "POCO M6 Pro 5G");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		capabilities.setCapability("automationName", "Appium");
		
		URL url=URI.create("http://0.0.0.0:4723/wd/hub").toURL();
		
		//URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		System.out.println("Application started");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		//views button
				WebElement views=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
				views.click();
				
				//controls
				driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
				
				//light theme
				driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]")).click();
				
				//dropdown button
				 driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
				 
				 //neptune
				 driver.findElement(By.xpath("//*[@text='Neptune']")).click();
				 
					
					System.out.println("Successful");
					
					driver.quit();
				
				

}
}
