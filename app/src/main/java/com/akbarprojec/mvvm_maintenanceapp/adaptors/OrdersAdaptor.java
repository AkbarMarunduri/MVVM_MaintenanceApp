package com.akbarprojec.mvvm_maintenanceapp.adaptors;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.OrderItemLayoutBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.Order;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class OrdersAdaptor extends RecyclerView.Adapter<OrdersAdaptor.OrderViewHolder>{
    private List<Order> orderList = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public OrdersAdaptor(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        OrderItemLayoutBinding orderBinding = DataBindingUtil.inflate(layoutInflater, R.layout.order_item_layout, parent,false);
        return new OrderViewHolder(orderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.loadListOrder(orderList.get(position));
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

   class OrderViewHolder extends RecyclerView.ViewHolder {
        private OrderItemLayoutBinding containerOrderBinding;

        public OrderViewHolder(@NonNull OrderItemLayoutBinding containerOrderBinding) {
            super(containerOrderBinding.getRoot());
            this.containerOrderBinding = containerOrderBinding;
        }

        public void loadListOrder(Order order) {
            containerOrderBinding.setNoorder(order.getNoOrder());
            containerOrderBinding.setDescription(order.getDescOrder());
            containerOrderBinding.setTanggal(order.getTanggal());
            containerOrderBinding.setStatus(order.getStsOrder());

            containerOrderBinding.getRoot().setOnClickListener(view -> {
                containerOrderBinding.getRoot().setBackgroundResource(R.drawable.selected_background);
            });

        }
    }
}
