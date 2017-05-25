package com.example.piromsurang.whateverweather;

import com.example.piromsurang.whateverweather.data.City;
import com.example.piromsurang.whateverweather.data.CityRepository;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Piromsurang on 5/12/2017 AD.
 */

public class WeatherPresenter implements Observer {

    private CityRepository repository;
    private WeatherView view;

    public WeatherPresenter(CityRepository repository, WeatherView view) {
        this.repository = repository;
        this.view = view;
    }

    public void displayList(ArrayList<City> list) {
        view.displayList(list);
    }

    public void updateWeather() {
        System.out.println("start updating weather...");
        repository.updateWeather();
    }

    public void searchByCityName(String t) {
        if( t.length() == 0 ) {
            view.displayList(repository.getCityList());
        }
        else {
            view.displayList(repository.searchByCityName(t));
        }
    }

    public void addToFavorite(City c) {
        repository.addToFavorites(c);
    }

    public void removeFromFavorite(City c) {
        repository.removeFromFavorites(c);
        createDialog(0);
    }

    public void createDialog(int b) {
        view.createDialog(b);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.toString().equals("")) {
            System.out.println("finished downloading cities data.");
            updateWeather();
        } else if(arg.toString().equals("finished updating weather")){
        }
    }
}
