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
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentDeltOrderBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.DetailOrderListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;

import java.util.ArrayList;
import java.util.List;

public class DeltOrderFragment extends Fragment implements DetailOrderListener {
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
            OrdersAdaptor ordersAdaptor = new OrdersAdaptor(deltOrder,this);
            binding.deltOrderRv.setAdapter(ordersAdaptor);
        } else {
            binding.emptyLogo.setVisibility(View.VISIBLE);
            binding.deltOrderRv.setVisibility(View.GONE);
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