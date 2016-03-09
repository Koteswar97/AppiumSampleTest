package com.augusta.safariinSimulator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class RunOnSimulator {
	
	
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

	
	public static void main(String[] args) throws Exception {
		//stopAppium();
		//startAppiumonMac();
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS);
		File f = new File("/Users/administrator/Library/Developer/Xcode/DerivedData/Universe-geukayhazanrdvfnapbyxbpyivfw/Build/Products/Debug-iphoneos/Universe.app");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.1");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone");
		capabilities.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		//capabilities.setCapability(MobileCapabilityType., "com.augusta.test"); //bundleId
		IOSDriver driver=new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		driver.get("http://google.com");
//		Thread.sleep(4000);
//		driver.quit();
		}
}
