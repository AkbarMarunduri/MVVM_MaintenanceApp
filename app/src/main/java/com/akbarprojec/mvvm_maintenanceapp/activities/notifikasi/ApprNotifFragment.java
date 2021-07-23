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
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentApprNotifBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.DetailNotifListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.ArrayList;
import java.util.List;

public class ApprNotifFragment extends Fragment implements DetailNotifListener {
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
    public void onClickItem(Notifikasi notifikasi) {
        Intent intent = new Intent(getActivity(), DetailNotifikasiActivity.class);
        intent.putExtra("data", notifikasi);
        startActivity(intent);
    }

    @Override
    public void onLongClickItem(List<Notifikasi> notifSelected) {

    }
}