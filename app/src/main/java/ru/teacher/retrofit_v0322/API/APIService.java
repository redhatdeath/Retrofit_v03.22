package ru.teacher.retrofit_v0322.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import ru.teacher.retrofit_v0322.data.ResponseData;

public interface APIService {
    @GET("v2/informers")
    Call<ResponseData> getDataWeather(
            @Query("lat") Double lat,
            @Query("lon") Double lon,
            @Query("lang") String lang,
            @Header("X-Yandex-API-Key") String key
    );
}
