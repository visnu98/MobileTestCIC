package Driver;

import base.AppData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class AppDriverFactory {
    //static AppiumDriver driver;

    public static void launchApp(String platform) throws Exception {
        AppiumDriver  driver;

        switch (platform){
            case "android":
                UiAutomator2Options aoptions = new UiAutomator2Options();
                aoptions.setDeviceName(AppData.androidDeviceName)
                        .setPlatformVersion(AppData.androidPlatFormVersion)
                        .setAppPackage(AppData.androidAppPackage)
                        .setAppActivity(AppData.androidAppActivity)
                        .setNoReset((Boolean.parseBoolean(AppData.androidNoReset)));

                //.setCapability("autoWebview",true);

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), aoptions);
                AppDriver.setDriver(driver);
                System.out.println("AndroidDriver is set");
                break;
            case "ios":
                XCUITestOptions ioptions = new XCUITestOptions();
                ioptions.setDeviceName(AppData.iOSDeviceName)
                        .setPlatformVersion(AppData.iOSPlatFormVersion)
                        .setApp(AppData.iOSAppPackage)
                        .setUdid(AppData.iOSUdid)
                        .setNoReset((Boolean.parseBoolean(AppData.iOSNoReset)));

                driver = new IOSDriver(new URL("http://127.0.0.1:4722/"), ioptions);
                AppDriver.setDriver(driver);
                System.out.println("IOSDriver is set");
                break;
            default:
                throw new Exception("Invalid Platform" + AppData.platform);
        }
    }


    public static void terminateApp(String platform) throws Exception {


        if (Objects.equals(platform, "ios")){
            ((IOSDriver) AppDriver.getCurrentDriver()).terminateApp(AppData.iOSAppPackage);
        }
        else if (Objects.equals(platform, "android")) {
            ((AndroidDriver) AppDriver.getCurrentDriver()).terminateApp(AppData.androidAppPackage);
        }
        else {
            throw new Exception ("Unvalid AppPlatform, cant close the app!");
        }

    }
}
