package com.zsuzsannavikuk.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.zsuzsannavikuk.androidtest.adapters.MoviesAdapter;
import com.zsuzsannavikuk.androidtest.models.LoadPopularMoviesResponse;
import com.zsuzsannavikuk.androidtest.models.Movie;
import com.zsuzsannavikuk.androidtest.network.MovieDbManager;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    LoadPopularMoviesResponse loadPopularMoviesResponse = new LoadPopularMoviesResponse();
    List<Movie> movies;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MovieDbManager.getInstance().loadPopularMovies(1, new Callback<LoadPopularMoviesResponse>() {
            @Override
            public void onResponse(Call<LoadPopularMoviesResponse> call, Response<LoadPopularMoviesResponse> response) {
                movies = new ArrayList<>();
                loadPopularMoviesResponse = response.body();
                movies = loadPopularMoviesResponse.getMovies();
                setUpRecyclerAdapter();
                Toast.makeText(MainActivity.this, "Successful load", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoadPopularMoviesResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setUpRecyclerAdapter() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MoviesAdapter(getApplicationContext(), movies));
    }
}
