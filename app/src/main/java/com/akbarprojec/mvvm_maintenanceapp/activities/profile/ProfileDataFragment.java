package com.akbarprojec.mvvm_maintenanceapp.activities.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentProfileDataBinding;
import com.akbarprojec.mvvm_maintenanceapp.dialog.ChangePasswordDialog;
import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.akbarprojec.mvvm_maintenanceapp.ultility.Constant;
import com.akbarprojec.mvvm_maintenanceapp.ultility.PreferenceManeger;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class ProfileDataFragment extends Fragment {
    FragmentProfileDataBinding binding;
    View view;
    PreferenceManeger preferenceManeger;
    User user;
    View dialogView;
    TextInputEditText oldPassword, newPassword, rePassword;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_data, container, false);
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

        //memanggi dialog ganti password
        binding.btChangePassword.setOnClickListener(v -> {
            ChangePasswordDialog changeDialog = new ChangePasswordDialog(getActivity());
            changeDialog.show();
        });
    }

}