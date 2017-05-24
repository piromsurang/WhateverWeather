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
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Piromsurang on 5/11/2017 AD.
 */

public class CityRepository extends Observable {

    private static CityRepository instance = null;
    private ArrayList<City> cityList;
    private ArrayList<City> searchedList;
    private ArrayList<City> favorites;

    private CityRepository() {
        cityList = new ArrayList<>();
        searchedList = new ArrayList<>();
        favorites = new ArrayList<>();
    }

    public static CityRepository getInstance() {

        if(instance == null) {
            instance = new CityRepository();
        }

        return instance;

    }

    public ArrayList<City> getSearchedList() {
        return searchedList;
    }

    public ArrayList<City> getFavorites() {
        return favorites;
    }

    public void addCity(City c) {
        cityList.add(c);
    }

    public City getCityByCityName(String name) {
        for(City c : cityList) {
            if(c.getCityName().equals(name)) {
                return c;
            }
        }
        return new City("", "", 0, 0);
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public ArrayList<City> searchByCityName(String name) {
        searchedList.clear();
        for (City b : cityList) {
            if( b.getCityName().contains(name)) {
                searchedList.add(b);
            }
        }

        Collections.sort(searchedList, new Comparator<City>() {
            @Override
            public int compare(City one, City other) {
                return one.getCityName().compareTo(other.getCityName());
            }
        });

        return searchedList;
    }

    public void updateWeather() {
        FetchWeather task = new FetchWeather();
        task.execute();
    }

    public void addToFavorites(City c) {
        favorites.add(c);
    }

    public void removeFromFavorites(City c) {
        favorites.remove(c);
    }


    private class FetchWeather extends AsyncTask<Void, Void, Void> {

        private String loadWeatherJson(City c) {
            String result = "";
            try {
                String url = "http://api.openweathermap.org/data/2.5/weather?lat=" + c.getLatitude() + "&lon=" + c.getLongtitude() + "&appid=f9a98548b05522ebc556cd91b297b253";
                URL dataUrl = new URL(url);
                URLConnection conn = dataUrl.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String inputLine = "";
                while ((inputLine = in.readLine()) != null) {
                    result += inputLine;
                }
                return result;
            } catch (IOException e) {
                return result;
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(City c : cityList) {
                String bookListJsonStr = loadWeatherJson(c);
                if (bookListJsonStr == null) {
                    return null;
                }
                try {
                    JSONObject jsonObject = new JSONObject(bookListJsonStr);
                    JSONObject weatherDetails = jsonObject.getJSONArray("weather").getJSONObject(0);
                    JSONObject weatherData = new JSONObject(jsonObject.getString("main"));
                    c.getWeather().setDescription(weatherDetails.getString("description").toUpperCase());
                    c.getWeather().setDetails("Humidity: " + weatherData.getString("humidity") + "%\nPressure: " + weatherData.getString("pressure") + "hPa");

                    int temp = (int) (Double.parseDouble(weatherData.getString("temp")) - 273.15);
                    c.getWeather().setTemperature(temp);
                    c.getWeather().getIcon("http://openweathermap.org/img/w/" + weatherDetails.getString("icon") + ".png");
                } catch (JSONException e) {
                    return null;
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            setChanged();
            notifyObservers("finished updating weather");
        }
    }
}
