package com.example.furama_resort.model.employee;

//import com.example.furama_resort.model.User;
import com.example.furama_resort.model.customer.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {

    @Id
    private  int id;

    private String name;
    private String birthDay;
    private String idCard;
    private Double salary;
    private String phone;
    private String email;
    private String address;

    @ManyToOne(targetEntity = Position.class)
    @NotNull(message = "Customer Type is not empty")
    private Position position;

    @ManyToOne(targetEntity = EducationDegree.class)
    @NotNull(message = "Customer Type is not empty")
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Division.class)
    @NotNull(message = "Customer Type is not empty")
    private Division division;

//    @OneToOne(targetEntity = User.class)
//    private User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
