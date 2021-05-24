package com.akbarprojec.mvvm_maintenanceapp.pager;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.ApprNotifFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.CompNotifFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.DeltNotifFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.NewNotifFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.order.ApprOrderFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.order.CompOrderFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.order.DeltOrderFragment;
import com.akbarprojec.mvvm_maintenanceapp.activities.order.NewOrderFragment;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPagerAdaptor extends FragmentPagerAdapter {

    public OrderPagerAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    List<Order> newOrder = new ArrayList<>();
    List<Order> appOrder = new ArrayList<>();
    List<Order> compOrder = new ArrayList<>();
    List<Order> deltOrder = new ArrayList<>();

    public void setDataOrder(List<Order> _newOrder, List<Order> _appOrder, List<Order> _compOrder, List<Order> _deltOrder) {
        this.newOrder = _newOrder;
        this.appOrder = _appOrder;
        this.compOrder = _compOrder;
        this.deltOrder = _deltOrder;
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
                fragment = new NewOrderFragment();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) newOrder);
                fragment.setArguments(bundle);
                break;
            case 1:
                fragment = new ApprOrderFragment();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) appOrder);
                fragment.setArguments(bundle);
                break;
            case 2:
                fragment = new CompOrderFragment();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) compOrder);
                fragment.setArguments(bundle);
                break;
            case 3:
                fragment = new DeltOrderFragment();
                bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) deltOrder);
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
