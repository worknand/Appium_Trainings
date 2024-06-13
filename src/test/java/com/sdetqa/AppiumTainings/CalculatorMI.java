package com.sdetqa.AppiumTainings;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorMI {
	static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("udid", "85KRN7YTNNXK5DWO");
		capabilities.setCapability("deviceName", "Redmi 9");
		capabilities.setCapability("appPackage", "com.miui.calculator");
		capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		capabilities.setCapability("automationName", "Appium");
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//driver.navigate().refresh();
		
		WebElement seven=driver.findElement(By.id("com.miui.calculator:id/btn_8_s"));
		//WebElement seven=driver.findElement(By.xpath("//*[@text='7']"));
		
		WebElement plus=driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
		
		WebElement five=driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
		
		WebElement equals=driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		
		seven.click();
		plus.click();
		five.click();
		equals.click();
		
		
		System.out.println("Successful");

		
		driver.quit();

	}

}
