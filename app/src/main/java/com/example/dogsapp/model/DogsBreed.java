package com.example.dogsapp.model;

import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

@Entity(tableName = "breeds_table")
public class DogsBreed {

	@SerializedName("life_span")
	private String lifeSpan;

	@SerializedName("breed_group")
	private String breedGroup;

	@SerializedName("temperament")
	private String temperament;

	@SerializedName("origin")
	private String origin;

	@SerializedName("name")
	private String name;
	//todo add a converter
	@SerializedName("weight")
	private Weight weight;

	@SerializedName("bred_for")
	private String bredFor;
	@PrimaryKey
	@SerializedName("id")
	private int id;
	//todo add type converter
	@SerializedName("height")
	private Height height;

	public void setLifeSpan(String lifeSpan){
		this.lifeSpan = lifeSpan;
	}

	public String getLifeSpan(){
		return lifeSpan;
	}

	public void setBreedGroup(String breedGroup){
		this.breedGroup = breedGroup;
	}

	public String getBreedGroup(){
		return breedGroup;
	}

	public void setTemperament(String temperament){
		this.temperament = temperament;
	}

	public String getTemperament(){
		return temperament;
	}

	public void setOrigin(String origin){
		this.origin = origin;
	}

	public String getOrigin(){
		return origin;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setWeight(Weight weight){
		this.weight = weight;
	}

	public Weight getWeight(){
		return weight;
	}

	public void setBredFor(String bredFor){
		this.bredFor = bredFor;
	}

	public String getBredFor(){
		return bredFor;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setHeight(Height height){
		this.height = height;
	}

	public Height getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"life_span = '" + lifeSpan + '\'' + 
			",breed_group = '" + breedGroup + '\'' + 
			",temperament = '" + temperament + '\'' + 
			",origin = '" + origin + '\'' + 
			",name = '" + name + '\'' + 
			",weight = '" + weight + '\'' + 
			",bred_for = '" + bredFor + '\'' + 
			",id = '" + id + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}