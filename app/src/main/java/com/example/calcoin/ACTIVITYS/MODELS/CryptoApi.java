package com.example.calcoin.ACTIVITYS.MODELS;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoApi {
    @GET("prices?key=a515f2a11672b5b6b93b4bba6856ed38")
    Call<List<CryptoModel>> getData();
}