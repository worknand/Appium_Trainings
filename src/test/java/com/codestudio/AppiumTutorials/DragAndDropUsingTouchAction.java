package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.AbstractOptionCombinedWithPosition;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDropUsingTouchAction {

static AndroidDriver driver;
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
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
				
			//by using touch action class-deprecated
				TouchAction action =new TouchAction(driver);
				
			//	action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
				
				action.longPress(LongPressOptions().withElement(element(source))).moveTo(element(target)).release().perform();
				
				
				
		System.out.println("Successful");
		
		driver.quit();
		


}

	private static  AbstractOptionCombinedWithPosition<LongPressOptions> LongPressOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
