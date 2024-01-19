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
    //android.widget.Button[@text="Anmelden"]
    @AndroidFindBy(className = "android.widget.CheckBox")
    @iOSXCUITFindBy(className = "XCUIElementTypeSwitch")
    public WebElement saveCredTgl;

    public void performLogin(String username, String password){
        toggleOff();
        usernameInputField.click();
        usernameInputField.sendKeys(username);
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        loginBtn.click();
    }

    public void performLoginAndSaveCredentials(String username, String password){
        toggleOn();
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

    // Toggle Methoden gegebenfalls auf Util ebene deklarieren und WebElemente als Paramter mitgeben!

    //Returns toggle state -> true = toggle On
    public boolean toggleState(){
        boolean state = Boolean.parseBoolean(null);
        if (OSHandler.getCurrentOS().equalsIgnoreCase("ios")){
            state = Objects.equals("1",saveCredTgl.getAttribute("value"));
        }
        else if (OSHandler.getCurrentOS().equalsIgnoreCase("android")){
            state = Boolean.parseBoolean(saveCredTgl.getAttribute("checked"));
        }
        else {
            System.out.println("Could not get the state of the toggle!");
        }
        return state;
    }

    //Turns toggle on (if not already on)
    public void toggleOn(){
        if(!toggleState()){
            saveCredTgl.click();
        }
    }

    //Turns toggle off (if not already off)
    public void toggleOff(){
        if(toggleState()){
            saveCredTgl.click();
        }
    }

}
