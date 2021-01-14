package com.akbarprojec.mvvm_maintenanceapp.networks;

import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MaintenanceInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseValue> loginToApps(@Field("iduser") String id,
                                    @Field("pass") String pasw);
    @FormUrlEncoded
    @POST("logout.php")
    Call<ResponseValue> logOutApp(@Field("iduser") String id);

    @GET("Notifikasi.php")
    Call<ResponseValue> getListNotifikasi();

    @GET("Order.php")
    Call<ResponseValue> getListOrder();
}
