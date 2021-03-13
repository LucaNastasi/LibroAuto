package it.rizzoli.carbooklogin.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    public static final String BASE_URL = "http://192.168.43.146:8080/";

    public static Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy")
            .create();

    public static Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();




}
