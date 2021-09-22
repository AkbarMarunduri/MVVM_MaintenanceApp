package com.akbarprojec.mvvm_maintenanceapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityLoginBinding;

import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.akbarprojec.mvvm_maintenanceapp.networks.ApiClient;
import com.akbarprojec.mvvm_maintenanceapp.networks.MaintenanceInterface;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;
import com.akbarprojec.mvvm_maintenanceapp.ultility.Constant;
import com.akbarprojec.mvvm_maintenanceapp.ultility.PreferenceManeger;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.LoginViewModel;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding loginBinding;
    private LoginViewModel loginViewModel;
    private PreferenceManeger preferenceManeger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        preferenceManeger = new PreferenceManeger(getApplicationContext());
        //memeriksa apakah data login sudah ada di sharepreference
        if (preferenceManeger.getBoolean(Constant.KEY_IS_SINGED_IN)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }

        doInitialitation();

        loginBinding.btlogin.setOnClickListener(view -> {
            if (TextUtils.isEmpty(loginBinding.userName.getText())) {
                Toast.makeText(getApplicationContext(), "Username harus diisi", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty(loginBinding.pasword.getText())) {
                Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_LONG).show();
            } else {
//                doInitialitation();
                doLogin(loginBinding.userName.getText().toString().trim(), loginBinding.pasword.getText().toString().trim());
            }
        });
    }

    private void doInitialitation() {
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    private void doLogin(String username, String pass) {

        loginViewModel.getLoginData(username, pass).observe(this, responseValue -> {
            if (responseValue.getValue() > 0) {

                //parse moshi ke json untuk disimpan ke preference
                Moshi moshi = new Moshi.Builder().build();
                JsonAdapter<User> jsonAdapter = moshi.adapter(User.class);
                String user = jsonAdapter.toJson(responseValue.getResultUser());

                //set data user ke preferencemaneger
                preferenceManeger.putUser(Constant.KEY_USER, user);
                preferenceManeger.putBoolean(Constant.KEY_IS_SINGED_IN, true);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "gagal login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}