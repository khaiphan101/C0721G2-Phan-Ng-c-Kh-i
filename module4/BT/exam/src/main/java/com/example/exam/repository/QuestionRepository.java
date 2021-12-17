package com.example.exam.repository;

import com.example.exam.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
