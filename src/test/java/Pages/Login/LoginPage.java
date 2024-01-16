package Pages.Login;

import Driver.AppDriver;
import Pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBys;
import org.openqa.selenium.WebElement;
import utils.OSHandler;
import utils.Util;

import java.util.Objects;


public class LoginPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"tab panel\"]/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    public WebElement nativeBackBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"The entered access data are incorrect.|Die eingegebenen Zugangsdaten sind nicht korrekt.\")")
    @iOSXCUITFindBys(value = { @iOSXCUITBy(id = "alert"), @iOSXCUITBy (className = "XCUIElementTypeStaticText")})
    public WebElement alertBanner;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"username\")")
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    public WebElement usernameInputField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"password\")")
    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    public WebElement passwordInputField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log in' or @text='Anmelden']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log in' or @name='Anmelden']")
    public WebElement loginBtn;

    public void performLogin(String username, String password){
        usernameInputField.click();
        usernameInputField.sendKeys(username);
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        loginBtn.click();
    }

    public void navigateToMainPage (){
        if (Util.doesElementExistXpath(usernameInputField)){
            if (Objects.equals(OSHandler.getCurrentOS(), "android")) {
                AppDriver.getCurrentDriver().navigate().back();
            } else if (Objects.equals(OSHandler.getCurrentOS(), "ios")) {
                nativeBackBtn.click();
            }
            else {
                System.out.println("Wrongly defined OS for Backbutton!");
            }
        }
        else {
            System.out.println("LoginPage was not visible and skipped!");
        }
    }

}
