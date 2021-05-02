package com.akbarprojec.mvvm_maintenanceapp.repositories;

import com.akbarprojec.mvvm_maintenanceapp.networks.ApiClient;
import com.akbarprojec.mvvm_maintenanceapp.networks.MaintenanceInterface;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {
    private MaintenanceInterface maintenanceInterface;

    public OrderRepository() {
        maintenanceInterface = ApiClient.getRetrofit().create(MaintenanceInterface.class);
    }

    public LiveData<ResponseValue> getDataListOrder() {
        MutableLiveData<ResponseValue> data = new MutableLiveData<>();
        maintenanceInterface.getListOrder().enqueue(new Callback<ResponseValue>() {
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
