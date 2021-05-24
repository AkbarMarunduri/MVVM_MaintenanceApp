package com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.NotifDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentDataBinding;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentDowntimeBinding;


public class Downtime extends Fragment {
    FragmentDowntimeBinding binding;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_downtime,container,false);
        view = binding.getRoot();
        return view;
    }
}