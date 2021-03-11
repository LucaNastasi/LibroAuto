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

    @POST("")

    @GET("login")
    Call <Persona> login(
            @Query("email") String email,
            @Query("password") String password
    );

    @FormUrlEncoded
    @POST("automobili")
    Call<Automobile> creaAutomobile(
            @Field("modello")String modello,
            @Field("stato")String stato,
            @Field("chilometraggio")String chilometraggio,
            @Field("alimentazione")String alimentazione,
            @Field("cambio") String cambio,
            @Field("potenza")String potenza,
            @Field("costo")String costo,
            @Field("marca")String marca,
            @Field("annoImmatricolazione")String annoImmatricolazione,
            @Field("citta") String citta

    );
}
