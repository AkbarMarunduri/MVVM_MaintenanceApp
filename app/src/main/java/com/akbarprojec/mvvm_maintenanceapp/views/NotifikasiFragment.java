package com.akbarprojec.mvvm_maintenanceapp.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentNotifikasiBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.akbarprojec.mvvm_maintenanceapp.networks.ApiClient;
import com.akbarprojec.mvvm_maintenanceapp.networks.MaintenanceInterface;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.NotifikasiViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * create an instance of this fragment.
 */
public class NotifikasiFragment extends Fragment {
    FragmentNotifikasiBinding fragmentNotifikasiBinding;
    View view;

    private NotifikasiViewModel viewModel;
    private NotifikasiAdaptor notifikasiAdaptor;

    private MaintenanceInterface anInterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentNotifikasiBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_notifikasi, container, false);
        view = fragmentNotifikasiBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doInitialization();
    }

    private void doInitialization() {
        viewModel = new ViewModelProvider(this).get(NotifikasiViewModel.class);
        lodaListNotifikasi();
    }

    private void lodaListNotifikasi() {
        viewModel.getNotifikasiList().observe(getActivity(), listNotifikasi -> {
            fragmentNotifikasiBinding.notifikasiRecycleView.setAdapter(new NotifikasiAdaptor(listNotifikasi.getListNotifikasi()));
        });
    }

}