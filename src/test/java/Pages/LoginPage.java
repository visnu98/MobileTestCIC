package Pages;

import Driver.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"username\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public WebElement usernameInputField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"password\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    public WebElement passwordInputField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Log in\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Log in\"]")
    public WebElement loginBtn;


    public void peformLogin(String username, String password){
        usernameInputField.click();
        usernameInputField.sendKeys(username);
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        loginBtn.click();
    }



}
