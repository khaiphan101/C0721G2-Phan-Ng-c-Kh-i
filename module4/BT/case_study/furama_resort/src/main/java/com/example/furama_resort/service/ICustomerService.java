package com.example.furama_resort.service;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ICustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(String id);

    void deleteById(String id);

    void save(Customer customer);
//
//    List<Customer> findAllCustomerByCustomerTypeId(int id);
//
//    List<Customer> findAllCustomerByNameContaining(String name);
//
//
//
//    List<Customer> findAllByCustomerType(Integer integer);

//    List<Customer> search(String s);

    Page<Customer> findAll(Pageable pageable);
//    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
    Page<Customer> findAllByCustomerType(Integer id, Pageable pageable);
    Page<Customer> search(String keyword,Pageable pageable);

//    Page<Customer> findAllCustomer(Pageable pageable);

}
