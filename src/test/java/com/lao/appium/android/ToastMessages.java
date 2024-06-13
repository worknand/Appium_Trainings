package com.lao.appium.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ToastMessages {

	static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
         DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("udid", "85KRN7YTNNXK5DWO");
		capabilities.setCapability("deviceName", "Redmi 9");
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		System.out.println("Successful");
		WebElement continue1=driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		continue1.click();
		
		Thread.sleep(10000);
		
		WebElement toast=driver.findElement(By.id("io.selendroid.testapp:id/showToastButton"));
		toast.click();
		
		WebElement toastMessage=driver.findElement(By.xpath("/hierarchy/android.widget.Toast"));
	    String message=	toastMessage.getText();
	    
	    System.out.println(message);
	}

}
