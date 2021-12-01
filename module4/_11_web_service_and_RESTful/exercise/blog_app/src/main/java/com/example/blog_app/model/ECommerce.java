package com.example.blog_app.model;

import javax.persistence.*;
import java.util.List;
@Entity(name = "ecommerce")
public class ECommerce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
   
    @OneToMany(targetEntity = Blog.class, mappedBy = "eCommerce")
    List<Blog> blogs;

    public ECommerce() {
    }

    public ECommerce(int id, String name) {
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
}
