package com.example.dogsapp.model;

import com.google.gson.annotations.SerializedName;

public class Height{

	@SerializedName("metric")
	private String metric;

	@SerializedName("imperial")
	private String imperial;

	public void setMetric(String metric){
		this.metric = metric;
	}

	public String getMetric(){
		return metric;
	}

	public void setImperial(String imperial){
		this.imperial = imperial;
	}

	public String getImperial(){
		return imperial;
	}

	@Override
 	public String toString(){
		return 
			"Height{" + 
			"metric = '" + metric + '\'' + 
			",imperial = '" + imperial + '\'' + 
			"}";
		}
}