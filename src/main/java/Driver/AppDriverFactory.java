package Driver;

import base.AppData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utils.EnvironmentHandler;
import utils.JsonReader;
import utils.OSHandler;

import java.net.URL;
import java.util.Objects;

public class AppDriverFactory {
    //static AppiumDriver driver;

    public static void launchApp(String device) throws Exception {
        AppiumDriver  driver;
        device ="resources/config/"+device+".json";


        switch (OSHandler.getCurrentOS()){
            case "android":

                UiAutomator2Options aoptions = new UiAutomator2Options();
                aoptions.setDeviceName(JsonReader.getTestData("androidDeviceName", device))
                        .setPlatformVersion(JsonReader.getTestData("androidPlatFormVersion", device))
                        .setAppPackage(EnvironmentHandler.getEnvironment())
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
                        .setApp(EnvironmentHandler.getEnvironment())
                        .setUdid(JsonReader.getTestData("iOSUdid", device))
                        .setNoReset((Boolean.parseBoolean(AppData.iOSNoReset)));
                driver = new IOSDriver(new URL(JsonReader.getTestData("iOSappiumUrl", device)), ioptions);
                AppDriver.setDriver(driver);
                System.out.println("IOSDriver is set");
                break;
            default:
                throw new Exception("Invalid Platform" + OSHandler.getCurrentOS());
        }
    }


    public static void terminateApp() throws Exception {


        if (OSHandler.getCurrentOS().equalsIgnoreCase("ios")){
            ((IOSDriver) AppDriver.getCurrentDriver()).terminateApp(EnvironmentHandler.getEnvironment());
            System.out.println("Following App closed: "+OSHandler.getCurrentOS()+ EnvironmentHandler.getEnvironment());
            AppDriver.closeDriver();
        }
        else if (OSHandler.getCurrentOS().equalsIgnoreCase("android")) {
            ((AndroidDriver) AppDriver.getCurrentDriver()).terminateApp(EnvironmentHandler.getEnvironment());
            System.out.println("Following App closed: "+OSHandler.getCurrentOS()+ EnvironmentHandler.getEnvironment());
            AppDriver.closeDriver();
        }
        else {
            throw new Exception ("Unvalid AppPlatform, cant close the app!");
        }

    }
}
