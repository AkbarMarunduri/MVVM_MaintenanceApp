package com.akbarprojec.mvvm_maintenanceapp.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentApprNotifBinding;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentNewNotifBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.NotifikasiListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.ArrayList;
import java.util.List;

public class ApprNotifFragment extends Fragment implements NotifikasiListener {
    FragmentApprNotifBinding binding;
    View view;
    List<Notifikasi> apprNotifikasi = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_appr_notif,container,false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        doInitializasion();
    }

    private void doInitializasion() {
        apprNotifikasi = getArguments().getParcelableArrayList("data");
        if (apprNotifikasi.size() > 0) {
            NotifikasiAdaptor notifikasiAdaptor = new NotifikasiAdaptor(apprNotifikasi, this);
            binding.apprNotifRv.setAdapter(notifikasiAdaptor);
        } else {
            binding.emptyLogo.setVisibility(View.VISIBLE);
            binding.apprNotifRv.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClickNotifikasiItem(Notifikasi notifikasi) {

    }

    @Override
    public void onLongClickNotifikasiItem(List<Notifikasi> notifSelected) {

    }
}