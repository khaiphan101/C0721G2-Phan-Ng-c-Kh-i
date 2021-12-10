package com.example.furama_resort.model.customer;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Pattern(regexp = "KH-[0-9]{4}", message = "Wrong format! Please input again!")
    private  String id;

    @ManyToOne(targetEntity = CustomerType.class)
    @NotNull(message = "Customer Type is not empty")
    private CustomerType customerType;
    @NotBlank
    private String name;

    @NotEmpty(message = "Birthday is not empty")
    private String birthDay;

    @NotNull(message = "Please select a gender")
    private Boolean gender;

    @Pattern(regexp = "[0-9]{9}|[09]{12}", message = "Wrong format! please input like the pattern!")
    private String idCard;

    @Pattern(regexp = "^(09|\\(84\\)+9)[01]\\d{7}$", message = "Wrong format! please input like the pattern!")
    private String phone;

    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-z]+.[a-z]+$", message = "Wrong format! please input like the pattern!")
    private String email;
    @NotBlank(message = "Please input address")
    private String address;
    public Customer() {
    }

    public Customer(@Pattern(regexp = "KH-[0-9]{4}", message = "Wrong format! Please input again!") String id,
                    @NotNull(message = "Customer Type is not empty") CustomerType customerType, @NotBlank String name,
                    @NotEmpty(message = "Birthday is not empty") String birthDay, @NotNull(message = "Please select a gender") Boolean gender,
                    @Pattern(regexp = "[0-9]{9}|[09]{12}", message = "Wrong format! please input like the pattern!") String idCard,
                    @Pattern(regexp = "^(09|\\(84\\)+9)[01]\\d{7}$", message = "Wrong format! please input like the pattern!") String phone,
                    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-z]+.[a-z]+$",
            message = "Wrong format! please input like the pattern!") String email, @NotBlank(message = "Please input address") String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
