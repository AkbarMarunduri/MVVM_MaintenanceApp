package com.akbarprojec.mvvm_maintenanceapp.listener;

import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.List;

public interface DetailNotifListener {
    void onClickItem(Notifikasi notifikasi);

    void onLongClickItem(List<Notifikasi> notifSelected);
}
