package ru.teacher.retrofit_v0322.presentation;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.teacher.retrofit_v0322.API.APILocalHost.APIConfigLocalHost;
import ru.teacher.retrofit_v0322.API.APILocalHost.APIServiceLocalHost;
import ru.teacher.retrofit_v0322.API.APIServiceConstructor;
import ru.teacher.retrofit_v0322.R;
import ru.teacher.retrofit_v0322.data.LocalHost.DataRequest;
import ru.teacher.retrofit_v0322.data.LocalHost.ResponseDataLocalHost;

public class ActivityShowWeather extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tw_weather);
        localHost();
    }

    private void localHost() {
        APIServiceLocalHost service = APIServiceConstructor.CreateService(
                APIServiceLocalHost.class,
                APIConfigLocalHost.HOST_URL
        );

//        Call<String> call_get = service.getDataGET();
//        call_get.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if (response.body() != null) {
//                    textView.setText(response.body());
//                    Toast.makeText(getApplicationContext(), response.body(), Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                textView.setText(t.toString());
//                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
//            }
//        });

        DataRequest dr = new DataRequest(0, 10);
        Log.d("err", (new Gson()).toJson(dr));
        Call<ArrayList<ResponseDataLocalHost>> call = service.getDataPOST(dr.getMark_min(), dr.getMark_max());
        call.enqueue(new Callback<ArrayList<ResponseDataLocalHost>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseDataLocalHost>> call, Response<ArrayList<ResponseDataLocalHost>> response) {
                if (response.body() != null) {
                    textView.setText(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseDataLocalHost>> call, Throwable t) {
                textView.setText(t.toString());
                Log.d("err", t.toString());
            }
        });
    }
}