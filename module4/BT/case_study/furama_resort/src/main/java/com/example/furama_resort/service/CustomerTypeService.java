package com.example.furama_resort.service;

import com.example.furama_resort.model.customer.CustomerType;
import com.example.furama_resort.repository.customer.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
