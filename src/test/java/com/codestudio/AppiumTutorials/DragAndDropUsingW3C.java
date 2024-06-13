package com.codestudio.AppiumTutorials;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.AbstractOptionCombinedWithPosition;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDropUsingW3C {

static AndroidDriver driver;
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		        //views button
				WebElement views=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
				views.click();
				
			//drag and drop
				WebElement dragAndDrop=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]"));
				dragAndDrop.click();
				
			//source	
				WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
				
				
				//target
				WebElement target=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
				
			//get  points
				Point sourceCenter=getCenter(source);
				
				Point targetCenter=getCenter(target);
				
			//pointerInput class to create sequence of actions	
				//that move the pointer to the center of the element 
				//press down on the element. then release the element
				
				PointerInput finger1= new  PointerInput(PointerInput.Kind.TOUCH, "finger1");
		
		//Sequence object , which is a list of actions that will be performed on the device 
				
				Sequence sequence=new Sequence(finger1, 1)
				//move finger to the starting position
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceCenter)) 
                //finger coming down to contact with screen
               .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
               //pause for few secs
               .addAction(new Pause(finger1, Duration.ofMillis(580)))
               
               //move finger to end position
               .addAction(finger1.createPointerMove(Duration.ofMillis(580), PointerInput.Origin.viewport(), targetCenter))
               
               //move finger up
               
               .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
				
				//perform sequence of actions
				//driver.perform(Collections.singleton(sequence));
				
				driver.perform(Arrays.asList(sequence));
				
				Thread.sleep(3000);
				
				
               
            		   
            	   
				
				
				
		System.out.println("Successful");
		
		driver.quit();
		


}
	
	public static Point getCenter(WebElement element) {
		
		//get location of element 
		Point location=element.getLocation();
		
		//get dimension
		Dimension size=element.getSize();
		
		//center point 
		Point center= new Point(location.x + size.width/2 , location.y + size.height/2);
		
		return center;
		
	}

	
}
