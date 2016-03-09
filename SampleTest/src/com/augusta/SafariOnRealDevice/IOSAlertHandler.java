package com.augusta.SafariOnRealDevice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class IOSAlertHandler {
	
	
	//Appium Launch on Mac
		public static void startAppiumonMac() throws Exception{
		//node appium
		//node appium.js
		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
		command.addArgument("--address", false);
		command.addArgument("0.0.0.0");
		command.addArgument("--port", false);
		command.addArgument("4723");
		command.addArgument("--no-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
		Thread.sleep(3000);
		}
		public static void stopAppium() throws Exception{
		Runtime.getRuntime().exec("killall node");
		}

	public static void main(String[] args) throws Exception{
		
		//stopAppium();
		//startAppiumonMac();
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
		driver.scrollTo("Alert Views").click();
		driver.findElement(By.name("Simple")).click();
//	    Alert simpleAlert=driver.switchTo().alert();
//		simpleAlert.accept();
		
		
		if(driver.findElement(By.className("UIAAlert")).getAttribute("label").equals("A Short Title Is Best")){
			driver.findElement(By.name("OK")).click();
			}
		
		Thread.sleep(1000);
		driver.findElement(By.name("Okay / Cancel")).click();
		
		if(driver.findElement(By.className("UIAAlert")).getAttribute("label").equals("A Short Title Is Best")){
			driver.findElement(By.name("OK")).click();
			}
		
		Thread.sleep(1000);
		driver.findElement(By.name("Other")).click();
		if(driver.findElement(By.className("UIAAlert")).getAttribute("label").equals("A Short Title Is Best")){
			driver.findElement(By.name("Cancel")).click();
			}
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("Text Entry")).click();
		if(driver.findElement(By.className("UIAAlert")).getAttribute("label").equals("A Short Title Is Best")){
			
          //  driver.FindElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]")).SendKeys("password");
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]")).sendKeys("Hai Kotes");
       
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]")).click();
			}
		
		Thread.sleep(3000);
		
		//System.out.println(slider.getAttribute("value"));
		
		driver.quit();
	}
}
