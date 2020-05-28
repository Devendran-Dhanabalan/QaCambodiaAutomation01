package com.qa.pages;

import com.qa.utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TacPage extends BasePage {
	public int flag = 0;
	@SuppressWarnings("rawtypes")
	public AppiumDriver driver;

	 public static final String TAC_URL = "https://121.120.89.92:444/hlb-kh-api/api/dummy/tac";
	//public static final String TAC_URL = "https://www.edureka.co/community/50974/how-to-verify-page-title-in-selenium";
	//https://121.120.89.99/hlb-my-api/api/utils/tac
	 // public static final String TAC_URL_MY = "https://211.25.68.199/hlb-my-api/api/utils/tac";
	/*
	 * Constructor initializes screen elements
	 */
	@SuppressWarnings("static-access")
	public TacPage()

	{
		/*
		 * this.driver = new Hooks().getDriver(); PageFactory.initElements(new
		 * AppiumFieldDecorator(this.driver), this);
		 */
		 this.driver = new DriverManager().getDriver();
		  PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@iOSXCUITFindBy(id = "Enter TAC to proceed")
	@AndroidFindBy(id = "my.com.hongleongconnect.mobileconnect.ui:id/toolbar_title")
	private MobileElement tacHeader;

	@iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
	@AndroidFindBy(id = "kh.com.hongleongconnect.mobileconnect.sit:id/txt_pin_entry2")
	private MobileElement tacTextField;

	@iOSXCUITFindBy(id = "Resend")
	private MobileElement resendTacBtn;

	public void waitForTacPage() {
		waitForVisibilityOf(tacHeader, driver);
	}

	public void enterSitTac(String username) {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities cap =DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.merge(cap);
		
		WebDriver chromeDriver = new ChromeDriver(chromeOptions);
		chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		chromeDriver.get(TAC_URL);
		
		String title = chromeDriver.getTitle();
		System.out.println("Page title is: " + title.toString());
		
		System.out.println("Web page Contains Login Id: "+username+": "+chromeDriver.getPageSource().contains(username));
		// chromeDriver.findElement(By.xpath("//*[contains(text(),'OTP')]"));
		// System.out.println(chromeDriver.findElement(By.xpath("//*[contains(text(),'OTP')]")));
		//System.out.println(chromeDriver.findElement(By.xpath("/html/body/table/tbody")).isDisplayed());
			
		if (chromeDriver.findElement(By.xpath("//*[contains(text(),'Login Id')]")).isDisplayed()) {
			System.out.println("You are currently on IWAPMG1 network ..");
		
		} else {
			System.out.println("You are currently on IWAPBU network ...so please change network to IWAPMG1");
		} 
		
		WebElement table = chromeDriver.findElement(By.xpath("/html/body/table/tbody"));
		List<WebElement> tableRow = table.findElements(By.tagName("tr"));
		List<String> tacCodes = new ArrayList<>();

		for (int i = 0; i < tableRow.size() - 1; i++)
		{
			List<WebElement> eachRow = (tableRow.get(i + 1)).findElements(By.tagName("td"));
			for (int j = 0; j <= eachRow.size() - 1; j++) {
				WebElement we = eachRow.get(j);
				if (we.getText().equalsIgnoreCase(username)) 
				{
					if (eachRow.get(j + 1).getText().equalsIgnoreCase("OTP"))
					{
						tacCodes.add(eachRow.get(j + 2).getText());
						break;
					}
				}
			}
			if (tacCodes.size() > 0)
				break;
		}
		
		System.out.println("$$$$$-tac is : " + tacCodes.get(0));	
		if (tacCodes.get(0).isEmpty()) {
			System.out.println("Retry : TAC Cannot be found for user name : "+username);
		} else if (tacCodes.get(0) != null) {
			System.out.println("Recevied: Tac code is: "+ tacCodes.get(0) +" for user name :"+username );

		}
		System.out.println("$$$$$-tac is : " + tacCodes.get(0));
		
		// Calling the input text for entering tac in tac page with locators has tacTextField
		inputText(tacCodes.get(0), tacTextField, driver);
		chromeDriver.quit();
		// enterSecurityAnswer();
	}
	
	public void proceedWithTac(String platform,String username) {
	if (System.getProperty("platform").equalsIgnoreCase(platform)) {
		enterSitTac(username);
		
	}
}
	/*
	 * public void enterSecurityAnswer() { SecurityQuestionPage securityQuestionPage
	 * = new SecurityQuestionPage(); if(securityQuestionPage.checkForSecurityPage())
	 * { securityQuestionPage.enterSecurityAnswer(); } }
	 */
}

