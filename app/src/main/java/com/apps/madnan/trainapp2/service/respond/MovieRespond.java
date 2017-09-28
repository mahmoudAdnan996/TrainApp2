package com.apps.madnan.trainapp2.service.respond;

import com.apps.madnan.trainapp2.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by mahmoud adnan on 9/27/2017.
 */

public class MovieRespond {

    @SerializedName("results")
    ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MovieRespond{" +
                "movies=" + movies +
                '}';
    }
}
