package Pages.Navigation;

import Pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MenuStackPage extends BasePage {

    @iOSXCUITFindBy(accessibility = "Abmelden")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Abmelden\"]")
    public WebElement logoutBtn;

    @iOSXCUITFindBy(id = "ACCOUNTS")
    @AndroidFindBy(id = "ACCOUNTS")
    public WebElement vermögenExpand;

    @iOSXCUITFindBy(id = "PAYMENTS")
    @AndroidFindBy(id = "PAYMENTS")
    public WebElement zahlungenExpand;

    @iOSXCUITFindBy(id = "TRADING")
    @AndroidFindBy(id= "TRADING")
    public WebElement anlagenExpand;

    @iOSXCUITFindBy(id = "PENSIONS")
    @AndroidFindBy(id = "PENSIONS")
    public WebElement vorsorgenExpand;

    @iOSXCUITFindBy(id = "DOCUMENTS")
    @AndroidFindBy(id = "DOCUMENTS")
    public WebElement dokumenteExpand;

    @iOSXCUITFindBy(id = "NEWS")
    @AndroidFindBy(id = "NEWS")
    public WebElement newsExpand;

    @iOSXCUITFindBy(id = "SERVICE")
    @AndroidFindBy(id = "SERVICE")
    public WebElement servicesExpand;

    @iOSXCUITFindBy(id = "SETTINGS_ROOT")
    @AndroidFindBy(id = "SETTINGS_ROOT")
    public WebElement einstellungenExpand;

    public void performLogOut(){
        logoutBtn.click();
    }

}
