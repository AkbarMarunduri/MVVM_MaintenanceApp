package com.akbarprojec.mvvm_maintenanceapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityIndexBinding;
import com.akbarprojec.mvvm_maintenanceapp.databinding.LayoutMenuNavHeaderBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.NotifikasiViewModel;
import com.google.android.material.navigation.NavigationView;

public class IndexActivity extends AppCompatActivity {
    ActivityIndexBinding activityIndexBinding;
    LayoutMenuNavHeaderBinding layoutMenuNavHeaderBinding;
    NavigationView navigationView;
    View view;
    NotifikasiViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityIndexBinding = DataBindingUtil.setContentView(this, R.layout.activity_index);

        //mengaktifkan icon menu pada top bar
        final DrawerLayout drawerLayout = activityIndexBinding.drawerLayout;
        activityIndexBinding.imageMenu.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        //mengatur navigation drawable
        navigationView = activityIndexBinding.navigationView;
        navigationView.setItemIconTintList(null);
        view = navigationView.getHeaderView(0);
        userInformation();

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    private void userInformation() {
        User user = getIntent().getParcelableExtra("user");
        TextView userName = view.findViewById(R.id.nav_username);
        TextView userLevel = view.findViewById(R.id.nav_user_level);

        userName.setText(user.getIduser());

        String level = user.getLevel();
        if (level.equals("1")) {
            userLevel.setText("Production");
        } else if (level.equals("2")) {
            userLevel.setText("Maintenance");
        } else if(level.equals("3")){
            userLevel.setText("Manager");
        }
    }




}