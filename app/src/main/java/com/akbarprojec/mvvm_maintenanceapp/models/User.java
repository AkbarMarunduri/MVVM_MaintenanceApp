package com.akbarprojec.mvvm_maintenanceapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

public class User implements Parcelable {

    @Json(name = "iduser")
    private String iduser;

    @Json(name = "pass")
    private String pass;

    @Json(name = "level")
    private String level;

    @Json(name = "status")
    private String status;

    @Json(name = "nik")
    private String nik;

    @Json(name = "nama_user")
    private String name;

    @Json(name = "jabatan")
    private String jabatan;

    @Json(name = "plant")
    private String plant;

    @Json(name = "no_telp")
    private String telp;

    protected User(Parcel in) {
        iduser = in.readString();
        pass = in.readString();
        level = in.readString();
        status = in.readString();
        nik = in.readString();
        name = in.readString();
        jabatan = in.readString();
        plant = in.readString();
        telp = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iduser);
        dest.writeString(pass);
        dest.writeString(level);
        dest.writeString(status);
        dest.writeString(nik);
        dest.writeString(name);
        dest.writeString(jabatan);
        dest.writeString(plant);
        dest.writeString(telp);
    }
}