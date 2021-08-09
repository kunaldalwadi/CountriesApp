package com.example.countriesapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.countriesapp.service.GetCatFactsService.BASE_URL;

public class RetrofitInstance {
    
    private static Retrofit mRetrofit = null;
    
    public static GetCatFactsService getFacts()
    {
        if (mRetrofit == null)
        {
            mRetrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        }
        return mRetrofit.create(GetCatFactsService.class);
    }
    
}
