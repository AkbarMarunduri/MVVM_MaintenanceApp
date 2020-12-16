package com.akbarprojec.mvvm_maintenanceapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityLoginBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding loginBinding;
    private LoginViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginBinding.btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(loginBinding.userName.getText())) {
                    Toast.makeText(getApplicationContext(), "Username harus diisi", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(loginBinding.pasword.getText())) {
                    Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else {
                    doInitialitation();
                }
            }
        });
    }

    private void doInitialitation() {
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        doLogin(loginBinding.userName.getText().toString().trim(), loginBinding.pasword.getText().toString().trim());
    }

    private void doLogin(String user, String pass) {
        loginViewModel.getLoginData(user, pass).observe(this, new Observer<ResponseValue>() {
            @Override
            public void onChanged(ResponseValue responseValue) {
                if (responseValue.getValue() != 0) {
                    User userLogin = responseValue.getResultUser().get(0);
                    Intent intent = new Intent(LoginActivity.this, IndexActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("user", userLogin);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}