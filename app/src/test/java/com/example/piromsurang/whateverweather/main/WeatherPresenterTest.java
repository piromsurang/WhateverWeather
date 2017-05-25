package com.example.piromsurang.whateverweather.main;

import com.example.piromsurang.whateverweather.WeatherPresenter;
import com.example.piromsurang.whateverweather.WeatherView;
import com.example.piromsurang.whateverweather.data.City;
import com.example.piromsurang.whateverweather.data.CityRepository;
import com.example.piromsurang.whateverweather.data.Weather;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;

/**
 * Created by Piromsurang on 5/25/2017 AD.
 */

public class WeatherPresenterTest {

    private WeatherPresenter presenter;
    private CityRepository repository;

    @Mock
    WeatherView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        repository = CityRepository.getInstance();
        presenter = new WeatherPresenter(repository,view);
    }

    @Test
    public void shouldDisplayFavoriteList() {
        repository.getCityList().clear();
        repository.getFavorites().clear();

        City city = new City("Bangkok", "Thailand", 0, 0);
        presenter.addToFavorite(city);
        presenter.displayList(repository.getFavorites());

        ArrayList<City> c = new ArrayList<>();
        c.add(city);
        verify(view).displayList(c);
    }

    @Test
    public void shouldAbleToDisPlayTheListOfSearchedCities() {
        repository.getCityList().clear();
        repository.getFavorites().clear();

        City c1 = new City("Bangkok", "Thailand", 0, 0);
        City c2 = new City("Tak", "Thailand", 0, 0);
        City c3 = new City("Pichit", "Thailand", 0, 0);
        repository.addCity(c1);
        repository.addCity(c2);
        repository.addCity(c3);

        presenter.searchByCityName("a");

        ArrayList<City> c = new ArrayList<>();
        c.add(c1);
        c.add(c2);
        verify(view).displayList(c);
    }

    @Test
    public void shouldAbleToCreateToastWhenDeleteCityFromFavorite() {
        repository.getCityList().clear();
        repository.getFavorites().clear();

        City c = new City("Bangkok", "Thailand", 0, 0);
        presenter.addToFavorite(c);
        presenter.displayList(repository.getFavorites());
        presenter.removeFromFavorite(c);

        verify(view).createDialog(0);
    }
}
