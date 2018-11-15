package com.example.android.sunshine.data.database;

import java.util.Date;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weather);

    @Query("SELECT * FROM weather where date = :date")
    LiveData<WeatherEntry> getWeatherByDate(Date date);

    @Query("SELECT * FROM weather where date > :date")
    LiveData<List<WeatherEntry>> getWeatherAfterDate(Date date);

    @Query("SELECT COUNT(DISTINCT date) FROM weather WHERE date < :date")
    int countAllFutureWeather(Date date);

    @Query("DELETE FROM weather WHERE date < :date")
    void deleteOldData(Date date);
}
