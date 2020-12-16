package com.akbarprojec.mvvm_maintenanceapp.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.OrdersAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentOrderBinding;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.OrderViewModel;

/**

 */
public class OrderFragment extends Fragment {
    FragmentOrderBinding orderBinding;
    View view;
    OrderViewModel viewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        orderBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_order, container, false);
        view = orderBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doInitialisazion();
    }

    public void doInitialisazion() {
        viewModel = new ViewModelProvider(getActivity()).get(OrderViewModel.class);
        loadListOrder();
    }

    public void loadListOrder() {
        viewModel.getDataListOrder().observe(getActivity(),getListOrder->{
            orderBinding.recylerViewOrders.setAdapter(new OrdersAdaptor(getListOrder.getListOrder()));
        });
    }
}