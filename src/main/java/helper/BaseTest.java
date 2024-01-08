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
import utils.Environment;
import utils.Util;

import java.io.IOException;
import java.net.MalformedURLException;


//enable=false - prioritize=1 - dependsOnMethods=MethodeName - alwaysRun=true ignoriert dependency -
public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void serverStart() throws Exception {
        System.out.println("before suite");
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"platform"})
    public void startAppiumServer(@Optional("ios") String platform){
        System.out.println("BeforeClass method");
        System.out.println("Plaform value in BeforeClass: "+platform);
        AppiumServer.start(platform);

    }

    @BeforeMethod (alwaysRun = true)
    @Parameters({"platform","device", "env"})
    public void launchApp(@Optional("ios") String platform, @Optional("iPhone14Plus") String device, @Optional("envTST") String env) throws Exception {
        System.out.println("before method");
        System.out.println("launch app for: "+platform);
        Environment.setEnvironment(env);
        AppDriverFactory.launchApp(platform, device);
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
            System.out.println("after method");
            AppDriverFactory.terminateApp(platform);
            System.out.println("Closed following platform"+platform);
        }
    }

    @AfterSuite(alwaysRun = true)
    @Parameters({"platform"})
    public void serverStop(@Optional("ios") String platform){
        AppiumServer.stop(platform);
    }
}
