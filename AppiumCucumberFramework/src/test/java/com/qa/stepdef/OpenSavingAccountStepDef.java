package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.OpenSavingAccountPage;
import com.qa.pages.ProductsPage;
import com.qa.pages.UsernamePage;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;

public class OpenSavingAccountStepDef {
	
	private OpenSavingAccountPage commonLocators;
	
	  @When("^I entering username as \"([^\"]*)\"$") 
	  public void
	  iEnteringUsernameAs(String username) throws InterruptedException { 
		 // new LoginPage().enterUserName(username);
		   System.out.println("Testing00"+username);
	       new OpenSavingAccountPage().waitForLanguagePage();
	       System.out.println("Testing01");
	       new OpenSavingAccountPage().selectEnglish();
	       new OpenSavingAccountPage().txtenterTacPin("MICKEY11");
	       new OpenSavingAccountPage().notAllowBtn();
	       new OpenSavingAccountPage().clickOpenAccount();
	       new OpenSavingAccountPage().clickradioButtonKHR();
	       new OpenSavingAccountPage().clickNextCurrencyButton();
	       new OpenSavingAccountPage().clickRbIdYes();
	       new OpenSavingAccountPage().clickrbCitizenNo();
	       new OpenSavingAccountPage().clickrbResidingYes();
	       new OpenSavingAccountPage().clicknextGetStartedFragment();
	       new OpenSavingAccountPage().clickimageFront();
	       //new OpenSavingAccountPage().clickpermissionAllowAutton();

		  }
	  
	  @When("^I entering password as \"([^\"]*)\"$") 
	  public void
	  iEnteringPasswordAs(String password) { new LoginPage().enterPassword(password);
	  }
	  
	  @When("^I logining$") 
	  public void iLogining() { new LoginPage().pressLoginBtn(); }
	  
	  @Then("^logining should fail with an error \"([^\"]*)\"$") public void
	  loginingShouldFailWithAnError(String err) { Assert.assertEquals(new
	  LoginPage().getErrTxt(), err); }
	 
