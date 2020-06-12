package com.example.dogsapp.database;

import com.example.dogsapp.model.DogsBreed;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface DogbreedDao {
    @Query("SELECT * FROM breeds_table ")
    LiveData<List<DogsBreed>>getAllBreeds();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DogsBreed> breeds);
    @Query("DELETE FROM BREEDS_TABLE")
    void deleteAll();
}
