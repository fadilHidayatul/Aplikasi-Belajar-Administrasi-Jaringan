package com.example.aplikasibelajar.UtilsApi;

public class UtilsApi {
    //public static final String baseURL ="http://192.168.100.11/androidsj/index.php/ServerApi/";
    public static final String baseURL = "https://jaringan.mantagi.com/ServerApi/";
    public static final String extendURL = "https://jaringan.mantagi.com/apiBelajar/user/";

    public static ApiInterface getApiService(){
       return RetrofitClient.getRetrofit(baseURL).create(ApiInterface.class);
    }

    public static ApiInterface getApiLogin(){
        return RetrofitClient.getLogin(extendURL).create(ApiInterface.class);
    }




}
