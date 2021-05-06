package com.akbarprojec.mvvm_maintenanceapp.pager;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.akbarprojec.mvvm_maintenanceapp.activities.ApprNotifFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.CompNotifFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.DeltNotifFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.NewNotifFragment;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;
import java.util.List;

public class NotifikasiPagerAdaptor extends FragmentPagerAdapter {

    public NotifikasiPagerAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    List<Notifikasi> newNotifikasi = new ArrayList<>();
    List<Notifikasi> aproveNotifikasi = new ArrayList<>();
    List<Notifikasi> compNotifikasi = new ArrayList<>();
    List<Notifikasi> deltNotifikasi = new ArrayList<>();

    public void setData(List<Notifikasi> newNotifikasi, List<Notifikasi> appNotifikasi, List<Notifikasi> compNotifikasi, List<Notifikasi> deltNotifikasi) {
        this.newNotifikasi = newNotifikasi;
        this.aproveNotifikasi = appNotifikasi;
        this.compNotifikasi = compNotifikasi;
        this.deltNotifikasi = deltNotifikasi;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "NEW";
                break;
            case 1:
                title = "APPROVE";
                break;
            case 2:
                title = "COMPLETE";
                break;
            case 3:
                title = "DELETE";
                break;
            default:
                title = "";
        }
        return title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                fragment = new NewNotifFragment();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) newNotifikasi);
                fragment.setArguments(bundle);
                break;
            case 1:
                fragment = new ApprNotifFragment();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) aproveNotifikasi);
                fragment.setArguments(bundle);
                break;
            case 2:
                fragment = new CompNotifFragment();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) compNotifikasi);
                fragment.setArguments(bundle);
                break;
            case 3:
                fragment = new DeltNotifFragment();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) deltNotifikasi);
                fragment.setArguments(bundle);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
