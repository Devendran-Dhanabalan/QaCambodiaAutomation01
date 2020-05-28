package com.qa.pages;

import com.qa.utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends BasePage{
    @SuppressWarnings("rawtypes")
	public AppiumDriver driver;
    /*
     *    Constructor initializes screen elements
     */

    @iOSXCUITFindBy(id = "checkNo")
    @AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/noButton")
    private MobileElement noButton;

    @iOSXCUITFindBy(id = "checkYes")
    @AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/yesButton")
    private MobileElement yesButton;

    @iOSXCUITFindBy(id = "field_password")
    @AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/edit_text_password")
    private MobileElement passwordTextField;
    
    @iOSXCUITFindBy(id="login_btn")
    @AndroidFindBy(id="my.com.hongleongconnect.mobileconnect.ui:id/text_view_login")
    private MobileElement passwordLoginBtn;


    @SuppressWarnings("static-access")
	public PasswordPage()
    {
        this.driver = new Hooks().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public void clickYes()
    {
        clickButton(yesButton,driver);
    }

    public void clickNo() {
        clickButton(noButton,driver);
    }

	public void enterPassword(String passwordText) {
		inputText(passwordText, passwordTextField, driver);
	}

    public void loginWithPassword(String passwordText) {
        enterPassword(passwordText);
   
    }

    public void waitForPasswordPage()
    {
        waitForVisibilityOf(yesButton,driver);
    }

    public void waitForPasswordTextField()
    {
        waitForVisibilityOf(passwordTextField,driver);
    }
    public void passwordLoginBtnClick() {
    	 clickButton(passwordLoginBtn,driver);
    }
  

}
