package base;

import org.testng.Reporter;
import org.testng.annotations.Parameters;

public class AppData {



    public static String platform;
    public static String useGesturePlugin = System.getProperty("useGesturePlugin", "true");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "false");


    //iOS Driver
    public static String iOSAppPackage = System.getProperty("iOSAppPackage", "ch.cic.mobilebanking.test");
    public static String iOSPlatFormVersion = System.getProperty("iOSPlatFormVersion", "17.1");
    public static String iOSDeviceName = System.getProperty("iOSDeviceName", "iPhone 14");
    public static String iOSNoReset = System.getProperty("iOSNoReset", "true");
    public static String iOSUdid = System.getProperty("iOSUdid", "00008110-000E0C2E1A11401E");
    public static String iOSappiumUrl = System.getProperty("iOSappiumUrl", "http://127.0.0.1:4723/");


    //Android Driver
    public static String androidAppPackage = System.getProperty("androidAppPackage","ch.cic.mobilebanking.test");
    public static String androidPlatFormVersion = System.getProperty("androidPlatFormVersion","14");
    public static String androidDeviceName = System.getProperty("androidDeviceName","R3CT60241ZM");
    public static String androidAppActivity = System.getProperty("androidAppActivity","ch.ti8m.cic.mobilebanking.frontend.android.main.MainActivity");
    public static String androidNoReset = System.getProperty("androidNoReset", "true");
    public static String androidAppiumUrl = System.getProperty("androidAppiumUrl", "http://127.0.0.1:4723/");


}
