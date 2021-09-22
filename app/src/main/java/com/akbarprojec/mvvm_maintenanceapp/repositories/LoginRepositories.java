package com.akbarprojec.mvvm_maintenanceapp.repositories;

import com.akbarprojec.mvvm_maintenanceapp.networks.ApiClient;
import com.akbarprojec.mvvm_maintenanceapp.networks.MaintenanceInterface;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepositories {

    private MaintenanceInterface maintenanceInterface;

    public LoginRepositories() {
        maintenanceInterface = ApiClient.getRetrofit().create(MaintenanceInterface.class);
    }

    public LiveData<ResponseValue> getLoginResponseLiveData(String users, String pass) {
        MutableLiveData<ResponseValue> data = new MutableLiveData<>();
        maintenanceInterface.loginToApps(users,pass).enqueue(new Callback<ResponseValue>() {
            @Override
            public void onResponse(Call<ResponseValue> call, Response<ResponseValue> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseValue> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
