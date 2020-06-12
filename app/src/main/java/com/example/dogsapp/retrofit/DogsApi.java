package com.example.dogsapp.retrofit;

import com.example.dogsapp.model.DogsBreed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogsApi {
    public static final String BASE_URL="https://api.thedogapi.com/";
    @GET("v1/breeds?limit=10&page=0")
    Call<List<DogsBreed>> getBreed();
}
