/*
Assignment #: In Class 04
File Name: GetNewsAsync.java
Group Members: Brian Bystrom, Mohamed Salad
*/

package com.example.brian.triviaapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by brianbystrom on 2/6/17.
 */

public class GetJSONAsync extends AsyncTask<String, Void, ArrayList<Data>> {

    IData activity;

    public GetJSONAsync(IData activity) {
        this.activity = activity;
    }

    @Override
    protected ArrayList<Data> doInBackground(String... params) {

        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null ) {
                sb.append(line);
            }

            return DataUtil.DataJSONParser.parseData(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<Data> s) {
        super.onPostExecute(s);


        activity.setupData(s);


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    static public interface IData {
        public void setupData(ArrayList<Data> s);
    }
}

