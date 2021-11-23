package com.example.blog_app.service;

import com.example.blog_app.model.Blog;
import com.example.blog_app.repository.BlogRepository;
import com.example.blog_app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        //baso orelse ddeer không bị nullpointer( nếu ko null thì ko sao, nếu null sẽ bị)
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllBlogByAuthorContaining(String name, Pageable pageable) {
        return blogRepository.findAllBlogByAuthorContaining(name, pageable);
    }

    @Override
    public Page<Blog> findAllBlogByECommerceId(int id, Pageable pageable) {
        return blogRepository.findAllBlogByECommerceId(id, pageable);
    }
}
