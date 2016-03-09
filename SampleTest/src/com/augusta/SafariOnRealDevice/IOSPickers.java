package com.augusta.SafariOnRealDevice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;

public class IOSPickers {
	public static void main(String[] args) throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");	
		capabilities.setCapability("platformName", "iOS");	
//		capabilities.setCapability("platformVersion", "9.2.1");
//		capabilities.setCapability("deviceName", "iPhone"); //
		
		
		capabilities.setCapability("platformVersion", "9.1");
		capabilities.setCapability("deviceName", "Augusta’s iPhone6S plus"); //
		capabilities.setCapability("app", "/Users/administrator/Library/Developer/Xcode/DerivedData/UICatalog-etygmeejalybcbeaczwvsdflvftm/Build/Products/Debug-iphoneos/UICatalog.app");
		capabilities.setCapability("bundleId", "com.augusta.test"); //bundleId
		//capabilities.setCapability("udid", "74f764e4067450e45ada3fbdefa7889bf6560fe6");
		capabilities.setCapability("udid", "5a127959bdd1b42e47a408b9128ac47fabee698e");
		IOSDriver driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.scrollTo("Picker View").click();
		((WebElement) driver.findElements(By.className("UIAPickerWheel")).get(1)).sendKeys("150");
		
		
		
		//System.out.println(slider.getAttribute("value"));
		
		driver.quit();
	}
}
