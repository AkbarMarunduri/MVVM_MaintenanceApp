package com.akbarprojec.mvvm_maintenanceapp.activities.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.NotifikasiAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.OrdersAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentApprNotifBinding;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentDeltOrderBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.NotifikasiListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;

import java.util.ArrayList;
import java.util.List;

public class DeltOrderFragment extends Fragment {
    FragmentDeltOrderBinding binding;
    View view;
    List<Order> deltOrder = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_delt_order,container,false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        doInitializasion();
    }

    private void doInitializasion() {
        deltOrder = getArguments().getParcelableArrayList("data");
        if (deltOrder.size() > 0) {
            OrdersAdaptor ordersAdaptor = new OrdersAdaptor(deltOrder);
            binding.deltOrderRv.setAdapter(ordersAdaptor);
        } else {
            binding.emptyLogo.setVisibility(View.VISIBLE);
            binding.deltOrderRv.setVisibility(View.GONE);
        }

    }

}