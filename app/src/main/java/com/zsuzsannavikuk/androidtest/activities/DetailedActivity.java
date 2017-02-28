package com.zsuzsannavikuk.androidtest.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zsuzsannavikuk.androidtest.R;
import com.zsuzsannavikuk.androidtest.models.Movie;
import com.zsuzsannavikuk.androidtest.network.MovieDbManager;

/**
 * Created by Zsuzska on 2017. 02. 28..
 */

public class DetailedActivity extends AppCompatActivity {

    TextView title, releaseDate, rating, overview, overviewTitle;
    ImageView ratingStar, calendar, toolbarBackground;
    Movie movie;
    MovieDbManager movieDbManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_activity);

        movie = (Movie) getIntent().getSerializableExtra("movie");

        toolbarBackground = (ImageView) findViewById(R.id.toolbar_background);
        Picasso.with(getApplicationContext())
                .load(movieDbManager.IMAGE_BASE_URL+movie.getPosterPath())
                .placeholder(R.drawable.ic_star_black_18dp)
                .error(R.drawable.ic_star_black_18dp)
                .into(toolbarBackground);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);

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


