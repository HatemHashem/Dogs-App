package com.example.dogsapp;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.dogsapp.database.DatabaseRepository;
import com.example.dogsapp.model.DogsBreed;
import com.example.dogsapp.retrofit.DogsApi;
import com.example.dogsapp.retrofit.DogsBreedClient;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private DogsApi dogsApi;
    private static final String TAG = "Repository";
    private Application application;

    public Repository(Application application) {
        dogsApi = DogsBreedClient.getRetrofitInstance().create(DogsApi.class);
        this.application=application;
    }

    public LiveData<List<DogsBreed>> getBreed() {
        final MutableLiveData<List<DogsBreed>> dogs = new MutableLiveData<>();
        dogsApi.getBreed().enqueue(new Callback<List<DogsBreed>>() {
            @Override
            public void onResponse(Call<List<DogsBreed>> call, Response<List<DogsBreed>> response) {
                if(response.isSuccessful()){
                    dogs.setValue(response.body());
                    //put in database
                    DatabaseRepository databaseRepository =new DatabaseRepository(application);
                    databaseRepository.insertAll(response.body());
                    Log.d(TAG, "onResponse: "+response.body());

                }else {
                    Toast.makeText(application.getApplicationContext(),"error:"+response.code(),Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<List<DogsBreed>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );

            }
        });

        return dogs;

    }
}
