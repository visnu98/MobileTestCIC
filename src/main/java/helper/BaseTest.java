package helper;

import Driver.AppDriverFactory;
import base.AppiumServer;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import utils.EnvironmentHandler;
import utils.OSHandler;
import utils.Util;


//enable=false - prioritize=1 - dependsOnMethods=MethodeName - alwaysRun=true ignoriert dependency -
public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void serverStart() throws Exception {
        System.out.println("before suite");
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"platform","env"})
    public void startAppiumServer(@Optional("ios") String platform, @Optional("envTST") String env){
        System.out.println("BeforeClass method");
        System.out.println("Plaform value in BeforeClass: "+platform);
        OSHandler.setOS(platform);
        EnvironmentHandler.setEnvironment(env);
        AppiumServer.start();

    }

    @BeforeMethod (alwaysRun = true)
    @Parameters({"device"})
    public void launchApp(@Optional("iPhone14Plus") String device) throws Exception {
        System.out.println("before method");
        System.out.println("launch app for: "+OSHandler.getCurrentOS());
        AppDriverFactory.launchApp(device);
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("after method");
            Util.getScreenshot(result.getTestName());
            AppDriverFactory.terminateApp();
        }
        else {
            System.out.println("after method");
            AppDriverFactory.terminateApp();
            System.out.println("Closed following platform"+OSHandler.getCurrentOS());
        }
    }

    @AfterSuite(alwaysRun = true)
    @Parameters({"platform"})
    public void serverStop(@Optional("ios") String platform){
        AppiumServer.stop();
    }
}
