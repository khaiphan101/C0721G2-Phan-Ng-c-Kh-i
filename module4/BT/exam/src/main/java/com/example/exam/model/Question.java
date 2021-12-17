package com.example.exam.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "question")
public class Question {

    @Id
//    @Pattern(regexp = "CI-[0-9]{4}", message = "Wrong format! Please input again!")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

        @NotBlank(message = "please enter again")
//        @Size(min=5,max=100)
    private String title;

        @NotBlank(message = "please enter again")
//        @Size(min=10,max=500)
    private String question;

        @NotBlank(message = "please enter again")
//    @Size(min=10,max=500)
    private String answer;

    @ManyToOne(targetEntity = QuestionType.class)
    @NotNull(message = "question Type is not empty")
    private QuestionType questionType;

        @NotEmpty(message = "dateCreate is not empty")
    private String dateCreate;

        @NotNull(message = "Please select a status")
    private Boolean status;

    public Question(int id, String title, String question, String answer, QuestionType questionType, String dateCreate, Boolean status) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
