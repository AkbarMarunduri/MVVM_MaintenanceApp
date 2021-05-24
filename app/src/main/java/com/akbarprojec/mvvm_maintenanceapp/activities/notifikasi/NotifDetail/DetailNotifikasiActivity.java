package com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.NotifDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityDetailNotifikasiBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.akbarprojec.mvvm_maintenanceapp.pager.NotifikasiDetailPagerAdaptor;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailNotifikasiActivity extends AppCompatActivity {
    Notifikasi notifikasi;
    ActivityDetailNotifikasiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_notifikasi);
        doInitialization();
    }

    void doInitialization() {
        binding.imageBack.setOnClickListener(view -> onBackPressed());

        notifikasi = getIntent().getParcelableExtra("data");
        binding.titleNotifikasi.setText(notifikasi.getNoNotifikasi());
        binding.tvNomor.setText(notifikasi.getNoNotifikasi());
        binding.tvDescription.setText(notifikasi.getDescNotifikasi());
        binding.tvStatus.setText(notifikasi.getStsNotif());
        binding.tvTanggal.setText(notifikasi.getTgl());
//
//        NotifikasiDetailPagerAdaptor adaptor = new NotifikasiDetailPagerAdaptor(getSupportFragmentManager());
//        binding.viewPager.setAdapter(adaptor);
//        binding.tabNotifikasi.setupWithViewPager(binding.viewPager);
    }
}