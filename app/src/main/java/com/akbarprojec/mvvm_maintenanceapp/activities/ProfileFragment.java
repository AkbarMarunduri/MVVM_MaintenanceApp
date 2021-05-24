package com.akbarprojec.mvvm_maintenanceapp.activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentProfileBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.akbarprojec.mvvm_maintenanceapp.ultility.Constant;
import com.akbarprojec.mvvm_maintenanceapp.ultility.PreferenceManeger;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;


public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    View view;
    PreferenceManeger preferenceManeger;
    User user;
    View dialogView;
    TextInputEditText oldPassword, newPassword, rePassword;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferenceManeger = new PreferenceManeger(getActivity());

        doInisialization();

    }

    private void doInisialization() {

        try {
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<User> jsonAdapter = moshi.adapter(User.class);
            user = jsonAdapter.fromJson(preferenceManeger.getUser(Constant.KEY_USER));
            String level = user.getLevel();

            if (level.equals("1")) {
                binding.tvLevel.setText("Production");
            } else if (level.equals("2")) {
                binding.tvLevel.setText("Maintenance");
            } else if (level.equals("3")) {
                binding.tvLevel.setText("Manager");
            }

            binding.ivProfile.setImageResource(R.drawable.user);
            binding.tvUserid.setText(user.getIduser());
            binding.tvNik.setText(user.getNik());
            binding.tvUsername.setText(user.getName());
            binding.tvPlant.setText(user.getPlant());
            binding.tvJabatan.setText(user.getJabatan());
            binding.tvTelp.setText(user.getTelp());
        } catch (IOException e) {
            e.printStackTrace();
        }

        binding.btChangePassword.setOnClickListener(v -> {
            dialogView = getLayoutInflater().inflate(R.layout.change_password_layout, null);
            oldPassword = (TextInputEditText) dialogView.findViewById(R.id.tvOldPasswor);
            newPassword = (TextInputEditText) dialogView.findViewById(R.id.tvNewPassword);
            rePassword = (TextInputEditText) dialogView.findViewById(R.id.tvRetryNewPassword);

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setView(dialogView);
            builder.setTitle("Change password");
            builder.setIcon(R.drawable.ic_profile);
            builder.setCancelable(true);
            builder.setPositiveButton("Change", (dialog, which) -> {
                binding.tvUsername.setText(oldPassword.getText().toString());
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> {
                Toast.makeText(getActivity(), "change password cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
            builder.show();
        });
    }

    public void changePassword() {
        String oldPss, newPass, rePass;
        if (TextUtils.isEmpty(oldPassword.getText().toString())) {
            oldPassword.setError("Masukkan password lama anda");
            oldPassword.requestFocus();
        } else if (TextUtils.isEmpty(newPassword.getText().toString())) {
            newPassword.setError("Masukkan password baru");
            newPassword.requestFocus();
        } else if (TextUtils.isEmpty(rePassword.getText().toString())) {
            rePassword.setError("Masukkan ulang password baru");
        } else if (!newPassword.getText().equals(rePassword.getText())) {
            rePassword.setError("password baru tidak sesuai");
            rePassword.setText("");
            rePassword.requestFocus();
        } else {
            Toast.makeText(getActivity(), "Password sudah diubah", Toast.LENGTH_SHORT).show();
        }
    }
}