package utils;

import Driver.AppDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementWaitHandler {


    public static WebElement waitUntilElementVisibleE (WebElement element, long sec){

        try {
            WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (Exception e) {
            throw new RuntimeException("Element was not present: "+ element);
        }

    }
    public static Boolean waitUntilElementVisibleB (WebElement element, long sec){

        try {
            WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Element was not present: "+ element);

        }

    }

}
