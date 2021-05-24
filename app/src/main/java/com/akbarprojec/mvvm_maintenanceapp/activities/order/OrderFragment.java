package com.akbarprojec.mvvm_maintenanceapp.activities.order;

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
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;
import com.akbarprojec.mvvm_maintenanceapp.pager.OrderPagerAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.viewmodels.OrderViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class OrderFragment extends Fragment {
    FragmentOrderBinding orderBinding;
    View view;
    OrderViewModel viewModel;

    List<Order> newOrder = new ArrayList<>();
    List<Order> apprOrder = new ArrayList<>();
    List<Order> compOrder = new ArrayList<>();
    List<Order> deltOrder = new ArrayList<>();

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
        viewModel.getDataListOrder().observe(getActivity(), orderResponse -> {
            for (Order order : orderResponse.getListOrder()) {
                if (order.getStsOrder().equalsIgnoreCase("NEW")) {
                    newOrder.add(order);
                } else if (order.getStsOrder().equalsIgnoreCase("APPR")) {
                    apprOrder.add(order);
                } else if (order.getStsOrder().equalsIgnoreCase("COMP")) {
                    compOrder.add(order);
                } else if (order.getStsOrder().equalsIgnoreCase("DELT")) {
                    deltOrder.add(order);
                }

                OrderPagerAdaptor orderPagerAdaptor = new OrderPagerAdaptor(getChildFragmentManager());
                orderPagerAdaptor.setDataOrder(newOrder, apprOrder, compOrder, deltOrder);
                orderBinding.viewPager.setAdapter(orderPagerAdaptor);
                orderBinding.tabOrder.setupWithViewPager(orderBinding.viewPager);
            }
        });
    }
}