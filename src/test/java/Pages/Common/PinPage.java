package Pages.Common;

import Driver.AppDriver;
import Pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import utils.OSHandler;

public class PinPage extends BasePage {

    //Passcode field
    //XCUIElementTypeSecureTextField
    //(//XCUIElementTypeSecureTextField[@name="Passcode field"])[1]
    @AndroidFindBy(id = "com.samsung.android.biometrics.app.setting:id/lockPassword")
    @iOSXCUITFindBy(accessibility = "Passcode field")
    public WebElement pinField;

    @AndroidFindBy(id ="com.samsung.android.biometrics.app.setting:id/btn_cancel")
    @iOSXCUITFindBy(xpath ="(//XCUIElementTypeButton[@name=\"Cancel\"])[2]")
    public WebElement cancelBtn;

    @AndroidFindBy(id ="com.samsung.android.biometrics.app.setting:id/btn_continue")
    public WebElement continueBtn;

    public void enterPin(int pin){
        pinField.sendKeys("123456");
        if(OSHandler.getCurrentOS().equalsIgnoreCase("android")){
            ((AndroidDriver)AppDriver.getCurrentDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        }

    }


}
