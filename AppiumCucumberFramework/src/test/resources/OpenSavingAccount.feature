Feature: Log in to the app and Opening an Saving Account

 
 Scenario: Opening an Saving Account with all valid postive data input
    When I entering username as "username"
    And I entering password as "password"
    And I logining
    Then logining should fail with an error "err"
   # Examples:
   #   | username | password | err |
    #  | standard_user | invalidPassword | Username and password do not match any user in this s
   
    @Test
 Scenario Outline:  Saving Account with all valid postive data input
    Given launching the cambodia SIT app 
    When selecting the langauge preferences has "English"
    Then clicking on open saving account button to open the account 
    Then selecting the currency options has combodia "KHR"
    And clicking on next button to proceed to second page
    Then selecting "yes" has an option for having cambodia National ID 
    Then selecting "no" has an option for Not having any connection with USA
    Then selecting "yes" has an option for residing in cambodia
    And clicking on next button to proceed to third page
    Then taking photo copy of front page of ID card
    Then taking photo copy of back page of ID card
    And  now taking selfie of mine for identifcation 
    Then entering the full name as per mine ID
    And  selecting mine date of birth as per ID
    Then need to enter the ID number which is always unique
    And selecting my expiry date of the ID Card
    Then selecting the gender has "male"
    Given the dropdown martial status selecting has "married"
    Then need to enter the mobile number which is also unique no
    Then entering the email id of mine
    Given from the dropdown ocupation selecting has "student" 
    Then entering company name has "Test Company"
    And clicking on next button to proceed to fourth page
    Then the page is listed with title "<title>"
    Then Entering the House number and street no as "house no and street no"
    Given the dropdown to select the province as "Takeo"
    Then seleting the dropdown value for district as "Angkor Borei"
    Then selecting the dropdown value for commune as "Angkor Borei"
    Then selecting the dropdown value for village as "Other"
    And selecting the mailing Addrress indicating it same has permanent
    And clicking on next button to proceed to fifth page
    Given to create the user name which is unique like "Khtest098" 
    Then need to create the password which is also unique like "PassKn098"
    And by entering the same password by confirming the password like "PassKn098"
    And clicking on next button to reate a new user and to proceed to fifth page
    Given the set of radio button need to select mailing address as like "home"
    Then selecting the todays date has appointment 
    Then selecting the first available slots 
    And clicking on next button to submit the appointment and proceed to six page
    Given the review page to review on cliking next button on scrolling down 
    Given to select and accept the terms and conditions for Account
    Then to select and accept the terms and conditions for TC
    Then to select and accept the terms and conditions for fatca
    Then select and perform signature 
    Then clicking on the cofirm button 
    And  clicking on next button to proceed to seventh page
    When Tac Page appeared entering the TAC OTP "<Code>"
    
    Examples: 
		| Code        |
		| khcust900    |