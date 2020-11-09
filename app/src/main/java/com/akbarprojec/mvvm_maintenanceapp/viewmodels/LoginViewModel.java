package com.akbarprojec.mvvm_maintenanceapp.viewmodels;

import com.akbarprojec.mvvm_maintenanceapp.repositories.LoginRepositories;
import com.akbarprojec.mvvm_maintenanceapp.responses.LoginResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private LoginRepositories loginRepositories;

    public LoginViewModel() {
        loginRepositories = new LoginRepositories();
    }

    public LiveData<LoginResponse> getLoginData(String users, String pass) {
        return loginRepositories.getLoginResponseLiveData(users, pass);
    }
}
