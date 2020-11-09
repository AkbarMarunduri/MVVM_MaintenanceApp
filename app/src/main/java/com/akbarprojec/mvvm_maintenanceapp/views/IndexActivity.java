package com.akbarprojec.mvvm_maintenanceapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import kotlin.jvm.JvmOverloads;

import android.os.Bundle;
import android.widget.Toast;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityIndexBinding;
import com.akbarprojec.mvvm_maintenanceapp.databinding.LayoutMenuNavHeaderBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.google.android.material.navigation.NavigationView;

public class IndexActivity extends AppCompatActivity {
    ActivityIndexBinding activityIndexBinding;
    LayoutMenuNavHeaderBinding layoutMenuNavHeaderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityIndexBinding = DataBindingUtil.setContentView(this, R.layout.activity_index);
        User user = getIntent().getParcelableExtra("user");

        //mengaktifkan icon menu pada bar
        final DrawerLayout drawerLayout = activityIndexBinding.drawerLayout;
        activityIndexBinding.imageMenu.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        activityIndexBinding.navigationView.setItemIconTintList(null);
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(activityIndexBinding.navigationView, navController);
    }

}