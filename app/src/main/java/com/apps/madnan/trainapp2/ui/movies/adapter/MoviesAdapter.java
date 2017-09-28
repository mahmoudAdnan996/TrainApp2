package com.apps.madnan.trainapp2.ui.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.madnan.trainapp2.R;
import com.apps.madnan.trainapp2.model.Movie;
import com.apps.madnan.trainapp2.ui.movies.MovieDetails;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mahmoud adnan on 9/27/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieVH> {


    ArrayList<Movie> movies;

    public MoviesAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MovieVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, null);

        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(MovieVH holder, int position) {

        holder.setMovieView(movies.get(position));

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieVH extends RecyclerView.ViewHolder{

        @BindView(R.id.movieIV)
        ImageView movieIV;
        @BindView(R.id.titleTV)
        TextView titleTV;


        public MovieVH(final View view) {
            super(view);
            ButterKnife.bind(this, view);

            //on item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION){
                    Movie clickedDataItem = movies.get(pos);
                    Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), MovieDetails.class);
                    intent.putExtra("title", movies.get(pos).getTitle());
                    intent.putExtra("overview", movies.get(pos).getOverview());
                    intent.putExtra("poster", movies.get(pos).getPosterPath());
                    v.getContext().startActivity(intent);


                }
            }
        });
        }
        void setMovieView(Movie movieView) {

            Glide.with(itemView.getContext())
                    .load("http://image.tmdb.org/t/p/w185/" + movieView.getPosterPath())
                    .into(movieIV);

            titleTV.setText(movieView.getTitle());
        }

    }
}
