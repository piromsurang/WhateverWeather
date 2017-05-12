package com.example.piromsurang.whateverweather.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Piromsurang on 5/11/2017 AD.
 */

public class CityRepository {

    private Map<String, City> cities;
    private static CityRepository instance = null;


    private CityRepository() {
        cities = new ConcurrentHashMap<>();
    }

    public static CityRepository getInstance() {

        if(instance == null) {
            instance = new CityRepository();
        }

        return instance;

    }

    public Map<String, City> getCities() {
        return cities;
    }

    public void addCity(String key, City c) {
        cities.put(key, c);
    }
}
