package com.qa.pages;

//import com.hlb.mobileautomation.configs.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.DriverManager;

public class BiometricPage extends BasePage {

    @SuppressWarnings("rawtypes")
	public AppiumDriver driver;
    /*
     *    Constructor initializes screen elements
     */
    @SuppressWarnings("static-access")
	public BiometricPage()

    {
		/*
		 * this.driver = new Hooks().getDriver(); PageFactory.initElements(new
		 * AppiumFieldDecorator(this.driver),this);
		 */
    	 this.driver = new DriverManager().getDriver();
		  PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @iOSXCUITFindBy(id="Yes")
    @AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.uat:id/allow_button")
    private MobileElement allowFingerprint;

    @iOSXCUITFindBy(id="Quick Access")
    @AndroidFindBy(xpath="//*[@text='Quick Access']")
    private MobileElement quickAccessHeader;

    @iOSXCUITFindBy(id="No")
    @AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.uat:id/skip_button")
    private MobileElement denyFingerprint;


    public void waitForBiometricPage()
    {
        waitForVisibilityOf(quickAccessHeader,driver);
    }

    public void clickAllowFingerprint()
    {
        clickButton(allowFingerprint,driver);
    }

    public void clickDenyFingerPrint()
    {
        clickButton(denyFingerprint,driver);
    }

}
