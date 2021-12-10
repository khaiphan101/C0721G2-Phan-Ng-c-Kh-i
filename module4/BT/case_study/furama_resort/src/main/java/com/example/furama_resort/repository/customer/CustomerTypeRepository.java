package com.example.furama_resort.repository.customer;

import com.example.furama_resort.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
