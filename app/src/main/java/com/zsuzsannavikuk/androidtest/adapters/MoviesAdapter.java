package com.zsuzsannavikuk.androidtest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.zsuzsannavikuk.androidtest.R;
import com.zsuzsannavikuk.androidtest.models.Movie;
import com.zsuzsannavikuk.androidtest.network.MovieDbManager;

import java.util.List;

/**
 * Created by Zsuzska on 2017. 02. 26..
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;
    private Context context;
    MovieDbManager movieDbManager;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre, overview, rating;
        public ImageView poster, starImage;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.titleTextView);
            genre = (TextView) view.findViewById(R.id.genresTextView);
            year = (TextView) view.findViewById(R.id.releaseTextView);
            overview = (TextView) view.findViewById(R.id.summaryTextView);
            rating = (TextView) view.findViewById(R.id.ratingTextView);
            poster = (ImageView) view.findViewById(R.id.poster_image);
            starImage = (ImageView) view.findViewById(R.id.star_image);
        }
    }


    public MoviesAdapter(Context context, List<Movie> moviesList) {
        this.context = context;
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
        Picasso.with(context).load(movieDbManager.IMAGE_BASE_URL + moviesList.get(position).getPosterPath()).into(holder.poster);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(String.valueOf(movie.getGenres()));
        holder.year.setText(movie.getReleaseDateText());
        holder.overview.setText(movie.getOverview());
        holder.rating.setText(String.valueOf(movie.getAverageVote()));
        holder.starImage.setImageResource(R.drawable.ic_star_black_18dp);
    }

    @Override
    public int getItemCount() {
        if (moviesList != null) {
            return moviesList.size();
        }
        return 0;
    }
}

