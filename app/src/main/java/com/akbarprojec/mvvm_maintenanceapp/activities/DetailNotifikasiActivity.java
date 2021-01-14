package com.akbarprojec.mvvm_maintenanceapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityDetailNotifikasiBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

public class DetailNotifikasiActivity extends AppCompatActivity {
    Notifikasi notifikasi;

    ActivityDetailNotifikasiBinding notifikasiBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notifikasiBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_notifikasi);
        doInitialization();
    }

    void doInitialization() {
        notifikasiBinding.imageBack.setOnClickListener(view -> onBackPressed());
        notifikasi = getIntent().getParcelableExtra("notifikasi");
        notifikasiBinding.titleNotifikasi.setText(notifikasi.getNoNotifikasi());
    }
}