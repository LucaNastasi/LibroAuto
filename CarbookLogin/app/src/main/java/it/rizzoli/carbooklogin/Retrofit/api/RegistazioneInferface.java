package it.rizzoli.carbooklogin.Retrofit.api;

import java.util.ArrayList;

import it.rizzoli.carbooklogin.model.Automobile;
import it.rizzoli.carbooklogin.model.Persona;
import it.rizzoli.carbooklogin.model.Pubblicazione;
import it.rizzoli.carbooklogin.model.listaPubblicazione;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegistazioneInferface {

    @POST("/nuovaPersona")
    Call<Persona> nuovaPersona(@Body Persona persona);

    @POST("/accesso")
    Call<Persona> accesso (@Body Persona persona);

    @POST("/automobili")
    Call<Automobile> nuovoAutomobile (@Body Automobile automobile);

    @POST("/pubblicazioni")
    Call<Pubblicazione> nuovaPubblicazioni (@Body Pubblicazione pubblicazione);

    @GET("/listPubllicazioni")
    //Call<COSA DEVO RICEVERE> nome (COSA DEVO MANDARE);
    Call<ArrayList<listaPubblicazione>> list ();
}