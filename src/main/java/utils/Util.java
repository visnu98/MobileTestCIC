package utils;

import Driver.AppDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

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

    public static boolean doesElementExistXpath(WebElement element){
        try {
           long sec =JsonReader.getTimeOutFromServerConfig()/1000;

           element.isEnabled();
           // ElementWaitHandler.waitUntilElementVisibleB(element, sec);
            System.out.println(element.toString()+ "is printed.");
            return true;
        } catch (Exception e) {
            System.out.println(element.toString()+ "is printed.");
            System.out.println("Following Element does not exist:"+element.toString());
            return false;
        }
    }



    //Bsp. von einem WebElement: Located by By.chained({By.xpath: //XCUIElementTypeButton[@name='Neuer Benutzer' or @name='New users']})
    public static String extractXpathfromWebElement (WebElement element){
        String source = element.toString();
        int sourcelength = element.toString().length()-2;
        return source.substring(0, sourcelength).split("xpath: ")[1];
    }

}
