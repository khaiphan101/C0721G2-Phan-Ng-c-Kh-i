package caseStudy_furamaResort.services;

import caseStudy_furamaResort.models.Customer;

import java.util.LinkedList;

public interface CustomerService extends Service{
    void edit(int object);
    LinkedList<Customer> readFile(String filePath);
    void writeFile(Customer customer, String filePath);
}
