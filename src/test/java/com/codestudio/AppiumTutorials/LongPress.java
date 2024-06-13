package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LongPress {
	
static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14.0");
		capabilities.setCapability("udid", "63854d07bfc2");
		capabilities.setCapability("deviceName", "POCO M6 Pro 5G");
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity","com.android.contacts.activities.TwelveKeyDialer");
		capabilities.setCapability("automationName", "Appium");
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		System.out.println("Application started");
		
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
		
		//clear button
	WebElement clear=driver.findElement(By.id("com.android.contacts:id/clear_button"));
	clear.click();
	longPress(clear);
	
	System.out.println("Successful"); 
	
	driver.quit();

		
		
		//Dial sim1
		//call_sim1.click();
		
}
	static void longPress(WebElement el) {
		//find location in screen
		Point location=el.getLocation();
		
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
		
		Sequence longPress=new Sequence(finger, 1);
		//move finger to the starting position
		longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x,location.y)) ;
		 //finger coming down to contact with screen
		longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	     //move finger to end position
		longPress.addAction(finger.createPointerMove(Duration.ofMillis(580), PointerInput.Origin.viewport(), location.x,location.y));
		//move finger up
		longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		//perform sequence of actions
		driver.perform(Collections.singleton(longPress));
	}

}
