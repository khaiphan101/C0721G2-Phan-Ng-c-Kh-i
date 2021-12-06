package com.example.furama_resort.controller;


import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    //    @Autowired
//    ICustomerTypeService customerTypeService;
    @GetMapping
    public String showListCustomer(Model model) {
        model.addAttribute("customers", iCustomerService.findAll());
        return "/customer/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        Optional<Customer> customer = iCustomerService.findById(id);
        iCustomerService.deleteById(customer.get().getId());
        return "redirect:/customer";
    }
}
