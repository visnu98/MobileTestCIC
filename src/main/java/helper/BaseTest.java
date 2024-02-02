package helper;

import Driver.AppDriverFactory;
import base.AppiumServer;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import utils.*;


//enable=false - prioritize=1 - dependsOnMethods=MethodeName - alwaysRun=true ignoriert dependency -
public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void serverStart() throws Exception {
        System.out.println("before suite");
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"env", "device"})
    public void startAppiumServer(@Optional("envTST") String env, @Optional("iPhone14Plus") String device) throws Exception {
        System.out.println("BeforeClass method");
        DeviceHandler.setDevice(device);
        OSHandler.setOS(DeviceHandler.getCurrentDeviceDetail("os"));
        EnvironmentHandler.setEnvironment(env);
        AppiumServer.start();

    }

    @BeforeMethod (alwaysRun = true)
    public void launchApp() throws Exception {
        System.out.println("before method");
        System.out.println("launch app for: "+OSHandler.getCurrentOS());
        AppDriverFactory.launchApp();
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("after method");
            Util.getScreenshot(result);
            AppDriverFactory.terminateApp();
        }
        else {
            System.out.println("after method");
            AppDriverFactory.terminateApp();
            System.out.println("Closed following platform "+OSHandler.getCurrentOS());
        }
    }

    @AfterSuite(alwaysRun = true)
    public void serverStop(){
        AppiumServer.stop();
    }
}
