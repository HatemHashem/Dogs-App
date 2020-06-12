package com.example.dogsapp.database;

import android.app.Application;

import com.example.dogsapp.model.DogsBreed;

import java.util.List;

import androidx.lifecycle.LiveData;

import static com.example.dogsapp.database.DogsbreedDatabase.databaseWriteExecutor;

public class DatabaseRepository {
    private LiveData<List<DogsBreed>> breeds;
    private DogbreedDao dogbreedDao;
    public DatabaseRepository(Application application) {
        dogbreedDao=DogsbreedDatabase.getInstance(application).dogbreedDao();
        breeds=dogbreedDao.getAllBreeds();

    }

    public LiveData<List<DogsBreed>> getBreeds() {
        return breeds;
    }
    public void insertAll(List<DogsBreed> dogsBreedList){
        databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dogbreedDao.insertAll(dogsBreedList);
            }
        });
    }
    public void deleteAll(){
        databaseWriteExecutor.execute(() -> {
            dogbreedDao.deleteAll();

        });
    }
}
