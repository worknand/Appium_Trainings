package com.codestudio.AppiumTutorials;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppManagement {
	//Install,verify,Activate,Remove,Terminate
	
static AndroidDriver driver;
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
        DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14.0");
		capabilities.setCapability("udid", "63854d07bfc2");
		capabilities.setCapability("deviceName", "POCO M6 Pro 5G");
		capabilities.setCapability("automationName", "Appium");
		
		URL url=URI.create("http://0.0.0.0:4723/wd/hub").toURL();
		
		//URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver(url,capabilities);
		System.out.println("Application started");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		String packageName="io.appium.android.apis";
		
	//	boolean terminateResult=driver.terminateApp(packageName);
	//	System.out.println(terminateResult);
		
	/*	//remove app -uninstall
		driver.removeApp(packageName);
		
		boolean result=driver.isAppInstalled(packageName);
	
		if(result==false) {
		//install
		driver.installApp("C:\\Users\\nanda\\Documents\\Appium\\APK_Files\\ApiDemos-debug.apk");
		System.out.println("App successfully Installed");
		//activate
		driver.activateApp(packageName);
		}
		else 
			System.out.println("App already installed  " + result);
		
		Thread.sleep(9000);
		
        System.out.println("Successful"); */
		
		driver.quit();

}
}
