package com.example.aplikasibelajar.UtilsApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getDataMateri")
    Call<ResponseBody>getMateri();

    @GET("getDataJobsheet")
    Call<ResponseBody>getJobsheet();

    @GET("getDataVideo")
    Call<ResponseBody>getVideo();

    @GET("getDataSoal")
    Call<ResponseBody>getAllSoal();

    @GET("getDataSiswa")
    Call<ResponseBody>getDataSiswa();
}
