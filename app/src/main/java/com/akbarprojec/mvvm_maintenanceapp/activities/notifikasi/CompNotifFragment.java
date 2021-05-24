package com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.NotifDetail.DetailNotifikasiActivity;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentCompNotifBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.NotifikasiListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.ArrayList;
import java.util.List;

public class CompNotifFragment extends Fragment implements NotifikasiListener {
    FragmentCompNotifBinding binding;
    View view;
    List<Notifikasi> compNotifikasi = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comp_notif, container, false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        doInitializasion();
    }
    private void doInitializasion() {
        compNotifikasi = getArguments().getParcelableArrayList("data");
        if (compNotifikasi.size() > 0) {
            NotifikasiAdaptor notifikasiAdaptor = new NotifikasiAdaptor(compNotifikasi, this);
            binding.compNotifRv.setAdapter(notifikasiAdaptor);
        } else {
            binding.compNotifRv.setVisibility(View.GONE);
            binding.emptyLogo.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClickNotifikasiItem(Notifikasi notifikasi) {
        Intent intent = new Intent(getActivity(), DetailNotifikasiActivity.class);
        intent.putExtra("data", notifikasi);
        startActivity(intent);
    }

    @Override
    public void onLongClickNotifikasiItem(List<Notifikasi> notifSelected) {

    }
}