    @Then("^I should seeing Products page with title \"([^\"]*)\"$")
    public void iShouldSeeingProductsPageWithTitle(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);
    }
 	
	String resultusername = "HlbKh"+ RandomStringUtils.randomNumeric(3);
	 String resultPassword = "KhPass"+ RandomStringUtils.randomNumeric(3);
	 
	@Given("^launching the cambodia SIT app$")
	public void launching_the_cambodia_SIT_app() throws Throwable {
	 
	if (!new UsernamePage().checkForUsernamePage())
			{
					//languagePage = new LanguagePage();
		// new OpenSavingAccountPage().waitForLanguagePage();
					//languagePage.waitForLanguagePageKh();
		//new OpenSavingAccountPage().selectEnglish();
					//languagePage.selectEnglishKh();
			}
			
	}

	@When("^selecting the langauge preferences has \"([^\"]*)\"$")
	public void selecting_the_langauge_preferences_has(String arg1) throws Throwable {
	 
		commonLocators = new OpenSavingAccountPage();
		
	    if (arg1.equalsIgnoreCase("English"))
	    		{
		    		new OpenSavingAccountPage().waitForLanguagePage();
		    		new OpenSavingAccountPage().selectEnglish();
		    		new OpenSavingAccountPage().notAllowBtn();
	    		}else {
	    			   new OpenSavingAccountPage().selectEnglish();
	    			   new OpenSavingAccountPage().notAllowBtn();
	    		}
	}

	@Then("^clicking on open saving account button to open the account$")
	public void clicking_on_open_saving_account_button_to_open_the_account() throws Throwable {
	  commonLocators = new OpenSavingAccountPage();
	  commonLocators.clickOpenAccount();
	}

	@Then("^selecting the currency options has combodia \"([^\"]*)\"$")
	public void selecting_the_currency_options_has_combodia(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/radioButtonKHR
		if (arg1.equalsIgnoreCase("KHR"))
		{
			commonLocators.clickradioButtonKHR();
		}else {
			commonLocators.clickradioButtonKHR();
		}	   
	}

	@Then("^clicking on next button to proceed to second page$")
	public void clicking_on_next_button_to_proceed_to_second_page() throws Throwable {
		commonLocators = new OpenSavingAccountPage();

		// kh.com.hongleongconnect.mobileconnect.sit:id/next_currency_button
		commonLocators.clickNextCurrencyButton();
	    
	}

	@Then("^selecting \"([^\"]*)\" has an option for having cambodia National ID$")
	public void selecting_has_an_option_for_having_cambodia_National_ID(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		if (arg1.equalsIgnoreCase("yes"))
		{  // kh.com.hongleongconnect.mobileconnect.sit:id/rb_id_yes
			commonLocators.clickRbIdYes();
		}else {
			commonLocators.clickRbIdYes();
		}
	}

	@Then("^selecting \"([^\"]*)\" has an option for Not having any connection with USA$")
	public void selecting_has_an_option_for_Not_having_any_connection_with_USA(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/rb_citizen_no
		
		if (arg1.equalsIgnoreCase("yes"))
		{  
			commonLocators.clickrbCitizenNo();
		}else {
			commonLocators.clickrbCitizenNo();
		}
	}

	@Then("^selecting \"([^\"]*)\" has an option for residing in cambodia$")
	public void selecting_has_an_option_for_residing_in_cambodia(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/rb_residing_yes
		
		if (arg1.equalsIgnoreCase("yes"))
		{  
			commonLocators.clickrbResidingYes();
		}else {
			commonLocators.clickrbResidingYes();
		}
	}

	@Then("^clicking on next button to proceed to third page$")
	public void clicking_on_next_button_to_proceed_to_third_page() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/next_get_started_fragment
		commonLocators.clicknextGetStartedFragment();
	}

	@Then("^taking photo copy of front page of ID card$")
	public void taking_photo_copy_of_front_page_of_ID_card() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/image_front
		commonLocators.clickimageFront();
	    }

	@Then("^taking photo copy of back page of ID card$")
	public void taking_photo_copy_of_back_page_of_ID_card() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/image_back
		commonLocators.clickimageBack();
	}

	@Then("^now taking selfie of mine for identifcation$")
	public void now_taking_selfie_of_mine_for_identifcation() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/image_selfie
		commonLocators.clickimageSelfie();
	}

	@Then("^entering the full name as per mine ID$")
	public void entering_the_full_name_as_per_mine_ID() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_fullname
		commonLocators.clickinputFullname("Testing FullName");
	}

	@Then("^selecting mine date of birth as per ID$")
	public void selecting_mine_date_of_birth_as_per_ID() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_dob
		commonLocators.clickInputCalDob();
	}

	@Then("^need to enter the ID number which is always unique$")
	public void need_to_enter_the_ID_number_which_is_always_unique() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		String number = RandomStringUtils.randomNumeric(9);
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_layout_id_number
		commonLocators.inpTxtLayoutIdNo(number);
	}

	@Then("^selecting my expiry date of the ID Card$")
	public void selecting_my_expiry_date_of_the_ID_Card() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_expirydate
		commonLocators.clkInpCalnExpiryDate();
	}

	@Then("^selecting the gender has \"([^\"]*)\"$")
	public void selecting_the_gender_has(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/male_button
			if (!arg1.isEmpty())
			{  
				commonLocators.clickRdBtnMale();
			}else {
				commonLocators.clickRdBtnMale();
			}
	}

	@Given("^the dropdown martial status selecting has \"([^\"]*)\"$")
	public void the_dropdown_martial_status_selecting_has(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_marital_status
		commonLocators.drpdwnMaritalStatus();
	}

	@Then("^need to enter the mobile number which is also unique no$")
	public void need_to_enter_the_mobile_number_which_is_also_unique_no() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		 String mobileno = RandomStringUtils.randomNumeric(8);
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_mobile_number
		commonLocators.inpTxtMobileNo(mobileno);
	}

	@Then("^entering the email id of mine$")
	public void entering_the_email_id_of_mine() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_email
		commonLocators.inpTxtEmail("ttest@test.com");
	}

	@Given("^from the dropdown ocupation selecting has \"([^\"]*)\"$")
	public void from_the_dropdown_ocupation_selecting_has(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_layout_occupation
		commonLocators.drpdwnLayoutOccupation();
	}

	@Then("^entering company name has \"([^\"]*)\"$")
	public void entering_company_name_has(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/input_company_name
		if (!arg1.isEmpty())
		{  
			commonLocators.inpTxtCompanyName(arg1);
		}else {
			commonLocators.inpTxtCompanyName("HLB Cambodia company name");
		}
		
	}

	@Then("^clicking on next button to proceed to fourth page$")
	public void clicking_on_next_button_to_proceed_to_fourth_page() throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/next_to_fragment_btn
		commonLocators.clickNextToFragmentBtn();
	}

	@Then("^the page is listed with title \"([^\"]*)\"$")
	public void the_page_is_listed_with_title(String arg1) throws Throwable {
		commonLocators = new OpenSavingAccountPage();
		// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_house_no
		commonLocators.inpTxtCrHouseNoStreet("HLB tower 23 A Cambodia team ");
	}


