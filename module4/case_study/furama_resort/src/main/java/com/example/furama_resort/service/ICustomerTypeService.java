package com.example.furama_resort.service;

import com.example.furama_resort.model.customer.CustomerType;

public interface ICustomerTypeService {
    Iterable<CustomerType> findAll();
}
