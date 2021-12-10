package com.example.demo.model;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="showCinema")
public class ShowCinema {

    @Id
    @Pattern(regexp = "CI-[0-9]{4}", message = "Wrong format! Please input again!")
    private  String id;

    @ManyToOne(targetEntity = Movie.class)
    @NotNull(message = "Movie is not empty")
    private Movie movie;

    @NotEmpty(message = "showDate is not empty")
    private String showDate;

    @NotNull(message= "salary may not be empty")
    @Min(1)
    private int totalTicket;

    public ShowCinema() {
    }

    public ShowCinema(String id, Movie movie, String showDate, int totalTicket) {
        this.id = id;
        this.movie = movie;
        this.showDate = showDate;
        this.totalTicket = totalTicket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

//    @Pattern(regexp ="^0[35789]\\d{8}$" , message = "Số điện thoại chưa đúng định dạng (0xxxxxxxxx).")
//    @NotBlank(message = "Số điện thoại không được để trống.")
//    @Column(name = "phone", nullable = false, unique = true)
//    private String phone;
}
