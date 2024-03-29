package it.rizzoli.carbooklogin.Retrofit.api;

import java.util.ArrayList;
import java.util.List;

import it.rizzoli.carbooklogin.model.Persona;
import it.rizzoli.carbooklogin.model.Pubblicazione;
import it.rizzoli.carbooklogin.model.ListaPubblicazione;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PubblicazioneApi {

    @POST("/pubblicazioni")
    Call<Pubblicazione> nuovaPubblicazione (@Body Pubblicazione pubblicazione);

    @GET("/listaPubllicazioni")
        //Call<COSA DEVO RICEVERE> nome (COSA DEVO MANDARE);
    Call<ArrayList<ListaPubblicazione>> list ();

    @GET("/pubblicazioni/persona/{persona}")
    Call<List<Pubblicazione>> byPersona(@Path("persona")Persona persona);
}
