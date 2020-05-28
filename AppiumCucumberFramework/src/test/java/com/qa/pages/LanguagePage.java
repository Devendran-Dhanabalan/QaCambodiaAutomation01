package com.qa.pages;

//import com.hlb.mobileautomation.configs.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.DriverManager;


public class LanguagePage extends BasePage {


    @SuppressWarnings("rawtypes")
	public AppiumDriver driver=this.driver;
    /*
     *    Constructor initializes screen elements
     */
	
	  @SuppressWarnings("static-access") public LanguagePage() { 
		  
		/*
		 * this.driver =new Hooks().getDriver(); PageFactory.initElements(new
		 * AppiumFieldDecorator(this.driver),this);
		 */
		  this.driver = new DriverManager().getDriver();
		  PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	  }
	 

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lang_eng']")
    @AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/eng_button")
    private MobileElement engButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lang_malay']")
    @AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/bm_button")
    private MobileElement malayButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lang_chines']")
    @AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/ch_button")
    private MobileElement chiButton;

    public void selectEnglish()
    {
       clickButton(engButton,driver);
    }

    public void selectBM()
    {
        clickButton(malayButton,driver);
    }

    public void selectCH()
    {
        clickButton(chiButton,driver);
    }

    public boolean checkForUsernamePage()
    {
        return new UsernamePage().checkForUsernamePage();

    }

    public void waitForLanguagePage(){
        waitForVisibilityOf(engButton,driver);
    }
}
