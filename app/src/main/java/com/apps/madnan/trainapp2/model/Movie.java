package com.apps.madnan.trainapp2.model;

import com.google.gson.annotations.SerializedName;



public class Movie {

    private String title;
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;

    public Movie(String title, String overview, String posterPath) {
        this.title = title;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }


    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + posterPath + '\'' +
                '}';
    }
}
