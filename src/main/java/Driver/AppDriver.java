package Driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public class AppDriver {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    private static AppDriver instance = null;

    private AppDriver(){

    }

    public static AppDriver getInstance(){
        if(instance==null){
           // return instance;
           instance = new AppDriver();
        }
        return instance;
    }

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public static AppiumDriver getCurrentDriver(){
        return getInstance().getDriver();
    }

    public static void setDriver(AppiumDriver Driver){
        driver.set(Driver);
        System.out.println("Driver is set");
    }

    public static void closeDriver(){
        getCurrentDriver().quit();
        System.out.println("Current Driver closed!");
    }
}
