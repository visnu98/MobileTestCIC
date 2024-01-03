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


    AppiumServer appiumServer = new AppiumServer();


    @BeforeMethod (alwaysRun = true)
    public void launchApp() throws Exception {
        System.out.println("before method");
       // AppDriverFactory.launchApp();

        AppDriverFactory.launchApp();
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("after method");
            Util.getScreenshot(result.getTestName());
            AppDriverFactory.terminateApp();
        }
        else {
            AppDriverFactory.terminateApp();
        }
        //AppDriver.getCurrentDriver().quit();
        //base.AppiumServer.stop();
    }

    @BeforeSuite(alwaysRun = true)
    @Parameters({"platform"})
    public void serverStart(String platform){
        System.out.println("before suite");
        AppData.platform = System.getProperty("platform",platform);
        System.out.println("Local variable: "+ AppData.platform);
        appiumServer.start();
    }

    @AfterSuite(alwaysRun = true)
    public void serverStop(){
        appiumServer.stop();
    }
}