@Then("^Entering the House number and street no as \"([^\"]*)\"$")
public void entering_the_House_number_and_street_no_as(String arg1) throws Throwable {
    // // kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_house_no
	if (!arg1.isEmpty())
	{  
		commonLocators.inpTxtCrHouseNoStreet(arg1);
	}else {
		commonLocators.inpTxtCrHouseNoStreet("HLB tower 23 A Cambodia team ");
	    
	}
	
}

@Given("^the dropdown to select the province as \"([^\"]*)\"$")
public void the_dropdown_to_select_the_province_as(String arg1) throws Throwable {
  // kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_province_City
				commonLocators.drpdwnCrProvinceCity();
    
}

@Then("^seleting the dropdown value for district as \"([^\"]*)\"$")
public void seleting_the_dropdown_value_for_district_as(String arg1) throws Throwable {
    // 	// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_district
		commonLocators.drpdwnCrDistrict();
    
}

@Then("^selecting the dropdown value for commune as \"([^\"]*)\"$")
public void selecting_the_dropdown_value_for_commune_as(String arg1) throws Throwable {
    // // kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_commune
	commonLocators.drpdwnCrCommune();
    
}

@Then("^selecting the dropdown value for village as \"([^\"]*)\"$")
public void selecting_the_dropdown_value_for_village_as(String arg1) throws Throwable {
    // 		// kh.com.hongleongconnect.mobileconnect.sit:id/edittext_cr_village
	commonLocators.drpdwnCrVillage();
    
}

@Then("^selecting the mailing Addrress indicating it same has permanent$")
public void selecting_the_mailing_Addrress_indicating_it_same_has_permanent() throws Throwable {
    // // kh.com.hongleongconnect.mobileconnect.sit:id/checkbox_is_same_permanent
	commonLocators.ChkBoxIsSamePermanetAddr();
    
}

@Then("^clicking on next button to proceed to fifth page$")
public void clicking_on_next_button_to_proceed_to_fifth_page() throws Throwable {
    // // clicknextButtonThird kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn
	commonLocators.clicknextButtonThird();
    
}

@Given("^to create the user name which is unique like \"([^\"]*)\"$")
public void to_create_the_user_name_which_is_unique_like(String arg1) throws Throwable {
	//  kh.com.hongleongconnect.mobileconnect.sit:id/text_username
		  
		  if (!arg1.isEmpty())
			{  
			  commonLocators.inpTxtUserName(arg1);
			}else {
				 commonLocators.inpTxtUserName(resultusername);
			    
			}  
}

@Then("^need to create the password which is also unique like \"([^\"]*)\"$")
public void need_to_create_the_password_which_is_also_unique_like(String arg1) throws Throwable {
	  // // 	kh.com.hongleongconnect.mobileconnect.sit:id/edittext_create_password
	
	  if (!arg1.isEmpty())
		{  
		  commonLocators.inpTxtCreatePassword(arg1);
		}else {
			 commonLocators.inpTxtCreatePassword(resultPassword);
		    
		}
	  
}

@Then("^by entering the same password by confirming the password like \"([^\"]*)\"$")
public void by_entering_the_same_password_by_confirming_the_password_like(String arg1) throws Throwable {
	 //  //inpTxtConfirmPassword kh.com.hongleongconnect.mobileconnect.sit:id/edittext_confirm_password
	  
	  if (!arg1.isEmpty())
		{  
		  commonLocators.inpTxtConfirmPassword(arg1);
		}else {
			 commonLocators.inpTxtConfirmPassword(resultPassword);
		    
		}  
    
}

@Then("^clicking on next button to reate a new user and to proceed to fifth page$")
public void clicking_on_next_button_to_reate_a_new_user_and_to_proceed_to_fifth_page() throws Throwable {
	 // clicknextButtonFourth kh.com.hongleongconnect.mobileconnect.sit:id/nextBtn
	  commonLocators.clicknextButtonFourth();
    
}

