package com.example.furama_resort.controller;


import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.model.customer.CustomerType;
import com.example.furama_resort.service.ICustomerService;
import com.example.furama_resort.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService icustomerTypeService;

    @ModelAttribute("customerTypeList")
    public Iterable<CustomerType> customerTypeList(Model model) {
        return icustomerTypeService.findAll();
    }

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

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable String id, Model model) {
        Optional<Customer> customer = iCustomerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/edit";
        } else {
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Edit customer successfully");
            return "redirect:/customer";
        }
    }

    //
//    @PostMapping("/search")
//    //optional khong bi null pointerexception, thuong dung cho research
//    public String display(Optional<Integer> customerTypeId, Model model) {
////        neu input author khong duoc nhap thi thuc thi if
//            if (customerTypeId.isPresent()) {
//                List<Customer> customers = iCustomerService.findAllByCustomerTypeId(customerTypeId.get());
//                model.addAttribute("customers", customers);
//                model.addAttribute("customerTypeId", customerTypeId.get());
//            }else {
//                model.addAttribute("customers", iCustomerService.findAll());
//            }
//        return "customer/customer";
//    }
//    @GetMapping(value = "")
//    public String getListPageCustomer(Model model, @RequestParam("keyword") Optional<String> keyword,
//                                      @RequestParam("cusType") Optional<Integer> cusType) {
//        if (!keyword.isPresent() || keyword.get().equals("")) {
//            if (cusType.isPresent()) {
//                model.addAttribute("customerList", iCustomerService.findAllByCustomerType(cusType.get()));
//                model.addAttribute("cusType", cusType.get());
//            } else {
//                model.addAttribute("customerList", iCustomerService.findAll());
//            }
//        } else {
//            model.addAttribute("customerList", iCustomerService.search(keyword.get()));
//            model.addAttribute("keyword", keyword);
//        }
//        return "customer/list";
//    }

//    @GetMapping(value = "")
//    public String getListPageCustomer(Model model,@PageableDefault(size = 5) Pageable pageable,
//                                      @RequestParam ("keyword") Optional<String> keyword,
//                                      @RequestParam ("cusType") Optional<Integer> cusType){
//        if (!keyword.isPresent()||keyword.get().equals("")){
//            if (cusType.isPresent()){
//                model.addAttribute("customerList",iCustomerService.findAllByCustomerType(cusType.get(),pageable));
//                model.addAttribute("cusType",cusType.get());
//            }else {
//                model.addAttribute("customerList",iCustomerService.findAll(pageable));
//            }
//        } else {
//            model.addAttribute("customerList",iCustomerService.search(keyword.get(),pageable));
//            model.addAttribute("keyword",keyword);
//        }
//        return "customer/list";
//    }

}
