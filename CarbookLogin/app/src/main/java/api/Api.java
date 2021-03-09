package api;

import model.Automobile;
import model.Persona;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @FormUrlEncoded
    @POST("nuovaPersona")
    Call<Persona> creaPersona(
            @Field("email")String email,
            @Field("password")String password,
            @Field("nome")String nome,
            @Field("cognome")String cognome,
            @Field("username") String username,
            @Field("citta")String citta,
            @Field("telefono")String telefono
    );

    @GET("login")
    Call <Persona> login(
            @Query("email") String email,
            @Query("password") String password
    );

    @FormUrlEncoded
    @POST("automobili")
    Call<Automobile> creaAutomobile(
            @Field("Modello")String modello,
            @Field("Stato")String stato,
            @Field("Chilometri")String chilometri,
            @Field("Alimentazione")String alimentazione,
            @Field("Cambio") String cambio,
            @Field("Cavalli")String cavalli,
            @Field("Prezzo")String prezzo
    );
}
