package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SwipeORScrollGesture {
	
static AndroidDriver driver;
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
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
		
		//get screen size
		Dimension size=driver.manage().window().getSize();
		
		//find the position where you need to touch the screen
		int startX=size.getWidth()/2;
		int startY=size.getHeight()/2;
		
		//find the position till you move your finger to swipe
		int endX=startX;
		int endY=(int) (size.getHeight() *.25);
		
		//pointerInput class to create a sequence of actions
		PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		
		//sequence object ,which is a list of actions that will be performed on the device
		Sequence sequence=new Sequence(finger1, 1)
		//move finger to the starting position
		.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX,startY)) 
        //finger coming down to contact with screen
       .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      //pause for few secs
       .addAction(new Pause(finger1, Duration.ofMillis(580)))
       //move finger to end position
       .addAction(finger1.createPointerMove(Duration.ofMillis(580), PointerInput.Origin.viewport(), endX,endY))
       //move finger up
       .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		//perform sequence of actions
		driver.perform(Collections.singleton(sequence));
		
		//driver.perform(Arrays.asList(sequence));
		
		Thread.sleep(3000);
		 
		System.out.println("Successful");
		
		driver.quit();


}
}

