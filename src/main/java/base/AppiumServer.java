package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.time.Duration;
import java.util.Objects;


public class AppiumServer {
    static AppiumDriverLocalService server;

    //Get the OS from AppData



    // Start AppiumServer for Android
    private static void setAndroidInstance(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                //.withAppiumJS(new File("/Users/visnu/node_modules/appium/build/lib/main.js"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                //.usingDriverExecutable(new File("/Program Files/nodejs/node.exe"))
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .usingPort(4723)
                .withIPAddress("127.0.0.1")
                .withTimeout(Duration.ofSeconds(20))
                .withArgument(GeneralServerFlag.USE_PLUGINS,"gestures, element-wait");


        if(AppData.useGesturePlugin.contains("true")){
            //builder.withArgument(GeneralServerFlag.USE_PLUGINS, "gestures");
        }

        if(AppData.chromeAutoDownloadDriver.contains("true")) {
            builder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
        }
        server = AppiumDriverLocalService.buildService(builder);

        System.out.println("Appium server started with configs for Android.");
    }

    //Start Appium Server for iOS
    private static void setiOSInstance() {

        System.out.println("Trying to invoke Apppium Server for iOS");
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                //.withAppiumJS(new File("/Users/visnu/node_modules/appium/build/lib/main.js"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                //.usingDriverExecutable(new File("/Program Files/nodejs/node.exe"))
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .usingPort(4723)
                .withLogFile(new File("Appiumlog.txt"))
                .withIPAddress("127.0.0.1")
                .withTimeout(Duration.ofSeconds(60))
                .withArgument(GeneralServerFlag.USE_PLUGINS,"gestures, element-wait");

        if(AppData.useGesturePlugin.contains("true")){
            //builder.withArgument(GeneralServerFlag.USE_PLUGINS, "gestures");
        }

        if(AppData.chromeAutoDownloadDriver.contains("true")) {
            builder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
        }
        server = AppiumDriverLocalService.buildService(builder);

        System.out.println("Appium server started with configs for iOS.");
    }

    private static AppiumDriverLocalService getInstance(){

        if(server == null){
            if(Objects.equals(AppData.platform, "android")){
                setAndroidInstance();
            } else if (Objects.equals(AppData.platform, "ios")) {
                setiOSInstance();
            }
            else {
                System.out.println("Failed at getInstance: Please set ios or Android as a platform. Currently: " + AppData.platform);
            }

        }
        return server;
    }



    public  static void start(){
        getInstance().start();
        System.out.println(server.getUrl());
        System.out.println(server.isRunning());
    }

    public static void stop(){
        if(server != null){
            getInstance().stop();
            System.out.println("Appium server stopped");
        }
    }
}
