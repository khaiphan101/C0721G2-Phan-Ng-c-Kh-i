package com.example.furama_resort.model.employee;

import com.example.furama_resort.model.User;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String name;
    private String birthDay;
    private String idCard;
    private Double salary;
    private String phone;
    private String email;
    private String address;
//    private Position position;
//    private EducationDegree educationDegree;
//    private Division division;

    @OneToOne(targetEntity = User.class)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
