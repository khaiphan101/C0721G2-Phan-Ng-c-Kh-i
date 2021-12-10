package com.example.demo.repository.customer;

import com.example.demo.model.Movie;
import com.example.demo.model.ShowCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
