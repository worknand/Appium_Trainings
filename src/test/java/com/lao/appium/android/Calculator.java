package com.lao.appium.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;


public class Calculator {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14.0");
		capabilities.setCapability("udid", "63854d07bfc2");
		capabilities.setCapability("deviceName", "POCO M6 Pro 5G");
		capabilities.setCapability("appPackage", "com.miui.calculator");
		capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
	   // capabilities.setCapability("automationName", "UiAutomator1");
		//capabilities.setCapability("appWaitForLaunch", false);
		
		//another way for setting capabilities
		
		//capabilities.setCapability(MobileCapabilityType, false);
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		
		driver=new AndroidDriver(url,capabilities);
		
		System.out.println("Successful");
		
		WebElement one=driver.findElement(By.id("com.miui.calculator:id/digit_1"));
		
		WebElement plus=driver.findElement(By.id("com.miui.calculator:id/op_add"));
		
		WebElement  two=driver.findElement(By.id("com.miui.calculator:id/digit_2"));
		
		WebElement equals=driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		
		one.click();
		plus.click();
		two.click();
		equals.click();
		
		
	   System.out.println(equals.getText());



	}

}
