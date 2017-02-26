package com.zsuzsannavikuk.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.greenfox.androidtest.R;
import com.zsuzsannavikuk.androidtest.models.LoadPopularMoviesResponse;
import com.zsuzsannavikuk.androidtest.network.MovieDbManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieDbManager.getInstance().loadPopularMovies(1, new Callback<LoadPopularMoviesResponse>() {
            @Override
            public void onResponse(Call<LoadPopularMoviesResponse> call, Response<LoadPopularMoviesResponse> response) {
                Toast.makeText(MainActivity.this, "Successful load", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoadPopularMoviesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
