package ru.teacher.retrofit_v0322.API.APILocalHost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ru.teacher.retrofit_v0322.data.LocalHost.ResponseDataLocalHost;

public interface APIServiceLocalHost {
    @GET("/")
    Call<String> getDataGET();

    @POST("/all")
    Call<ArrayList<ResponseDataLocalHost>> getDataPOST();


    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded()
    @POST("/request")
    Call<ArrayList<ResponseDataLocalHost>> getDataPOST(
            @Field("mark_min") int min,
            @Field("mark_max") int max
    );

}
