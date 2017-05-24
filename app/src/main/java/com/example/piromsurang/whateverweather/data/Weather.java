package com.example.piromsurang.whateverweather.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.piromsurang.whateverweather.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Piromsurang on 5/12/2017 AD.
 */

public class Weather {

    private String cityName;
    private int temperature;
    private String description = "";
    private String details = "";
    protected Bitmap bitmap;
    private String iconName;

    public Weather(String name) {
        cityName = name;
        iconName = "";
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String d) {
        details = d;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return description;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temp) {
        temperature = temp;
        temperature -= 273;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public Bitmap getIcon() {
        return bitmap;
    }


    public String toString() {
        return String.format("%s\ntemperature: %d\n\t%s", cityName, temperature, description);
    }

    public void loadIcon(String url, Context context) {
        InputStream imageIS = null;
        switch(url) {
            case "01d":
                imageIS = context.getResources().openRawResource(R.raw.d01);
                break;
            case "02d":
                imageIS = context.getResources().openRawResource(R.raw.d02);
                break;
            case "03d":
                imageIS = context.getResources().openRawResource(R.raw.n03);
                break;
            case "03n":
                imageIS = context.getResources().openRawResource(R.raw.n03);
                break;
            case "04d":
                imageIS = context.getResources().openRawResource(R.raw.d04);
                break;
            case "04n":
                imageIS = context.getResources().openRawResource(R.raw.d04);
                break;
            case "09d":
                imageIS = context.getResources().openRawResource(R.raw.d09);
                break;
            case "09n":
                imageIS = context.getResources().openRawResource(R.raw.d09);
                break;
            case "10d":
                imageIS = context.getResources().openRawResource(R.raw.d10);
                break;
            case "10n":
                imageIS = context.getResources().openRawResource(R.raw.n10);
                break;
            case "11d":
                imageIS = context.getResources().openRawResource(R.raw.d11);
                break;
            case "11n":
                imageIS = context.getResources().openRawResource(R.raw.d11);
                break;
            case "13d":
                imageIS = context.getResources().openRawResource(R.raw.d13);
                break;
            case "13n":
                imageIS = context.getResources().openRawResource(R.raw.d13);
                break;
            case "50d":
                imageIS = context.getResources().openRawResource(R.raw.d50);
                break;
            case "50n":
                imageIS = context.getResources().openRawResource(R.raw.d50);
                break;
        }
        bitmap = BitmapFactory.decodeStream(imageIS);
    }

}
