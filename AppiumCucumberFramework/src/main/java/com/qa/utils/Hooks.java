package com.qa.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.qa.utils.CapsJsonParser;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@SuppressWarnings("rawtypes")
public class Hooks {

	private static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();
	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	
	public static AppiumDriver getDriver() {
		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.get();
	}

	public AppiumDriverLocalService getService() {
		return service.get();
	}

	/**
	 * Start Appium Server Programmatically before each scenario
	 */

	// @Before, @After are called Global tagged hooks
	/*
	 * @Before public void startServer() { AppiumServiceBuilder appiumServiceBuilder
	 * = new AppiumServiceBuilder() .withAppiumJS(new
	 * File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
	 * .withIPAddress("127.0.0.1"); service.set(appiumServiceBuilder.build());
	 * service.get().start();
	 * 
	 * if (service == null || !service.get().isRunning()) { throw new
	 * AppiumServerHasNotBeenStartedLocallyException("Malaysia-: An Appium server node is not started!"
	 * ); }
	 * 
	 * if (driver.get() == null) { setDriver(); } //else if (!new
	 * UsernamePage().checkForUsernamePage()) { //setDriver(); //} }
	 */

	public void setDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if (System.getProperty("platform").equalsIgnoreCase("ios")) {
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
					(String) CapsJsonParser.getJSONObjectValue("ios").get("platformVersion"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
					(String) CapsJsonParser.getJSONObjectValue("ios").get("deviceName"));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					(String) CapsJsonParser.getJSONObjectValue("ios").get("automationName"));
			capabilities.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, true);
			capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,
					(String) CapsJsonParser.getJSONObjectValue("ios").get("bundleId"));
			capabilities.setCapability(MobileCapabilityType.UDID,
					(String) CapsJsonParser.getJSONObjectValue("ios").get("udid"));
			capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") +"/Resources/Hongleong.ipa");
			driver.set(new IOSDriver<IOSElement>(service.get().getUrl(), capabilities));
		} else {
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
					(String) CapsJsonParser.getJSONObjectValue("android").get("platformVersion"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
					(String) CapsJsonParser.getJSONObjectValue("android").get("deviceName"));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					(String) CapsJsonParser.getJSONObjectValue("android").get("automationName"));
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
					(String) CapsJsonParser.getJSONObjectValue("android").get("appPackage"));
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
					(String) CapsJsonParser.getJSONObjectValue("android").get("appActivity"));
			//capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/Resources/Hongleong.apk");
			driver.set(new AndroidDriver<AndroidElement>(service.get().getUrl(), capabilities));		     
		}
	}
	
	
//	@After(order = 1)
//	public void saveScreenshot(Scenario scenario) {
//		String screenshotName = scenario.getName().replaceAll(" ", "_");
//		if (scenario.isFailed()) {
//			File sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//
//			File destinationDir = new File("./target/cucumber-reports/extent-report/");
//			if (!destinationDir.exists()) {
//				destinationDir.mkdir();
//			}
//			File destinationPath = new File(destinationDir + "/" + screenshotName + ".png");
//			try {
//				Files.copy(sourcePath, destinationPath);
//				Reporter.addScreenCaptureFromPath(screenshotName + ".png");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		CommonUtils.getInstance().removeDevice();
//	}
}
