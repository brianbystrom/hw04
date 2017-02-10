package com.example.brian.triviaapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by brianbystrom on 2/6/17.
 */

//String title, author, published_date, description, urlToImage;


public class DataUtil {

    static public class DataJSONParser {
        static ArrayList<Data> parseData(String in) {
            ArrayList<Data> dataList = new ArrayList();


            try {
                JSONObject root = new JSONObject(in);
                JSONArray dataJSONArray = root.getJSONArray("questions");


                for (int i = 0; i<dataJSONArray.length(); i++) {
                    JSONObject dataJSONObject = dataJSONArray.getJSONObject(i);
                    Data data = new Data();

                    data.setId(dataJSONObject.getInt("id"));
                    data.setText(dataJSONObject.getString("text"));
                    data.setImage(dataJSONObject.getString("image"));

                    ArrayList<String> choiceList = new ArrayList();
                    JSONObject choices = dataJSONObject.optJSONObject("choices");
                    JSONArray choicesArray = choices.getJSONArray("choice");
                    for (int j = 0; j < choicesArray.length(); j++) {
                        //choiceList.add(choicesArray.getString(j));
                    }
                    data.setChoices(choiceList);
                    data.setAnswer(choices.getInt("answer"));
                    dataList.add(data);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return dataList;
        }
    }
}
