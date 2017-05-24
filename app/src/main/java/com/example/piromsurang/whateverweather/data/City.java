package com.example.piromsurang.whateverweather.data;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Piromsurang on 5/11/2017 AD.
 */

public class City {
    private String cityName;
    private String cityCountry;
    private float longtitude;
    private float latitude;

    private Weather weather;

    public City(String cityName, String cityCountry, float longtitude, float latitude) {
        this.cityName = cityName;
        this.cityCountry = cityCountry;
        this.longtitude = longtitude;
        this.latitude = latitude;
        weather = new Weather(cityName);
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityCountry() {
        return cityCountry;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public Weather getWeather() {
        return weather;
    }

    public String toString() {
        return String.format("Country: %s City: %s Longtitude: %.3f Latitude: %.3f", cityCountry, cityName, longtitude, latitude);
    }

}
