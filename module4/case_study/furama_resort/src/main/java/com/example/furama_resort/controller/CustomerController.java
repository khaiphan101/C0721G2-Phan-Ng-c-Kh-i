package com.example.furama_resort.controller;


import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    //    @Autowired
//    ICustomerTypeService customerTypeService;
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("customers", iCustomerService.findAll());
        return "/customer/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        Optional<Customer> customer = iCustomerService.findById(id);
        iCustomerService.deleteById(customer.get().getId());
        return "redirect:/customer";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/create";
        } else {
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Create successfully");
            return "redirect:/customer";
        }
    }
}
