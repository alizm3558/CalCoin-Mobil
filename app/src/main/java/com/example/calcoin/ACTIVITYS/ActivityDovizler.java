package com.example.calcoin.ACTIVITYS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calcoin.ACTIVITYS.MODELS.CryptoApi;
import com.example.calcoin.ACTIVITYS.MODELS.CryptoModel;
import com.example.calcoin.ACTIVITYS.MODELS.RecyclerViewAdapter;
import com.example.calcoin.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityDovizler extends AppCompatActivity {
TextView isimlik1,ekleText,goster;
String bilgi;
    ArrayList<CryptoModel> cryptoModels;
    private String BASE_URL="https://api.nomics.com/v1/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dovizler);
        getSupportActionBar().hide();
        tanimla();
        intentBilgiAl();
        retrofitTanimla();
        loadData();

    }

    public void retrofitTanimla(){ // çalışıyor
        Gson gson=new GsonBuilder().setLenient().create();
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void loadData(){ // çalışıyor(veriler alınıyor).
        final CryptoApi cryptoApi=retrofit.create(CryptoApi.class);
        Call<List<CryptoModel>> call=cryptoApi.getData();
        call.enqueue(new Callback<List<CryptoModel>>() {
            @Override
            public void onResponse(Call<List<CryptoModel>> call, Response<List<CryptoModel>> response) {
                if(response.isSuccessful()){
                    List<CryptoModel> responList=response.body();
                    cryptoModels=new ArrayList<>(responList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ActivityDovizler.this));
                    recyclerViewAdapter=new RecyclerViewAdapter(cryptoModels); // arraylist
                    recyclerView.setAdapter(recyclerViewAdapter);

                    /*for(CryptoModel cryptoModel:cryptoModels){
                        System.out.println(cryptoModel.currency);
                        System.out.println(cryptoModel.price);
                    }*/
                }
            }

            @Override
            public void onFailure(Call<List<CryptoModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void tanimla(){
        isimlik1=(TextView)findViewById(R.id.isimlik);
        ekleText=(TextView)findViewById(R.id.ekleButonu);
        goster=(TextView)findViewById(R.id.gosterButonu);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

    }
    public void intentBilgiAl(){
        Intent intent=getIntent();
        bilgi=intent.getStringExtra("gelenAd");
        isimlik1.setText(bilgi);
    }
    public void notEkleGit(View view){
        Intent intent=new Intent(ActivityDovizler.this, ActivityNotEkle.class);
        intent.putExtra("gelenad",isimlik1.getText().toString());
        startActivity(intent);
    }
    public void goster(View view){
        Intent intent=new Intent(ActivityDovizler.this, ActivityNotlar.class);
        intent.putExtra("gelenad",isimlik1.getText().toString());
        startActivity(intent);
    }

}
