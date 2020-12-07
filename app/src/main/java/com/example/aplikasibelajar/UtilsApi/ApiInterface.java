package com.example.aplikasibelajar.UtilsApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("getDataMateri")
    Call<ResponseBody>getMateri();

    @GET("getDataJobsheet")
    Call<ResponseBody>getJobsheet();

    @GET("getDataVideo")
    Call<ResponseBody>getVideo();

    @FormUrlEncoded
    @POST("getDataSoal")
    Call<ResponseBody>getAllSoal(@Field("id")String id);

    @GET("getDataSiswa")
    Call<ResponseBody>getDataSiswa();

    @GET("getDataRPP")
    Call<ResponseBody>getRPP();

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody>registerUser(@Field("nama") String nama,
                                @Field("kelas") String kelas,
                                @Field("username") String username,
                                @Field("password") String password
                                );

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody>loginUser(@Field("username") String username,
                                   @Field("password") String password
    );

    @FormUrlEncoded
    @POST("sendScore.php")
    Call<ResponseBody>sendScore(@Field("idSiswa") String idSiswa,
                                @Field("idMateri") String idMateri,
                                @Field("tgl") String tgl,
                                @Field("skor") String skor
    );
}
