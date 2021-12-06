//package com.example.furama_resort.service;
//
//import com.example.blog_app.model.Blog;
//import com.example.blog_app.repository.BlogRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BlogServiceImpl implements BlogService{
//    @Autowired
//    BlogRepository blogRepository;
//    @Override
//    public List<Blog> findAll() {
//        return blogRepository.findAll();
//    }
//
//    @Override
//    public Optional<Blog> findById(int id) {
//        //baso orelse ddeer không bị nullpointer( nếu ko null thì ko sao, nếu null sẽ bị)
//        return blogRepository.findById(id);
//    }
//
//    @Override
//    public Page<Blog> findAllBlog(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }
//
//    @Override
//    public Page<Blog> findAllBlogByAuthorContaining(String name, Pageable pageable) {
//        return blogRepository.findAllBlogByAuthorContaining(name, pageable);
//    }
//
//    @Override
//    public Page<Blog> findAllBlogByECommerceId(int id, Pageable pageable) {
//        return blogRepository.findAllBlogByECommerceId(id, pageable);
//    }
//
//    @Override
//    public void remove(Integer id) {
//        blogRepository.deleteById(id);
//    }
//
//    @Override
//    public void save(Blog blog) {
//        blogRepository.save(blog);
//    }
//
//    @Override
//    public List<Blog> findAllBlogByAuthorContaining(String name) {
//        return blogRepository.findAllBlogByAuthorContaining(name);
//    }
//}
