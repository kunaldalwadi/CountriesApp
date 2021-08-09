package com.example.countriesapp.view;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.countriesapp.R;
import com.example.countriesapp.model.CatFacts;
import com.example.countriesapp.service.GetCatFactsService;
import com.example.countriesapp.service.RetrofitInstance;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        getFacts();
    }
    
    public void getFacts(){
    
        GetCatFactsService facts = RetrofitInstance.getFacts();
        Call<CatFacts> catFacts = facts.getCatFacts();
        catFacts.enqueue(new Callback<CatFacts>() {
            @Override
            public void onResponse(Call<CatFacts> call, Response<CatFacts> response) {
               
                CatFacts body = response.body();
                
                if (body != null)
                {
                    String fact = body.getFact();
                    Integer length = body.getLength();
                    
                    String display = fact + " \n" + length;
    
                    Log.d(TAG, "Response = " + display);
                }
                
            }
    
            @Override
            public void onFailure(Call<CatFacts> call, Throwable t) {
                Log.d(TAG, "Service Call Failed. " + t.getMessage());
            }
        });
    
    }
}