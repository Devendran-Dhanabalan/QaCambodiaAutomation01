# appium-cucumberbdd
Tools and Technologies
======================
- Cucumber JVM
- Gherkin
- Appium
- Java
- Maven
- Log4J2
- JUnit
- IntelliJ

Framework features
==================
- Page Object Model Design
- Supports Android and iOS
- Behavioral Driven
- Production Ready
- Supports Parallel Execution
- Screenshot on Scenario Failure
- Video Recording
- Log4J logging with Parallel Logging Support
- Start and Stop Appium Server Programmatically
- Integration with Cucumber-HTML-Reports Plugin
- Execution from Runner file or from Maven Command Line

Sauce Lab's demo mobile app
===========================
- GitHub: https://github.com/saucelabs/sample-app-mobile
- Releases (Latest APKs and IPAs): https://github.com/saucelabs/sample-app-mobile/releases

Cucumber
========
- Cucumber JVM: https://cucumber.io/docs/installation/java/
- Ccumber JUnit: https://cucumber.io/docs/cucumber/api/#junit
- Gherkin basics: https://cucumber.io/docs/gherkin/reference/
- Step Management: https://cucumber.io/docs/gherkin/step-organization/

Log4J2
=======
log4j2 configurations (GitHub): https://github.com/omprakashchavan01/log4j2_properties

Cucumber HTML Reports
=====================
- cucumber-jvm reports (Jenkins plugin): https://github.com/jenkinsci/cucumber-reports-plugin
- cucumber-jvm reports (cucumber): https://gitlab.com/monochromata-de/cucumber-reporting-plugin

#cucumberbdd #appium #junit
=====================
mvn test -Dplatform="Android" -Dudid="emulator-5554" -DeviceName="Pixel 2 API 26" -DsystemPort="10004" -DchromeDriver="11004"

mvn test-DplatformName="iOS" -DdeviceName="iPhone 11" -Dudid="" -DwdaLocalPort="10004" -DwebkitDebugProxyPort="10005"

"platformName":"android","chromeDriverPort":11000,"app":"/Users/tdeven/Desktop/appiumCucumberBddTest/AppiumCucumberFramework/src/test/resources/apps/Android.SauceLabs.Mobile.Sample.app.2.2.1.apk","appActivity":"com.swaglabsmobileapp.SplashActivity","appPackage":"com.swaglabsmobileapp","automationName":"UiAutomator2","deviceName":"Pixel 2 API 26","systemPort":10000,"udid":"emulator-5554"

=====================
#### Stesps to run it##
=====================
Make changes in GlobalParam like below:
 	params.setPlatformName(System.getProperty("platformName", "Android"));
	 params.setUDID(System.getProperty("udid", "ce11171b79f6090e04"));
 	params.setDeviceName(System.getProperty("deviceName", "Galaxy"));
Also Need to changes few properties in Config.Properites like below:
	androidAutomationName=UiAutomator2
	androidAppPackage=kh.com.hongleongconnect.mobileconnect.sit
	androidAppActivity=mobileconnect.com.activity.SplashScreenActivity"
