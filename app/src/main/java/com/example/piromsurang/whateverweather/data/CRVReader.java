package com.example.piromsurang.whateverweather.data;

import android.content.Context;
import android.os.AsyncTask;

import com.example.piromsurang.whateverweather.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Piromsurang on 5/11/2017 AD.
 */

public class CRVReader extends AsyncTask<Void, Void, Void> {

    private CityRepository repository;
    private Context context;

    public CRVReader(Context context) {
        this.context = context;
        repository = CityRepository.getInstance();
    }

    public void startReading() {
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            InputStream stream = context.getResources().openRawResource(R.raw.worldcities);
            reader = new BufferedReader(new InputStreamReader(stream));
            while ((line = reader.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                City c = new City(country[0], country[5], Float.parseFloat(country[3]), Float.parseFloat(country[2]));
                repository.addCity(country[0], c);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        startReading();
        return null;
    }
}
