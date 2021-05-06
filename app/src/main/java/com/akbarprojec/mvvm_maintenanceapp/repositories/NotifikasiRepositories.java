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

public class NotifikasiRepositories {

    private MaintenanceInterface maintenanceInterface;

    public NotifikasiRepositories() {
        maintenanceInterface = ApiClient.getRetrofit().create(MaintenanceInterface.class);
    }

    public LiveData<ResponseValue> getNorifikasiListData() {
        MutableLiveData<ResponseValue> data = new MutableLiveData<>();
        maintenanceInterface.getListNotifikasi().enqueue(new Callback<ResponseValue>() {
            @Override
            public void onResponse(@NonNull Call<ResponseValue> call, @NonNull Response<ResponseValue> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseValue> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
