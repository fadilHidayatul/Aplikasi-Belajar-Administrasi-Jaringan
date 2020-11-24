package com.example.aplikasibelajar.UtilsApi;

public class UtilsApi {
    public static final String baseURL ="http://192.168.100.11/androidsj/index.php/ServerApi/";

    public static ApiInterface getApiService(){
       return RetrofitClient.getRetrofit(baseURL).create(ApiInterface.class);
    }
}
