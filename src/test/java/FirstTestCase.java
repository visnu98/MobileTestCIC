import Driver.AppDriver;
import helper.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FirstTestCase extends BaseTest {



    @Test
    public void firstTest() throws InterruptedException {

        AppDriver.getCurrentDriver().findElement(By.id("username")).sendKeys("USER605");
    }
}
