package com.zsuzsannavikuk.androidtest.activities;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsuzsannavikuk.androidtest.R;
import com.zsuzsannavikuk.androidtest.models.Movie;

/**
 * Created by Zsuzska on 2017. 02. 28..
 */

public class DetailedActivity extends AppCompatActivity {

    TextView title, releaseDate, rating, overview, overviewTitle;
    ImageView ratingStar, calendar;
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

        releaseDate = (TextView) findViewById(R.id.relDate);
        releaseDate.setText(movie.getReleaseDateText());
        rating = (TextView) findViewById(R.id.movieRating);
        rating.setText(String.valueOf(movie.getAverageVote()));
        overviewTitle = (TextView) findViewById(R.id.movieOverviewTitle);
        overview = (TextView) findViewById(R.id.movieOverview);
        overview.setText(movie.getOverview());

        ratingStar = (ImageView) findViewById(R.id.ratingStar);
        calendar = (ImageView) findViewById(R.id.calendar);




    }
}
