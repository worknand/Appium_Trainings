package com.sdetqa.AppiumTainings;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDrop {

static AndroidDriver driver;
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String[] args) throws MalformedURLException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("udid", "85KRN7YTNNXK5DWO");
		capabilities.setCapability("deviceName", "Redmi 9");
		capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity","com.mobeta.android.demodslv.Launcher");
		capabilities.setCapability("automationName", "Appium");
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.xpath("//*[@text='Basic usage playground']")).click();
		
		//chick corea
		
		
		WebElement source =driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(2);
		
		WebElement target =driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(5);
		
		TouchAction action =new TouchAction(driver);
		
		//drag and drop
		
		action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
		
		
		System.out.println("Successful");
		
		driver.quit();
		


}
}
