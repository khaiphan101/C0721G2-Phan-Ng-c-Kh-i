package com.example.furama_resort.model;

import javax.persistence.*;

@Entity
@Table(name="show")
public class Show {
    @Id
//    @Pattern(regexp = "CI-[0-9]{4}", message = "Wrong format! Please input again!")
    private String code;
    @ManyToOne(targetEntity = Movie.class)
//    @NotNull(message = "Movie is not empty")
    private Movie movie;
    //    @NotEmpty(message = "date is not empty")
    private String showDate;
    //    @NotNull(message = "ticket Type is not empty")
    private int totalTicket;

    public Show() {
    }

    public Show(String code, Movie movie, String showDate, int totalTicket) {
        this.code = code;
        this.movie = movie;
        this.showDate = showDate;
        this.totalTicket = totalTicket;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }
}
