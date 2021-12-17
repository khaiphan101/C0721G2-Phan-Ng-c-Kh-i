package com.example.exam.service;

import com.example.exam.model.QuestionType;
import com.example.exam.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public Iterable<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
