package com.akbarprojec.mvvm_maintenanceapp.activities;

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
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentNewNotifBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.NotifikasiListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.ArrayList;
import java.util.List;

public class NewNotifFragment extends Fragment implements NotifikasiListener {
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

        binding.fabAdd.setOnClickListener(v -> Toast.makeText(getContext(), "Notifikasi" + newNotifList.size(), Toast.LENGTH_LONG).show());

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