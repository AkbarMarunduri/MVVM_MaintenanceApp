package com.akbarprojec.mvvm_maintenanceapp.ultility;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManeger {
    private SharedPreferences sharedPreferences;

    public PreferenceManeger(Context context) {
        sharedPreferences = context.getSharedPreferences(Constant.KEY_PREFERENCE_NAME, context.MODE_PRIVATE);
    }

    public void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key,false);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void clearPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
