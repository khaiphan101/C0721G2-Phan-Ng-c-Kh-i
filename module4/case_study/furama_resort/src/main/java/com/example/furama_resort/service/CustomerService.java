package com.example.furama_resort.service;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional< Customer > findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

//    @Override
//    public Page<Customer> findAllCustomer(Pageable pageable) {
//        return customerRepository.findAll(pageable);
//    }
}
