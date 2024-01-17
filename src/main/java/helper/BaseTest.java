package helper;

import Driver.AppDriverFactory;
import base.AppiumServer;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import utils.DeviceHandler;
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
    @Parameters({"platform","env", "device"})
    public void startAppiumServer(@Optional("ios") String platform, @Optional("envTST") String env, @Optional("iPhone14Plus") String device) throws Exception {
        System.out.println("BeforeClass method");
        System.out.println("Platform value in BeforeClass: "+platform);
        OSHandler.setOS(platform);
        DeviceHandler.setDevice(device);
        EnvironmentHandler.setEnvironment(env);
        AppiumServer.start();

    }

    @BeforeMethod (alwaysRun = true)
    public void launchApp() throws Exception {
        System.out.println("before method");
        System.out.println("launch app for: "+OSHandler.getCurrentOS());
        AppDriverFactory.launchApp(DeviceHandler.getCurrentDevice());
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
    public void serverStop(){
        AppiumServer.stop();
    }
}
