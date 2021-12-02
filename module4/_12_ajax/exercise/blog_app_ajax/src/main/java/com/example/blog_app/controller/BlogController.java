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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
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


    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<Blog> customer = blogService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("blog", customer.get());
            modelAndView.addObject("ecommerces", eCommerceRepository.findAll());

            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:";
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Blog> blog = blogService.findById(id);

        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/search/{name}")
    public String searchBlog(@PathVariable("name") String name,
                             Model model) {
        List<Blog>  searchList =  blogService.findAllBlogByAuthorContaining(name);
        System.out.println(searchList);
        model.addAttribute("blogs", searchList);
        model.addAttribute("name", name);
        return "search";
    }
}
