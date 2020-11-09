package com.akbarprojec.mvvm_maintenanceapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityMainBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private LoginViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mainBinding.userName.getText())) {
                    Toast.makeText(getApplicationContext(), "Username harus diisi", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(mainBinding.pasword.getText())) {
                    Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else {
                    doInitialitation();
                }
            }
        });
    }

    private void doInitialitation() {
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        doLogin(mainBinding.userName.getText().toString().trim(),mainBinding.pasword.getText().toString().trim());
    }

    private void doLogin(String user, String pass) {
        loginViewModel.getLoginData(user, pass).observe(this,getLoginData-> {
            if (getLoginData.getValue() != 0) {
                User userLogin = getLoginData.getResultUser().get(0);
                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", userLogin);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
            }
        });
    }
}