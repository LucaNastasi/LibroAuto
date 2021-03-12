package it.rizzoli.carbooklogin.api;

import it.rizzoli.carbooklogin.model.Pubblicazione;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiPubblicazione {

    @FormUrlEncoded
    @POST("pubblicazioni")
    Call<Pubblicazione> creaPubblicazione(
            @Field("dataPubblicazione") String dataPubblicazione,
            @Field("descrizione") String descrizione
    );
}
