package com.example.dogsapp.database;

import com.example.dogsapp.model.Weight;
import com.google.gson.Gson;

import androidx.room.TypeConverter;

public class WeightConverter {
    @TypeConverter
    public String fromWeight(Weight weight){
        Gson gson=new Gson();
        String toJson=gson.toJson(weight);
        return toJson;
    }
    @TypeConverter
    public Weight toWeight(String weightJson){
        Gson gson=new Gson();
        Weight weight=gson.fromJson(weightJson,Weight.class);
        return weight;
    }
}
