package com.akbarprojec.mvvm_maintenanceapp.activities.profile;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ChangePasswordLayoutBinding;

public class ChangePasswordDialog extends Dialog {
    public Activity activity;
    ChangePasswordLayoutBinding binding;

    public ChangePasswordDialog(@NonNull Activity context) {
        super(context);
        this.activity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.change_password_layout);

        Button btChange = findViewById(R.id.btChangePassword);
        btChange.setOnClickListener(v-> Toast.makeText(getContext(),"testing",Toast.LENGTH_SHORT).show());
    }
}
