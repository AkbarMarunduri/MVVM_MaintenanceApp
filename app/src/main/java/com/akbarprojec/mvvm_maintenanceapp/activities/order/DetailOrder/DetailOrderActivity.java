package com.akbarprojec.mvvm_maintenanceapp.activities.order.DetailOrder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.dialog.CostumDialog;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityDetailOrderBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;
import com.akbarprojec.mvvm_maintenanceapp.pager.OrderDetailPagerAdaptor;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class DetailOrderActivity extends AppCompatActivity {
    ActivityDetailOrderBinding binding;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_order);
        doInitialization();
    }

    private void doInitialization() {
        genereteQrCode();

        Order order = getIntent().getParcelableExtra("data");
        binding.tvNomor.setText(order.getNoOrder());
        binding.tvDescription.setText(order.getDescOrder());
        binding.tvStatus.setText(order.getStsOrder());
        binding.tvTanggal.setText(order.getTanggal());

        OrderDetailPagerAdaptor adaptor = new OrderDetailPagerAdaptor(getSupportFragmentManager());
        binding.viewPager.setAdapter(adaptor);
        binding.tabNotifikasi.setupWithViewPager(binding.viewPager);

        binding.imageBack.setOnClickListener(v -> onBackPressed());

    }

    private void genereteQrCode() {

        try {
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.encodeBitmap("contect", BarcodeFormat.QR_CODE, 200, 200);
            binding.QrCode.setImageBitmap(bitmap);
            dialogView = getLayoutInflater().inflate(R.layout.qr_code_view, null);

            binding.QrCode.setOnClickListener(v -> {
                CostumDialog dialog = new CostumDialog(DetailOrderActivity.this);
                dialog.setCode(bitmap);
                dialog.show();
            });
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}