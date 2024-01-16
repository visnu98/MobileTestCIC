package utils;

public class OSHandler {

    //To set and get the Operating System (ios or android)
    public static final ThreadLocal<String> threadOS = new ThreadLocal<String>();

    public static void setOS(String os) throws Exception {
        if (os.equalsIgnoreCase("ios" )|| os.equalsIgnoreCase("android" )){
            threadOS.set(os);
            System.out.println("Current OS set to: "+threadOS.get());
        }
        else {
            throw new Exception(os + " is not a correct os! Please set ios or android.");
        }
    }

    public static String getCurrentOS(){
        System.out.println(threadOS.get() + " current Environment.");
        return threadOS.get();
    }

}