@Given("^the set of radio button need to select mailing address as like \"([^\"]*)\"$")
public void the_set_of_radio_button_need_to_select_mailing_address_as_like(String arg1) throws Throwable {
  switch(arg1)
  {
  case "button1" :
	  		 // kh.com.hongleongconnect.mobileconnect.sit:id/radioButton1
	          commonLocators.clickradioButton1();
	          break;
  case "button2" :
	  		//kh.com.hongleongconnect.mobileconnect.sit:id/radioButton2
			  commonLocators.clickradioButton2();
			  break;
	
  case "button3" :
	        //kh.com.hongleongconnect.mobileconnect.sit:id/radioButton3
			  commonLocators.clickradioButton3();
  case "branch"	:		  
			// drpdwnSelectBranch kh.com.hongleongconnect.mobileconnect.sit:id/edittext_select_branch
			    commonLocators.drpdwnSelectBranch();
			  break;
	default:
		 // kh.com.hongleongconnect.mobileconnect.sit:id/radioButton1
         commonLocators.clickradioButton1();
  }		  
    
}

@Then("^selecting the todays date has appointment$")
public void selecting_the_todays_date_has_appointment() throws Throwable {
    // //kh.com.hongleongconnect.mobileconnect.sit:id/text_date
    //kh.com.hongleongconnect.mobileconnect.sit:id/mdtp_ok
    commonLocators.drpdwnSelectVisitDate();
    
}

@Then("^selecting the first available slots$")
public void selecting_the_first_available_slots() throws Throwable {
    // // kh.com.hongleongconnect.mobileconnect.sit:id/text_time
    // kh.com.hongleongconnect.mobileconnect.sit:id/itemname
    commonLocators.drpdwnSelectVisitTimeSlot();
    
}

@Then("^clicking on next button to submit the appointment and proceed to six page$")
public void clicking_on_next_button_to_submit_the_appointment_and_proceed_to_six_page() throws Throwable {
    
    //  kh.com.hongleongconnect.mobileconnect.sit:id/ntx_btn
    commonLocators.clicknextButtonFifth();
    
}

@Given("^the review page to review on cliking next button on scrolling down$")
public void the_review_page_to_review_on_cliking_next_button_on_scrolling_down() throws Throwable {
    //Scroll is needed below
    
			 //  kh.com.hongleongconnect.mobileconnect.sit:id/ntx_btn
			     commonLocators.clicknextButtonSixth();
    
}

@Given("^to select and accept the terms and conditions for Account$")
public void to_select_and_accept_the_terms_and_conditions_for_Account() throws Throwable {
    //  // kh.com.hongleongconnect.mobileconnect.sit:id/button_account 
    //kh.com.hongleongconnect.mobileconnect.sit:id/accept_term_condition
    commonLocators.chkBoxAcceptAccountTC();
    
}

@Then("^to select and accept the terms and conditions for TC$")
public void to_select_and_accept_the_terms_and_conditions_for_TC() throws Throwable {
    //  //kh.com.hongleongconnect.mobileconnect.sit:id/button_connect_mobile
    //kh.com.hongleongconnect.mobileconnect.sit:id/accept_term_condition
    commonLocators.chkBoxAcceptTermsCon();
    
}

@Then("^to select and accept the terms and conditions for fatca$")
public void to_select_and_accept_the_terms_and_conditions_for_fatca() throws Throwable {
    //   //kh.com.hongleongconnect.mobileconnect.sit:id/button_fatca
    //kh.com.hongleongconnect.mobileconnect.sit:id/accept_term_condition
    commonLocators.tickChkBoxAcceptFatcaTC();
    
}

@Then("^select and perform signature$")
public void select_and_perform_signature() throws Throwable {
    //   // kh.com.hongleongconnect.mobileconnect.sit:id/signatureBorder
    //kh.com.hongleongconnect.mobileconnect.sit:id/signaturePad
    //kh.com.hongleongconnect.mobileconnect.sit:id/saveButton
     commonLocators.selectAndPerformSignature();
    
}

@Then("^clicking on the cofirm button$")
public void clicking_on_the_cofirm_button() throws Throwable {
   System.out.println("This test steps alreay covered in the above step it self");
    
}

@Then("^clicking on next button to proceed to seventh page$")
public void clicking_on_next_button_to_proceed_to_seventh_page() throws Throwable {
    //  //  //  kh.com.hongleongconnect.mobileconnect.sit:id/ntx_btn
    commonLocators.clicknextButtonSeventh();
    
}

@When("^Tac Page appeared entering the TAC OTP \\\"([^\\\"]*)\\\"$")
public void tac_Page_appeared_entering_the_TAC_OTP(String string) throws Throwable {
    // 
	  //kh.com.hongleongconnect.mobileconnect.sit:id/txt_pin_entry2
    commonLocators.txtenterTacPin(resultusername);
    
    //Pending-->kh.com.hongleongconnect.mobileconnect.sit:id/next_to_fragment_btn
    //Pending-->kh.com.hongleongconnect.mobileconnect.sit:id/text_error_message
}
}
