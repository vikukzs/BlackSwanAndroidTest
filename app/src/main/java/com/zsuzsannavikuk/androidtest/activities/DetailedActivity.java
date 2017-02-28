package com.zsuzsannavikuk.androidtest.activities;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zsuzsannavikuk.androidtest.R;
import com.zsuzsannavikuk.androidtest.models.Movie;

/**
 * Created by Zsuzska on 2017. 02. 28..
 */

public class DetailedActivity extends AppCompatActivity {

    TextView title;
    Movie movie;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_activity);

        movie = (Movie) getIntent().getSerializableExtra("movie");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(movie.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = (TextView)  findViewById(R.id.movieTitle);
        title.setText(movie.getTitle());

        
    }
}
