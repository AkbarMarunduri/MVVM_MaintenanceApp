package com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.NotifDetail.DetailNotifikasiActivity;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentNewNotifBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.DetailNotifListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.ArrayList;
import java.util.List;

public class NewNotifFragment extends Fragment implements DetailNotifListener {
    FragmentNewNotifBinding binding;
    View view;
    List<Notifikasi> newNotifList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_notif, container, false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doInitializasion();
    }

    private void doInitializasion() {
        newNotifList = getArguments().getParcelableArrayList("data");
        if (newNotifList.size() > 0) {
            NotifikasiAdaptor notifikasiAdaptor = new NotifikasiAdaptor(newNotifList, this);
            binding.newNotifRv.setAdapter(notifikasiAdaptor);
        } else {
            binding.newNotifRv.setVisibility(View.GONE);
            binding.emptyLogo.setVisibility(View.VISIBLE);
        }

        binding.fabAdd.setOnClickListener(v -> Toast.makeText(getContext(), "Coming soon", Toast.LENGTH_LONG).show());

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