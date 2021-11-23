package com.example.blog_app.controller;


import com.example.blog_app.model.Blog;
import com.example.blog_app.repository.ECommerceRepository;
import com.example.blog_app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    ECommerceRepository eCommerceRepository;

    @GetMapping("")
    //optional khong bi null pointerexception, thuong dung cho research
    public String displayBlog(Optional<String> author, Optional<Integer> ecomId,
                              Model model,
                              @PageableDefault(size = 5) Pageable pageable
    ) {
//        neu input author khong duoc nhap thi thuc thi if
        if (!author.isPresent()) {
//            neu author ko nhap ma ecom nhap thi thuc thi if
            if (ecomId.isPresent()) {
                model.addAttribute("blogs", blogService.findAllBlogByECommerceId(ecomId.get(), pageable));
                model.addAttribute("ecomId", ecomId.get());
            }else {
                model.addAttribute("blogs", blogService.findAllBlog(pageable));
            }
        } else {
            model.addAttribute("blogs", blogService.findAllBlogByAuthorContaining(author.get(), pageable));
        }

//        test cac method
//        Page<Blog> blogs = blogService.findAllBlogByECommerceId(1,pageable);
            model.addAttribute("listBlog", blogService.findAll());
            model.addAttribute("ecommerces", eCommerceRepository.findAll());
        return "list";
    }
}
