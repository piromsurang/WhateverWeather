package com.example.piromsurang.whateverweather.data;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Piromsurang on 5/25/2017 AD.
 */

public class CityRepositoryTest {

    private CityRepository repository;

    @Before
    public void setUp() {
        repository = CityRepository.getInstance();
    }

    @Test
    public void shouldAbleToAddCityToFavorite() {
        repository.getCityList().clear();
        repository.getFavorites().clear();
        City c = new City("Bangkok", "Thailand", 0, 0);
        repository.addToFavorites(c);
        assertEquals(1, repository.getFavorites().size());
    }

    @Test
    public void shouldAbleToAddCityToCityList() {
        repository.getCityList().clear();
        repository.getFavorites().clear();
        City c = new City("Bangkok", "Thailand", 0, 0);
        repository.addCity(c);
        City d = new City("Tak", "Thailand", 0, 0);
        repository.addCity(d);
        assertEquals(2, repository.getCityList().size());
    }

    @Test
    public void shouldGetCityByName() {
        repository.getCityList().clear();
        repository.getFavorites().clear();
        City c = new City("Bangkok", "Thailand", 0, 0);
        repository.addCity(c);
        City d = new City("Tak", "Thailand", 0, 0);
        repository.addCity(d);
        assertEquals("Bangkok", repository.getCityByCityName("Bangkok").getCityName());
    }

    @Test
    public void shouldSearchCityByName() {
        repository.getCityList().clear();
        repository.getFavorites().clear();
        City c = new City("Bangkok", "Thailand", 0, 0);
        repository.addCity(c);
        City d = new City("Tak", "Thailand", 0, 0);
        repository.addCity(d);
        assertEquals(d.toString(), repository.searchByCityName("Tak").get(0).toString());
    }

    @Test
    public void shouldRemoveCityFromFavoriteList() {
        repository.getCityList().clear();
        repository.getFavorites().clear();
        City c = new City("Bangkok", "Thailand", 0, 0);
        repository.addToFavorites(c);
        City d = new City("Tak", "Thailand", 0, 0);
        repository.addToFavorites(d);
        repository.removeFromFavorites(d);
        assertEquals(1, repository.getFavorites().size());
    }
}
