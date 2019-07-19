package com.studio.suku.tmdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static String BASE_URL = "https://api.themoviedb.org";
    public static String API_KEY = "24f2356bed948a69b6ce4946afbf4f67";
    TextView txt;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<MoviesResults> call = apiInterface.getMovies(API_KEY);

        call.enqueue(new Callback<MoviesResults>() {
            @Override
            public void onResponse(Call<MoviesResults> call, Response<MoviesResults> response) {
                MoviesResults results = response.body();
                List<MoviesResults.ResultsBean> list = results.getResults();
                MoviesResults.ResultsBean berhasil = list.get(0);
                Log.d("Panjang Data", "Total Data " + list.size());
                txt.setText(berhasil.getTitle());
            }

            @Override
            public void onFailure(Call<MoviesResults> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){
            Intent intent = new Intent(MainActivity.this, ListFilm.class);
            startActivity(intent);
        }
    }
}
