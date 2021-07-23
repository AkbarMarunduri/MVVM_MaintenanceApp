package com.akbarprojec.mvvm_maintenanceapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.akbarprojec.mvvm_maintenanceapp.R;

public class CostumDialog extends Dialog {
    public Activity activity;
    Bitmap code;

    public void setCode(Bitmap code) {
        this.code = code;
    }

    public CostumDialog(@NonNull Activity context) {
        super(context);
        this.activity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qr_code_view);
        ImageView barcode = findViewById(R.id.qrCodeView);
        barcode.setImageBitmap(code);
    }
}
