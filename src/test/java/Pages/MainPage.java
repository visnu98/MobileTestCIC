package Pages;

import Driver.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Util;

public class MainPage extends BasePage{


    public MainPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()),this);
    }



    @AndroidFindBy(xpath = "//android.widget.Button[@text='Neuer Benutzer' or @text='New users']")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name='Neuer Benutzer' or @name='New users']")
    public WebElement newUsersBtn;


    public boolean validateMainPage(){
        if (newUsersBtn.isDisplayed()){
            return true;
        }
        else {
            System.out.println("Could not validate MainPage, following button is missing:"+newUsersBtn);
            return false;
        }
    }


    public void navigateToNewUsers(){
        if (Util.isExistXpath(newUsersBtn)){
            newUsersBtn.click();
        }
        else {
            System.out.println("Main page not visible and skipped!");
        }

    }


}
