package com.akbarprojec.mvvm_maintenanceapp.models;

import com.squareup.moshi.Json;

public class Order {

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