package Pages.Login;

import Driver.AppDriver;
import Pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Util;

public class MainPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Neuer Benutzer' or @text='New users']")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name='Neuer Benutzer' or @name='New users']")
    public WebElement newUsersBtn;


    public void navigateToNewUsers(){
        if (Util.doesElementExistXpath(newUsersBtn)){
            newUsersBtn.click();
        }
        else {
            System.out.println("Main page not visible and skipped!");
        }

    }


}
