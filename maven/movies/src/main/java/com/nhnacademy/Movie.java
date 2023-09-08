package com.nhnacademy;

import java.util.Set;

public class Movie {
    private long movieId;
    private String title;
    private Set<String> genres;

    public Movie(long movieId, String title, Set<String> genres) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    public long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setMovieId(long id) {
        this.movieId = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public String toString() {
        return getMovieId() + "\t\t\t" + getTitle() + "\t\t\t"+ getGenres();
    }
}