package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;

public class JsonReader {

    //strfileName = JSON FIle Path = "resources/testData.json"
    public static JSONObject getJsonData (String strFileName) {

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
            testDataValue = (String) getJsonData(strFileName).get(key);
        }
        catch (Exception e){
            System.out.println("Could not find test data with the key: "+key);
        }
        return testDataValue;
    }
}
