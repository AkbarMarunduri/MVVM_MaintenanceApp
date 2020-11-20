package com.akbarprojec.mvvm_maintenanceapp.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.LayoutContainerNotifikasiBinding;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class NotifikasiAdaptor extends RecyclerView.Adapter<NotifikasiAdaptor.NotifikasiViewHolde> {

    List<Notifikasi> notifikasis;
    private LayoutInflater layoutInflater;

    public NotifikasiAdaptor(List<Notifikasi> notifikasis) {
        this.notifikasis = notifikasis;
    }

    @NonNull
    @Override
    public NotifikasiViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        LayoutContainerNotifikasiBinding notifikasiBinding = DataBindingUtil.inflate(layoutInflater, R.layout.layout_container_notifikasi, parent, false);
        return new NotifikasiViewHolde(notifikasiBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifikasiViewHolde holder, int position) {
        holder.notifikasi(notifikasis.get(position));
    }

    @Override
    public int getItemCount() {
        return notifikasis.size();
    }

    static class NotifikasiViewHolde extends RecyclerView.ViewHolder {
        private LayoutContainerNotifikasiBinding notifikasiBinding;

        public NotifikasiViewHolde(@NonNull LayoutContainerNotifikasiBinding notifikasiBinding) {
            super(notifikasiBinding.getRoot());
            this.notifikasiBinding = notifikasiBinding;
        }

        public void notifikasi(Notifikasi notifikasi) {
            notifikasiBinding.setNotifikasi(notifikasi);
        }
    }

}
