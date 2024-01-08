package base;

import org.testng.Reporter;
import org.testng.annotations.Parameters;

public class AppData {


    public static String platform;
    public static String environment;
    public static String useGesturePlugin = System.getProperty("useGesturePlugin", "true");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "false");


    //iOS Driver
    public static String iOSAppPackage = System.getProperty("iOSAppPackage", "ch.cic.mobilebanking.test");
    public static String iOSNoReset = System.getProperty("iOSNoReset", "true");



    //Android Driver
    public static String androidAppPackage = System.getProperty("androidAppPackage","ch.cic.mobilebanking.test");
    public static String androidAppActivity = System.getProperty("androidAppActivity","ch.ti8m.cic.mobilebanking.frontend.android.main.MainActivity");
    public static String androidNoReset = System.getProperty("androidNoReset", "true");



}
