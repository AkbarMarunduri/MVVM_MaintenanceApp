package com.akbarprojec.mvvm_maintenanceapp.viewmodels;

import com.akbarprojec.mvvm_maintenanceapp.repositories.OrderRepository;
import com.akbarprojec.mvvm_maintenanceapp.responses.ResponseValue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class OrderViewModel extends ViewModel {
    private OrderRepository orderRepository;

    public OrderViewModel() {
        this.orderRepository = new OrderRepository();
    }

    public LiveData<ResponseValue> getDataListOrder() {
        return orderRepository.getDataListOrder();
    }
}
