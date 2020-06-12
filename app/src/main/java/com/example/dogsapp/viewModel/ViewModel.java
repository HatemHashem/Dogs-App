package com.example.dogsapp.viewModel;

import android.app.Application;

import com.example.dogsapp.Repository;
import com.example.dogsapp.database.DatabaseRepository;
import com.example.dogsapp.model.DogsBreed;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ViewModel extends AndroidViewModel {
    private Repository repository;
    private DatabaseRepository databaseRepository;
    private LiveData<List<DogsBreed>> dogsBreedLiveData;
    private LiveData<List<DogsBreed>> dogsBreedRoom;

    public LiveData<List<DogsBreed>> getDogsBreedLiveData() {
        return dogsBreedLiveData;
    }

    public ViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        databaseRepository=new DatabaseRepository(application);
        dogsBreedRoom=databaseRepository.getBreeds();
        dogsBreedLiveData=repository.getBreed();
    }

    public LiveData<List<DogsBreed>> getDogsBreedRoom() {
        return dogsBreedRoom;
    }
}
