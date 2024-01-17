package utils;

import java.io.FileNotFoundException;

public class DeviceHandler {

    public static final ThreadLocal<String> threadDevice = new ThreadLocal<String>();

    public static void setDevice(String device) throws Exception {
       if(deviceExists(device)){
           threadDevice.set(device);
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

    public static String getDeviceFilePath (String device){
        device ="resources/config/device/"+device+".json";
        return device;
    }
}
