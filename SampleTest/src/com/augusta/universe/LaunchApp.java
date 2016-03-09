package com.augusta.universe;

import java.net.MalformedURLException;
import java.util.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class LaunchApp {

//public static void main(String[] args) throws MalformedURLException{
//	DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("automationName", "Appium");	
//		capabilities.setCapability("platformName", "iOS");	
//		capabilities.setCapability("platformVersion", "9.2.1");
//		capabilities.setCapability("deviceName", "iPhone6"); //
//		capabilities.setCapability("app", "/Users/administrator/Library/Developer/Xcode/DerivedData/Universe-geukayhazanrdvfnapbyxbpyivfw/Build/Products/Debug-iphoneos/Universe.app");
//		capabilities.setCapability("bundleId", "com.augusta.universe"); //bundleId
//		capabilities.setCapability("udid", "f7ace1d8817643c5082099f216694f6a5ca6f728");
//	IOSDriver driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//	
//	
//}
	

 //                 ******* Real IOS Device ***********
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	DesiredCapabilities capabilities=new DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS);
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.1");
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Augusta's iPhone6S plus"); //
	capabilities.setCapability("udid", "5a127959bdd1b42e47a408b9128ac47fabee698e");
	capabilities.setCapability("app", "com.augusta.poc");
	capabilities.setCapability("safariAllowPopups", false);
	capabilities.setCapability("safariIgnoreFraudWarning", true);
	//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
	//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone Simulator");
	IOSDriver driver=new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
	//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//Set   = driver.getContextHandles();
	Thread.sleep(5000);
     Set<String> contextHandlers = driver.getContextHandles();
     for(String contextHandle:contextHandlers){
    	 if(contextHandle.contains("WEBVIEW")){
    		 driver.context(contextHandle);
    	 }
     }
	driver.get("http://www.augustasoftsol.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.quit();
	}
}
