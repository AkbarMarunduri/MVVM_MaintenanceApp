package com.akbarprojec.mvvm_maintenanceapp.activities;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentNotifikasiBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.NotifikasiListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.NotifikasiViewModel;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * create an instance of this fragment.
 */
public class NotifikasiFragment extends Fragment implements NotifikasiListener {
    FragmentNotifikasiBinding fragmentNotifikasiBinding;
    View view;
    private NotifikasiViewModel viewModel;

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
        fragmentNotifikasiBinding.fabAdd.setOnClickListener(view1 -> Toast.makeText(getActivity(),"Fab Action Clicked!!",Toast.LENGTH_LONG).show());
        lodaListNotifikasi();
    }

    private void lodaListNotifikasi() {
        viewModel.getNotifikasiList().observe(getActivity(), listNotifikasi -> {
            fragmentNotifikasiBinding.notifikasiRecycleView.setAdapter(new NotifikasiAdaptor(listNotifikasi.getListNotifikasi(), this));
        });
    }

    @Override
    public void onClickNotifikasiItem(Notifikasi notifikasi) {
        Intent intent = new Intent(getActivity(), DetailNotifikasiActivity.class);
        intent.putExtra("notifikasi", notifikasi);
        startActivity(intent);
        Toast.makeText(getContext(), "Action Clicket at "+notifikasi.getNoNotifikasi()+" !!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLongClickNotifikasiItem(Notifikasi notifikasi) {
        if (notifikasi.isSelected) {
            fragmentNotifikasiBinding.actionSelected.setVisibility(View.VISIBLE);
            fragmentNotifikasiBinding.bottomAppBar.setVisibility(View.GONE);
        }else {
            fragmentNotifikasiBinding.actionSelected.setVisibility(View.GONE);
            fragmentNotifikasiBinding.bottomAppBar.setVisibility(View.VISIBLE);
        }
    }
}