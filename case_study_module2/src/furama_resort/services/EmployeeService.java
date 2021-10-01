package furama_resort.services;

import furama_resort.models.Employee;

import java.util.ArrayList;

public interface EmployeeService extends Service {

    void edit(int object);

    ArrayList<Employee> readFile(String filePath);

    void writeFile(Employee employee, String filePath);
}
