package com.akbarprojec.mvvm_maintenanceapp.listener;

import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.List;

public interface NotifikasiListener {
    void onClickNotifikasiItem(Notifikasi notifikasi);

    void onLongClickNotifikasiItem(List<Notifikasi> notifSelected);
}
