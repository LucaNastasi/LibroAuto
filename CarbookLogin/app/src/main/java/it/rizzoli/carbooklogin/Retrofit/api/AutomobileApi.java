package it.rizzoli.carbooklogin.Retrofit.api;

import it.rizzoli.carbooklogin.model.Automobile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AutomobileApi {
    @POST("/automobili")
    Call<Automobile> nuovaAutomobile (@Body Automobile automobile);

}
