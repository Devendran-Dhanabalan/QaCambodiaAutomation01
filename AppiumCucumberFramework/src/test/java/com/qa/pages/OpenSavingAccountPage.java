package com.qa.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.DriverManager;

//import com.hlb.mobileautomation.configs.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OpenSavingAccountPage extends BasePage {

	@SuppressWarnings("rawtypes")
	public AppiumDriver driver=this.driver;

	@iOSXCUITFindBy(xpath = "//*[@name='Allow']")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
	private MobileElement allowBtn;

	@iOSXCUITFindBy(xpath = "//*[@name='Allow']")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='DENY']")
	private MobileElement denyBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='cancel']")
	@AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/button_cancel")
	private MobileElement cancelButton;

	@iOSXCUITFindBy(id = "back")
	private MobileElement backBtn;

	@iOSXCUITFindBy(id = "cancel")
	private MobileElement cancelBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']")
	private MobileElement confirmBtn;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Done']")
	private MobileElement doneBtn;

	@AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/button_no")
	private MobileElement registerLaterBtn;

	@AndroidFindBy(className = "android.widget.RadioButton")
	private MobileElement radioBtn;

	@iOSXCUITFindBy(id = "btn_ok")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Ok']")
	// @AndroidFindBy(id="kh.com.hongleongconnect.mobileconnect.sit:id/notAllowBtn")
	private MobileElement oKBtn;

	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/notAllowBtn")
	private MobileElement notAllowBtn;

	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/open_account_btn")
	private MobileElement openAcctBtn;

	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/radioButtonKHR")
	private MobileElement radioButtonKHR;

	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/next_currency_button")
	private MobileElement nextCurrencyButton;

	// kh.com.hongleongconnect.mobileconnect.sit:id/rb_id_yes
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/rb_id_yes")
	private MobileElement rbIdYes;

	// kh.com.hongleongconnect.mobileconnect.sit:id/rb_citizen_no
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/rb_citizen_no")
	private MobileElement rbCitizenNo;

	// kh.com.hongleongconnect.mobileconnect.sit:id/rb_residing_yes
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/rb_residing_yes")
	private MobileElement rbResidingYes;

	// kh.com.hongleongconnect.mobileconnect.sit:id/next_get_started_fragment
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/next_get_started_fragment")
	private MobileElement nextGetStartedFragment;

	// fornt image
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/image_front")
	private MobileElement imageFront;

	// clickimageBack kh.com.hongleongconnect.mobileconnect.sit:id/image_back
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/image_back")
	private MobileElement clickimageBack;

	// clickimageSelfie Tkh.com.hongleongconnect.mobileconnect.sit:id/image_selfie
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/image_selfie")
	private MobileElement clickimageSelfie;

	//
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private MobileElement permissionAllowButton;

	//
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/startBtn")
	private MobileElement startBtn;

	// kh.com.hongleongconnect.mobileconnect.sit:id/input_fullname
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_fullname")
	private MobileElement txtInpFullname;

	//
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_id_number")
	private MobileElement inpTxtLayoutIdNo;

	//// inpTxtMobileNo
	//// kh.com.hongleongconnect.mobileconnect.sit:id/input_mobile_number
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_mobile_number")
	private MobileElement inpTxtMobileNo;

	// inpTxtEmail kh.com.hongleongconnect.mobileconnect.sit:id/input_email
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_email")
	private MobileElement inpTxtEmail;

	// inpTxtCompanyName
	// kh.com.hongleongconnect.mobileconnect.sit:id/input_company_name
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_company_name")
	private MobileElement inpTxtCompanyName;

	// kh.com.hongleongconnect.mobileconnect.sit:id/input_dob
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_dob")
	private MobileElement txtInpDob;

	// kh.com.hongleongconnect.mobileconnect.sit:id/input_expirydate
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_expirydate")
	private MobileElement clkInpCalnExpiryDate;

	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_company_name")
	private MobileElement txtInpDob1;

	// inpTxtLayoutIdNo kh.com.hongleongconnect.mobileconnect.sit:id/input_dob
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_dob")
	private MobileElement inpTxtLayoutIdN;

	//
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement button1;

	// @AndroidFindBy(xpath =
	// "//android.widget.ListView/android.widget.TextView[@text=\"1992\"]")
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.TextView[2]")
	private MobileElement date_picker_header_date;

	// android.widget.LinearLayout[7]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[3]")
	private MobileElement drpdwnOccupation1;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"02 May 1992\"]")
	private MobileElement date_picker_header_date1;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"02 May 2021\"]")
	private MobileElement date_picker_header_date2;

	// date_picker_ExpiryDate //android.widget.ListView/android.widget.TextView[6]
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.TextView[6]")
	private MobileElement date_picker_ExpiryDate;


	//// android.widget.LinearLayout[7]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView
	// android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@content-desc=\"Driver\"]
	// @AndroidFindBy(xpath =
	/// "//android.widget.LinearLayout[1]/android.widget.RelativeLayout/"+
	/// "android.widget.LinearLayout/android.widget.TextView\n" + "")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text=\"Hairdresser/Beautician\"]")
	private MobileElement editedOcupation1;

	// clickRdBtnMale kh.com.hongleongconnect.mobileconnect.sit:id/male_button
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/male_button")
	private MobileElement clickRdBtnMale;

	// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_marital_status
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_marital_status")
	private MobileElement drpdwnMaritalStatus;

	// android.widget.LinearLayout[5]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text=\"WIDOW/WIDOWER\"]")
	private MobileElement martialStatus1;
 
	// drpdwnLayoutOccupation kh.com.hongleongconnect.mobileconnect.sit:id/input_layout_occupation
	/// hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/input_layout_occupation")
	private MobileElement drpdwnLayoutOccupation;

	@AndroidFindBy(id = "android:id/content")
	private MobileElement drpdwnLayoutOccupation2;

	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/recycler_view")
	private MobileElement drpdwnLayoutDefault;
	
	// clickNextToFragmentBtn kh.com.hongleongconnect.mobileconnect.sit:id/next_to_fragment_btn
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/next_to_fragment_btn")
	private MobileElement clickNextToFragmentBtn;

	// inpTxtCrHouseNoStreet kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_house_no
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_house_no")
	private MobileElement inpTxtCrHouseNoStreet;

	// drpdwnCrProvinceCity kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_province_City
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_province_City")
	private MobileElement drpdwnCrProvinceCity;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text=\"Takeo\"]")
	private MobileElement drpdwnVaueCity1;

	// kh.com.hongleongconnect.mobileconnect.sit:id/recycler_view
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/recycler_view")
	private MobileElement lyoutRecycler_view;

	// drpdwnCrDistrict kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_district
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_district")
	private MobileElement drpdwnCrDistrict;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text=\"Treang\"]")
	private MobileElement drpdwnVaueDistrict1;

	// drpdwnCrCommune kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_commune
    @AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_commune")
	private MobileElement drpdwnCrCommune;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text=\"Tralach\"]")
	private MobileElement drpdwnVaueCommune1;

	// drpdwnCrVillage kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_village
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_village")
	private MobileElement drpdwnCrVillage;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text=\"Trapeang Chhuk\"]")
	private MobileElement drpdwnVaueVillage1;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	private MobileElement drpdwnVaueDefault;

	// ChkBoxIsSamePermanetAddr kh.com.hongleongconnect.mobileconnect.sit:id/checkbox_is_same_permanent
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/checkbox_is_same_permanent")
	private MobileElement ChkBoxIsSamePermanetAddr;

