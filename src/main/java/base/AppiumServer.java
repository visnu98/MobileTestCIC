package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.OSHandler;

import java.io.File;
import java.time.Duration;
import java.util.Objects;


public class AppiumServer {
    static AppiumDriverLocalService server;

    // Start AppiumServer for Android
    private static void setAndroidInstance(AppiumServiceBuilder builder){
        builder
                //.withAppiumJS(new File("/Users/visnu/node_modules/appium/build/lib/main.js"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                //.usingDriverExecutable(new File("/Program Files/nodejs/node.exe"))
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .usingPort(4723)
                .withIPAddress("127.0.0.1")
                .withTimeout(Duration.ofSeconds(60))
                .withArgument(GeneralServerFlag.USE_PLUGINS,"gestures, element-wait")
                .withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");

/*
        if(AppData.useGesturePlugin.contains("true")){
            //builder.withArgument(GeneralServerFlag.USE_PLUGINS, "gestures");
        }

        if(AppData.chromeAutoDownloadDriver.contains("true")) {
            builder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
        }*/
        server = AppiumDriverLocalService.buildService(builder);

        System.out.println("Appium server started with configs for Android.");
    }

    //Start Appium Server for iOS
    private static void setiOSInstance(AppiumServiceBuilder builder) {

        System.out.println("Trying to invoke Apppium Server for iOS");
        builder
                //.withAppiumJS(new File("/Users/visnu/node_modules/appium/build/lib/main.js"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                //.usingDriverExecutable(new File("/Program Files/nodejs/node.exe"))
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .usingPort(4722)
                .withLogFile(new File("Appiumlog.txt"))
                .withIPAddress("127.0.0.1")
                .withTimeout(Duration.ofSeconds(60))
                .withArgument(GeneralServerFlag.USE_PLUGINS,"gestures, element-wait")
                .withArgument(() -> "--config", new File("resources/config/appiumServer" + File.separator + "serverConfig.json").toString());

        if(AppData.useGesturePlugin.contains("true")){
            //builder.withArgument(GeneralServerFlag.USE_PLUGINS, "gestures");
        }

        if(AppData.chromeAutoDownloadDriver.contains("true")) {
            builder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
        }
        server = AppiumDriverLocalService.buildService(builder);

        System.out.println("Appium server started with configs for iOS.");
    }

    public static void start(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder ();
        if(OSHandler.getCurrentOS().equalsIgnoreCase("android")){
            setAndroidInstance(builder);
        }
        else if (OSHandler.getCurrentOS().equalsIgnoreCase("ios")) {
            setiOSInstance(builder);
        }
        else {
            System.out.println("Failed at getInstance: Please set ios or Android as a platform. Currently: " + OSHandler.getCurrentOS());
        }
        server.start();
        System.out.println(server.getUrl());
        System.out.println(server.isRunning());
    }

    public static void stop(){
        if(server != null){
           server.stop();
           System.out.println("Appium server stopped");
        }
    }
}
