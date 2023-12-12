package helper;

import Driver.AppDriver;
import Driver.AppDriverFactory;
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

    @BeforeMethod
    public void launchApp() throws Exception {
        System.out.println("before method");
        AppDriverFactory.launchApp();
    }

    @AfterMethod
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

    @BeforeSuite
    public void serverStart(){
        System.out.println("before suite");
        base.AppiumServer.start();
    }

    @AfterSuite
    public void serverStop(){
        base.AppiumServer.stop();
    }
}
