package Pages.Login;

import Driver.AppDriver;
import Pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ElementWaitHandler;
import utils.JsonReader;
import utils.Util;

public class LandingPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Dashboard\"]")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"Dashboard\"]")
    public WebElement dashboardStack; // Dashboard Butten unten im Stack

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Zahlen\"]")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"Zahlen\"]")
    public WebElement paymentStack; // Zahlen Butten unten im Stack

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Anlegen\"]")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"Anlegen\"]")
    public WebElement investmentStack; // Anlegen Butten unten im Stack

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Menu\"]")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"Menu\"]")
    public WebElement menuStack; // Menu Butten unten im Stack

    public boolean validateLandingPage() throws Exception {
        //Takes default server waiting time and adds 5 seconds to wait more, since it takes longer to load the landing screen.
        long sec = JsonReader.getTimeOutFromServerConfig()/1000+5;
        if (ElementWaitHandler.waitUntilElementVisibleB(dashboardStack,sec)){
            return true;
        }
        else {
            System.out.println("Could not validate LandingPage, following button is missing:"+dashboardStack);
            return false;
        }
    }




}
