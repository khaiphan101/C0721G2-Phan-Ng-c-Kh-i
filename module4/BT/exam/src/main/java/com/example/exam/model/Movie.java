package com.example.exam.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(targetEntity = ShowCinema.class, mappedBy = "movie")
    List<ShowCinema> showList;

    public Movie() {
    }

    public Movie(Integer id, String name, List<ShowCinema> showList) {
        this.id = id;
        this.name = name;
        this.showList = showList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
