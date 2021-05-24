package com.akbarprojec.mvvm_maintenanceapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

public class Order implements Parcelable {

    @Json(name = "status")
    private String stsOrder;

    @Json(name = "no_order")
    private String noOrder;

    @Json(name = "desc_order")
    private String descOrder;

    @Json(name = "tanggal")
    private String tanggal;

    @Json(name = "release_by")
    private String releaseBy;

    @Json(name = "created_by")
    private String createdBy;


    protected Order(Parcel in) {
        stsOrder = in.readString();
        noOrder = in.readString();
        descOrder = in.readString();
        tanggal = in.readString();
        releaseBy = in.readString();
        createdBy = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(stsOrder);
        dest.writeString(noOrder);
        dest.writeString(descOrder);
        dest.writeString(tanggal);
        dest.writeString(releaseBy);
        dest.writeString(createdBy);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStsOrder() {
        return stsOrder;
    }

    public String getNoOrder() {
        return noOrder;
    }

    public String getDescOrder() {
        return descOrder;
    }

    public String getReleaseBy() {
        return releaseBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setStsOrder(String stsOrder) {
        this.stsOrder = stsOrder;
    }

    public void setNoOrder(String noOrder) {
        this.noOrder = noOrder;
    }

    public void setDescOrder(String descOrder) {
        this.descOrder = descOrder;
    }

    public void setReleaseBy(String releaseBy) {
        this.releaseBy = releaseBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}