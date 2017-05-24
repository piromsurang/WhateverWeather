package com.example.piromsurang.whateverweather.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
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

    public Weather(String name) {
        cityName = name;
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
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public String toString() {
        return String.format("%s\ntemperature: %d\n\t%s", cityName, temperature, description);
    }

    public void getIcon(String url) {
        ImageFetchTask task = new ImageFetchTask();
        task.execute(url);
    }
    public class ImageFetchTask extends AsyncTask<String, Void, Bitmap > {

        private Bitmap map;

        @Override
        protected Bitmap doInBackground(String... params) {

            return downloadImg(params[0]);
        }

        private Bitmap downloadImg(String icon_url) {
            URL url = null;
            try {
                url = new URL(icon_url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                map = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return map;
        }

        @Override
        protected void onPostExecute(Bitmap results) {
            if( results != null ) {
                bitmap = results;
            }
        }
    }
}
