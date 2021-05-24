package com.akbarprojec.mvvm_maintenanceapp.ultility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceManeger {
    private SharedPreferences sharedPreferences;

    public PreferenceManeger(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    //put dan get status login
    public void putBoolean(String key, Boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    //put dan get data user
    public void putUser(String key,String user) {
        sharedPreferences.edit().putString(key, user).apply();
    }

    public String getUser(String key) {
        return sharedPreferences.getString(key, null);
    }


    public void clearPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
