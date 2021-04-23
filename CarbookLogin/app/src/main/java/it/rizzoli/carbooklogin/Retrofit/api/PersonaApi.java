package it.rizzoli.carbooklogin.Retrofit.api;

import it.rizzoli.carbooklogin.model.Persona;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PersonaApi {

    @POST("/nuovaPersona")
    Call<Persona> nuovaPersona(@Body Persona persona);

    @POST("/accesso")
    Call<Persona> accesso(@Body Persona persona);

    @GET("/persone/username/{username}")
    Call<Persona> byUsername(@Path("username") String username);




}