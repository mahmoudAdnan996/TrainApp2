package com.apps.madnan.trainapp2.service;

import com.apps.madnan.trainapp2.service.respond.MovieRespond;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mahmoud adnan on 9/26/2017.
 */

public interface Service {

    @GET("upcoming?api_key=e0e7f86d51fd9f1c11d41bea49e14f25")
    Call<MovieRespond> getMovies();
}
