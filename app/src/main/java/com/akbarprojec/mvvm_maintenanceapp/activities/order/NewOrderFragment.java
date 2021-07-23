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
import com.akbarprojec.mvvm_maintenanceapp.adaptors.OrdersAdaptor;
import com.akbarprojec.mvvm_maintenanceapp.databinding.FragmentNewOrdeBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.DetailOrderListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;

import java.util.ArrayList;
import java.util.List;

public class NewOrderFragment extends Fragment implements DetailOrderListener {
    FragmentNewOrdeBinding binding;
    View view;
    List<Order> newOrder = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_orde, container, false);
        view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        doInitializasion();
    }

    private void doInitializasion() {
        newOrder = getArguments().getParcelableArrayList("data");
        if (newOrder.size() > 0) {
            OrdersAdaptor ordersAdaptor = new OrdersAdaptor(newOrder,this);
            binding.newOrderRv.setAdapter(ordersAdaptor);
        } else {
            binding.emptyLogo.setVisibility(View.VISIBLE);
            binding.newOrderRv.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClickItem(Order order) {
        Intent intent = new Intent(getActivity(), DetailOrderListener.class);
        intent.putExtra("data", order);
        startActivity(intent);
    }

    @Override
    public void onLongClickItem(List<Order> notifSelected) {

    }
}