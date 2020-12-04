package com.example.aplikasibelajar.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "belajar";
    public static final String SESSION_KEY = "SESSION_USER";
    public static final String ID_SISWA = "id_siswa";
    public static final String NAMA = "nama";
    public static final String USERNAME = "username";


    //constructor
    public PrefManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = preferences.edit();
    }

    //SessionUser
    public void saveSession(){
        editor.putBoolean(SESSION_KEY,true);
        editor.commit();
    }
    public boolean getSession(){
        return preferences.getBoolean(SESSION_KEY,false);
    }
    public void removeSession(){
        editor.putBoolean(SESSION_KEY,false);
        editor.commit();
    }

    //idSiswa
    public void setIdSiswa(String key, String value){
        editor.putString(key,value);
        editor.commit();
    }
    public String getIdSiswa(){
        return preferences.getString(ID_SISWA,"");
    }

    //namaSiswa
    public void setNamaSiswa(String key, String value){
        editor.putString(key, value);
        editor.commit();
    }
    public String getNamaSiswa(){
        return preferences.getString(NAMA,"");
    }

    //username
    public void setUsername(String key, String value){
        editor.putString(key, value);
        editor.commit();
    }
    public String getUsername(){
        return preferences.getString(USERNAME,"");
    }


}
