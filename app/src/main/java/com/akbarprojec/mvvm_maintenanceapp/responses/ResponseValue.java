package com.akbarprojec.mvvm_maintenanceapp.responses;

import java.util.List;

import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;
import com.akbarprojec.mvvm_maintenanceapp.models.User;
import com.squareup.moshi.Json;

public class ResponseValue {
    @Json(name = "message")
    private String message;

    @Json(name = "value")
    private int value;

    @Json(name = "resultUser")
    private User resultUser;

    @Json(name = "resultNotifikasi")
    private List<Notifikasi> listNotifikasi;

    @Json(name = "resultOrder")
    private List<Order> listOrder;

    public List<Order> getListOrder() {
        return listOrder;
    }

    public User getResultUser() {
        return resultUser;
    }

    public String getMessage() {
        return message;
    }

    public List<Notifikasi> getListNotifikasi() {
        return listNotifikasi;
    }

    public int getValue() {
        return value;
    }
}