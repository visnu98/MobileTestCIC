package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;

public class JsonReader {

    //strfileName = JSON FIle Path = "resources/testData.json"
    static JSONObject readFile (String strFileName) {

        JSONObject jsonObject = null;
        try {
            File filename = new File(strFileName);
            String json = FileUtils.readFileToString(filename);
            Object obj = new JSONParser().parse(json);
            jsonObject = (JSONObject) obj;

        } catch (Exception e) {
            System.out.println("Could not handle the json: " + e);
        }
        return jsonObject;
    }

    public static String getTestData (String key, String strFileName){
        String testDataValue = null;
        try {
            testDataValue = (String) readFile(strFileName).get(key);
        }
        catch (Exception e){
            System.out.println("Could not find test data with the key: "+key);
        }
        return testDataValue;
    }


    public static long getTimeOutFromServerConfig() throws Exception {

        try {
            JSONObject obj = readFile("resources/config/appiumServer/serverConfig.json");
            JSONObject server = (JSONObject) obj.get("server");
            JSONObject plugin = (JSONObject) server.get("plugin");
            JSONObject elementWait = (JSONObject) plugin.get("element-wait");

            return (long) elementWait.get("timeout");
        }
        catch (Exception e){
            throw new Exception("Could not read Server config");

        }


    }
}
