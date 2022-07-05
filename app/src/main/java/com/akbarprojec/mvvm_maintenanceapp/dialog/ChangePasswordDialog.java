package com.akbarprojec.mvvm_maintenanceapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ChangePasswordLayoutBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.akbarprojec.mvvm_maintenanceapp.networks.ApiClient;
import com.akbarprojec.mvvm_maintenanceapp.networks.MaintenanceInterface;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;
import com.akbarprojec.mvvm_maintenanceapp.ultility.Constant;
import com.akbarprojec.mvvm_maintenanceapp.ultility.PreferenceManeger;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordDialog extends Dialog {
    public Activity activity;
    PreferenceManeger preferenceManeger;
    User user;
    ChangePasswordLayoutBinding binding;
    public ChangePasswordDialog(@NonNull Activity context) {
        super(context);
        this.activity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.change_password_layout);

        Button btChange = findViewById(R.id.btChangePassword);
        TextView oldPassword = findViewById(R.id.tvOldPasswor);
        TextView newPassword = findViewById(R.id.tvNewPassword);
        TextView rePassword = findViewById(R.id.tvRetryNewPassword);

        preferenceManeger = new PreferenceManeger(getContext());
        try {
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<User> jsonAdapter = moshi.adapter(User.class);
            user = jsonAdapter.fromJson(preferenceManeger.getUser(Constant.KEY_USER));

            btChange.setOnClickListener(v -> {
                if (TextUtils.isEmpty(oldPassword.getText().toString().trim())) {
                    oldPassword.setError("Tidak boleh kosong");
                    oldPassword.requestFocus();
                } else if (TextUtils.isEmpty(newPassword.getText().toString().trim())) {
                    newPassword.setError("Tidak boleh kosong");
                    newPassword.requestFocus();
                } else if (TextUtils.isEmpty(rePassword.getText().toString().trim())) {
                    rePassword.setError("Tidak boleh kosong");
                    rePassword.requestFocus();
                } else if (!rePassword.getText().toString().equals(newPassword.getText().toString())) {
                    rePassword.setError("Confirm password tidak sama");
                    rePassword.requestFocus();
                } else {
                    MaintenanceInterface service = ApiClient.getRetrofit().create(MaintenanceInterface.class);
                    service.changePassword(user.getIduser(), oldPassword.getText().toString(), rePassword.getText().toString()).enqueue(new Callback<ResponseValue>() {
                        @Override
                        public void onResponse(Call<ResponseValue> call, Response<ResponseValue> response) {
                            if (response.body().getValue() == 1) {
                                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            dismiss();
                        }

                        @Override
                        public void onFailure(Call<ResponseValue> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
