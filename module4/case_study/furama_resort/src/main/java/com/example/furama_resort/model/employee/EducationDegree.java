package com.example.furama_resort.model.employee;

import javax.persistence.*;
import java.util.List;
@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public EducationDegree() {
    }

    public EducationDegree(int id) {
        this.id = id;
    }

    public EducationDegree(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = Employee.class, mappedBy = "educationDegree")
    List< Employee > employeeList;
}
