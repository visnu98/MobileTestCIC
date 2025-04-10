package Driver;

import base.AppData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utils.DeviceHandler;
import utils.EnvironmentHandler;
import utils.OSHandler;

import java.net.URL;

public class AppDriverFactory {
    //static AppiumDriver driver;

    public static void launchApp() throws Exception {
        AppiumDriver  driver;

        switch (OSHandler.getCurrentOS()){
            case "android":
                UiAutomator2Options aoptions = new UiAutomator2Options();
                aoptions.setDeviceName(DeviceHandler.getCurrentDeviceDetail("deviceName"))
                        .setPlatformVersion(DeviceHandler.getCurrentDeviceDetail("platFormVersion"))
                        .setAppPackage(EnvironmentHandler.getEnvironment())
                        .setAppActivity(AppData.androidAppActivity)
                        .setNoReset((Boolean.parseBoolean(AppData.androidNoReset)));

                driver = new AndroidDriver(new URL(DeviceHandler.getCurrentDeviceDetail("appiumUrl")), aoptions);
                AppDriver.setDriver(driver);
                System.out.println("AndroidDriver is set");
                break;
            case "ios":
                XCUITestOptions ioptions = new XCUITestOptions();
                ioptions.setDeviceName(DeviceHandler.getCurrentDeviceDetail("deviceName"))
                        .setPlatformVersion(DeviceHandler.getCurrentDeviceDetail("platFormVersion"))
                        .setApp(EnvironmentHandler.getEnvironment())
                        .setUdid(DeviceHandler.getCurrentDeviceDetail("iOSUdid"))
                        .setNoReset((Boolean.parseBoolean(AppData.iOSNoReset)));
                driver = new IOSDriver(new URL(DeviceHandler.getCurrentDeviceDetail("appiumUrl")), ioptions);
                AppDriver.setDriver(driver);
                System.out.println("IOSDriver is set");
                break;
            default:
                throw new Exception("Invalid Platform" + OSHandler.getCurrentOS());
        }
    }


    public static void terminateApp() throws Exception {


        if (OSHandler.getCurrentOS().equalsIgnoreCase("ios" )){
            ((IOSDriver) AppDriver.getCurrentDriver()).terminateApp(EnvironmentHandler.getEnvironment());
            System.out.println("Platform: "+OSHandler.getCurrentOS()+ " "+EnvironmentHandler.getEnvironment()+" closed!");
            AppDriver.closeDriver();
        }
        else if (OSHandler.getCurrentOS().equalsIgnoreCase("android")) {
            ((AndroidDriver) AppDriver.getCurrentDriver()).terminateApp(EnvironmentHandler.getEnvironment());
            System.out.println("Platform: "+OSHandler.getCurrentOS()+ " "+EnvironmentHandler.getEnvironment()+" closed!");
            AppDriver.closeDriver();
        }
        else {
            throw new Exception ("Unvalid AppPlatform, cant close the app!");
        }

    }
}
