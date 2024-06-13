package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HandlingTextAndRadioAndCheckBox {
	
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
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		
		//views
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		
		//controls
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
		
		//darktheme
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"2. Dark Theme\"]")).click();
		
		//textbox
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Nanda");
 
		//checkbox
		driver.findElement(By.id("io.appium.android.apis:id/check2")).click();
		driver.findElement(By.id("io.appium.android.apis:id/check1")).click();
		
		//radiobutton
		
		driver.findElement(By.id("io.appium.android.apis:id/radio1")).click();
		driver.findElement(By.id("io.appium.android.apis:id/radio2")).click();
		
		
		
		
		
        System.out.println("Successful");
		
		driver.quit();

}
}
