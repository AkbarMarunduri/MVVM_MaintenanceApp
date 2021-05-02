package com.akbarprojec.mvvm_maintenanceapp.adaptors;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbarprojec.mvvm_maintenanceapp.R;
import com.akbarprojec.mvvm_maintenanceapp.databinding.NotifikasiItemLayoutBinding;
import com.akbarprojec.mvvm_maintenanceapp.listener.NotifikasiListener;
import com.akbarprojec.mvvm_maintenanceapp.models.Notifikasi;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class NotifikasiAdaptor extends RecyclerView.Adapter<NotifikasiAdaptor.NotifikasiViewHolde> {

    List<Notifikasi> notifikasis;
    NotifikasiListener notifikasiListener;
    private LayoutInflater layoutInflater;

    public NotifikasiAdaptor(List<Notifikasi> notifikasis, NotifikasiListener notifikasiListener) {
        this.notifikasis = notifikasis;
        this.notifikasiListener = notifikasiListener;
    }

    @NonNull
    @Override
    public NotifikasiViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        NotifikasiItemLayoutBinding notifikasiBinding = DataBindingUtil.inflate(layoutInflater, R.layout.notifikasi_item_layout, parent, false);
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

    class NotifikasiViewHolde extends RecyclerView.ViewHolder {
        private NotifikasiItemLayoutBinding notifikasiBinding;

        public NotifikasiViewHolde(@NonNull NotifikasiItemLayoutBinding notifikasiBinding) {
            super(notifikasiBinding.getRoot());
            this.notifikasiBinding = notifikasiBinding;
        }

        public void notifikasi(final Notifikasi notifikasi) {

            notifikasiBinding.setNomor(notifikasi.getNoNotifikasi());
            notifikasiBinding.setTanggal(notifikasi.getTgl());
            notifikasiBinding.setDescription(notifikasi.getDescNotifikasi());
            notifikasiBinding.setStatus(notifikasi.getStsNotif());

            if (notifikasi.getStsNotif().equalsIgnoreCase("new")) {
                notifikasiBinding.txStatus.setTextColor(Color.parseColor("#FFE712"));
            } else if (notifikasi.getStsNotif().equalsIgnoreCase("approve")) {
                notifikasiBinding.txStatus.setTextColor(Color.parseColor("#25DA62"));
            } else if (notifikasi.getStsNotif().equalsIgnoreCase("comp")) {
                notifikasiBinding.txStatus.setTextColor(Color.parseColor("#254EDA"));
            } else {
                notifikasiBinding.txStatus.setTextColor(Color.parseColor("#DA2540"));
            }
            
            notifikasiBinding.cardNotifikasi.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (notifikasi.isSelected) {
                        notifikasi.isSelected = false;
                        notifikasiBinding.cardNotifikasi.setBackgroundResource(R.drawable.unselected_background);
                    } else {
                        notifikasi.isSelected = true;
                        notifikasiBinding.cardNotifikasi.setBackgroundResource(R.drawable.selected_background);
                    }
                    notifikasiListener.onLongClickNotifikasiItem(notifikasi);
                    return true;
                }
            });

            notifikasiBinding.cardNotifikasi.setOnClickListener(view -> {
                notifikasiListener.onClickNotifikasiItem(notifikasi);
            });
        }
    }

}
