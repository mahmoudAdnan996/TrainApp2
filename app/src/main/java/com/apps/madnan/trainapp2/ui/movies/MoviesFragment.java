package com.apps.madnan.trainapp2.ui.movies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.madnan.trainapp2.App;
import com.apps.madnan.trainapp2.R;
import com.apps.madnan.trainapp2.model.Movie;
import com.apps.madnan.trainapp2.service.respond.MovieRespond;
import com.apps.madnan.trainapp2.ui.movies.adapter.MoviesAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoviesFragment extends Fragment {


    @BindView(R.id.moviesRV)
    RecyclerView moviesRV;

    MoviesAdapter moviesAdapter;

    public MoviesFragment() {
        // Required empty public constructor
    }

    public static MoviesFragment newInstance() {

        return  new MoviesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        ButterKnife.bind(this, view);
        getMovie();

        return  view;
    }

    void getMovie() {
        App.service.getMovies().enqueue(new Callback<MovieRespond>() {
            @Override
            public void onResponse(Call<MovieRespond> call, Response<MovieRespond> response) {
                if (response.isSuccessful()){
                    onSucess(response.body().getMovies());
                }
            }

            @Override
            public void onFailure(Call<MovieRespond> call, Throwable t) {

            }
        });
    }
    void onSucess(ArrayList<Movie> movies) {
        moviesAdapter = new MoviesAdapter(movies);
        moviesRV.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        moviesRV.setItemAnimator(new DefaultItemAnimator());
        moviesRV.setAdapter(moviesAdapter);
    }
}
