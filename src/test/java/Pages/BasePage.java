package Pages;

import Driver.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()),this);
    }
}
