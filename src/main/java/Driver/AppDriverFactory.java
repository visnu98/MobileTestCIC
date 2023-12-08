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

public class AppDriverFactory {
    //static AppiumDriver driver;
/*
    private static void android_launchApp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("R3CT60241ZM")
                .setPlatformVersion("14.0")
                .setAppPackage("ch.cic.mobilebanking.test")
                .setAppActivity("ch.ti8m.cic.mobilebanking.frontend.android.main.MainActivity")
                .setNoReset(true)
                .setCapability("printPageSourceOnFindFailure",true);
                //.setCapability("autoWebview",true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    } */
/*
    private static void ios_launchApp() throws MalformedURLException, MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14")
                .setPlatformVersion("16.2")
                .setBundleId("com.saucelabs.mydemoapp.rn")
                .setNoReset(true);

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        AppDriver.setDriver(driver);
        System.out.println("IOSDriver is set");
    } */

    public static void launchApp() throws Exception {

        AppiumDriver  driver;

        switch (AppData.platform){
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

                driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), ioptions);
                AppDriver.setDriver(driver);
                System.out.println("IOSDriver is set");
                break;
            default:
                throw new Exception("Invalid Platform" + AppData.platform);
        }



/*
        System.out.println("entering into launchapp");
        if(AppData.platform.contains("ios")){
            ios_launchApp();
            System.out.println("iOS App launched...");
        }else
        if(AppData.platform.contains("android")){
            android_launchApp();
            System.out.println("Android App launched...");
        }else
            throw new SkipException("Enter valid platform value, android/ios");*/
    }


    public static void terminateApp() throws Exception {

        /*if (AppData.platform="ios"){


            ((IOSDriver) AppDriver.getCurrentDriver()).terminateApp(AppDriver.getCurrentDriver().getCapabilities());
        }
*/


    }
}
