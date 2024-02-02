package helper;

import Driver.AppDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    public static String getTestMethodeName (ITestResult iTestListener){
        return iTestListener.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public static byte [] saveFailureScreenShot (){
        return ((TakesScreenshot) AppDriver.getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}",type = "type/plain")
        public static String saveTextLog(String message){
            return message;
        }


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On Success Method");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        if(AppDriver.getCurrentDriver() != null){
            saveFailureScreenShot();
            saveTextLog(getTestMethodeName(result)+ "failed and screenshot taken!");
        }

        System.out.println("On Failure Method");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On Skipped Method");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("OonTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout");
    }

    @Override
    public void onStart(ITestContext context) {
        //context.setAttribute("WebDriver",AppDriver.getCurrentDriver());
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
