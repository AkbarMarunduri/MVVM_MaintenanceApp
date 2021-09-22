package com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentNotifikasiBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.DetailNotifListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.akbarprojec.mvvm_maintenanceapp.pager.NotifikasiPagerAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.NotifikasiViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * <p>
 * create an instance of this fragment.
 */
public class NotifikasiFragment extends Fragment implements DetailNotifListener {
    FragmentNotifikasiBinding fragmentNotifikasiBinding;
    View view;
    private NotifikasiViewModel viewModel;

    List<Notifikasi> newNotifikasi = new ArrayList<>();
    List<Notifikasi> aproveNotifikasi = new ArrayList<>();
    List<Notifikasi> compNotifikasi = new ArrayList<>();
    List<Notifikasi> deltNotifikasi = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        viewModel.getNotifikasiList().observe(getViewLifecycleOwner(), notifikasiResponse -> {
            for (Notifikasi notifikasi : notifikasiResponse.getListNotifikasi()) {
                if (notifikasi.getStsNotif().equalsIgnoreCase("NEW")) {
                    newNotifikasi.add(notifikasi);
                } else if (notifikasi.getStsNotif().equalsIgnoreCase("APPR")) {
                    aproveNotifikasi.add(notifikasi);
                } else if (notifikasi.getStsNotif().equalsIgnoreCase("COMP")) {
                    compNotifikasi.add(notifikasi);
                } else if (notifikasi.getStsNotif().equalsIgnoreCase("DELT")) {
                    deltNotifikasi.add(notifikasi);
                }
            }

            NotifikasiPagerAdaptor pagerAdaptor = new NotifikasiPagerAdaptor(getChildFragmentManager());
            pagerAdaptor.setData(newNotifikasi, aproveNotifikasi, compNotifikasi, deltNotifikasi);
            fragmentNotifikasiBinding.viewPager.setAdapter(pagerAdaptor);
            fragmentNotifikasiBinding.tabNotifikasi.setupWithViewPager(fragmentNotifikasiBinding.viewPager);

//            fragmentNotifikasiBinding.tabNotifikasi.getTabAt(0).getOrCreateBadge().setNumber(newNotifikasi.size());
//            fragmentNotifikasiBinding.tabNotifikasi.getTabAt(1).getOrCreateBadge().setNumber(aproveNotifikasi.size());
//            fragmentNotifikasiBinding.tabNotifikasi.getTabAt(2).getOrCreateBadge().setNumber(compNotifikasi.size());
//            fragmentNotifikasiBinding.tabNotifikasi.getTabAt(3).getOrCreateBadge().setNumber(deltNotifikasi.size());

        });
    }

    @Override
    public void onClickItem(Notifikasi notifikasi) {

    }

    @Override
    public void onLongClickItem(List<Notifikasi> notifSelected) {

    }
}