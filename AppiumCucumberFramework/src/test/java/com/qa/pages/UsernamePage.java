package com.qa.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsernamePage extends BasePage {

	@SuppressWarnings("rawtypes")
	public AppiumDriver driver;

	/*
	 * Constructor initializes screen elements
	 */
	@SuppressWarnings("static-access")
	public UsernamePage()

	{
		/*
		 * this.driver = new Hooks().getDriver(); PageFactory.initElements(new
		 * AppiumFieldDecorator(this.driver), this);
		 */
		 this.driver = new DriverManager().getDriver();
		  PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@iOSXCUITFindBy(id = "field_userName")
	@AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/edit_text_username")
	private MobileElement usernameTextField;

	@iOSXCUITFindBy(xpath = "//*[@label='Register Username']")
	@AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/text_register")
	private MobileElement registerNowButton;
	
	@iOSXCUITFindBy(id="register_here_btn")
	private MobileElement registerhereBtn;

	@iOSXCUITFindBy(id = "login_btn")
	@AndroidFindBy(id="my.com.hongleongconnect.mobileconnect.ui:id/tv_login_register")
	@FindBy(xpath = "//*[@label = 'Go']")
	private MobileElement loginBtn;

	@iOSXCUITFindBy(id = "ic black question mark")
	private MobileElement questionMarkButton;

	@iOSXCUITFindBy(id = "fx_rate_title")
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Hong Leong'][1]")
	private MobileElement forexButton;

	@iOSXCUITFindBy(id = "loan_calculator_title")
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='LoanCalc']")
	private MobileElement loanCalculatorButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LOCATE US']")
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Locate']")
	private MobileElement locateUsButton;

	@iOSXCUITFindBy(id = "ic_menu_help")
	private MobileElement helpButton;
	
	@AndroidFindBy(xpath= "//android.widget.ImageView[@content-desc='DuitNow']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name='ic_duit_now']")
	private MobileElement duitNowBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CLOSE']")
	@AndroidFindBy(id="my.com.hongleongconnect.mobileconnect.sit:id/img_close")
	private MobileElement closeButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='ATM WITHDRAWAL']")
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='ATMWithdrawl']")
	private MobileElement aTMWithdrawlBtn;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='ScanQr']")
	@iOSXCUITBy(xpath="//XCUIElementTypeStaticText[@name='SCAN QR']")
	private MobileElement scanQrBtn;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='MORE']")
	private MobileElement moreBtn;
	
	@iOSXCUITFindBy(id="btn_morning")
	private MobileElement morningtheme;
	
	@iOSXCUITFindBy(id="btn_night")
	private MobileElement nightTheme;
			 
	public void clickLoginBtn() {
		clickButton(loginBtn, driver);
		System.err.println("-------------- Login Button Clicked ----------------");
	}
	/**
	 * Method to enter username
	 * @param usernameText
	 */

	public void enterUsername(String usernameText) {
		inputText(usernameText, usernameTextField, driver);
	}
	/**
	 * Method to click forex button
	 */

	public void clickForex() {
		clickButton(forexButton, driver);
	}
	/**
	 * Method to click loan calculator button
	 */

	public void clickLoanCalculator() {
		clickButton(loanCalculatorButton, driver);
	}
	/**
	 * Method to click locate us button
	 */

	public void clickLocateUsButton() {
		clickButton(locateUsButton, driver);
	}
	/**
	 * Method to click help button
	 */

	public void clickHelpButton() {
		clickButton(helpButton, driver);
	}
	/**
	 * method to click more Button
	 */

	public void clickMoreButton() {
		clickButton(moreBtn, driver);
	}
	/**
	 * Method to check for username present
	 * @return
	 */

	public boolean checkForUsernamePage() {
		try {
			usernameTextField.isDisplayed();
			return true;

		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}
	/**
	 * Method to wait for username page
	 */

	public void waitForUsernamePage() {
		waitForVisibilityOf(usernameTextField, driver);
	}
	/**
	 * Method for login 
	 * 
	 */
	public void loginApp(String arg1, String arg2)
	{
		waitForUsernamePage();
		enterUsername(arg1);
		clickLoginBtn();
		PasswordPage passwordPage = new PasswordPage();
		passwordPage.waitForPasswordPage();
		passwordPage.clickYes();
		passwordPage.enterPassword(arg2);
		passwordPage.passwordLoginBtnClick();
	}

}
