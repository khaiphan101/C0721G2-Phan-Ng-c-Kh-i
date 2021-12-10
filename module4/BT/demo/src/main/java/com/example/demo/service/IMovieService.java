package com.example.demo.service;

import com.example.demo.model.Movie;

public interface IMovieService {

    public Iterable<Movie> findAll();
}
