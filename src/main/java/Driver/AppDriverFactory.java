package Driver;

import base.AppData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import utils.Environment;
import utils.JsonReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class AppDriverFactory {
    //static AppiumDriver driver;

    public static void launchApp(String platform, String device) throws Exception {
        AppiumDriver  driver;
        device ="resources/config/"+device+".json";


        switch (platform){
            case "android":

                UiAutomator2Options aoptions = new UiAutomator2Options();
                aoptions.setDeviceName(JsonReader.getTestData("androidDeviceName", device))
                        .setPlatformVersion(JsonReader.getTestData("androidPlatFormVersion", device))
                        .setAppPackage(Environment.getEnvironment())
                        .setAppActivity(AppData.androidAppActivity)
                        .setNoReset((Boolean.parseBoolean(AppData.androidNoReset)));

                driver = new AndroidDriver(new URL(JsonReader.getTestData("androidAppiumUrl", device)), aoptions);
                AppDriver.setDriver(driver);
                System.out.println("AndroidDriver is set");
                break;
            case "ios":
                XCUITestOptions ioptions = new XCUITestOptions();
                ioptions.setDeviceName(JsonReader.getTestData("iOSDeviceName", device))
                        .setPlatformVersion(JsonReader.getTestData("iOSPlatFormVersion", device))
                        .setApp(Environment.getEnvironment())
                        .setUdid(JsonReader.getTestData("iOSUdid", device))
                        .setNoReset((Boolean.parseBoolean(AppData.iOSNoReset)));
                driver = new IOSDriver(new URL(JsonReader.getTestData("iOSappiumUrl", device)), ioptions);
                AppDriver.setDriver(driver);
                System.out.println("IOSDriver is set");
                break;
            default:
                throw new Exception("Invalid Platform" + platform);
        }
    }


    public static void terminateApp(String platform) throws Exception {


        if (Objects.equals(platform, "ios")){
            ((IOSDriver) AppDriver.getCurrentDriver()).terminateApp(Environment.getEnvironment());
            System.out.println("Following App closed: "+platform+Environment.getEnvironment());
            AppDriver.closeDriver();
        }
        else if (Objects.equals(platform, "android")) {
            ((AndroidDriver) AppDriver.getCurrentDriver()).terminateApp(Environment.getEnvironment());
            System.out.println("Following App closed: "+platform+Environment.getEnvironment());
            AppDriver.closeDriver();
        }
        else {
            throw new Exception ("Unvalid AppPlatform, cant close the app!");
        }

    }
}
