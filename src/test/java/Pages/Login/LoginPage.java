package Pages.Login;

import Pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBys;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {


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

}
