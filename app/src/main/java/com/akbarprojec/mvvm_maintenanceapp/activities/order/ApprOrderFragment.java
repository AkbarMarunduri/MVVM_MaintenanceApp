package com.akbarprojec.mvvm_maintenanceapp.activities.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.activities.order.DetailOrder.DetailOrderActivity;
import com.akbarprojec.mvvm_maintenanceapp.adaptors.OrdersAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentApprOrderBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.DetailOrderListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;

import java.util.ArrayList;
import java.util.List;

public class ApprOrderFragment extends Fragment implements DetailOrderListener {
    FragmentApprOrderBinding binding;
    View view;
    List<Order> apprOrder = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_appr_order, container, false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        doInitializasion();
    }

    private void doInitializasion() {
        apprOrder = getArguments().getParcelableArrayList("data");
        if (apprOrder.size() > 0) {
            OrdersAdaptor ordersAdaptor = new OrdersAdaptor(apprOrder,this);
            binding.appOrderRv.setAdapter(ordersAdaptor);
        } else {
            binding.emptyLogo.setVisibility(View.VISIBLE);
            binding.appOrderRv.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClickItem(Order order) {
        Intent intent = new Intent(getActivity(), DetailOrderActivity.class);
        intent.putExtra("data", order);
        startActivity(intent);
    }

    @Override
    public void onLongClickItem(List<Order> notifSelected) {

    }
}