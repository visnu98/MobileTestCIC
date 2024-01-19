package utils;

public class EnvironmentHandler {

    // To set and get the execution environment (envINT or envTST)

    public static final ThreadLocal<String> environment = new ThreadLocal<String>();

    public static void setEnvironment(String env){
        if (env.equalsIgnoreCase("envTST")){
            environment.set("ch.cic.mobilebanking.test");
            System.out.println("Environment set to: ch.cic.mobilebanking.test");
        }
        else if (env.equalsIgnoreCase("envINT")){
            environment.set("ch.cic.mobilebanking.int");
            System.out.println("Environment set to: ch.cic.mobilebanking.int");
        }
        else {
            throw new IllegalArgumentException(env+ " is not a correct environment! Please set envINT or envTST.\"");
        }
    }

    public static String getEnvironment(){
        System.out.println(environment.get() + " current Environment.");
        return environment.get();
    }
}
