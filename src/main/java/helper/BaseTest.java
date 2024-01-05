package helper;

import Driver.AppDriver;
import Driver.AppDriverFactory;
import base.AppData;
import base.AppiumServer;
import io.appium.java_client.InteractsWithApps;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import utils.Util;

import java.io.IOException;
import java.net.MalformedURLException;


//enable=false - prioritize=1 - dependsOnMethods=MethodeName - alwaysRun=true ignoriert dependency -
public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void serverStart() throws Exception {
        System.out.println("before suite");
       // AppData.platform = System.getProperty("platform",platform);
        //System.out.println("Local variable: "+ AppData.platform);
        //AppiumServer.start();
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"platform"})
    public void startAppiumServer(@Optional("ios") String platform){
        System.out.println("BeforeClass method");
        System.out.println("Plaform value in BeforeClass: "+platform);
        AppiumServer.start(platform);

    }

    @BeforeMethod (alwaysRun = true)
    @Parameters({"platform"})
    public void launchApp(@Optional("ios") String platform) throws Exception {
        System.out.println("before method");
        System.out.println("launch app for: "+platform);
        AppDriverFactory.launchApp(platform);
    }

    @AfterMethod(alwaysRun = true)
    @Parameters({"platform"})
    public void closeApp(@Optional("ios") String platform, ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("after method");
            Util.getScreenshot(result.getTestName());
            AppDriverFactory.terminateApp(platform);
        }
        else {
            AppDriverFactory.terminateApp(platform);
            System.out.println("Closed following platform"+platform);
        }
        //AppDriver.getCurrentDriver().quit();
        //base.AppiumServer.stop();
    }

    @AfterSuite(alwaysRun = true)
    @Parameters({"platform"})
    public void serverStop(@Optional("ios") String platform){
        AppiumServer.stop(platform);
    }


    /*
    @BeforeMethod(alwaysRun = true)
    @Parameters({"platform"})
    public void serverStart(String platform){
        System.out.println("before method");
        AppData.platform = System.getProperty("platform",platform);
        System.out.println("Local variable: "+ AppData.platform);
        appiumServer.start();
        System.out.println("Appium Server triggered for "+ AppData.platform);
    }*/

    /* //local execution
    @BeforeSuite(alwaysRun = true)
    public void serverStart(){
        System.out.println("before suite");
        AppData.platform = System.getProperty("platform","ios");
        System.out.println("Local variable: "+ AppData.platform);
        AppiumServer.start();
        System.out.println("Appium Server triggered for "+ AppData.platform);
    }*/
}
