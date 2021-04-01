package com.example.kependudukan.http_client;

import com.example.kependudukan.pojo.ListKk;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface KependudukanCall {

    @FormUrlEncoded
    @POST("rest/api/selectbyKK")
    Call<ListKk> getKKById(
            @Field("NoKK") String nomor_kk
    );

    @FormUrlEncoded
    @POST("rest/api/getlist")
    Call<ArrayList<ListKk>> getKKList(
            @Field("Data") int jumlah
    );
}
