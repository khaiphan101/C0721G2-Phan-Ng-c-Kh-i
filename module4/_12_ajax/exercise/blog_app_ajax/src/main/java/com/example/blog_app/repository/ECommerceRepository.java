package com.example.blog_app.repository;

import com.example.blog_app.model.Blog;
import com.example.blog_app.model.ECommerce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ECommerceRepository extends JpaRepository<ECommerce, Integer> {

}
