package caseStudy_furamaResort.services;

import caseStudy_furamaResort.models.Employee;

import java.util.ArrayList;

public interface EmployeeService extends Service{
    void edit(int object);
    ArrayList<Employee> readFile(String filePath);
    void writeFile(Employee employee, String filePath);
}
