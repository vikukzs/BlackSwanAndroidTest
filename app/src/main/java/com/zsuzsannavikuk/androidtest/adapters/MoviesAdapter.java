package com.zsuzsannavikuk.androidtest.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zsuzsannavikuk.androidtest.R;
import com.zsuzsannavikuk.androidtest.models.Movie;

import java.util.List;

/**
 * Created by Zsuzska on 2017. 02. 26..
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre, overview, rating;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.titleTextView);
            genre = (TextView) view.findViewById(R.id.genresTextView);
            year = (TextView) view.findViewById(R.id.releaseTextView);
            overview = (TextView) view.findViewById(R.id.summaryTextView);
            rating = (TextView) view.findViewById(R.id.ratingTextView);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenres().toString());
        holder.year.setText(movie.getReleaseDateText());
        holder.overview.setText(movie.getOverview());
        holder.rating.setText((int) movie.getAverageVote());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

