package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DrawingDemo {
	
static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14.0");
		capabilities.setCapability("udid", "63854d07bfc2");
		capabilities.setCapability("deviceName", "POCO M6 Pro 5G");
		capabilities.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
		capabilities.setCapability("appActivity","com.saucelabs.mydemoapp.rn.MainActivity");
		capabilities.setCapability("automationName", "Appium");
		
		
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		
		System.out.println("Application started");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	  WebElement optionMenu=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
	  optionMenu.click();
	
      WebElement drawing=	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item drawing\"]"));
      drawing.click();
      
      WebElement drawingPanel=	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drawing screen\"]/android.view.ViewGroup[2]"));
      
      Point location=drawingPanel.getLocation();//point at top left corner of drawing panel
      
      System.out.println("Location is "+location);
      System.out.println("Location of X is "+location.x);
      System.out.println("Location of Y is "+location.y);
      
      //Height and width  of drawing panel
      Dimension size=drawingPanel.getSize();
      System.out.println("Size is "+size);

      
      //find the position where you need to touch
      int startX=(location.x +(size.getWidth()/2));
      System.out.println("Start X is "+startX);
      int startY=location.y;
      System.out.println("Start Y is "+startY);

      
      //position till you want to move your finger to swipe
      int endX=startX;
      int endY=(location.y+ (size.getHeight()));
      
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

	
	
		
		Thread.sleep(3000);
		 
		System.out.println("Successful");
		
		driver.quit();


}
}
