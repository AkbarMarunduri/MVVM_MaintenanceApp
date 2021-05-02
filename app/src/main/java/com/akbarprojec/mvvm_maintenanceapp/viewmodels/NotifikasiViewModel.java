package com.akbarprojec.mvvm_maintenanceapp.viewmodels;

import com.akbarprojec.mvvm_maintenanceapp.repositories.NotifikasiRepositories;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class NotifikasiViewModel extends ViewModel {

    private NotifikasiRepositories notifikasiRepositories;

    public NotifikasiViewModel() {
        notifikasiRepositories = new NotifikasiRepositories();
    }

    public LiveData<ResponseValue> getNotifikasiList() {
        return notifikasiRepositories.getNorifikasiListData();
    }
}
