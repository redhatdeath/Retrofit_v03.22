package ru.teacher.retrofit_v0322.presentation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.teacher.retrofit_v0322.API.APIConfig;
import ru.teacher.retrofit_v0322.API.APIService;
import ru.teacher.retrofit_v0322.API.APIServiceConstructor;
import ru.teacher.retrofit_v0322.R;
import ru.teacher.retrofit_v0322.data.ResponseData;

public class ActivityShowWeather extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tw_weather);

        APIService service = APIServiceConstructor.CreateService(APIService.class);
        Call<ResponseData> call = service.getDataWeather(
                APIConfig.CITY_EKB_LAT,
                APIConfig.CITY_EKB_LON,
                APIConfig.LANG,
                APIConfig.API_YANDEX_KEY
        );
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.body() != null) {
                    textView.setText(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                textView.setText(t.toString());
            }
        });
    }
}