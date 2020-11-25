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
}
