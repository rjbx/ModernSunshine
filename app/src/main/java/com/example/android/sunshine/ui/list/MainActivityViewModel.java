package com.example.android.sunshine.ui.list;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.WeatherEntry;

import java.util.Date;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    
    // Weather forecast the user is looking at
    private SunshineRepository mSunshineRepository;

    public MainActivityViewModel(SunshineRepository repository) {
        mSunshineRepository = repository;
    }

    public List<LiveData<WeatherEntry>> getWeather(Date date) {
        return mSunshineRepository.getWeatherAfterDate(date);
    }
}
