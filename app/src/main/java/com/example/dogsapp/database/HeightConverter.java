package com.example.dogsapp.database;

import com.example.dogsapp.model.Height;
import com.google.gson.Gson;

import androidx.room.TypeConverter;

public class HeightConverter {
    @TypeConverter
    public String fromHeight(Height height){
        Gson gson=new Gson();
        String toJson=gson.toJson(height);
        return toJson;
    }
    @TypeConverter
    public Height toHeight(String height){
        Gson gson=new Gson();
        Height heightObject=gson.fromJson(height,Height.class);
        return heightObject;
    }
}
