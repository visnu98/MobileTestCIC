package base;

import org.testng.Reporter;
import org.testng.annotations.Parameters;

public class AppData {

    public static String useGesturePlugin = System.getProperty("useGesturePlugin", "true");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "false");


    //iOS Driver
    public static String iOSNoReset = System.getProperty("iOSNoReset", "true");

    //Android Driver
    public static String androidAppActivity = System.getProperty("androidAppActivity","ch.ti8m.cic.mobilebanking.frontend.android.main.MainActivity");
    public static String androidNoReset = System.getProperty("androidNoReset", "true");



}