// 	clicknextButtonThird kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn")
	private MobileElement clicknextButtonThird;
	
	// inpTxtUserName kh.com.hongleongconnect.mobileconnect.sit:id/text_username
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/text_username")
	private MobileElement inpTxtUserName;

	// inpTxtCreatePassword kh.com.hongleongconnect.mobileconnect.sit:id/edittext_create_password
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_create_password")
	private MobileElement inpTxtCreatePassword;
	
	 //inpTxtConfirmPassword kh.com.hongleongconnect.mobileconnect.sit:id/edittext_confirm_password
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_confirm_password")
	private MobileElement inpTxtConfirmPassword;
	
	//  // clicknextButtonFourth kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn 
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn")
	private MobileElement clicknextButtonFourth;
	
	  // kh.com.hongleongconnect.mobileconnect.sit:id/radioButton1
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/radioButton1")
	private MobileElement clickradioButton1;
	
    //kh.com.hongleongconnect.mobileconnect.sit:id/radioButton2
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/radioButton2")
	private MobileElement clickradioButton2;
	
	//kh.com.hongleongconnect.mobileconnect.sit:id/radioButton3
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/radioButton3")
	private MobileElement clickradioButton3;
	
	//drpdwnSelectBranch kh.com.hongleongconnect.mobileconnect.sit:id/edittext_select_branch
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/edittext_select_branch")
	private MobileElement drpdwnSelectBranch;
	
	// clickVisitDate kh.com.hongleongconnect.mobileconnect.sit:id/text_date
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/text_date")
	private MobileElement clickVisitDate;
	
	//clickbtnVisitDateOk kh.com.hongleongconnect.mobileconnect.sit:id/mdtp_ok
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/mdtp_ok")
	private MobileElement clickbtnVisitDateOk;
	
	// drpdwnSelectVisitTimeSlot kh.com.hongleongconnect.mobileconnect.sit:id/text_time
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/text_time")
	private MobileElement drpdwnSelectVisitTimeSlot;
	
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn")
	private MobileElement clicknextButtonFifth;
	
	// chkBoxAcceptAccountTC kh.com.hongleongconnect.mobileconnect.sit:id/button_account 
    // chkBoxAcceptAccountTC kh.com.hongleongconnect.mobileconnect.sit:id/accept_term_condition
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/button_account")
	private MobileElement chkBoxAcceptAccountTC;
	
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/accept_term_condition")
	private MobileElement accept_term_condition;
	
	 // chkBoxAcceptTermsCon kh.com.hongleongconnect.mobileconnect.sit:id/button_connect_mobile
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/button_connect_mobile")
	private MobileElement chkBoxAcceptTermsCon;
	
	 //kh.com.hongleongconnect.mobileconnect.sit:id/button_fatca
    //kh.com.hongleongconnect.mobileconnect.sit:id/accept_term_condition
    @AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/button_fatca")
	private MobileElement tickChkBoxAcceptFatcaTC;
    
    // clkSelctSignatureBorder kh.com.hongleongconnect.mobileconnect.sit:id/signatureBorder
    @AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/signatureBorder")
  	private MobileElement clkSelctSignatureBorder;
    
    //clkSelctSignaturePad kh.com.hongleongconnect.mobileconnect.sit:id/signaturePad
    @AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/signaturePad")
  	private MobileElement clkSelctSignaturePad;
    
    //btnSubmitSignatureBorder kh.com.hongleongconnect.mobileconnect.sit:id/saveButton
    @AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/saveButton")
  	private MobileElement btnSubmitSignatureBorder;
	
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lang_eng']")
    @AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/englishBtn")
    private MobileElement engButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='lang_eng']")
    @AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/notAllowBtn")
    private MobileElement enbleLocSerNtNw;
    
	/////////////////////////////////////////////////////////////////////////////////////////
    // New Methods and actions for Cambodia projects//
	///////////////////////////////////////////////////////////////////////////////////////
    

	/*
	 * Constructor initializes screen elements
	 */
	public OpenSavingAccountPage()
	{   //this.driver = new Hooks().getDriver();
		//PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		  this.driver = new DriverManager().getDriver();
		  PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
    /**
	 * Method to select language page
	 */
	public void selectEnglish()
    {
       clickButton(engButton,driver);
       //clickButton(enbleLocSerNtNw,driver);
    }
	
	 public void waitForLanguagePage(){
	        waitForVisibilityOf(engButton,driver);
	    }

	/**
	 * Method to accept allow alert method
	 */
	public void clickAllowNotification() {

		driver.switchTo().alert().accept();
	}

	/**
	 * Method to select deny button
	 */

	public void clickDenyNotification() {

		driver.switchTo().alert().dismiss();
	}

	/**
	 * Method to accept custom allow button
	 */
	public void selectCustomAllowBtn() {

		clickButton(allowBtn, driver);
	}

	/**
	 * Methoid used to click duitnow register later Btn
	 * 
	 */
	public void clickLaterBtn() {
		clickButton(registerLaterBtn, driver);
	}

	/**
	 * Method used to click done button common entire app
	 * 
	 */
	public void clickDoneBtn() {
		clickButton(doneBtn, driver);
	}

	/**
	 * Method to click on ok button
	 */
	public void clickOK() {
		clickButton(oKBtn, driver);
	}

	/**
	 * Method to click on ok button
	 */
	public void notAllowBtn() {
		clickButton(notAllowBtn, driver);
	}
	
	/**
	 * Method to click Open account button by dperiaswamy on sat 09 may 2020
	 */
	public void clickOpenAccount() {
		clickButton(openAcctBtn, driver);
	}

	/**
	 * Method to click Open account button by dperiaswamy on sat 10 may 2020
	 */
	public void clickradioButtonKHR() {
		clickButton(radioButtonKHR, driver);
	}

	/**
	 * Method to click Open account button by dperiaswamy on sat 10 may 2020
	 */
	public void clickNextCurrencyButton() {
		clickButton(nextCurrencyButton, driver);
	}

	/**
	 * Method to click on radio checking ID button has yes by dperiaswamy on sat 10
	 * may 2020 //kh.com.hongleongconnect.mobileconnect.sit:id/rb_id_yes
	 */
	public void clickRbIdYes() {
		clickButton(rbIdYes, driver);
	}

	/**
	 * Method to click on radio checking citizen button has yes by dperiaswamy on
	 * sat 10 may 2020 //kh.com.hongleongconnect.mobileconnect.sit:id/rb_citizen_nos
	 */
	public void clickrbCitizenNo() {
		clickButton(rbCitizenNo, driver);
	}

	/**
	 * Method to clicking on radio residing button has yes by dperiaswamy on sat 10
	 * may 2020 //kh.com.hongleongconnect.mobileconnect.sit:id/rb_residing_yes
	 */
	public void clickrbResidingYes() {
		clickButton(rbResidingYes, driver);
	}

	/**
	 * Method to click next button by dperiaswamy on sat 10 may 2020 //
	 * kh.com.hongleongconnect.mobileconnect.sit:id/next_get_started_fragment
	 */
	public void clicknextGetStartedFragment() {
		clickButton(nextGetStartedFragment, driver);
	}

	/**
	 * Method to click image front button by dperiaswamy on sat 10 may 2020
	 * 
	 */
	public void clickimageFront() {

		clickButton(imageFront, driver);

		clickpermissionAllowAutton();

		// clickpermissionAllowAutton();

		clickstartBtn();

	}

	/**
	 * Method to click permission button by dperiaswamy on sat 10 may 2020
	 * 
	 */
	public void clickpermissionAllowAutton() {
		// TODO Auto-generated method stub
		driver.switchTo().alert().accept();
		clickButton(permissionAllowButton, driver);

	}

	/**
	 * Method to click start button by dperiaswamy on mon 11 may 2020
	 * 
	 */
	public void clickstartBtn() {
		// TODO Auto-generated method stub
		clickButton(startBtn, driver);

	}

	/**
	 * Method to click start button by dperiaswamy on mon 11 may 2020
	 * 
	 */
	public void clickinputFullname(String string) {

		// TODO Auto-generated method stub
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_fullname
		String resultusername = "HlbKh"+ RandomStringUtils.randomAlphabetic(9);
		inputText(resultusername, txtInpFullname, driver);
		// clickButton(txtInpFullname, driver);

	}
	
	/**
	 * Method to click start button by dperiaswamy on mon 11 may 2020
	 * 
	 */
	public void clickInputCalDob() throws InterruptedException {
		// TODO Auto-generated method stub
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_dob
		clickButton(txtInpDob, driver);

		// scroll till 5 times till 1992 and click on visible
		clickButtonBySwipeDownOnLayoutDOB(date_picker_header_date, driver, drpdwnLayoutOccupation2);

		// clickButton(date_picker_header_date, driver);

		// selecting specific date like 2 may 1992
		// clickButton(date_picker_header_date1, driver);

		// click ok will automatically select current date for the above year
		clickButton(button1, driver);

		// android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText[2]

	}

	/**
	 * Method to click start button by dperiaswamy on mon 11 may 2020
	 * 
	 */
	public void clkInpCalnExpiryDate() throws InterruptedException {
		// clkInpCalnExpiryDate
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_expirydate
		clickButton(clkInpCalnExpiryDate, driver);

		// scrollUsingTouchAction("up", driver); // use this only when u just need one
		// scroll

		// it will scroll once and will select the 6th elements
		clickButtonBySwipeUpOnLayout(date_picker_ExpiryDate, driver, drpdwnLayoutOccupation2);

		// use below only if specific date needs to be selected
		// clickButton(date_picker_header_date2, driver);

		// will click ok button with current date has default.
		clickButton(button1, driver);
		Thread.sleep(2000);
		scrollUsingTouchAction("up", driver);

	}

	/**
	 * Method to click start button by dperiaswamy on Tue 12 may 2020
	 * 
	 */
	public void inpTxtLayoutIdNo(String text) {
		// // inpTxtLayoutIdNo
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_id_number
		 String result = RandomStringUtils.randomNumeric(9);
		 if (text!=null) {
			 inputText(text, inpTxtLayoutIdNo, driver);
		 }else {
			 inputText(result, inpTxtLayoutIdNo, driver);
		 }
		  System.out.println("random = " + result); 

	}

	/**
	 * Method to click start button by dperiaswamy on Tue 12 may 2020
	 * 
	 */
	public void clickRdBtnMale() {
		// clickRdBtnMale kh.com.hongleongconnect.mobileconnect.sit:id/male_button
		clickButton(clickRdBtnMale, driver);

	}

	/**
	 * Method to click start button by dperiaswamy on Tue 12 may 2020
	 * 
	 */
	public void drpdwnLayoutOccupation() throws InterruptedException {
		// drpdwnLayoutOccupation
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_layout_occupation
		// Chemist/Physicist/Statistician/Actuarist
		clickButton(drpdwnLayoutOccupation, driver);

		Thread.sleep(1000);

		//clickButtonBySwipeUpOnLayout(editedOcupation1, driver, drpdwnLayoutOccupation2);
		try {
			clickButtonBySwipeUpOnLayout(editedOcupation1, driver, drpdwnLayoutOccupation2);
		}
		catch(Exception e) {
			clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutDefault);
			
		}
		// scrollUsingTouchAction("up", driver);

	}

	/**
	 * Method to click start button by dperiaswamy on Tue 12 may 2020
	 * 
	 */
	public void drpdwnMaritalStatus() throws InterruptedException {
		// TODO Auto-generated method stub

		clickButton(drpdwnMaritalStatus, driver);

		try {
			clickButtonBySwipeUpOnLayout(martialStatus1, driver, drpdwnLayoutOccupation2);
		}
		catch(Exception e) {
			clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutDefault);
			
		}
	}

	/**
	 * Method to click start button by dperiaswamy on Tue 12 may 2020
	 * 
	 */
	public void inpTxtMobileNo(String string) {
		// inpTxtMobileNo
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_mobile_number
		  String result = RandomStringUtils.randomNumeric(8);
		  System.out.println("random = " + result); //
		try {
			inputText(result, inpTxtMobileNo, driver);
		}
		catch(Exception e) {
			inputText(result, inpTxtMobileNo, driver);
		}

	}
	
	/**
	 * Method to click start button by dperiaswamy on Tue 12 may 2020
	 * 
	 */
	public void inpTxtEmail(String string) {
		// inpTxtCompanyNameEmail
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_email
		inputText(string, inpTxtEmail, driver);

	}

	/**
	 * Method to click start button by dperiaswamy on Tue 12 may 2020
	 * 
	 */
	public void inpTxtCompanyName(String string) {
		// // inpTxtCompanyName
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_company_name

		inputText(string, inpTxtCompanyName, driver);
	}

	/**
	 * Method to click start button by dperiaswamy on Wed 13 may 2020
	 * 
	 */
	public void clickimageBack() {
		// clickimageBack kh.com.hongleongconnect.mobileconnect.sit:id/image_back
		clickButton(clickimageBack, driver);

		// clickpermissionAllowAutton();

		// clickpermissionAllowAutton();

		clickstartBtn();

	}

	/**
	 * Method to click start button by dperiaswamy on Wed 13 may 2020
	 * 
	 */
	public void clickimageSelfie() {
		// clickimageSelfie Tkh.com.hongleongconnect.mobileconnect.sit:id/image_selfie
		clickButton(clickimageSelfie, driver);

		// clickpermissionAllowAutton();

		// clickpermissionAllowAutton();

		clickstartBtn();

	}

	/**
	 * Method to click start button by dperiaswamy on Wed 13 may 2020
	 * 
	 */
	public void clickNextToFragmentBtn() {
		// clickNextToFragmentBtn
		// kh.com.hongleongconnect.mobileconnect.sit:id/next_to_fragment_btn
		clickButton(clickNextToFragmentBtn, driver);
	}

	/**
	 * Method to click start button by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void inpTxtCrHouseNoStreet(String string) {
		// // inpTxtCrHouseNoStreet
		// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_house_no
		inputText(string, inpTxtCrHouseNoStreet, driver);

	}

	/**
	 * Method to click start button by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void drpdwnCrProvinceCity() throws InterruptedException {
		// // drpdwnCrProvinceCity
		// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_province_City

		clickButton(drpdwnCrProvinceCity, driver);

		// clickButtonBySwipeUpOnLayout(drpdwnVaueCity1, driver,
		// drpdwnLayoutOccupation2);
		
			try {
				clickButtonBySwipeUpOnLayout(drpdwnVaueCity1, driver, lyoutRecycler_view);
				
		} catch (Exception e) {
				clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutDefault);
		}
	}

	/**
	 * Method to click start button by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void drpdwnCrDistrict() throws InterruptedException {
		// drpdwnCrDistrict 
		// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_district

		clickButton(drpdwnCrDistrict, driver);

			try {
				clickButtonBySwipeUpOnLayout(drpdwnVaueDistrict1, driver, drpdwnLayoutOccupation2);
		} catch (Exception e) {
				clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutDefault);
		}
		
	}

	/**
	 * Method to click start button by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void drpdwnCrCommune() throws InterruptedException {
		// drpdwnCrCommune
		// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_commune
		clickButton(drpdwnCrCommune, driver);
	
			try {
				clickButtonBySwipeUpOnLayout(drpdwnVaueCommune1, driver, drpdwnLayoutOccupation2);
		} catch (Exception e) {
				clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutDefault);
		}

	}

	/**
	 * Method to click start button by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void drpdwnCrVillage() throws InterruptedException {
		// drpdwnCrVillage
		// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_village

		clickButton(drpdwnCrVillage, driver);

		try {
				clickButtonBySwipeUpOnLayout(drpdwnVaueVillage1, driver, drpdwnLayoutOccupation2);
		} catch (Exception e) {
				clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutDefault);
		}

	}

	/**
	 * Method to select a checkbox which indicate the permanet address is 
	 * same has current address/Mailing address by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void ChkBoxIsSamePermanetAddr() {
		// ChkBoxIsSamePermanetAddr
		// kh.com.hongleongconnect.mobileconnect.sit:id/checkbox_is_same_permanent

		clickButton(ChkBoxIsSamePermanetAddr, driver);
	}
	
	/**
	 * Method to  navigate to user creation page by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void clicknextButtonThird() {
		// clicknextButtonThird kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn
		clickButton(clicknextButtonThird, driver);

	}

	/**
	 * Method to create a new user name by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void inpTxtUserName(String string) {
		// kh.com.hongleongconnect.mobileconnect.sit:id/text_username
		System.out.println("String:"+ string);
		inputText(string, inpTxtUserName, driver);
	}


	/**
	 * Method to create a new password by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void inpTxtCreatePassword(String string) {
		// inpTxtCreatePassword kh.com.hongleongconnect.mobileconnect.sit:id/text_username
		inputText(string, inpTxtCreatePassword, driver);
		System.out.println("String:"+ string);
	}

	/**
	 * Method to re-enter the password to confirm by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	public void inpTxtConfirmPassword(String string) {
	  //inpTxtConfirmPassword kh.com.hongleongconnect.mobileconnect.sit:id/edittext_confirm_password
		inputText(string, inpTxtConfirmPassword, driver);
		System.out.println("String:"+ string);
		
	}
	
	/**
	 * Method to review the summary of all entered data page by dperiaswamy on Thu 14 may 2020
	 * 
	 */
	
	public void clicknextButtonFourth() {
		//   // clicknextButtonFourth kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn
		clickButton(clicknextButtonFourth, driver);
	}


	public void clickradioButton1() {
		// TODO Auto-generated method stub
		clickButton(clickradioButton1, driver);
	}
	public void clickradioButton2() {
		// TODO Auto-generated method stub
		clickButton(clickradioButton2, driver);
	}
	public void clickradioButton3() {
		// TODO Auto-generated method stub
		clickButton(clickradioButton3, driver);
	}
	
	public void drpdwnSelectBranch() {
		//drpdwnSelectBranch kh.com.hongleongconnect.mobileconnect.sit:id/edittext_select_branch
		clickButton(drpdwnSelectBranch, driver);

		try {
				clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutOccupation2);
		} catch (Exception e) {
				clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutDefault);
		}
		
	}

	public void drpdwnSelectVisitDate() {
		// clickVisitDate kh.com.hongleongconnect.mobileconnect.sit:id/text_date

		//clickbtnVisitDateOk kh.com.hongleongconnect.mobileconnect.sit:id/mdtp_ok
		
		clickButton(clickVisitDate, driver);
		
		clickButton(clickbtnVisitDateOk, driver);
	}

	public void drpdwnSelectVisitTimeSlot() {
		
		// drpdwnSelectVisitTimeSlot kh.com.hongleongconnect.mobileconnect.sit:id/text_time
       // kh.com.hongleongconnect.mobileconnect.sit:id/itemname
	     clickButton(drpdwnSelectVisitTimeSlot, driver);
	     clickButton(drpdwnVaueDefault, driver);
		/*
		 * try { clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver,
		 * drpdwnLayoutOccupation2); } catch (Exception e) {
		 * clickButtonBySwipeUpOnLayout(drpdwnVaueDefault, driver, drpdwnLayoutDefault);
		 * }
		 */
	}
	
	public void clicknextButtonFifth() throws Exception {
		// TODO Auto-generated method stub
		clickButton(clicknextButtonFifth, driver);
		scrollToElement(clicknextButtonFifth, "up");
	}
	
	public void clicknextButtonSixth() {
		// TODO Auto-generated method stub
		//scrollToElement(clicknextButtonFifth, "up");
		clickButtonBySwipeUp(clicknextButtonFifth, driver);
		//clickButton(clicknextButtonFifth, driver);
	}

	public void chkBoxAcceptAccountTC() {
		// chkBoxAcceptAccountTC kh.com.hongleongconnect.mobileconnect.sit:id/button_account 
	     // chkBoxAcceptAccountTC kh.com.hongleongconnect.mobileconnect.sit:id/accept_term_condition
		clickButton(chkBoxAcceptAccountTC, driver);
		clickButton(accept_term_condition, driver);
		
	}

	public void chkBoxAcceptTermsCon() {
		 // chkBoxAcceptTermsCon kh.com.hongleongconnect.mobileconnect.sit:id/button_connect_mobile
	     //kh.com.hongleongconnect.mobileconnect.sit:id/accept_term_condition
		clickButton(chkBoxAcceptTermsCon, driver);
		clickButton(accept_term_condition, driver);
		
	}

	public void tickChkBoxAcceptFatcaTC() {
		// TODO Auto-generated method stub
		clickButton(tickChkBoxAcceptFatcaTC, driver);
		clickButton(accept_term_condition, driver);
	}

	public void selectAndPerformSignature() {
		//  // clkSelctSignatureBorder kh.com.hongleongconnect.mobileconnect.sit:id/signatureBorder
		clickButton(clkSelctSignatureBorder, driver);
		
	    //kh.com.hongleongconnect.mobileconnect.sit:id/signaturePad
		clickButton(clkSelctSignaturePad, driver);
		
		swipeDragRightSignature(driver);
		
	    //kh.com.hongleongconnect.mobileconnect.sit:id/saveButton
		clickButton(btnSubmitSignatureBorder, driver);
		
	}

	public void clicknextButtonSeventh() {
		
		clickButton(clicknextButtonFifth, driver);
		
	}

	public void txtenterTacPin(String username ) {
		// TODO Auto-generated method stub
		enterTacPinForSitKh(username);
		
	}
	
	
}