package com.akbarprojec.mvvm_maintenanceapp.listener;


import com.akbarprojec.mvvm_maintenanceapp.models.Order;

import java.util.List;

public interface DetailOrderListener {
    void onClickItem(Order order);

    void onLongClickItem(List<Order> orderSelected);
}
