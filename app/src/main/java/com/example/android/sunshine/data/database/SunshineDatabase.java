package com.example.android.sunshine.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {WeatherEntry.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class SunshineDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "weather";
    private static final Object LOCK = new Object();
    private static volatile SunshineDatabase sInstance;

    public static SunshineDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(
                            context.getApplicationContext(), SunshineDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return sInstance;
    }

    abstract public WeatherDao weatherDao();
}
