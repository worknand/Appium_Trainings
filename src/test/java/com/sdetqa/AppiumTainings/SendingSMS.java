package com.sdetqa.AppiumTainings;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SendingSMS {
	
    static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("udid", "85KRN7YTNNXK5DWO");
		capabilities.setCapability("deviceName", "Redmi 9");
		capabilities.setCapability("appPackage", "com.android.mms");
		capabilities.setCapability("appActivity","com.android.mms.ui.NewMessageActivity");
		capabilities.setCapability("automationName", "Appium");
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("com.android.mms:id/embedded_text_editor")).sendKeys("hello nanda");
		
		driver.findElement(By.id("com.android.mms:id/recipients_viewer")).click();
		
		driver.findElement(By.id("com.android.mms:id/send_button")).click();
		
		

}
}
