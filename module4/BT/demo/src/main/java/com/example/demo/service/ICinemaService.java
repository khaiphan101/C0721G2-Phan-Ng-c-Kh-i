package com.example.demo.service;

import com.example.demo.model.ShowCinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ICinemaService {

    Object findAllCinemaById(int id, Pageable pageable);

    Object findAllCinema(Pageable pageable);

    Object findAll();

    Object findAllCinemaByMovie(String name, Pageable pageable);

    Optional<ShowCinema> findById(String id);

    void deleteById(String id);

    void save(ShowCinema showCinema);
}
