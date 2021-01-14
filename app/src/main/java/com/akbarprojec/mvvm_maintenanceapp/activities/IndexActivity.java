package com.akbarprojec.mvvm_maintenanceapp.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.ActivityIndexBinding;
import com.akbarprojec.mvvm_maintenanceapp.databinding.LayoutMenuNavHeaderBinding;
import com.akbarprojec.mvvm_maintenanceapp.networks.ApiClient;
import com.akbarprojec.mvvm_maintenanceapp.networks.MaintenanceInterface;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;
import com.akbarprojec.mvvm_maintenanceapp.ultility.Constant;
import com.akbarprojec.mvvm_maintenanceapp.ultility.PreferenceManeger;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.NotifikasiViewModel;
import com.google.android.material.navigation.NavigationView;

public class IndexActivity extends AppCompatActivity {
    ActivityIndexBinding activityIndexBinding;
    LayoutMenuNavHeaderBinding layoutMenuNavHeaderBinding;
    NavigationView navigationView;
    View view;
    NotifikasiViewModel viewModel;
    private PreferenceManeger preferenceManeger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityIndexBinding = DataBindingUtil.setContentView(this, R.layout.activity_index);

        preferenceManeger = new PreferenceManeger(getApplicationContext());

        //mengaktifkan icon menu pada top bar
        final DrawerLayout drawerLayout = activityIndexBinding.drawerLayout;
        activityIndexBinding.imageMenu.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        //mengatur navigation drawable
        navigationView = activityIndexBinding.navigationView;
        navigationView.setItemIconTintList(null);
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
        navigationView.setItemIconTintList(ColorStateList.valueOf(Color.WHITE));
        view = navigationView.getHeaderView(0);


        userInformation();

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> activityIndexBinding.titleMain.setText(destination.getLabel()));

    }

    private void userInformation() {
        TextView userName = view.findViewById(R.id.nav_username);
        TextView userLevel = view.findViewById(R.id.nav_user_level);

        userName.setText(preferenceManeger.getString(Constant.KEY_USER_NAME));
        String level = preferenceManeger.getString(Constant.KEY_USER_LEVEL);
        if (level.equals("1")) {
            userLevel.setText("Production");
        } else if (level.equals("2")) {
            userLevel.setText("Maintenance");
        } else if(level.equals("3")){
            userLevel.setText("Manager");
        }
    }


    private void logOut(String id) {
        MaintenanceInterface anInterface = ApiClient.getRetrofit().create(MaintenanceInterface.class);
        anInterface.logOutApp(id).enqueue(new Callback<ResponseValue>() {
            @Override
            public void onResponse(Call<ResponseValue> call, Response<ResponseValue> response) {
                if (response.body().getValue()==1) {
                    Toast.makeText(IndexActivity.this, "Berhasil logout", Toast.LENGTH_SHORT).show();
                }else{

                }
            }

            @Override
            public void onFailure(Call<ResponseValue> call, Throwable t) {

            }
        });
    }


}