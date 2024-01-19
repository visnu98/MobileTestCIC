package utils;

import java.io.FileNotFoundException;

public class DeviceHandler {

    public static final ThreadLocal<String> threadDevice = new ThreadLocal<String>();

    public static void setDevice(String device) throws Exception {
       if(deviceExists(device)){
           threadDevice.set(device);
           System.out.println("Device is set to: " + device);
       }
       else {
           throw new FileNotFoundException(device + " device does not exist as a JSON config!");
       }
    }

    public static String getCurrentDevice(){
        System.out.println(threadDevice.get() + " current Device.");
        return threadDevice.get();
    }

    static boolean deviceExists(String device) {
        device =getDeviceFilePath(device);
        return JsonReader.doesFileExists(device);
    }

    //Returns needed info from current device JSON File
    public static String getCurrentDeviceDetail(String key){
        String detail = null;
        try {
         detail = JsonReader.getTestData(key,getDeviceFilePath(getCurrentDevice()));
        } catch (Exception e) {
            System.out.println(" Could not get following data: " + key);
        }
        return detail;
    }

    public static String getDeviceFilePath (String device){
        device ="resources/config/device/"+device+".json";
        return device;
    }
}
