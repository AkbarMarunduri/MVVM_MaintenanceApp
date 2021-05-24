package com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentDeltNotifBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.NotifikasiListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.ArrayList;
import java.util.List;

public class DeltNotifFragment extends Fragment implements NotifikasiListener {
    FragmentDeltNotifBinding binding;
    View view;
    List<Notifikasi> deltNotifikasi = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_delt_notif, container, false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doInitializasion();
    }

    private void doInitializasion() {
        deltNotifikasi = getArguments().getParcelableArrayList("data");

        if (deltNotifikasi.size() > 0) {
            NotifikasiAdaptor notifikasiAdaptor = new NotifikasiAdaptor(deltNotifikasi, this);
            binding.deltNotifRv.setAdapter(notifikasiAdaptor);
        } else {
            binding.emptyLogo.setVisibility(View.VISIBLE);
            binding.deltNotifRv.setVisibility(View.GONE);
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClickNotifikasiItem(Notifikasi notifikasi) {

    }

    @Override
    public void onLongClickNotifikasiItem(List<Notifikasi> notifSelected) {

    }
}