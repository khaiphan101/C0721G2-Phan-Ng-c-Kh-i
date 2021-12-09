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
//    public List<Customer> findAllCustomerByCustomerTypeId(int id) {
//        return null;
//    }

//    @Override
//    public List<Customer> findAllCustomerByCustomerTypeId(int id) {
//        return customerRepository.findAllCustomerByCustomerTypeId(id);
//    }

//    @Override
//    public List<Customer> findAllCustomerByNameContaining(String name) {
//        return customerRepository.findAllCustomerByNameContaining(name);
//    }
//
//    @Override
//    public List<Customer> findAllByCustomerType(Integer integer) {
//        return customerRepository.findAllByCsutomerType(integer);
//    }
//
//    @Override
//    public List<Customer> search(String keyword) {
//        return customerRepository.search(keyword);
//    }

//    @Override
//    public Page<Customer> findAllCustomer(Pageable pageable) {
//        return customerRepository.findAll(pageable);
//    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

//    @Override
//    public Page<Customer> findAllByNameContaining(String name, Pageable pageable) {
//        return customerRepository.findAllByCustomerNameContaining(name, pageable);
//    }

    @Override
    public Page<Customer> findAllByCustomerType(Integer id, Pageable pageable) {
        return customerRepository.findCustomersByCustomerType(id,pageable);
    }


    @Override
    public Page<Customer> search(String keyword, Pageable pageable) {
        return customerRepository.search(keyword,pageable);
    }
}
