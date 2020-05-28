package com.qa.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import com.qa.pages.*;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//////////////New By May 09////////////
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
//import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.util.HashMap;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePage {
  
    
    @iOSXCUITFindBy(id="Auto renew with the same tenor")
    @AndroidFindBy(id="my.com.hongleongconnect.mobileconnect.uat:id/toolbar_title")
    private MobileElement title_screen_message;
    
    @iOSXCUITFindBy(id="Auto renew with the same tenor")
    @AndroidFindBy(id="my.com.hongleongconnect.mobileconnect.uat:id/snackbar_text")
    private MobileElement snackbar;

    @iOSXCUITFindBy(id="Auto renew with the same tenor")
    @AndroidFindBy(id="my.com.hongleongconnect.mobileconnect.uat:id/accountBalance")
    private MobileElement acc_bal;
    
    @iOSXCUITFindBy(id="Auto renew with the same tenor")
    @AndroidFindBy(id="my.com.hongleongconnect.mobileconnect.uat:id/totalAmountLabel")
    private MobileElement total_amt_label;
    
    @iOSXCUITFindBy(id="Auto renew with the same tenor")
    @AndroidFindBy(id="my.com.hongleongconnect.mobileconnect.uat:id/totalAmount")
    private MobileElement total_amt;
    
    private AppiumDriver<?> driver;
    TestUtils utils = new TestUtils();
    
	  public BasePage(){ 
		  this.driver = new DriverManager().getDriver();
	  PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	  }
	 

    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(MobileElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();
    }

    public void click(By e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        driver.findElement(e).click();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void sendKeys(MobileElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public String getText(MobileElement e, String msg) {
        String txt;
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        utils.log().info(msg + txt);
        return txt;
    }

    public String getText(By e, String msg) {
        String txt;
        switch(new GlobalParams().getPlatformName()){
            case "Android":
                txt = getAttribute(e, "text");
                break;
            case "iOS":
                txt = getAttribute(e, "label");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        utils.log().info(msg + txt);
        return txt;
    }

    public void closeApp() {
        ((InteractsWithApps) driver).closeApp();
    }

    public void launchApp() {
        ((InteractsWithApps) driver).launchApp();
    }

    public MobileElement andScrollToElementUsingUiScrollable(String childLocAttr, String childLocValue) {
        return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector()."+ childLocAttr +"(\"" + childLocValue + "\"));");
    }

    public MobileElement iOSScrollToElementUsingMobileScroll(MobileElement e) {
        RemoteWebElement element = ((RemoteWebElement) e);
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
//	  scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        driver.executeScript("mobile:scroll", scrollObject);
        return e;
    }

    public By iOSScrollToElementUsingMobileScrollParent(MobileElement parentE, String predicateString) {
        RemoteWebElement parent = (RemoteWebElement)parentE;
        String parentID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", parentID);
//	  scrollObject.put("direction", "down");
	  scrollObject.put("predicateString", predicateString);
//	  scrollObject.put("name", "test-ADD TO CART");
//        scrollObject.put("toVisible", "sdfnjksdnfkld");
        driver.executeScript("mobile:scroll", scrollObject);
        By m = MobileBy.iOSNsPredicateString(predicateString);
        System.out.println("Mobilelement is " + m);
        return m;
    }

    public MobileElement scrollToElement(MobileElement element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }

    public By scrollToElement(By element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }

    public boolean find(final MobileElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (element.isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean find(final By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (driver.findElement(element).isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("rawtypes")
	public void swipe(int startX, int startY, int endX, int endY, int millis)
            throws InterruptedException {
        TouchAction t = new TouchAction(driver);
        t.press(point(startX, startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point(endX, endY)).release()
                .perform();
    }
    
    ////////////////////Newly Added on may 09///////////////////////
	public void inputText(String inputText, MobileElement mobileElement,
			@SuppressWarnings("rawtypes") AppiumDriver driver) {
		mobileElement.clear();
		mobileElement.sendKeys(inputText);
		if (driver.getKeyboard() != null) {
			closeKeyboard(driver); //22may commenting for debugging for null pointer error
		}
	}
	/**
	 * Method used to click button elements
	 * @param mobileElement
	 * @param driver
	 */
	public void clickButton(MobileElement mobileElement, @SuppressWarnings("rawtypes") AppiumDriver driver) {
		waitForVisibilityOf(mobileElement, driver);
		mobileElement.click();
	}

	/**
	 * Method used to get text
	 * @param mobileElement
	 * @return
	 */
	public String getText(MobileElement mobileElement) {
		return mobileElement.getText();
	}
	/**
	 * Method used to wait for visibility of element
	 * @param mobileElement
	 * @param driver
	 */
	protected void waitForVisibilityOf(MobileElement mobileElement, @SuppressWarnings("rawtypes") AppiumDriver driver) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 70);
		webDriverWait.until(ExpectedConditions.visibilityOf(mobileElement));
	}
	/**
	 * Method used to wait for availability of element
	 * @param mobileElement
	 * @param driver
	 */
	protected void waitForAvailabilityOf(MobileElement mobileElement,
			@SuppressWarnings("rawtypes") AppiumDriver driver) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 70);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(mobileElement));
	}
	protected void waitForVisibilityOfShort(MobileElement mobileElement,
			@SuppressWarnings("rawtypes") AppiumDriver driver) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
		webDriverWait.until(ExpectedConditions.visibilityOf(mobileElement));
	}
	/**
	 * Method used to close keyboard or hide keyboard
	 * @param driver
	 */
	protected void closeKeyboard(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		if (driver.getKeyboard() != null) {
			if (new GlobalParams().getPlatformName().equalsIgnoreCase("ios")) {
				try {
					MobileElement doneToolBarButton = (MobileElement) driver.findElement(By.id("Toolbar Done Button"));
					if (doneToolBarButton.isDisplayed()) {
						doneToolBarButton.click();
					}
				} catch (NoSuchElementException | TimeoutException e) {

					System.err.println("---------- Skipping clicking Done Button as its not present ----------- ");
				}
			} else {
				driver.hideKeyboard();
			}
		}
	}
	/**
	 * Method used to swipe right gesture
	 * @param driver
	 */
	public void swipeRight(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.9);
		int endx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			new AndroidTouchAction(driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release().perform();
		} else {
			new IOSTouchAction(driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release().perform();
		}
	}
	/**
	 * Method used to swipe ios
	 * @param driver
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 */
	public void swipeiOS(@SuppressWarnings("rawtypes") AppiumDriver driver, int startx, int starty, int endx,
			int endy) {
		new IOSTouchAction(driver).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, endy))
				.release().perform();
	}
	/**
	 * Method used to swipe android
	 * @param driver
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 */
	public void swipeAndroid(@SuppressWarnings("rawtypes") AppiumDriver driver, int startx, int starty, int endx,
			int endy) {
		new AndroidTouchAction(driver).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(05))).moveTo(PointOption.point(endx, endy))
				.release().perform();
	}
	/**
	 * Method used to swipeup
	 * @param driver
	 */
	public void swipeUp(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.9);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			swipeAndroid(driver, startx, starty, startx, endy);
		} else {
			swipeiOS(driver, startx, starty, startx, endy);
		}
	}
	/**
	 * Method used to swipe by screen layout
	 * @param driver
	 * @param mobileElement
	 * @throws InterruptedException 
	 */
	public void swipeUpByLayout(@SuppressWarnings("rawtypes") AppiumDriver driver, MobileElement mobileElement)  {
		Dimension size = mobileElement.getSize();
		int starty = (int) (size.height * 0.9);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			swipeAndroid(driver, startx, starty, startx, endy);
		} else {
			swipeiOS(driver, startx, starty, startx, endy);
		}
	}
	/**
	 * Method used to swipe down using screen layout
	 * @param driver
	 * @param mobileElement
	 */
	public void swipeDownByLayout(@SuppressWarnings("rawtypes") AppiumDriver driver, MobileElement mobileElement) {
		Dimension size = mobileElement.getSize();
		int starty = (int) (size.height * 0.5);
		int endy = (int) (size.height * 0.9);
		int startx = size.width / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			swipeAndroid(driver, startx, starty, startx, endy);
		} else {
			swipeiOS(driver, startx, starty, startx, endy);
		}
	}
	
	public void swipeDownByLayoutDOB(@SuppressWarnings("rawtypes") AppiumDriver driver, MobileElement mobileElement) {
		Dimension size = mobileElement.getSize();
		int starty = (int) (size.height * 0.5);
		int endy = (int) (size.height * 0.9);
		int startx = size.width / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			swipeAndroid(driver, startx, starty, startx, endy);
			swipeAndroid(driver, startx, starty, startx, endy);
			swipeAndroid(driver, startx, starty, startx, endy);
			swipeAndroid(driver, startx, starty, startx, endy);
			swipeAndroid(driver, startx, starty, startx, endy);
			swipeAndroid(driver, startx, starty, startx, endy);
		} else {
			swipeiOS(driver, startx, starty, startx, endy);
		}
	}
	
	/**
	 * Method used to swipe right using layout
	 * @param driver
	 * @param swiperLayout
	 */
	public void swipeRightByLayout(@SuppressWarnings("rawtypes") AppiumDriver driver, MobileElement swiperLayout) {
		Dimension size = swiperLayout.getSize();
		int startx = (int) (size.width * 0.9);
		int endx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			new AndroidTouchAction(driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release().perform();
		} else {
			new IOSTouchAction(driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release().perform();
		}
	}
	/**
	 * Method used to swipe left by screen layout
	 * @param driver
	 * @param swiperLayout
	 */
	public void swipeLeftByLayout(@SuppressWarnings("rawtypes") AppiumDriver driver, MobileElement swiperLayout) {
		Dimension size = swiperLayout.getSize();
		int endx = (int) (size.width * 0.9);
		int startx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			new AndroidTouchAction(driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release().perform();
		} else {
			new IOSTouchAction(driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release().perform();
		}
	}
	/**
	 * Method used to swipe left
	 * @param driver
	 */
	public void swipeLeft(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		Dimension size = driver.manage().window().getSize();
		int endx = (int) (size.width * 0.9);
		int startx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			new AndroidTouchAction(driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release();
		} else {
			new IOSTouchAction(driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release();
		}
	}
	/**
	 * Method used to swipe right until element present in layout
	 * @param mobileElement
	 * @param swiperLayout
	 * @param driver
	 * @return
	 */
	public boolean swipeRightUntilElementPresentInLayout(MobileElement mobileElement, MobileElement swiperLayout,
			@SuppressWarnings("rawtypes") AppiumDriver driver) {
		for (int i = 0; i <4; i++) {
			if (!isElementPresentFully(mobileElement, driver)) {
				swipeRightByLayout(driver, swiperLayout);
				System.err.println("Swipe Right: " + i);
			} else {
				return true;
			}
		}
		return false;
	}
	/**
	 * Method used to swipe left until element present in layout
	 * @param mobileElement
	 * @param swiperLayout
	 * @param driver
	 * @return
	 */
	public boolean swipeLeftUntilElementPresentInLayout(MobileElement mobileElement, MobileElement swiperLayout,
			@SuppressWarnings("rawtypes") AppiumDriver driver) {
		for (int i = 0; i < 4; i++) {
			if (!isElementPresentFully(mobileElement, driver)) {
				swipeLeftByLayout(driver, swiperLayout);
				System.err.println("Swipe Left: " + i);
			} else {
				return true;
			}
		}
		return false;
	}
	/**
	 * Method used to swipe left until the element present
	 * @param mobileElement
	 * @param driver
	 */
	public void swipeLeftUntilElementPresent(MobileElement mobileElement,
			@SuppressWarnings("rawtypes") AppiumDriver driver) {
		do {
			swipeLeft(driver);
		} while (!isElementPresent(mobileElement));
	}
	/**
	 * Method used to swipe right until element present
	 * @param mobileElement
	 * @param driver
	 */
	public void swipeRightUntilElementPresent(MobileElement mobileElement,
			@SuppressWarnings("rawtypes") AppiumDriver driver) {

		do {
			swipeLeft(driver);
		} while (!isElementPresent(mobileElement));
	}
	/**
	 * Method used to verify element present
	 * @param mobileElement
	 * @return true
	 */
	public boolean isElementPresent(MobileElement mobileElement) {
		try {
			if (mobileElement.isDisplayed())
				return true;
		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
		return false;
	}
	/**
	 * Method used to verify element present fully
	 * @param mobileElement
	 * @param driver
	 * @return
	 */
	public boolean isElementPresentFully(MobileElement mobileElement,
			@SuppressWarnings("rawtypes") AppiumDriver driver) {
		if (isElementPresent(mobileElement)) {
			Dimension screenDimension = driver.manage().window().getSize();
			Point elementPoint = mobileElement.getLocation();
			if (screenDimension.getWidth() - elementPoint.getX() > 200) {
				System.err.println("Screen Point X : " + screenDimension.getWidth());
				System.err.println("Mobile Element Point X : " + elementPoint.getX());
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	/**
	 * Method used to click button by swipeup
	 * @param mobileElement
	 * @param driver
	 */
	public void clickButtonBySwipeUp(MobileElement mobileElement, @SuppressWarnings("rawtypes") AppiumDriver driver) {
		if (isElementPresent(mobileElement)) {
			clickButton(mobileElement, driver);
		} else {
			swipeUp(driver);
			clickButton(mobileElement, driver);
		}
	}
	/**
	 * Method used to click button swipe up on layout
	 * @param mobileElement
	 * @param driver
	 * @param layout
	 * @throws InterruptedException 
	 */
	public void clickButtonBySwipeUpOnLayout(MobileElement mobileElement,
			@SuppressWarnings("rawtypes") AppiumDriver driver, MobileElement layout)  {
		swipeUpByLayout(driver, layout);
		clickButton(mobileElement, driver);
		
	}
///////////////////////////////////////////////////////////////////////////
	//#Assert functions which is need for testing#// By dperiaswamy //
///////////////////////////////////////////////////////////////////////////
	
	// clickButtonBySwipeDownOnLayout by dperiaswamy on 14 may 2020
	public void clickButtonBySwipeDownOnLayoutDOB(MobileElement mobileElement,
			@SuppressWarnings("rawtypes") AppiumDriver driver, MobileElement layout) {
		swipeDownByLayoutDOB(driver, layout);
		//swipeDownByLayout(driver, layout);
		clickButton(mobileElement, driver);
		
	}
	
	/**
	 * Method used to verify error msg json
	 * @param expectedError
	 * @throws Throwable
	 */
	public void verifyErrorMsgjson(Object expectedError) throws Throwable {
		System.out.println("Verify that the actual error message is matching the expected one");
		String actualError = getText(snackbar);

		System.out.println("The expected error message is: " + expectedError);
		System.out.println("The actual shown error message is: " + actualError);
		Assert.assertTrue(actualError.equalsIgnoreCase((String) expectedError));
	}
	/**
	 * Method used to assert error message
	 * @param expectedError
	 * @throws Throwable
	 */
	public void verifyErrorMsg(String expectedError) throws Throwable {
		System.out.println("Verify that the actual error message is matching the expected one");
		String actualError = getText(snackbar);
		System.out.println("The expected error message is: " + expectedError);
		System.out.println("The actual shown error message is: " + actualError);
		Assert.assertTrue(actualError.equalsIgnoreCase(expectedError));
	}
	/**
	 * Method used to verify or assert field label
	 * @param expectedError
	 * @param element
	 * @throws Throwable
	 */
	public void verifylabel(String expectedError, MobileElement element) throws Throwable {
		System.out.println("Verify that the actual label message is matching the expected one");
		String actualError = getText(element);
		System.out.println("The expected label  is: " + expectedError);
		System.out.println("The actual shown label  is: " + actualError);
		Assert.assertTrue(actualError.equalsIgnoreCase(expectedError));
	}
	/**
	 * Method used to verify or assert the title
	 * @param expectedtitle
	 */
	public void verifytitle(String expectedtitle) {
		System.out.println("Verify that the actual title message is matching the expected one");
		String actualtitle = getText(title_screen_message);
		System.out.println("The expected title  is: " + expectedtitle);
		System.out.println("The actual shown tilte  is: " + actualtitle);
		Assert.assertTrue(actualtitle.equalsIgnoreCase(expectedtitle));
	}
	/**
	 * Method used to verify total amount field
	 * @param expectedtitle
	 */
	public void verify_total_amount(String expectedtitle) {
		System.out.println("Verify that the actual total amount label is matching the expected one");
		String actualtitle = getText(total_amt_label);
		System.out.println("The expected title  is: " + expectedtitle);
		System.out.println("The actual total amount label  is: " + actualtitle);
		Assert.assertTrue(actualtitle.equalsIgnoreCase(expectedtitle));
	}
	/**
	 * Method used to get account balance
	 */
	public void get_account_balance() {
		System.out.println("Printing total account balance is displayed on screen");
		String actualtitle = getText(acc_bal);
		System.out.println("The actual shown amount  is: " + actualtitle);
	}
	/**
	 * Method used to get total amount
	 */
	public void get_total_amount() {

		System.out.println("Printing the total amount displayed on confirmation screen");
		String actualtitle = getText(total_amt);
		System.out.println("The actual shown total amount  is: " + actualtitle);
	}
	
	/**
	 * Method to scrollUsingTouchAction using direction by dperiaswamy on Tue 11 may 2020
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void scrollUsingTouchAction(String direction, AppiumDriver driver) {
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getWidth()/2;
		int startY=0;
		int endY=0;
		
		switch(direction) {
		case "up" :
			startY =(int)(dim.getHeight()*0.8);
			endY =(int)(dim.getHeight()*0.2);
			break;
		case "down" :
			startY = (int)(dim.getHeight() * 0.2);
			endY = (int)(dim.getHeight() * 0.8);
			break;
		}
		TouchAction t =new TouchAction(driver);
		t.press(PointOption.point(x,startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		.moveTo(PointOption.point(x,endY))
		.release().perform();
		
	}
	
	/**
	 * Method to scrollToElement by dperiaswamy on Tue 11 may 2020
	 * @throws Exception 
	 * 
	 */
	public void scrollToElementKh(MobileElement element, String direction) throws Exception
	{
		for (int i =0; i<=3;i++)
		{
			if (isElementPresent(element))
			{ break;
			}
			else
			{
				if(direction.equalsIgnoreCase("up")) {
					scrollToElement(element, "up");
				}else{
					scrollToElement(element, "down");
				}
				
			}
		}
	}
	
	/**
	 * Method to find element by scrolling it with wait by dperiaswamy on Tue 11 may 2020
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public void scrollToElement(WebDriver driver ,String text) {
		((FindsByAndroidUIAutomator)driver)
		.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".scrollable(true).instance(0).scrollIntoView(new uiSelector().text(\""+text+"\").instance(0))");
		/*
		 * return (MobileElement)((FindsByAndroidUIAutomator)driver).
		 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		 * +".description(\"scrollView\")).scrollIntoView("
		 * +"new UiSelector().description(\"input_company_name\"));");
		 */
		
		/*List<MobileElement> elementsTextContainsTO = ((AndroidDriver<MobileElement>)driver)
				.findElementsByAndroidUIAutomator("new UiSelector().textContains(\"TO\")");
		for(MobileElement element : elementsTextContainsTO) {
			System.out.println("Element - " + element.getText());*/
		//}
	}
	/**
	 * Method to find is displayed with wait by dperiaswamy on Tue 11 may 2020
	 * 
	 */
	public static boolean isDisplayed(final WebElement element, AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait= new WebDriverWait(driver, 2);
			driver.findElement((By)element).isDisplayed();
			return true;
		}
		catch (Exception e) {
			return false;
		}

	}
	
	/**
	 * Method to find a text in dropdown with wait by dperiaswamy on Tue 11 may 2020
	 * 
	 */
	public static void dropdownScrolltillText(AppiumDriver driver,String value) {
		((FindsByAndroidUIAutomator) driver).
		findElementByAndroidUIAutomator("new UiScrollable(newUiSelector())"
				+ ".scrollIntoView(new UiSelector().text(\""+value+"\"))").click();
		}

	
	public void swipeDragRightSignature(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.5);
		int endx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		if (new GlobalParams().getPlatformName().equalsIgnoreCase("android")) {
			new AndroidTouchAction(driver).longPress(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release().perform();
		} else {
			new IOSTouchAction(driver).longPress(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(endx, starty))
					.release().perform();
		}
		
	}
	
	public void enterTacPinForSitKh(String username)
	{
		TacPage tac = new TacPage();
		tac.enterSitTac(username);
	}
}
