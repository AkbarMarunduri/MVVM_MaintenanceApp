package com.akbarprojec.mvvm_maintenanceapp.listener;

import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

public interface NotifikasiListener {
    void onClickNotifikasiItem(Notifikasi notifikasi);

    void onLongClickNotifikasiItem(Notifikasi notifikasi);
}
