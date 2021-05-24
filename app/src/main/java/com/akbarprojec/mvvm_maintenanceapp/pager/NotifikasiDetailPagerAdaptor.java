package com.akbarprojec.mvvm_maintenanceapp.pager;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.NotifDetail.Data;
import com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.NotifDetail.Downtime;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;


public class NotifikasiDetailPagerAdaptor extends FragmentPagerAdapter {

    public NotifikasiDetailPagerAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    Notifikasi notifikasi;

    public void setData(Notifikasi data) {
        this.notifikasi = data;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "DATA";
                break;
            case 1:
                title = "DOWNTIME";
                break;
        }
        return title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        switch (position) {
            case 0:
                fragment = new Data();
                break;
            case 1:
                fragment = new Downtime();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
