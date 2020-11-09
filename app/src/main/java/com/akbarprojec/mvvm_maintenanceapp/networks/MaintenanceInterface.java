package com.akbarprojec.mvvm_maintenanceapp.networks;

import com.akbarprojec.mvvm_maintenanceapp.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MaintenanceInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> loginToApps(@Field("iduser") String id,
                                    @Field("pass") String pasw);
}
