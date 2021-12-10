package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.customer.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements IMovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

}
