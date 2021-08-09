package com.example.countriesapp.service;

import com.example.countriesapp.model.CatFacts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCatFactsService {

    public static final String BASE_URL = "https://catfact.ninja";
    
    @GET("/fact")
    Call<CatFacts> getCatFacts();

}
