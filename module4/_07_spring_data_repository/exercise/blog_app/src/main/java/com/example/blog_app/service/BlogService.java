package com.example.blog_app.service;

import com.example.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    Page<Blog> findAllBlog(Pageable pageable);

    Page<Blog> findAllBlogByAuthorContaining(String name, Pageable pageable);


    Page<Blog> findAllBlogByECommerceId(@Param("id") int id, Pageable pageable);

}
