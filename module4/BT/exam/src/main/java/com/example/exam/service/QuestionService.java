package com.example.exam.service;

import com.example.exam.model.Question;
import com.example.exam.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    QuestionRepository questionRepository;


    @Override
    public Object findAll() {
        return null;
    }

    @Override
    public Object findAllQuestion(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Optional<Question> findById(int id) {
        return questionRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }


}
