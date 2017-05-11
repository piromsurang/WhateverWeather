package com.example.piromsurang.whateverweather.data;

/**
 * Created by Piromsurang on 5/11/2017 AD.
 */

public class City {
    private String cityName;
    private String cityCountry;
    private double longtitude;
    private double latitude;

    public City(String cityName, String cityCountry, double longtitude, double latitude) {
        this.cityName = cityName;
        this.cityCountry = cityCountry;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityCountry() {
        return cityCountry;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
