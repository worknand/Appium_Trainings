package com.lao.appium.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ExpandableAndCollapsibleList {
	
	static AndroidDriver driver;

	
	public static void main(String[] args) throws MalformedURLException {
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("udid", "85KRN7YTNNXK5DWO");
		capabilities.setCapability("deviceName", "Redmi 9");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement views=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		views.click();
		
		WebElement expandableLists=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]"));
		expandableLists.click();
		
		WebElement customAdapter=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]"));
		customAdapter.click();
		
		WebElement peopleNames=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]"));
		peopleNames.click();
		
		List<WebElement> list=driver.findElements(By.xpath("//*[@class='android.widget.TextView']") );
		
		for (WebElement names : list) {
			
			if(!(names.getText().equalsIgnoreCase("Dog Names"))) {
				System.out.println(names.getText());
			}
			else
				break;	
			
			
		}
		
		System.out.println("Successful");
		
		
		

	}

}
