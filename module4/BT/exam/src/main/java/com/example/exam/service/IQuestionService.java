package com.example.exam.service;

import com.example.exam.model.Question;
import com.example.exam.model.ShowCinema;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IQuestionService {

//    Object findAllCinemaById(int id, Pageable pageable);

    Object findAll();

    Object findAllQuestion(Pageable pageable);

    Optional<Question> findById(int id);

    void deleteById(int id);

    void save(Question question);
//
//    Object findAllCinemaByMovie(String name, Pageable pageable);
//
//    Optional<ShowCinema> findById(String id);

}
