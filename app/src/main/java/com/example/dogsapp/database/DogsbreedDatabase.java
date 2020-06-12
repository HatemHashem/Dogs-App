package com.example.dogsapp.database;

import android.content.Context;

import com.example.dogsapp.model.DogsBreed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(entities = {DogsBreed.class},version = 1,exportSchema = false)
@TypeConverters({WeightConverter.class,HeightConverter.class})
public abstract class DogsbreedDatabase extends RoomDatabase {
    private static DogsbreedDatabase instance;
  public abstract DogbreedDao dogbreedDao();
  private static final int NUM_OF_THREADS=5;
  static final ExecutorService databaseWriteExecutor= Executors.newFixedThreadPool(NUM_OF_THREADS);

    public static DogsbreedDatabase getInstance(Context context) {
        if(instance==null){
            instance= Room.databaseBuilder(context,DogsbreedDatabase.class,"breed_database")
            .fallbackToDestructiveMigration()
            .build();
        }
       return instance;
    }
}
