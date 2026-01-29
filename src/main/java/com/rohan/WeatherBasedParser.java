package com.rohan;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;

public class WeatherBasedParser {
    public void parseAndPrint(String jsonResponse) {
        JSONObject obj = new JSONObject(jsonResponse);
        if(obj.getInt("cod") == 200) {
            System.out.println("City Forcast: " );
            JSONArray list = obj.getJSONArray("list");
            for(int i = 0; i < list.length(); i++){
                JSONObject forecast = list.getJSONObject(i);
                long timestamp = forecast.getLong("dt");
                String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp * 1000));
                double temp = forecast.getJSONObject("main").getDouble("temp");
                String weatherDescription = forecast.getJSONArray("weather").getJSONObject(0).getString("description");

                System.out.println("Date: " + date + ", Temp: " + temp + "°C, Weather: " + weatherDescription);
            }
        }else{
            System.out.println("Error: " + obj.getString("message"));
            return;
        }
    }
}
