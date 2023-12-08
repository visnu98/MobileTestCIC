package utils;

import Driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Util {

    public static String getScreenshot(String imagename) throws IOException, IOException {
        TakesScreenshot ts = (TakesScreenshot) AppDriver.getCurrentDriver();
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenshot/"+imagename+".jpg";
        FileUtils.copyFile(f, new File(filePath));
        return filePath;
    }

    public static void changeDriverContextToWeb (){
        Set<String> contextNames = ((SupportsContextSwitching) AppDriver.getCurrentDriver()).getContextHandles();
        ((SupportsContextSwitching) AppDriver.getCurrentDriver()).context((String) contextNames.toArray()[1]);
        // Funzt nicht, nicht getestet
    }

    public static boolean isExistXpath(WebElement xPath){
        try {
            //AppDriver.getCurrentDriver().findElement(By.xpath(xPath.toString()));
            AppDriver.getCurrentDriver().findElement(By.xpath(extractXpathfromWebElement(xPath)));
            System.out.println(xPath.toString()+ "is printed.");
            return true;
        } catch (Exception e) {
            System.out.println(xPath.toString()+ "is printed.");
            System.out.println("Following Element does not exist:"+xPath.toString());
            return false;
        }
    }


    //Bsp. von einem WebElement: Located by By.chained({By.xpath: //XCUIElementTypeButton[@name='Neuer Benutzer' or @name='New users']})
    public static String extractXpathfromWebElement (WebElement xPath){
        String source = xPath.toString();
        int sourcelenght = xPath.toString().length()-2;

        return source.substring(0, sourcelenght).split("xpath: ")[1];
    }

}
