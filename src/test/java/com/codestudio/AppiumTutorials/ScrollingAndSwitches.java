package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollingAndSwitches {
	
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
		System.out.println("Application started");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		//views button
		WebElement views=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		views.click();
		
		//scroll on web page
		String MobileElementToScroll= "Switches";
		
		WebElement switchElement=driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
		".scrollIntoView(new UiSelector().text(\"" + MobileElementToScroll + "\" ))"));
		
		switchElement.click();
		
		//switch
		WebElement monitorSwitch=driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
		
		
		WebElement customtext=driver.findElement(By.xpath("//android.widget.Switch[@content-desc=\"Customized text\"]"));
		customtext.click();
		
		if(monitorSwitch.isSelected()==true) {
			System.out.println("Its ON");
		}
		else
		{
			System.out.println("Its OFF then Switch ON");
			monitorSwitch.click();
		}
		
		
		
		
		//List<WebElement> list= driver.findElements(By.id("android:id/text1"));
		
		
		
		
		System.out.println("Successful");
		
		driver.quit();
		
		

}
}

