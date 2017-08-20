package com.erickogi14gmail.rog.Bible;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 8/17/2017.
 */


public class JsonParser {
    static ArrayList<BiblePojo> biblePojo;

    public static ArrayList<BiblePojo> parseData(String content) {

        JSONArray course_arry = null;
        BiblePojo model = null;
        try {


            biblePojo = new ArrayList<>();
            JSONObject jObj = new JSONObject(content);
            course_arry = jObj.getJSONArray("data");
            if(course_arry.length()<1){

            }
            for (int i = 0; i < course_arry.length(); i++) {

                JSONObject obj = course_arry.getJSONObject(i);
                model = new BiblePojo();



                model.setId(obj.getInt("id"));
                model.setB(obj.getInt("b"));
                model.setC(obj.getInt("c"));
                model.setV(obj.getInt("v"));
                model.setT(obj.getString("t"));



                biblePojo.add(model);
            }
            return biblePojo;

        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
