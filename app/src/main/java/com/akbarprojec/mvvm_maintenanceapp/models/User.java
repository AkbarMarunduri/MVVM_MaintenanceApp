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


    public String getIduser() {
        return iduser;
    }

    public String getPass() {
        return pass;
    }

    public String getLevel() {
        return level;
    }

    public String getStatus() {
        return status;
    }

    protected User(Parcel in) {
        iduser = in.readString();
        pass = in.readString();
        level = in.readString();
        status = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(iduser);
        parcel.writeString(pass);
        parcel.writeString(level);
        parcel.writeString(status);
    }


}