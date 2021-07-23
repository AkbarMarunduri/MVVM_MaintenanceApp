package com.akbarprojec.mvvm_maintenanceapp.activities.notifikasi.NotifDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityDetailNotifikasiBinding;
import com.akbarprojec.mvvm_maintenanceapp.dialog.CostumDialog;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class DetailNotifikasiActivity extends AppCompatActivity {
    Notifikasi notifikasi;
    ActivityDetailNotifikasiBinding binding;
    View dialogView;

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

        genereteQrCode();

    }

    void genereteQrCode() {
        try {
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.encodeBitmap("contect", BarcodeFormat.QR_CODE, 200, 200);
            binding.QrCode.setImageBitmap(bitmap);

            dialogView = getLayoutInflater().inflate(R.layout.qr_code_view, null);
            binding.QrCode.setOnClickListener(v -> {
                CostumDialog dialog = new CostumDialog(DetailNotifikasiActivity.this);
                dialog.setCode(bitmap);
                dialog.show();
            });
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}