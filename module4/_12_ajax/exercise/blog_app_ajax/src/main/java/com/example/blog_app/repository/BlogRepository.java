package com.example.blog_app.repository;

import com.example.blog_app.model.Blog;
import com.example.blog_app.model.ECommerce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllBlogByAuthorContaining(String author, Pageable pageable);

    @Query(value = "select * from blog b join ecommerce c where b.e_commerce_id = c.id and c.id = :id", nativeQuery = true)
    Page<Blog> findAllBlogByECommerceId(int id, Pageable pageable);

    List<Blog> findAllBlogByAuthorContaining(String name);

}
