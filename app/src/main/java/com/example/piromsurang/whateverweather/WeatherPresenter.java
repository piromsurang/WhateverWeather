package com.example.piromsurang.whateverweather;

import com.example.piromsurang.whateverweather.data.CityRepository;

/**
 * Created by Piromsurang on 5/12/2017 AD.
 */

public class WeatherPresenter {

    private CityRepository repository;
    private WeatherView view;

    public WeatherPresenter(CityRepository repository, WeatherView view) {
        this.repository = repository;
        this.view = view;
    }
}
